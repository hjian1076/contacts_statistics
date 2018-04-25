/*
Navicat MySQL Data Transfer

Source Server         : 192.168.2.22
Source Server Version : 50528
Source Host           : 192.168.2.22:3306
Source Database       : ms

Target Server Type    : MYSQL
Target Server Version : 50528
File Encoding         : 65001

Date: 2018-04-25 20:39:04
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
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of tb_page_res
-- ----------------------------
INSERT INTO `tb_page_res` VALUES ('1', '信息管理', '0', '', '0', '0');
INSERT INTO `tb_page_res` VALUES ('2', '系统设置', '0', '', '0', '0');
INSERT INTO `tb_page_res` VALUES ('4', '信息统计', '1', '/admin/statisticsUser/statisticsList', '0', '1');
INSERT INTO `tb_page_res` VALUES ('5', '修改密码', '1', '/admin/user/updatePwdPage', '0', '2');

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
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of tb_platform_config
-- ----------------------------
INSERT INTO `tb_platform_config` VALUES ('1', '百度', 'http://news.baidu.com/', '2018-04-25 17:14:42');
INSERT INTO `tb_platform_config` VALUES ('2', 'CSDN', 'https://blog.csdn.net/a379850992/article/details/54288595', '2018-04-25 19:03:07');

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
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of tb_statistics_user
-- ----------------------------
INSERT INTO `tb_statistics_user` VALUES ('1', 'aaaa', '11111111111', '11111', '2018-04-24 15:51:14', '1');
INSERT INTO `tb_statistics_user` VALUES ('2', 'bbbbb', '22222222222', '22222', '2018-04-11 12:51:44', '0');
INSERT INTO `tb_statistics_user` VALUES ('3', 'ccccc', '33333333333', '33333', '2018-04-12 15:52:06', '0');
INSERT INTO `tb_statistics_user` VALUES ('4', 'ddddd', '11223344551', '21311', '2018-04-18 15:52:25', '0');
INSERT INTO `tb_statistics_user` VALUES ('5', 'qqqqq', '12121212121', '222111', '2018-04-21 15:52:46', '0');
INSERT INTO `tb_statistics_user` VALUES ('6', '221111', '12121212122', '12122', '2018-04-12 15:53:10', '0');
INSERT INTO `tb_statistics_user` VALUES ('7', '221112', '11111222221', '122122', '2018-04-12 15:53:30', '0');
INSERT INTO `tb_statistics_user` VALUES ('8', 'aswwa', '12312312312', '2122', '2018-04-13 15:53:50', '0');
INSERT INTO `tb_statistics_user` VALUES ('9', '2112', '44422244422', '121222', '2018-04-14 15:54:14', '0');
INSERT INTO `tb_statistics_user` VALUES ('10', '1212', '33333333332', '11222', '2018-04-13 15:54:29', '0');
INSERT INTO `tb_statistics_user` VALUES ('11', '12222', '22222222212', '22112', '2018-04-11 15:54:44', '0');
INSERT INTO `tb_statistics_user` VALUES ('12', '12121', 'ssss', 'saaaa', '2018-04-25 19:33:31', '1');
INSERT INTO `tb_statistics_user` VALUES ('13', '', '', '', '2018-04-25 19:58:54', '1');
INSERT INTO `tb_statistics_user` VALUES ('14', '', '', '', '2018-04-25 19:59:04', '2');
INSERT INTO `tb_statistics_user` VALUES ('15', 'dad', '', '', '2018-04-25 20:01:49', '2');
INSERT INTO `tb_statistics_user` VALUES ('16', '', 'sss', '', '2018-04-25 20:11:01', '2');
INSERT INTO `tb_statistics_user` VALUES ('17', '', '1212', '', '2018-04-25 20:12:07', '2');
INSERT INTO `tb_statistics_user` VALUES ('18', '', 'sdsd', '', '2018-04-25 20:13:47', '2');
INSERT INTO `tb_statistics_user` VALUES ('19', 'sdsd', '15213425633', 'dsadas', '2018-04-25 20:18:48', '2');
INSERT INTO `tb_statistics_user` VALUES ('20', 'sdsd', '15213425633', 'dsadas', '2018-04-25 20:21:41', '2');
INSERT INTO `tb_statistics_user` VALUES ('21', 'dsds', '15213425633', '21212313', '2018-04-25 20:22:20', '1');
INSERT INTO `tb_statistics_user` VALUES ('22', '1212', '15213425633', 'dsadsad', '2018-04-25 20:29:34', '1');

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
INSERT INTO `tb_user` VALUES ('1', 'admin', 'KMJ+vYhSQpMDHgbm6QCWqQ==', '2018-04-23 17:50:52');
