package factory;

import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

public class Options {

    DesiredCapabilities caps = new DesiredCapabilities();
    ChromeOptions chromeOptions = new ChromeOptions();

    public ChromeOptions getChromeOptions() {
        chromeOptions.addArguments("start-maximized");
        return chromeOptions;
    }

    public DesiredCapabilities getCaps() {
        caps.setCapability("UnexpectedAlertBehaviour", "accept");
        caps.setCapability(ChromeOptions.CAPABILITY, getChromeOptions());
        return caps;
    }




}
// DesiredCapabilities caps = new DesiredCapabilities();/*Capabilities to set up a browser
// caps.setCapability("UnexpectedAlertBehaviour", "accept");//Each capability requires it's own particular method
// ChromeOptions opt = new ChromeOptions();//to choose options
// opt.addArguments("start-fullscreen");
// WebDriverManager.chromedriver().setup();
// driver = new ChromeDriver(caps);//set settings
// caps.setCapability(ChromeOptions.CAPABILITY, opt);// post options using сapability
//