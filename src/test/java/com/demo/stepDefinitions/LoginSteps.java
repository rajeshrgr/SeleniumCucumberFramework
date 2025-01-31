package com.demo.stepDefinitions;

import org.openqa.selenium.support.PageFactory;

import com.demo.pages.LoginPage;
import com.demo.utils.BaseTest;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginSteps extends BaseTest{
    LoginPage loginPage;

	@Given("I open the browser")
	public void i_open_the_browser() {
		initializeDriver();
        loginPage = PageFactory.initElements(driver, LoginPage.class);

	}
	@When("I enter username {string} and password {string}")
	public void i_enter_username_and_password(String username, String password) {
	    loginPage.clickSignIn();
		loginPage.enterUsername(username);
	    loginPage.clickContinueBtn();
	    loginPage.enterPassword(password);
	}
	@When("I click on login button")
	public void i_click_on_login_button() {
	    loginPage.clickLogin();
	}
	    
	@Then("I should see the dashboard")
	public void i_should_see_the_dashboard() {
        loginPage.verifyDashboard();
        closeBrowser();
	}
}
