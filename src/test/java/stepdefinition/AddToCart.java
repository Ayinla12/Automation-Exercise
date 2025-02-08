package stepdefinition;


import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


import org.testng.Assert;
import pageobjects.AddToCart_PO;
import pageobjects.Base_PO;


import static driver.DriverFactory.getDriver;

public class AddToCart extends Base_PO {
    private WebDriver driver = getDriver();

    private AddToCart_PO addToCart_po;

    public AddToCart(AddToCart_PO addToCart_po) {
        this.addToCart_po = addToCart_po;

    }


    @Given("the user accesses the Automation Exercise home page")
    public void the_user_accesses_the_automation_exercise_home_page() {

        addToCart_po.navigateTo_AutomationExercise_HomePage();

        try {
            waitForElementAndClick(By.xpath("//button[@aria-label='Consent']"));

        } catch (Exception e) {
            System.out.println("consent button not present");
        }

        addToCart_po.verificationOf_Page_Title();
    }

    @When("the user clicks on the products button")
    public void the_user_clicks_on_the_products_button() {

        addToCart_po.clickOn_productsButton();

    }

    @And("the user hovers over the first product and clicks Add to cart")
    public void the_user_hovers_over_the_first_product_and_clicks_add_to_cart() {

        addToCart_po.add_firstProduct_To_Cart();

    }

    @And("the user clicks on the continue shopping button")
    public void the_user_clicks_on_the_continue_shopping_button() {

        addToCart_po.clickOn_Continue_Shopping_Button();

    }

    @And("the user hovers over the second product and clicks Add to cart")
    public void the_user_hovers_over_the_second_product_and_clicks_add_to_cart() {

        addToCart_po.add_secondProduct_To_Cart();

    }

    @And("the user clicks on the view cart button")
    public void the_user_clicks_on_the_view_cart_button() {

        addToCart_po.clickOn_ViewCart_Button();

    }

    @Then("both products should be visible in the cart")
    public void both_products_should_be_visible_in_the_cart() {

        addToCart_po.verificationOf_ProductOne();

        addToCart_po.verificationOf_ProductTwo();

    }

    @And("the prices, quantities, and total price of the products should be correct")
    public void the_prices_quantities_and_total_price_of_the_products_should_be_correct() {

        addToCart_po.verificationOf_First_Product_Detail();

        addToCart_po.verificationOf_Second_Product_Detail();

    }

}
