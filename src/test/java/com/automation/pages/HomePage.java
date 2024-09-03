package com.automation.pages;

import com.microsoft.playwright.Locator;

public class HomePage extends BasePage {

    Locator burgerMenu;
    Locator shoppingCartIcon;

    public HomePage() {
        burgerMenu = page.getByText("Open Menu");
        shoppingCartIcon = page.locator("a.shopping_cart_link");
    }

    public Locator getBurgerMenu(){
        return burgerMenu;
    }

    public Locator getShoppingCartIcon(){
        return shoppingCartIcon;
    }


}
