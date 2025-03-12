package com.mobileautomation.base;

import java.io.File;
import java.time.Duration;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class BaseTest {
    protected static AndroidDriver driver;
    protected static UiAutomator2Options options;
    protected static AppiumDriverLocalService service;

    @BeforeMethod
    public void setupDriver() {
        try {
            System.out.println("Starting Appium server...");
            service = new AppiumServiceBuilder()
                .withIPAddress("127.0.0.1")
                .usingPort(4723)
                .build();
            service.start();

            System.out.println("Setting up Android driver...");
            
            // Initialize UiAutomator2Options
            options = new UiAutomator2Options()
                .setDeviceName("Android")
                .setPlatformName("Android")
                .setAutomationName("UiAutomator2")
                .setNoReset(true);

            // Set app path
            String appPath = System.getProperty("user.dir") + 
                           File.separator + "src" + 
                           File.separator + "test" + 
                           File.separator + "resources" + 
                           File.separator + "apps" + 
                           File.separator + "ApiDemos-debug.apk";
            
            System.out.println("Using app path: " + appPath);
            
            options.setApp(appPath)
                  .setAppPackage("io.appium.android.apis")
                  .setAppActivity("io.appium.android.apis.ApiDemos");

            System.out.println("Connecting to Appium server...");
            driver = new AndroidDriver(
                service.getUrl(), 
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
            if (service != null && service.isRunning()) {
                service.stop();
            }
            throw new RuntimeException("Failed to initialize driver", e);
        }
    }

    @AfterMethod
    public void tearDown() {
        System.out.println("Tearing down test...");
        if (driver != null) {
            try {
                System.out.println("Closing the app...");
                driver.terminateApp("io.appium.android.apis");
                
                System.out.println("Quitting the driver...");
                driver.quit();
                driver = null;
                System.out.println("Driver quit successfully.");
            } catch (Exception e) {
                System.err.println("Error while closing app/quitting driver: " + e.getMessage());
            }
        }
        
        if (service != null && service.isRunning()) {
            try {
                System.out.println("Stopping Appium server...");
                service.stop();
                service = null;
                System.out.println("Appium server stopped successfully.");
            } catch (Exception e) {
                System.err.println("Error while stopping Appium server: " + e.getMessage());
            }
        }
    }

    public AndroidDriver getDriver() {
        return driver;
    }
} 