package com.fms.testcases;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.fms.pageobject.Accountnewsignup;
import com.fms.pageobject.Privacypolicy;
import com.fms.pageobject.Termsandconditions;
import com.fms.utilities.ReadConfig;
import java.time.Duration;
public class TC_NewsignuppagePage extends BaseClass {
    public static Logger logger = LogManager.getLogger(TC_NewsignuppagePage.class);
    ReadConfig readConfig; // Declare ReadConfig instance
    Privacypolicy policyPage;// Declare Privacypolicy instance
    Termsandconditions termsCond; //Declare Termsandconditions instance
    
    @BeforeMethod
    public void beforeMethod() {
        readConfig = new ReadConfig(configFilePath); // Instantiate ReadConfig with configFilePath
        setup(); // Call the setup method from the base class to initialize the WebDriver instance
        policyPage = new Privacypolicy(driver);// Initialize the class variable
        termsCond = new Termsandconditions(driver);// Initialize the termsCond instance variable
    }
    
    @Test
    public void verifyRegistrationAndLogin() {
        try {
            if (driver == null) {
                logger.error("WebDriver instance is null. Setup method in BaseClass might have failed.");
                return;
            }

            String url = readConfig.getBaseUrl(); // Fetch URL from configuration using readConfig instance
            driver.get(url); // Navigate to the URL
            logger.info("Navigated to the sign-up page");
            
            Accountnewsignup signUpPage = new Accountnewsignup(driver);
          
            
//            String nameWithUnwantedCharacters = "John123"; // Name with unwanted characters
//            signUpPage.enterUsername(nameWithUnwantedCharacters);
//            
//            String invalidMobileNumber = "12345"; // Invalid mobile number
//            signUpPage.enterMobileNumber(invalidMobileNumber);
//
//            String errorMessage1 = signUpPage.getValidationMessageText();
//            logger.info("Error message for invalid mobile number: " + errorMessage1);
//
//
//            String errorMessage2 = signUpPage.getValidationMessageText();
//            logger.info("Error message for name with unwanted characters: " + errorMessage2);

            String validUsername = "Tester";
            signUpPage.enterUsername(validUsername);
            String validMobileNumber = "9440252578";
            signUpPage.enterMobileNumber(validMobileNumber);
            driver.findElement(By.cssSelector("input#flexCheckDefault")).click();
            signUpPage.checkAgreementCheckbox();
            
            termsCond.clickTermsLink();
            logger.info("Clicked on the Terms link");
            
         // Navigating back to the sign-up page
            driver.navigate().back();
            
            // Initialize WebDriverWait with PageFactory
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            
            // Click on Privacy Policy link
            policyPage.clickPrivacyPolicyLink(wait);
            
            logger.info("Clicked on the Privacy Policy link");
            
        } catch (Exception e) {
            logger.error("An error occurred during test execution: " + e.getMessage(), e);
        }
        finally  {
            // Ensure proper cleanup
            
            // Cleanup Privacypolicy and Termsandconditions instances
            if (policyPage != null) {
                policyPage.cleanup();
            }
            if (termsCond != null) {
                termsCond.cleanup();
            }
            
            try {
                // Quit WebDriver session
                if (driver != null) {
                    driver.quit();
                    // Log WebDriver session has been quit successfully
                    logger.info("WebDriver session has been quit successfully.");
                }
            } catch (Exception e) {
                // Log any exceptions occurred while quitting the WebDriver session
                logger.error("Error occurred while quitting the WebDriver session: " + e.getMessage());
            }
        }
    }
}