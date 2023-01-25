package com.example.hatching.web.Model;

import jakarta.persistence.Entity;

public class Pokemon {
    private String name;
    private Integer level;

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
