package org.pokecollect.dto;

import lombok.Data;

import java.util.List;

/**
 * Represents a Pokemon card, specifically a "Pokecard," with various attributes including ID, name, level, HP,
 * types, and description.
 */
public @Data class Pokecard {

    private String id;
    private String name;
    private String level;
    private String hp;
    private List<String> types;
    private int pokecardId;

}
