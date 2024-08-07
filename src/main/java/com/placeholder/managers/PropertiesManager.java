package com.placeholder.managers;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Properties;

public class PropertiesManager {

    private static PropertiesManager instance;

    private final Properties properties;


    /*
     * Constructor to load the properties file based on the environment variable ENVIRONMENT (e.g., staging, qa, prod)
     */
    public PropertiesManager() {
        properties = new Properties();
        String propertyFile = System.getenv("ENVIRONMENT").toLowerCase() + ".properties";
        try {
            properties.load(Files.newInputStream(Paths.get(propertyFile)));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /*
     * Singleton pattern implementation to ensure only one instance of the class exists
     */
    public static PropertiesManager getInstance() {
        if (instance == null) {
            instance = new PropertiesManager();
        }
        return instance;
    }

    /*
     * Method to retrieve property values based on their keys
     */
    public String getProperty(Property key) {
        return properties.getProperty(key.getValue());
    }

    /**
     *
     * @param key the key
     * @return the property
     */
    public String getProperty(String key) {
        return properties.getProperty(key);
    }

    /**
     *
     * @param key the key
     * @param value the property
     */
    public void setProperty(String key, String value) {
        properties.setProperty(key, value);
    }

    /**
     * The enum property
     */
    public enum Property {
        CAPS;

        private final String property;

        /**
         * Instantiates a new property
         */
        Property() {
            property = this.toString();
        }

        /**
         * Gets the value.
         *
         * @return the value
         */
        public String getValue() {
            return property;
        }

    }
}
