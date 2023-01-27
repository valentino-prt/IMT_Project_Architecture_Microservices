package com.example.randomGenerator.Model;

import jakarta.persistence.*;

@Entity
public class Egg {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "egg_generator")
    @SequenceGenerator(name = "egg_seq", sequenceName = "egg_seq", allocationSize = 1)
    private String name;
    private Integer hatchingTime;

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

}
