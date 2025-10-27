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
    public void recordView(Long id,String userId, int views,Long articleId) {
        // Insert a new view (will ignore if already exists due to ON DUPLICATE KEY)
        ArticleViewDTO dto = new ArticleViewDTO();
        dto.setUserId(userId);
        dto.setArticleId(articleId);
        dto.setId(id);
        dto.setviews(views);
        articleMapper.insertArticleView(dto);

        int count = articleMapper.countArticleViews(articleId);
        if (count == 1) {
            articleMapper.incrementArticleViews(articleId);
        }
    }

    public Users getUser(String userId) {
        return articleMapper.getUserByUserId(userId);
    }

    public void createUser(Users user) {
        articleMapper.insertUser(user);
    }
}
