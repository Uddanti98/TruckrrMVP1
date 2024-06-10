package com.fms.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Privacypolicy {

    // WebElement declaration
    @FindBy(linkText = "Privacy policy")
    public WebElement privacyPolicyLink;

    // WebDriver instance
    public WebDriver driver;

    // Logger instance
    public static final Logger logger = LogManager.getLogger(Privacypolicy.class);

    // Constructor to initialize WebDriver and Page Factory
    public Privacypolicy(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // Method to click on the privacy policy link
    public void clickPrivacyPolicyLink(WebDriverWait wait) {
        try {
            // Explicit wait for the presence of the privacy policy link
            WebElement privacyPolicyLinkElement = wait.until(ExpectedConditions.visibilityOf(privacyPolicyLink));

            // Click on the privacy policy link
            privacyPolicyLinkElement.click();

            // Verify the URL after clicking the link
            String currentUrl = driver.getCurrentUrl();
            String expectedUrl = "https://www.truckrr.com/privacy-policy/";

            if (currentUrl.equals(expectedUrl)) {
                logger.info("Correct link opened: " + currentUrl);
            } else {
                logger.error("Incorrect link opened: " + currentUrl);
            }
        } catch (Exception e) {
            logger.error("Error occurred while clicking the Privacy Policy link: " + e.getMessage());
        }
    }

    // Method to quit the WebDriver session
    public void quitDriver() {
        try {
            driver.quit();
            logger.info("WebDriver session has been quit successfully.");
        } catch (Exception e) {
            logger.error("Error occurred while quitting the WebDriver session: " + e.getMessage());
        }
    }

    // Method to close the current browser window
    public void closeBrowser() {
        try {
            driver.close();
            logger.info("Current browser window has been closed successfully.");
        } catch (Exception e) {
            logger.error("Error occurred while closing the current browser window: " + e.getMessage());
        }
    }
 // Method to perform cleanup tasks specific to the Privacy Policy page
    public void cleanup() {
        closeBrowser(); // Close the browser window
        quitDriver();   // Quit the WebDriver session
    }
}
