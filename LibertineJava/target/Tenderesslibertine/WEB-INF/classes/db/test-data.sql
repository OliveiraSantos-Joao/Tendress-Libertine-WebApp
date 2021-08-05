DELETE
FROM customers;
INSERT INTO customers(id, nickname, password, email)
VALUES (1, 'Rui', 11111, 'mail@gmail.com'),
       (2, 'Sergio', 11111, 'mail@gmail.com'),
       (3, 'Bruno', 11111, 'mail@gmail.com');

/*
CREATE TABLE customers
(
    id       INTEGER AUTO_INCREMENT NOT NULL,
    nickname VARCHAR(30) NOT NULL,
    password INTEGER NOT NULL,
    email VARCHAR(80) UNIQUE NOT NULL,
    PRIMARY KEY (id)
);*/
)