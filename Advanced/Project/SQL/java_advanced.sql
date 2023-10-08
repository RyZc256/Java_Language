/*
 Navicat Premium Data Transfer

 Source Server         : java_advanced
 Source Server Type    : MySQL
 Source Server Version : 50734
 Source Host           : localhost:3306
 Source Schema         : java_advanced

 Target Server Type    : MySQL
 Target Server Version : 50734
 File Encoding         : 65001

 Date: 01/06/2022 11:43:21
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for attend
-- ----------------------------
DROP TABLE IF EXISTS `attend`;
CREATE TABLE `attend` (
  `ID` int(11) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `Student` int(11) NOT NULL COMMENT '学生',
  `Datetime` datetime DEFAULT NULL COMMENT '打卡时间',
  `Status` int(11) DEFAULT '0' COMMENT '打卡状态',
  `Date` date NOT NULL COMMENT '日期',
  PRIMARY KEY (`ID`),
  KEY `Student` (`Student`),
  CONSTRAINT `attend_ibfk_1` FOREIGN KEY (`Student`) REFERENCES `student` (`Account`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=74 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for class
-- ----------------------------
DROP TABLE IF EXISTS `class`;
CREATE TABLE `class` (
  `ID` int(11) NOT NULL AUTO_INCREMENT COMMENT '班级编号',
  `Name` varchar(255) NOT NULL COMMENT '班级名称',
  `College` varchar(255) NOT NULL COMMENT '所属学院',
  PRIMARY KEY (`ID`),
  KEY `College` (`College`),
  KEY `Name` (`Name`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for college
-- ----------------------------
DROP TABLE IF EXISTS `college`;
CREATE TABLE `college` (
  `ID` int(11) NOT NULL AUTO_INCREMENT COMMENT '学院编号',
  `Name` varchar(255) NOT NULL COMMENT '学院名称',
  PRIMARY KEY (`ID`),
  KEY `Name` (`Name`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for student
-- ----------------------------
DROP TABLE IF EXISTS `student`;
CREATE TABLE `student` (
  `Account` int(11) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `Password` varchar(255) NOT NULL COMMENT '用户密码',
  `Name` varchar(255) NOT NULL COMMENT '姓名',
  `Sex` varchar(255) NOT NULL COMMENT '性别',
  `Age` int(11) NOT NULL COMMENT '年龄',
  `IdCard` varchar(255) NOT NULL COMMENT '身份证',
  `Telphone` varchar(255) DEFAULT NULL COMMENT '联系方式',
  `Image` varchar(255) DEFAULT NULL COMMENT '头像',
  `College` varchar(255) NOT NULL COMMENT '所属学院',
  `Class` varchar(255) NOT NULL COMMENT '所属班级',
  `LastOnline` datetime DEFAULT NULL COMMENT '最后登录时间',
  PRIMARY KEY (`Account`) USING BTREE,
  UNIQUE KEY `IdCard` (`IdCard`)
) ENGINE=InnoDB AUTO_INCREMENT=2000270 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for stutask
-- ----------------------------
DROP TABLE IF EXISTS `stutask`;
CREATE TABLE `stutask` (
  `ID` int(11) NOT NULL COMMENT '任务编号',
  `Student` int(11) NOT NULL COMMENT '接收学生',
  `CompletionTime` datetime DEFAULT NULL COMMENT '完成时间',
  `Path` varchar(255) DEFAULT NULL COMMENT '文件路径',
  `Status` int(11) NOT NULL DEFAULT '0' COMMENT '完成状态',
  KEY `Student` (`Student`),
  CONSTRAINT `stutask_ibfk_1` FOREIGN KEY (`Student`) REFERENCES `student` (`Account`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for teacher
-- ----------------------------
DROP TABLE IF EXISTS `teacher`;
CREATE TABLE `teacher` (
  `Account` int(11) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `Password` varchar(255) NOT NULL COMMENT '密码',
  `Name` varchar(255) NOT NULL COMMENT '姓名',
  `Sex` varchar(255) NOT NULL COMMENT '性别',
  `Age` int(11) NOT NULL COMMENT '年龄',
  `IdCard` varchar(255) NOT NULL COMMENT '身份证',
  `Telphone` varchar(255) NOT NULL COMMENT '联系方式',
  `Image` varchar(255) DEFAULT NULL COMMENT '头像',
  `College` varchar(255) NOT NULL COMMENT '所属学院',
  `Class` varchar(255) NOT NULL COMMENT '班级',
  `LastOnline` datetime NOT NULL COMMENT '最后登录时间',
  `Enable` int(11) NOT NULL DEFAULT '0' COMMENT '是否启用',
  PRIMARY KEY (`Account`) USING BTREE,
  UNIQUE KEY `IdCard` (`IdCard`),
  KEY `College` (`College`),
  CONSTRAINT `teacher_ibfk_1` FOREIGN KEY (`College`) REFERENCES `college` (`Name`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=1000010 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for teatask
-- ----------------------------
DROP TABLE IF EXISTS `teatask`;
CREATE TABLE `teatask` (
  `ID` int(11) NOT NULL AUTO_INCREMENT COMMENT '任务编号',
  `Title` varchar(255) NOT NULL COMMENT '任务标题',
  `Content` varchar(255) NOT NULL COMMENT '任务内容',
  `DispatchTime` datetime NOT NULL COMMENT '下发时间',
  `Deadline` datetime NOT NULL COMMENT '截止时间',
  `Teacher` int(11) NOT NULL COMMENT '所属教师',
  PRIMARY KEY (`ID`),
  KEY `Teacher` (`Teacher`),
  CONSTRAINT `teatask_ibfk_1` FOREIGN KEY (`Teacher`) REFERENCES `teacher` (`Account`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Procedure structure for getStuCompleteTask
-- ----------------------------
DROP PROCEDURE IF EXISTS `getStuCompleteTask`;
delimiter ;;
CREATE PROCEDURE `getStuCompleteTask`(IN taskId int, IN stuId int)
BEGIN
	SELECT a.ID,a.Student,a.Path,a.CompletionTime,a.`Status`,b.`Name` FROM stutask AS a JOIN student AS b ON a.Student = b.Account WHERE a.ID = taskId and a.Student=stuId;
  #Routine body goes here...
END
;;
delimiter ;

-- ----------------------------
-- Procedure structure for getStuTask
-- ----------------------------
DROP PROCEDURE IF EXISTS `getStuTask`;
delimiter ;;
CREATE PROCEDURE `getStuTask`(IN stuId integer, IN now datetime)
BEGIN
	SELECT a.ID,a.Student,a.CompletionTime,a.Path,a.Status,b.Title,b.Content,b.DispatchTime,b.Deadline,b.Teacher 
	FROM stutask AS a JOIN teatask AS b ON a.ID = b.ID 
	WHERE a.Student=stuId AND b.Deadline>now ORDER BY b.DispatchTime DESC;
  #Routine body goes here...
END
;;
delimiter ;

-- ----------------------------
-- Procedure structure for getTeaTask
-- ----------------------------
DROP PROCEDURE IF EXISTS `getTeaTask`;
delimiter ;;
CREATE PROCEDURE `getTeaTask`(IN teaId INT)
BEGIN
	SELECT a.ID,a.Student,a.CompletionTime,a.Path,a.Status,b.Title,b.Content,b.DispatchTime,b.Deadline,b.Teacher 
	FROM stutask AS a JOIN teatask AS b ON a.ID = b.ID 
	WHERE b.teacher=teaId ORDER BY b.DispatchTime DESC;
  #Routine body goes here...
END
;;
delimiter ;

SET FOREIGN_KEY_CHECKS = 1;
