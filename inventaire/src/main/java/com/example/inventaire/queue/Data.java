package com.example.inventaire.queue;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Data {

    @JsonProperty("id")
    public String id;

    @JsonProperty("name")
    public String name;
}
