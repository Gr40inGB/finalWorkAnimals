package org.gr40in.app;

import org.gr40in.database.UtilsCRUD;
import org.gr40in.model.AnimalService;
import org.gr40in.model.HumanFriends;

public class CommandInputNew extends Commands {
    public CommandInputNew(ConsoleApp app) {
        super("Input new animal: ", app);
    }

    @Override
    public void run() {

        System.out.print("Please enter new animal (<type> <name> <birth data> as  \"Dog Saimon 28.12.1999\")\n>>>>> ");
        HumanFriends temp = AnimalService.parseStringToAnimal(getApp().getInfo());
        UtilsCRUD.createAnimal(temp);
        getApp().showInfo("\tcreated new animal: " + temp + "\n");

    }
}
