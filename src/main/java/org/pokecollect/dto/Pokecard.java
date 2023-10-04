package org.pokecollect.dto;

import lombok.Data;

import java.util.List;

public @Data class Pokecard {

    private int id;
    private String name;
    private String level;
    private String hp;
    private List<String> types;
}
