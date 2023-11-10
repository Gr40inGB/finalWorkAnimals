package org.gr40in.model;

import java.time.LocalDate;

public class Horse extends PackAnimals {
    public Horse() {
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName() + " " + super.toString();
    }

    public Horse(String name, LocalDate birthDay) {
        super(name, birthDay);
    }
}
