package com.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestContext;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.net.MalformedURLException;
import java.net.URL;

public class BaseTest {

    protected WebDriver driver;
    private WebDriverWait wait;

    @BeforeTest
    public void setupDriver(ITestContext ctx) throws MalformedURLException {
        // BROWSER => chrome/firefox
        // HUB_HOST =>localhost/10.0.1.3 /hostname

        String host = "localhost";
        DesiredCapabilities dc;

        if(System.getProperty("BROWSER")!= null &&
            System.getProperty("BROWSER").equalsIgnoreCase("firefox")){
            dc=DesiredCapabilities.firefox();
        }else{
             dc=DesiredCapabilities.chrome();
        }

        if(System.getProperty("HUB_HOST")!= null){
            host=System.getProperty("HUB_HOST");
        }

        String testName=ctx.getCurrentXmlTest().getName();
        //String completeUrl="http://" + host + ":4444/wd/hub";
        String completeUrl="http://" + host + ":4444/wd/hub";
        dc.setCapability("name",testName);
        //System.out.println(completeUrl+" este soy");
        this.driver= new RemoteWebDriver(new URL(completeUrl),dc);

        try{
            //some exception is thrown here
        }catch(Exception e){
            driver.quit();
        }
        /*
        //set path
        System.setProperty("webdriver.chrome.driver","/Users/juan.zuniga/Documents/Drivers/chromedriver");
        this.driver=new ChromeDriver();*/
    }

    @AfterTest
    public void quitBrowser(){
        this.driver.quit();
    }


   /* @BeforeTest
    public void setupDriver() throws MalformedURLException {
        // BROWSER => chrome/firefox
        // HUB_HOST =>localhost/10.0.1.3 /hostname

        String host = "localhost";
        DesiredCapabilities dc =DesiredCapabilities.chrome();

        if(System.getProperty("BROWSER")!= null &&
                System.getProperty("BROWSER").equalsIgnoreCase("firefox")){
            dc=DesiredCapabilities.firefox();
        }

        if(System.getProperty("HUB_HOST")!= null){
            host=System.getProperty("HUB_HOST");
        }

        //String completeUrl="http://" + host + ":4444/wd/hub";
        String completeUrl="http://" + host + ":4444/wd/hub";
        dc.setCapability("name","somename");
        System.out.println(completeUrl+" este soy");
        this.driver= new RemoteWebDriver(new URL(completeUrl),dc);

        try{
            //some exception is thrown here
        }catch(Exception e){
            driver.quit();
        }
        /*
        //set path
        System.setProperty("webdriver.chrome.driver","/Users/juan.zuniga/Documents/Drivers/chromedriver");
        this.driver=new ChromeDriver();*/
    //}*/

}
