package org.gr40in.model;

import java.time.LocalDate;

public class Hamster extends Pets {
    public Hamster() {
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName() + " " + super.toString();
    }

    public Hamster(String name, LocalDate birthDay) {
        super(name, birthDay);
    }
}
