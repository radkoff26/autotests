package org.example.page;

import org.example.model.Language;
import org.openqa.selenium.By;

import com.codeborne.selenide.Condition;

import static com.codeborne.selenide.Selenide.$;

public class MainPage extends Page<MainPage> {
    // Locators
    private static final By RUSSIAN_LANGUAGE = By.xpath("//a[text() = 'Русский']");
    private static final By ENGLISH_LANGUAGE = By.xpath("//a[text() = 'English']");
    private static final By COLLAPSE = By.xpath("//div[@id='toolbar_search']/div");
    private static final By MAIN_PAGE_FEEDS_WRAPPER = By.cssSelector("#hook_Block_MainFeedsWrapper");
    private static final By PROFILE_NAME = By.cssSelector(".toolbar_accounts-user_name");
    private static final By TOOLS = By.className("js-toolbar-menu");
    private static final By LANGUAGE = By.xpath("//li[@class='u-menu_li']/a[contains(@hrefattrs, 'PopLayerChooseNewLanguage')]");
    private static final By CHAT = By.cssSelector("li[data-l='t,messages']");
    private static final By SERVICE_DROPDOWN_TOGGLE = By.cssSelector(".vk_ecosystem_toolbar");
    private static final By SERVICE_DROPDOWN = By.cssSelector(".vk_ecosystem_toolbar .toolbar_dropdown");
    private static final By SEARCH_INPUT = By.cssSelector("form[role='search'] label input");

    @Override
    protected void isLoaded() throws Error {
        waitTillElementIsLoaded(MAIN_PAGE_FEEDS_WRAPPER, "Страница не загружена!");
    }

    // Value getters
    public String getProfileName() {
        openTools();
        return waitTillElementIsLoaded(PROFILE_NAME, "Имя профиля не отображается!").getOwnText();
    }

    public Language getLanguage() {
        openTools();
        String text = waitTillElementIsLoaded(LANGUAGE, "Элемент языка не отображается!").$(By.xpath(".//div/span")).getOwnText();
        switch (text) {
            case "Русский" -> {
                return Language.RUSSIAN;
            }
            case "English" -> {
                return Language.ENGLISH;
            }
            default -> throw new Error("Такого языка нет!");
        }
    }

    public String getSearchInputText() {
        return waitTillElementIsLoaded(SEARCH_INPUT, "Поисковая строка не отображается!").getValue();
    }

    // Actions
    public void openChat() {
        waitTillElementIsLoaded(CHAT, "Кнопка чата не отображается!").click();
    }

    public MainPage changeLanguage() {
        Language current = getLanguage();
        $(LANGUAGE).click();
        final By languageNow;
        switch (current) {
            case ENGLISH -> languageNow = RUSSIAN_LANGUAGE;
            case RUSSIAN -> languageNow = ENGLISH_LANGUAGE;
            default -> throw new Error("Такого языка нет!");
        }
        waitTillElementIsLoaded(languageNow, "Такого языка нет!").click();
        return this;
    }

    public MainPage openServices() {
        waitTillElementIsLoaded(SERVICE_DROPDOWN_TOGGLE, "Кнопка открытия сервисов не отображается!").click();
        return this;
    }

    public MainPage openSearchInput() {
        waitTillElementIsLoaded(SEARCH_INPUT, "Поисковая строка не отображается!").click();
        return this;
    }

    public MainPage collapseSearchInput() {
        waitTillElementIsLoaded(COLLAPSE, "Кнопка закрытия поисковой строки не отображается!").click();
        return this;
    }

    public MainPage inputSearchText(String text) {
        waitTillElementIsLoaded(SEARCH_INPUT, "Поисковая строка не отображается!").setValue(text);
        return this;
    }

    public MainPage openTools() {
        waitTillElementIsLoaded(TOOLS, "Кнопка открытия инструментов не отображается!").click();
        return this;
    }

    // State
    public boolean isDropdownVisible() {
        return $(SERVICE_DROPDOWN).is(Condition.visible);
    }

    public boolean isSearchInputCollapsed() {
        return $(SERVICE_DROPDOWN_TOGGLE).is(Condition.visible);
    }
}
