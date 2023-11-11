package org.gr40in;

import org.gr40in.app.ConsoleApp;
import org.gr40in.controller.Controller;
import org.gr40in.database.DataBaseService;
import org.gr40in.database.UtilsCRUD;
import org.gr40in.model.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        new Controller().runApp();
    }
}