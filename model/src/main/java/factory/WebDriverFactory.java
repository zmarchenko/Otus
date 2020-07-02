package factory;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

public class WebDriverFactory {
    public static Options options = new Options();

    public static WebDriver getDriver(Browsers browser){
    switch (browser) {
        case FIREFOX:
            WebDriverManager.firefoxdriver().setup();
            return new FirefoxDriver();

        case EDGE:
            WebDriverManager.edgedriver().setup();
            return new EdgeDriver();

        case CHROME:
            WebDriverManager.chromedriver().setup();
            return new ChromeDriver();

        default: WebDriverManager.operadriver().setup(); return new OperaDriver();
    }
}


   /*public static WebDriver getDriver(Browsers browsers, DesiredCapabilities desiredCapabilities){
        desiredCapabilities = options.getCaps();

        switch (browsers) {
            case FIREFOX:
                WebDriverManager.firefoxdriver().setup();
                return new FirefoxDriver(desiredCapabilities);

            case EDGE:
                WebDriverManager.edgedriver().setup();
                return new EdgeDriver(desiredCapabilities);

            case CHROME:
                WebDriverManager.chromedriver().setup();
                return new ChromeDriver(desiredCapabilities);

            default: WebDriverManager.operadriver().setup(); return new OperaDriver(desiredCapabilities);
        }
    }*/






}


