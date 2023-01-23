package com.example.hatching.Model;

public class Eggs {
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
