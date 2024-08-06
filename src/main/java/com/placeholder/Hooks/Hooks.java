package com.placeholder.Hooks;

import com.placeholder.managers.ScenarioManager;
import io.cucumber.java.AfterAll;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.Scenario;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Hooks {

    private static final Logger LOGGER = LoggerFactory.getLogger(Hooks.class.getName());

    @BeforeAll
    public static void setUpClass() {
        LOGGER.info("Setting up the Appium Driver...");
        LOGGER.info("-------------------------------- Execution Start -------------------------------- ");
    }

    @AfterAll
    public static void tearDownClass() {
        LOGGER.info("-------------------------------- Execution End -------------------------------- ");
        LOGGER.info("Tearing down the Appium Driver...");
    }

    @Before
    public void beforeScenario(Scenario scenario) {
        LOGGER.info("\n-------------------------------- Scenario Start --------------------------------\n");
        LOGGER.info("\n******* Scenario: {} started! *******\n", scenario.getName());
        ScenarioManager.getScenario(scenario);
        LOGGER.info("Starting appium server instance...");

    }
}
