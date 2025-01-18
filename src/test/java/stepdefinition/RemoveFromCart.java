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
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.List;

public class RemoveFromCart {
    private WebDriver driver;

    @Before("@removeProduct")
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

    }

    @After("@removeProduct")
    public void tearDown() {
        driver.quit();
    }

    @Given("user accesses the automation exercise home page")
    public void user_accesses_the_automation_exercise_home_page() {
        driver.get("https://automationexercise.com/");
        try {
            driver.findElement(By.xpath("//button[@aria-label='Consent']")).click();
        } catch (Exception e) {
            System.out.println("Consent button not displayed");
        }
    }

    @And("verifies the home page is visible successfully")
    public void verifies_the_home_page_is_visible_successfully() {
        String pageTitle = driver.getTitle();
        Assert.assertEquals(pageTitle, "Automation Exercise");

    }

    @When("user adds products to the cart")
    public void user_adds_products_to_the_cart() {
        driver.findElement(By.xpath("//div[@class='productinfo text-center']//a[@data-product-id='4']")).click();
        driver.findElement(By.xpath("//button[contains(text(),'Continue Shopping')]")).click();

        driver.findElement(By.xpath("//div[@class='productinfo text-center']//a[@data-product-id='5']")).click();

    }

    @And("clicks on the view cart button")
    public void clicks_on_the_view_cart_button() {
        driver.findElement(By.xpath("//u[contains(text(),'View Cart')]")).click();

    }

    @Then("verifies that the cart page is displayed")
    public void verifies_that_the_cart_page_is_displayed() {
        String pageUrl = driver.getCurrentUrl();
        Assert.assertEquals(pageUrl, "https://automationexercise.com/view_cart");

    }

    @And("clicks on the X button corresponding to a particular product")
    public void clicks_on_the_x_button_corresponding_to_a_particular_product() {
        driver.findElement(By.xpath("//a[@data-product-id='4']")).click();

    }

    @And("verifies that the product is removed from the cart")
    public void verifies_that_the_product_is_removed_from_the_cart() {
        List<WebElement> cartSize = driver.findElements(By.className("cart_product"));
        int initialCartSize = cartSize.size();

        // waits for product to be removed
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.stalenessOf(cartSize.get(0)));

        List<WebElement> currentCartSize = driver.findElements(By.className("cart_product"));
        int finalCartSize = currentCartSize.size();

        Assert.assertEquals(finalCartSize, initialCartSize - 1);

    }

}
