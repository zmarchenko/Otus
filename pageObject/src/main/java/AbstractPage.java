import Factory.Browsers;
import config.ServerConfig;
import org.aeonbits.owner.ConfigFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract  class AbstractPage {
    WebDriver driver;
    WebDriverWait wait;
    public ServerConfig config = ConfigFactory.create(ServerConfig.class);
    public AbstractPage (WebDriver driver) {
        this.wait = new WebDriverWait(driver, 15);
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public Logger loggerLogin = LogManager.getLogger(LoginPage.class);
    public Logger loggerPrivatePage = LogManager.getLogger(PrivateOffice.class);





}