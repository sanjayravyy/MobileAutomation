package page_objects.commonPage;

import com.placeholder.utils.AndroidHelper;
import com.placeholder.utils.Waits;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Duration;

public class AndroidCommonPage {

    protected static final Logger LOGGER = LoggerFactory.getLogger(AndroidCommonPage.class.getName());

    protected AndroidDriver driver;

    protected Actions action;

    protected AndroidHelper androidHelper;

    protected Waits waits;

    public AndroidCommonPage(AndroidDriver driver) {
        try {
            this.driver = driver;
            PageFactory.initElements(new AppiumFieldDecorator(driver, Duration.ofSeconds(10)), this);
            action = new Actions(driver);
            androidHelper = new AndroidHelper();
            waits = new Waits();
        } catch (Exception e) {
            LOGGER.warn("Error initializing class {}", getClass().getSimpleName(), e);
        }
        LOGGER.info("Initializing {} for session:{}", getClass().getSimpleName(), driver.getSessionId());
    }
}
