package stepdefinition;


import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


import org.testng.Assert;


import static driver.DriverFactory.getDriver;

public class AddToCart {
    private WebDriver driver = getDriver();


    @Given("the user accesses the Automation Exercise home page")
    public void the_user_accesses_the_automation_exercise_home_page() {
        driver.get("https://automationexercise.com/");

        try {
            driver.findElement(By.xpath("//button[@aria-label='Consent']")).click();
        } catch (Exception e) {
            System.out.println("consent button not present");
        }
        // Verifies homepage
        String homeTitle = driver.getTitle();
        Assert.assertEquals(homeTitle, "Automation Exercise");
    }

    @When("the user clicks on the products button")
    public void the_user_clicks_on_the_products_button() {
        driver.findElement(By.partialLinkText(" Products")).click();

    }

    @And("the user hovers over the first product and clicks Add to cart")
    public void the_user_hovers_over_the_first_product_and_clicks_add_to_cart() {
        driver.findElement(By.xpath("//div[@class='productinfo text-center']//a[@data-product-id='1']")).click();

    }

    @And("the user clicks on the continue shopping button")
    public void the_user_clicks_on_the_continue_shopping_button() {
        driver.findElement(By.xpath("//button[contains(text(),'Continue Shopping')]")).click();

    }

    @And("the user hovers over the second product and clicks Add to cart")
    public void the_user_hovers_over_the_second_product_and_clicks_add_to_cart() {
        driver.findElement(By.xpath("//div[@class='productinfo text-center']//a[@data-product-id='2']")).click();

    }

    @And("the user clicks on the view cart button")
    public void the_user_clicks_on_the_view_cart_button() {
        driver.findElement(By.xpath("//u[contains(text(),'View Cart')]")).click();

    }

    @Then("both products should be visible in the cart")
    public void both_products_should_be_visible_in_the_cart() {
        WebElement firstProduct = driver.findElement(By.id("product-1"));
        Assert.assertTrue(firstProduct.isDisplayed());

        WebElement secondProduct = driver.findElement(By.id("product-2"));
        Assert.assertTrue(secondProduct.isDisplayed());

    }

    @And("the prices, quantities, and total price of the products should be correct")
    public void the_prices_quantities_and_total_price_of_the_products_should_be_correct() {
        //System.out.println("I WILL DO THIS LATER ");
        String firstProductPrice = driver.findElement(By.xpath("//tr[@id='product-1']//td[@class='cart_price']")).getText().replace("Rs.", "");
        String firstProductQuantity = driver.findElement(By.xpath("//tr[@id='product-1']//td[@class='cart_quantity']//button")).getText();
        String firstProductTotalPrice = driver.findElement(By.xpath("//tr[@id='product-1']//td[@class='cart_total']//p")).getText().replace("Rs.", "");

        double price1 = Double.parseDouble(firstProductPrice);
        int quantity1 = Integer.parseInt(firstProductQuantity);
        double totalPrice1 = Double.parseDouble(firstProductTotalPrice);

        String secondProductPrice = driver.findElement(By.xpath("//tr[@id='product-2']//td[@class='cart_price']")).getText().replace("Rs.", "");
        String secondProductQuantity = driver.findElement(By.xpath("//tr[@id='product-2']//td[@class='cart_quantity']//button")).getText();
        String secondProductTotalPrice = driver.findElement(By.xpath("//tr[@id='product-2']//td[@class='cart_total']//p")).getText().replace("Rs.", "");

        double price2 = Double.parseDouble(secondProductPrice);
        int quantity2 = Integer.parseInt(secondProductQuantity);
        double totalPrice2 = Double.parseDouble(secondProductTotalPrice);

        Assert.assertEquals(totalPrice1, price1 * quantity1);
        Assert.assertEquals(totalPrice2, price2 * quantity2);

    }

}
