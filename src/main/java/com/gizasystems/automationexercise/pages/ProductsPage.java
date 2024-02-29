package com.gizasystems.automationexercise.pages;

<<<<<<< HEAD
import com.gizasystems.automationexercise.utils.GoogleAlert;
=======
>>>>>>> 90fd880 (1. add method for products link)
import com.shaft.driver.SHAFT;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

public class ProductsPage {
<<<<<<< HEAD
    //Variables
    private SHAFT.GUI.WebDriver driver;
    private String url = System.getProperty("baseUrl") + "/products";


    //Locators
    private final By productsPageTitle_div = By.xpath("//h2[@class='title text-center' and text()='All Products']");

    private By viewProduct_link(String productName) {
        return By.xpath("(//p[text()='" + productName + "'])[1]//ancestor::div[@class='product-image-wrapper']//child::a[contains(@href,'/product')]");
    }

    private final By searchTextArea = By.xpath("//input[@id='search_product']");
    private final By searchedProducts = By.xpath("//h2[text()='Searched Products']");
    private final By allProducts = By.xpath("//h2[text()='All Products']");
    private final By searchButton = By.xpath("//button[@id='submit_search']");
    private final By searchResult = By.xpath("//div[@class='productinfo text-center']//p");
    private final By viewProduct = By.xpath("(//i[@class='fa fa-plus-square'])[1]");
    private final By writeReviewSection = By.xpath("//li[@class='active']");
    private final By reviewerName_input = By.id("name");
    private final By reviewerEmail_input = By.id("email");
    private final By reviewText_input = By.name("review");
    private final By submitBtn = By.id("button-review");
    private final By reviewSuccessAlert = By.xpath("//div[@class='alert-success alert']//span");

    private By hoverOnProduct(String itemName) {
        return By.xpath("//div[@class='productinfo text-center']//child::p[text()='" + itemName + "']");
    }

    private By ClickOnProduct(String itemName) {
        return By.xpath("//div[@class='overlay-content']//p[text()='" + itemName + "']//following-sibling::a[text()='Add to cart']");

    }

    private By hoverOnProduct(Integer Index) {
        return By.xpath("(//div[@class=\"single-products\"]//img)[" + Index + "]");
    }

    private By ClickOnProduct(Integer Index) {
        return By.xpath("(//a[@data-product-id=\"" + Index + "\"])[" + Index + "]");

    }

    private By hoverOnProduct(String itemName) {
        return By.xpath("//div[@class='productinfo text-center']//child::p[text()='" + itemName + "']");
    }

    private By ClickOnProduct(String itemName) {
        return By.xpath("//div[@class='overlay-content']//p[text()='" + itemName + "']//following-sibling::a[text()='Add to cart']");

    }

    //Constructors
=======
    // Variables
    private SHAFT.GUI.WebDriver driver;

    // Locators
    private final By searchProduct = By.id("search_product");
    private final By viewProduct = By.xpath("(//i[@class='fa fa-plus-square'])[1]");
    private final By writeReviewSection = By.xpath("//li[@class='active']");
    private final By reviewerName_input =By.id("name");
    private final By reviewerEmail_input =By.id("email");
    private final By reviewText_input = By.name("review");
    private final By submitBtn = By.id("button-review");
    private final By reviewSuccessAlert = By.cssSelector("div.alert-success.alert > span[style=\"font-size: 20px;\"]");

    // Constructor
>>>>>>> 90fd880 (1. add method for products link)
    public ProductsPage(SHAFT.GUI.WebDriver driver) {
        this.driver = driver;
    }

    //////////////////// Actions \\\\\\\\\\\\\\\\\\\\
<<<<<<< HEAD
    @Step("Pick Product")
    public ProductsPage pickProduct(String productName) {
        driver.element().click(viewProduct_link(productName));
        GoogleAlert.dismissAlert(driver, viewProduct_link(productName));
        return this;
    }

    @Step("Enter product name in search input and click search button")
    public ProductsPage searchForProduct(String SearchedProduct) {
        driver.element().type(searchTextArea, SearchedProduct);
        driver.element().click(searchButton);
        return this;
    }
    public ProductsPage navigate() {
        driver.browser().navigateToURL(url);
        return this;
    }

