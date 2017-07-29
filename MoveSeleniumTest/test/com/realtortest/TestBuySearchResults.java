
package com.realtortest;

import com.realtorwebpages.RealtorBuySearchResults;
import com.realtorwebpages.RealtorHomePage;
import com.realtorwebpages.RealtorSearchDetail;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

/**
 * @author shidave
 */
public class TestBuySearchResults {
   WebDriver driver;
   RealtorHomePage realtorHomePage;
   RealtorBuySearchResults realtorBuySearchResults;
   RealtorSearchDetail realtorSearchDetail;
   String baseUrl="http://www.realtor.com/";
   String searchTabTest="buy";
   String searchAreaTest="Morgantown,WV";
   String searchResultPageTest = "Morgantown, WV Real Estate & Homes for Sale";
   String searchResultTextTest="Homes";
   
   @BeforeSuite()
   public void setup(){
     //System.out.println("Setup");
     driver = new ChromeDriver();
     driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
     driver.get(baseUrl);
   }
   @AfterSuite()
   public void cleanup(){
     driver.close();
   }
   @BeforeTest(description="Create instances of the POMs and verify that user is on correct page before initiating the tests")
   public void createInstances(){
     //System.out.println("Create Instances");
     realtorHomePage = new RealtorHomePage(driver);
     realtorBuySearchResults = new RealtorBuySearchResults(driver);
     realtorSearchDetail = new RealtorSearchDetail(driver);
     
     String searchTabResult = realtorHomePage.getSearchTab();
     Assert.assertTrue(searchTabResult.toLowerCase().contains(searchTabTest)); 
   }
   @Test(priority=0,description="Search for homes to buy in Morgantown, WV and verify that result is > 0")
   public void test_Buy_Search_GreaterThanZero(){     
     realtorHomePage.searchHomesToBuyInArea(searchAreaTest);
     realtorHomePage.clickSearch();
     
     //Test to check correct page is opened on clicking the search button
     String searchResultTitleRes = realtorBuySearchResults.getSearchResultTitleText();
     Assert.assertTrue(searchResultTitleRes.toLowerCase().contains(searchResultPageTest.toLowerCase()));
     
     String searchResult = realtorBuySearchResults.getSearchResults();
     Assert.assertTrue(searchResult.toLowerCase().contains(searchResultTextTest.toLowerCase()));
     String count = driver.findElement(By.className("srp-list-header-count")).getText();
     String countNum = count.substring(0,count.length()-6);
     System.out.println("Test 1 Result: Search Result Count "+countNum);
     int cnt = Integer.parseInt(countNum);
   
     Assert.assertTrue(cnt>0);
   }
   @Test(priority=0,description="Validate that the price in listing and selection for a selected home is same")
   public void test_SelectionPrice_Same(){
     realtorHomePage.searchHomesToBuyInArea(searchAreaTest);
     realtorHomePage.clickSearch();
     
     String searchResultTitleRes = realtorBuySearchResults.getSearchResultTitleText();
     Assert.assertTrue(searchResultTitleRes.toLowerCase().contains(searchResultPageTest.toLowerCase()));
     String searchResult = realtorBuySearchResults.getSearchResults();
     Assert.assertTrue(searchResult.toLowerCase().contains(searchResultTextTest.toLowerCase()));
     String count = driver.findElement(By.className("srp-list-header-count")).getText();
     String countNum = count.substring(0,count.length()-6);
     int cnt = Integer.parseInt(countNum);
     Assert.assertTrue(cnt>0); 
     
     String listResult = realtorBuySearchResults.getHouseListing();
     System.out.println("Price of a house in list view: "+listResult);
     String strPrice = listResult.replaceAll("[^0-9 ]","");
     //System.out.println("List Price: "+strPrice);   
     int listPriceAmount=Integer.parseInt(strPrice);
     
     realtorBuySearchResults.clickViewDetails();
     String detailPriceResult = realtorSearchDetail.getDetailPrice();    
     String detailPrice = detailPriceResult.replaceAll("[^0-9 ]","");
     int detailPriceAmount = Integer.parseInt(detailPrice);
     System.out.println("Price of same house in detail view "+detailPriceResult);
     
     Assert.assertEquals(listPriceAmount, detailPriceAmount);   
   }
}
