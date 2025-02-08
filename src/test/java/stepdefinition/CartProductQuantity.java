package stepdefinition;


import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.testng.Assert;
import pageobjects.Base_PO;
import pageobjects.CartProductQuantity_PO;


import static driver.DriverFactory.getDriver;

public class CartProductQuantity extends Base_PO {
    private WebDriver driver = getDriver();

    private CartProductQuantity_PO cartProductQuantity_po;

    public CartProductQuantity(CartProductQuantity_PO cartProductQuantity_po) {
        this.cartProductQuantity_po = cartProductQuantity_po;
    }


    @Given("the user accesses the Automation exercise home page")
    public void the_user_accesses_the_automation_exercise_home_page() {

        cartProductQuantity_po.navigateTo_Automation_Exercise_Home_Page();

        try {
            waitForElementAndClick(By.xpath("//button[@aria-label='Consent']"));
        } catch (Exception e) {
            System.out.println("Consent button not displayed ");
        }

    }

    @And("verifies the home page is displayed")
    public void verifies_the_home_page_is_displayed() {

        cartProductQuantity_po.verify_Page_Title();

    }

    @When("the user clicks View Product for any product on the home page")
    public void the_user_clicks_view_product_for_any_product_on_the_home_page() {

        cartProductQuantity_po.clickOn_View_Button();

    }

    @And("verifies the product details page is opened")
    public void verifies_the_product_details_page_is_opened() {

        cartProductQuantity_po.verify_Product_Details_Page();

    }

    @And("increases the quantity to {int}")
    public void increases_the_quantity_to(Integer quantity) {

        cartProductQuantity_po.setProductQuantity(quantity);

    }

    @Then("the user clicks the Add to Cart button")
    public void the_user_clicks_the_add_to_cart_button() {

        cartProductQuantity_po.clickOn_addToCart_Button();

    }

    @And("user clicks on the view cart button")
    public void user_clicks_on_the_view_cart_button() {

        cartProductQuantity_po.clickOn_viewCart_Button();

    }

    @And("verifies that the product is displayed in the cart page with the exact quantity")
    public void verifies_that_the_product_is_displayed_in_the_cart_page_with_the_exact_quantity() {

        cartProductQuantity_po.verify_Cart_Page_Details();

    }
}
