import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;



public class PrivateOffice extends AbstractPage{

    //WebElements
    @FindBy(css = "input[id = 'id_fname']")
    WebElement nameField;

    @FindBy(css = "input[id = 'id_fname_latin']")
    WebElement latinNameField;

    @FindBy(css = "input[id = 'id_lname']")
    WebElement surnameField;

    @FindBy(css = "input[id = 'id_lname_latin']")
    WebElement latinSurnameField;

    @FindBy(css = "input[id = 'id_blog_name']")
    WebElement blogNameField;

    @FindBy (css = "input[name = 'date_of_birth']")
    WebElement birthdayField;

    @FindBy (css = "button[name = 'continue']")
    WebElement saveBtn;

    private final By personal = By.cssSelector("div.title+div.nav a[href='/lk/biography/personal/']");

    public PrivateOffice() {
        super(driver, wait);
    }


    //Methods
    public void getPersonalInfoForm(){
        loggerPrivatePage.info("etPersonalInfoForm");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.header2-menu__item-wrapper__username")));
        driver.findElement(personal).click();
    }

    public void setPersonal (String name, String latinName, String surname, String latinSurname, String blogName, String birthday){
        loggerPrivatePage.info("setPersonnal started");
        nameField.clear();
        nameField.sendKeys(name);
        latinNameField.clear();
        latinNameField.sendKeys(latinName);
        surnameField.clear();
        surnameField.sendKeys(surname);
        latinSurnameField.clear();
        latinSurnameField.sendKeys(latinSurname);
        blogNameField.clear();
        blogNameField.sendKeys(blogName);
        birthdayField.clear();
        birthdayField.sendKeys(birthday);
        saveBtn.click();

    }

    public String getPersonal(String value){
        loggerPrivatePage.info("getPersonal started");
        String field;
        switch (value) {
            case ("nameField"):
                field = wait.until(ExpectedConditions.visibilityOf(nameField)).getAttribute("value");
                break;
            case ("latinNameField"):
                field = latinNameField.getAttribute("value");
                break;
            case ("surnameField"):
                field = surnameField.getAttribute("value");
                break;
            case ("latinSurnameField"):
                field = latinSurnameField.getAttribute("value");
                break;
            case ("blogNameField"):
                field = blogNameField.getAttribute("value");
                break;
            case ("birthdayField"):
                field = birthdayField.getAttribute("value");
                break;
            default:
                loggerPrivatePage.error("WebElement is not found");
                throw new IllegalStateException("Unexpected value: " + value);
        }
        return field;

    }













}
