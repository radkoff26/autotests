package org.example.page;

import org.openqa.selenium.By;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class MainPage extends Page {
    private static final String URL = "https://ok.ru/feed";
    private final SelenideElement profileName = $(By.className("toolbar_accounts-user_name"));
    private final SelenideElement tools = $(By.className("js-toolbar-menu"));
    private final SelenideElement language = $(By.xpath("//div[@class='toolbar_accounts-menu']/ul/li[position() = 2]/a"));

    public MainPage() {
        super(URL);
    }

    public String getProfileName() {
        return profileName.getOwnText();
    }

    public void changeLanguageToEnglish() {
        tools.click();
        language.click();
        final SelenideElement english = $(By.xpath("//a[text()='English']"));
        english.click();
    }

    public String getLanguage() {
        final SelenideElement lang = $(By.xpath("//div[@class='toolbar_accounts-menu']/ul/li[position() = 2]/a/div/span"));
        return lang.getOwnText();
    }
}
