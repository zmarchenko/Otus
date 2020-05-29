import config.ServerConfig;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.aeonbits.owner.ConfigFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

@TestInstance(TestInstance.Lifecycle.PER_METHOD)

public class OtusTest {
    private WebDriver driver;
    private Logger logger = LogManager.getLogger(OtusTest.class);
    private ServerConfig cfg = ConfigFactory.create(ServerConfig.class);
    MobilesTab mb;

@BeforeEach
public void setUp() {
    DesiredCapabilities caps = new DesiredCapabilities();/*возможности запуска браузера
     */
    caps.setCapability("UnexpectedAlertBehaviour", "accept");//на каждую сapability отдельный метод
    ChromeOptions opt = new ChromeOptions();//тут можно опции повыбирать
    opt.addArguments("start-fullscreen");
    WebDriverManager.chromedriver().setup();
    driver = new ChromeDriver(caps);//в браузер передаются настройки
    caps.setCapability(ChromeOptions.CAPABILITY, opt);//этот метод позволяет передавать опции через сapability
    driver.manage().window().maximize();
    mb = new MobilesTab(driver);
}

@AfterEach
public void tearDown(){
    if (driver != null) {
        driver.quit();
    }
}

@Test
public void openYandex() {
    driver.get(cfg.yandex());
    logger.info("Start page is opened");
    mb.goMobilesPage();
    logger.info("Mobile catalog is opened");
}


}
