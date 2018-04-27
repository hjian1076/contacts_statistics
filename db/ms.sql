/*
Navicat MySQL Data Transfer

Source Server         : 192.168.2.22
Source Server Version : 50528
Source Host           : 192.168.2.22:3306
Source Database       : ms

Target Server Type    : MYSQL
Target Server Version : 50528
File Encoding         : 65001

Date: 2018-04-27 19:24:12
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `tb_page_res`
-- ----------------------------
DROP TABLE IF EXISTS `tb_page_res`;
CREATE TABLE `tb_page_res` (
  `id` int(36) NOT NULL AUTO_INCREMENT,
  `res_name` varchar(50) NOT NULL,
  `res_type` int(1) NOT NULL,
  `res_url` varchar(255) DEFAULT NULL,
  `show_menu` int(1) DEFAULT NULL,
  `parent_res_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of tb_page_res
-- ----------------------------
INSERT INTO `tb_page_res` VALUES ('1', '信息管理', '0', '', '0', '0');
INSERT INTO `tb_page_res` VALUES ('2', '系统设置', '0', '', '0', '0');
INSERT INTO `tb_page_res` VALUES ('4', '信息统计', '1', '/admin/statisticsUser/statisticsList', '0', '1');
INSERT INTO `tb_page_res` VALUES ('5', '修改密码', '1', '/admin/user/updatePwdPage', '0', '2');
INSERT INTO `tb_page_res` VALUES ('6', '平台列表', '1', '/admin/platform/platformList', '0', '2');

-- ----------------------------
-- Table structure for `tb_platform_config`
-- ----------------------------
DROP TABLE IF EXISTS `tb_platform_config`;
CREATE TABLE `tb_platform_config` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `platform_name` varchar(100) DEFAULT NULL COMMENT '平台名（品牌名）',
  `website` varchar(1000) DEFAULT NULL COMMENT '官网地址',
  `create_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of tb_platform_config
-- ----------------------------
INSERT INTO `tb_platform_config` VALUES ('5', '测试1', 'http://www.baidu.com', '2018-04-27 16:53:01');
INSERT INTO `tb_platform_config` VALUES ('6', '测试2', 'http://www.taobao.com', '2018-04-27 16:53:36');
INSERT INTO `tb_platform_config` VALUES ('7', '测试3', 'http://www.hao123.com', '2018-04-27 16:53:58');

-- ----------------------------
-- Table structure for `tb_statistics_user`
-- ----------------------------
DROP TABLE IF EXISTS `tb_statistics_user`;
CREATE TABLE `tb_statistics_user` (
  `id` int(36) NOT NULL AUTO_INCREMENT,
  `person` varchar(20) NOT NULL,
  `iphone` varchar(11) NOT NULL,
  `address` varchar(50) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `pf_id` int(11) NOT NULL,
  `birth_date` datetime NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of tb_statistics_user
-- ----------------------------
INSERT INTO `tb_statistics_user` VALUES ('1', '测试', '15213425633', '重庆市江北区', '2018-04-26 19:34:30', '1', '2018-04-27 00:00:00');
INSERT INTO `tb_statistics_user` VALUES ('2', '测试名字2', '15213425633', '重庆市沙坪坝区', '2018-04-02 19:51:20', '1', '2018-04-20 00:00:00');
INSERT INTO `tb_statistics_user` VALUES ('3', '测试人1', '13465865456', '11111', '2018-04-27 17:30:21', '7', '2018-04-09 00:00:00');
INSERT INTO `tb_statistics_user` VALUES ('4', '测试人2', '13976485236', '重庆市大渡口区', '2018-04-27 17:32:55', '7', '1992-06-25 00:00:00');
INSERT INTO `tb_statistics_user` VALUES ('5', '测试人1', '13464973193', '5555665', '2018-04-27 17:35:20', '6', '2018-04-20 00:00:00');
INSERT INTO `tb_statistics_user` VALUES ('6', '测试人5', '13976497664', '144444', '2018-04-27 17:37:24', '5', '2018-04-19 00:00:00');
INSERT INTO `tb_statistics_user` VALUES ('7', '测试人6', '13464975497', '555555', '2018-04-27 17:44:25', '5', '2018-04-20 00:00:00');

-- ----------------------------
-- Table structure for `tb_user`
-- ----------------------------
DROP TABLE IF EXISTS `tb_user`;
CREATE TABLE `tb_user` (
  `id` bigint(36) NOT NULL AUTO_INCREMENT,
  `username` varchar(20) DEFAULT NULL,
  `password` varchar(50) NOT NULL,
  `creat_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of tb_user
-- ----------------------------
INSERT INTO `tb_user` VALUES ('1', 'admin', 'Z++2G7Kq7fd3TUgNlFzQyw==', '2018-04-23 17:50:52');
