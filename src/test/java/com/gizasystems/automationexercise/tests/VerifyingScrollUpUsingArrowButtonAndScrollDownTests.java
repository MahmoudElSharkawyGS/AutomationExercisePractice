package com.gizasystems.automationexercise.tests;

import com.gizasystems.automationexercise.pages.Footer;
import com.gizasystems.automationexercise.pages.HomePage;
import com.shaft.driver.SHAFT;
import io.qameta.allure.*;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

@Epic("Automation Exercise")
@Feature("Home page navigation")
@Story("Verify Scroll Up using 'Arrow' button and Scroll Down functionality")
public class VerifyingScrollUpUsingArrowButtonAndScrollDownTests {
    // Variables
    private SHAFT.GUI.WebDriver driver;
    private SHAFT.TestData.JSON testUser;

    // Test Cases
    @Test(description = "Verify scrolling functionality on the homepage with the arrow button")
    @Description("Given I open Automation Exercise home, When I scroll down the page to the bottom, Then I verify that 'SUBSCRIPTION' is visible on the screen, When I click on the arrow at the bottom right side to move upward, Then I verify that the page is scrolled up, And I verify that 'Full-Fledged practice website for Automation Engineers' text is visible on the screen")
    @TmsLink("55512524")
    public void verifyScrollingUpUsingArrowButtonInHomePage() {
        new Footer(driver)
                .scrollToBottomPage()
                .verifySubscriptionText(testUser.getTestData("subText"));
        new HomePage(driver)
                .clickOnScrollUpArrow()
                .validateOnVisibilityOfCarouselSlideText(testUser.getTestData("slideHeadingText"));
    }

    //////////////////// Configurations \\\\\\\\\\\\\\\\\\\\
    @BeforeClass
    public void beforeClass() {
        testUser = new SHAFT.TestData.JSON("src/test/resources/testDataFiles/ScrollingTestData.json");
    }
    @BeforeMethod
    public void beforeMethod() {
        driver = new SHAFT.GUI.WebDriver();
        new HomePage(driver)
                .navigate()
                .validateOnVisibilityOfHomePage();
    }
    @AfterMethod
    public void afterMethod() {
        driver.quit();
    }
}
