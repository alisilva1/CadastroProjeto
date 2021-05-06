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
 
 insert into tbl_project (titulo,descricao,tipo,dataCriacao,dataTermino) 
 values ('Alfa','Topson','Trabalho','07/05/1990','09/02/1996');
 
 INSERT INTO `db_project`.`tbl_project` (`titulo`, `descricao`, `tipo`, `dataCriacao`, `dataTermino`) 
 VALUES ('Beta', 'Jobson', 'Prova', '2021-06-20','2021-06-29');

 INSERT INTO tbl_project (titulo) value ('Beta');
 
 select * from tbl_project;
truncate table tbl_project;