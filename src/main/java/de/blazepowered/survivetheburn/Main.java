package de.blazepowered.survivetheburn;

import java.util.Random;

public class Main {
    public static void main(String[] args) {

        Random random = new Random();
        long r = random.nextLong();
        System.out.println("First: " + r);
        String test = Long.toUnsignedString(r, 36);
        System.out.println(test);

        System.out.println("Last: " + Long.parseUnsignedLong(test, 36));

    }

}
