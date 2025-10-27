package com.example.demo4.controller;

import com.example.demo4.entity.Article;
import com.example.demo4.entity.Users;
import com.example.demo4.service.ArticleService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "https://hggfs7-4200.csb.app")
public class ArticleController {

    private final ArticleService articleService;

    public ArticleController(ArticleService articleService) {
        this.articleService = articleService;
    }

    @GetMapping("/api/articles/{id}")
    public Article getArticle(@PathVariable Long id) {
        return articleService.getArticle(id);
    }

    @GetMapping
    public List<Article> getAllArticles() {
        return articleService.getAllArticles();
    }

    @PostMapping
    public String createArticle(@RequestBody Article article) {
        articleService.createArticle(article);
        return "Article created";
    }

    @PostMapping("/api/articles/{articleId}/view")
    public String recordView(@PathVariable Long articleId,
                             @RequestParam("userId") String userId,
                             @RequestParam("views") int views) {
        articleService.recordView(articleId, userId, views, articleId);
        return "View recorded";
    }

    @PostMapping("/api/articles/user")
    public String createUser(@RequestParam String userId) {
        Users user = new Users();
        user.setUserId(userId);
        articleService.createUser(user);
        return "User created";
    }

    @GetMapping("/api/articles/user/{userId}")
    public Users getUser(@PathVariable String userId) {
        return articleService.getUser(userId);
    }
}



