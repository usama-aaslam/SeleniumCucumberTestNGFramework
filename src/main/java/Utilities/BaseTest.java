package Utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

//Get the values from configuration. properties file
public class BaseTest {
    public static WebDriver driver;
    public static Properties properties;

    public  BaseTest(){
       try {
           properties = new Properties();
           FileInputStream fis = new FileInputStream( "src/main/java/Config/config.properties" );
           properties.load( fis );
       }
       catch (IOException e){
           e.getMessage();
       }
    }

    //Launch the browser
public static void intialization(){
        String browserName = properties.getProperty( "browser" );
        if(browserName.equals("chrome")){
            System.setProperty( "webdriver.chrome.driver", "src/main/resources/chromedriver.exe" );
            driver = new ChromeDriver();
        }
        else if(browserName.equals("firefox")){
            System.setProperty ("webdriver.gecko.driver","src/main/resources/geckodriver.exe") ;
            driver = new FirefoxDriver();
        }
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().pageLoadTimeout( TestUtil.PAGE_LOAD_TIMEOUT , TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait( TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS );

        driver.get( properties.getProperty( "url" ) );
}




}