    @Step("Add Products to Cart")
    public ProductsPage addProductsToCart(Integer index, Integer itemID) {
        driver.element().hover(hoverOnProduct(index));
        driver.element().click(ClickOnProduct(itemID));
        return this;
    }

    public ProductsPage navigate() {
        driver.browser().navigateToURL(url);
        return this;
    }

    @Step("Add Products to Cart")
    public ProductsPage addProductsToCart(String ProductName) {
        driver.element().hover(hoverOnProduct(ProductName));
        driver.element().click(ClickOnProduct(ProductName));
        return this;
    }

    @Step("Click on View Product Link")
    public ProductsPage clickOnViewProduct() {
        driver.element().click(viewProduct);
        return this;
    }

    @Step("Add Review")
    public ProductsPage AddReviewOnProduct(String reviewerName, String reviewerEmail, String reviewText) {
        driver.element()
                .type(reviewerName_input, reviewerName)
                .type(reviewerEmail_input, reviewerEmail)
                .type(reviewText_input, reviewText)
                .click(submitBtn);
        return this;
    }

    public ProductsPage navigate() {
        driver.browser().navigateToURL(url);
        return this;
    }

    @Step("Add Products to Cart")
    public ProductsPage addProductsToCart(String ProductName) {
        driver.element().hover(hoverOnProduct(ProductName));
        driver.element().click(ClickOnProduct(ProductName));
        return this;
    }

    //////////////////// Validations \\\\\\\\\\\\\\\\\\\\
    @Step("Validate on Visibility of the Products Page Title")
    public ProductsPage VerifyProductPageTitleVisibility() {
        driver.assertThat().element(productsPageTitle_div).isVisible().perform();
        return this;
    }

    @Step("Verify user is navigated to ALL PRODUCTS page successfully")
    public ProductsPage validateOnallProductPage() {
        GoogleAlert.dismissAlert(driver, allProducts);
        driver.assertThat().element(allProducts).isVisible().perform();
        return this;
    }

    @Step("Verify 'SEARCHED PRODUCTS' is visible")
    public ProductsPage validateOnsearchedProducts() {
        driver.element().assertThat(searchedProducts).isVisible().perform();
        return this;
    }

    @Step("Verify all the products related to search are visible")
    public ProductsPage validateOnProductsRelatedToSearch(String SearchResult) {
        driver.element().assertThat(searchResult).text().isEqualTo(SearchResult).perform();
        return this;
    }

    @Step("Validate that Review page is displayed")
    public ProductsPage validateVisibilityOfReviewPage() {
        driver.verifyThat().element(writeReviewSection).exists().perform();
        return this;
    }

    @Step("Validate that Review success alert is displayed")
    public ProductsPage validatethatReviewSuccessAlertIsDisplayed() {
        driver.verifyThat().element(reviewSuccessAlert).exists().perform();
        return this;
    }
}
=======
    @Step("Click on View Product Link")
    public ProductsPage clickOnViewProduct(){
        driver.element().click(viewProduct);
        return this;
    }

    @Step("Add Review")
    public ProductsPage AddReviewOnProduct(String reviewerName,String reviewerEmail,String reviewText){
        driver.element()
                .type(reviewerName_input,reviewerName)
                .type(reviewerEmail_input,reviewerEmail)
                .type(reviewText_input,reviewText)
                .click(submitBtn);

        return this;
    }
    //////////////////// Validations \\\\\\\\\\\\\\\\\\\\
    @Step("Validate on Visibility of the Products Page")
    public ProductsPage validateOnVisibilityOfProductsPage(){
        driver.verifyThat().element(searchProduct).exists().perform();
       return this;
    }

    @Step("Validate that Review page is displayed")
    public  ProductsPage validateVisibilityOfReviewPage(){
        driver.verifyThat().element(writeReviewSection).exists().perform();
        return this;
    }

    @Step("Validate that Review success alert is displayed")
    public ProductsPage validatethatReviewSuccessAlertIsDisplayed(){
        driver.verifyThat().element(reviewSuccessAlert).exists().perform();
        return this;
    }


}

>>>>>>> 90fd880 (1. add method for products link)
