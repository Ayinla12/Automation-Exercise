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
import pageobjects.SearchProduct_PO;


import java.util.List;

import static driver.DriverFactory.getDriver;

public class SearchProduct extends Base_PO {
    private WebDriver driver = getDriver();

    private SearchProduct_PO searchProduct_po;

    public SearchProduct(SearchProduct_PO searchProduct_po) {
        this.searchProduct_po = searchProduct_po;
    }


    @Given("I access the Automation Exercise home page")
    public void i_access_the_automation_exercise_home_page() {

        searchProduct_po.navigateTo_AutomationExercise_Home_Page();

        try {
            waitForElementAndClick(By.xpath("//button[@aria-label='Consent']"));
        } catch (Exception e) {
            System.out.println("consent button not present");
        }

        searchProduct_po.verify_Home_Page();
    }

    @When("I click on the products button")
    public void i_click_on_the_products_button() {

        searchProduct_po.clickOn_Products_Button();

        searchProduct_po.verify_URL();

    }

    @And("I enter the product name {string} in the search input field")
    public void i_enter_the_product_name_in_the_search_input_field(String productName) {

        searchProduct_po.setSearch_Input(productName);

    }

    @And("I click on the search button")
    public void i_click_on_the_search_button() {

        searchProduct_po.clickOn_search_Button();

    }

    @Then("I should be presented with the searched products section")
    public void i_should_be_presented_with_the_searched_products_section() {

        searchProduct_po.assertionOf_Displayed_Searched_Products();
    }

    @And("all the products related to the search should be visible")
    public void all_the_products_related_to_the_search_should_be_visible() {

        searchProduct_po.verify_Searched_Product();
    }

}
