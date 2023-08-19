package stepDefinition;

import Pages.Checkout;
import Pages.HomePage;
import Pages.LoginPage;
import Utilities.BaseTest;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;

public class CheckoutProductStepDefinition extends BaseTest {
    LoginPage loginPage;
    HomePage homePage;

    private Checkout checkout ;


    @Given("^user open the browser$")
    public void user_open_the_browser() {
        BaseTest.intialization();

    }

    @Then("^user is on login page$")
    public void user_is_on_login_page() {
        loginPage = new LoginPage();
        String title = loginPage.validateLoginPageTitle();
        Assert.assertEquals( "Swag Labs", title );

    }

    @Then("^user logs into the application$")
    public void user_enters_username_and_password() {
        homePage = loginPage.login( properties.getProperty( "username" ), properties.getProperty( "password" ) );
    }


    @Then("^user validate the home page$")
    public void user_validate_the_home_page() {
        String homePageTitle = homePage.verifyHomePageTitle();
        Assert.assertEquals( "Products" , homePageTitle );
    }

    @And("^user add products to cart$")
    public void user_add_products_to_cart() {
        homePage.addProductToCart();
    }

    @Then("^validate product added to cart successfully$")
    public void validate_product_added_to_cart_successfully() {
        String validateCartCount = homePage.validateProductAdded();
        Assert.assertEquals( "2" , validateCartCount );
    }

    @Given("^user go to cart$")
    public void user_go_to_cart() {
        checkout= new Checkout();
        checkout.GoToCart();

    }
    @Then("^user enter checkout information$")
    public void user_enter_checkout_information() {
        checkout.CheckOutStep1( properties.getProperty( "firstName" ) , properties.getProperty( "lastName" ), properties.getProperty( "zipCode" ));
        double orderTotal= checkout.validateCartTotal();
        Assert.assertEquals( 43.18, orderTotal, 0.001 );

    }
    @Then("^user finish and checkout$")
    public void user_finish_and_checkout() {
        checkout.FinishCheckout();
    }
    @And("^validate user checkout successfully$")
    public void validate_user_checkout_successfully() {
        String successText = checkout.validateCheckoutComplete();
        Assert.assertEquals( "Thank you for your order!" , successText );
        checkout.clickBackToHome();
    }

    @Then( "^close browser$" )
    public void close_browser(){

        driver.quit();
    }

}
