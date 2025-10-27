package com.example.demo4.mapper;

import com.example.demo4.entity.ArticleViewDTO;
import com.example.demo4.entity.Users;
import org.apache.ibatis.annotations.Mapper;
import com.example.demo4.entity.Article;

import java.util.List;

@Mapper
public interface ArticleMapper {

    void insertArticle(Article article);

    void updateArticle(Article article);

    Article getArticleById(Long id);

    List<Article> getAllArticles();

    void incrementArticleViews(ArticleViewDTO dto);

    void insertArticleView(ArticleViewDTO dto);

    int countArticleViews(ArticleViewDTO dto);

    int getViewsByArticleAndUser(ArticleViewDTO dto);

    void insertUser(Users user);

    Users getUserById(Long id);

    Users getUserByUserId(String userId);
}
