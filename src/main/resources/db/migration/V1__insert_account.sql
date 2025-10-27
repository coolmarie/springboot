CREATE TABLE account (
                           id BIGINT PRIMARY KEY AUTO_INCREMENT,
                           owner VARCHAR(255) NOT NULL,
                           balance DECIMAL(15,2) NOT NULL DEFAULT 0
);


INSERT INTO account (owner, balance) VALUES ('Alice', 1000.00);
INSERT INTO account (owner, balance) VALUES ('Bob', 500.00);
select * FROM account;

CREATE TABLE "maintenance_schedule"
( id BIGINT PRIMARY KEY AUTO_INCREMENT,
  car_id BIGINT NOT NULL,
  description VARCHAR(255),
  scheduled_date DATE );
