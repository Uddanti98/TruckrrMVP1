package com.fms.utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ReadConfig {

    private Properties properties;

    public ReadConfig(String configFilePath) {
        loadProperties(configFilePath);
    }

    private void loadProperties(String configFilePath) {
        try (FileInputStream fis = new FileInputStream(configFilePath)) {
            properties = new Properties();
            properties.load(fis);
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("Failed to load configuration properties from file: " + configFilePath);
        }
    }

    public String getBaseUrl() {
        return properties.getProperty("Url");
    }

    public String getBaseUrl1() {
        return properties.getProperty("Url1");
    }

    public String getBrowser() {
        return properties.getProperty("browser");
    }

    // Static method to get the URL property
    public static String getUrl(String configFilePath) {
        ReadConfig config = new ReadConfig(configFilePath);
        return config.getBaseUrl();
    }
}
