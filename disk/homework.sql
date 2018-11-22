/*
Navicat MySQL Data Transfer

Source Server         : mysql
Source Server Version : 50520
Source Host           : localhost:3306
Source Database       : homework

Target Server Type    : MYSQL
Target Server Version : 50520
File Encoding         : 65001

Date: 2018-11-22 20:45:46
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for t_doc
-- ----------------------------
DROP TABLE IF EXISTS `t_doc`;
CREATE TABLE `t_doc` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '自增',
  `filename` varchar(200) NOT NULL COMMENT '文件名',
  `savepath` varchar(100) NOT NULL COMMENT '存储路径',
  `filesize` bigint(20) DEFAULT NULL COMMENT '文件大小',
  `catalog` varchar(50) DEFAULT NULL COMMENT '分类',
  `filetype` varchar(50) DEFAULT NULL COMMENT '文件类型',
  `memo` varchar(500) DEFAULT NULL COMMENT '备注',
  `isshare` varchar(10) NOT NULL COMMENT '是否共享',
  `username` varchar(50) NOT NULL COMMENT '用户名',
  `uploaddate` varchar(50) DEFAULT NULL COMMENT '上传时间',
  `count` int(11) NOT NULL COMMENT '总计数量',
  PRIMARY KEY (`id`),
  KEY `fkey_username` (`username`),
  CONSTRAINT `fkey_username` FOREIGN KEY (`username`) REFERENCES `t_user` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=26 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_doc
-- ----------------------------
INSERT INTO `t_doc` VALUES ('23', '21181740_1369193866785.jpg', 'D:\\disk\\src\\main\\resources\\static\\upload\\21181740_1369193866785.jpg', '48844', ' ', 'image/jpeg', ' ', 'yes', 'yhj', '2018-11-22', '3');
INSERT INTO `t_doc` VALUES ('24', '204J52M0-4.jpg', 'D:\\disk\\src\\main\\resources\\static\\upload\\204J52M0-4.jpg', '365944', ' ', 'image/jpeg', ' ', 'no', 'yhj', '2018-11-22', '0');
INSERT INTO `t_doc` VALUES ('25', '32-1PR914060b63.jpg', 'D:\\disk\\src\\main\\resources\\static\\upload\\32-1PR914060b63.jpg', '424455', ' ', 'image/jpeg', ' ', 'yes', 'yhj', '2018-11-22', '1');

-- ----------------------------
-- Table structure for t_user
-- ----------------------------
DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user` (
  `username` varchar(50) NOT NULL COMMENT '用户',
  `password` varchar(64) NOT NULL COMMENT '密码',
  `memo` varchar(200) DEFAULT NULL COMMENT '备注',
  `tel` varchar(12) DEFAULT NULL COMMENT '电话',
  `email` varchar(50) DEFAULT NULL COMMENT '邮箱',
  PRIMARY KEY (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_user
-- ----------------------------
INSERT INTO `t_user` VALUES ('yhj', '654321', 'none', '15636985562', 'xxx@QQ.com');
INSERT INTO `t_user` VALUES ('ysh', '970831', 'none', '15677897865', '666@QQ.com');
INSERT INTO `t_user` VALUES ('yy', '987654', 'none', '123456', '2255@qq.com');
