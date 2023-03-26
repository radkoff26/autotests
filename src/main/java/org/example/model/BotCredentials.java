package org.example.model;

public class BotCredentials {
    private BotCredentials() {
    }

    public static UserCredentials getBotCredentials() {
        return new UserCredentials("botS23AT20", "autotests2023");
    }
}
