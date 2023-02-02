package com.example.hatching.web.Model;

import jakarta.persistence.Entity;

public class Pokemon {
    public Pokemon(String url){
        this.picture = url;
    }
    public Pokemon(){}
    private String name;
    private Integer level;
    private String picture;
    public String getPicture() {
        return picture;
    }
    public void setPicture(Integer no) {
        this.picture = String.format("https://assets.pokemon.com/assets/cms2/img/pokedex/detail/%s.png",no);

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

    public void setLevel(Integer level) {
        this.level = level;
    }



}
