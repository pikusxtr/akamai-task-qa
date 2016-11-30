package com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.io.File;
import java.net.URISyntaxException;
import java.net.URL;

import static com.google.common.io.Resources.getResource;

public abstract class WebDriverTestBase {

  protected WebDriver driver;

  @BeforeClass
  public void setUp() throws URISyntaxException {
    URL geckoURL = getResource("geckodriver.exe");
    String geckoDriverPath = new File(geckoURL.toURI()).getAbsolutePath();
    System.setProperty("webdriver.gecko.driver", geckoDriverPath);
    driver = new FirefoxDriver();
  }

  @AfterClass
  public void tearDown() {
    driver.close();
    driver.quit();
  }
}
