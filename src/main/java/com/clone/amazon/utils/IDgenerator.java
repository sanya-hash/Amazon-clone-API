package com.clone.amazon.utils;

import java.util.Random;
import java.util.UUID;

public class IDgenerator {
	
    public static String generateUniqueIdUsingUUID() {
        return UUID.randomUUID().toString();
    }

	
    public static String generateUniqueId() {
        return generateRandomString();
    }

    private static String generateRandomString() {
        StringBuilder buffer = new StringBuilder();
        buffer.append(generateRandomHex(8)); // 65320c26
        buffer.append(generateRandomHex(4)); // 35ca
        buffer.append(generateRandomHex(4)); // 026e
        buffer.append(generateRandomHex(4)); // fd05
        buffer.append(generateRandomHex(12)); // 83a5
        return buffer.toString();
    }

    private static String generateRandomHex(int length) {
        Random random = new Random();
        StringBuilder buffer = new StringBuilder(length);
        for (int i = 0; i < length; i++) {
            int randomInt = random.nextInt(16); // Random number between 0 and 15
            buffer.append(Integer.toHexString(randomInt));
        }
        return buffer.toString();
    }


}

