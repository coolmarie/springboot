package com.example.demo4.entity;

public class Article {

    private Long id;           // primary key
    private String article_id;       // author/owner
    private String description;
    public Article() {}

    public Article(Long id, String article_id, String description) {
        this.id = id;
        this.article_id= article_id;
        this.description = description;

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public String getarticleId() {
        return article_id;
    }

    public void setarticleId(String article_id) {
        this.article_id = article_id;
    }


    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}
