package com.victoria.parabank.utils;

import java.io.FileInputStream;
import java.util.Properties;

public class ConfigReader {
    private static Properties properties;

    static {
        try {
            FileInputStream fileInputStream = new FileInputStream("src/test/resources/config.properties");
            properties = new Properties();
            properties.load(fileInputStream);
        } catch (Exception e) {
            throw new RuntimeException("Could not load config.properties");
        }
    }
public static String getProperty(String key){
        return properties.getProperty(key);
}
    }