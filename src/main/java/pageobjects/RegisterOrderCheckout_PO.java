package pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class RegisterOrderCheckout_PO extends Base_PO {
    public RegisterOrderCheckout_PO() {
        super();
    }

    private @FindBy(partialLinkText = "Signup / Login")
    WebElement singupLoginButton;

    private @FindBy(xpath = "//input[@data-qa='signup-name']")
    WebElement signupNameField;

    private @FindBy(xpath = "//input[@data-qa='signup-email']")
    WebElement signupEmailField;

    private @FindBy(xpath = "//button[@data-qa='signup-button']")
    WebElement signupButton;

    private @FindBy(id = "id_gender1")
    WebElement getGender;

    private @FindBy(id = "password")
    WebElement passwordField;

    private @FindBy(id = "days")
    WebElement daysField;

    private @FindBy(id = "months")
    WebElement monthsField;

    private @FindBy(id = "years")
    WebElement yearsField;

    private @FindBy(id = "newsletter")
    WebElement getNewsLetter;

    private @FindBy(id = "optin")
    WebElement getSpecialOffer;

    private @FindBy(id = "first_name")
    WebElement firstNameField;

    private @FindBy(id = "last_name")
    WebElement lastNameField;

    private @FindBy(id = "company")
    WebElement companyNameField;

    private @FindBy(id = "address1")
    WebElement addressOneField;

    private @FindBy(id = "address2")
    WebElement addressTwoField;

    private @FindBy(id = "country")
    WebElement countryField;

    private @FindBy(id = "state")
    WebElement stateField;

    private @FindBy(id = "city")
    WebElement cityField;

    private @FindBy(id = "zipcode")
    WebElement zipcodeField;

    private @FindBy(id = "mobile_number")
    WebElement mobileField;

    private @FindBy(xpath = "//button[@data-qa='create-account']")
    WebElement createAccountButton;

    private @FindBy(xpath = "//h2[@data-qa='account-created']//b")
    WebElement accountCreation;

    private @FindBy(xpath = "//a[@data-qa='continue-button']")
    WebElement continueButton;

    private @FindBy(xpath = "//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[10]/a/b")
    WebElement usernameDisplayed;

    private @FindBy(xpath = "//body/section[2]/div[1]/div[1]/div[2]/div[2]/div[1]/div[1]/div[1]/div[3]/div[1]/div[1]/div[1]/a[1]")
    WebElement addToCart;

    private @FindBy(xpath = "//u[contains(text(),'View Cart')]")
    WebElement viewCartButton;

    private @FindBy(xpath = "//div[@class='col-sm-6']//a[@class='btn btn-default check_out']")
    WebElement checkoutButton;

    private @FindBy(xpath = "//h2[contains(text(),'Address Details')]")
    WebElement addressDetails;

    private @FindBy(xpath = "//h2[contains(text(),'Review Your Order')]")
    WebElement reviewOrder;

    private @FindBy(xpath = "//textarea[@name='message']")
    WebElement textAreaField;

    private @FindBy(xpath = "//a[contains(text(),'Place Order')]")
    WebElement placeOrderButton;

    private @FindBy(name = "name_on_card")
    WebElement nameOnCardField;

    private @FindBy(name = "card_number")
    WebElement cardNumberField;

    private @FindBy(name = "cvc")
    WebElement cvcField;

    private @FindBy(name = "expiry_month")
    WebElement expiryMonthField;

    private @FindBy(name = "expiry_year")
    WebElement expiryYearField;

    private @FindBy(id = "submit")
    WebElement payAndConfirmOrderButton;

    private @FindBy(xpath = "//p[contains(text(),'Congratulations! Your order has been confirmed!')]")
    WebElement confirmation;

    private @FindBy(partialLinkText = "Delete Account")
    WebElement deleteAccountButton;

    private @FindBy(xpath = "//div[@class='col-sm-9 col-sm-offset-1']//b")
    WebElement deleteAccount;

    private @FindBy(xpath = "//a[contains(text(),'Continue')]")
    WebElement theContinueButton;

    public void navigateTo_Automation_Exercise_Home_Page() {
        navigateTo_URL("https://automationexercise.com/");
    }

    public void verify_Home_Page() {
        waitFor_Page_Title("Automation Exercise");
    }

    public void clickOn_Signup_Login_Button() {
        waitForElementAndClick(singupLoginButton);
    }

    public void setSignup_Name(String username) {
        sendkeys(signupNameField, username);
    }

    public void setSignup_Email(String email) {
        sendkeys(signupEmailField, email);
    }

    public void clickOn_Signup_Button() {
        waitForElementAndClick(signupButton);
    }

    public void setGender() {
        waitForElementAndClick(getGender);
    }

    public void setPassword(String password) {
        sendkeys(passwordField, password);
    }

    public void setDay() {
        waitFor(daysField);
        Select select = new Select(daysField);
        select.selectByIndex(10);
    }

    public void setMonth() {
        waitFor(monthsField);
        Select select = new Select(monthsField);
        select.selectByValue("10");
    }

    public void setYear() {
        waitFor(yearsField);
        Select select = new Select(yearsField);
        select.selectByVisibleText("2000");
    }

    public void setNewsLetter() {
        waitForElementAndClick(getNewsLetter);
    }

    public void setSpecial_Offers() {
        waitForElementAndClick(getSpecialOffer);
    }

    public void setFirstName(String firstName) {
        sendkeys(firstNameField, firstName);
    }

    public void setLastName(String lastName) {
        sendkeys(lastNameField, lastName);
    }

    public void setCompany_Name(String company) {
        sendkeys(companyNameField, company);
    }

    public void setAddress_One(String addressOne) {
        sendkeys(addressOneField, addressOne);
    }

    public void setAddress_Two(String addressTwo) {
        sendkeys(addressTwoField, addressTwo);
    }

    public void setCountry() {
        waitFor(countryField);
        Select select = new Select(countryField);
        select.selectByIndex(2);
    }

    public void setSate(String state) {
        sendkeys(stateField, state);
    }

    public void setCity(String city) {
        sendkeys(cityField, city);
    }

    public void setZipcode(String zipcode) {
        sendkeys(zipcodeField, zipcode);
    }

    public void setMobileNumber(String mobile) {
        sendkeys(mobileField, mobile);
    }

    public void createAccount() {
        waitForElementAndClick(createAccountButton);
    }

    public void verify_Account_created_Message() {
        waitFor(accountCreation);
        String accountCreationText = accountCreation.getText().toLowerCase();
        Assert.assertEquals(accountCreationText, "account created!");
    }

    public void clickOn_Continue_Button() {
        waitForElementAndClick(continueButton);
    }

    public void verify_username(String username) {
        waitFor(usernameDisplayed);
        Assert.assertEquals(usernameDisplayed.getText(), username);
    }

    public void addProduct_To_The_Cart() {
        waitForElementAndClick(addToCart);
    }

    public void clickOn_View_Cart_Button() {
        waitForElementAndClick(viewCartButton);
    }

    public void verify_URL() {
        waitFor_URL("https://automationexercise.com/view_cart");
    }

    public void clickOn_Checkout_Button() {
        waitForElementAndClick(checkoutButton);
    }

    public void verify_Address_Details() {
        waitFor(addressDetails);
        Assert.assertTrue(addressDetails.isDisplayed());
    }

    public void verify_Review() {
        waitFor(reviewOrder);
        Assert.assertTrue(reviewOrder.isDisplayed());
    }

    public void setComment(String comment) {
        sendkeys(textAreaField, comment);
    }

    public void clickOn_Place_Order_Button() {
        waitForElementAndClick(placeOrderButton);
    }

    public void setName_On_Card(String username) {
        sendkeys(nameOnCardField, username);
    }

    public void setCard_Number(String cardNumber) {
        sendkeys(cardNumberField, cardNumber);
    }

    public void setCvc(String cvc) {
        sendkeys(cvcField, cvc);
    }

    public void setExpiry_Month(String expiryMonth) {
        sendkeys(expiryMonthField, expiryMonth);
    }

    public void setExpiry_Year(String expiryYear) {
        sendkeys(expiryYearField, expiryYear);
    }


    public void clickOn_Pay_Confirm_Order_Button() {
        waitForElementAndClick(payAndConfirmOrderButton);
    }

    public void verify_Success_Message(String successMessage) {
        waitFor(confirmation);
        Assert.assertEquals(confirmation.getText(), successMessage);
    }

    public void clickOn_Delete_Account_Button() {
        waitForElementAndClick(deleteAccountButton);
    }

    public void verify_Account_deletion() {
        waitFor(deleteAccount);
        String deleteAccountTest = deleteAccount.getText();
        Assert.assertEquals(deleteAccountTest, "ACCOUNT DELETED!");
    }

    public void clickOn_The_Continue_Button() {
        waitForElementAndClick(theContinueButton);
    }
}
