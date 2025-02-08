package stepdefinition;


import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import pageobjects.Base_PO;
import pageobjects.RemoveFromCart_PO;

import java.time.Duration;
import java.util.List;

import static driver.DriverFactory.getDriver;

public class RemoveFromCart extends Base_PO {
    private WebDriver driver = getDriver();

    private RemoveFromCart_PO removeFromCart_po;

    public RemoveFromCart(RemoveFromCart_PO removeFromCart_po) {
        this.removeFromCart_po = removeFromCart_po;
    }


    @Given("user accesses the automation exercise home page")
    public void user_accesses_the_automation_exercise_home_page() {

        removeFromCart_po.navigateTo_Automation_Exercise_Home_Page();
        try {
            waitForElementAndClick(By.xpath("//button[@aria-label='Consent']"));
        } catch (Exception e) {
            System.out.println("Consent button not displayed");
        }
    }

    @And("verifies the home page is visible successfully")
    public void verifies_the_home_page_is_visible_successfully() {

        removeFromCart_po.verify_Home_Page();

    }

    @When("user adds products to the cart")
    public void user_adds_products_to_the_cart() {

        removeFromCart_po.addProduct_To_Cart();

        removeFromCart_po.clickOn_Continue_Shopping();

        removeFromCart_po.addAnother_Product_To_Cart();

    }

    @And("clicks on the view cart button")
    public void clicks_on_the_view_cart_button() {

        removeFromCart_po.clickOn_View_Cart_Button();

    }

    @Then("verifies that the cart page is displayed")
    public void verifies_that_the_cart_page_is_displayed() {

        removeFromCart_po.verify_URL();

    }

    @And("clicks on the X button corresponding to a particular product")
    public void clicks_on_the_x_button_corresponding_to_a_particular_product() {

        removeFromCart_po.clickOn_X_Button();

    }

    @And("verifies that the product is removed from the cart")
    public void verifies_that_the_product_is_removed_from_the_cart() {

        removeFromCart_po.verify_Final_Cart_Size();

    }

}
