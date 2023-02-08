package com.example.store.web.model;

import jakarta.persistence.*;
import org.springframework.core.SpringVersion;

@Entity
public class Egg {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "egg_generator")
    @SequenceGenerator(name = "egg_seq", sequenceName = "egg_seq", allocationSize = 1)

    private String name;



    private Integer hatchingTime;
    private Integer price;

    private Integer level;

    private Integer No;
    public Integer getNo() {
        return No;
    }

    public void setNo(Integer no) {
        No = no;
    }
    public void setHatchingTime(Integer hatchingTime) {
        this.hatchingTime = hatchingTime;
    }

    public void setName(String name) {
        this.name = "Oeuf de " + name;
    }

    public String getName() {
        return name;
    }

    public Integer getHatchingTime() {
        return hatchingTime;
    }


    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public Integer getLevel() {
        return level;
    }

}
