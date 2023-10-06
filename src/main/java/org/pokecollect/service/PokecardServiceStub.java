package org.pokecollect.service;

import org.pokecollect.dto.Pokecard;
import org.springframework.stereotype.Component;
import java.util.List;

@Component
public class PokecardServiceStub implements IPokecardService {

    @Override
    public Pokecard fetchByID(int id) {
        Pokecard pokecard = new Pokecard();
        pokecard.setId(83);
        return pokecard;
    }

    @Override
    public Pokecard getPokecardsByName(String cardName) {
        Pokecard pokecard = new Pokecard();
        pokecard.setName(cardName);
        return pokecard;
    }

    @Override
    public Pokecard getPokecardsByType(List<String> cardType) {
        Pokecard pokecard = new Pokecard();
        pokecard.setTypes(cardType);
        return pokecard;
    }
}
