USE libertine;

Drop table customers;

CREATE TABLE customers
(
    id       INTEGER AUTO_INCREMENT NOT NULL,
    nickname VARCHAR(30) NOT NULL,
    password INTEGER NOT NULL,
    email VARCHAR(80) UNIQUE NOT NULL,
    PRIMARY KEY (id)
);

INSERT INTO customers(id, nickname, password, email)
VALUES (1, 'Rui', 11111, 'mail1@gmail.com'),
       (2, 'Sergio', 11111, 'mai2l@gmail.com'),
       (3, 'Bruno', 11111, 'mai4l@gmail.com');



