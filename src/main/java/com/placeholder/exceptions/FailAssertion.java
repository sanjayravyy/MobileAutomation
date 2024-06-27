package com.placeholder.exceptions;

@FunctionalInterface
public interface FailAssertion {

    /**
     *
     * @param message the message to fail with
     */
    void fail(String message);
}
