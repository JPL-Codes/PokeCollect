package org.pokecollect;

import org.pokecollect.dto.Pokecard;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

//testing spring annotations to ensure successful import
@Controller
public class CardController {

    /**
     * Listens for a connection to root (/) endpoint
     * @return start page
     */
    @RequestMapping("/")
    public String index() {
        return "start";
    }

    @GetMapping("/pokecard")
    public ResponseEntity getAllPokecards() {
        return new ResponseEntity(HttpStatus.OK);
    }

    @GetMapping("/pokecard/{id}/")
    public ResponseEntity getPokecardById(@PathVariable("id") String id) {
        return new ResponseEntity(HttpStatus.OK);
    }

    @PostMapping(value="/pokecard", consumes = "application/json", produces = "application/json")
    public Pokecard createPokecard(@RequestBody Pokecard card) {
        return card;
    }

    @DeleteMapping("/pokecard/{id}/")
    public ResponseEntity deletePokecard(@PathVariable("id") String id) {
        return new ResponseEntity(HttpStatus.OK);
    }
}
