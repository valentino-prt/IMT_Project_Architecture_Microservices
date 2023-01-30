package com.example.user.Model;

import jakarta.persistence.*;

@Entity
public class Dresseur {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "egg_generator")
    @SequenceGenerator(name = "egg_seq", sequenceName = "egg_seq", allocationSize = 1)
    private Integer id;
    private String name;
    private Integer level;
    private Integer gold;
    private Integer xp;
    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public void setGold(Integer gold) {
        this.gold = gold;
    }

    public void setXp(Integer xp) {
        this.xp = xp;
    }



    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Integer getLevel() {
        return level;
    }

    public Integer getGold() {
        return gold;
    }

    public Integer getXp() {
        return xp;
    }
}
