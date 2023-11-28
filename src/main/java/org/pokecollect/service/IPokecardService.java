package org.pokecollect.service;

import org.pokecollect.dto.Pokecard;
import org.pokecollect.dto.SecurityUser;

import java.io.IOException;
import java.net.http.HttpResponse;
import java.util.List;

/**
 * The interface defining the service methods for managing Pokecards. These methods provide functionality for
 * fetching, saving, deleting, and querying Pokecards, as well as fetching a list of all available Pokecards.
 */
public interface IPokecardService {

    /**
     * Fetches a Pokecard by its unique ID.
     *
     * @param id The unique identifier of the Pokecard to be fetched.
     * @return The fetched Pokecard, or null if it does not exist.
     */
    Pokecard fetchByID(String id);

    /**
     * Retrieves a Pokecard by its name.
     *
     * @param cardName The name of the Pokecard to be retrieved.
     * @return The Pokecard with the specified name, or null if not found.
     */
    Pokecard getPokecardsByName(String cardName);

    /**
     * Retrieves a list of Pokecards based on their types.
     *
     * @param cardType The types of Pokecards to be retrieved.
     * @return A list of Pokecards matching the specified types.
     */
    Pokecard getPokecardsByType(List<String> cardType);

    /**
     * Queries an external API for Pokecards by name.
     *
     * @param userInput The name or query string to search for Pokecards in an external API.
     * @return An HTTP response containing the API query results.
     * @throws IOException If there is an issue with the HTTP request.
     * @throws InterruptedException If the HTTP request is interrupted.
     */
    HttpResponse<String> queryAPIByName(String userInput) throws IOException, InterruptedException;


    Pokecard save(Pokecard pokecard) throws Exception;

    //public void delete(int id);

    List<Pokecard> fetchAll();

    void addPokecardToCollection(String username, Pokecard card);

    List<Pokecard> getUserPokecardCollection(SecurityUser securityUser);
}