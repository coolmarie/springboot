CREATE TABLE "account" (
                           id BIGINT PRIMARY KEY AUTO_INCREMENT,
                           owner VARCHAR(255) NOT NULL,
                           balance DECIMAL(15,2) NOT NULL DEFAULT 0
);
CREATE TABLE "transaction" (
                               id BIGINT PRIMARY KEY AUTO_INCREMENT,
                               account_id BIGINT NOT NULL,
                               amount DECIMAL(15,2) NOT NULL,
                               type VARCHAR(20) NOT NULL, -- 'deposit' or 'withdrawal'
                               description VARCHAR(255),
                               date TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
                               FOREIGN KEY (account_id) REFERENCES "account"(id)
);


select * FROM "transaction";
