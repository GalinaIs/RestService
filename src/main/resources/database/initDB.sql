DROP TABLE IF EXISTS client;
DROP TABLE IF EXISTS manager;

CREATE TABLE IF NOT EXISTS manager
(
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    surname VARCHAR(255) NOT NULL,
    name VARCHAR(255) NOT NULL,
    patronymic VARCHAR(255) NOT NULL,
    phone_number VARCHAR(255) NOT NULL,
    deputy_id BIGINT
);

CREATE TABLE IF NOT EXISTS client
(
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    address VARCHAR(255) NOT NULL,
    manager_id BIGINT,
    FOREIGN KEY (manager_id) REFERENCES manager (Id) ON UPDATE CASCADE ON DELETE SET NULL
);

