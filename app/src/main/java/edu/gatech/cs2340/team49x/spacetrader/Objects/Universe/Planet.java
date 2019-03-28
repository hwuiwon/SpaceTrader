package edu.gatech.cs2340.team49x.spacetrader.Objects.Universe;

import java.io.Serializable;

public class Planet implements Serializable {
    static final long serialVersionUID = 1L;

    private String name;

    public Planet(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}