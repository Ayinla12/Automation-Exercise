package pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class AddToCart_PO extends Base_PO {
    public AddToCart_PO() {
        super();
    }


    private @FindBy(partialLinkText = " Products")
    WebElement productsButton;

    private @FindBy(xpath = "//div[@class='productinfo text-center']//a[@data-product-id='1']")
    WebElement firstProduct;

    private @FindBy(xpath = "//button[contains(text(),'Continue Shopping')]")
    WebElement continueShoppingButton;

    private @FindBy(xpath = "//div[@class='productinfo text-center']//a[@data-product-id='2']")
    WebElement secondProduct;

    private @FindBy(xpath = "//u[contains(text(),'View Cart')]")
    WebElement viewCartButton;

    private @FindBy(id = "product-1")
    WebElement productOne;

    private @FindBy(id = "product-2")
    WebElement productTwo;

    private @FindBy(xpath = "//tr[@id='product-1']//td[@class='cart_price']")
    WebElement firstProductPrice;

    private @FindBy(xpath = "//tr[@id='product-1']//td[@class='cart_quantity']//button")
    WebElement firstProductQuantity;

    private @FindBy(xpath = "//tr[@id='product-1']//td[@class='cart_total']//p")
    WebElement firstProductTotalPrice;

    private @FindBy(xpath = "//tr[@id='product-2']//td[@class='cart_price']")
    WebElement secondProductPrice;

    private @FindBy(xpath = "//tr[@id='product-2']//td[@class='cart_quantity']//button")
    WebElement secondProductQuantity;

    private @FindBy(xpath = "//tr[@id='product-2']//td[@class='cart_total']//p")
    WebElement secondProductTotalPrice;

    public void navigateTo_AutomationExercise_HomePage() {
        navigateTo_URL("https://automationexercise.com/");
    }

    public void verificationOf_Page_Title() {
        waitFor_Page_Title("Automation Exercise");
    }

    public void clickOn_productsButton() {
        waitForElementAndClick(productsButton);
    }

    public void add_firstProduct_To_Cart() {
        waitForElementAndClick(firstProduct);
    }

    public void clickOn_Continue_Shopping_Button() {
        waitForElementAndClick(continueShoppingButton);
    }

    public void add_secondProduct_To_Cart() {
        waitForElementAndClick(secondProduct);
    }

    public void clickOn_ViewCart_Button() {
        waitForElementAndClick(viewCartButton);
    }

    public void verificationOf_ProductOne() {
        waitFor(productOne);
        Assert.assertTrue(productOne.isDisplayed());
    }

    public void verificationOf_ProductTwo() {
        waitFor(productTwo);
        Assert.assertTrue(productTwo.isDisplayed());
    }

    public void verificationOf_First_Product_Detail() {
        waitFor(firstProductPrice);
        String priceText1 = firstProductPrice.getText().replace("Rs.", "");
        waitFor(firstProductQuantity);
        String quantityText1 = firstProductQuantity.getText();
        waitFor(firstProductTotalPrice);
        String totalPriceText1 = firstProductTotalPrice.getText().replace("Rs.", "");

        double price1 = Double.parseDouble(priceText1);
        int quantity1 = Integer.parseInt(quantityText1);
        double totalPrice1 = Double.parseDouble(totalPriceText1);

        Assert.assertEquals(totalPrice1, price1 * quantity1);

    }

    public void verificationOf_Second_Product_Detail() {
        waitFor(secondProductPrice);
        String priceText2 = secondProductPrice.getText().replace("Rs.", "");
        waitFor(secondProductQuantity);
        String quantityText2 = secondProductQuantity.getText();
        waitFor(secondProductTotalPrice);
        String totalPriceText2 = secondProductTotalPrice.getText().replace("Rs.", "");

        double price2 = Double.parseDouble(priceText2);
        int quantity2 = Integer.parseInt(quantityText2);
        double totalPrice2 = Double.parseDouble(totalPriceText2);

        Assert.assertEquals(totalPrice2, price2 * quantity2);

    }

}
