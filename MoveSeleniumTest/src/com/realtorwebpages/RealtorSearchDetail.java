package com.realtorwebpages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * @author shidave
 */
public class RealtorSearchDetail {
    WebDriver driver;
    By detailPrice = By.cssSelector("#ldp-pricewrap > div > div > span");
    
    public RealtorSearchDetail(WebDriver driver){
     this.driver=driver;
    }
    public String getDetailPrice(){
     return driver.findElement(detailPrice).getText();
    }
    
}
