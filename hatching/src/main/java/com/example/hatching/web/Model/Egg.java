package com.example.hatching.web.Model;

import jakarta.persistence.*;

import java.util.Date;

@Entity
public class Egg {

    private String name;
    private Integer hatchingTime;
    private Date dateDeposit;
    private String No;

    public String getNo() {
        return No;
    }

    public void setNo(String no) {
        No = no;
    }

    public Date getDateDeposit() {
        return dateDeposit;
    }

    public void setDateDeposit(Date dateDeposit) {
        this.dateDeposit = dateDeposit;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = "Oeuf de " + name;
    }

    public Integer getHatchingTime() {
        return hatchingTime;
    }

    public void setHatchingTime(Integer hatchingTime) {
        this.hatchingTime = hatchingTime;
    }

}
