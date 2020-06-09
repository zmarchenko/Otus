import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.HashMap;



public class PrivateOffice extends AbstractPage{
    public PrivateOffice(WebDriver driver) {
        super(driver);
    }

    //Variables
    String firstName = "fname";
    String lastName = "lname";
    String lFirstName = "fname_latin";
    String lLastName = "lname_latin";
    String blogName = "blog_name";

    //WebElements
    private By personal = By.cssSelector("div.title+div.nav a[href='/lk/biography/personal/']");
    private By nameField = By.cssSelector("");
    private By latinNameField = By.cssSelector("");
    private By surnameField = By.cssSelector("");
    private By latinSurnameField = By.cssSelector("");
    private By blogNameField = By.cssSelector("");
    private By birthdayField = By.cssSelector("");
    private By photo = By.cssSelector("");
    private By saveBtn = By.cssSelector("");




    //Methods
    public void getPersonalInfoForm(){
        driver.findElement(personal).click();
    }

    public void setPersonal (String name, String latinName, String surname, String latinSurname, String blogName, String birthday){
        driver.findElement(nameField)
                .clear();
        driver.findElement(nameField)
                .sendKeys(name);
        driver.findElement(latinNameField).sendKeys(latinName);
        driver.findElement(surnameField).sendKeys(surname);
        driver.findElement(latinSurnameField).sendKeys(latinSurname);
        driver.findElement(blogNameField).clear();
        driver.findElement(blogNameField).sendKeys(blogName);
        driver.findElement(birthdayField).sendKeys(birthday);
        driver.findElement(saveBtn).click();

    }













}
