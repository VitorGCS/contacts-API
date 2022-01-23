CREATE DATABASE IF NOT EXISTS `contacts`;
USE `contacts`;

DROP TABLE IF EXISTS `contact_info`;

CREATE TABLE `contact_info` ( `id` int(11) NOT NULL AUTO_INCREMENT,
                              `first_name` varchar(45) DEFAULT NULL,
                              `last_name` varchar(45) DEFAULT NULL,
                              `email` varchar(45) DEFAULT NULL,
                              PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;
