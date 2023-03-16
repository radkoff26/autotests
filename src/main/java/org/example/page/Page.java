package org.example.page;

import static com.codeborne.selenide.Selenide.closeWindow;
import static com.codeborne.selenide.Selenide.open;

public class Page {
    private final String url;

    public Page(String url) {
        this.url = url;
    }

    public void openPage() {
        open(url);
    }

    public void closePage() {
        closeWindow();
    }
}
