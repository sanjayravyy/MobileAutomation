package com.placeholder.TestData.config;

public final class TestConstants {

    public enum Groups {
        SANJAY_TEST("sanjay_test");

        private final String group;

        Groups(String group) {
            this.group = group;
        }

        public String getValue() {
            return group;
        }
    }
}
