import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class filtersPage {
    private WebDriver driver;

    public filtersPage(WebDriver driver) { this.driver=driver;}

    private By showResultsButton =By.xpath("//a[@class='button button_size_l button_theme_pseudo i-bem button_action_show-filtered n-filter-panel-extend__controll-button_size_big button_js_inited']");

    public void useFilterXiaomi() {
        WebElement checkboxXiaomi = (new WebDriverWait(driver, 10))
                .until(ExpectedConditions.elementToBeClickable(By.xpath("//label[@for='glf-7893318-7701962']")));
        checkboxXiaomi.click();

    }

    public mobilesTab useFilterRedmi() {
        WebElement checkboxRedmi = (new WebDriverWait(driver, 10))
                .until(ExpectedConditions.elementToBeClickable(By.xpath("//label[@for='glf-12782797-14357428']")));
        checkboxRedmi.click();
        driver.findElement(showResultsButton).click();
        return new mobilesTab(driver);
    }

    public void openProductsTab(){
        WebElement productLinesTab = (new WebDriverWait(driver, 10))
                .until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@data-filter-id='12782797']")));
        productLinesTab.click();
    }




}
