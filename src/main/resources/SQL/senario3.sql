create database user_db;

CREATE TABLE `user_db`.`t_user` (
  `user_id` BIGINT NOT NULL,
  `username` VARCHAR(100) NOT NULL,
  `ustatus` VARCHAR(50) NOT NULL,
  PRIMARY KEY (`user_id`)
);

create table t_udic (
    dictid BIGINT PRIMARY KEY,
    ustatus VARCHAR(100) NOT NULL,
    uvalue VARCHAR (100) NOT NULL
)