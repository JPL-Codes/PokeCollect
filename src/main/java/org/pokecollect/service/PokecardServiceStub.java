package org.pokecollect.service;

import org.pokecollect.dto.Pokecard;
import org.springframework.stereotype.Component;

@Component
public class PokecardServiceStub implements IPokecardService {
    @Override
    public Pokecard fetchByID(int id) {
        Pokecard pokecard = new Pokecard();
        pokecard.setId(83);
        return pokecard;
    }
}
