package com.victoria.parabank.drivers;

import org.openqa.selenium.chrome.ChromeOptions;

public class DriverOptions {

    // Returns configured ChromeOptions for browser initialization
    public ChromeOptions getChromeOptions() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--user-agent=Mozilla/5.0 (Windows NT 10.0; Win64; x64) Chrome/114 Safari/537.36");

        //Start browser maximized
        options.addArguments("start-maximized");

        //Disable browser notifications
        options.addArguments("--disable-notifications");

        //Disable extensions
        options.addArguments("--disable-extensions");

        //Allow remote origins to avoid automation errors
        options.addArguments("--remote-allow-origins=*");
        return options;
    }
}
