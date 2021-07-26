DROP DATABASE IF EXISTS project;
CREATE DATABASE project;

USE project;

DROP TABLE IF EXISTS `admin`;
CREATE TABLE `admin` (
  `admin_id` int NOT NULL,
  `name` varchar(100) DEFAULT NULL,
  `email` varchar(100) DEFAULT NULL,
  `password` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`admin_id`)
);

DROP TABLE IF EXISTS `contact`;
CREATE TABLE `contact` (
  `user_id` int DEFAULT NULL,
  `name` varchar(30) DEFAULT NULL,
  `email` varchar(20) DEFAULT NULL,
  `phone_no` bigint DEFAULT NULL,
  `message` varchar(20) DEFAULT NULL,
  `contact_id` int NOT NULL,
  PRIMARY KEY (`contact_id`)
);

DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `user_id` int NOT NULL,
  `name` varchar(100) DEFAULT NULL,
  `phone_no` bigint DEFAULT NULL,
  `email` varchar(100) DEFAULT NULL,
  `address` varchar(100) DEFAULT NULL,
  `reg_date` date DEFAULT NULL,
  `password` varchar(100) DEFAULT NULL,
  `upload_photo` mediumtext,
  PRIMARY KEY (`user_id`)
);

DROP TABLE IF EXISTS `course`;
CREATE TABLE `course` (
  `course_id` int NOT NULL,
  `c_name` varchar(100) DEFAULT NULL,
  `c_desp` varchar(100) DEFAULT NULL,
  `c_fees` varchar(100) DEFAULT NULL,
  `c_resource` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`course_id`)
);

DROP TABLE IF EXISTS `feedback`;
CREATE TABLE `feedback` (
  `user_id` int DEFAULT NULL,
  `name` varchar(100) DEFAULT NULL,
  `email` varchar(100) DEFAULT NULL,
  `f_id` int NOT NULL,
  `feedback` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`f_id`)
);