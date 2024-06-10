package com.fms.pageobject;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Termsandconditions {

    // WebDriver instance and Logger declaration
	public WebDriver driver;
	public static final Logger logger = LogManager.getLogger(Termsandconditions.class);

    // WebElement declaration using @FindBy annotation
    @FindBy(linkText = "Terms")
    public WebElement termsLinkLinkText;

    // Constructor to initialize WebDriver and Page Factory
    public Termsandconditions(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // Method to click on the terms link
    public void clickTermsLink() {
        try {
            termsLinkLinkText.click(); // Clicking on the terms link
            String currentUrl = driver.getCurrentUrl(); // Get the current URL after clicking
            String expectedUrl = "https://www.truckrr.com/terms-and-conditions/"; // Expected URL after clicking the link
            
            // Verify if the correct link is opened
            if (currentUrl.equals(expectedUrl)) {
                logger.info("Correct link opened: " + currentUrl); // Log message if correct link is opened
            } else {
                logger.error("Incorrect link opened: " + currentUrl); // Log message if incorrect link is opened
            }
        } catch (Exception e) {
            logger.error("Error occurred while clicking the Terms link: " + e.getMessage()); // Log any exceptions
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