package org.example.page;

import org.openqa.selenium.By;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class MainPage extends Page {
    private static final String URL = "https://ok.ru/feed";
    private final SelenideElement profileName = $(By.className("toolbar_accounts-user_name"));

    public MainPage() {
        super(URL);
    }

    public String getProfileName() {
        return profileName.getOwnText();
    }
}
