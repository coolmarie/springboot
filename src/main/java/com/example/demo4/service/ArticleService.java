package com.example.demo4.service;

import com.example.demo4.entity.Article;
import com.example.demo4.entity.ArticleViewDTO;
import com.example.demo4.entity.Users;
import com.example.demo4.mapper.ArticleMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ArticleService {

    private final ArticleMapper articleMapper;

    public ArticleService(ArticleMapper articleMapper) {
        this.articleMapper = articleMapper;
    }

    public Article getArticle(Long id) {
        return articleMapper.getArticleById(id);
    }

    public List<Article> getAllArticles() {
        return articleMapper.getAllArticles();
    }

    public void createArticle(Article article) {
        articleMapper.insertArticle(article);
    }

    public void updateArticle(Article article) {
        articleMapper.updateArticle(article);
    }

    @Transactional
    public int recordView(Long articleId, String userId) {
        ArticleViewDTO dto = new ArticleViewDTO();
        dto.setArticleId(articleId);
        dto.setUserId(userId);

        // Check if view exists
        int count = articleMapper.countArticleViews(dto);

        if (count == 0) {
            // Insert new view record
            dto.setviews(1);
            articleMapper.insertArticleView(dto);
        } else {
            // Increment views
            articleMapper.incrementArticleViews(dto);
        }

        // Return current views for this user & article
        return articleMapper.getViewsByArticleAndUser(dto);
    }

    public Users getUser(String userId) {
        return articleMapper.getUserByUserId(userId);
    }

    public void createUser(Users user) {
        articleMapper.insertUser(user);
    }
}
