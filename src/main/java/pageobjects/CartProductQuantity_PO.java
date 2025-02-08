package pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class CartProductQuantity_PO extends Base_PO {
    public CartProductQuantity_PO() {
        super();
    }

    private @FindBy(xpath = "//body/section[2]/div[1]/div[1]/div[2]/div[1]/div[2]/div[1]/div[2]/ul[1]/li[1]/a[1]")
    WebElement viewProduct;

    private @FindBy(id = "quantity")
    WebElement quantityField;

    private @FindBy(xpath = "//button[@class='btn btn-default cart']")
    WebElement addToCartButton;

    private @FindBy(xpath = "//u[contains(text(),'View Cart')]")
    WebElement viewCartButton;

    private @FindBy(id = "product-1")
    WebElement cartProduct;

    private @FindBy(xpath = "//td[@class='cart_quantity']")
    WebElement productQuantity;

    public void navigateTo_Automation_Exercise_Home_Page() {
        navigateTo_URL("https://automationexercise.com/");
    }

    public void verify_Page_Title() {
        waitFor_Page_Title("Automation Exercise");
    }

    public void clickOn_View_Button() {
        waitForElementAndClick(viewProduct);
    }

    public void verify_Product_Details_Page() {
        waitFor_Page_Title("Automation Exercise - Product Details");
    }

    public void setProductQuantity(int quantity) {
        quantityField.clear();
        sendkeys(quantityField, String.valueOf(quantity));
    }

    public void clickOn_addToCart_Button() {
        waitForElementAndClick(addToCartButton);
    }

    public void clickOn_viewCart_Button() {
        waitForElementAndClick(viewCartButton);
    }

    public void verify_Cart_Page_Details() {
        waitFor(cartProduct);
        Assert.assertTrue(cartProduct.isDisplayed());

        waitFor(productQuantity);
        String productQuantityText = productQuantity.getText();

        int actualQuantity = Integer.parseInt(productQuantityText);
        Assert.assertEquals(actualQuantity, 4);

    }
}
