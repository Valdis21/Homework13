package org.skypro.skyshop.article;

import org.skypro.skyshop.search.Searchable;

public final class Article implements Searchable {
    private final String title;
    private final String content;

    public Article(String title, String content) {
        this.title = title;
        this.content = content;
    }

    @Override
    public String getSearchTerm() {
        return title + " " + content;
    }

    @Override
    public String getType() {
        return "ARTICLE";
    }

    public String getName() {
        return title;
    }

}
