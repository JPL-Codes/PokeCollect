package org.pokecollect;

import org.pokecollect.dto.Pokecard;
import org.pokecollect.service.IPokecardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//testing spring annotations to ensure successful import
@Controller
public class CardController {

    @Autowired
    IPokecardService pokecardService;
    /**
     * Listens for a connection to root (/) endpoint
     * @return start page
     */
    @RequestMapping("/")
    public String index() {
        return "start";
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
