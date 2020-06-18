# museum
文物管理系统
数据库如下：
/*
 Navicat Premium Data Transfer

 Source Server         : zby
 Source Server Type    : MySQL
 Source Server Version : 50716
 Source Host           : localhost:3306
 Source Schema         : group3

 Target Server Type    : MySQL
 Target Server Version : 50716
 File Encoding         : 65001

 Date: 08/06/2020 16:05:55
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for borrow
-- ----------------------------
DROP TABLE IF EXISTS `borrow`;
CREATE TABLE `borrow`  (
  `borrowId` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '借出主键',
  `culturalRelicId` bigint(20) NOT NULL COMMENT '文物编号',
  `toWho` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '外借名称',
  `borrowTime` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '借出时间',
  PRIMARY KEY (`borrowId`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 13 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '外借登记表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of borrow
-- ----------------------------
INSERT INTO `borrow` VALUES (12, 1, '测试测试', '2020/06/04 10:24:49');

-- ----------------------------
-- Table structure for cultural_relic
-- ----------------------------
DROP TABLE IF EXISTS `cultural_relic`;
CREATE TABLE `cultural_relic`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `name` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '名称',
  `number` bigint(20) NULL DEFAULT 0 COMMENT '数量',
  `material` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '材质',
  `age` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '年代',
  `title` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '年号',
  `source` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '来源',
  `size` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '尺寸',
  `price` bigint(50) NULL DEFAULT NULL COMMENT '价值',
  `image` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '图片地址',
  `wareHouse` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '仓库',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 21 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '文物表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of cultural_relic
-- ----------------------------
INSERT INTO `cultural_relic` VALUES (1, '秘色瓷莲花碗', 2, '碗', '夏', NULL, '软件A班捐赠', '30x20x10', 9789769, 'cultural1.png', '金銮殿');
INSERT INTO `cultural_relic` VALUES (2, '贴金彩绘石雕菩萨', 1, '石雕', '商', NULL, '软件B班捐赠', '10*10', 70000000000, 'cultural2.png', '金銮殿');
INSERT INTO `cultural_relic` VALUES (3, '玄秘塔碑', 1, '石刻', '西周', NULL, '软件C班捐赠', '10*10', 9000000000, 'cultural3.png', '1号仓库');
INSERT INTO `cultural_relic` VALUES (4, '千里江山图', 1, '画卷', '东周', NULL, '软件D班捐赠', '10*10', 50000, 'cultural4.png', '2号仓库');
INSERT INTO `cultural_relic` VALUES (5, '官窑渣斗', 1, '渣斗', '春秋', NULL, '海外华侨捐赠', '10*10', 8000000, 'cultural5.png', '3号仓库');
INSERT INTO `cultural_relic` VALUES (6, '仿哥窑鼠耳簋式炉', 3, '炉', '战国', NULL, '中山市博物馆', '10*10', 50000, 'cultural6.png', '1号仓库');
INSERT INTO `cultural_relic` VALUES (9, '式', 9, '炉', '9', '', '中山市博物馆', '9*9', 9, 'cultural9.png', '1号仓库');
INSERT INTO `cultural_relic` VALUES (10, '测试', 1000, '测试', '测试', NULL, '阿萨德', '按时', 56457262, '', '珍宝馆');

-- ----------------------------
-- Table structure for in_library
-- ----------------------------
DROP TABLE IF EXISTS `in_library`;
CREATE TABLE `in_library`  (
  `id` bigint(20) NOT NULL COMMENT '编号',
  `is_leave` char(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '0' COMMENT '0->未离馆，1->离馆',
  `is_borrow` char(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '0' COMMENT '0->未外借，1->外借',
  `is_exhibition` char(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '0' COMMENT '0->未展览，1->展览',
  `is_repair` char(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '0' COMMENT '0->未送修，1->送修',
  `storage_time` datetime(0) NOT NULL COMMENT '收储时间',
  `storage_warehouse` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '收储仓库',
  `storage_rack` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '收储货架',
  `leave_time` datetime(0) NULL DEFAULT NULL COMMENT '离馆时间',
  `init_value` bigint(20) NOT NULL COMMENT '入馆价值',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '入馆登记表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of in_library
-- ----------------------------
INSERT INTO `in_library` VALUES (1, '0', '0', '0', '0', '2020-01-01 13:27:29', '珍宝馆', '展柜101', NULL, 500000000);
INSERT INTO `in_library` VALUES (2, '0', '1', '0', '0', '2020-01-02 13:28:49', '金銮殿', '展柜11', NULL, 70000000000);
INSERT INTO `in_library` VALUES (3, '0', '0', '0', '1', '2020-01-03 13:29:33', '1号仓库', '1号架', NULL, 9000000000);
INSERT INTO `in_library` VALUES (4, '1', '0', '0', '0', '2020-01-04 13:30:33', '2号仓库', NULL, NULL, 50000);
INSERT INTO `in_library` VALUES (5, '0', '0', '1', '0', '2020-01-05 13:31:18', '3号仓库', NULL, NULL, 8000000);
INSERT INTO `in_library` VALUES (6, '0', '0', '0', '0', '2020-01-06 13:41:31', '4号仓库', NULL, NULL, 50000);

-- ----------------------------
-- Table structure for out_library
-- ----------------------------
DROP TABLE IF EXISTS `out_library`;
CREATE TABLE `out_library`  (
  `culturalRelicId` bigint(20) NOT NULL COMMENT '文物编号',
  `toWhere` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '离馆去处',
  `outTime` datetime(0) NULL DEFAULT NULL COMMENT '出馆时间',
  PRIMARY KEY (`culturalRelicId`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '离馆登记表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of out_library
-- ----------------------------
INSERT INTO `out_library` VALUES (4, '商人A', NULL);

-- ----------------------------
-- Table structure for repair
-- ----------------------------
DROP TABLE IF EXISTS `repair`;
CREATE TABLE `repair`  (
  `culturalRelicId` bigint(20) NOT NULL COMMENT '文物编号',
  `repairTime` datetime(0) NOT NULL COMMENT '送修时间',
  `repairWith` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '送修方',
  PRIMARY KEY (`culturalRelicId`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '送修表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of repair
-- ----------------------------
INSERT INTO `repair` VALUES (3, '2020-01-04 14:00:32', '文物修理厂');

-- ----------------------------
-- Table structure for returnform
-- ----------------------------
DROP TABLE IF EXISTS `returnform`;
CREATE TABLE `returnform`  (
  `returnId` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '归还主键',
  `culturalRelicId` bigint(20) NOT NULL COMMENT '文物编号',
  `forWho` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '外借单位',
  `returnTime` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '归还时间',
  `borrowTime` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '借出时间',
  PRIMARY KEY (`returnId`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 25 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '外借登记表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of returnform
-- ----------------------------
INSERT INTO `returnform` VALUES (19, 2, '中山市博物馆', '2020/06/02 23:29:59', '2020/06/02 23:29:36');
INSERT INTO `returnform` VALUES (21, 4, '中山市博物馆', '2020/06/04 00:21:41', '2020/06/02 23:43:13');
INSERT INTO `returnform` VALUES (22, 1, '中山市博物馆', '2020/06/04 10:08:00', '2020/06/02 23:42:41');
INSERT INTO `returnform` VALUES (24, 1, '中山市博物馆', '2020/06/04 10:18:09', '2020/06/04 10:18:04');

-- ----------------------------
-- Table structure for staff
-- ----------------------------
DROP TABLE IF EXISTS `staff`;
CREATE TABLE `staff`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '工号',
  `name` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '姓名',
  `officer` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '职位',
  `number` bigint(20) NOT NULL DEFAULT 1001 COMMENT '登录账号',
  `password` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '123' COMMENT '登录密码',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 12 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '员工表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of staff
-- ----------------------------
INSERT INTO `staff` VALUES (1, '梁老师', '馆长', 1000, '123');
INSERT INTO `staff` VALUES (2, '刘一', '文职人员', 1001, '123');
INSERT INTO `staff` VALUES (3, '陈二', '文职人员', 1002, '123');
INSERT INTO `staff` VALUES (4, '张三', '文职人员', 1003, '123');
INSERT INTO `staff` VALUES (5, '李四', '仓库管理员', 1004, '123');
INSERT INTO `staff` VALUES (6, '王五', '仓库管理员', 1005, '123');
INSERT INTO `staff` VALUES (7, '赵六', '仓库管理员', 1006, '123');
INSERT INTO `staff` VALUES (9, '周八', '资产科人员', 1008, '123');
INSERT INTO `staff` VALUES (10, '吴九', '资产科人员', 1009, '123');

-- ----------------------------
-- Table structure for status
-- ----------------------------
DROP TABLE IF EXISTS `status`;
CREATE TABLE `status`  (
  `id` int(2) NOT NULL COMMENT 'id',
  `path` int(2) NULL DEFAULT NULL COMMENT '状态码'
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of status
-- ----------------------------
INSERT INTO `status` VALUES (1, 0);

-- ----------------------------
-- Table structure for warehouse
-- ----------------------------
DROP TABLE IF EXISTS `warehouse`;
CREATE TABLE `warehouse`  (
  `id` int(10) NOT NULL AUTO_INCREMENT COMMENT '仓库编号',
  `warehouseName` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '仓库名称',
  `shelvesNumber` int(10) UNSIGNED NULL DEFAULT NULL COMMENT '货架数量',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 11 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '仓库表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of warehouse
-- ----------------------------
INSERT INTO `warehouse` VALUES (1, '珍宝馆', 20);
INSERT INTO `warehouse` VALUES (2, '金銮殿', 200);
INSERT INTO `warehouse` VALUES (3, '1号仓库', 10);
INSERT INTO `warehouse` VALUES (4, '2号仓库', 10);
INSERT INTO `warehouse` VALUES (5, '3号仓库', 10);
INSERT INTO `warehouse` VALUES (6, '4号仓库', 10);
INSERT INTO `warehouse` VALUES (7, '5号仓库', 10);
INSERT INTO `warehouse` VALUES (8, '6号仓库', 20);

SET FOREIGN_KEY_CHECKS = 1;
