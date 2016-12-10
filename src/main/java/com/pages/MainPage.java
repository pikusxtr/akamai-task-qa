package com.pages;

import com.data.Locations;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.util.List;

public class MainPage extends AbstractPage {

    //private static final int TIMEOUT = 7;
    private List<WebElement> searchResultsList;

    @FindBy(id = "keyword")
    private WebElement searchByKeywordText;

    @FindBy(id = "loc_placeholder")
    private WebElement locationsField;

    @FindBy(id = "jSearchSubmit")
    private WebElement searchBtn;

    private By locationTextInput = By.cssSelector("div#location_facet_chzn input.default");
    private By searchFinished = By.cssSelector("div#jPaginationHldr");
    private By searchResultsItemsLocator =
            By.cssSelector("div#jobs_filters_area > div#job_results_list_hldr > div[id^='job_list_']");

    private By pageVisible =
            By.cssSelector("div#job_results_list_hldr, div#job_no_results_list_hldr");
    private By textToGetFromLocation = By.cssSelector("ul.chzn-results > li.active-result");

    private String url;

    public MainPage(WebDriver driver, String url) {
        super(driver);
        this.url = url;
        PageFactory.initElements(driver, this);
        open();

    }

    public MainPage open() {
        driver.get(url);
        // Check that we're on the right page.
        if (!(driver.getCurrentUrl().contains("referrals"))) {
            throw new IllegalStateException(
                    "This is not the " + this.getClass().getSimpleName() + " page");
        }
        WebDriverWait wait = new WebDriverWait(driver, TIMEOUT);
        wait.until(ExpectedConditions.visibilityOfElementLocated(pageVisible));
        return this;
    }

    public MainPage search() {
        searchBtn.click();

        WebDriverWait wait = new WebDriverWait(driver, TIMEOUT);
        wait.until(ExpectedConditions.presenceOfElementLocated(searchFinished));
        return this;
    }

    public MainPage setJobKeyword(String keyword) {
        setElementText(searchByKeywordText, keyword);
        return this;
    }

    public MainPage enterLocation(String location) {
        locationsField.click();
        setElementText(waitForElementPresent(locationTextInput), location);
        return this;
    }


    public MainPage selectLocationFromResults(Locations location) {
        clickListElementWithText(textToGetFromLocation, location.getFullLocationName());
        return this;
    }

    public MainPage assertAnyResultsReturned() {
        searchResultsList = driver.findElements(searchResultsItemsLocator);
        System.out.println("Search results jobs count=" + searchResultsList.size());
        Assert.assertTrue(!searchResultsList.isEmpty(), "Search results list is not empty");
        return this;
    }

    public MainPage assertNumberOfResultsReturned(int resultsCount) {
        searchResultsList = driver.findElements(searchResultsItemsLocator);
        Assert.assertEquals(
                searchResultsList.size(),
                resultsCount,
                "Number of search results is equal to " + resultsCount);
        return this;
    }
}
