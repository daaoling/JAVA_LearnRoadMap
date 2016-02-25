/*
Navicat MySQL Data Transfer

Source Server         : local
Source Server Version : 50169
Source Host           : 192.168.1.170:3306
Source Database       : MANUAL

Target Server Type    : MYSQL
Target Server Version : 50169
File Encoding         : 65001

Date: 2014-09-19 09:36:20
*/

SET FOREIGN_KEY_CHECKS=0;
-- ----------------------------
-- Table structure for `ACCOUNT`
-- ----------------------------
DROP TABLE IF EXISTS `ACCOUNT`;
CREATE TABLE `ACCOUNT` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_name` varchar(16) COLLATE utf8_bin NOT NULL COMMENT '帐号',
  `pass_word` varchar(32) COLLATE utf8_bin NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=7 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;


DROP TABLE IF EXISTS `PLAYER`;
CREATE TABLE `PLAYER` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键，唯一，作为角色唯一识别码',
  `acc_id` int(11) NOT NULL COMMENT '对应的帐号ID，用于角色与帐号之间的绑定关系确认',
  `name` varchar(255) COLLATE utf8_bin NOT NULL COMMENT '角色名称',
  `job` int(11) NOT NULL COMMENT '角色职业',
  `level` int(11) NOT NULL COMMENT '角色等级',
  `map` int(11) NOT NULL COMMENT '角色所在地图',
  `x` float NOT NULL COMMENT '角色所在坐标X',
  `y` float NOT NULL COMMENT '角色所在坐标Y',
  `z` float NOT NULL COMMENT '角色所在坐标z',
  `exp` int(11) NOT NULL COMMENT '角色当前经验',
  `atk` int(11) NOT NULL COMMENT '角色当前基础攻击力',
  `def` int(11) NOT NULL COMMENT '角色当前基础防御力',
  `hp` int(11) NOT NULL COMMENT '角色当前血量',
  `hp_max` int(11) NOT NULL COMMENT '角色基础血量上限',
  `mp` int(11) NOT NULL COMMENT '角色当前魔法值',
  `mp_max` int(11) NOT NULL COMMENT '角色基础魔法值上限',
  `money` int(11) NOT NULL COMMENT '角色拥有金币',
  `equipment` varbinary(255) NOT NULL COMMENT '角色穿戴装备',
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=13 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
