package org.loose.fis.sre.exceptions;

public class InvalidCredentials extends Exception {

    private String Name;

    public InvalidCredentials(String Name) {
        super(String.format("Your name or password is incorrect"));
        this.Name = Name;
    }

    public String getName() {
        return Name;
    }
}
