package com.pl.Base;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

import java.time.Duration;

public class PoundLandBase {

public WebDriver driver;
WebDriverFactory webDriverFactory;
@Parameters({"browserType","url"})
@BeforeClass
public void initializeBrowser(String browserType, String url){
    webDriverFactory=new WebDriverFactory(driver);
    driver=webDriverFactory.GetBrowser(browserType);
    driver.get(url);

    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
}
/*
@Parameters("url")
@BeforeTest
public void launchApplication(String url){

    driver.get(url);
}*/

/*
@AfterClass
public void killSession(){
    if(driver!=null) {

        driver.quit();
    }
*/
}


