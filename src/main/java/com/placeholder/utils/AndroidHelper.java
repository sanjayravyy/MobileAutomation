package com.placeholder.utils;

import com.placeholder.managers.AppiumDriverManager;
import com.placeholder.managers.AppiumServerManager;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AndroidHelper extends WebDriverHelper {

    public static final Logger LOGGER = LoggerFactory.getLogger(AndroidHelper.class.getName());

    private static final AndroidDriver driver = (AndroidDriver) AppiumDriverManager.getDriver();



}