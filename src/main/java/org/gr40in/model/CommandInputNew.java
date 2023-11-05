package org.gr40in.model;

public class CommandInputNew extends Commands {
    public CommandInputNew(ConsoleApp app) {
        super("Input new: ", app);
    }

    @Override
    public void run() {
        getApp().enterNew();
    }
}
