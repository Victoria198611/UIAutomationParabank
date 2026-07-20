package com.victoria.parabank.utils;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class ScreenshotUtils {

    //Save screenshot to a specific path
    public static String takeScreenshot(WebDriver driver, String fieldName) {
        File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        String desPath = "target/screenshots/" + fieldName + ".png";

        try {
            Files.createDirectories(Paths.get("target/screenshots/"));
            Files.copy(srcFile.toPath(), Paths.get(desPath));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return desPath; // return path for reporting
    }
}
