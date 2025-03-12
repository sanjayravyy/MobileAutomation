package page_objects.loginPage;

import org.openqa.selenium.WebElement;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidBy;
import io.appium.java_client.pagefactory.AndroidFindBy;
import page_objects.commonPage.AndroidCommonPage;

public class AndroidLoginPage extends AndroidCommonPage {

    @AndroidFindBy(id = "loginTextFieldId")
    private WebElement loginEmailTextField;

    @AndroidBy(id = "loginPassTextField")
    private WebElement loginPasswordTextField;

    @AndroidFindBy(accessibility = "App")
    public WebElement appButton;

    public AndroidLoginPage(AndroidDriver driver) {
        super(driver);
    }

    public void clickElement(WebElement element) {
        androidHelper.tap(element);
    }
}
