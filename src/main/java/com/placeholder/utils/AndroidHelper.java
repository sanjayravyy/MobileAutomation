package com.placeholder.utils;

import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.placeholder.managers.AppiumDriverManager;

import io.appium.java_client.android.AndroidDriver;

public class AndroidHelper extends WebDriverHelper {

    private static final Logger LOGGER = LoggerFactory.getLogger(AndroidHelper.class.getName());

    /**
     * Gets the current AndroidDriver instance safely
     * @return AndroidDriver instance
     */
    protected AndroidDriver getAndroidDriver() {
        return (AndroidDriver) AppiumDriverManager.getDriver();
    }

    /**
     * Checks if an element is displayed on screen
     * @param element The element to check
     * @return true if element is displayed, false otherwise
     */
    public boolean isElementDisplayed(WebElement element) {
        try {
            return element.isDisplayed();
        } catch (Exception e) {
            LOGGER.debug("Element is not displayed: {}", e.getMessage());
            return false;
        }
    }

    /**
     * Performs a tap action on the given element
     * @param element The element to tap
     */
    public void tap(WebElement element) {
        LOGGER.info("Tapping on element");
        if (isElementDisplayed(element)) {
            element.click();
        } else {
            LOGGER.warn("Element not displayed for tapping");
        }
    }

    /**
     * Enters text into a text field
     * @param element The text field element
     * @param text The text to enter
     */
    public void enterText(WebElement element, String text) {
        LOGGER.info("Entering text: {}", text);
        if (isElementDisplayed(element)) {
            element.clear();
            element.sendKeys(text);
        } else {
            LOGGER.warn("Element not displayed for text entry");
        }
    }

    /**
     * Hides the keyboard if it is shown
     */
    public void hideKeyboard() {
        try {
            getAndroidDriver().hideKeyboard();
        } catch (Exception e) {
            LOGGER.debug("Could not hide keyboard: {}", e.getMessage());
        }
    }
}