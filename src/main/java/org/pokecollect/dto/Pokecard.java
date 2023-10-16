package org.pokecollect.dto;

import lombok.Data;

import java.util.List;

public @Data class Pokecard {
    private final String id;
    private final String name;
    private final String level;
    private final String hp;
    private final List<String> types;
    private final String description;

    public Pokecard(String id, String name, String level, String hp, List<String> types, String description) {
        this.id = id;
        this.name = name;
        this.level = level;
        this.hp = hp;
        this.types = types;
        this.description = description;
    }
}
