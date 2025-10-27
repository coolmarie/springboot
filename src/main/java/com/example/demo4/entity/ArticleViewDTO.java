package com.example.demo4.entity;


public class ArticleViewDTO {
    private Long id;
    private String userId;
    private int views;
    private Long articleId;

    public ArticleViewDTO(){

    }

    public ArticleViewDTO(Long id, String userId, int views, Long articleId) {
        this.id = id;
        this.userId = userId;
        this.views= views;
        this.articleId= articleId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserId() {
        return userId;
    }


    public void setviews(int views) {
        this.views = views;
    }

    public int getviews(){
        return views;
    }

    public Long getArticleId() {
        return articleId;
    }

    public void setArticleId(Long articleId) {
        this.articleId = articleId;
    }

}
