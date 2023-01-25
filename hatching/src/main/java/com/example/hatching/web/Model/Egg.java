package com.example.hatching.web.Model;

import jakarta.persistence.*;

import java.util.Date;

@Entity
public class Egg {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "egg_generator")
    @SequenceGenerator(name = "egg_seq", sequenceName = "egg_seq", allocationSize = 1)
    private Integer id;
    private String name;
    private Integer hatchingTime;
    private Date dateDeposit;
    public Date getDateDeposit() {
        return dateDeposit;
    }
    public void setDateDeposit(Date dateDeposit) {
        this.dateDeposit = dateDeposit;
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
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }

}
