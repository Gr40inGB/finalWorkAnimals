package org.gr40in.model;

import java.time.LocalDate;

public class Cat extends Pets{
    public Cat() {
    }

    public Cat(String name, LocalDate birthDay) {
        super(name, birthDay);
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName() + " " + super.toString();
    }
}
