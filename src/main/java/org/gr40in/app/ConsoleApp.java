package org.gr40in.app;

import org.gr40in.controller.Controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ConsoleApp implements App<String> {
    private List<Commands> menu;
    private boolean run;

    private Controller controller;


    Scanner scanner = new Scanner(System.in);

    public List<Commands> getMenu() {
        return this.menu;
    }


    public boolean isRun() {
        return run;
    }


    public void exit() {
        System.out.println("buy buy ;)");
        this.run = false;
    }

    @Override
    public void run() {
        while (this.isRun()) {
            showMenu();
            Commands selected = this.getMenu().
                    get(inputNumber("\nEnter selected command number: ", this.getMenu().size()) - 1);
            selected.run();
        }
    }

    public int inputNumber(String welcome, int biggest) {

        boolean inputError = true;
        int rezult = 0;
        while (inputError) {
            System.out.print(welcome);
            try {
                rezult = Integer.parseInt(scanner.nextLine());
                if (rezult <= biggest && rezult > 0) {
                    inputError = false;
                } else System.out.print("Choose between 1-" + biggest + "\n>>>> ");
            } catch (NumberFormatException nfe) {
                System.out.println("error - try again:");
            }
        }
        return rezult;
    }

    @Override
    public Controller getController() {
        return controller;
    }

    public ConsoleApp(Controller controller) {
        this.controller = controller;
        this.run = true;
        this.menu = new ArrayList<>();
        menu.add(new CommandInputNew(this));
        menu.add(new CommandShowAll(this));
        menu.add(new CommandShowAllCommands(this));
        menu.add(new CommandInputNewCommands(this));
        menu.add(new CommandGetCounts(this));
        menu.add(new CommandExit(this));

    }

    @Override
    public void showInfo(String message) {
        System.out.print(message);
    }

    @Override
    public void showMenu() {
        System.out.println("Main menu: ");
        for (int i = 0; i < this.menu.size(); i++) {
            System.out.println("\t" + (i + 1) + ". " + menu.get(i).getName());
        }
    }

    @Override
    public String getInfo() {
        return this.scanner.nextLine();
    }


}
