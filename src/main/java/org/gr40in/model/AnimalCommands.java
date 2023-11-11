package org.gr40in.model;

import java.util.ArrayList;
import java.util.List;

public class AnimalCommands {
    private Long id;
    private String name;

    public AnimalCommands(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public AnimalCommands(Long id, String name) {
        this.id = id;
        this.name = name;
    }
}
