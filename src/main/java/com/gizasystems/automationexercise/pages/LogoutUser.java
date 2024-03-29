package com.gizasystems.automationexercise.pages;

import com.shaft.driver.SHAFT;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

public class LogoutUser {

    //Variables
    private SHAFT.GUI.WebDriver driver;

    //Locators

    private final By Logout_button = By.xpath("//a[contains(text(),\" Logout\")]");

    //Constructors
    public LogoutUser(SHAFT.GUI.WebDriver driver) {
        this.driver = driver;
    }

    //////////////////////////Actions\\\\\\\\\\\\\\\\\\\\
    @Step("Navigate to Home Page")
    public LogoutUser logOut() {
        driver.element().click(Logout_button);
        return this;
    }

}
