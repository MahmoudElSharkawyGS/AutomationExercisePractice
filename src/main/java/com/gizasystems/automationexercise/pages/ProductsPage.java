package com.gizasystems.automationexercise.pages;

import com.gizasystems.automationexercise.utils.GoogleAlert;
import com.shaft.driver.SHAFT;
import io.qameta.allure.Step;
import org.openqa.selenium.By;


public class ProductsPage {
    private SHAFT.GUI.WebDriver driver;

    public ProductsPage(SHAFT.GUI.WebDriver driver) {
        this.driver = driver;
    }

    private final By searchTextArea = By.xpath("//input[@id='search_product']");
    private final By searchedProducts = By.xpath("//h2[text()='Searched Products']");
    private final By allProducts = By.xpath("//h2[text()='All Products']");
    private final By searchButton = By.xpath("//button[@id='submit_search']");
    private final By searchResult = By.xpath("//div[@class='productinfo text-center']//p");

    @Step("Enter product name in search input and click search button")
    public ProductsPage searchForProduct(String SearchedProduct) {
        driver.element().type(searchTextArea, SearchedProduct);
        driver.element().click(searchButton);
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
}
