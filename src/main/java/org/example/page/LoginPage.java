package org.example.page;

import org.example.model.UserCredentials;
import org.openqa.selenium.By;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class LoginPage extends Page {
    private static final String URL = "https://ok.ru/";
    private final SelenideElement emailOrPhoneNumberInput = $(By.id("field_email"));
    private final SelenideElement passwordInput = $(By.id("field_password"));
    private final SelenideElement loginButton = $(By.cssSelector(".login-form-actions input[type='submit']"));

    public LoginPage() {
        super(URL);
    }

    public void login(UserCredentials userCredentials) {
        emailOrPhoneNumberInput.setValue(userCredentials.emailOrPhoneNumber());
        passwordInput.setValue(userCredentials.password());
        loginButton.click();
    }
}
