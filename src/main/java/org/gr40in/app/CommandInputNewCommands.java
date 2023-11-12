package org.gr40in.app;

import org.gr40in.database.UtilsCRUD;
import org.gr40in.model.AnimalService;
import org.gr40in.model.HumanFriends;

import java.util.List;

public class CommandInputNewCommands extends Commands {
    public CommandInputNewCommands(ConsoleApp app) {
        super("Input new command: ", app);
    }

    @Override
    public void run() {

        List<HumanFriends> humanFriendsList = UtilsCRUD.getAllFriends();
        int listSize = humanFriendsList.size();
        StringBuilder sb = new StringBuilder("All animals: \n");
        for (int i = 0; i < listSize; i++) {
            sb.append("\t").append(i + 1).append(" ").append(humanFriendsList.get(i)).append("\n");
        }
        sb.append("Please select number: ");

        HumanFriends selectedLink = humanFriendsList.get(getApp().inputNumber(sb.toString(), listSize) - 1);

        getApp().showInfo("Please enter new command for " + selectedLink + " :");
        UtilsCRUD.createNewCommand(getApp().getInfo(), selectedLink);


    }
}
