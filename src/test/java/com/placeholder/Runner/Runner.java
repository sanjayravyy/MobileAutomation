package com.placeholder.Runner;

import com.placeholder.Hooks.Hooks;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RunWith(Cucumber.class)
@CucumberOptions(
        glue = {"StepsDefs"},
        features = {"src/test/resources"},
        plugin = {"pretty", "json:target/cucumber.json"},
        monochrome = true,
        dryRun = false,
        tags = "@test"// Add your tags here to run specific scenarios or features.
)

public class Runner extends Hooks {

    private static final Logger LOGGER = LoggerFactory.getLogger(Runner.class);

}
