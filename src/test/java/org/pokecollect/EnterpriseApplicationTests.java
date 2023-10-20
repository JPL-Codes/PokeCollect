package org.pokecollect;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.pokecollect.dao.IPokecardDAO;
import org.pokecollect.dto.Pokecard;
import org.pokecollect.service.IPokecardService;
import org.pokecollect.service.PokecardServiceStub;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Arrays;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.verify;

@SpringBootTest
class EnterpriseApplicationTests {

    @Autowired
    private IPokecardService pokecardService;
    private Pokecard pokecard = new Pokecard();

    @MockBean
    private IPokecardDAO pokecardDAO;

    @Test
    void contextLoads() {
    }

    @Test
    void fetchPokemonCardByID_returnPokemonCard() throws Exception {
        givenDataAreAvailable();
        whenSearchForPokemonCardWithID83();
        thenReturnPokemonCardWithID83();
    }

    private void givenDataAreAvailable() throws Exception{
        Mockito.when(pokecardDAO.save(pokecard)).thenReturn(pokecard);
        pokecardService = new PokecardServiceStub(pokecardDAO);
    }

    private void whenSearchForPokemonCardWithID83() {

        pokecard = pokecardService.fetchByID("83");
    }

    private void thenReturnPokemonCardWithID83() {
        String id = pokecard.getId();
        assertEquals("83", id);
    }


    @Test
    void fetchPokecardsByName_returnAllPokecardsNamedCharizard() throws Exception {
        givenSearchFieldIsAvailable();
        whenTheUserSearchesCharizard();
        thenReturnPokecardsNamedCharizard();
    }

    private void givenSearchFieldIsAvailable() throws Exception {
        Mockito.when(pokecardDAO.save(pokecard)).thenReturn(pokecard);
        pokecardService = new PokecardServiceStub(pokecardDAO);
    }

    private void whenTheUserSearchesCharizard() {

        pokecard = pokecardService.getPokecardsByName("Charizard");
    }

    private void thenReturnPokecardsNamedCharizard() {
        String name = pokecard.getName();
        assertEquals("Charizard", name);
    }


    @Test
    void fetchPokecardsByType_returnAllWaterTypePokecards() throws Exception {
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

    @Test
    void savePokecard_validateReturnPokecardWithIdAndNameAndLevelAndHpAndType() throws Exception {
        givenDataAreAvailable();
        whenTheUserSearchesNewPokemonAndSaves();
        thenCreateNewPokecardRecordAndReturnIt();
    }

    private void whenTheUserSearchesNewPokemonAndSaves() {
        pokecard.setId("5");
        pokecard.setName(null);
        pokecard.setLevel(null);
        pokecard.setHp(null);
        pokecard.setTypes(null);
    }

    private void thenCreateNewPokecardRecordAndReturnIt() throws Exception {
        Pokecard searchedPokecard = pokecardService.save(pokecard);
        assertEquals("5", pokecard.getId());
        verify(pokecardDAO, atLeastOnce()).save(pokecard);
    }

}
