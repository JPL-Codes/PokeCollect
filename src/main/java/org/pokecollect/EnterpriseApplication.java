package org.pokecollect;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

@SpringBootApplication
public class EnterpriseApplication {

    public static void main(String[] args) throws IOException, InterruptedException {

        SpringApplication.run(EnterpriseApplication.class, args);

        // create a client
        var client = HttpClient.newHttpClient();

        // create a request
        var request = HttpRequest.newBuilder(
                        URI.create("https://api.pokemontcg.io/v2/cards?q=id:hgss4-1"))
                .header("accept", "application/json")
                .header("X-Api-Key", "f9011b3f-82ce-4519-a551-96be1209afc9")
                .build();

        // use the client to send the request
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        // the response:
        System.out.println(response.body());
    }

}