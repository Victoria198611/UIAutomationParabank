package com.victoria.parabank.utils;

import org.testng.Assert;

public class AssertationUtils {

    public static void assertEquals(String actual, String expected, String message) {
        Assert.assertEquals(actual, expected, message);
    }

    public static void assertTrue(boolean condition, String message) {
        Assert.assertTrue(condition, message);
    }

    public static void assertFalse(boolean condition, String message) {
        Assert.assertFalse(condition, message);
    }

    public static void assertNotNull(Object object, String message) {
        Assert.assertNotNull(object, message);
    }

    public static void assertContains(String actual, String expectedSubstring, String message) {
        Assert.assertTrue(actual.contains(expectedSubstring), message);
    }
}