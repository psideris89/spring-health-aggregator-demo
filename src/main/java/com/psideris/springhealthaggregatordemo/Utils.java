package com.psideris.springhealthaggregatordemo;

import java.util.Random;

public class Utils {
    public static int getRandomNumber() {
        return new Random().ints(1, 10).findFirst().orElseThrow(() -> new RuntimeException("Failed to generate random number"));
    }
}
