package com.example.hatching.web.Model;

import jakarta.persistence.Entity;

public class Pokemon {
    private String name;
    private Integer level;
    private Integer No;

    public Integer getNo() {
        return No;
    }

    public void setNo(Integer no) {
        No = no;
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
