package org.pokecollect;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class EnterpriseApplicationTests {

    @Test
    void contextLoads() {
    }

    @Test
    void fetchPokemonCardsNamedCharizard_returnPokemonCardsNamedCharizard() {
        givenSearchFieldIsAvailable();
        whenTheUserEntersCharizardAndClicksTheSearchButton();
        thenReturnPokemonCardsNamedCharizard();
    }

    private void givenSearchFieldIsAvailable() {
    }

    private void whenTheUserEntersCharizardAndClicksTheSearchButton() {
    }

    private void thenReturnPokemonCardsNamedCharizard() {
    }

}
