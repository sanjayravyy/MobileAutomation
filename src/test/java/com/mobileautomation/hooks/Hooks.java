package com.mobileautomation.hooks;

import com.mobileautomation.base.BaseTest;

import io.appium.java_client.android.options.UiAutomator2Options;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class Hooks extends BaseTest {
    
    @Before
    public void setUp() {
        try {
            System.out.println("Setting up Android driver...");
            options = new UiAutomator2Options()
                .setDeviceName("Android")
                .setPlatformName("Android")
                .setAutomationName("UiAutomator2")
                .setNoReset(true)
                .setApp("C:\\Automation\\Mobile Java Repo\\MobileJava\\ApiDemos-debug.apk")
                .setAppPackage("io.appium.android.apis")
                .setAppActivity("io.appium.android.apis.ApiDemos");

            // Initialize driver with app capabilities
            setupDriver();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @After
    public void teardown(Scenario scenario) {
        if (scenario.isFailed()) {
            // Add screenshot capture logic here if needed
            System.out.println("Scenario failed: " + scenario.getName());
        }
        tearDown();
        System.out.println("Finished scenario: " + scenario.getName());
    }
} 