package com.example.inventaire.web.Model;

import jakarta.persistence.*;

import java.util.Arrays;

@Entity
public class Pokemon {
    public Pokemon(String received_message){
        String[] parameters = received_message.split(";");
        if (parameters.length == 3) {
            this.name = parameters[0];
            this.level = Integer.parseInt(parameters[1]);
            this.picture = String.format("https://assets.pokemon.com/assets/cms2/img/pokedex/detail/%s.png",Integer.parseInt(parameters[2]));

        }
    }

    public Pokemon(){}


    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "pokemon_generator")
    @SequenceGenerator(name = "pokemon_seq", sequenceName = "pokemon_seq", allocationSize = 1)
    private Integer id;
    private String name;
    private Integer level;

    private String picture;

    public String getPicture() {
        return picture;
    }

    public void setPicture(Integer no) {
        this.picture = String.format("https://assets.pokemon.com/assets/cms2/img/pokedex/detail/%s.png",no);

    }

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

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
