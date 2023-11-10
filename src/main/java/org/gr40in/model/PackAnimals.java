package org.gr40in.model;

import java.time.LocalDate;

public abstract class PackAnimals extends HumanFriends {
    public PackAnimals() {
    }

    public PackAnimals(String name, LocalDate birthDay) {
        super(name, birthDay);
    }
}
