SET NAMES 'utf8' COLLATE 'utf8_general_ci';

DROP DATABASE IF EXISTS `bfa`;

CREATE DATABASE `bfa` CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;

USE `bfa`;

CREATE TABLE `group`(
  `id` INT PRIMARY KEY NOT NULL auto_increment,
  `name` VARCHAR (10) NOT NULL
);

CREATE TABLE `foods` (
  `id` INT PRIMARY KEY NOT NULL auto_increment,
  `name` VARCHAR (15) NOT NULL,
  `calories` INT,
  `groupId` INT NOT NULL,
  FOREIGN KEY (`groupId`) REFERENCES `group`(`id`)
);

INSERT INTO `bfa`.`group` (`id`, `name`) VALUES ('1', 'Healthy');
INSERT INTO `bfa`.`group` (`id`, `name`) VALUES ('2', 'Unhealthy');
INSERT INTO `bfa`.`group` (`id`, `name`) VALUES ('3', 'New Group');

INSERT INTO `bfa`.`foods` (`id`, `name`, `calories`, `groupId`) VALUES ('1', 'salad', '120', '1');
INSERT INTO `bfa`.`foods` (`id`, `name`, `calories`, `groupId`) VALUES ('2', 'apple', '140', '1');
INSERT INTO `bfa`.`foods` (`id`, `name`, `calories`, `groupId`) VALUES ('3', 'pizza', '1200', '2');
INSERT INTO `bfa`.`foods` (`id`, `name`, `calories`, `groupId`) VALUES ('4', 'chips', '450', '2');
INSERT INTO `bfa`.`foods` (`id`, `name`, `calories`, `groupId`) VALUES ('5', 'candy', '150', '2');
