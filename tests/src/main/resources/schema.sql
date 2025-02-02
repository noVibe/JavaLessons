CREATE TABLE IF NOT EXISTS employee
(
    id         SERIAL PRIMARY KEY,
    age        INT,
    first_name VARCHAR(255),
    last_name  VARCHAR(255)
);