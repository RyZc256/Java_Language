/*
 Navicat Premium Data Transfer

 Source Server         : java_advanced
 Source Server Type    : MySQL
 Source Server Version : 50734
 Source Host           : 150.158.146.225:3306
 Source Schema         : java_advanced

 Target Server Type    : MySQL
 Target Server Version : 50734
 File Encoding         : 65001

 Date: 23/05/2022 00:46:14
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for class
-- ----------------------------
DROP TABLE IF EXISTS `class`;
CREATE TABLE `class` (
  `ID` int(11) NOT NULL AUTO_INCREMENT COMMENT '班级编号',
  `Name` varchar(255) NOT NULL COMMENT '班级名称',
  `College` int(11) NOT NULL COMMENT '所属学院',
  `Teacher` int(11) NOT NULL COMMENT '所属教师',
  PRIMARY KEY (`ID`),
  KEY `College` (`College`),
  KEY `Teacher` (`Teacher`),
  CONSTRAINT `class_ibfk_1` FOREIGN KEY (`College`) REFERENCES `college` (`ID`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `class_ibfk_2` FOREIGN KEY (`Teacher`) REFERENCES `teacher` (`ID`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for college
-- ----------------------------
DROP TABLE IF EXISTS `college`;
CREATE TABLE `college` (
  `ID` int(11) NOT NULL AUTO_INCREMENT COMMENT '学院编号',
  `Name` varchar(255) NOT NULL COMMENT '学院名称',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for student
-- ----------------------------
DROP TABLE IF EXISTS `student`;
CREATE TABLE `student` (
  `ID` int(11) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `Account` varchar(255) NOT NULL COMMENT '用户名',
  `Password` varchar(255) NOT NULL COMMENT '用户密码',
  `Name` varchar(255) NOT NULL COMMENT '姓名',
  `Sex` varchar(255) NOT NULL COMMENT '性别',
  `Age` int(11) NOT NULL COMMENT '年龄',
  `IdCard` varchar(255) NOT NULL COMMENT '身份证',
  `Telphone` varchar(255) DEFAULT NULL COMMENT '联系方式',
  `Image` varchar(255) DEFAULT NULL COMMENT '头像',
  `College` int(11) NOT NULL COMMENT '所属学院',
  `Class` int(11) NOT NULL COMMENT '所属班级',
  `LastOnline` datetime DEFAULT NULL COMMENT '最后登录时间',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=1000000 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for teacher
-- ----------------------------
DROP TABLE IF EXISTS `teacher`;
CREATE TABLE `teacher` (
  `ID` int(11) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `Account` varchar(255) NOT NULL COMMENT '用户名',
  `Password` varchar(255) NOT NULL COMMENT '密码',
  `Name` varchar(255) NOT NULL COMMENT '姓名',
  `Sex` varchar(255) NOT NULL COMMENT '性别',
  `Age` int(11) NOT NULL COMMENT '年龄',
  `IdCard` varchar(255) NOT NULL COMMENT '身份证',
  `Telphone` varchar(255) DEFAULT NULL COMMENT '联系方式',
  `Image` varchar(255) DEFAULT NULL COMMENT '头像',
  `College` int(11) NOT NULL COMMENT '所属学院',
  `LastOnline` datetime NOT NULL COMMENT '最后登录时间',
  PRIMARY KEY (`ID`),
  KEY `College` (`College`),
  CONSTRAINT `teacher_ibfk_1` FOREIGN KEY (`College`) REFERENCES `college` (`ID`) ON DELETE NO ACTION ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=1000000 DEFAULT CHARSET=utf8;

SET FOREIGN_KEY_CHECKS = 1;
