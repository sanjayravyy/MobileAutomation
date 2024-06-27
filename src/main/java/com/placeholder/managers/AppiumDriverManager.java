package com.placeholder.managers;

import io.appium.java_client.AppiumDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AppiumDriverManager {

    public static final Logger LOGGER = LoggerFactory.getLogger(AppiumDriverManager.class.getName());

    private static final ThreadLocal<AppiumDriver> appiumDriver = new ThreadLocal<>();

    public static AppiumDriver getDriver(){
        return appiumDriver.get();
    }


}
