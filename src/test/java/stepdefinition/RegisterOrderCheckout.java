package stepdefinition;

import com.github.javafaker.Faker;
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
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.time.Duration;

public class RegisterOrderCheckout {
    private WebDriver driver;
    Faker faker = new Faker();
    private String username;

    @Before("@registerOrder")
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @After("@registerOrder")
    public void tearDown() {
        driver.quit();
    }

    @Given("the user accesses the automation exercise home page")
    public void the_user_accesses_the_automation_exercise_home_page() {
        driver.get("https://automationexercise.com/");
        try {
            driver.findElement(By.xpath("//button[@aria-label='Consent']")).click();
        } catch (Exception e) {
            System.out.println("Consent button not present");
        }

        String pageTitle = driver.getTitle();
        Assert.assertEquals(pageTitle, "Automation Exercise");

    }

    @When("the user clicks the signup-login button")
    public void the_user_clicks_the_signup_login_button() {
        driver.findElement(By.partialLinkText("Signup / Login")).click();

    }

    @And("the user fills all the required details to create an account")
    public void the_user_fills_all_the_required_details_to_create_an_account() {
        // Generate dynamic test data
        username = faker.name().username();
        String email = faker.internet().emailAddress();
        String firstname = faker.name().firstName();
        String lastname = faker.name().lastName();
        String company = faker.company().name();
        String address1 = faker.address().streetAddress();
        String address2 = faker.address().secondaryAddress();
        String state = faker.address().state();
        String city = faker.address().city();
        String zipcode = faker.regexify("[A-Za-z0-9]{6}");
        String mobileNumber = faker.number().digits(11);

        //Fill signup details
        driver.findElement(By.xpath("//input[@data-qa='signup-name']")).sendKeys(username);
        driver.findElement(By.xpath("//input[@data-qa='signup-email']")).sendKeys(email);
        driver.findElement(By.xpath("//button[@data-qa='signup-button']")).click();

        // Fill account information
        driver.findElement(By.id("id_gender1")).click();
        String password = faker.number().digits(6);
        driver.findElement(By.id("password")).sendKeys(password);
        WebElement daysField = driver.findElement(By.id("days"));
        Select select = new Select(daysField);
        select.selectByIndex(10);
        WebElement monthsField = driver.findElement(By.id("months"));
        Select months = new Select(monthsField);
        months.selectByValue("10");
        WebElement yearField = driver.findElement(By.id("years"));
        Select years = new Select(yearField);
        years.selectByVisibleText("2000");

        // signup to newsletter and special offers
        driver.findElement(By.id("newsletter")).click();
        driver.findElement(By.id("optin")).click();

        // Fill Address Information
        driver.findElement(By.id("first_name")).sendKeys(firstname);
        driver.findElement(By.id("last_name")).sendKeys(lastname);
        driver.findElement(By.id("company")).sendKeys(company);
        driver.findElement(By.id("address1")).sendKeys(address1);
        driver.findElement(By.id("address2")).sendKeys(address2);

        WebElement country = driver.findElement(By.id("country"));
        Select selectCountry = new Select(country);
        selectCountry.selectByIndex(2);
        driver.findElement(By.id("state")).sendKeys(state);
        driver.findElement(By.id("city")).sendKeys(city);
        driver.findElement(By.id("zipcode")).sendKeys(zipcode);
        driver.findElement(By.id("mobile_number")).sendKeys(mobileNumber);
        driver.findElement(By.xpath("//button[@data-qa='create-account']")).click();

    }

    @And("the user verifies ACCOUNT CREATED is displayed")
    public void the_user_verifies_account_created_is_displayed() {
        String accountCreationMessage = driver.findElement(By.xpath("//h2[@data-qa='account-created']//b")).getText().toLowerCase();
        Assert.assertEquals(accountCreationMessage, "account created!");
        System.out.println("the message is " + accountCreationMessage);

    }

    @And("the user clicks on the continue button")
    public void the_user_clicks_on_the_continue_shopping() {
        driver.findElement(By.xpath("//a[@data-qa='continue-button']")).click();

    }

    @And("the user verifies logged in as username is displayed at the top")
    public void the_user_verifies_logged_in_as_username_is_displayed_at_the_top() {
        String userName = driver.findElement(By.xpath("//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[10]/a/b")).getText();
        Assert.assertEquals(userName, username);
        System.out.println("this is the correct username " + userName);

    }

