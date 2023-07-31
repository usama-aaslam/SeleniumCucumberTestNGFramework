package Pages;

import Utilities.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Checkout extends BaseTest {
    @FindBy(id = "shopping_cart_container")
    WebElement cartIcon ;

    @FindBy(id = "checkout")
    WebElement checkoutButton;

    @FindBy (id = "first-name")
    WebElement firstNameCheckoutInfo;

    @FindBy(id = "last-name")
    WebElement lastNameCheckoutInfo;

    @FindBy(id = "postal-code")
    WebElement zipCodeCheckoutInfo;

    @FindBy(id = "continue")
    WebElement continueBtnCheckout;

  //  @FindBy(className = "summary_info_label summary_total_label")
   // WebElement carTotal;

    @FindBy(id = "finish")
    WebElement finishBtn;

    @FindBy(className = "complete-header")
    WebElement orderSuccessText;

    @FindBy(id = "back-to-products")
    WebElement backHomeBtn;

    //initializing the page object
    public Checkout(){
        PageFactory.initElements( driver, this );

    }

    public void GoToCart(){
        cartIcon.click();
        checkoutButton.click();
    }


}
