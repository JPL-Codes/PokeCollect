package org.pokecollect;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.client.RestTemplate;

@Controller
public class ExploreController {

    private static final String POKEAPI_URL = "https://pokeapi.co/api/v2/pokemon?limit=100";

    @GetMapping("/explore")
    public String explorePokemons(Model model) {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<PokeAPIResponse> response = restTemplate.getForEntity(POKEAPI_URL, PokeAPIResponse.class);

        if (response.getStatusCode().is2xxSuccessful()) {
            model.addAttribute("pokemons", response.getBody().getResults());
        }

        return "explore";
    }

    // You would also need a DTO for the response structure
    public static class PokeAPIResponse {
        private List<Pokemon> results;

        // Getter, Setter and possibly other fields based on API structure

        public static class Pokemon {
            private String name;
            private String url;

            // Getter, Setter
        }

        public Object getResults() {
            return null;
        }
    }
}
