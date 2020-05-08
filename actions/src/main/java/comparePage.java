import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class comparePage {
    private WebDriver driver;

    public comparePage (WebDriver driver) { this.driver=driver;}

    private By listOfElements = By.xpath("//div[contains(@class, 'n-compare-content__line')]/div");
    private By allProperties = By.xpath("//div[contains(@class, 'n-compare-show-controls')]/span[@class='link n-compare-show-controls__all']");
    private By differentProperties = By.xpath("//span[@class='link n-compare-show-controls__diff']/span[@class='link__inner']");

    public int getNumber() {
        int number = driver.findElements(listOfElements).size();
        return number;
    }

    public String getPropertyOsTitle() {
        driver.findElement(allProperties).click();
        String text = driver.findElement(By.xpath("//div[contains(@data-bem, 'Операционная система')]/parent::div")).getText();
        return text;
    }

    public void differences(){
        driver.findElement(differentProperties).click();

    }











    

}
