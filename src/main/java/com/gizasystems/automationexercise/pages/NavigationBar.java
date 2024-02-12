package com.gizasystems.automationexercise.pages;

import com.shaft.driver.SHAFT;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;

import javax.swing.*;

public class NavigationBar {
    // Variables
    private  SHAFT.GUI.WebDriver driver;

    // Locators
    private final By signupLogin_link = By.cssSelector("a[href='/login']");
    private final By delete_link = By.cssSelector("a[href='/delete_account']");
    private final By loggedInUser_link = By.xpath("//i[@class = 'fa fa-user']/parent::a");
    private final By TestCase_link = By.cssSelector("li > a[href='/test_cases']");

    private final By contactUs_link = By.cssSelector("a[href='/contact_us']");

    // Constructor
    public NavigationBar(SHAFT.GUI.WebDriver driver) {
        this.driver = driver;
    }

    //////////////////// Actions \\\\\\\\\\\\\\\\\\\\
    @Step("click on Signup Login Link")
    public NavigationBar clickOnSignupLoginLink() {
        driver.element().click(signupLogin_link);
        return this;
    }

    @Step("Click on Delete Account Link")
    public NavigationBar clickOnDeleteAccountLink() {
        driver.element().click(delete_link);
        return this;
    }
    @Step("Click on ContactUs Account Link")
    public NavigationBar clickOnContactUsLink() {
        driver.element().clickUsingJavascript(contactUs_link);
        return this;
    }

    @Step("Click on test Case")
    public NavigationBar ClickOnTestCase (){
        driver.element().click(TestCase_link);


        Actions action = new Actions(driver.getDriver());
        action.pause(1000).doubleClick().perform();

      return this;

    }

    //////////////////// Validations \\\\\\\\\\\\\\\\\\\\
    @Step("Validate the Logged In User")
    public NavigationBar validateTheLoggedInUser(String expectedUser) {
        driver.verifyThat().element(loggedInUser_link).text().isEqualTo("Logged in as " + expectedUser).perform();
        return this;
    }


}
