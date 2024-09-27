package com.automation.pages;

import com.automation.utils.ConfigReader;
import com.microsoft.playwright.APIResponse;
import com.microsoft.playwright.Locator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class HotelPage extends BasePage {

    Locator popUp1;
    Locator popUp2;
    Locator popUp3;

    Locator hotelIcon;
    Locator searchFlight;
    Locator location;
    Locator search;
    Locator updateSearch;
    Locator priceLowToHigh;
    Locator priceHighToLow;
    Locator priceList;


    public HotelPage() {
        hotelIcon = page.locator("//span[normalize-space(text())='Hotels']");
        searchFlight = page.locator("//span[normalize-space(text())='SEARCH FLIGHTS']");
        location = page.getByPlaceholder("e.g. - Area, Landmark or Property Name");
        search = page.locator("//button[text()='Search']");
        updateSearch = page.locator("//button[normalize-space(text())='Update Search']");
        priceLowToHigh = page.locator("//span[text()='Price (Low to High)']");
        priceHighToLow = page.locator("//span[text()='Price (High to Low)']");

        popUp1 = page.locator("//span[@aria-hidden='true']");
        popUp2 = page.locator("//span[@class='logSprite icClose']");
        popUp3 = page.locator("//p[@class='sc-jlwm9r-1 ewETUe']");
        priceList = page.locator("//p[@itemprop='priceRange']");

    }

    public void openWebsite() {
        page.navigate(ConfigReader.getConfigValue("application.url"));
        if (popUp1.isVisible()) {
            popUp1.click();
        } else {
            popUp2.click();
        }
        if (popUp3.isVisible()) {
            popUp3.click();
        }
    }

    public Locator getHotelIcon() {
        return hotelIcon;
    }

    public Locator getFlightSearch() {
        return searchFlight;
    }

    public void selectHotel() {
        hotelIcon.click();
    }

    String clickOnFirstLoc = "(//div[@class='HomePageAutosuggeststyles__LoctionName-sc-tk3iiv-16 fTrnEo' and contains(text(),'%s')])[1]";

    public void enterLocation(String loc) {
        location.click();
        location.fill(loc);

        String loc1 = String.format(clickOnFirstLoc, loc);
        Locator firstLoc = page.locator(loc1);
        firstLoc.waitFor();
        firstLoc.click();
    }

    public void clickOnSearch() {
        search.click();
    }

    public Locator getUpdateSearch() {
        return updateSearch;
    }

    public void clickOnPriceLowToHigh() {
        priceLowToHigh.click();
    }


    public boolean priceAreInLowToHigh() {

        page.waitForTimeout(4000);
        List<Integer> li = new ArrayList<>();

        for (int i = 0; i < priceList.count() ; i++)
        {
            String text=priceList.nth(i).innerText();
            li.add(Integer.valueOf(text.trim()));

        }

        System.out.println("Original list (high to low) \n" + li);

        List<Integer> copy_li = new ArrayList<>(li);
        System.out.println("Copy of original list(high to low) \n " + copy_li);

        Collections.sort(copy_li);
        System.out.println("Sorted list (low to high) \n" + copy_li);

        return li.equals(copy_li);
    }

    public void clickOnPriceHighToLow() {
        priceHighToLow.click();
    }

    public boolean priceAreInHighToLow() {
        page.waitForTimeout(4000);
        List<Integer> li = new ArrayList<>();

        for (int i = 0; i < priceList.count() ; i++)
        {
            String text=priceList.nth(i).innerText();
            li.add(Integer.valueOf(text.trim()));

        }

        System.out.println("Original list (high to low) \n" + li);

        List<Integer> copy_li = new ArrayList<>(li);
        System.out.println("Copy of original list(high to low) \n " + copy_li);

        Collections.sort(copy_li);
        System.out.println("Sorted list (low to high) \n" + copy_li);

        Collections.reverse(copy_li);
        System.out.println("reverse sorter list (high to low)\n" + copy_li);

        return li.equals(copy_li);
    }

}