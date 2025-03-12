package com.mobileautomation.stepdefinitions;

import java.time.Duration;

import com.mobileautomation.base.BaseTest;

import io.cucumber.java.en.Given;

public class LoginSteps extends BaseTest {
    
    @Given("I am on the login screen")
    public void iAmOnTheLoginScreen() {
        // Verify login screen is displayed
        System.out.println("On login screen");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }
}