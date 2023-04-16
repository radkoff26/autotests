package org.example.model;

public enum Language {
    ENGLISH("English"),
    RUSSIAN("Russian");

    private final String languageText;

    Language(String languageText) {
        this.languageText = languageText;
    }

    public String getLanguageText() {
        return languageText;
    }
}
