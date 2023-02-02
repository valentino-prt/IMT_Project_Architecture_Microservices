package com.example.inventaire.web.Model;

import jakarta.persistence.*;


@Entity
public class Pokemon {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "pokemon_generator")
    @SequenceGenerator(name = "pokemon_seq", sequenceName = "pokemon_seq", allocationSize = 1)
    private Integer id;
    private String name;
    private Integer level;
    private String No;

    public Pokemon(String received_message) {
        String[] parameters = received_message.split(";");
        if (parameters.length == 3) {
            this.name = parameters[0];
            this.level = Integer.parseInt(parameters[1]);
            this.No = parameters[2];
        }
    }

    public Pokemon() {
    }

    public String getNo() {
        return No;
    }

    public void setNo(String no) {
        this.No = no;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public Integer getId() {
        return id;
    }

}
