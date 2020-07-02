import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static factory.WebDriverFactory.getDriver;


public class LoginPage extends AbstractPage {
    public LoginPage(){
        super();
    }

    WebDriverWait wait = new WebDriverWait(driver, 15);

    Logger loggerLogin = LogManager.getLogger(LoginPage.class);
    Actions action = new Actions(driver);

    //WebElements login pop-up
    @FindBy(css = "input[type='text'].js-email-input")
    WebElement emailField;

    private final By passwordField = By.cssSelector("input[type='password']");
    private final By submitBtn = By.cssSelector("form[action='/login/'] button[type='submit']");
    private final By privateOfficeOption = By.cssSelector("a[href='/learning/']");

    //WebElements mainPage
    @FindBy(css = "button[data-modal-id='new-log-reg'].header2__auth")
    WebElement loginButton;



    //methods

    public void login (String email, String password) {
        loggerLogin.info("Try to login");
        wait.until(ExpectedConditions.visibilityOf(loginButton)).click();
        emailField.sendKeys(email);
        driver.findElement(passwordField).sendKeys(password);
        driver.findElement(submitBtn).click();
        loggerLogin.info("Logged in");
    } //open authorisation pop-up; put email; put password; click on the submit button

    public PrivateOffice getPrivateOffice () {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.header2-menu__item-wrapper__username")));
        action.moveToElement(driver.findElement(By.cssSelector("div.header2-menu__item-wrapper__username"))).click();
        driver.findElement(privateOfficeOption).click();
        loggerLogin.info("PrivateOffice is opened");
        return new PrivateOffice();

    }

    public void getLoginPage (String email, String password) {
        loggerLogin.info("Get login page after refreshing");
        wait.until(ExpectedConditions.visibilityOf(emailField)).sendKeys(email);
        driver.findElement(passwordField).sendKeys(password);
        driver.findElement(submitBtn).click();
    }


}
