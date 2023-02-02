package com.example.inventaire.web.Model;

import jakarta.persistence.*;

@Entity
public class Egg {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "egg_generator")
    @SequenceGenerator(name = "egg_seq", sequenceName = "egg_seq", allocationSize = 1)
    private Integer id;
    private String name;
    private Integer hatchingTime;
    private String picture;

    public String getPicture() {
        return picture;
    }

    public void setPicture(Integer no) {
        this.picture = String.format("https://assets.pokemon.com/assets/cms2/img/pokedex/detail/%s.png",no);
    }

    public void setHatchingTime(Integer hatchingTime) {
        this.hatchingTime = hatchingTime;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Integer getHatchingTime() {
        return hatchingTime;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
