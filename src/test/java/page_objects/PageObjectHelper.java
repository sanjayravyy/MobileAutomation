package page_objects;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import com.placeholder.TestData.config.Configuration;
import com.placeholder.capabilities.CapabilityManager;
import com.placeholder.exceptions.ExceptionController;
import com.placeholder.managers.AppiumDriverManager;
import interfaces.CommonPageInterface;
import io.appium.java_client.android.AndroidDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import page_objects.commonPage.AndroidCommonPage;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class PageObjectHelper {

    private static final Logger LOGGER = LoggerFactory.getLogger(PageObjectHelper.class);

    private static final ThreadLocal<CommonPageInterface> commonPageThreadLocal = new ThreadLocal<>();

    protected static Configuration configuration;


    public static void setCommonPage(String platform) {
        switch (platform) {
            case "android":
                commonPageThreadLocal.set((CommonPageInterface) new AndroidCommonPage((AndroidDriver) AppiumDriverManager.getDriver()));
                break;
            case "ios":
                ExceptionController.hookFail("Not supported yet");
            default:
                throw new IllegalArgumentException("Unsupported platform: " + platform);
        }
    }

    public static CommonPageInterface driverSelector() {
        if (commonPageThreadLocal.get() == null) {
            setCommonPage(CapabilityManager.getInstance().getPlatform());
        }
        return commonPageThreadLocal.get();
    }

    //NOT COMPLETED
    public static void loadConfigFiles() {
        LOGGER.info("Loading config files!");
        try {
            String platform = CapabilityManager.getInstance().getPlatform();

            String environment = System.getenv("ENVIRONMENT").toLowerCase();
            String configFile = "accounts." + platform + "." + environment + ".yml";

            LOGGER.info("Config file: " + configFile);

            Path filePath = Paths.get(System.getProperty("user.dir"), "src", "main", "resources", "accounts", configFile);
            String yamlConfig = Files.readString(filePath);

            ObjectMapper mapper = new ObjectMapper(new YAMLFactory());
            configuration = mapper.readValue(yamlConfig, Configuration.class);

        } catch (IOException e) {
            LOGGER.warn("Failed to load configuration file." + e.getMessage());
            System.exit(1);

        } catch (Exception e) {
            LOGGER.warn("Error parsing YAML configuration." + e.getMessage());
            e.printStackTrace();
        }
    }


}
