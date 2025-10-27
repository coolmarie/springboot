package com.example.demo4.entity;

public class Article {

    private Long id;
    private String articleId;
    private String description;

    public Article() {}

    public Article(Long id, String articleId, String description) {
        this.id = id;
        this.articleId = articleId;
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getArticleId() {
        return articleId;
    }

    public void setArticleId(String articleId) {
        this.articleId = articleId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
