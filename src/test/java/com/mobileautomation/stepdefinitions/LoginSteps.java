package com.mobileautomation.stepdefinitions;

import java.time.Duration;

import org.testng.Assert;

import com.mobileautomation.base.BaseTest;

import io.cucumber.java.en.Given;

public class LoginSteps extends BaseTest {
    
    @Given("I am on the login screen")
    public void iAmOnTheLoginScreen() {
        System.out.println("On login screen");
        Assert.assertNotNull(driver, "Driver should not be null");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }
}