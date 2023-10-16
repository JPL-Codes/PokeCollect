package org.pokecollect;

import org.pokecollect.dto.Pokecard;
import org.pokecollect.service.IPokecardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.net.http.HttpResponse;
import java.util.List;

@Controller
@SessionAttributes("myObject")
public class CardController {

    @Autowired
    IPokecardService pokecardService;
    /**
     * Listens for a connection to root (/) endpoint
     * @return start page
     */
    @RequestMapping("/")
    public String index(@ModelAttribute String myObject) {
        return "start";
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
    @PostMapping(value = "/results")

    public void addPokecardViaAjax(@RequestBody Pokecard card) {
        //TODO - this method successfully receives a card object from results.html.
        //      Need to add: interface, service, a User & Collection dto, and a database for persistence
        //      and to complete the CRUD operation
        System.out.println(card);

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

    @DeleteMapping("/pokecard/{id}/")
    public ResponseEntity deletePokecard(@PathVariable("id") String id) {
        try {
            pokecardService.delete(Integer.parseInt(id));
            return new ResponseEntity(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
