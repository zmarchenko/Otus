import config.ServerConfig;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.aeonbits.owner.ConfigFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

@TestInstance(TestInstance.Lifecycle.PER_METHOD)

public class OtusTest {
    private WebDriver driver;
    private Logger logger = LogManager.getLogger(OtusTest.class);
    private ServerConfig cfg = ConfigFactory.create(ServerConfig.class);
    mobilesTab mb;





@BeforeEach
public void setUp() {
    WebDriverManager.chromedriver().setup();
    driver = new ChromeDriver();
    driver.manage().window().maximize();
    logger.info("Driver is set up");
     mb = new mobilesTab(driver);
}

@AfterEach
public void tearDown(){
    if (driver != null) {
        driver.quit();
    }
}

@Test
public void openYandex(){
    driver.get(cfg.yandex());
    logger.info("Start page is opened");
    mb.goMobilesPage();
    logger.info("Mobile catalog is opened");
    filtersPage fp = mb.openFilters();
    logger.info("Filter page is opened");
    fp.useFilterXiaomi();
    fp.openProductsTab();
    logger.info("Products Tab is opened ");
    fp.useFilterRedmi();
    logger.info("Filter Xiaomi is used");
}


}
