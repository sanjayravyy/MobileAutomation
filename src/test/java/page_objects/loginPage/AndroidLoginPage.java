package page_objects.loginPage;

import interfaces.LoginPageInterface;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidBy;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;
import page_objects.commonPage.AndroidCommonPage;

public class AndroidLoginPage extends AndroidCommonPage implements LoginPageInterface {

    @AndroidFindBy(id = "loginTextFieldId")
    private WebElement loginEmailTextField;

    @AndroidBy(id = "loginPassTextField")
    private WebElement loginPasswordTextField;

    public AndroidLoginPage(AndroidDriver driver) {
        super(driver);
    }

    @Override
    public void enterUsername(String username) {
        LOGGER.info("Entering username");
        loginEmailTextField.sendKeys(username);
    }
}
