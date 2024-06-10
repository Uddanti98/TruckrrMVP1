package com.fms.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Accountnewsignup {

    // WebDriver object
    public WebDriver driver;

    // Constructor to initialize WebDriver and Page Factory
    public Accountnewsignup(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this); // Initializing elements using Page Factory
    }

    // WebElement for username input field
    @FindBy(id = "UserName")
    public WebElement username;

    // WebElement for mobile number input field
    @FindBy(id = "PhoneNumber")
    public WebElement mobilenumber;

    // WebElement for agreement checkbox
    @FindBy(id = "flexCheckDefault")
    public WebElement agreementCheckbox;

    // WebElement for validation message
    @FindBy(id = "flexCheckDefaultValidation")
    public WebElement validationMessage;

    // Method to get validation message text
    public String getValidationMessageText() {
        return validationMessage.getText();
    }

    // Method to set username
    public void setUsername(String usernameText) {
        try {
            username.sendKeys(usernameText);
        } catch (Exception e) {
            System.out.println("Error occurred while setting username: " + e.getMessage());
        }
    }

    // Method to set mobile number
    public void setMobileNumber(String mobileNumberText) {
        try {
            mobilenumber.sendKeys(mobileNumberText);
        } catch (Exception e) {
            System.out.println("Error occurred while setting mobile number: " + e.getMessage());
        }
    }

    // Method to check the agreement checkbox
    public void checkAgreementCheckbox() {
        try {
            if (!agreementCheckbox.isSelected()) {
                agreementCheckbox.click();
            }
        } catch (Exception e) {
            System.out.println("Error occurred while checking agreement checkbox: " + e.getMessage());
        }
    }

    // Method to enter mobile number
    public void enterMobileNumber(String mobileNumber) {
        try {
            mobilenumber.sendKeys(mobileNumber);
        } catch (Exception e) {
            System.out.println("Error occurred while entering mobile number: " + e.getMessage());
        }
    }

    // Method to enter name
    public void enterUsername(String name) {
        try {
            username.sendKeys(name);
        } catch (Exception e) {
            System.out.println("Error occurred while entering username: " + e.getMessage());
        }
    }

    // Method to quit the WebDriver session
    public void quitDriver() {
        try {
            if (driver != null) {
                driver.quit();
            }
        } catch (Exception e) {
            System.out.println("Error occurred while quitting WebDriver session: " + e.getMessage());
        }
    }
}