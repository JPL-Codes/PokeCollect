package org.pokecollect.dto;

import lombok.Data;

import java.util.List;

public @Data class Pokecard {

    private String id;
    private String name;
    private String level;
    private String hp;
    private List<String> types;
    private String description;

}