    @And("the user adds products to the cart")
    public void the_user_adds_products_to_the_cart() {
        driver.findElement(By.xpath("//body/section[2]/div[1]/div[1]/div[2]/div[2]/div[1]/div[1]/div[1]/div[3]/div[1]/div[1]/div[1]/a[1]")).click();

    }

    @And("the user clicks the cart button")
    public void the_user_clicks_the_cart_button() {
        driver.findElement(By.xpath("//u[contains(text(),'View Cart')]")).click();

    }

    @And("the user verifies the cart page is displayed")
    public void the_user_verifies_the_cart_page_is_displayed() {
        String currentUrl = driver.getCurrentUrl();
        Assert.assertEquals(currentUrl, "https://automationexercise.com/view_cart");
    }

    @And("the user clicks Proceed to Checkout")
    public void the_user_clicks_proceed_to_checkout() {
        driver.findElement(By.xpath("//div[@class='col-sm-6']//a[@class='btn btn-default check_out']")).click();

    }

    @And("the user verifies Address Details and Review Your Order are displayed")
    public void the_user_verifies_address_details_and_review_your_order_are_displayed() {
        WebElement addressDetails = driver.findElement(By.xpath("//h2[contains(text(),'Address Details')]"));
        Assert.assertTrue(addressDetails.isDisplayed());

        WebElement reviewOrder = driver.findElement(By.xpath("//h2[contains(text(),'Review Your Order')]"));
        Assert.assertTrue(reviewOrder.isDisplayed());

    }

    @And("the user enters a description in the comment text area")
    public void the_user_enters_a_description_in_the_comment_text_area() {
        String comment = faker.lorem().sentence(4);
        driver.findElement(By.xpath("//textarea[@name='message']")).sendKeys(comment);

    }

    @And("the user clicks the Place Order button")
    public void the_user_clicks_the_place_order_button() {
        driver.findElement(By.xpath("//a[contains(text(),'Place Order')]")).click();

    }

    @And("the user enters payment details including Name on Card, Card Number, CVC, and Expiration Date")
    public void the_user_enters_payment_details_including_name_on_card_card_number_cvc_and_expiration_date() {
        // Generate dynamic test data
        String cardNumber = faker.number().digits(12);
        String cvc = faker.number().digits(3);
        String expiryMonth = String.valueOf(faker.number().numberBetween(1, 12));
        String expiryYear = String.valueOf(faker.number().numberBetween(2026, 2030));

        // Fill payment details
        driver.findElement(By.name("name_on_card")).sendKeys(username);
        driver.findElement(By.name("card_number")).sendKeys(cardNumber);
        driver.findElement(By.name("cvc")).sendKeys(cvc);
        driver.findElement(By.name("expiry_month")).sendKeys(expiryMonth);
        driver.findElement(By.name("expiry_year")).sendKeys(expiryYear);

    }

    @And("the user clicks the Pay and Confirm Order button")
    public void the_user_clicks_the_pay_and_confirm_order_button() {
        driver.findElement(By.id("submit")).click();

    }

    @Then("the user verifies the success message {string}")
    public void the_user_verifies_the_success_message(String successMessage) {
        WebElement confirmationMessage = driver.findElement(By.xpath("//p[contains(text(),'Congratulations! Your order has been confirmed!')]"));
        Assert.assertEquals(confirmationMessage.getText(), successMessage);

    }

    @And("the user clicks the Delete Account button")
    public void the_user_clicks_the_delete_account_button() {
        driver.findElement(By.partialLinkText("Delete Account")).click();

    }

    @And("the user verifies ACCOUNT DELETED is displayed")
    public void the_user_verifies_account_deleted_is_displayed() {
        String deletionMessage = driver.findElement(By.xpath("//div[@class='col-sm-9 col-sm-offset-1']//b")).getText();
        Assert.assertEquals(deletionMessage, "ACCOUNT DELETED!");

    }

    @And("the user clicks the Continue button")
    public void the_user_clicks_the_continue_button() {
        driver.findElement(By.xpath("//a[contains(text(),'Continue')]")).click();

    }

}
