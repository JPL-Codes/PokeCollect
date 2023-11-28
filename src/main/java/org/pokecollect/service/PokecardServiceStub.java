package org.pokecollect.service;

import org.pokecollect.dao.IPokecardDAO;
import org.pokecollect.dao.PokecardRepository;
import org.pokecollect.dao.UserRepository;
import org.pokecollect.dto.Pokecard;
import org.pokecollect.dto.SecurityUser;
import org.pokecollect.dto.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;
import java.util.Optional;

/**
 * A stub implementation of the {@link IPokecardService} interface for managing Pokecards.
 */
@Service
public class PokecardServiceStub implements IPokecardService {

    @Value("${apikey}")
    public String apikey;

    @Autowired
    public IPokecardDAO pokecardDAO;

    @Autowired
    private PokecardRepository pokecardRepository;

    @Autowired
    private UserRepository userRepository;

    public PokecardServiceStub(){

    }

    public PokecardServiceStub(IPokecardDAO pokecardDAO) {

        this.pokecardDAO = pokecardDAO;
    }

    /**
     * Fetches a pokecard by its unique ID.
     *
     * @param id A unique identifier for a pokecard.
     * @return The matching pokecard, or null if no matches are found.
     */
    //TODO implement live operations
    @Override
    public Pokecard fetchByID(String id) {
        Pokecard pokecard = new Pokecard();
        pokecard.setId("83");
        return pokecard;
    }

    /**
     * Retrieves pokecards with names matching user input.
     *
     * @param cardName The name of the pokecard that the user is looking for.
     * @return A list of matching pokecards, or null if no matches are found.
     */
    //TODO implement live operations
    @Override
    public Pokecard getPokecardsByName(String cardName) {
        Pokecard pokecard = new Pokecard();
        pokecard.setName(cardName);
        return pokecard;
    }

    /**
     * Retrieves pokecards with types matching user input.
     *
     * @param cardType The type of the pokecard that the user is looking for.
     * @return A list of matching pokecards, or null if no matches are found.
     */
    //TODO implement live operations
    @Override
    public Pokecard getPokecardsByType(List<String> cardType) {
        Pokecard pokecard = new Pokecard();
        pokecard.setTypes(cardType);
        return pokecard;
    }

    /**
     * Gets matching card JSON data from an external API using the user's input as the name search parameter.
     *
     * @param userInput The text the user entered for the search.
     * @return Matching card data in JSON format.
     * @throws IOException If there is an issue with the HTTP request.
     * @throws InterruptedException If the HTTP request is interrupted.
     */
    @Override
    public HttpResponse<String> queryAPIByName(String userInput) throws IOException, InterruptedException {

        // create a client
        var client = HttpClient.newHttpClient();
        // create a request
        var request = HttpRequest.newBuilder(
                URI.create("https://api.pokemontcg.io/v2/cards?q=name:" + userInput))
                    .header("accept", "application/json")
                    .header("X-Api-Key", apikey)
                    .build();
        // use the client to send the request and capture response
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());


        return response;
    }

    @Override
    public void addPokecardToCollection(String username, Pokecard card) {

        Optional<User> userOptional = userRepository.findByUsername(username);
        if (userOptional.isPresent()) {
            User user = userOptional.get();
            user.getPokecardCollection().add(card);
            userRepository.save(user);

            pokecardRepository.save(card);
        }
    }

    @Override
    public List<Pokecard> getUserPokecardCollection(SecurityUser securityUser) {
        Long id = securityUser.getId();
        return userRepository.findPokecardCollectionByUserId(id);
    }


    @Override
    public Pokecard save(Pokecard pokecard) throws Exception {
        return pokecardDAO.save(pokecard);
    }

    @Override
    public void deletePokecard(SecurityUser securityUser,int pokecardId) {

        Optional<User> optionalUser = userRepository.findByUsername(securityUser.getUsername());

        if (optionalUser.isPresent()) {
            // user found.
            User user = optionalUser.get();
            user.getPokecardCollection().removeIf(Pokecard -> Pokecard.getPokecardId() == pokecardId);
            userRepository.save(user);
        }
    }

    @Override
    public List<Pokecard> fetchAll() {
        return pokecardDAO.fetchAll();
    }

}
