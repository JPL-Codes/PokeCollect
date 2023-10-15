package org.pokecollect.service;

import org.pokecollect.dao.IPokecardDAO;
import org.pokecollect.dto.Pokecard;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;

import static org.apache.logging.log4j.message.MapMessage.MapFormat.JSON;

@Service
public class PokecardServiceStub implements IPokecardService {

    @Value("${apikey}")
    public String apikey;

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

    @Override
    public HttpResponse<String> queryAPIByName(String userInput) throws IOException, InterruptedException {

        // create a client
        var client = HttpClient.newHttpClient();


        // create a request
        var request = HttpRequest.newBuilder(
                        URI.create("https://api.pokemontcg.io/v2/cards?q=name:" + userInput))
                .header("accept", "application/json")
                // API KEY REQUIRED - Put your API key in the line below
                .header("X-Api-Key", apikey)
                .build();

        // use the client to send the request and capture response
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        return response;
    }
}
