/*
 Navicat Premium Data Transfer

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 80011
 Source Host           : localhost
 Source Database       : library

 Target Server Type    : MySQL
 Target Server Version : 80011
 File Encoding         : utf-8

 Date: 08/15/2018 08:48:59 AM
*/

SET NAMES utf8;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
--  Table structure for `book`
-- ----------------------------
DROP TABLE IF EXISTS `book`;
CREATE TABLE `book` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) DEFAULT NULL,
  `author` varchar(20) DEFAULT NULL,
  `publish` varchar(20) DEFAULT NULL,
  `pages` int(10) DEFAULT NULL,
  `price` float(10,2) DEFAULT NULL,
  `bookcaseid` int(10) DEFAULT NULL,
  `abled` int(10) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_ieh6qsxp6q7oydadktc9oc8t2` (`bookcaseid`),
  CONSTRAINT `FK_ieh6qsxp6q7oydadktc9oc8t2` FOREIGN KEY (`bookcaseid`) REFERENCES `bookcase` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8;

-- ----------------------------
--  Records of `book`
-- ----------------------------
BEGIN;
INSERT INTO `book` VALUES ('1', '解忧杂货店', '东野圭吾', '南海出版公司', '102', '27.30', '1', '1'), ('2', '追风筝的人', '卡勒德·胡赛尼', '上海人民出版社', '230', '33.50', '1', '1'), ('3', '人间失格', '太宰治', '作家出版社', '150', '17.30', '1', '1'), ('4', '这就是二十四节气', '高春香', '海豚出版社', '220', '59.00', '3', '1'), ('5', '白夜行', '东野圭吾', '南海出版公司', '300', '27.30', '4', '1'), ('6', '摆渡人', '克莱儿·麦克福尔', '百花洲文艺出版社', '225', '22.80', '1', '1'), ('7', '暖暖心绘本', '米拦弗特毕', '湖南少儿出版社', '168', '131.60', '5', '1'), ('8', '天才在左疯子在右', '高铭', '北京联合出版公司', '330', '27.50', '6', '1'), ('9', '我们仨', '杨绛', '生活.读书.新知三联书店', '89', '17.20', '7', '1'), ('10', '活着', '余华', '作家出版社', '100', '13.00', '1', '1'), ('11', '水浒传', '施耐庵', '三联出版社', '300', '50.00', '1', '1'), ('12', '三国演义', '罗贯中', '三联出版社', '300', '50.00', '2', '1'), ('13', '红楼梦', '曹雪芹', '三联出版社', '300', '50.00', '5', '1'), ('14', '西游记', '吴承恩', '三联出版社', '300', '60.00', '3', '1'), ('15', '金瓶梅', '兰陵笑笑生', '三联出版社', '400', '70.00', '1', '1'), ('16', '色戒', '李安', '三联出版社', '100', '50.00', '6', '1'), ('17', '西游记', '吴承恩', '三联出版社', '200', '50.00', '1', '1');
COMMIT;

-- ----------------------------
--  Table structure for `bookadmin`
-- ----------------------------
DROP TABLE IF EXISTS `bookadmin`;
CREATE TABLE `bookadmin` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `username` varchar(15) DEFAULT NULL,
  `password` varchar(15) DEFAULT NULL,
  `purviewid` int(10) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
--  Records of `bookadmin`
-- ----------------------------
BEGIN;
INSERT INTO `bookadmin` VALUES ('1', 'admin1', '123123', '1'), ('2', 'admin2', '2222', '1'), ('3', 'zhangsan', '000', '1');
COMMIT;

-- ----------------------------
--  Table structure for `bookcase`
-- ----------------------------
DROP TABLE IF EXISTS `bookcase`;
CREATE TABLE `bookcase` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

-- ----------------------------
--  Records of `bookcase`
-- ----------------------------
BEGIN;
INSERT INTO `bookcase` VALUES ('1', '社会'), ('2', '情感'), ('3', '国学'), ('4', '推理'), ('5', '绘画'), ('6', '心理学'), ('7', '传记');
COMMIT;

-- ----------------------------
--  Table structure for `booktype`
-- ----------------------------
DROP TABLE IF EXISTS `booktype`;
CREATE TABLE `booktype` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) DEFAULT NULL,
  `days` int(10) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
--  Records of `booktype`
-- ----------------------------
BEGIN;
INSERT INTO `booktype` VALUES ('1', '普通图书', '30');
COMMIT;

-- ----------------------------
--  Table structure for `borrow`
-- ----------------------------
DROP TABLE IF EXISTS `borrow`;
CREATE TABLE `borrow` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `bookid` int(10) DEFAULT NULL,
  `readerid` int(10) DEFAULT NULL,
  `borrowtime` varchar(20) DEFAULT NULL,
  `returntime` varchar(20) DEFAULT NULL,
  `adminid` int(10) DEFAULT NULL,
  `state` int(10) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=70 DEFAULT CHARSET=utf8;

-- ----------------------------
--  Records of `borrow`
-- ----------------------------
BEGIN;
INSERT INTO `borrow` VALUES ('68', '1', '4', '2018-07-19', '2018-08-02', '1', '2'), ('69', '3', '3', '2018-07-19', '2018-08-02', '1', '3');
COMMIT;

-- ----------------------------
--  Table structure for `reader`
-- ----------------------------
DROP TABLE IF EXISTS `reader`;
CREATE TABLE `reader` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(30) DEFAULT NULL,
  `password` varchar(20) DEFAULT NULL,
  `name` varchar(10) DEFAULT NULL,
  `tel` varchar(11) DEFAULT NULL,
  `cardid` varchar(15) DEFAULT NULL,
  `gender` varchar(2) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
--  Records of `reader`
-- ----------------------------
BEGIN;
INSERT INTO `reader` VALUES ('3', 'zhangsan', '123123', '张三', '131', '001', '男'), ('4', 'lisi', '000', '李四', '987655123', '002', '男');
COMMIT;

-- ----------------------------
--  Table structure for `readertype`
-- ----------------------------
DROP TABLE IF EXISTS `readertype`;
CREATE TABLE `readertype` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) DEFAULT NULL,
  `number` int(10) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
--  Records of `readertype`
-- ----------------------------
BEGIN;
INSERT INTO `readertype` VALUES ('1', '普通读者', '10');
COMMIT;

-- ----------------------------
--  Table structure for `returnbook`
-- ----------------------------
DROP TABLE IF EXISTS `returnbook`;
CREATE TABLE `returnbook` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `bookid` int(10) DEFAULT NULL,
  `readerid` int(10) DEFAULT NULL,
  `returntime` varchar(20) DEFAULT NULL,
  `adminid` int(10) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8;

-- ----------------------------
--  Records of `returnbook`
-- ----------------------------
BEGIN;
INSERT INTO `returnbook` VALUES ('21', '1', '3', '2018-07-05', '1');
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
