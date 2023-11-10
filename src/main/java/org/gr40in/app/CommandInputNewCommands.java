package org.gr40in.app;

import org.gr40in.model.AnimalService;
import org.gr40in.model.HumanFriends;

public class CommandInputNewCommands extends Commands {
    public CommandInputNewCommands(ConsoleApp app) {
        super("Input new: ", app);
    }

    @Override
    public void run() {

        System.out.print("Please enter new animal (<type> <name> <birth data> as  \"dog Saimon 28.12.1999\")\n>>>>> ");
        HumanFriends temp = AnimalService.parseStringToAnimal(getApp().getInfo());
        System.out.println("-----------------");
        System.out.println(temp);

    }
}
