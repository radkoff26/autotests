package org.example;

import org.example.model.UserCredentials;
import org.example.page.LoginPage;
import org.example.page.MainPage;
import org.hamcrest.BaseMatcher;
import org.hamcrest.Description;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;

class MainTest {

    @Test
    void test() {
        LoginPage loginPage = new LoginPage();
        loginPage.openPage();
        loginPage.login(new UserCredentials("botS23AT20", "autotests2023"));

        MainPage mainPage = new MainPage();

        assertThat(mainPage.getProfileName(), new BaseMatcher<>() {
            @Override
            public boolean matches(Object o) {
                return o.equals("botS23AT20 botS23AT20");
            }

            @Override
            public void describeTo(Description description) {
                description.appendText("botS23AT20 botS23AT20");
            }
        });
    }

    @Test
    void languageChangeTest() {
        LoginPage loginPage = new LoginPage();
        loginPage.openPage();
        loginPage.login(new UserCredentials("botS23AT20", "autotests2023"));

        MainPage mainPage = new MainPage();

        mainPage.openPage();

        mainPage.changeLanguageToEnglish();

        assertThat(mainPage.getLanguage(), new BaseMatcher<>() {
            @Override
            public boolean matches(Object o) {
                return o.equals("English");
            }

            @Override
            public void describeTo(Description description) {
                description.appendText("English");
            }
        });
    }
}
