import config.ServerConfig;
import org.aeonbits.owner.ConfigFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import java.util.concurrent.TimeUnit;

public class BaseHooks {
    WebDriver driver;
    ServerConfig cfg = ConfigFactory.create(ServerConfig.class);
    public Logger logger = LogManager.getLogger(OtusTest.class);//for logs


    @BeforeEach
    public void setup() {

        driver.get(cfg.otus());
        logger.info("Driver is set up");
        logger.info("Open start page" + " " + cfg.otus());

        if (driver != null) {
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        }
    }

    @AfterEach
    public void teardown() {
        if (driver != null) {
            driver.quit();
        }
    }

    public void cleanAndRefresh(){
        driver.manage().deleteAllCookies();
        logger.info("Cookies were deleted");
        driver.navigate().refresh();
        logger.info("Page refreshed");
    }
}