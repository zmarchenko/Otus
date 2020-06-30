package Factory;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public enum Browsers {

    CHROME {
        public WebDriver create(){
            WebDriverManager.chromedriver().setup();
            return new ChromeDriver();
        }
    },
    IE {
        public WebDriver create(){
            WebDriverManager.edgedriver().setup();
            return new EdgeDriver();
        }
    },
    FIREFOX {
        public WebDriver create() {
            WebDriverManager.firefoxdriver().setup();
            return new FirefoxDriver();
        }
    };

    public WebDriver create(){
        return null;
    }
}



