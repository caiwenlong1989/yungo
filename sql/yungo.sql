/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50642
Source Host           : localhost:3306
Source Database       : yungo

Target Server Type    : MYSQL
Target Server Version : 50642
File Encoding         : 65001

Date: 2018-12-27 11:28:25
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for t_customer
-- ----------------------------
DROP TABLE IF EXISTS `t_customer`;
CREATE TABLE `t_customer` (
  `id` int(11) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  `phone` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_customer
-- ----------------------------

-- ----------------------------
-- Table structure for t_index
-- ----------------------------
DROP TABLE IF EXISTS `t_index`;
CREATE TABLE `t_index` (
  `msg` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_index
-- ----------------------------
INSERT INTO `t_index` VALUES ('你好，这是测试接口的响应内容，用于检查整个应用交互是否正常。');

-- ----------------------------
-- Table structure for t_log_buy
-- ----------------------------
DROP TABLE IF EXISTS `t_log_buy`;
CREATE TABLE `t_log_buy` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `update_time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `phone` varchar(255) DEFAULT NULL,
  `product_id` int(11) DEFAULT NULL,
  `from_count` int(11) DEFAULT NULL,
  `count` int(11) DEFAULT NULL,
  `to_count` int(11) DEFAULT NULL,
  `buy_status` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_log_buy
-- ----------------------------
INSERT INTO `t_log_buy` VALUES ('1', '2018-12-27 11:06:03', null, '15000000040', '1', '178', '2', '176', '1');
INSERT INTO `t_log_buy` VALUES ('2', '2018-12-27 11:06:03', null, '15000000027', '1', '200', '22', '178', '1');
INSERT INTO `t_log_buy` VALUES ('3', '2018-12-27 11:06:03', null, '15000000050', '1', '164', '28', '136', '1');
INSERT INTO `t_log_buy` VALUES ('4', '2018-12-27 11:06:03', null, '15000000023', '1', '176', '12', '164', '1');
INSERT INTO `t_log_buy` VALUES ('5', '2018-12-27 11:06:03', null, '15000000017', '1', '120', '7', '113', '1');
INSERT INTO `t_log_buy` VALUES ('6', '2018-12-27 11:06:03', null, '15000000090', '1', '77', '11', '66', '1');
INSERT INTO `t_log_buy` VALUES ('7', '2018-12-27 11:06:03', null, '15000000084', '1', '97', '20', '77', '1');
INSERT INTO `t_log_buy` VALUES ('8', '2018-12-27 11:06:03', null, '15000000007', '1', '42', '9', '33', '1');
INSERT INTO `t_log_buy` VALUES ('9', '2018-12-27 11:06:03', null, '15000000032', '1', '136', '16', '120', '1');
INSERT INTO `t_log_buy` VALUES ('10', '2018-12-27 11:06:03', null, '15000000062', '1', '113', '16', '97', '1');
INSERT INTO `t_log_buy` VALUES ('11', '2018-12-27 11:06:03', null, '15000000091', '1', '66', '24', '42', '1');
INSERT INTO `t_log_buy` VALUES ('12', '2018-12-27 11:06:03', null, '15000000013', '1', '12', '2', '10', '1');
INSERT INTO `t_log_buy` VALUES ('13', '2018-12-27 11:06:03', null, '15000000073', '1', '33', '21', '12', '1');
INSERT INTO `t_log_buy` VALUES ('14', '2018-12-27 11:06:03', null, '15000000030', '1', '10', '5', '5', '1');
INSERT INTO `t_log_buy` VALUES ('15', '2018-12-27 11:06:03', null, '15000000018', '1', '5', '3', '2', '1');
INSERT INTO `t_log_buy` VALUES ('16', '2018-12-27 11:06:03', null, '15000000040', '1', '2', '2', '0', '1');

-- ----------------------------
-- Table structure for t_log_sms
-- ----------------------------
DROP TABLE IF EXISTS `t_log_sms`;
CREATE TABLE `t_log_sms` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `update_time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `type` int(11) DEFAULT NULL,
  `phone` varchar(255) DEFAULT NULL,
  `content` varchar(255) DEFAULT NULL,
  `response` varchar(255) DEFAULT NULL,
  `resp_code` varchar(255) DEFAULT NULL,
  `resp_msg` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_log_sms
-- ----------------------------
INSERT INTO `t_log_sms` VALUES ('1', null, null, '1', '15855120914', '您的验证码是：096070', '{\"code\":\"0\",\"msgId\":\"18122514344123403\",\"time\":\"20181225143441\",\"errorMsg\":\"\"}', '0', '');
INSERT INTO `t_log_sms` VALUES ('2', null, null, '1', '15855120914', '您的验证码是：816298', '{\"code\":\"0\",\"msgId\":\"18122514344123403\",\"time\":\"20181225143441\",\"errorMsg\":\"\"}', '0', '');
INSERT INTO `t_log_sms` VALUES ('3', null, null, '1', '15855120914', '您的验证码是：754385', '{\"code\":\"0\",\"msgId\":\"18122514344123403\",\"time\":\"20181225143441\",\"errorMsg\":\"\"}', '0', '');
INSERT INTO `t_log_sms` VALUES ('4', null, null, '1', '15855120914', '您的验证码是：722529', '{\"code\":\"0\",\"msgId\":\"18122514344123403\",\"time\":\"20181225143441\",\"errorMsg\":\"\"}', '0', '');
INSERT INTO `t_log_sms` VALUES ('5', '2018-12-25 18:59:48', null, '1', '15855120914', '您的验证码是：444491', '{\"code\":\"0\",\"msgId\":\"18122514344123403\",\"time\":\"20181225143441\",\"errorMsg\":\"\"}', '0', '');
INSERT INTO `t_log_sms` VALUES ('6', '2018-12-26 09:52:49', null, '1', '15855120914', '您的验证码是：237758', '{\"code\":\"0\",\"msgId\":\"18122514344123403\",\"time\":\"20181225143441\",\"errorMsg\":\"\"}', '0', '');

-- ----------------------------
-- Table structure for t_product
-- ----------------------------
DROP TABLE IF EXISTS `t_product`;
CREATE TABLE `t_product` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `update_time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `count` int(11) DEFAULT NULL,
  `buy_count` int(11) DEFAULT NULL,
  `no_buy_count` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_product
-- ----------------------------
INSERT INTO `t_product` VALUES ('1', '2018-12-26 10:13:00', '2018-12-27 11:06:03', '200', '200', '0');
