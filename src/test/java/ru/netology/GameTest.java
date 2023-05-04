package ru.netology;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GameTest {
    Player player1 = new Player(1, "Oliver", 40);
    Player player2 = new Player(2, "Sara", 30);
    Player player3 = new Player(3, "Ann", 50);
    Player player4 = new Player(4, "Jack", 50);
    Player player5 = new Player(5, "Arya", 50);
    Game game = new Game();

    @Test
    void checkAmongRegisteredWhenStrengthPlayer1IsMorePlayer2() {
        game.register(player1);
        game.register(player2);
        game.register(player3);
        game.register(player4);
        game.register(player5);
        int expected = 1;
        int actual = game.round("Oliver", "Sara");

        Assertions.assertEquals(expected, actual);
    }
    @Test
    void checkAmongRegisteredWhenStrengthPlayer2IsLessPlayer3() {
        game.register(player1);
        game.register(player2);
        game.register(player3);
        game.register(player4);
        game.register(player5);
        int expected = 2;
        int actual = game.round("Sara", "Ann");

        Assertions.assertEquals(expected, actual);
    }
    @Test
    void checkAmongRegisteredWhenStrengthPlayer3IsEqualPlayer4() {
        game.register(player1);
        game.register(player2);
        game.register(player3);
        game.register(player4);
        game.register(player5);
        int expected = 0;
        int actual = game.round("Ann", "Jack");

        Assertions.assertEquals(expected, actual);
    }
    @Test
    void checkAmongRegisteredWhenStrengthPlayer4IsEqualPlayer5() {
        game.register(player1);
        game.register(player2);
        game.register(player3);
        game.register(player4);
        game.register(player5);
        int expected = 0;
        int actual = game.round("Jack", "Arya");

        Assertions.assertEquals(expected, actual);
    }
    @Test
    public void checkAmongUnregisteredPlayers_1() {
        game.register(player1);
        game.register(player2);
        game.register(player4);
        game.register(player5);
        Assertions.assertThrows(NotRegisteredException.class, () -> {
            game.round("Oliver", "Ann");
        });
    }
    @Test
    public void checkAmongUnregisteredPlayers_2() {
        game.register(player1);
        game.register(player2);
        game.register(player3);
        game.register(player4);
        Assertions.assertThrows(NotRegisteredException.class, () -> {
            game.round("Arya", "Sara");
        });
    }
    @Test
    public void checkAmongUnregisteredPlayers_3() {
        game.register(player1);
        game.register(player3);
        game.register(player4);
        game.register(player5);
        Assertions.assertThrows(NotRegisteredException.class, () -> {
            game.round("Ann", "Sara");
        });
    }
    @Test
    public void checkAmongUnregisteredPlayers_4() {
        game.register(player2);
        game.register(player3);
        game.register(player4);
        game.register(player5);
        Assertions.assertThrows(NotRegisteredException.class, () -> {
            game.round("Jack", "Oliver");
        });
    }
    @Test
    public void checkWhenFirstPlayerRegisteredSecondNotRegistered() {
        game.register(player1);
        game.register(player2);
        game.register(player3);
        game.register(player4);
        game.register(player5);
        Assertions.assertThrows(NotRegisteredException.class, () -> {
            game.round("Oliver", "Liza");
        });
    }
    @Test
    public void checkWhenFirstPlayerNotRegisteredSecondRegistered() {
        game.register(player1);
        game.register(player2);
        game.register(player3);
        game.register(player4);
        game.register(player5);
        Assertions.assertThrows(NotRegisteredException.class, () -> {
            game.round("Liza", "Ann");
        });
    }
    @Test
    public void checkAmongTwoUnregisteredPlayers() {
        game.register(player1);
        game.register(player2);
        game.register(player3);
        game.register(player4);
        game.register(player5);
        Assertions.assertThrows(NotRegisteredException.class, () -> {
            game.round("Setner", "Narspi");
        });
    }
}