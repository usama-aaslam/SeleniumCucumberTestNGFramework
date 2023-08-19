package Pages;

import Utilities.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends BaseTest {
    @FindBy(css = "div.header_secondary_container >span")
    WebElement homePageHeader;

    @FindBy(id = "add-to-cart-sauce-labs-backpack")
    WebElement addProduct1;

    @FindBy(id = "add-to-cart-sauce-labs-bike-light")
    WebElement addProduct2;

    @FindBy(className = "shopping_cart_badge")
    WebElement cart;

    //initializing the page object
    public HomePage(){
        PageFactory.initElements( driver, this );
    }

    //Verify page title for Homepage after login
    public String verifyHomePageTitle(){
        return  homePageHeader.getText();
    }

    //add product to cart
    public void addProductToCart(){
        addProduct1.click();
        addProduct2.click();
    }

    public String validateProductAdded(){
        return cart.getText();
    }
    
}
