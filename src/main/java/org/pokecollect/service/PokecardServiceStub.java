package org.pokecollect.service;

import org.pokecollect.dao.IPokecardDAO;
import org.pokecollect.dto.Pokecard;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PokecardServiceStub implements IPokecardService {

    @Autowired
    public IPokecardDAO pokecardDAO;

    public PokecardServiceStub(){

    }

    public PokecardServiceStub(IPokecardDAO pokecardDAO) {

        this.pokecardDAO = pokecardDAO;
    }

    @Override
    public Pokecard fetchByID(int id) {
        Pokecard pokecard = pokecardDAO.fetch(id);
        return pokecard;
    }

    @Override
    public void delete(int id) throws Exception {
        pokecardDAO.delete(id);
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

    @Override
    public Pokecard save(Pokecard pokecard) throws Exception {
        return pokecardDAO.save(pokecard);
    }

    @Override
    public List<Pokecard> fetchAll() {
        return pokecardDAO.fetchAll();
    }
}
