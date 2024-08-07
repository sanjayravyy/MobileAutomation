package page_objects;

import com.placeholder.exceptions.ExceptionController;
import com.placeholder.managers.AppiumDriverManager;
import interfaces.CommonPageInterface;
import io.appium.java_client.android.AndroidDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import page_objects.commonPage.AndroidCommonPage;

public class PageObjectHelper {

    private static final Logger LOGGER = LoggerFactory.getLogger(PageObjectHelper.class);

    private static final ThreadLocal<CommonPageInterface> commonPageThreadLocal = new ThreadLocal<>();


    public static void setCommonPage(String platform) {
        switch (platform) {
            case "android":
                commonPageThreadLocal.set(new AndroidCommonPage((AndroidDriver) AppiumDriverManager.getDriver()));
                break;
            case "ios":
                ExceptionController.hookFail("Not supported yet");
            default:
                throw new IllegalArgumentException("Unsupported platform: " + platform);
        }
    }

    public CommonPageInterface driverSelector() {
        if (commonPageThreadLocal.get() == null) {
            setCommonPage(CapabilityManager);
        }
    }
}
