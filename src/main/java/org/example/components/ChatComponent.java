package org.example.components;

import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class ChatComponent {
    private static final By CHAT_CLOSE_BUTTON_PATH = By.cssSelector("[data-l='t,closeLayer']");

    public void closeChat() {
        $(CHAT_CLOSE_BUTTON_PATH).shouldBe(visible.because("Кнопка закрытия чата не отображается!")).click();
    }

    public void checkForChatBeingVisible() {
        $(CHAT_CLOSE_BUTTON_PATH).shouldBe(visible.because("Кнопка закрытия чата не отображается!"));
    }
}
