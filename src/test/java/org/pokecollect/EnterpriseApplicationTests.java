package org.pokecollect;

import org.junit.jupiter.api.Test;
import org.pokecollect.dto.Pokecard;
import org.pokecollect.service.IPokecardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class EnterpriseApplicationTests {

    @Autowired
    private IPokecardService pokecardService;
    private Pokecard pokecard;
    private ArrayList<Pokecard> pokecardList;

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

}
