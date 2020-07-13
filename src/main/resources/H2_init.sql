CREATE TABLE advertisement (
    id INT PRIMARY KEY AUTO_INCREMENT,
    title VARCHAR(60) NOT NULL,
    description VARCHAR(400),
    add_date DATETIME NOT NULL
);


INSERT INTO advertisement VALUES (DEFAULT, 'Заголовок объявления №1', 'Описание объявления №1', '2020-07-10 14:09:13');