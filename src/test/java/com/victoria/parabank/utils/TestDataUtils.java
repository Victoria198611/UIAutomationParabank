package com.victoria.parabank.utils;

import java.util.Random;

public class TestDataUtils {

    private static final Random random = new Random();

    // Generate random string (letters only)
    public static String randomString(int length) {
        String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < length; i++) {
            sb.append(chars.charAt(random.nextInt(chars.length())));
        }

        return sb.toString();
    }

    // Generate random number with specific digits
    public static String randomNumber(int digits) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < digits; i++) {
            sb.append(random.nextInt(10));
        }

        return sb.toString();
    }

    // Generate random email
    public static String randomEmail() {
        return "test_" + randomString(6) + "@mail.com";
    }

    // Generate random amount for transfers (1–500)
    public static String randomAmount() {
        return String.valueOf(random.nextInt(500) + 1);
    }

    // Generate negative amount (for negative tests)
    public static String negativeAmount() {
        return "-" + randomAmount();
    }

    // Generate very large amount (for boundary tests)
    public static String largeAmount() {
        return String.valueOf(random.nextInt(90000) + 10000); // 10.000 – 100.000
    }

    // Generate invalid email
    public static String invalidEmail() {
        return randomString(5) + "@" + randomNumber(3); // missing domain
    }

    // Generate random username
    public static String randomUsername() {
        return "user_" + randomString(5);
    }

    // Generate random password
    public static String randomPassword() {
        return randomString(8) + randomNumber(2);
    }
}