package ru.netology;

public class NotRegisteredException extends RuntimeException {
    public NotRegisteredException(String playerName) {

        super("Player named: " + playerName + "is not registered");
    }

}