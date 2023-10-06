package org.pokecollect;

import org.junit.jupiter.api.Test;
import org.pokecollect.dto.Pokecard;
import org.pokecollect.service.IPokecardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import java.util.Arrays;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class EnterpriseApplicationTests {

    @Autowired
    private IPokecardService pokecardService;
    private Pokecard pokecard;

    @Test
    void contextLoads() {
    }

    @Test
    void fetchPokemonCardByID_returnPokemonCard() {
        givenDataAreAvailable();
        whenSearchForPokemonCardWithID83();
        thenReturnPokemonCardWithID83();
    }

    private void givenDataAreAvailable() {
    }

    private void whenSearchForPokemonCardWithID83() {
        pokecard = pokecardService.fetchByID(83);
    }

    private void thenReturnPokemonCardWithID83() {
        int id = pokecard.getId();
        assertEquals(83, id);
    }


    @Test
    void fetchPokecardsByName_returnAllPokecardsNamedCharizard() {
        givenSearchFieldIsAvailable();
        whenTheUserSearchesCharizard();
        thenReturnPokecardsNamedCharizard();
    }

    private void givenSearchFieldIsAvailable() {
    }

    private void whenTheUserSearchesCharizard() {
        pokecard = pokecardService.getPokecardsByName("Charizard");
    }

    private void thenReturnPokecardsNamedCharizard() {
        String name = pokecard.getName();
        assertEquals("Charizard", name);
    }


    @Test
    void fetchPokecardsByType_returnAllWaterTypePokecards() {
        givenSearchFieldIsAvailable();
        whenTheUserSearchesWaterType();
        thenReturnAllWaterTypePokecards();
    }

    private void whenTheUserSearchesWaterType() {
        List<String> typeDesired = Arrays.asList("Water");
        pokecard = pokecardService.getPokecardsByType(typeDesired);
    }

    private void thenReturnAllWaterTypePokecards() {
        List<String> types = pokecard.getTypes();
        if (types.size() == 2) {
            assert (types.get(0).equals("Water") || types.get(1).equals("Water"));
        } else {
            assert types.get(0).equals("Water");
        }
    }


}
