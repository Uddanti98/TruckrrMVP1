package com.fms.pageobject;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.fms.pageobject.Accountnewsignup;
import com.fms.testcases.BaseClass;

public class TC_NewsignuppagePage extends BaseClass {
   
    public static final Logger logger = LogManager.getLogger(TC_NewsignuppagePage.class);
    
    @BeforeMethod
    public void beforeMethod() {
        setup(); // Call the setup method from the base class to initialize the WebDriver instance
    }
    
    @Test
    public void verifyRegistrationAndLogin() {
        if (driver == null) {
            logger.error("WebDriver instance is null. Setup method in BaseClass might not have been called.");
            return;
        }
        
        try {
            // Navigate to the sign-up page
            driver.get(Url());
            logger.info("Navigated to the sign-up page");
            
            // Create an instance of the sign-up page
            Accountnewsignup signUpPage = new Accountnewsignup(driver);

            // Test case: Enter invalid mobile number
            String invalidMobileNumber = "12345"; // Invalid mobile number
            signUpPage.enterMobileNumber(invalidMobileNumber);

            // Check if error message is displayed for invalid mobile number
            String errorMessage1 = signUpPage.getValidationMessageText();
            logger.info("Error message for invalid mobile number: " + errorMessage1);

            // Test case: Enter name with unwanted characters
            String nameWithUnwantedCharacters = "John123"; // Name with unwanted characters
            signUpPage.enterUsername(nameWithUnwantedCharacters);

            // Check if error message is displayed for name with unwanted characters
            String errorMessage2 = signUpPage.getValidationMessageText();
            logger.info("Error message for name with unwanted characters: " + errorMessage2);

            // Test case: Enter valid data
            String validUsername = "Tester";
            String validMobileNumber = "9440252578";
            signUpPage.enterUsername(validUsername);
            signUpPage.enterMobileNumber(validMobileNumber);
            signUpPage.checkAgreementCheckbox();
        } catch (Exception e) {
            logger.error("An error occurred during test execution: " + e.getMessage(), e);
        }
    }

	private String Url() {
		// TODO Auto-generated method stub
		return null;
	}
}
