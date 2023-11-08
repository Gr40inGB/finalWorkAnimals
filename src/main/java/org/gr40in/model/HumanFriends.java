package org.gr40in.model;

import org.gr40in.app.Commands;

import java.time.LocalDate;
import java.util.List;

public abstract class HumanFriends {
    Long humanFriendsId;
    LocalDate birthDay;
    List<AnimalCommands> commands;
}
