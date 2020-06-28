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


@BeforeEach
public void setUp() {
    DesiredCapabilities caps = new DesiredCapabilities();/*âîçìîæíîñòè çàïóñêà áðàóçåðà
     */
    caps.setCapability("UnexpectedAlertBehaviour", "accept");//íà êàæäóþ ñapability îòäåëüíûé ìåòîä
    ChromeOptions opt = new ChromeOptions();//òóò ìîæíî îïöèè ïîâûáèðàòü
    opt.addArguments("start-fullscreen");
    WebDriverManager.chromedriver().setup();
    driver = new ChromeDriver(caps);//â áðàóçåð ïåðåäàþòñÿ íàñòðîéêè
    caps.setCapability(ChromeOptions.CAPABILITY, opt);//ýòîò ìåòîä ïîçâîëÿåò ïåðåäàâàòü îïöèè ÷åðåç ñapability
    driver.manage().window().maximize();
    driver.get(cfg.otus());

}

@AfterEach
public void tearDown(){
    if (driver != null) {
        driver.quit();
    }
}

@Test
    public void testLogin(){
    LoginPage loginPage = new LoginPage(driver);
    loginPage.login("email", "password");
    PrivateOffice privateOffice = loginPage.getPrivateOffice();
    privateOffice.getPersonalInfoForm();
    privateOffice.setPersonal("Ftest", "LFtest", "Ltest", "LLTest", "OMG", "26.02.1992");
}



}
