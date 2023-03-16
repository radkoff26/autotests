package org.example;

import org.example.model.UserCredentials;
import org.example.page.LoginPage;
import org.example.page.MainPage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class MainTest {

    @Test
    void test() {
        LoginPage loginPage = new LoginPage();
        loginPage.openPage();
        loginPage.login(new UserCredentials("YOUR_PHONE_NUMBER_OR_EMAIL", "YOUR_PASSWORD"));

        MainPage mainPage = new MainPage();
        Assertions.assertEquals("Вячеслав Радько", mainPage.getProfileName());
    }
}
