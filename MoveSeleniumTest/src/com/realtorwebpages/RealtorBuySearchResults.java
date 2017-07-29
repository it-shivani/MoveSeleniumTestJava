package com.realtorwebpages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * @author shidave
 */
public class RealtorBuySearchResults {
  WebDriver driver;
  By searchResultTitle = By.cssSelector("h1.ellipsis");
  By searchResult = By.className("srp-list-header-count");
  By houseList = By.cssSelector("div#srp-list > div:first-of-type > ul.srp-list-marginless.list-unstyled > li:nth-child(3) >div.js-record-user-activity.js-navigate-to.srp-item > div.aspect-content > div.srp-item-body > div.srp-item-details > div.srp-item-price > span");
  By viewDetailButton = By.cssSelector("div#srp-list > div:first-of-type > ul.srp-list-marginless.list-unstyled > li:nth-child(3) >div.js-record-user-activity.js-navigate-to.srp-item > div.aspect-content > div.srp-item-body > div.srp-item-details > div.srp-item-ldp-link.hidden-xs.hidden-xxs > a.btn.btn-default");
  By address = By.cssSelector("div#srp-list > div:first-of-type > ul.srp-list-marginless.list-unstyled > li:nth-child(3) >div.js-record-user-activity.js-navigate-to.srp-item > div.aspect-content > div.srp-item-body > div.srp-item-details > div.srp-item-address.ellipsis > a");
 // By link = By.xpath("//*[@id=\"4872673780\"]/div[2]/div[1]/a");
  By link = By.cssSelector("div#srp-list > div:first-of-type > ul.srp-list-marginless.list-unstyled > li:nth-child(3) >div.js-record-user-activity.js-navigate-to.srp-item > div.aspect-content > div.srp-item-body > div.srp-item-details > a");
  
  public RealtorBuySearchResults(WebDriver driver){
   this.driver=driver;
  }
  public String getSearchResultTitleText(){
   return driver.findElement(searchResultTitle).getText();
  }
  public String getSearchResults(){
   return driver.findElement(searchResult).getText();
  }  
  public String getHouseListing(){
   return driver.findElement(houseList).getText();
  }
  public void clickViewDetails(){
    //driver.findElement(viewDetail).click();
    try{
    System.out.println("Address: "+driver.findElement(address).getText());
    driver.findElement(link).click();  
    }catch (Exception ex){
      ex.printStackTrace();
    }
  }
}
