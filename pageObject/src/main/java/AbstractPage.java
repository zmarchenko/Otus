import config.ServerConfig;
import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract  class AbstractPage {
    protected WebDriver driver;
    public ServerConfig config = ConfigFactory.create(ServerConfig.class);

    public AbstractPage (WebDriver driver) {
        this.driver = driver;
    }



}