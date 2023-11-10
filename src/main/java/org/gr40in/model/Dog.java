package org.gr40in.model;

import java.time.LocalDate;

public class Dog extends Pets {
    @Override
    public String toString() {
        return this.getClass().getSimpleName() + " " + super.toString();
    }

    public Dog() {
    }

    public Dog(String name, LocalDate birthDay) {
        super(name, birthDay);
    }
}
