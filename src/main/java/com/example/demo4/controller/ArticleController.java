package com.example.demo4.controller;

import com.example.demo4.entity.Article;
import com.example.demo4.entity.Users;
import com.example.demo4.service.ArticleService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/articles")
public class ArticleController {

    private final ArticleService articleService;

    public ArticleController(ArticleService articleService) {
        this.articleService = articleService;
    }

    @GetMapping("/{id}")
    public Article getArticle(@PathVariable Long id) {
        return articleService.getArticle(id);
    }

    @GetMapping
    public List<Article> getAllArticles() {
        return articleService.getAllArticles();
    }

    @PostMapping("/{article_id}")
    public String createArticle(@RequestBody Article article,@PathVariable Long article_id) {
        articleService.createArticle(article);
        return "Article created";
    }

    @PostMapping("/{id}/{articleId}/view")
    public String recordView(@PathVariable("id") Long id,@PathVariable("id") Long articleId,int views,
                             @RequestParam("userId") String userId) {
        articleService.recordView(id,userId,views,articleId);
        return "View recorded";
    }

    @GetMapping("/{userId}")
    public Users getUser(@PathVariable String userId) {
        return articleService.getUser(userId);
    }

    // Create a new user
    @PostMapping("/{userId}")
    public String User(@RequestParam String userId) {
        Users user = new Users();
        user.setUserId(userId);
        articleService.createUser(user);
        return "User created";
    }
}


