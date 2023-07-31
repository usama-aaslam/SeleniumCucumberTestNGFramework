package Pages;

import Utilities.BaseTest;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

//Page Factory for login page
public class LoginPage extends BaseTest {
    @FindBy(id = "user-name")
    WebElement name;

    @FindBy(id = "password")
    WebElement pass;

    @FindBy(id = "login-button")
    WebElement loginBtn;

    //initialize The page objects
    public LoginPage( ) {
        PageFactory.initElements( driver, this );
    }

    public String validateLoginPageTitle(){
        return driver.getTitle();
    }

    public HomePage login(String uname , String pwd){
        name.sendKeys( uname );
        pass.sendKeys( pwd );
        //loginBtn.click();
        JavascriptExecutor js =  (JavascriptExecutor) driver;
        js.executeScript( "arguments [0].click()", loginBtn );

        return new HomePage();
    }

}
