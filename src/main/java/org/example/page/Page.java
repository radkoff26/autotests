package org.example.page;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.LoadableComponent;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public abstract class Page<T extends LoadableComponent<T>> extends LoadableComponent<T> {
    protected Page() {
        isLoaded();
    }

    @Override
    protected void load() {
        // Unnecessary to override
    }

    protected SelenideElement waitTillElementIsLoaded(By by, String message) {
        return $(by).shouldBe(Condition.visible.because(message), Duration.ofSeconds(10));
    }
}
