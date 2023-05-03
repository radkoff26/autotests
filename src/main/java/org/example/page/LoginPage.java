package org.example.page;

import org.example.Data;
import org.example.model.UserCredentials;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.open;

public class LoginPage extends Page<LoginPage> {
    private static final By LOGIN_BUTTON_PATH = By.cssSelector("[data-l='t,sign_in']");
    private static final By EMAIL_OR_PHONE_NUMBER_INPUT = By.id("field_email");
    private static final By PASSWORD_INPUT = By.id("field_password");

    @Override
    protected void load() {
        open(Data.OK.getUrl());
    }

    @Override
    protected void isLoaded() throws Error {
        load();
        waitTillElementIsLoaded(LOGIN_BUTTON_PATH, "Страница не загружена!");
    }

    public MainPage login(UserCredentials userCredentials) {
        waitTillElementIsLoaded(EMAIL_OR_PHONE_NUMBER_INPUT, "Поле логина не отображается!").setValue(userCredentials.emailOrPhoneNumber());
        waitTillElementIsLoaded(PASSWORD_INPUT,"Поле для пароля не отображается!").setValue(userCredentials.password());
        waitTillElementIsLoaded(LOGIN_BUTTON_PATH, "Кнопка для логина не отображается!").click();
        return new MainPage();
    }
}
