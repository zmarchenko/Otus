import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class mobilesTab {
    private WebDriver driver;

    public mobilesTab(WebDriver driver) { this.driver=driver;}


    private By sortByPrice = By.xpath("//a[@class='link link_theme_major n-filter-sorter__link i-bem link_js_inited' and text()='по цене']");
    private By firstItem = By.xpath("//div[contains (@class, 'n-snippet-list_type_grid')]/div[1]");
    private By addToCompareButton = By.xpath("//div[contains (@class, 'n-snippet-list_type_grid')]/div[1]//div[contains (@class, 'n-user-lists_type_compare')]");
    private By notificationTitle = By.xpath("//div[@class='popup-informer__pane popup-informer__pane_type_notify']//div[@class='popup-informer__title']");
    private By addToCompareButton2 = By.xpath("//div[contains (@class, 'n-snippet-list_type_grid')]/div[2]//div[contains (@class, 'n-user-lists_type_compare')]");
    private By goToCompareButton = By.xpath("//div[@class='popup-informer__pane popup-informer__pane_type_notify']//a[@href='/compare?track=rmmbr']");



    public filtersPage openFilters(){
        WebElement allFilterButton = (new WebDriverWait(driver,10)).until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@data-zone-name='all-filters-button']/div/a")));
        allFilterButton.click();
        return new filtersPage(driver);
    }

    public void priceSorting(){
        driver.findElement(sortByPrice).click();
    }

    public String addFirstItemToCompare(){
        driver.findElement(addToCompareButton).click();
        String titleCompare = driver.findElement(notificationTitle).getText();
        return titleCompare;
    }

    public String addSecondItemToCompare(){
        driver.findElement(addToCompareButton2).click();
        String titleCompare = driver.findElement(notificationTitle).getText();
        return titleCompare;
    }

    public comparePage goToCompare(){
        driver.findElement(goToCompareButton).click();
        return new comparePage(driver);
    }

    public void goMobilesPage(){
        WebElement popup = (new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(By.xpath("//div [@class='popup2__content']"))));
        popup.click();
        WebElement getMobiles = (new WebDriverWait(driver, 10)).until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@href='/catalog--elektronika/54440']")));
        getMobiles.click();
        WebElement mobilePhones = (new WebDriverWait(driver, 10)).until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(@href, '/catalog--mobilnye-telefony-v-')]")));
        mobilePhones.click();

    }




}
