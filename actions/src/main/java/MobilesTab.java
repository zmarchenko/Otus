import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class MobilesTab {
    private WebDriver driver;

    public MobilesTab(WebDriver driver) { this.driver=driver;}


    private By sortByPrice = By.xpath("//a[@class='link link_theme_major n-filter-sorter__link i-bem link_js_inited' and text()='ïî öåíå']");

    public FiltersPage openFilters(){
        WebElement allFilterButton = (new WebDriverWait(driver,10)).until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@data-zone-name='all-filters-button']/div/a")));
        allFilterButton.click();
        return new FiltersPage(driver);
    }

    public void priceSorting(){
        driver.findElement(sortByPrice).click();
    }

    public String addFirstItemToCompare(){
        Actions actions = new Actions(driver);
        WebDriverWait webDriverWait = new WebDriverWait(driver,10);
        WebElement firstItemBlock = webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@class, 'n-filter-applied-results__content')]/div[contains(@class, 'n-snippet-list')]/div[1]")));
        actions.moveToElement(firstItemBlock).build().perform();
        WebElement addToCompareButton = webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains (@class, 'n-snippet-list_type_grid')]/div[1]//div[contains (@class, 'n-user-lists_type_compare')]")));
        addToCompareButton.click();
        WebElement notificationTitle = webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='popup-informer__pane popup-informer__pane_type_notify']//div[@class='popup-informer__title']")));
        String notification = notificationTitle.getText();
        return  notification;
    }

    public String addSecondItemToCompare(){
        Actions actions = new Actions(driver);
        WebDriverWait webDriverWait = new WebDriverWait(driver,10);
        WebElement firstItemBlock = webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@class, 'n-filter-applied-results__content')]/div[contains(@class, 'n-snippet-list')]/div[2]")));
        actions.moveToElement(firstItemBlock).build().perform();
        WebElement addToCompareButton = webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains (@class, 'n-snippet-list_type_grid')]/div[2]//div[contains (@class, 'n-user-lists_type_compare')]")));
        addToCompareButton.click();
        WebElement notificationTitle = webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='popup-informer__pane popup-informer__pane_type_notify']//div[@class='popup-informer__title']")));
        String notification = notificationTitle.getText();
        return  notification;
    }

    public ÑomparePage goToCompare(){
        WebElement goToCompareButton = (new WebDriverWait(driver,10).until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='popup-informer__pane popup-informer__pane_type_notify']//a[@href='/compare?track=rmmbr']"))));
        goToCompareButton.click();
        return new ÑomparePage(driver);
    }

    public void goMobilesPage(){
        WebDriverWait webDriverWait = new WebDriverWait(driver,10);
        WebElement popup = webDriverWait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div [@class='popup2__content']")));
        popup.click();
        WebElement getMobiles = webDriverWait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@href='/catalog--elektronika/54440']")));
        getMobiles.click();
        WebElement mobilePhones = webDriverWait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(@href, '/catalog--mobilnye-telefony')]")));
        mobilePhones.click();

    }




}
