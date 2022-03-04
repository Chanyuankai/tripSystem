/*
MySQL Data Transfer
Source Host: localhost
Source Database: trip
Target Host: localhost
Target Database: trip
Date: 2022-3-4 22:52:45
*/

SET FOREIGN_KEY_CHECKS=0;
-- ----------------------------
-- Table structure for car
-- ----------------------------
DROP TABLE IF EXISTS `car`;
CREATE TABLE `car` (
  `id` int(100) NOT NULL AUTO_INCREMENT,
  `departure` varchar(100) NOT NULL,
  `arrive` varchar(100) NOT NULL,
  `date` varchar(100) NOT NULL,
  `dtime` varchar(100) NOT NULL,
  `atime` varchar(100) NOT NULL,
  `carnum` varchar(100) NOT NULL,
  `price` varchar(100) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for carorder
-- ----------------------------
DROP TABLE IF EXISTS `carorder`;
CREATE TABLE `carorder` (
  `id` int(111) NOT NULL AUTO_INCREMENT,
  `arrive` varchar(111) DEFAULT NULL,
  `departure` varchar(111) DEFAULT NULL,
  `date` varchar(111) DEFAULT NULL,
  `dtime` varchar(111) DEFAULT NULL,
  `atime` varchar(111) DEFAULT NULL,
  `carnum` varchar(111) DEFAULT NULL,
  `price` varchar(111) DEFAULT NULL,
  `number` varchar(1111) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for mangerlogin
-- ----------------------------
DROP TABLE IF EXISTS `mangerlogin`;
CREATE TABLE `mangerlogin` (
  `id` int(111) NOT NULL AUTO_INCREMENT,
  `number` varchar(111) DEFAULT NULL,
  `password` varchar(111) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for plane
-- ----------------------------
DROP TABLE IF EXISTS `plane`;
CREATE TABLE `plane` (
  `id` int(100) NOT NULL AUTO_INCREMENT,
  `departure` varchar(100) NOT NULL,
  `arrive` varchar(100) NOT NULL,
  `date` varchar(100) NOT NULL,
  `dtime` varchar(100) NOT NULL,
  `atime` varchar(100) NOT NULL,
  `airline` varchar(100) NOT NULL,
  `price` varchar(100) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for planeorder
-- ----------------------------
DROP TABLE IF EXISTS `planeorder`;
CREATE TABLE `planeorder` (
  `id` int(111) NOT NULL AUTO_INCREMENT,
  `arrive` varchar(111) DEFAULT NULL,
  `departure` varchar(111) DEFAULT NULL,
  `date` varchar(111) DEFAULT NULL,
  `dtime` varchar(111) DEFAULT NULL,
  `atime` varchar(111) DEFAULT NULL,
  `airline` varchar(111) DEFAULT NULL,
  `price` varchar(111) DEFAULT NULL,
  `number` varchar(1111) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for scenic
-- ----------------------------
DROP TABLE IF EXISTS `scenic`;
CREATE TABLE `scenic` (
  `id` int(111) NOT NULL AUTO_INCREMENT,
  `site` varchar(111) DEFAULT NULL,
  `adultprice` varchar(111) DEFAULT NULL,
  `childprice` varchar(111) DEFAULT NULL,
  `introduce` varchar(11111) DEFAULT NULL,
  `img` varchar(111) DEFAULT NULL,
  `name` varchar(111) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for scenicorder
-- ----------------------------
DROP TABLE IF EXISTS `scenicorder`;
CREATE TABLE `scenicorder` (
  `id` int(111) NOT NULL AUTO_INCREMENT,
  `number` varchar(111) DEFAULT NULL,
  `name` varchar(111) DEFAULT NULL,
  `childprice` varchar(111) DEFAULT NULL,
  `adultprice` varchar(111) DEFAULT NULL,
  `introduce` varchar(111) DEFAULT NULL,
  `reservenum` varchar(111) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for train
-- ----------------------------
DROP TABLE IF EXISTS `train`;
CREATE TABLE `train` (
  `id` int(100) NOT NULL AUTO_INCREMENT,
  `departure` varchar(100) NOT NULL,
  `arrive` varchar(100) NOT NULL,
  `date` varchar(100) NOT NULL,
  `dtime` varchar(100) NOT NULL,
  `atime` varchar(100) NOT NULL,
  `trainnum` varchar(100) NOT NULL,
  `price` varchar(100) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for trainorder
-- ----------------------------
DROP TABLE IF EXISTS `trainorder`;
CREATE TABLE `trainorder` (
  `id` int(111) NOT NULL AUTO_INCREMENT,
  `arrive` varchar(111) DEFAULT NULL,
  `departure` varchar(111) DEFAULT NULL,
  `date` varchar(111) DEFAULT NULL,
  `dtime` varchar(111) DEFAULT NULL,
  `atime` varchar(111) DEFAULT NULL,
  `trainnum` varchar(111) DEFAULT NULL,
  `price` varchar(111) DEFAULT NULL,
  `number` varchar(1111) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `gender` varchar(100) DEFAULT NULL,
  `date` varchar(100) DEFAULT NULL,
  `password` varchar(100) DEFAULT NULL,
  `number` varchar(100) DEFAULT NULL,
  `name` varchar(100) DEFAULT NULL,
  `id` int(100) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records 
-- ----------------------------
INSERT INTO `car` VALUES ('1', '哈尔滨', '黑河', '2021-5-24', '13:23', '15:23', '黑A TQ888', '2323元');
INSERT INTO `car` VALUES ('2', '南京', '长沙', '2021-5-23', '13:23', '19:23', '黑A TQ888', '45元');
INSERT INTO `car` VALUES ('3', '哈尔滨', '天津', '2021-5-23', '12:12', '12:34', '黑A TQ888', '5555元');
INSERT INTO `carorder` VALUES ('10', '广州', '哈尔滨', '2021-5-24', '13:23', '15:23', '黑A 21212', '1000元', '123');
INSERT INTO `carorder` VALUES ('12', '黑河', '哈尔滨', '2021-5-24', '13:23', '15:23', '黑A TQ888', '2323元', '123');
INSERT INTO `carorder` VALUES ('13', '天津', '哈尔滨', '2021-5-23', '12:12', '12:34', '黑A TQ888', '5555元', '1234');
INSERT INTO `carorder` VALUES ('14', '天津', '哈尔滨', '2021-5-23', '12:12', '12:34', '黑A TQ888', '5555元', '1234');
INSERT INTO `carorder` VALUES ('15', '长沙', '南京', '2021-5-23', '13:23', '19:23', '黑A TQ888', '45元', '1234');
INSERT INTO `carorder` VALUES ('16', '黑河', '哈尔滨', '2021-5-24', '13:23', '15:23', '黑A TQ888', '2323元', '1234');
INSERT INTO `mangerlogin` VALUES ('1', '123', '123');
INSERT INTO `mangerlogin` VALUES ('2', '789', '789');
INSERT INTO `plane` VALUES ('1', '哈尔滨', '广州', '2021-5-24', '13:23', '15:23', '南方航空', '1000元');
INSERT INTO `plane` VALUES ('2', '南京', '广州', '2021-5-23', '13:23', '19:23', '南方航空', '1200元');
INSERT INTO `plane` VALUES ('3', '哈尔滨', '天津', '2021-5-23', '12:12', '12:34', '南方航空', '1232元');
INSERT INTO `planeorder` VALUES ('10', '广州', '哈尔滨', '2021-5-24', '13:23', '15:23', '南方航空', '1000元', '123');
INSERT INTO `planeorder` VALUES ('11', '广州', '哈尔滨', '2021-5-24', '13:23', '15:23', '南方航空', '1000元', '123');
INSERT INTO `planeorder` VALUES ('12', '广州', '南京', '2021-5-23', '13:23', '19:23', '南方航空', '1200元', '1234');
INSERT INTO `planeorder` VALUES ('13', '广州', '哈尔滨', '2021-5-24', '13:23', '15:23', '南方航空', '1000元', '1234');
INSERT INTO `scenic` VALUES ('1', '哈尔滨', '110元', '11元', '是个有意思的地方', 'images/img02.png', '哈尔滨融创');
INSERT INTO `scenic` VALUES ('2', 'hhh', '110元', '11元', '看美女去', 'images/img04.png', '广州长隆');
INSERT INTO `scenic` VALUES ('3', '南京', '12元', '12元', '你说呢哈哈哈哈', 'images/img01.png', '南京夫子庙');
INSERT INTO `scenic` VALUES ('4', '长沙', '78元', '22元', '很好玩呀呀呀', 'images/img03.png', '长沙橘子洲头');
INSERT INTO `scenicorder` VALUES ('1', '1234', '哈尔滨419', '11元', '110元', '是个有意思的地方', '2');
INSERT INTO `scenicorder` VALUES ('2', '1234', '哈尔滨414', '11元', '110元', '是个有意思的地方', '34');
INSERT INTO `scenicorder` VALUES ('3', '1234', '哈尔滨融创', '12元', '110元', '是个有意思的地方', '12');
INSERT INTO `scenicorder` VALUES ('4', '1234', '南京夫子庙', '12元', '12元', '你说呢哈哈哈哈', '4');
INSERT INTO `scenicorder` VALUES ('5', '1234', '哈尔滨融创', '11元', '110元', '是个有意思的地方', '234');
INSERT INTO `scenicorder` VALUES ('6', '1234', '广州长隆', '11元', '110元', '一点都不好玩', '');
INSERT INTO `train` VALUES ('1', '哈尔滨西', '广州东', '2021-5-24', '13:23', '15:23', 'A12344', '1000元');
INSERT INTO `train` VALUES ('2', '南京北', '广州南', '2021-5-23', '13:23', '19:23', 'S12331', '1200元');
INSERT INTO `train` VALUES ('3', '哈尔滨西', '天津东', '2021-5-23', '12:12', '12:34', 'A21345', '1232元');
INSERT INTO `trainorder` VALUES ('12', '广州东', '哈尔滨西', '2021-5-24', '13:23', '15:23', 'A12344', '1000元', '1234');
INSERT INTO `trainorder` VALUES ('13', '广州南', '南京北', '2021-5-23', '13:23', '19:23', 'S12331', '1200元', '1234');
INSERT INTO `trainorder` VALUES ('14', '广州东', '哈尔滨西', '2021-5-24', '13:23', '15:23', 'A12344', '1000元', '1234');
INSERT INTO `trainorder` VALUES ('15', '天津东', '哈尔滨西', '2021-5-23', '12:12', '12:34', 'A21345', '1232元', '1234');
INSERT INTO `user` VALUES ('女', '2000-2-1', '1234', '1234', '曲蔚然', '2');
INSERT INTO `user` VALUES ('男', '2000.1.2', '123123', '2018040592', '陈源锴', '3');
INSERT INTO `user` VALUES ('女', '2000.11.11', '123123', '201415245', '唐成斌', '4');
INSERT INTO `user` VALUES ('男', '2000-2-1', '1', '123', '电风扇', '5');
INSERT INTO `user` VALUES ('wer', 'ewrwe', 'wer', 'wer', 'we', '12');
