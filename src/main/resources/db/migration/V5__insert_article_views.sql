-- Users table
CREATE TABLE users (
                      id BIGINT PRIMARY KEY AUTO_INCREMENT,
                      user_id VARCHAR(255) NOT NULL
);

-- Articles table
CREATE TABLE article (
                         id BIGINT PRIMARY KEY AUTO_INCREMENT,
                         article_id VARCHAR(255) NOT NULL,
                         description VARCHAR(255)
);

-- Article views table\
CREATE TABLE article_view (
                              id BIGINT PRIMARY KEY AUTO_INCREMENT,
                              article_id BIGINT NOT NULL,
                              user_id BIGINT NOT NULL,
                              viewed_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                              CONSTRAINT uq_user_article UNIQUE (article_id, user_id),
                              CONSTRAINT fk_article FOREIGN KEY (article_id) REFERENCES article(id) ON DELETE CASCADE,
                              CONSTRAINT fk_user FOREIGN KEY (user_id) REFERENCES users(id) ON DELETE CASCADE
);


