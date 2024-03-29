package com.gizasystems.automationexercise.pages;

import com.gizasystems.automationexercise.utils.GoogleAlert;
import com.shaft.driver.SHAFT;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

public class ProductQuantityPage {
    // Locators
    private final SHAFT.GUI.WebDriver driver;
    private final By viewProductbtn_button = By.xpath("(//div[@class='choose']//a)[2]");
    private final By productDetails = By.xpath("//span/Label");
    private final By hoverBtn_button = By.id("quantity");
    private final By addToCartbtn_Button = By.xpath("//button[@class='btn btn-default cart']");
    private final By viewCartbtn_button = By.xpath("//p[@class='text-center']/a[@href='/view_cart']/u");
    private final By productQuantity_button = By.xpath("//td[@class ='cart_quantity']/button[@class='disabled']");

    // Constructor
    public ProductQuantityPage(SHAFT.GUI.WebDriver driver) {
        this.driver = driver;
    }

    //////////////////// Actions \\\\\\\\\\\\\\\\\\\\
    @Step("Click on View Product")
    public ProductQuantityPage clickOnViewProduct() {
        driver.element().click(viewProductbtn_button);
        GoogleAlert.dismissAlert(driver, viewProductbtn_button);
        return this;
    }

    @Step("Increase Quantity in Cart")
    public ProductQuantityPage increaseQuantityInCart(String quantity) {
        driver.element()
                .hover(hoverBtn_button)
                .click(hoverBtn_button)
                .type(hoverBtn_button, quantity);
        return this;
    }

    @Step("Add Product to Cart")
    public ProductQuantityPage addProductToCart() {
        driver.element().click(addToCartbtn_Button);
        return this;
    }

    @Step("Click on view Cart button")
    public ProductQuantityPage clickOnCart() {
        driver.element().click(viewCartbtn_button);
        return this;
    }
    @Step("Refresh Cart Page")
    public ProductQuantityPage refreshCartPage(){
        driver.browser().refreshCurrentPage();
        return this;
    }

    //////////////////// Validations \\\\\\\\\\\\\\\\\\\\
    @Step("Verify that Product details is opened")
    public ProductQuantityPage verifyOnProductDetails() {
        driver.element().assertThat(productDetails).exists().perform();
        return this;
    }
    @Step("Verify Product Added to Cart with exact quantity")
    public ProductQuantityPage verifyExactQuantityAddedToCart(String quantity) {
        driver.element().assertThat(productQuantity_button).text().isEqualTo(quantity).perform();
        return this;
    }

}
