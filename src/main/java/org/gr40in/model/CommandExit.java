package org.gr40in.model;

public class CommandExit extends Commands {
    public CommandExit(ConsoleApp app) {
        super("Exit: ", app);
    }

    @Override
    public void run() {
        getApp().exit();
    }
}
