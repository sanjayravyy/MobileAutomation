package com.placeholder.managers;

import io.cucumber.java.Scenario;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public final class ScenarioManager {

    private static final ThreadLocal<Scenario> currentScenario = new ThreadLocal<>();

    private static final Logger LOGGER = LoggerFactory.getLogger(ScenarioManager.class.getName());

    private static ScenarioManager instance;

    private ScenarioManager() {
    }

    /**
     * @return the instance
     */
    public static ScenarioManager getInstance() {
        if (instance == null) {
            synchronized (ScenarioManager.class) {
                instance = new ScenarioManager();
            }
        }
        return instance;
    }

    /**
     * Return scenario manager instance
     */
    public static Scenario getScenario() {
        return currentScenario.get();
    }

    public static void setScenario(Scenario scenario) {
        currentScenario.set(scenario);
        LOGGER.info("Set current scenario: {}", scenario.getName());
    }
}
