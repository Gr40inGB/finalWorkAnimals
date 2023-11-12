package org.gr40in.app;

import org.gr40in.database.UtilsCRUD;

public class CommandGetCounts extends Commands {
    public CommandGetCounts(ConsoleApp app) {
        super("Get counts of animals: ", app);
    }
    @Override
    public void run() {
        getApp().showInfo("\tAll animal count : " + UtilsCRUD.getAnimalCount() + "\n");
    }
}
