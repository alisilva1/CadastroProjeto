create database db_project;

use db_project;

CREATE TABLE `tbl_project` (
   `titulo` varchar(50) DEFAULT NULL,
   `descricao` varchar(100) DEFAULT NULL,
	`tipo` varchar(10) DEFAULT NULL,
   `dataCriacao` date DEFAULT NULL,
    `dataTermino` date DEFAULT NULL,
   `id` int NOT NULL AUTO_INCREMENT,
   PRIMARY KEY (`id`)
 ) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
 
ALTER TABLE `db_project`.`tbl_project` 
CHANGE COLUMN `dataCriacao` `data_criacao` DATE NULL DEFAULT NULL ,
CHANGE COLUMN `dataTermino` `data_termino` DATE NULL DEFAULT NULL ;
