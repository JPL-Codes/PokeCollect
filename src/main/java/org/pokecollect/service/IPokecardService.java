package org.pokecollect.service;

import org.pokecollect.dto.Pokecard;

import java.io.IOException;
import java.net.http.HttpResponse;
import java.util.List;

public interface IPokecardService {
    /**
     * Fetch a pokecard with a given ID.
     * @param id a unique identifier for a pokecard.
     * @return the matching pokecard, or null if no matches found.
     * */
    Pokecard fetchByID(String id);

    /**
     * Get pokecards with name matching user input.
     * @param cardName the name of the pokecard that the user is looking for.
     * @return a list of matching pokecards, or null if no matches found.
     */
    Pokecard getPokecardsByName(String cardName);

    /**
     * Get pokecards with name matching user input.
     * @param cardType the type of the pokecard that the user is looking for.
     * @return a list of matching pokecards, or null if no matches found.
     */
    Pokecard getPokecardsByType(List<String> cardType);

    /**
     *
     * @param userInput
     * @return
     * @throws IOException
     * @throws InterruptedException
     */
    HttpResponse<String> queryAPIByName(String userInput) throws IOException, InterruptedException;


    Pokecard save(Pokecard pokecard) throws Exception;

    List<Pokecard> fetchAll();

    void delete(int id) throws Exception;
}