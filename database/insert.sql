INSERT INTO clients VALUES (1, 'Смелянский Руслан Леонидович', 'smel@gmail.com', 'г. Москва, Ломоносовский проспект');
INSERT INTO clients VALUES (2, 'Сальников Алексей Николаевич', 'salnikov@gmail.com', 'г. Москва, ул. Мира');
INSERT INTO clients VALUES (3, 'Санников Виктор Федорович', 'sanny@gmail.com', 'г. Севастополь, ул. Фадеева');
INSERT INTO clients VALUES (4, 'Нагорный Александр Степанович', 'nagorne@gmail.com', 'г. Москва, ул. Лермонтова');
INSERT INTO clients VALUES (5, 'Сазонов Василий Викторович', 'sazonov@gmail.com', 'г. Москва, ул. Пушкина');
INSERT INTO clients VALUES (6, 'Линь Данил', 'linadnil@gmail.com', 'г. Москва, пр. Мичуринский');
INSERT INTO clients VALUES (7, 'Шишков Илья Сергеевич', 'il.shishkov@gmail.com', 'г. Москва, ул. Красного Маяка');


INSERT INTO Companies VALUES (1, 'Pixar');
INSERT INTO Companies VALUES (2, 'Universal Pictures');
INSERT INTO Companies VALUES (3, 'Columbia Pictures');
INSERT INTO Companies VALUES (4, 'DreamWorks');
INSERT INTO Companies VALUES (5, 'Paramount Pictures');
INSERT INTO Companies VALUES (6, 'Metro-Goldwyn-Mayer');
INSERT INTO Companies VALUES (7, '20th Century Fox');

INSERT INTO Directors VALUES (1, 'Том МакГрат');
INSERT INTO Directors VALUES (2, 'Эндрю Адамсон');
INSERT INTO Directors VALUES (3, 'Стивен Спилберг');
INSERT INTO Directors VALUES (4, 'Роберт Земекис');
INSERT INTO Directors VALUES (5, 'Джон Лассетер');
INSERT INTO Directors VALUES (6, 'Пит Доктер');
INSERT INTO Directors VALUES (7, 'Квентин Тарантино');
INSERT INTO Directors VALUES (8, 'Дэвид Финчер');
INSERT INTO Directors VALUES (9, 'Мартин Скорсезе');
INSERT INTO Directors VALUES (10, 'Виктор Флеминг');
INSERT INTO Directors VALUES (11, 'Джэймс Кэмерон');


INSERT INTO Movies VALUES (1, 'Мадагаскар',2005,1,4);
INSERT INTO Movies VALUES (2, 'Шрек',2001,2,4);
INSERT INTO Movies VALUES (3, 'Спиоск Шиндлера',1993,3,2);
INSERT INTO Movies VALUES (4, 'Назад в будущее',1985,4,2);
INSERT INTO Movies VALUES (5, 'Тачки',2006,5,1);
INSERT INTO Movies VALUES (6, 'Вверх!',2009,6,1);
INSERT INTO Movies VALUES (7, 'Джанго освобожденный',2012,7,3);
INSERT INTO Movies VALUES (8, 'Социальная сеть',2010,8,3);
INSERT INTO Movies VALUES (9, 'Форрест Гамп',1994,4,5);
INSERT INTO Movies VALUES (10, 'Остров проклятых',2009,9,5);
INSERT INTO Movies VALUES (11, 'Унесенные ветром',1939,10,6);
INSERT INTO Movies VALUES (12, 'Аватар',2009,11,7);

INSERT INTO Copy_type VALUES (1, 'CD');
INSERT INTO Copy_type VALUES (2, 'DVD');
INSERT INTO Copy_type VALUES (3, 'Blu-Ray');
INSERT INTO Copy_type VALUES (4, 'VHS');

INSERT INTO Copies VALUES (1, 1, 1, 5, 5, 10);
INSERT INTO Copies VALUES (2, 1, 2, 5, 5, 12);
INSERT INTO Copies VALUES (3, 1, 3, 5, 5, 15);
INSERT INTO Copies VALUES (4, 2, 1, 5, 5, 10);
INSERT INTO Copies VALUES (5, 2, 2, 5, 5, 12);
INSERT INTO Copies VALUES (6, 2, 3, 5, 5, 15);
INSERT INTO Copies VALUES (7, 3, 1, 5, 5, 10);
INSERT INTO Copies VALUES (8, 4, 1, 5, 5, 10);
INSERT INTO Copies VALUES (9, 5, 1, 5, 5, 10);
INSERT INTO Copies VALUES (10, 6, 1, 5, 5, 10);
INSERT INTO Copies VALUES (11, 7, 1, 5, 5, 10);
INSERT INTO Copies VALUES (12, 8, 1, 5, 5, 10);
INSERT INTO Copies VALUES (13, 9, 1, 5, 5, 10);
INSERT INTO Copies VALUES (14, 10, 1, 5, 5, 10);
INSERT INTO Copies VALUES (15, 11, 1, 5, 5, 10);
INSERT INTO Copies VALUES (16, 12, 1, 5, 5, 10);
INSERT INTO Copies VALUES (17, 4, 2, 5, 5, 12);
INSERT INTO Copies VALUES (18, 5, 2, 5, 5, 12);
INSERT INTO Copies VALUES (19, 6, 2, 5, 5, 12);
INSERT INTO Copies VALUES (20, 7, 2, 5, 5, 12);
INSERT INTO Copies VALUES (21, 8, 2, 5, 5, 12);
INSERT INTO Copies VALUES (22, 9, 2, 5, 5, 12);
INSERT INTO Copies VALUES (23, 10, 2, 5, 5, 12);
INSERT INTO Copies VALUES (24, 11, 2, 5, 5, 12);
INSERT INTO Copies VALUES (25, 12, 2, 5, 5, 12);


INSERT INTO Order_history VALUES (1,5,1,'2014-02-17 12:00:00','2014-02-21 13:00:00',20);
INSERT INTO Order_history VALUES (2,3,2,'2013-12-15 12:00:00','2013-12-22 13:00:00',20);
INSERT INTO Order_history VALUES (3,7,3,'2014-01-02 12:00:00','2014-01-08 13:00:00',20);
INSERT INTO Order_history VALUES (4,22,4,'2014-01-17 12:00:00','2014-01-21 13:00:00',20);
INSERT INTO Order_history VALUES (5,10,5,'2014-01-17 12:00:00','2014-01-21 13:00:00',20);
INSERT INTO Order_history VALUES (6,17,6,'2014-01-17 12:00:00','2014-01-21 13:00:00',20);


