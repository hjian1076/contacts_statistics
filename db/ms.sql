/*
Navicat MySQL Data Transfer

Source Server         : 192.168.2.22
Source Server Version : 50528
Source Host           : 192.168.2.22:3306
Source Database       : ms

Target Server Type    : MYSQL
Target Server Version : 50528
File Encoding         : 65001

Date: 2018-05-23 18:32:34
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
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of tb_page_res
-- ----------------------------
INSERT INTO `tb_page_res` VALUES ('4', '信息统计', '1', '/admin/statisticsUser/statisticsList', '0', '1');
INSERT INTO `tb_page_res` VALUES ('5', '修改密码', '1', '/admin/user/updatePwdPage', '0', '2');
INSERT INTO `tb_page_res` VALUES ('6', '平台列表', '1', '/admin/platform/platformList', '0', '2');
INSERT INTO `tb_page_res` VALUES ('7', '广告位管理', '1', '/admin/adSpace/adSpaceList', '0', '1');

-- ----------------------------
-- Table structure for `tb_platform_config`
-- ----------------------------
DROP TABLE IF EXISTS `tb_platform_config`;
CREATE TABLE `tb_platform_config` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `platform_name` varchar(100) DEFAULT NULL COMMENT '平台名（品牌名）',
  `website` varchar(1000) DEFAULT NULL COMMENT '官网地址',
  `create_time` datetime DEFAULT NULL,
  `image` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of tb_platform_config
-- ----------------------------
INSERT INTO `tb_platform_config` VALUES ('8', '测试1', 'http://www.baidu.com', '2018-05-07 17:25:04', null);
INSERT INTO `tb_platform_config` VALUES ('9', '测试2', 'http://www.hao123.com', '2018-05-07 17:27:51', null);
INSERT INTO `tb_platform_config` VALUES ('11', '测试5', 'http://www.youku.com', '2018-05-23 18:31:52', '/images/platform/1527071497176448.jpg');

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
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of tb_statistics_user
-- ----------------------------
INSERT INTO `tb_statistics_user` VALUES ('13', 'will', '13986584656', '重庆江北区大石坝镇', '2018-05-08 09:39:52', '8');

-- ----------------------------
-- Table structure for `tb_user`
-- ----------------------------
DROP TABLE IF EXISTS `tb_user`;
CREATE TABLE `tb_user` (
  `id` bigint(36) NOT NULL AUTO_INCREMENT,
  `username` varchar(20) DEFAULT NULL,
  `password` varchar(50) NOT NULL,
  `create_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of tb_user
-- ----------------------------
INSERT INTO `tb_user` VALUES ('1', 'admin', 'Z++2G7Kq7fd3TUgNlFzQyw==', '2018-04-23 17:50:52');
