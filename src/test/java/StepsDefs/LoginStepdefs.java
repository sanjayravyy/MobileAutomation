package StepsDefs;

import com.placeholder.TestData.config.Account;
import com.placeholder.TestData.config.TestConstants;
import interfaces.LoginPageInterface;
import io.cucumber.java8.En;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import page_objects.PageObjectHelper;

public class LoginStepdefs extends PageObjectHelper implements En {

    private static final Logger LOGGER = LoggerFactory.getLogger(LoginStepdefs.class.getName());

    public LoginStepdefs() {

        Given("^I enter email address of ([A-Z_]+)$", (TestConstants.Groups account) -> {

            LOGGER.info("Entering email address of account: {}", account);
            Account loginAccount = configuration.users.getUser(account.getValue());

            //Getting email address
            String email = loginAccount.getEmail();

            //Entering email address on login page
            LoginPageInterface loginView = driverSelector().initLoginPageView();
            loginView.enterUsername(email);
        });

    }
}
