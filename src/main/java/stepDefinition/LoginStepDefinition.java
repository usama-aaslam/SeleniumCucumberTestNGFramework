package stepDefinition;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class LoginStepDefinition {

    WebDriver driver;

    @Given( "^User is already on login page$" )
    public void user_already_on_login_page(){
        System.setProperty( "webdriver.chrome.driver","src/main/resources/chromedriver.exe" );
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get( "https://www.saucedemo.com/" );
    }

    @When( "^title of login page is Swag Labs$" )
    public void title_login_page_is_Swag_Labs(){
        String title = driver.getTitle();
        System.out.println("Login Page Title: "+title);
        Assert.assertEquals(  "Swag Labs", title );
    }
    @Then("^User enter \"(.*)\" & \"(.*)\"$")
    public void user_enter_username_password(String username, String password) {
       driver.findElement( By.id( "user-name" ) ).sendKeys( username );
       driver.findElement( By.id( "password" ) ).sendKeys( password );

    }
    @Then("^User click on login button$")
    public void user_click_on_login_button() {
        driver.findElement( By.id( "login-button" ) ).click();
    }

    @And("^User will be redirected to CRM Home page$")
    public void user_will_be_redirected_to_crm_home_page() {
        driver.manage().timeouts().implicitlyWait( Duration.ofSeconds( 2 ) );
        String homePageHeader=driver.findElement( By.cssSelector( "div.header_secondary_container >span" ) ).getText();
        System.out.println(homePageHeader);
        Assert.assertEquals( "Products", homePageHeader );
    }
    @Then( "^Close the browser$" )
    public void close_the_browser(){

        driver.quit();
    }

}
