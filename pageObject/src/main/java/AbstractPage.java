import factory.Browsers;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import static factory.Enviroment.getEnv;
import static factory.WebDriverFactory.getDriver;

 public abstract  class AbstractPage {
    protected WebDriver driver;

    public AbstractPage() {
        Browsers browser = getEnv();
        this.driver = getDriver(browser);
    }

    Logger loggerPrivatePage = LogManager.getLogger(PrivateOffice.class);



}