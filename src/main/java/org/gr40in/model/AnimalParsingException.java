package org.gr40in.model;

public class AnimalParsingException extends RuntimeException {
    public AnimalParsingException(String message) {
        super("ERROR! " + message);
    }
}
