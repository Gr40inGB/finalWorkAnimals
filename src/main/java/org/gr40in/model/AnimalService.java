package org.gr40in.model;

import org.gr40in.database.UtilsCRUD;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AnimalService {
    public static final int ARGUMENTS_COUNT = 3;

    public static HumanFriends parseStringToAnimal(String data) {
        List<String> dataList = new ArrayList<>(Arrays.asList(data.split("\s+")));
        int dataLength = dataList.size();
        if (dataLength != ARGUMENTS_COUNT)
            System.out.println("There are " +
                    (dataLength < ARGUMENTS_COUNT ? "not enough" : "too much") +
                    " arguments in your data! Need " +
                    ARGUMENTS_COUNT + ". You entered " + dataLength + "!");
        HumanFriends tempLink = null;
        for (String s : dataList) {
            if (s.matches("[a-zA-Zа-яА-Я]+") && validAnimalType(s)) {
                switch (s) {
                    case "Dog" -> tempLink = new Dog();
                    case "Cat" -> tempLink = new Cat();
                    case "Hamster" -> tempLink = new Hamster();
                    case "Horse" -> tempLink = new Horse();
                    case "Camel" -> tempLink = new Camel();
                    case "Donkey" -> tempLink = new Donkey();
                }
            } else if (s.matches("[a-zA-Zа-яА-Я]+")) {
                tempLink.setName(s);
            } else if
            (s.matches("(0[1-9]|[12][0-9]|3[01])[-\\/.](0[1-9]|1[0-2])[-\\/.](19[0-9][0-9]|20[0-9][0-9])")) {
                tempLink.setBirthDay(getValidLocalData(s));

            } else throw new AnimalParsingException("Can't parse this data: " + s);
        }
        return tempLink;


    }

    public static LocalDate getValidLocalData(String stringData) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        LocalDate localDate = LocalDate.parse(stringData.replaceAll("[-\\/.]", "."), formatter);
        if (localDate.isAfter(LocalDate.now()))
            throw new AnimalParsingException("Found Data " + stringData + " is not correct!");
        return localDate;
    }

    public static boolean validAnimalType(String data) {
        return UtilsCRUD.type_exist(data);
    }
}
