package com.fms.testcases;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import com.fms.utilities.ReadConfig;
import io.github.bonigarcia.wdm.WebDriverManager;
import java.time.Duration;

public class BaseClass {
    public WebDriver driver;
    public static Logger logger = LogManager.getLogger(BaseClass.class);
    // Path to the configuration file
    public String configFilePath = "C:\\Users\\Caddy\\eclipse-workspace\\TruckrrAutomation\\Truckrr FMS Automation Project By Mohan 1\\TruckrrMvp1\\Configuration\\config.properties";

    public BaseClass() {}

    public BaseClass(String configFilePath) {
        this.configFilePath = configFilePath;
    }

    @BeforeClass
    public void setup() {
        // Log message indicating loading of configuration
        logger.info("Loading configuration from: " + configFilePath);
        try {
            // Add logging before initializing WebDriver
            logger.info("Initializing WebDriver...");
            
            // Create an instance of ReadConfig to read configuration properties
            ReadConfig readConfig = new ReadConfig(configFilePath);
            // Get the browser value from the configuration
            String browser = readConfig.getBrowser();

            // Set up WebDriver based on the browser specified in the configuration
            switch (browser.toLowerCase()) {
                case "chrome":
                    // Setup ChromeDriver using WebDriverManager
                    WebDriverManager.chromedriver().setup();
                    // Initialize WebDriver instance with ChromeDriver
                    driver = new ChromeDriver();
                    break;
                case "firefox":
                    // Setup FirefoxDriver using WebDriverManager
                    WebDriverManager.firefoxdriver().setup();
                    // Initialize WebDriver instance with FirefoxDriver
                    driver = new FirefoxDriver();
                    break;
                case "edge":
                    // Setup EdgeDriver using WebDriverManager
                    WebDriverManager.edgedriver().setup();
                    // Initialize WebDriver instance with EdgeDriver
                    driver = new EdgeDriver();
                    break;
                default:
                    // Log an error message if an invalid browser is specified in the configuration
                    logger.error("Invalid browser specified in configuration: " + browser);
                    break;
            }

            // Check if driver is initialized successfully
            if (driver != null) {
                // Set implicit wait timeout for the WebDriver instance
                driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
                // Log success message for WebDriver initialization
                logger.info("WebDriver instance initialized successfully.");
            } else {
                // Log error message if WebDriver instance is null
                logger.error("WebDriver instance is null. WebDriver setup failed.");
            }
        } catch (Exception e) {
            // Log error message if an exception occurs during WebDriver setup
            logger.error("Error occurred during WebDriver setup: " + e.getMessage());
            // Handle the exception gracefully
            // For example, you could print the stack trace or log additional details
            e.printStackTrace();
        }
    }

    @AfterSuite
    public void tearDownSuite() {
        // Quit WebDriver instance after the suite (if WebDriver instance is not null)
        if (driver != null) {
            driver.quit();
        }
    }
}
