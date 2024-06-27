package com.placeholder.managers;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import org.testng.annotations.Test;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;

public class AppiumServerManager {

    @Test
    public void appiumTest() throws MalformedURLException, URISyntaxException {

        //Appium Server
        AppiumDriverLocalService appium = new AppiumServiceBuilder().withAppiumJS(new File("\\Users\\imsaa\\AppData\\Roaming\\npm\\node_modules\\appium\\build\\lib\\main.js")).withIPAddress("127.0.0.1").usingPort(4723).build();
        appium.start();

        UiAutomator2Options options = new UiAutomator2Options();

        //Set device
        options.setDeviceName("Pixel 7_Pro");

        //Set App
        options.setApp("\\Users\\imsaa\\IdeaProjects\\PlaceholderProject\\src\\main\\resources\\ApiDemos-debug.apk");

        //Set Android driver
        AndroidDriver driver = new AndroidDriver(new URI("http://127.0.0.1:4723").toURL(), options);
    }
}
