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

    private static ThreadLocal<AppiumDriverLocalService> threadLocalService = new ThreadLocal<>();

    private static AppiumDriverLocalService getService() {
        return threadLocalService.get();
    }


    @Test// Code to start appium server automatically@Test
    public void appiumTest() throws MalformedURLException, URISyntaxException {
        // Code to start appium server automatically
        AppiumDriverLocalService appium = new AppiumServiceBuilder()
                .withAppiumJS(new File("\\Users\\imsaa\\AppData\\Roaming\\npm\\node_modules\\appium\\build\\lib\\main.js"))
                .withIPAddress("127.0.0.1")
                .usingPort(4723)
                .build();
        appium.start();

        UiAutomator2Options options = new UiAutomator2Options();

        // Set device
        options.setDeviceName("Pixel 7_Pro");

        // Set App
        options.setApp("\\Users\\imsaa\\IdeaProjects\\MobileAutomation\\demoApp.apk");

        // Set Android driver
        AndroidDriver driver = new AndroidDriver(new URI("http://127.0.0.1:4725/wd/hub").toURL(), options);

    }

    public static void startAppiumServer(String name) {

    }

    public static void stopAppiumServer() {
        getService().stop();
    }
}
