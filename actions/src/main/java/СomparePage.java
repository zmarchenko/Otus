import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class СomparePage {
    private WebDriver driver;

    public СomparePage(WebDriver driver) { this.driver=driver;}

    private By listOfElements = By.xpath("//div[contains(@class, 'n-compare-content__line')]/div");
    private By allProperties = By.xpath("//div[contains(@class, 'n-compare-show-controls')]/span[@class='link n-compare-show-controls__all']");
    private By differentProperties = By.xpath("//span[@class='link n-compare-show-controls__diff']/span[@class='link__inner']");

    public int getNumber() {
        int number = driver.findElements(listOfElements).size();
        return number;
    }

    public String getPropertyTitle() {
        driver.findElement(allProperties).click();
        WebElement operationSystem = (new WebDriverWait(driver,10).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@data-bem, 'Операционная система')]/parent::div"))));
        String text = operationSystem.getText();
        return text;
    }

    public Boolean differences(){
        driver.findElement(differentProperties).click();
        Boolean operationSystemVisibility = (new WebDriverWait(driver,10).until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[contains(@data-bem, 'Операционная система')]/parent::div"))));
        return operationSystemVisibility;
    }











    

}
