package com.tests;

import com.data.AppUrls;
import com.data.Locations;
import com.pages.MainPage;
import com.pages.WebDriverTestBase;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AkamaiTest extends WebDriverTestBase {
  private MainPage mainPage;

  @BeforeMethod
  public void openMainPage() {
    mainPage = new MainPage(driver, AppUrls.PROD.getUrl());
  }

  @Test
  public void anyResultsShouldBeReturnedForKeywordLocation() {

    mainPage
        .setJobKeyword("Test")
        .enterLocation("Krakow")
        .selectLocationFromResults(Locations.PL_KRK)
        .search()
        .assertAnyResultsReturned();
  }

  @Test
  public void noResultsShouldBeReturnedForKeywordWithEmptyLocation() {
    mainPage
        .setJobKeyword("XXX")
        .search()
        .assertNumberOfResultsReturned(0);
  }
}
