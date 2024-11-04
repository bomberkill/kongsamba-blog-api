package com.example.kongsambablogapi.models.articles;

public enum ArticleType {
    ARTICLE("article"),
    BREVE("breve"),
    NEWS("news"),
    COVER("cover"),
    SPORTS("sports");

    private final String value;

    ArticleType(String value) {
        this.value = value;
    }
    public String getValue () {
        return value;
    }
}