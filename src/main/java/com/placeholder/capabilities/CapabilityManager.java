package com.placeholder.capabilities;

import com.placeholder.managers.PropertiesManager;
import com.placeholder.utils.JsonParser;
import org.json.JSONArray;
import org.json.JSONObject;

public class CapabilityManager {

    private static CapabilityManager instance;

    private final String capabilityPath;

    private final JSONObject capabiliies;

    private CapabilityManager() {
        capabilityPath = getCapabilityLocation();
        com.placeholder.utils.JsonParser jsonParser = new JsonParser(capabilityPath);
        capabiliies = jsonParser.getObjectFromJSON();


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
    public String getEnvironment() {
        return System.getenv("ENVIRONMENT").toLowerCase();
    }

    public boolean isAndroid() {
        return getPlatform().equals("android");
    }

    /**
     * @param key the capability key
     * @return the capability
     */
    public JSONObject getCapabilityObjectFromKey(String key) {
        boolean hasKey = capabiliies.has(key);
        if (hasKey) {
            return (JSONObject) capabiliies.get(key);
        }
        return null;
    }

    /**
     * @param key the capability key
     * @return the capability
     */
    public JSONArray getCapabilityArrayFromKey(String key) {
        return capabiliies.getJSONArray(key);
    }

    /**
     * @return app path
     */
    public String appPath() {
        return System.getProperty("user.dir") + "/demoApp.apk";
    }

    public static CapabilityManager getInstance() {
        if (instance == null) {
            instance = new CapabilityManager();
        }
        return instance;
    }
}
