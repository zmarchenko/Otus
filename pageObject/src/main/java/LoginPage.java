import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class LoginPage extends AbstractPage {
    Actions action = new Actions(driver);
    //URLs
    public String URL = config.otus();

    //Ñredentials
    private String email = "doib3vmani.com";
    private String password = "password";


    //WebElements login pop-up
    private By  emailField = By.cssSelector("input[type='text'].js-email-input");
    private By passwordField = By.cssSelector("input[type='password']");
    private By submitBtn = By.cssSelector("form[action='/login/'] button[type='submit']");

    //WebElements mainPage
    private By loginButton = By.cssSelector("button[data-modal-id='new-log-reg'].header2__auth");
    private By menuDropdown = By.cssSelector("div.header2-menu__item-wrapper__username");
    private By privateOfficeOption = By.cssSelector("a[href='/learning/']");

    //driver
    public LoginPage(WebDriver driver) {
        super(driver);
    }

    //methods

    public void login (String email, String password) {
        driver.findElement(loginButton).click();
        driver.findElement(emailField).sendKeys(email);
        driver.findElement(passwordField).sendKeys(password);
        driver.findElement(submitBtn).click();
    } //open authorisation pop-up; put email; put password; click on the submit button

    public PrivateOffice getPrivateOffice () {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.header2-menu__item-wrapper__username")));
        action.moveToElement(driver.findElement(By.cssSelector("div.header2-menu__item-wrapper__username"))).click();
        driver.findElement(privateOfficeOption).click();
        return new PrivateOffice(driver);
    }


}
