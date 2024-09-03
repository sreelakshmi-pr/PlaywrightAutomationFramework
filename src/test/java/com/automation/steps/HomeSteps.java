package com.automation.steps;

import com.automation.pages.HomePage;
import io.cucumber.java.en.Then;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class HomeSteps {

    HomePage homePage = new HomePage();

    @Then("verify user is on home page")
    public void verify_user_is_on_home_page() {
        assertThat(homePage.getBurgerMenu()).isVisible();
        assertThat(homePage.getShoppingCartIcon()).isVisible();
    }

}
