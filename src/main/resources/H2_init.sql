CREATE TABLE advertisement (
    id INT PRIMARY KEY AUTO_INCREMENT,
    category_id INT NOT NULL,
    title VARCHAR(60) NOT NULL,
    description VARCHAR(400),
    add_date DATETIME NOT NULL
);

CREATE TABLE category (
    id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(30) NOT NULL
);

CREATE TABLE user (
    id INT PRIMARY KEY AUTO_INCREMENT,
    username VARCHAR(20) UNIQUE,
    password VARCHAR(32)
);

INSERT INTO category VALUES (DEFAULT, 'Недвижимость');
INSERT INTO category VALUES (DEFAULT, 'Личный транспорт');
INSERT INTO category VALUES (DEFAULT, 'Бытовая техника');
INSERT INTO category VALUES (DEFAULT, 'Персональная электроника');
INSERT INTO category VALUES (DEFAULT, 'Одежда и обувь');
INSERT INTO category VALUES (DEFAULT, 'Спорт и отдых');
INSERT INTO category VALUES (DEFAULT, 'Прочее');

INSERT INTO advertisement VALUES (DEFAULT, 2, 'Заголовок объявления №1', 'Описание объявления №1', '2020-08-25 03:31:52');
INSERT INTO advertisement VALUES (DEFAULT, 1, 'Заголовок объявления №1', 'Описание объявления №1', '2020-10-03 18:52:06');
INSERT INTO advertisement VALUES (DEFAULT, 1, 'Заголовок объявления №1', 'Описание объявления №1', '2020-10-09 22:16:12');
INSERT INTO advertisement VALUES (DEFAULT, 1, 'Заголовок объявления №1', 'Описание объявления №1', '2020-10-22 04:05:33');
INSERT INTO advertisement VALUES (DEFAULT, 5, 'Заголовок объявления №1', 'Описание объявления №2', '2020-05-15 00:53:12');
INSERT INTO advertisement VALUES (DEFAULT, 5, 'Заголовок объявления №1', 'Описание объявления №2', '2020-11-21 12:08:21');
INSERT INTO advertisement VALUES (DEFAULT, 1, 'Заголовок объявления №1', 'Описание объявления №2', '2020-09-08 07:36:00');
INSERT INTO advertisement VALUES (DEFAULT, 1, 'Заголовок объявления №1', 'Описание объявления №2', '2020-01-11 16:15:53');
INSERT INTO advertisement VALUES (DEFAULT, 4, 'Заголовок объявления №1', 'Описание объявления №3', '2020-11-16 10:26:22');
INSERT INTO advertisement VALUES (DEFAULT, 2, 'Заголовок объявления №1', 'Описание объявления №3', '2020-11-18 05:29:05');
INSERT INTO advertisement VALUES (DEFAULT, 7, 'Заголовок объявления №1', 'Описание объявления №3', '2020-04-28 20:19:55');
INSERT INTO advertisement VALUES (DEFAULT, 2, 'Заголовок объявления №1', 'Описание объявления №3', '2020-04-23 21:32:29');
INSERT INTO advertisement VALUES (DEFAULT, 5, 'Заголовок объявления №1', 'Описание объявления №4', '2020-01-09 16:54:04');
INSERT INTO advertisement VALUES (DEFAULT, 3, 'Заголовок объявления №1', 'Описание объявления №4', '2020-11-06 13:51:57');
INSERT INTO advertisement VALUES (DEFAULT, 4, 'Заголовок объявления №1', 'Описание объявления №4', '2020-01-15 07:10:12');
INSERT INTO advertisement VALUES (DEFAULT, 7, 'Заголовок объявления №1', 'Описание объявления №4', '2020-02-08 03:53:18');
INSERT INTO advertisement VALUES (DEFAULT, 7, 'Заголовок объявления №2', 'Описание объявления №1', '2020-05-21 09:18:55');
INSERT INTO advertisement VALUES (DEFAULT, 3, 'Заголовок объявления №2', 'Описание объявления №1', '2020-03-12 00:29:24');
INSERT INTO advertisement VALUES (DEFAULT, 1, 'Заголовок объявления №2', 'Описание объявления №1', '2020-08-01 12:00:35');
INSERT INTO advertisement VALUES (DEFAULT, 5, 'Заголовок объявления №2', 'Описание объявления №1', '2020-10-14 22:12:18');
INSERT INTO advertisement VALUES (DEFAULT, 5, 'Заголовок объявления №2', 'Описание объявления №2', '2020-01-05 12:09:22');
INSERT INTO advertisement VALUES (DEFAULT, 2, 'Заголовок объявления №2', 'Описание объявления №2', '2020-09-04 22:39:29');
INSERT INTO advertisement VALUES (DEFAULT, 4, 'Заголовок объявления №2', 'Описание объявления №2', '2020-10-19 05:25:36');
INSERT INTO advertisement VALUES (DEFAULT, 3, 'Заголовок объявления №2', 'Описание объявления №2', '2020-08-16 02:13:31');
INSERT INTO advertisement VALUES (DEFAULT, 1, 'Заголовок объявления №2', 'Описание объявления №3', '2020-03-05 15:14:02');
INSERT INTO advertisement VALUES (DEFAULT, 3, 'Заголовок объявления №2', 'Описание объявления №3', '2020-01-07 08:56:13');
INSERT INTO advertisement VALUES (DEFAULT, 2, 'Заголовок объявления №2', 'Описание объявления №3', '2020-07-03 00:46:42');
INSERT INTO advertisement VALUES (DEFAULT, 1, 'Заголовок объявления №2', 'Описание объявления №3', '2020-02-28 11:09:10');
INSERT INTO advertisement VALUES (DEFAULT, 2, 'Заголовок объявления №2', 'Описание объявления №4', '2020-08-13 18:23:33');
INSERT INTO advertisement VALUES (DEFAULT, 6, 'Заголовок объявления №2', 'Описание объявления №4', '2020-04-25 14:21:55');
INSERT INTO advertisement VALUES (DEFAULT, 5, 'Заголовок объявления №2', 'Описание объявления №4', '2020-07-17 02:05:36');
INSERT INTO advertisement VALUES (DEFAULT, 7, 'Заголовок объявления №2', 'Описание объявления №4', '2020-11-26 08:27:49');
INSERT INTO advertisement VALUES (DEFAULT, 1, 'Заголовок объявления №3', 'Описание объявления №1', '2020-07-26 17:48:05');
INSERT INTO advertisement VALUES (DEFAULT, 2, 'Заголовок объявления №3', 'Описание объявления №1', '2020-08-02 22:40:33');
INSERT INTO advertisement VALUES (DEFAULT, 4, 'Заголовок объявления №3', 'Описание объявления №1', '2020-01-20 14:34:36');
INSERT INTO advertisement VALUES (DEFAULT, 6, 'Заголовок объявления №3', 'Описание объявления №1', '2020-02-06 03:46:13');
INSERT INTO advertisement VALUES (DEFAULT, 1, 'Заголовок объявления №3', 'Описание объявления №2', '2020-03-02 08:12:09');
INSERT INTO advertisement VALUES (DEFAULT, 3, 'Заголовок объявления №3', 'Описание объявления №2', '2020-07-07 13:16:47');
INSERT INTO advertisement VALUES (DEFAULT, 7, 'Заголовок объявления №3', 'Описание объявления №2', '2020-01-16 17:04:41');
INSERT INTO advertisement VALUES (DEFAULT, 4, 'Заголовок объявления №3', 'Описание объявления №2', '2020-03-27 22:28:02');
INSERT INTO advertisement VALUES (DEFAULT, 3, 'Заголовок объявления №3', 'Описание объявления №3', '2020-08-13 06:57:18');
INSERT INTO advertisement VALUES (DEFAULT, 1, 'Заголовок объявления №3', 'Описание объявления №3', '2020-05-25 14:34:37');
INSERT INTO advertisement VALUES (DEFAULT, 1, 'Заголовок объявления №3', 'Описание объявления №3', '2020-03-15 20:40:04');
INSERT INTO advertisement VALUES (DEFAULT, 2, 'Заголовок объявления №3', 'Описание объявления №3', '2020-01-24 19:53:32');
INSERT INTO advertisement VALUES (DEFAULT, 2, 'Заголовок объявления №3', 'Описание объявления №4', '2020-08-03 11:16:32');
INSERT INTO advertisement VALUES (DEFAULT, 1, 'Заголовок объявления №3', 'Описание объявления №4', '2020-03-22 22:22:31');
INSERT INTO advertisement VALUES (DEFAULT, 5, 'Заголовок объявления №3', 'Описание объявления №4', '2020-01-20 20:56:52');
INSERT INTO advertisement VALUES (DEFAULT, 5, 'Заголовок объявления №3', 'Описание объявления №4', '2020-02-13 20:41:51');
INSERT INTO advertisement VALUES (DEFAULT, 5, 'Заголовок объявления №4', 'Описание объявления №1', '2020-11-17 18:37:26');
INSERT INTO advertisement VALUES (DEFAULT, 3, 'Заголовок объявления №4', 'Описание объявления №1', '2020-02-22 19:10:20');
INSERT INTO advertisement VALUES (DEFAULT, 3, 'Заголовок объявления №4', 'Описание объявления №1', '2020-02-03 06:14:22');
INSERT INTO advertisement VALUES (DEFAULT, 4, 'Заголовок объявления №4', 'Описание объявления №1', '2020-01-25 21:08:37');
INSERT INTO advertisement VALUES (DEFAULT, 7, 'Заголовок объявления №4', 'Описание объявления №2', '2020-05-02 20:50:46');
INSERT INTO advertisement VALUES (DEFAULT, 4, 'Заголовок объявления №4', 'Описание объявления №2', '2020-03-29 04:16:18');
INSERT INTO advertisement VALUES (DEFAULT, 4, 'Заголовок объявления №4', 'Описание объявления №2', '2020-07-18 05:41:15');
INSERT INTO advertisement VALUES (DEFAULT, 7, 'Заголовок объявления №4', 'Описание объявления №2', '2020-10-26 07:39:50');
INSERT INTO advertisement VALUES (DEFAULT, 5, 'Заголовок объявления №4', 'Описание объявления №3', '2020-09-26 01:57:37');
INSERT INTO advertisement VALUES (DEFAULT, 3, 'Заголовок объявления №4', 'Описание объявления №3', '2020-04-24 21:22:11');
INSERT INTO advertisement VALUES (DEFAULT, 5, 'Заголовок объявления №4', 'Описание объявления №3', '2020-05-08 22:43:58');
INSERT INTO advertisement VALUES (DEFAULT, 2, 'Заголовок объявления №4', 'Описание объявления №3', '2020-01-25 18:15:40');
INSERT INTO advertisement VALUES (DEFAULT, 5, 'Заголовок объявления №4', 'Описание объявления №4', '2020-08-11 12:10:15');
INSERT INTO advertisement VALUES (DEFAULT, 2, 'Заголовок объявления №4', 'Описание объявления №4', '2020-02-22 04:04:08');
INSERT INTO advertisement VALUES (DEFAULT, 1, 'Заголовок объявления №4', 'Описание объявления №4', '2020-01-07 06:08:58');
INSERT INTO advertisement VALUES (DEFAULT, 1, 'Заголовок объявления №4', 'Описание объявления №4', '2020-01-06 09:51:17');
INSERT INTO advertisement VALUES (DEFAULT, 7, 'Заголовок объявления №5', 'Описание объявления №1', '2020-09-05 20:53:38');
INSERT INTO advertisement VALUES (DEFAULT, 5, 'Заголовок объявления №5', 'Описание объявления №1', '2020-11-14 04:14:17');
INSERT INTO advertisement VALUES (DEFAULT, 3, 'Заголовок объявления №5', 'Описание объявления №1', '2020-06-04 12:08:15');
INSERT INTO advertisement VALUES (DEFAULT, 2, 'Заголовок объявления №5', 'Описание объявления №1', '2020-02-10 02:03:38');
INSERT INTO advertisement VALUES (DEFAULT, 1, 'Заголовок объявления №5', 'Описание объявления №2', '2020-02-25 19:18:11');
INSERT INTO advertisement VALUES (DEFAULT, 2, 'Заголовок объявления №5', 'Описание объявления №2', '2020-05-24 01:31:23');
INSERT INTO advertisement VALUES (DEFAULT, 7, 'Заголовок объявления №5', 'Описание объявления №2', '2020-10-07 02:11:05');
INSERT INTO advertisement VALUES (DEFAULT, 5, 'Заголовок объявления №5', 'Описание объявления №2', '2020-09-25 21:01:37');
INSERT INTO advertisement VALUES (DEFAULT, 4, 'Заголовок объявления №5', 'Описание объявления №3', '2020-11-28 21:57:41');
INSERT INTO advertisement VALUES (DEFAULT, 6, 'Заголовок объявления №5', 'Описание объявления №3', '2020-10-22 11:06:46');
INSERT INTO advertisement VALUES (DEFAULT, 4, 'Заголовок объявления №5', 'Описание объявления №3', '2020-03-21 06:41:49');
INSERT INTO advertisement VALUES (DEFAULT, 1, 'Заголовок объявления №5', 'Описание объявления №3', '2020-03-30 16:27:13');
INSERT INTO advertisement VALUES (DEFAULT, 2, 'Заголовок объявления №5', 'Описание объявления №4', '2020-04-29 05:26:18');
INSERT INTO advertisement VALUES (DEFAULT, 2, 'Заголовок объявления №5', 'Описание объявления №4', '2020-10-03 05:55:23');
INSERT INTO advertisement VALUES (DEFAULT, 4, 'Заголовок объявления №5', 'Описание объявления №4', '2020-07-13 02:05:37');
INSERT INTO advertisement VALUES (DEFAULT, 6, 'Заголовок объявления №5', 'Описание объявления №4', '2020-07-25 09:20:00');
INSERT INTO advertisement VALUES (DEFAULT, 3, 'Заголовок объявления №6', 'Описание объявления №1', '2020-05-02 22:24:47');
INSERT INTO advertisement VALUES (DEFAULT, 5, 'Заголовок объявления №6', 'Описание объявления №1', '2020-03-14 16:52:41');
INSERT INTO advertisement VALUES (DEFAULT, 1, 'Заголовок объявления №6', 'Описание объявления №1', '2020-08-14 09:40:14');
INSERT INTO advertisement VALUES (DEFAULT, 7, 'Заголовок объявления №6', 'Описание объявления №1', '2020-07-08 06:01:08');
INSERT INTO advertisement VALUES (DEFAULT, 7, 'Заголовок объявления №6', 'Описание объявления №2', '2020-05-04 08:01:50');
INSERT INTO advertisement VALUES (DEFAULT, 1, 'Заголовок объявления №6', 'Описание объявления №2', '2020-07-29 22:49:02');
INSERT INTO advertisement VALUES (DEFAULT, 3, 'Заголовок объявления №6', 'Описание объявления №2', '2020-10-14 06:34:45');
INSERT INTO advertisement VALUES (DEFAULT, 7, 'Заголовок объявления №6', 'Описание объявления №2', '2020-06-20 16:20:22');
INSERT INTO advertisement VALUES (DEFAULT, 5, 'Заголовок объявления №6', 'Описание объявления №3', '2020-03-28 12:41:47');
INSERT INTO advertisement VALUES (DEFAULT, 5, 'Заголовок объявления №6', 'Описание объявления №3', '2020-02-11 20:35:58');
INSERT INTO advertisement VALUES (DEFAULT, 4, 'Заголовок объявления №6', 'Описание объявления №3', '2020-04-05 13:16:16');
INSERT INTO advertisement VALUES (DEFAULT, 2, 'Заголовок объявления №6', 'Описание объявления №3', '2020-09-26 09:07:50');
INSERT INTO advertisement VALUES (DEFAULT, 2, 'Заголовок объявления №6', 'Описание объявления №4', '2020-05-30 10:20:28');
INSERT INTO advertisement VALUES (DEFAULT, 5, 'Заголовок объявления №6', 'Описание объявления №4', '2020-08-02 16:10:44');
INSERT INTO advertisement VALUES (DEFAULT, 6, 'Заголовок объявления №6', 'Описание объявления №4', '2020-10-28 03:10:42');
INSERT INTO advertisement VALUES (DEFAULT, 2, 'Заголовок объявления №6', 'Описание объявления №4', '2020-05-07 10:33:16');
INSERT INTO advertisement VALUES (DEFAULT, 6, 'Заголовок объявления №7', 'Описание объявления №1', '2020-04-08 08:57:33');
INSERT INTO advertisement VALUES (DEFAULT, 7, 'Заголовок объявления №7', 'Описание объявления №1', '2020-09-05 01:43:15');
INSERT INTO advertisement VALUES (DEFAULT, 5, 'Заголовок объявления №7', 'Описание объявления №1', '2020-04-23 20:25:54');
INSERT INTO advertisement VALUES (DEFAULT, 1, 'Заголовок объявления №7', 'Описание объявления №1', '2020-11-04 09:38:23');
INSERT INTO advertisement VALUES (DEFAULT, 3, 'Заголовок объявления №7', 'Описание объявления №2', '2020-07-18 03:45:45');
INSERT INTO advertisement VALUES (DEFAULT, 7, 'Заголовок объявления №7', 'Описание объявления №2', '2020-05-27 15:50:00');
INSERT INTO advertisement VALUES (DEFAULT, 5, 'Заголовок объявления №7', 'Описание объявления №2', '2020-02-20 11:14:24');
INSERT INTO advertisement VALUES (DEFAULT, 6, 'Заголовок объявления №7', 'Описание объявления №2', '2020-10-05 14:18:52');
INSERT INTO advertisement VALUES (DEFAULT, 2, 'Заголовок объявления №7', 'Описание объявления №3', '2020-09-28 06:29:35');
INSERT INTO advertisement VALUES (DEFAULT, 5, 'Заголовок объявления №7', 'Описание объявления №3', '2020-03-21 20:00:20');
INSERT INTO advertisement VALUES (DEFAULT, 1, 'Заголовок объявления №7', 'Описание объявления №3', '2020-04-29 08:25:21');
INSERT INTO advertisement VALUES (DEFAULT, 5, 'Заголовок объявления №7', 'Описание объявления №3', '2020-02-13 17:41:19');
INSERT INTO advertisement VALUES (DEFAULT, 2, 'Заголовок объявления №7', 'Описание объявления №4', '2020-05-22 16:46:44');
INSERT INTO advertisement VALUES (DEFAULT, 3, 'Заголовок объявления №7', 'Описание объявления №4', '2020-09-09 16:12:02');
INSERT INTO advertisement VALUES (DEFAULT, 7, 'Заголовок объявления №7', 'Описание объявления №4', '2020-04-26 06:31:38');
INSERT INTO advertisement VALUES (DEFAULT, 6, 'Заголовок объявления №7', 'Описание объявления №4', '2020-04-03 07:29:53');
INSERT INTO advertisement VALUES (DEFAULT, 4, 'Заголовок объявления №8', 'Описание объявления №1', '2020-03-14 18:15:10');
INSERT INTO advertisement VALUES (DEFAULT, 2, 'Заголовок объявления №8', 'Описание объявления №1', '2020-03-02 13:03:03');
INSERT INTO advertisement VALUES (DEFAULT, 4, 'Заголовок объявления №8', 'Описание объявления №1', '2020-06-13 21:37:16');
INSERT INTO advertisement VALUES (DEFAULT, 5, 'Заголовок объявления №8', 'Описание объявления №1', '2020-04-04 21:32:05');
INSERT INTO advertisement VALUES (DEFAULT, 4, 'Заголовок объявления №8', 'Описание объявления №2', '2020-02-18 18:26:21');
INSERT INTO advertisement VALUES (DEFAULT, 7, 'Заголовок объявления №8', 'Описание объявления №2', '2020-10-29 18:15:32');
INSERT INTO advertisement VALUES (DEFAULT, 6, 'Заголовок объявления №8', 'Описание объявления №2', '2020-05-15 03:15:00');
INSERT INTO advertisement VALUES (DEFAULT, 4, 'Заголовок объявления №8', 'Описание объявления №2', '2020-03-09 18:24:03');
INSERT INTO advertisement VALUES (DEFAULT, 3, 'Заголовок объявления №8', 'Описание объявления №3', '2020-05-22 18:17:13');
INSERT INTO advertisement VALUES (DEFAULT, 7, 'Заголовок объявления №8', 'Описание объявления №3', '2020-06-20 08:17:09');
INSERT INTO advertisement VALUES (DEFAULT, 3, 'Заголовок объявления №8', 'Описание объявления №3', '2020-08-23 15:20:09');
INSERT INTO advertisement VALUES (DEFAULT, 4, 'Заголовок объявления №8', 'Описание объявления №3', '2020-01-07 19:37:10');
INSERT INTO advertisement VALUES (DEFAULT, 3, 'Заголовок объявления №8', 'Описание объявления №4', '2020-10-01 02:56:19');
INSERT INTO advertisement VALUES (DEFAULT, 4, 'Заголовок объявления №8', 'Описание объявления №4', '2020-08-21 12:32:03');
INSERT INTO advertisement VALUES (DEFAULT, 4, 'Заголовок объявления №8', 'Описание объявления №4', '2020-05-19 16:02:45');
INSERT INTO advertisement VALUES (DEFAULT, 5, 'Заголовок объявления №8', 'Описание объявления №4', '2020-11-05 07:34:35');
INSERT INTO advertisement VALUES (DEFAULT, 2, 'Заголовок объявления №9', 'Описание объявления №1', '2020-04-26 02:40:22');
INSERT INTO advertisement VALUES (DEFAULT, 5, 'Заголовок объявления №9', 'Описание объявления №1', '2020-05-23 12:00:22');
INSERT INTO advertisement VALUES (DEFAULT, 6, 'Заголовок объявления №9', 'Описание объявления №1', '2020-08-17 08:33:36');
INSERT INTO advertisement VALUES (DEFAULT, 4, 'Заголовок объявления №9', 'Описание объявления №1', '2020-01-04 16:01:54');
INSERT INTO advertisement VALUES (DEFAULT, 5, 'Заголовок объявления №9', 'Описание объявления №2', '2020-05-01 09:00:41');
INSERT INTO advertisement VALUES (DEFAULT, 5, 'Заголовок объявления №9', 'Описание объявления №2', '2020-06-10 09:51:37');
INSERT INTO advertisement VALUES (DEFAULT, 2, 'Заголовок объявления №9', 'Описание объявления №2', '2020-08-30 06:40:10');
INSERT INTO advertisement VALUES (DEFAULT, 6, 'Заголовок объявления №9', 'Описание объявления №2', '2020-02-12 05:29:22');
INSERT INTO advertisement VALUES (DEFAULT, 6, 'Заголовок объявления №9', 'Описание объявления №3', '2020-06-11 12:48:32');
INSERT INTO advertisement VALUES (DEFAULT, 7, 'Заголовок объявления №9', 'Описание объявления №3', '2020-07-09 21:33:16');
INSERT INTO advertisement VALUES (DEFAULT, 7, 'Заголовок объявления №9', 'Описание объявления №3', '2020-05-11 01:29:31');
INSERT INTO advertisement VALUES (DEFAULT, 6, 'Заголовок объявления №9', 'Описание объявления №3', '2020-09-23 20:53:51');
INSERT INTO advertisement VALUES (DEFAULT, 6, 'Заголовок объявления №9', 'Описание объявления №4', '2020-03-11 21:23:52');
INSERT INTO advertisement VALUES (DEFAULT, 6, 'Заголовок объявления №9', 'Описание объявления №4', '2020-04-27 14:11:29');
INSERT INTO advertisement VALUES (DEFAULT, 5, 'Заголовок объявления №9', 'Описание объявления №4', '2020-06-20 17:55:18');
INSERT INTO advertisement VALUES (DEFAULT, 4, 'Заголовок объявления №9', 'Описание объявления №4', '2020-06-04 16:53:14');
INSERT INTO advertisement VALUES (DEFAULT, 4, 'Заголовок объявления №10', 'Описание объявления №1', '2020-03-20 20:10:41');
INSERT INTO advertisement VALUES (DEFAULT, 6, 'Заголовок объявления №10', 'Описание объявления №1', '2020-04-18 11:54:36');
INSERT INTO advertisement VALUES (DEFAULT, 7, 'Заголовок объявления №10', 'Описание объявления №1', '2020-06-05 09:26:14');
INSERT INTO advertisement VALUES (DEFAULT, 2, 'Заголовок объявления №10', 'Описание объявления №1', '2020-09-07 19:42:00');
INSERT INTO advertisement VALUES (DEFAULT, 4, 'Заголовок объявления №10', 'Описание объявления №2', '2020-04-25 10:32:23');
INSERT INTO advertisement VALUES (DEFAULT, 3, 'Заголовок объявления №10', 'Описание объявления №2', '2020-10-09 02:07:08');
INSERT INTO advertisement VALUES (DEFAULT, 6, 'Заголовок объявления №10', 'Описание объявления №2', '2020-07-05 04:02:50');
INSERT INTO advertisement VALUES (DEFAULT, 4, 'Заголовок объявления №10', 'Описание объявления №2', '2020-10-18 00:32:23');
INSERT INTO advertisement VALUES (DEFAULT, 2, 'Заголовок объявления №10', 'Описание объявления №3', '2020-11-02 20:20:09');
INSERT INTO advertisement VALUES (DEFAULT, 5, 'Заголовок объявления №10', 'Описание объявления №3', '2020-11-16 14:02:52');
INSERT INTO advertisement VALUES (DEFAULT, 6, 'Заголовок объявления №10', 'Описание объявления №3', '2020-02-23 04:44:01');
INSERT INTO advertisement VALUES (DEFAULT, 2, 'Заголовок объявления №10', 'Описание объявления №3', '2020-02-12 00:10:50');
INSERT INTO advertisement VALUES (DEFAULT, 5, 'Заголовок объявления №10', 'Описание объявления №4', '2020-02-21 08:56:52');
INSERT INTO advertisement VALUES (DEFAULT, 7, 'Заголовок объявления №10', 'Описание объявления №4', '2020-09-22 10:18:36');
INSERT INTO advertisement VALUES (DEFAULT, 1, 'Заголовок объявления №10', 'Описание объявления №4', '2020-10-17 02:04:10');
INSERT INTO advertisement VALUES (DEFAULT, 6, 'Заголовок объявления №10', 'Описание объявления №4', '2020-07-18 06:20:54');

