package com.automation.pages;

import com.automation.utils.ConfigReader;
import com.microsoft.playwright.Locator;

public class LoginPage extends BasePage {

    Locator usernameInput;
    Locator passwordInput;
    Locator loginBtn;

    public LoginPage() {
        usernameInput = page.getByPlaceholder("Username");
        passwordInput = page.getByPlaceholder("Password");
        loginBtn = page.locator("#login-button");
    }

    public void openWebsite() {
        page.navigate(ConfigReader.getConfigValue("application.url"));
    }

    public void doLogin(String username, String password) {
        usernameInput.fill(username);
        passwordInput.fill(password);
        loginBtn.click();
    }

    public Locator getUsernameInput(){
        return usernameInput;
    }

    public Locator getPasswordInput(){
        return passwordInput;
    }
}
