package org.gr40in.controller;

import org.gr40in.app.App;
import org.gr40in.app.ConsoleApp;

public class Controller {
    App<String> app;

    public Controller() {
        this.app = new ConsoleApp(this);
    }

    public void runApp() {
        app.run();
    }
}
