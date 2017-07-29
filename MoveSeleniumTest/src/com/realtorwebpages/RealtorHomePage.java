package com.realtorwebpages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * @author shidave
 */
public class RealtorHomePage {
  WebDriver driver;
  By searchBox = By.id("searchBox");
  By searchButton = By.cssSelector("button.btn.btn-primary.js-searchButton");
  By searchTab = By.xpath("//*[@id=\"property-status-wrapper\"]/div[1]/label");
  
  public RealtorHomePage(WebDriver driver){
    this.driver=driver;
  }
  public void setSearchText(String strSearch){
    driver.findElement(searchBox).sendKeys(strSearch);
  }
  public void clickSearch(){
    driver.findElement(searchButton).click();
  }
  public String getSearchTab(){
    return driver.findElement(searchTab).getText();
  }
  public void searchHomesToBuyInArea(String area){
    this.setSearchText(area);
    this.clickSearch();
  } 
  
}
