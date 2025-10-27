package com.example.demo4.controller;

import com.example.demo4.entity.Article;
import com.example.demo4.entity.Users;
import com.example.demo4.service.ArticleService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/articles")
@CrossOrigin(origins = "https://hggfs7-4200.csb.app")
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

    @PostMapping
    public Article createArticle(@RequestBody Article article) {
        articleService.createArticle(article);
        return article;

    }

    @PostMapping("/{articleId}/view")
    public Map<String, Integer> recordView(@PathVariable Long articleId,
                                           @RequestParam("userId") String userId) {
        Integer counts= articleService.recordView(articleId, userId);
        return Map.of("views", counts); // clearer message
    }


    @PostMapping("/user")
    public Map<String, String> createUser(@RequestParam String userId) {
        Users user = new Users();
        user.setUserId(userId);
        articleService.createUser(user);
        return Map.of("message", "User created");
    }

    @GetMapping("/user/{userId}")
    public Users getUser(@PathVariable String userId) {
        return articleService.getUser(userId);
    }
}



