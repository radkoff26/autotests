package org.example.page;

import org.openqa.selenium.By;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class MainPage extends Page {
    private static final String URL = "https://ok.ru/feed";
    private final SelenideElement profileName = $(By.className("toolbar_accounts-user_name"));
    private final SelenideElement tools = $(By.className("js-toolbar-menu"));
    private final SelenideElement language = $(By.xpath("//div[@class='toolbar_accounts-menu']/ul/li[position() = 2]/a"));
    private final SelenideElement chat = $(By.cssSelector("li[data-l='t,messages']"));
    private final SelenideElement servicesDropdownToggle = $(By.cssSelector(".vk_ecosystem_toolbar"));
    private final SelenideElement servicesDropdown = $(By.cssSelector(".vk_ecosystem_toolbar .toolbar_dropdown"));
    private final SelenideElement searchInput = $(By.cssSelector("form[role='search'] label input"));

    public MainPage() {
        super(URL);
    }

    public String getProfileName() {
        return profileName.getOwnText();
    }

    public MainPage changeLanguage() {
        tools.click();
        String current = getLanguage();
        language.click();
        final SelenideElement languageNow;
        if (current.equals("English")) {
            languageNow = $(By.xpath("//a[text() = 'Русский']"));
        } else {
            languageNow = $(By.xpath("//a[text() = 'English']"));
        }
        languageNow.click();
        return this;
    }

    public String getLanguage() {
        return language.$(By.xpath(".//div/span")).getOwnText();
    }

    public MainPage openChat() {
        chat.click();
        return this;
    }

    public MainPage closeChat() {
        $(By.cssSelector("[data-l='t,closeLayer']")).click();
        return this;
    }

    public boolean checkForChatBeingVisible() {
        final SelenideElement closeBtn = $(By.cssSelector("[data-l='t,closeLayer']"));
        if (!closeBtn.exists()) {
            return false;
        }
        return closeBtn.is(Condition.visible);
    }

    public MainPage openServices() {
        servicesDropdownToggle.click();
        return this;
    }

    public boolean isDropdownVisible() {
        return servicesDropdown.is(Condition.visible);
    }

    public MainPage openSearchInput() {
        searchInput.click();
        return this;
    }

    public MainPage inputSearchText(String text) {
        searchInput.setValue(text);
        return this;
    }

    public String getSearchInputText() {
        return searchInput.getValue();
    }

    public MainPage collapseSearchInput() {
        $(By.xpath("//div[@id='toolbar_search']/div")).click();
        return this;
    }

    public boolean isSearchInputCollapsed() {
        return servicesDropdownToggle.is(Condition.visible);
    }
}
