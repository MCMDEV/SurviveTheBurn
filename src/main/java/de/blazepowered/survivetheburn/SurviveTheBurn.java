package de.blazepowered.survivetheburn;

import java.util.Random;

public interface SurviveTheBurn {

    Random RANDOM = new Random();

    default STBGame createGame(String name) {
        return createGame(RANDOM.nextLong(), name);
    }

    STBGame createGame(long id, String name);

    STBGame getGame(long id);

    STBGame deleteGame(long id);

}
