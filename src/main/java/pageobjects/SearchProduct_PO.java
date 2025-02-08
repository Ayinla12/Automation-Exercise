package pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import java.util.List;

public class SearchProduct_PO extends Base_PO {

    public SearchProduct_PO() {
        super();
    }

    private @FindBy(partialLinkText = "Products")
    WebElement productsButton;

    private @FindBy(id = "search_product")
    WebElement searchInputField;

    private @FindBy(id = "submit_search")
    WebElement searchButton;

    private @FindBy(className = "features_items")
    WebElement searchedProducts;

    private @FindBy(className = "product-image-wrapper")
    List<WebElement> productWrapper;


    public void navigateTo_AutomationExercise_Home_Page() {
        navigateTo_URL("https://automationexercise.com/");
    }

    public void verify_Home_Page() {
        waitFor_Page_Title("Automation Exercise");
    }

    public void verify_URL() {
        waitFor_URL("https://automationexercise.com/products");
    }

    public void clickOn_Products_Button() {
        waitForElementAndClick(productsButton);
    }

    public void setSearch_Input(String productName) {
        sendkeys(searchInputField, productName);
    }

    public void clickOn_search_Button() {
        waitForElementAndClick(searchButton);
    }

    public void assertionOf_Displayed_Searched_Products() {
        waitFor(searchedProducts);
        Assert.assertTrue(searchedProducts.isDisplayed());

    }

    public void verify_Searched_Product() {
        waitForAll(productWrapper);
        Assert.assertFalse(productWrapper.isEmpty());
    }

}
