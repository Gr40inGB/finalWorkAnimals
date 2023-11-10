package org.gr40in.model;

import org.gr40in.app.Commands;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public abstract class HumanFriends {
    Long humanFriendsId;
    String name;
    LocalDate birthDay;
    List<AnimalCommands> commands;

    public HumanFriends() {
    }

    @Override
    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        return name + " " + birthDay.format(formatter);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(LocalDate birthDay) {
        this.birthDay = birthDay;
    }

    public List<AnimalCommands> getCommands() {
        return commands;
    }

    public void setCommands(List<AnimalCommands> commands) {
        this.commands = commands;
    }

    public HumanFriends(String name, LocalDate birthDay) {
        this.name = name;
        this.birthDay = birthDay;
        this.commands = new ArrayList<>();
    }
}
