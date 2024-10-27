package com.placeholder.Devices;

public class AppiumDevice {

    private static final String AVAILABLE = "AVAILABLE";

    private String deviceState;

    private int chromeDriverPort;

    private boolean prodInstalled;


    public AppiumDevice() {
        deviceState = AVAILABLE;
        chromeDriverPort = 0;
        prodInstalled = false;
    }
}
