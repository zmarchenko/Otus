
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class PrivateOffice extends AbstractPage{
    public PrivateOffice(WebDriver driver) {
        super(driver);
    }
    WebDriverWait wait = new WebDriverWait(driver, 5);



    //WebElements
    @FindBy(css = "input[id = 'id_fname']")
    WebElement nameField;




    private By personal = By.cssSelector("div.title+div.nav a[href='/lk/biography/personal/']");
    // private By nameField = By.cssSelector("input[id = 'id_fname']");
    private By latinNameField = By.cssSelector("input[id = 'id_fname_latin']");
    private By surnameField = By.cssSelector("input[id = 'id_lname']");
    private By latinSurnameField = By.cssSelector("input[id = 'id_lname_latin']");
    private By blogNameField = By.cssSelector("input[id = 'id_blog_name']");
    private By birthdayField = By.cssSelector("input[name = 'date_of_birth']");
    private By saveBtn = By.cssSelector("button[name = 'continue']");




    //Methods
    public void getPersonalInfoForm(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.header2-menu__item-wrapper__username")));
        driver.findElement(personal).click();
    }

    public void setPersonal (String name, String latinName, String surname, String latinSurname, String blogName, String birthday){
        nameField.clear();
        nameField.sendKeys(name);
        driver.findElement(latinNameField).clear();
        driver.findElement(latinNameField).sendKeys(latinName);
        driver.findElement(surnameField).clear();
        driver.findElement(surnameField).sendKeys(surname);
        driver.findElement(latinSurnameField).clear();
        driver.findElement(latinSurnameField).sendKeys(latinSurname);
        driver.findElement(blogNameField).clear();
        driver.findElement(blogNameField).sendKeys(blogName);
        driver.findElement(birthdayField).clear();
        driver.findElement(birthdayField).sendKeys(birthday);
        driver.findElement(saveBtn).click();

    }

    public String getPersonal(String value){
        String field;
        switch (value) {
            case ("nameField"):
                field = wait.until(ExpectedConditions.visibilityOf(nameField)).getAttribute("value");
                break;
            case ("latinNameField"):
                field = driver.findElement(latinNameField).getText();
                break;
            case ("surnameField"):
                field = driver.findElement(surnameField).getText();
                break;
            case ("latinSurnameField"):
                field = driver.findElement(latinSurnameField).getText();
                break;
            case ("blogNameField"):
                field = driver.findElement(blogNameField).getText();
                break;
            case ("birthdayField"):
                field = driver.findElement(birthdayField).getText();
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + value);
        }
        return field;

    }













}
