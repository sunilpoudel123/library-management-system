package com.miu.util;

import java.util.Random;

public class HelperUtil {
    private static final Random random = new Random();
    private static final int MIN = 0;
    private static final int MAX = 1000000;

    public static int generateID() {
        return random.nextInt((MAX - MIN) + 1) + MIN;
    }

}
