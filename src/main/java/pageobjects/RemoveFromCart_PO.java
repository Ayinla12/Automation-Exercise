package pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import java.util.List;

public class RemoveFromCart_PO extends Base_PO {
    public RemoveFromCart_PO() {
        super();
    }

    private @FindBy(xpath = "//div[@class='productinfo text-center']//a[@data-product-id='4']")
    WebElement fourthProduct;

    private @FindBy(xpath = "//div[@class='productinfo text-center']//a[@data-product-id='5']")
    WebElement fifthProduct;

    private @FindBy(xpath = "//button[contains(text(),'Continue Shopping')]")
    WebElement continueShoppingButton;

    private @FindBy(xpath = "//u[contains(text(),'View Cart')]")
    WebElement viewCartButton;

    private @FindBy(xpath = "//a[@data-product-id='4']")
    WebElement removeProduct;

    private @FindBy(className = "cart_product")
    List<WebElement> cartProduct;


    public void navigateTo_Automation_Exercise_Home_Page() {
        navigateTo_URL("https://automationexercise.com/");
    }

    public void verify_Home_Page() {
        waitFor_Page_Title("Automation Exercise");
    }

    public void addProduct_To_Cart() {
        waitForElementAndClick(fourthProduct);
    }

    public void addAnother_Product_To_Cart() {
        waitForElementAndClick(fifthProduct);
    }

    public void clickOn_Continue_Shopping() {
        waitForElementAndClick(continueShoppingButton);
    }

    public void clickOn_View_Cart_Button() {
        waitForElementAndClick(viewCartButton);
    }

    public void verify_URL() {
        waitFor_URL("https://automationexercise.com/view_cart");
    }

    public void clickOn_X_Button() {
        waitForElementAndClick(removeProduct);
    }

    public void verify_Final_Cart_Size() {

        waitForAll(cartProduct);
        int initialCartSize = cartProduct.size();
        waitForNow(cartProduct.get(0));
        int currentCartSize = cartProduct.size();
        Assert.assertEquals(currentCartSize, initialCartSize - 1);

    }

}
