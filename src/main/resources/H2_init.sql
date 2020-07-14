CREATE TABLE advertisement (
    id INT PRIMARY KEY AUTO_INCREMENT,
    title VARCHAR(60) NOT NULL,
    description VARCHAR(400),
    add_date DATETIME NOT NULL
);


INSERT INTO advertisement VALUES (DEFAULT, 'Заголовок объявления №1', 'Описание объявления №1', '2020-06-23 14:09:13');
INSERT INTO advertisement VALUES (DEFAULT, 'Заголовок объявления №2', 'Описание объявления №2', '2020-07-10 08:56:01');
INSERT INTO advertisement VALUES (DEFAULT, 'Заголовок объявления №3', 'Описание объявления №3', '2020-07-13 22:37:44');
