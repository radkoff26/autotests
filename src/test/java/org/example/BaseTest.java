package org.example;

import org.example.page.LoginPage;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

import static com.codeborne.selenide.Selenide.closeWebDriver;
import static com.codeborne.selenide.Selenide.closeWindow;

public class BaseTest {
    protected LoginPage loginPage;

    @BeforeEach
    void init() {
        loginPage = new LoginPage();
    }

    @AfterEach
    void close() {
        closeWindow();
    }

    @AfterAll
    static void tearDown() {
        closeWebDriver();
    }
}
