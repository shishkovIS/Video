CREATE TABLE `Movies` (
  `movie_id` INT NOT NULL AUTO_INCREMENT,
  `title` VARCHAR(100),
  `year` INT,
  `director_id` INT,
  `company_id` INT,
  PRIMARY KEY  (`movie_id`)
);

CREATE TABLE `Clients` (
  `client_id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(100),
  `e-mail` VARCHAR(50),
  `adress` VARCHAR(50),
  PRIMARY KEY  (`client_id`)
);

CREATE TABLE `Companies` (
  `company_id` INT NOT NULL AUTO_INCREMENT,
  `company_name` VARCHAR(60),
  PRIMARY KEY  (`company_id`)
);

CREATE TABLE `Directors` (
  `director_id` INT NOT NULL AUTO_INCREMENT,
  `director_name` VARCHAR(50),
   PRIMARY KEY  (`director_id`)
);

CREATE TABLE `Copies` (
  `copy_id` INT NOT NULL AUTO_INCREMENT,
  `film_id` INT,
  `copy_type` INT,
  `count` INT,
  `count_available` INT,
  `rent_cost` INT,
  PRIMARY KEY  (`copy_id`)
);

CREATE TABLE `Copy_type` (
  `type_id` INT NOT NULL AUTO_INCREMENT,
  `type_name` VARCHAR(30),
  PRIMARY KEY  (`type_id`)
);

CREATE TABLE `Order_history` (
  `history_id` INT NOT NULL AUTO_INCREMENT,
  `copy_id` INT,
  `client_id` INT,
  `order_time` DATETIME,
  `return_time` DATETIME,
  `payout` INT,
  PRIMARY KEY  (`history_id`)
  
);

ALTER TABLE `Movies` ADD CONSTRAINT `Movie_director` FOREIGN KEY (`director_id`) REFERENCES Directors(`director_id`);
ALTER TABLE `Movies` ADD CONSTRAINT `Movie_company` FOREIGN KEY (`company_id`) REFERENCES Companies(`company_id`);
ALTER TABLE `Copies` ADD CONSTRAINT `Copy_film` FOREIGN KEY (`film_id`) REFERENCES Movies(`Movie_id`);
ALTER TABLE `Copies` ADD CONSTRAINT `Copy_type_constraint` FOREIGN KEY (`copy_type`) REFERENCES Copy_type(`type_id`);
ALTER TABLE `Order_history` ADD CONSTRAINT `Order_copy` FOREIGN KEY (`copy_id`) REFERENCES Copies(`copy_id`);
ALTER TABLE `Order_history` ADD CONSTRAINT `Order_client` FOREIGN KEY (`client_id`) REFERENCES Clients(`client_id`);
