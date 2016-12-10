package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

class AbstractPage {

    static final int TIMEOUT = 7;
    WebDriver driver;


    AbstractPage(WebDriver driver) {
        this.driver = driver;
    }

    void setElementText(WebElement webElement, String textToSet) {
        webElement.sendKeys(textToSet);
    }

    void clickListElementWithText(By elementListLocator, String exactTextToClick) {
        WebDriverWait wait = new WebDriverWait(driver, TIMEOUT);
        List<WebElement> elementList =
                wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(elementListLocator));
        elementList.forEach(
                webElement -> {
                    if (webElement.getText().contentEquals(exactTextToClick))
                        webElement.click();
                });
    }

    WebElement waitForElementPresent(By elementLocator) {
        WebDriverWait wait = new WebDriverWait(driver, TIMEOUT);
        return wait.until(ExpectedConditions.presenceOfElementLocated(elementLocator));
    }

}
