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
    private String No;

    public String getNo() {
        return No;
    }

    public void setNo(String no) {
        No = no;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getHatchingTime() {
        return hatchingTime;
    }

    public void setHatchingTime(Integer hatchingTime) {
        this.hatchingTime = hatchingTime;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
