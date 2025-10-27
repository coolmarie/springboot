package com.example.demo4.mapper;


import com.example.demo4.entity.ArticleViewDTO;
import com.example.demo4.entity.Users;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import com.example.demo4.entity.Article;

import java.util.List;

@Mapper
public interface ArticleMapper {

    void insertArticle(Article article);

    void updateArticle(Article article);

    Article getArticleById(@Param("id") Long id);

    List<Article> getAllArticles();

    void incrementArticleViews(@Param("articleId") Long articleId,@Param("userId") String userId);

    void insertArticleView(ArticleViewDTO dto);

    int countArticleViews(@Param("articleId") Long articleId,@Param("userId") String userId);

    void insertUser(Users user);

    Users getUserById(@Param("id") Long id);

    Users getUserByUserId(@Param("userId") String userId);

}

