ALTER TABLE `Movies` DROP FOREIGN KEY `Movie_director`; 
ALTER TABLE `Movies` DROP FOREIGN KEY `Movie_company`;
ALTER TABLE `Copies` DROP FOREIGN KEY `Copy_film`;
ALTER TABLE `Copies` DROP FOREIGN KEY `Copy_type_constraint`;
ALTER TABLE `Order_history` DROP FOREIGN KEY `Order_copy`;
ALTER TABLE `Order_history` DROP FOREIGN KEY `Order_client`;

DROP TABLE IF EXISTS Clients;
DROP TABLE IF EXISTS Movies;
DROP TABLE IF EXISTS Companies;
DROP TABLE IF EXISTS Directors;
DROP TABLE IF EXISTS Copies;
DROP TABLE IF EXISTS Copy_type;
DROP TABLE IF EXISTS Order_history;