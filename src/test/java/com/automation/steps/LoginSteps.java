package com.automation.steps;

import com.automation.pages.LoginPage;
import com.automation.utils.ConfigReader;
import com.microsoft.playwright.assertions.PlaywrightAssertions;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class LoginSteps {

    LoginPage loginPage = new LoginPage();

    @Given("user opens the website")
    public void user_opens_the_website() {
        loginPage.openWebsite();
    }

    @Then("verify user is on login page")
    public void verify_user_is_on_login_page() {
        assertThat(loginPage.getUsernameInput()).isVisible();
        assertThat(loginPage.getPasswordInput()).isVisible();
    }

    @When("user enters username {string} and password {string}")
    public void user_enters_username_and_password(String usernameKey, String passwordKey) {
        loginPage.doLogin(ConfigReader.getConfigValue(usernameKey), ConfigReader.getConfigValue(passwordKey));
    }

}
