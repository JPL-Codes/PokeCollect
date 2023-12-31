package org.pokecollect;

import jakarta.validation.Valid;
import org.pokecollect.dao.UserRepository;
import org.pokecollect.dto.Pokecard;
import org.pokecollect.dto.SecurityUser;
import org.pokecollect.dto.User;
import org.pokecollect.service.IPokecardService;
import org.pokecollect.service.JpaUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.net.http.HttpResponse;
import java.security.Principal;
import java.util.List;
import java.util.Optional;

/**
 * A Spring Boot controller for handling Pokecard-related web requests and interactions.
 */
@Controller
@SessionAttributes("myObject")
public class CardController {


    @Autowired
    IPokecardService pokecardService;

    private final UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public CardController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    /**
     * Listens for a connection to the root (/) endpoint and returns the start page.
     *
     * @param myObject Model attribute used to contain JSON data returned from the API.
     * @return The start page.
     */
    @RequestMapping("/")
    public String index(@ModelAttribute String myObject) {
        return "start";
    }

    @RequestMapping("/login")
    public String login(@ModelAttribute String myObject) {
        return "login";
    }

    @RequestMapping("/collection")
    public String collection(Model model, @ModelAttribute String myObject) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        if (authentication != null) {
            SecurityUser securityUser = (SecurityUser) authentication.getPrincipal();
            Optional<User> optionalUser = userRepository.findByUsername(securityUser.getUsername());

            if (optionalUser.isPresent()) {
                User user = optionalUser.get();
                model.addAttribute("user", user);
                List<Pokecard> pokecardCollection = pokecardService.getUserPokecardCollection(securityUser);
                model.addAttribute("userCollection", pokecardCollection);
            }
        }
        return "collection";
    }

    @PostMapping("/collection/deletePokecard")
    public String deletePokecard(@RequestParam int pokecardId, Model model) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        if (authentication != null) {
            SecurityUser securityUser = (SecurityUser) authentication.getPrincipal();
            try {
                pokecardService.deletePokecard(securityUser, pokecardId);
                return "redirect:/collection";
            } catch (Exception e) {
                //TODO add logging
            }
        }
        return "redirect:/collection";
    }

    /**
     * GET endpoint listens for user search request and returns results page
     * @param model
     * @param inputReceived variable passed from navigation search box. Used to find desired pokecard.
     * @param myObject model attribute to contain JSON returned from API. Used by results.html to build
     *                 datatable.
     * @return JSON data from API, results.html
     * @throws IOException
     * @throws InterruptedException
     */
    @GetMapping(value = "/results")
   // @PreAuthorize("hasRole('ROLE_USER')")
    public String results(ModelMap model, @RequestParam(value = "userInput") String inputReceived, @ModelAttribute String myObject) throws IOException, InterruptedException {
        HttpResponse<String> data = pokecardService.queryAPIByName(inputReceived);
        model.addAttribute("myObject", data.body());
        return "results";
    }

    /**
     * Void POST endpoint used to add card to user collection via button click.
     *     AJAX request caller will display success or failure to user on the html page based on results
     * @param card POJO built with javascript. Passed from results.html when the user clicks the 'Add' button
     */
    @PreAuthorize("hasRole('ROLE_USER')")
    @PostMapping(value = "/results")
    public void addPokecardViaAjax(@RequestBody Pokecard card, Principal principal) {
        String username = principal.getName();
        try {
            pokecardService.addPokecardToCollection(username, card);
        } catch (Exception e){
            //TODO add logging
        }
    }


    @GetMapping("/pokecard")
    @ResponseBody
    public List<Pokecard> fetchAllPokecards() {
        return pokecardService.fetchAll();
    }

    @GetMapping("/pokecard/{id}/")
    public ResponseEntity getPokecardById(@PathVariable("id") String id) {
        Pokecard foundPokecard = pokecardService.fetchByID(id);
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        return new ResponseEntity(foundPokecard, headers, HttpStatus.OK);
    }

    @PostMapping(value="/pokecard", consumes = "application/json", produces = "application/json")
    public Pokecard createPokecard(@RequestBody Pokecard card) {
        Pokecard newPokecard = null;
        try {
            card = pokecardService.save(card);
        } catch (Exception e){
            //TODO add logging
        }
        return card;
    }

    @GetMapping("/registration")
    public String registration(Model theModel){
        User user = new User();
        theModel.addAttribute("user", user);
        return "/registration";
    }

    @PostMapping("/registration")
    public String saveUser(@ModelAttribute("user") @Valid User theUser, BindingResult bindingResult){
        if (bindingResult.hasErrors()) { return "/registration"; }
        try {
            Optional<User> existingUser = userRepository.findByUsername(theUser.getUsername());
            if (existingUser.isPresent()) { return "/usernameError"; }
        }
        catch(Exception e) {
            return "/usernameError";
        }
        theUser.setRoles("ROLE_USER");
        theUser.setPassword(passwordEncoder.encode(theUser.getPassword()));
        userRepository.save(theUser);
        return "redirect:/login";
    }
}
