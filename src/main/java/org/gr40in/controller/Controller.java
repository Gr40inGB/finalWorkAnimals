package org.gr40in.controller;

import org.gr40in.app.App;
import org.gr40in.app.ConsoleApp;
import org.gr40in.database.DataBaseService;
import org.gr40in.database.UtilsCRUD;

public class Controller {
    App<String> app;

    public Controller() {
        DataBaseService.initDataBase();
        this.app = new ConsoleApp(this);

    }

    public void runApp() {
        app.run();
    }
}
