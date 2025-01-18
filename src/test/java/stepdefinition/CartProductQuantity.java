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

public class CartProductQuantity {
    private WebDriver driver;

    @Before("@cartQuantity")
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @After("@cartQuantity")
    public void tearDown() {
        driver.quit();
    }

    @Given("the user accesses the Automation exercise home page")
    public void the_user_accesses_the_automation_exercise_home_page() {
        driver.get("https://automationexercise.com/");
        try {
            driver.findElement(By.xpath("//button[@aria-label='Consent']")).click();
        } catch (Exception e) {
            System.out.println("Consent button not displayed ");
        }

    }

    @And("verifies the home page is displayed")
    public void verifies_the_home_page_is_displayed() {
        String pageTitle = driver.getTitle();
        Assert.assertEquals(pageTitle, "Automation Exercise");

    }

    @When("the user clicks View Product for any product on the home page")
    public void the_user_clicks_view_product_for_any_product_on_the_home_page() {
        driver.findElement(By.xpath("//body/section[2]/div[1]/div[1]/div[2]/div[1]/div[2]/div[1]/div[2]/ul[1]/li[1]/a[1]")).click();

    }

    @And("verifies the product details page is opened")
    public void verifies_the_product_details_page_is_opened() {
        String pagetitle = driver.getTitle();
        Assert.assertEquals(pagetitle, "Automation Exercise - Product Details");

    }

    @And("increases the quantity to {int}")
    public void increases_the_quantity_to(Integer quantity) {
        WebElement quantityField = driver.findElement(By.id("quantity"));

        quantityField.clear();
        quantityField.sendKeys(String.valueOf(quantity));

    }

    @Then("the user clicks the Add to Cart button")
    public void the_user_clicks_the_add_to_cart_button() {
        driver.findElement(By.xpath("//button[@class='btn btn-default cart']")).click();

    }

    @And("user clicks on the view cart button")
    public void user_clicks_on_the_view_cart_button() {
        driver.findElement(By.xpath("//u[contains(text(),'View Cart')]")).click();

    }

    @And("verifies that the product is displayed in the cart page with the exact quantity")
    public void verifies_that_the_product_is_displayed_in_the_cart_page_with_the_exact_quantity() {
        WebElement cartProduct = driver.findElement(By.id("product-1"));
        Assert.assertTrue(cartProduct.isDisplayed());

        String productQuanity = driver.findElement(By.xpath("//td[@class='cart_quantity']")).getText();
        int actualQuantity = Integer.parseInt(productQuanity);
        Assert.assertEquals(actualQuantity, 4);
        System.out.println("the product quantity in cart is " + actualQuantity);

    }
}
