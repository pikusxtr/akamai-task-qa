package com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AbstractPage {

  protected WebDriver driver;

  public AbstractPage(WebDriver driver) {
    this.driver = driver;
  }

  public void setElementText(WebElement webElement, String textToSet) {
    webElement.sendKeys(textToSet);
  }
}
