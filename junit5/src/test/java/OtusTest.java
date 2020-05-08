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
    MobilesTab mb;

@BeforeEach
public void setUp() {
    WebDriverManager.chromedriver().setup();
    driver = new ChromeDriver();
    driver.manage().window().maximize();
    logger.info("Driver is set up");
     mb = new MobilesTab(driver);
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
    FiltersPage fp = mb.openFilters();
    logger.info("Filter page is opened. FiltersPage Class used");
    fp.useFilterXiaomi();
    logger.info("Filter Xiaomi is used");
    fp.useFilterRedmi();
    logger.info("Filter Redmi is used");
    fp.getFilteredResults();
    logger.info("Results are filtered. The user is redirected to the Mobile catalog. MobileTab Class used");
    mb.priceSorting();
    logger.info("Elements are sorted by price");
    String firstTitle = mb.addFirstItemToCompare();
    logger.info(firstTitle);
    String secondTitle = mb.addSecondItemToCompare();
    logger.info(secondTitle);
    —omparePage cp = mb.goToCompare();
    logger.info("Compare page is opened. ComparePage Class used");
    int number = cp.getNumber();
    Assertions.assertEquals(2, number);
    logger.info("The number of elements is " + number);
    String property = cp.getPropertyTitle();
    Assertions.assertEquals("Œœ≈–¿÷»ŒÕÕ¿ﬂ —»—“≈Ã¿", property);
    logger.info(property);
    Boolean visibility = cp.differences();
    Assertions.assertEquals(true, visibility);
}


}
