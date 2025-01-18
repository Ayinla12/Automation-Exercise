package stepdefinition;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.time.Duration;
import java.util.List;

public class SearchProduct {
    public WebDriver driver;

    @Before("@searchProduct")
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @After("@searchProduct")
    public void teardown() {
        driver.quit();
    }

    @Given("I access the Automation Exercise home page")
    public void i_access_the_automation_exercise_home_page() {
        driver.get("https://automationexercise.com/");
        try {
            driver.findElement(By.xpath("//button[@aria-label='Consent']")).click();
        } catch (Exception e) {
            System.out.println("consent button not present");
        }

        // verifies that page is visible
        String pageTitle = driver.getTitle();
        Assert.assertEquals(pageTitle, "Automation Exercise");
    }

    @When("I click on the products button")
    public void i_click_on_the_products_button() {
        driver.findElement(By.partialLinkText("Products")).click();
        // Verifies current URL
        String currentUrl = driver.getCurrentUrl();
        Assert.assertEquals(currentUrl, "https://automationexercise.com/products");

    }

    @And("I enter the product name {string} in the search input field")
    public void i_enter_the_product_name_in_the_search_input_field(String productName) {
        driver.findElement(By.id("search_product")).sendKeys(productName);

    }

    @And("I click on the search button")
    public void i_click_on_the_search_button() {
        driver.findElement(By.id("submit_search")).click();

    }

    @Then("I should be presented with the searched products section")
    public void i_should_be_presented_with_the_searched_products_section() {
        WebElement featuresItems = driver.findElement(By.className("features_items"));
        Assert.assertTrue(featuresItems.isDisplayed());
    }

    @And("all the products related to the search should be visible")
    public void all_the_products_related_to_the_search_should_be_visible() {
        List<WebElement> productImageWrapper = driver.findElements(By.className("product-image-wrapper"));
        Assert.assertFalse(productImageWrapper.isEmpty());
        System.out.println("The number of Tshirts is " + productImageWrapper.size());
    }

}
