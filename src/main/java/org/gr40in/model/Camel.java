package org.gr40in.model;

import java.time.LocalDate;

public class Camel extends PackAnimals {
    public Camel() {
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName() + " " + super.toString();
    }

    public Camel(String name, LocalDate birthDay) {
        super(name, birthDay);
    }
}
