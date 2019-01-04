/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50642
Source Host           : localhost:3306
Source Database       : yungo

Target Server Type    : MYSQL
Target Server Version : 50642
File Encoding         : 65001

Date: 2019-01-04 15:10:59
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for t_config_task
-- ----------------------------
DROP TABLE IF EXISTS `t_config_task`;
CREATE TABLE `t_config_task` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `update_time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `code` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `clazz` varchar(255) DEFAULT NULL,
  `cron` varchar(255) DEFAULT NULL,
  `fixed_rate` int(255) DEFAULT NULL,
  `fixed_delay` int(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_config_task
-- ----------------------------
INSERT INTO `t_config_task` VALUES ('1', '2019-01-04 12:44:02', '2019-01-04 15:10:42', 'MY', '测试1', 'MyTask', null, null, '1000');
INSERT INTO `t_config_task` VALUES ('2', '2019-01-04 12:44:10', '2019-01-04 15:10:46', 'YOUR', '测试2', 'YourTask', null, null, '1000');
