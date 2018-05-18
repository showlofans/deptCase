/*
Navicat MySQL Data Transfer

Source Server         : home
Source Server Version : 50626
Source Host           : localhost:3306
Source Database       : dept_case

Target Server Type    : MYSQL
Target Server Version : 50626
File Encoding         : 65001

Date: 2018-05-18 16:50:01
*/

SET FOREIGN_KEY_CHECKS=0;
-- ----------------------------
-- Table structure for `case_contact`
-- ----------------------------
DROP TABLE IF EXISTS `case_contact`;
CREATE TABLE `case_contact` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '案件联系方式id',
  `case_id` int(11) DEFAULT NULL COMMENT '案件id',
  `case_admin` int(11) DEFAULT NULL COMMENT '案件负责人id',
  `contact` varchar(255) DEFAULT NULL COMMENT '联系方式',
  `last_access` bigint(20) DEFAULT NULL COMMENT '联系方式添加时间',
  `contact_add_user` int(11) DEFAULT NULL COMMENT '添加人id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of case_contact
-- ----------------------------

-- ----------------------------
-- Table structure for `case_log`
-- ----------------------------
DROP TABLE IF EXISTS `case_log`;
CREATE TABLE `case_log` (
  `id` bigint(20) NOT NULL DEFAULT '0',
  `log_user` int(11) DEFAULT NULL COMMENT '产生日志的用户',
  `log_event` int(11) DEFAULT NULL COMMENT '日志事件（案件导入，添加联系方式，添加通话记录）',
  `case_id` int(11) DEFAULT NULL COMMENT '案件id',
  `log_time` bigint(20) DEFAULT NULL COMMENT '日志产生时间',
  `log_key` varchar(255) DEFAULT NULL COMMENT '日志关键信息',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of case_log
-- ----------------------------

-- ----------------------------
-- Table structure for `contact_record`
-- ----------------------------
DROP TABLE IF EXISTS `contact_record`;
CREATE TABLE `contact_record` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `cc_id` bigint(20) DEFAULT NULL COMMENT '案件联系方式id',
  `case_id` int(11) DEFAULT NULL,
  `case_contact` varchar(255) DEFAULT NULL COMMENT '联系方式',
  `record_user` int(11) DEFAULT NULL,
  `record_user_name` varchar(255) DEFAULT NULL COMMENT '记录人账户名',
  `contact_record` varchar(255) DEFAULT NULL COMMENT '通话记录',
  `record_time` bigint(20) DEFAULT NULL COMMENT '记录时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of contact_record
-- ----------------------------

-- ----------------------------
-- Table structure for `dept_case`
-- ----------------------------
DROP TABLE IF EXISTS `dept_case`;
CREATE TABLE `dept_case` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '案件id',
  `dept_date` bigint(20) DEFAULT NULL COMMENT '贷款日期',
  `dept_end_date` bigint(20) DEFAULT NULL COMMENT '到期日期',
  `dept_amount` double DEFAULT NULL COMMENT '贷款金额',
  `dept_balance` double DEFAULT NULL COMMENT '贷款余额',
  `dept_profit` double DEFAULT NULL COMMENT '结欠利息',
  `dc_id` varchar(255) DEFAULT NULL COMMENT '证件号码',
  `case_org` varchar(255) DEFAULT NULL COMMENT '机构名称',
  `customer_contact` varchar(255) DEFAULT NULL COMMENT '联系电话',
  `customer_location` varchar(255) DEFAULT NULL COMMENT '客户地址',
  `case_warrantor` varchar(255) DEFAULT NULL COMMENT '保证人名称',
  `case_customer` varchar(255) DEFAULT NULL COMMENT '案件内容',
  `case_admin` int(11) DEFAULT NULL COMMENT '案件负责人',
  `last_access` bigint(20) DEFAULT NULL COMMENT '案件最后更新时间',
  `access_log` int(11) DEFAULT NULL COMMENT '案件更新内容',
  `create_time` bigint(20) DEFAULT NULL COMMENT '案件创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of dept_case
-- ----------------------------
INSERT INTO `dept_case` VALUES ('1', '1482508800000', '1482508800000', '10000', '2000', '150', '1.3699562589E10', '????', '1.36995466E8', '??', '1.36995466E8', 'xiao', '0', '1526114510880', '0', '1526114510880');
INSERT INTO `dept_case` VALUES ('2', '1482508800000', '1482508800000', '10000', '2000', '150', '13699562589', '????', '136995466', '??', '??', 'xiao', '0', '1526115436248', '0', '1526115436248');

-- ----------------------------
-- Table structure for `login_user`
-- ----------------------------
DROP TABLE IF EXISTS `login_user`;
CREATE TABLE `login_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '用户id',
  `name` varchar(255) DEFAULT NULL COMMENT '用户名',
  `pass` varchar(255) DEFAULT NULL COMMENT '登陆密码',
  `access` int(11) DEFAULT NULL COMMENT '权限（0-超管，1-一般用户）',
  `root_flag` varchar(255) DEFAULT NULL COMMENT '父级代理商标志（邀请码）',
  `create_time` bigint(20) DEFAULT NULL COMMENT '创建用户时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of login_user
-- ----------------------------

-- ----------------------------
-- Table structure for `system_params`
-- ----------------------------
DROP TABLE IF EXISTS `system_params`;
CREATE TABLE `system_params` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `key` varchar(255) DEFAULT NULL COMMENT '英文键',
  `value` varchar(255) DEFAULT NULL COMMENT '值',
  `desc` varchar(255) DEFAULT NULL COMMENT '描述',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of system_params
-- ----------------------------
