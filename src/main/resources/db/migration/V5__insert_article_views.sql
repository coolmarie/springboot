CREATE TABLE users (
                      id BIGINT PRIMARY KEY AUTO_INCREMENT,
                      user_id VARCHAR(255) NOT NULL
);

CREATE TABLE article (
                         id BIGINT PRIMARY KEY AUTO_INCREMENT,
                         article_id VARCHAR(255) NOT NULL,
                         description VARCHAR(255)
);
CREATE TABLE article_view (
                              id BIGINT PRIMARY KEY AUTO_INCREMENT,
                              user_id VARCHAR(255) NOT NULL,
                              article_id BIGINT NOT NULL,
                              views INT DEFAULT 0,
                              CONSTRAINT unique_user_article UNIQUE (user_id, article_id),
                              FOREIGN KEY (article_id) REFERENCES article(id) ON DELETE CASCADE
);
