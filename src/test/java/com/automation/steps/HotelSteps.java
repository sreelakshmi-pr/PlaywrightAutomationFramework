package com.automation.steps;

import com.automation.pages.HotelPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class HotelSteps {

    HotelPage hotelPage=new HotelPage();

    @Given("user open goibibo website")
    public void user_open_goibibo_website() {
        hotelPage.openWebsite();
    }

    @Then("verify home page is displayed")
    public void verifyHomePageIsDisplayed() {
          assertThat(hotelPage.getHotelIcon()).isVisible();
          assertThat(hotelPage.getFlightSearch()).isVisible();
    }

    @When("user select hotel booking")
    public void user_select_hotel_booking() {
        hotelPage.selectHotel();
    }
    @When("user enters location {string}")
    public void user_enters_location(String loc) {
        hotelPage.enterLocation(loc);
    }
    @When("user clicks on search")
    public void user_clicks_on_search() {
        hotelPage.clickOnSearch();
        
    }
    @Then("verify user is on hotel displayed page")
    public void verify_user_is_on_hotel_displayed_page() {
        assertThat(hotelPage.getUpdateSearch()).isVisible();
    }

    @And("user clicks on price low to high")
    public void userClicksOnPriceLowToHigh() {
        hotelPage.clickOnPriceLowToHigh();
    }

    @Then("verify the hotels displayed in price low to high order")
    public void verifyTheHotelsDisplayedInPriceLowToHighOrder() {
        Assert.assertTrue(hotelPage.priceAreInLowToHigh());
    }

    @And("user clicks on price low to high to low")
    public void userClicksOnPriceLowToHighToLow() {
        hotelPage.clickOnPriceHighToLow();
    }

    @Then("verify the hotels displayed in price low to high to low order")
    public void verifyTheHotelsDisplayedInPriceLowToHighToLowOrder() {
        Assert.assertTrue(hotelPage.priceAreInHighToLow());
    }
}
