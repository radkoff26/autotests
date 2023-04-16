package org.example;

import org.example.components.ChatComponent;
import org.example.model.BotCredentials;
import org.example.model.Language;
import org.example.page.MainPage;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.not;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

class MainTest extends BaseTest {

    @Test
    void loginTest() {
        final MainPage mainPage = loginPage.login(BotCredentials.getBotCredentials());
        assertThat(mainPage.getProfileName(), containsString(BotCredentials.getBotCredentials().emailOrPhoneNumber()));
    }

    @Test
    void languageChangeTest() {
        final MainPage mainPage = loginPage.login(BotCredentials.getBotCredentials());
        final Language prevLanguage = mainPage.getLanguage();

        final Language actualLanguage = mainPage
                .openTools()
                .changeLanguage()
                .getLanguage();

        assertThat(actualLanguage, not(equalTo(prevLanguage)));
    }

    @Test
    void chatWorkingTest() {
        final MainPage mainPage = loginPage.login(BotCredentials.getBotCredentials());
        ChatComponent chatComponent = new ChatComponent();

        assertThrows(Throwable.class, chatComponent::checkForChatBeingVisible, "Чат не должен быть виден!");

        mainPage.openChat();

        assertDoesNotThrow(chatComponent::checkForChatBeingVisible, "Чат должен быть виден!");

        chatComponent.closeChat();

        assertThrows(Throwable.class, chatComponent::checkForChatBeingVisible, "Чат не должен быть виден!");
    }

    @Test
    void servicesDropdownTest() {
        final MainPage mainPage = loginPage.login(BotCredentials.getBotCredentials());
        boolean isDropdownVisible = mainPage.isDropdownVisible();

        assertFalse(isDropdownVisible);

        isDropdownVisible = mainPage
                .openServices()
                .isDropdownVisible();

        assertTrue(isDropdownVisible);
    }

    @Test
    void searchInputTest() {
        final MainPage mainPage = loginPage.login(BotCredentials.getBotCredentials());
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
        final MainPage mainPage = loginPage.login(BotCredentials.getBotCredentials());
        boolean isCollapsed = mainPage
                .openSearchInput()
                .inputSearchText("Text")
                .collapseSearchInput()
                .isSearchInputCollapsed();

        assertTrue(isCollapsed);
    }
}
