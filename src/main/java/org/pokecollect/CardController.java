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

    @GetMapping(value = "/results")
    public String results(ModelMap model, @RequestParam(value = "userInput") String inputReceived, @ModelAttribute String myObject) throws IOException, InterruptedException {
        HttpResponse<String> data = pokecardService.queryAPIByName(inputReceived);
        /*if (model.getAttribute("myObject") == null) {
            model.addAttribute("myObject", data.body());
        } else {
            model.getAttribute("myObject") = null;
        }*/
        model.addAttribute("myObject", data.body());
        return "results";
    }

    @GetMapping("/pokecard")
    @ResponseBody
    public List<Pokecard> fetchAllPokecards() {
        return pokecardService.fetchAll();
    }

    @GetMapping("/pokecard/{id}/")
    public ResponseEntity getPokecardById(@PathVariable("id") String id) {
        Pokecard foundPokecard = pokecardService.fetchByID(Integer.parseInt(id));
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
