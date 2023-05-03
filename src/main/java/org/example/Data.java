package org.example;

public enum Data {
    OK("https://ok.ru");

    private final String url;

    Data(String url) {
        this.url = url;
    }

    public String getUrl() {
        return url;
    }
}
