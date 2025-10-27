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

    @PostMapping
    public String createArticle(@RequestBody Article article) {
        articleService.createArticle(article);
        return "Article created";
    }

    @PostMapping("/{articleId}/view")
    public String recordView(@PathVariable Long articleId,
                             @RequestParam("userId") String userId,
                             @RequestParam("views") int views) {
        articleService.recordView(articleId, userId, views, articleId);
        return "View recorded";
    }

    // ✅ Create user with clear endpoint
    @PostMapping("/user")
    public String createUser(@RequestParam String userId) {
        Users user = new Users();
        user.setUserId(userId);
        articleService.createUser(user);
        return "User created";
    }

    // ✅ Get user with clear endpoint
    @GetMapping("/user/{userId}")
    public Users getUser(@PathVariable String userId) {
        return articleService.getUser(userId);
    }
}
