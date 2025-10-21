CREATE TABLE "user" (
                        id INT PRIMARY KEY AUTO_INCREMENT,
                        name VARCHAR(50),
                        email VARCHAR(50)
);
INSERT INTO "user" (name, email) VALUES ('Alice', 'alice@example.com');
INSERT INTO "user" (name, email) VALUES ('Bob', 'bob@example.com');


CREATE TABLE "car" (
                       id INT PRIMARY KEY AUTO_INCREMENT,
                       name VARCHAR(50),
                       fuel VARCHAR(50)
);

INSERT INTO "car" (id, name, fuel) VALUES (1, 'Toyota Camry', 'Petrol');
INSERT INTO "car" (id, name, fuel) VALUES (2, 'Tesla Model 3', 'Electric');
INSERT INTO "car" (id, name, fuel) VALUES (4, 'Hyundai Ioniqsss', 'Hybridss');

SELECT * FROM "car";

