package org.gr40in.model;

import java.time.LocalDate;

public class Donkey extends PackAnimals {
    public Donkey() {
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName() + " " + super.toString();
    }

    public Donkey(String name, LocalDate birthDay) {
        super(name, birthDay);
    }
}
