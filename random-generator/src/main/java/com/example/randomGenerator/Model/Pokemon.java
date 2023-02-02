package com.example.randomGenerator.Model;

import jakarta.persistence.*;

@Entity
public class Pokemon {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "pokemon_generator")
    @SequenceGenerator(name = "pokemon_seq", sequenceName = "pokemon_seq", allocationSize = 1)
    private String name;
    private Integer level;
    private String picture;

    public void setLevel(Integer level) {
        this.level = level;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Integer getLevel() {
        return level;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(Integer no) {
        this.picture = String.format("https://assets.pokemon.com/assets/cms2/img/pokedex/detail/%s.png",no);
    }
}
