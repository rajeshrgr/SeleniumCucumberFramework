package com.demo.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class LoginPage {
    WebDriver driver;
    WebDriverWait wait;

    // Constructor: Initialize WebDriver and WebDriverWait
    public LoginPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));  // 10 seconds timeout
    }

    // Locators
    private By signIn = By.xpath("//span[text()='Hello, sign in']");
    private By username = By.id("ap_email");
    private By password = By.name("password");
    private By continueBtn = By.id("continue");
    private By submitButton = By.id("signInSubmit");
    private By homeUsername = By.xpath("//span[text()='Hello, Rajesh']");

    public void enterUsername(String user) {
        WebElement userField = wait.until(ExpectedConditions.visibilityOfElementLocated(username));
        userField.sendKeys(user);
    }

    public void enterPassword(String pass) {
        WebElement passField = wait.until(ExpectedConditions.visibilityOfElementLocated(password));
        passField.sendKeys(pass);
    }

    public void clickContinueBtn() {
        WebElement continueButton = wait.until(ExpectedConditions.elementToBeClickable(continueBtn));
        continueButton.click();
    }

    public void clickLogin() {
        WebElement loginButton = wait.until(ExpectedConditions.elementToBeClickable(submitButton));
        loginButton.click();
    }

    public void clickSignIn() {
        WebElement signInButton = wait.until(ExpectedConditions.elementToBeClickable(signIn));
        signInButton.click();
    }

    public void verifyDashboard() {
        WebElement dashboardElement = wait.until(ExpectedConditions.visibilityOfElementLocated(homeUsername));
        if (dashboardElement.isDisplayed()) {
            System.out.println("Login Successful!");
        } else {
            throw new RuntimeException("Login Failed!");
        }
    }
}
