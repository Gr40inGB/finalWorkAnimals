package org.gr40in.app;

import org.gr40in.database.UtilsCRUD;
import org.gr40in.model.HumanFriends;

import java.util.List;

public class CommandShowAll extends Commands {
    public CommandShowAll(ConsoleApp app) {
        super("Show all: ", app);
    }

    @Override
    public void run() {

        List<HumanFriends> humanFriendsList = UtilsCRUD.getAllFriends();
        for (HumanFriends friends : humanFriendsList) {
            System.out.println(friends);
        }

    }
}
