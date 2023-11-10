package org.gr40in.model;

import java.time.LocalDate;

public abstract class Pets extends HumanFriends {
    public Pets() {
    }

    public Pets(String name, LocalDate birthDay) {
        super(name, birthDay);
    }
}
