package com.demo.utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import java.time.Duration;

public class BaseTest {
    public static WebDriver driver;

    public void initializeDriver() {
        String browser = ConfigReader.getProperty("browser").toLowerCase();
        boolean isHeadless = Boolean.parseBoolean(ConfigReader.getProperty("headless"));
        int implicitWait = Integer.parseInt(ConfigReader.getProperty("implicitWait"));
        switch (browser) {
            case "chrome":
                WebDriverManager.chromedriver().setup();
                ChromeOptions chromeOptions = new ChromeOptions();
                if (isHeadless) {
                    chromeOptions.addArguments("--headless");
                }
                driver = new ChromeDriver(chromeOptions);
                break;

            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                FirefoxOptions firefoxOptions = new FirefoxOptions();
                if (isHeadless) {
                    firefoxOptions.addArguments("--headless");
                }
                driver = new FirefoxDriver(firefoxOptions);
                break;

            case "edge":
                WebDriverManager.edgedriver().setup();
                driver = new EdgeDriver();
                break;

            default:
                throw new IllegalArgumentException("Invalid browser name in config.properties: " + browser);
        }

        // Set implicit wait
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(implicitWait));
        driver.manage().window().maximize();
        driver.get(ConfigReader.getProperty("baseURL"));
    }

    public void closeBrowser() {
        if (driver != null) {
            driver.quit();
        }
    }
}
