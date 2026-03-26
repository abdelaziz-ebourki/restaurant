DROP TABLE IF EXISTS plat;

CREATE TABLE plat (
                      id BIGINT AUTO_INCREMENT PRIMARY KEY,
                      nom VARCHAR(100) NOT NULL,
                      calories INT NOT NULL,
                      prix DOUBLE NOT NULL,
                      cout_ingredients DOUBLE NOT NULL
);