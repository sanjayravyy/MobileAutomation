package StepsDefs;

import interfaces.LoginPageInterface;
import io.cucumber.java.en.Given;
import io.cucumber.java8.En;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import page_objects.PageObjectHelper;

public class LoginStepdefs extends PageObjectHelper implements En {

    public static final Logger LOGGER = LoggerFactory.getLogger(LoginStepdefs.class.getName());

    public LoginStepdefs() {


        @Given("^I enter email address as (.*)$", (String email) -> {
            LOGGER.info("Entering email address: {}", email);
            LoginPageInterface loginView = driverSelector().getLoginView();

        })
    }
}
