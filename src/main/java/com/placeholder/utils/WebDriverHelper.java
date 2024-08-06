package com.placeholder.utils;

import com.placeholder.exceptions.ExceptionController;
import com.placeholder.managers.AppiumDriverManager;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Pause;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Duration;
import java.util.List;


public class WebDriverHelper {

    public static final Logger LOGGER = LoggerFactory.getLogger(WebDriverHelper.class.getName());

    public enum Direction {
        UP,
        DOWN,
        RIGHT,
        LEFT
    }

    /**
     * Method to get the center point of an element.
     *
     * @param element element
     * @return the center point of the element.
     */
    public Point getCenter(WebElement element) {
        Point cornet = element.getLocation();
        Dimension size = element.getSize();
        return new Point(cornet.getX() + size.getWidth() / 2, cornet.getY() + size.getHeight() / 2);
    }

    /**
     * Method to long press an element.
     *
     * @param element element
     */
    public void longPress(WebElement element) {
        LOGGER.info("Long pressing element!");
        PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
        Sequence sequence = new Sequence(finger, 1);
        sequence.addAction(finger.createPointerMove(Duration.ofMillis(0), PointerInput.Origin.viewport(), getCenter(element).getX(), getCenter(element).getY()));
        sequence.addAction(new Pause(finger, Duration.ofSeconds(1)));
        sequence.addAction(finger.createPointerUp(PointerInput.Kind.TOUCH.hashCode()));
        AppiumDriverManager.getDriver().perform(List.of(sequence));
    }

    /**
     * Method to swipe in a specific direction
     *
     * @param startX startX
     * @param startY startY
     * @param endX   endX
     * @param endY   endY
     */
    public void swipe(int startX, int startY, int endX, int endY) {
        PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
        Sequence sequence = new Sequence(finger, 1);
        sequence.addAction(finger.createPointerMove(Duration.ofMillis(0), PointerInput.Origin.viewport(), startX, startY));
        sequence.addAction(finger.createPointerDown(PointerInput.Kind.TOUCH.hashCode()));
        sequence.addAction(finger.createPointerMove(Duration.ofMillis(500), PointerInput.Origin.viewport(), endX, endY));
        sequence.addAction(finger.createPointerUp(PointerInput.Kind.TOUCH.hashCode()));
        AppiumDriverManager.getDriver().perform(List.of(sequence));

    }

    /**
     * @param startX startX
     * @param startY startY
     * @param endX   endX
     * @param endY   endY
     */
    public void doSwipe(double startX, double startY, double endX, double endY) {
        int screenWidth = AppiumDriverManager.getDriver().manage().window().getSize().width;
        int screenHeight = AppiumDriverManager.getDriver().manage().window().getSize().height;
        LOGGER.info("Doing swipe!");
        swipe((int) (startX * screenWidth), (int) (startY * screenHeight), (int) (endX * screenWidth), (int) (endY * screenHeight));
    }


    /**
     * Method to swipe in a specific direction
     *
     * @param direction direction
     */
    public void doSwipe(Direction direction) {
        switch (direction) {
            case UP:
                doSwipe(0.5, 0.9, 0.5, 0.1);
                break;
            case DOWN:
                doSwipe(0.5, 0.5, 0.5, 0.9);
                break;
            case RIGHT:
                doSwipe(0.05, 0.5, 0.95, 0.5);
                break;
            case LEFT:
                doSwipe(0.95, 0.5, 0.05, 0.5);
                break;
            default:
                ExceptionController.hookFail("Invalid direction -> " + direction);

        }
    }
}
