import Factory.Browsers;
import config.ServerConfig;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.aeonbits.owner.ConfigFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import java.util.concurrent.TimeUnit;

public class BaseHooks {

    WebDriver driver;
    ServerConfig cfg = ConfigFactory.create(ServerConfig.class);
    public Logger logger = LogManager.getLogger(OtusTest.class);//for logs



    @BeforeEach
    public void setup() {
       // DesiredCapabilities caps = new DesiredCapabilities();/*Capabilities to set up a browser

        //caps.setCapability("UnexpectedAlertBehaviour", "accept");//Each capability requires it's own particular method
        //ChromeOptions opt = new ChromeOptions();//to choose options
       // opt.addArguments("start-fullscreen");
        //WebDriverManager.chromedriver().setup();
        //driver = new ChromeDriver(caps);//set settings
        //caps.setCapability(ChromeOptions.CAPABILITY, opt);// post options using сapability
        WebDriver driver = Browsers.CHROME.create();
        driver.get(cfg.otus());
        logger.info("Driver is set up");
        logger.info("Open start page" + cfg.otus());

        if (driver != null) {
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            driver.manage().window().maximize();
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