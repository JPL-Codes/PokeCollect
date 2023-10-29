package org.pokecollect.dto;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import java.util.List;

/**
 * Represents a Pokemon card, specifically a "Pokecard," with various attributes including ID, name, level, HP,
 * types, and description.
 */
@Entity
public class Pokecard {

    @Id
    @GeneratedValue(
            strategy= GenerationType.AUTO,
            generator="native"
    )
    @GenericGenerator(
            name = "native",
            strategy = "native"
    )
    @Column(name = "pokecardId")
    private int pokecardId;

    @Column(name = "id")
    private String id;

    @Column(name = "name")
    private String name;

    @Column(name = "level")
    private String level;

    @Column(name = "hp")
    private String hp;

    @Column(name = "types")
    private List<String> types;

    @ManyToMany(mappedBy = "pokecardCollection")
    private List<User> users;

    public int getPokecardId() {
        return pokecardId;
    }

    public void setPokecardId(int pokecardId) {
        this.pokecardId = pokecardId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getHp() {
        return hp;
    }

    public void setHp(String hp) {
        this.hp = hp;
    }

    public List<String> getTypes() {
        return types;
    }

    public void setTypes(List<String> types) {
        this.types = types;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    @Override
    public String toString() {
        return "Pokecard{" +
                "pokecardId=" + pokecardId +
                ", id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", level='" + level + '\'' +
                ", hp='" + hp + '\'' +
                ", types=" + types +
                ", users=" + users +
                '}';
    }
}
