package com.placeholder.exceptions;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ExceptionController {

    private static final Logger LOGGER = LoggerFactory.getLogger(ExceptionController.class.getName());

    private static FailAssertion mThrower = null;

    /**
     * @param thrower the thrower to use
     */
    public static void regHookFail(FailAssertion thrower) {
        mThrower = thrower;
    }

    /**
     * @param message the message to fail with
     */
    public static void hookFail(String message) {
        LOGGER.warn(message);
        mThrower.fail(message + "\n Failed.");
    }

    /**
     * @param message the message to fail with
     * @param error   the error to fail with
     */
    public static void hookFail(String message, Exception error) {
        hookFail(message + "\n" + error.getMessage());
    }

}
