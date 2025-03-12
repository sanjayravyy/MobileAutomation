package com.mobileautomation.base;

import java.net.URL;
import java.time.Duration;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

public class BaseTest {
    protected static AndroidDriver driver;
    protected static UiAutomator2Options options;

    @BeforeMethod
    public void setupDriver() {
        try {
            System.out.println("Connecting to Appium server...");
            driver = new AndroidDriver(
                new URL("http://127.0.0.1:4723"), 
                options
            );
            
            System.out.println("Setting implicit wait...");
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
            System.out.println("Driver setup completed successfully.");
            
        } catch (Exception e) {
            System.err.println("Failed to initialize driver: " + e.getMessage());
            e.printStackTrace();
            if (driver != null) {
                driver.quit();
            }
            throw new RuntimeException("Failed to initialize driver", e);
        }
    }

    @AfterMethod
    public void tearDown() {
        System.out.println("Tearing down driver...");
        if (driver != null) {
            try {
                driver.quit();
                System.out.println("Driver quit successfully.");
            } catch (Exception e) {
                System.err.println("Error while quitting driver: " + e.getMessage());
            }
        }
    }

    public AndroidDriver getDriver() {
        return driver;
    }
} 