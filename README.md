# MoveSeleniumTestJava
Test Suite to execute test cases for the site Realtor.com

Problem statement: Create test cases that :
 1. Verify that the search result for a given city gives more that 0 results 
    Test-City: Morgantown,WV, Result-Search count: 980+
 2. Select 2nd Home from the displayed list of homes. And click on the address displayed for that home. 
    Verify that the price listed for the home in search results is same as that displayed in the 
 
Solution Details:
1. Page object model is used to create the test cases.
2. There are 3 Folders - Source Packages (src), Test Packages(test) and Libraries(lib)
3. Source Packages Folder contains the package - com.realtorwebpages 
4. Each web page to be tested is one class in this package - Home Page, Search Results, Search Details
5. Page has detail about the locators and actions to be taken on them
6. Test Packages Folder contains the package  com.realtortest
7. It conatains a.) a java class with 2 test cases mentioned above and helper methods for setup and cleanup.
                b.) RealtorTestSuite.xml - testng.xml file that would trigger the test execution.
8. Libraries folder contains the Selenium and testNG jars. 

Execution:
Two ways to execute the project:
1. Import the project to NetBeans, build the project(right click on project and click on build) and from IDE run the file : RealtorTestSuite.xml  
   a.) This would run both the test cases and test result will be displayed in the console. 
   b.) Access the project folder structure (may be thru command line) and look-up for the test-output folder. This contains          the test execution report
   c.) test-output folder will be either located inside the project folder or inside the build folder. 
   
2. On command line, 
     a.) compile the project (javac -classpath "dist/lib/*" ./src/com/realtorseleniumtest/*.java     ./src/com/realtorwebpages/*.java ./test/com/realtortest/*.java)
     b.) Run the project : java -cp  "dist/lib/*" org/testng/TestNG test/com/realtortest/RealtorTestSuite.xml -d test-output
     c.) Execution result will be displayed on the console and test-output folder will be created inside the project folder.
