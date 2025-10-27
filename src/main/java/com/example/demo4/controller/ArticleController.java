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
    public String createArticle(@RequestBody Article article) {
        articleService.createArticle(article);
        return "Article created";
    }

    @PostMapping("/{articleId}/view")
    public Map<String, String> recordView(@PathVariable Long articleId,
                             @RequestParam("userId") String userId,
                             @RequestParam("views") int views) {
        articleService.recordView(articleId, userId, views, articleId);
        return Map.of("message", "User created");

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
