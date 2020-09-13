/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50728
Source Host           : localhost:3306
Source Database       : db_books

Target Server Type    : MYSQL
Target Server Version : 50728
File Encoding         : 65001

Date: 2020-09-14 00:45:16
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for bank
-- ----------------------------
DROP TABLE IF EXISTS `bank`;
CREATE TABLE `bank` (
  `b_id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `b_name` varchar(255) DEFAULT NULL,
  `money` float DEFAULT NULL,
  `b_money` float DEFAULT NULL,
  `version` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`b_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of bank
-- ----------------------------
INSERT INTO `bank` VALUES ('1', 'zs', '100', '100', '1');
INSERT INTO `bank` VALUES ('2', 'ls', '100', '100', '1');

-- ----------------------------
-- Table structure for tb_books
-- ----------------------------
DROP TABLE IF EXISTS `tb_books`;
CREATE TABLE `tb_books` (
  `ID` int(11) NOT NULL,
  `ISBN` varchar(255) DEFAULT NULL,
  `BookName` varchar(255) DEFAULT NULL,
  `Unit` varchar(255) DEFAULT NULL,
  `Author` varchar(255) DEFAULT NULL,
  `money` float DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_books
-- ----------------------------
INSERT INTO `tb_books` VALUES ('0', 'ISBN00333', 'sql基础', '60', '辰东', null);
INSERT INTO `tb_books` VALUES ('2', 'ISBN0010', '斗罗大陆', '78', '唐家三少', null);
INSERT INTO `tb_books` VALUES ('3', 'ISBN0010', '万族之劫', '98', '老鹰吃小鸡', null);
INSERT INTO `tb_books` VALUES ('4', 'ISBN0010', '白骨大圣', '88', '咬火', null);
INSERT INTO `tb_books` VALUES ('5', 'ISBN0010', '第一序列', '67', '会说话的肘子', null);
INSERT INTO `tb_books` VALUES ('6', 'ISBN0010', '不听话', '1111', '曹雪芹', null);

-- ----------------------------
-- Table structure for tb_pre
-- ----------------------------
DROP TABLE IF EXISTS `tb_pre`;
CREATE TABLE `tb_pre` (
  `pre_id` int(11) NOT NULL AUTO_INCREMENT,
  `pre_name` varchar(30) DEFAULT NULL,
  `pre_url` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`pre_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_pre
-- ----------------------------
INSERT INTO `tb_pre` VALUES ('1', '谈生意', '#');
INSERT INTO `tb_pre` VALUES ('2', '签合同', '#');
INSERT INTO `tb_pre` VALUES ('3', '写代码', '#');

-- ----------------------------
-- Table structure for tb_role
-- ----------------------------
DROP TABLE IF EXISTS `tb_role`;
CREATE TABLE `tb_role` (
  `role_id` int(11) NOT NULL AUTO_INCREMENT,
  `role_name` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`role_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_role
-- ----------------------------
INSERT INTO `tb_role` VALUES ('1', '老板');
INSERT INTO `tb_role` VALUES ('2', '经理');
INSERT INTO `tb_role` VALUES ('3', '员工');

-- ----------------------------
-- Table structure for tb_role_pre
-- ----------------------------
DROP TABLE IF EXISTS `tb_role_pre`;
CREATE TABLE `tb_role_pre` (
  `role_id` int(11) NOT NULL,
  `pre_id` int(11) NOT NULL,
  PRIMARY KEY (`role_id`,`pre_id`),
  KEY `FK_role_pre_2` (`pre_id`),
  CONSTRAINT `FK_role_pre_1` FOREIGN KEY (`role_id`) REFERENCES `tb_role` (`role_id`),
  CONSTRAINT `FK_role_pre_2` FOREIGN KEY (`pre_id`) REFERENCES `tb_pre` (`pre_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_role_pre
-- ----------------------------
INSERT INTO `tb_role_pre` VALUES ('1', '1');
INSERT INTO `tb_role_pre` VALUES ('1', '2');
INSERT INTO `tb_role_pre` VALUES ('2', '2');
INSERT INTO `tb_role_pre` VALUES ('1', '3');
INSERT INTO `tb_role_pre` VALUES ('2', '3');
INSERT INTO `tb_role_pre` VALUES ('3', '3');

-- ----------------------------
-- Table structure for tb_user_role
-- ----------------------------
DROP TABLE IF EXISTS `tb_user_role`;
CREATE TABLE `tb_user_role` (
  `user_id` int(11) NOT NULL,
  `role_id` int(11) NOT NULL,
  PRIMARY KEY (`user_id`,`role_id`),
  KEY `Fk_user_role_2` (`role_id`),
  CONSTRAINT `Fk_user_role_1` FOREIGN KEY (`user_id`) REFERENCES `t_user` (`ID`),
  CONSTRAINT `Fk_user_role_2` FOREIGN KEY (`role_id`) REFERENCES `tb_role` (`role_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_user_role
-- ----------------------------
INSERT INTO `tb_user_role` VALUES ('1', '1');
INSERT INTO `tb_user_role` VALUES ('2', '2');
INSERT INTO `tb_user_role` VALUES ('2', '3');
INSERT INTO `tb_user_role` VALUES ('3', '3');

-- ----------------------------
-- Table structure for t_user
-- ----------------------------
DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user` (
  `ID` int(11) NOT NULL,
  `userName` varchar(20) DEFAULT NULL,
  `password` varchar(20) DEFAULT NULL,
  `money` float DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_user
-- ----------------------------
INSERT INTO `t_user` VALUES ('1', 'qwe', '123', '0');
INSERT INTO `t_user` VALUES ('2', 'asdf', '1234', '200');
INSERT INTO `t_user` VALUES ('3', 'yxc', '21123', '100');

-- ----------------------------
-- Procedure structure for p_proc
-- ----------------------------
DROP PROCEDURE IF EXISTS `p_proc`;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `p_proc`(in dno int,out cn int)
begin
	declare c int default 0;
	select count(*) into c from t_user where id = dno;
	set cn = c;
	 
end
;;
DELIMITER ;
