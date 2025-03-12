package com.mobileautomation.stepdefinitions;

import java.time.Duration;

import org.testng.Assert;

import com.mobileautomation.base.BaseTest;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import page_objects.loginPage.AndroidLoginPage;

public class LoginSteps extends BaseTest {
    
    private AndroidLoginPage loginPage;

    @Given("I am on the login screen")
    public void iAmOnTheLoginScreen() {
        System.out.println("On login screen");
        Assert.assertNotNull(driver, "Driver should not be null");
        loginPage = new AndroidLoginPage(driver);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @When("I click on the App button")
    public void I_enter_invalid_username_and_password() {
        System.out.println("Clicking on App button");
        loginPage.clickElement(loginPage.appButton);
    }
}