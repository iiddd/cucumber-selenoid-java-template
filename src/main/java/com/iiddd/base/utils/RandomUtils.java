package com.iiddd.base.utils;

import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

/**
 * This class is used to store random generators
 */

public class RandomUtils {

    private static final String NUMERIC_STRING = "0123456789";
    private static final String ALPHABETIC_STRING = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
    private static final String ALPHA_NUMERIC_STRING = ALPHABETIC_STRING + NUMERIC_STRING;
    private static final int EMAIL_RANDOM_STRING_COUNT = 12;

    public static String getRandomAlphaNumericByCharLength(int length) {
        return getRandomStringByCharacterSet(ALPHA_NUMERIC_STRING, length);
    }

    public static String getAlphabeticString(int length) {
        return getRandomStringByCharacterSet(ALPHABETIC_STRING, length);
    }

    public static Long getRandomNumericByCharLength(int length) {
        return Long.parseLong(getRandomStringByCharacterSet(NUMERIC_STRING, length));
    }

    public static String getRandomCellNumber() {
        return String.format("+%d", getRandomNumericByCharLength(10));
    }

    public static String getRandomEmail() {
        return String.format("%s@ammail.ttt", getRandomAlphaNumericByCharLength(EMAIL_RANDOM_STRING_COUNT));
    }

    public static <P> P getRandomElementFromList(List<P> list) {
        int size = list.size();
        int random = new Random().nextInt(size);
        return list.get(random);
    }

    public static int getRandomNumericInRange(int min, int max) {
        //inclusive
        return ThreadLocalRandom.current().nextInt(min, max + 1);
    }

    private static String getRandomStringByCharacterSet(String characters, int length) {
        StringBuilder builder = new StringBuilder();
        while (length-- != 0) {
            int character = (int) (Math.random() * characters.length());
            builder.append(characters.charAt(character));
        }
        return builder.toString();
    }
}