package stepdefinition;

import com.github.javafaker.Faker;


import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import pageobjects.Base_PO;
import pageobjects.RegisterOrderCheckout_PO;


import static driver.DriverFactory.getDriver;

public class RegisterOrderCheckout extends Base_PO {
    private WebDriver driver = getDriver();
    Faker faker = new Faker();
    private String username;

    private RegisterOrderCheckout_PO registerOrderCheckout_po;

    public RegisterOrderCheckout(RegisterOrderCheckout_PO registerOrderCheckout_po) {
        this.registerOrderCheckout_po = registerOrderCheckout_po;
    }


    @Given("the user accesses the automation exercise home page")
    public void the_user_accesses_the_automation_exercise_home_page() {

        registerOrderCheckout_po.navigateTo_Automation_Exercise_Home_Page();

        try {
            waitForElementAndClick(By.xpath("//button[@aria-label='Consent']"));
        } catch (Exception e) {
            System.out.println("Consent button not present");
        }

        registerOrderCheckout_po.verify_Home_Page();

    }

    @When("the user clicks the signup-login button")
    public void the_user_clicks_the_signup_login_button() {

        registerOrderCheckout_po.clickOn_Signup_Login_Button();

    }

    @And("the user fills all the required details to create an account")
    public void the_user_fills_all_the_required_details_to_create_an_account() {
        // Generate dynamic test data
        username = faker.name().username();
        String email = faker.internet().emailAddress();
        String password = faker.number().digits(6);
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
        registerOrderCheckout_po.setSignup_Name(username);
        registerOrderCheckout_po.setSignup_Email(email);
        registerOrderCheckout_po.clickOn_Signup_Button();

        // Fill account information
        registerOrderCheckout_po.setGender();
        registerOrderCheckout_po.setPassword(password);
        registerOrderCheckout_po.setDay();
        registerOrderCheckout_po.setMonth();
        registerOrderCheckout_po.setYear();

        // signup to newsletter and special offers
        registerOrderCheckout_po.setNewsLetter();
        registerOrderCheckout_po.setSpecial_Offers();

        // Fill Address Information
        registerOrderCheckout_po.setFirstName(firstname);
        registerOrderCheckout_po.setLastName(lastname);
        registerOrderCheckout_po.setCompany_Name(company);
        registerOrderCheckout_po.setAddress_One(address1);
        registerOrderCheckout_po.setAddress_Two(address2);
        registerOrderCheckout_po.setCountry();
        registerOrderCheckout_po.setSate(state);
        registerOrderCheckout_po.setCity(city);
        registerOrderCheckout_po.setZipcode(zipcode);
        registerOrderCheckout_po.setMobileNumber(mobileNumber);

        registerOrderCheckout_po.createAccount();

    }

    @And("the user verifies ACCOUNT CREATED is displayed")
    public void the_user_verifies_account_created_is_displayed() {

        registerOrderCheckout_po.verify_Account_created_Message();

    }

    @And("the user clicks on the continue button")
    public void the_user_clicks_on_the_continue_shopping() {

        registerOrderCheckout_po.clickOn_Continue_Button();

    }

    @And("the user verifies logged in as username is displayed at the top")
    public void the_user_verifies_logged_in_as_username_is_displayed_at_the_top() {

        registerOrderCheckout_po.verify_username(username);

    }

    @And("the user adds products to the cart")
    public void the_user_adds_products_to_the_cart() {

        registerOrderCheckout_po.addProduct_To_The_Cart();

    }

    @And("the user clicks the cart button")
    public void the_user_clicks_the_cart_button() {

        registerOrderCheckout_po.clickOn_View_Cart_Button();

    }

    @And("the user verifies the cart page is displayed")
    public void the_user_verifies_the_cart_page_is_displayed() {

        registerOrderCheckout_po.verify_URL();
    }

    @And("the user clicks Proceed to Checkout")
    public void the_user_clicks_proceed_to_checkout() {

        registerOrderCheckout_po.clickOn_Checkout_Button();

    }

    @And("the user verifies Address Details and Review Your Order are displayed")
    public void the_user_verifies_address_details_and_review_your_order_are_displayed() {

        registerOrderCheckout_po.verify_Address_Details();
        registerOrderCheckout_po.verify_Review();

    }

    @And("the user enters a description in the comment text area")
    public void the_user_enters_a_description_in_the_comment_text_area() {
        String comment = faker.lorem().sentence(4);
        registerOrderCheckout_po.setComment(comment);

    }

    @And("the user clicks the Place Order button")
    public void the_user_clicks_the_place_order_button() {

        registerOrderCheckout_po.clickOn_Place_Order_Button();

    }

    @And("the user enters payment details including Name on Card, Card Number, CVC, and Expiration Date")
    public void the_user_enters_payment_details_including_name_on_card_card_number_cvc_and_expiration_date() {
        // Generate dynamic test data
        String cardNumber = faker.number().digits(12);
        String cvc = faker.number().digits(3);
        String expiryMonth = String.valueOf(faker.number().numberBetween(1, 12));
        String expiryYear = String.valueOf(faker.number().numberBetween(2026, 2030));

        // fill payment details
        registerOrderCheckout_po.setName_On_Card(username);
        registerOrderCheckout_po.setCard_Number(cardNumber);
        registerOrderCheckout_po.setCvc(cvc);
        registerOrderCheckout_po.setExpiry_Month(expiryMonth);
        registerOrderCheckout_po.setExpiry_Year(expiryYear);

    }

    @And("the user clicks the Pay and Confirm Order button")
    public void the_user_clicks_the_pay_and_confirm_order_button() {

        registerOrderCheckout_po.clickOn_Pay_Confirm_Order_Button();

    }

    @Then("the user verifies the success message {string}")
    public void the_user_verifies_the_success_message(String successMessage) {

        registerOrderCheckout_po.verify_Success_Message(successMessage);

    }

    @And("the user clicks the Delete Account button")
    public void the_user_clicks_the_delete_account_button() {

        registerOrderCheckout_po.clickOn_Delete_Account_Button();

    }

    @And("the user verifies ACCOUNT DELETED is displayed")
    public void the_user_verifies_account_deleted_is_displayed() {

        registerOrderCheckout_po.verify_Account_deletion();

    }

    @And("the user clicks the Continue button")
    public void the_user_clicks_the_continue_button() {

        registerOrderCheckout_po.clickOn_The_Continue_Button();

    }

}
