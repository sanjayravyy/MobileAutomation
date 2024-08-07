package com.placeholder.capabilities;

import com.placeholder.managers.PropertiesManager;

public class CapabilityManager {

    private static CapabilityManager instance;

    private final String capabilityPath;

    private CapabilityManager() {
        capabilityPath = getCapabilityLocation();

    }

    /**
     * @return the capability
     */
    private String getCapabilityLocation() {
        // Logic to get the capability location
        return PropertiesManager.getInstance().getProperty(PropertiesManager.Property.CAPS);
    }

    /**
     * @return the capability platform
     */
    public String getPlatform() {
        return System.getenv("PLATFORM").toLowerCase();
    }

    /**
     * @return the capability environment
     */
    public String getEnvironment(){
        return System.getenv("ENVIRONMENT").toLowerCase();
    }

}
