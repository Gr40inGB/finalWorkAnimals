package org.gr40in.app;

import org.gr40in.controller.Controller;

public interface App<T> {
    public void showInfo(T message);

    public void showMenu();

    public T getInfo();

    public void run();

    public Controller getController();
}
