package org.example;

import org.example.model.BotCredentials;
import org.example.page.LoginPage;
import org.example.page.MainPage;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.closeWindow;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class MainTest {

    @BeforeAll
    static void adjust() {
        final LoginPage loginPage = new LoginPage();
        loginPage.openPage();
        loginPage.login(BotCredentials.getBotCredentials());
    }

    @Test
    void loginTest() {
        final MainPage mainPage = new MainPage();

        assertThat(mainPage.getProfileName(), containsString("botS23AT20"));
    }

    @Test
    void languageChangeTest() {
        final MainPage mainPage = new MainPage();

        mainPage.openPage();

        final String prevLanguage = mainPage.getLanguage();

        final String actualLanguage = mainPage
                .changeLanguage()
                .getLanguage();

        assertThat(actualLanguage, equalTo(prevLanguage.equals("English") ? "Русский" : "English"));
    }

    @Test
    void chatWorkingTest() {
        final MainPage mainPage = new MainPage();

        boolean isOpen = mainPage.checkForChatBeingVisible();

        assertFalse(isOpen);

        isOpen = mainPage
                .openChat()
                .checkForChatBeingVisible();

        assertTrue(isOpen);

        isOpen = mainPage
                .closeChat()
                .checkForChatBeingVisible();

        assertFalse(isOpen);
    }

    @Test
    void servicesDropdownTest() {
        final MainPage mainPage = new MainPage();

        boolean isDropdownVisible = mainPage.isDropdownVisible();

        assertFalse(isDropdownVisible);

        isDropdownVisible = mainPage
                .openServices()
                .isDropdownVisible();

        assertTrue(isDropdownVisible);
    }

    @Test
    void searchInputTest() {
        final MainPage mainPage = new MainPage();

        String inputValue = mainPage.getSearchInputText();

        assertEquals("", inputValue);

        inputValue = mainPage
                .openSearchInput()
                .inputSearchText("Text")
                .getSearchInputText();

        assertEquals("Text", inputValue);
    }

    @Test
    void searchInputCollapsingTest() {
        MainPage mainPage = new MainPage();

        boolean isCollapsed = mainPage
                .openSearchInput()
                .inputSearchText("Text")
                .collapseSearchInput()
                .isSearchInputCollapsed();

        assertTrue(isCollapsed);
    }

    @AfterAll
    static void tearDown() {
        closeWindow();
    }
}
