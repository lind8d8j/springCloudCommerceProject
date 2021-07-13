/*
 Navicat Premium Data Transfer

 Source Server         : springcloud
 Source Server Type    : MySQL
 Source Server Version : 50562
 Source Host           : localhost:3306
 Source Schema         : b2bgoods

 Target Server Type    : MySQL
 Target Server Version : 50562
 File Encoding         : 65001

 Date: 13/07/2021 15:46:48
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for cart
-- ----------------------------
DROP TABLE IF EXISTS `cart`;
CREATE TABLE `cart`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `goodsname` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `number` int(11) NOT NULL,
  `price` int(11) NOT NULL,
  `goodid` int(11) NOT NULL,
  `uid` int(11) NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 17 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of cart
-- ----------------------------
INSERT INTO `cart` VALUES (1, 'fg', 0, 0, 0, 0);
INSERT INTO `cart` VALUES (14, '苹果', 1, 2, 2, 10029);
INSERT INTO `cart` VALUES (15, '橙子', 1, 4, 3, 10029);
INSERT INTO `cart` VALUES (16, '带鱼', 1, 50, 6, 10029);

-- ----------------------------
-- Table structure for goods
-- ----------------------------
DROP TABLE IF EXISTS `goods`;
CREATE TABLE `goods`  (
  `gid` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `gname` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '商品名称',
  `gremain` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '商品图片地址',
  `gdetails` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '商品介绍',
  `gprice` int(11) NOT NULL COMMENT '商品价格',
  `types` int(64) NOT NULL COMMENT '商品类别',
  PRIMARY KEY (`gid`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 17 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of goods
-- ----------------------------
INSERT INTO `goods` VALUES (1, '草莓', 'http://localhost:8894/img/goods/goods003.jpg', '可口草莓', 4, 0);
INSERT INTO `goods` VALUES (2, '苹果', 'http://localhost:8894/img/2.jpg', '红富士苹果', 2, 0);
INSERT INTO `goods` VALUES (3, '橙子', 'http://localhost:8894/img/goods/goods001.jpg', '金黄的大橙子', 4, 0);
INSERT INTO `goods` VALUES (4, '葡萄', 'http://localhost:8894/img/goods/goods002.jpg', '吐鲁番葡萄', 12, 0);
INSERT INTO `goods` VALUES (5, '大虾', 'http://localhost:8894/img/goods/goods018.jpg', '山东大虾', 5, 2);
INSERT INTO `goods` VALUES (6, '带鱼', 'http://localhost:8894/img/goods/goods020.jpg', '好吃的带鱼', 50, 2);
INSERT INTO `goods` VALUES (7, '扇贝', 'http://localhost:8894/img/goods/goods019.jpg', '大神快来快来', 20, 2);
INSERT INTO `goods` VALUES (8, '皮皮虾', 'http://localhost:8894/img/goods/goods021.jpg', '啥的客户', 10, 2);
INSERT INTO `goods` VALUES (9, '脉动', 'http://localhost:8894/img/goods/maidong.png', '不在状态，脉动一下', 4, 1);
INSERT INTO `goods` VALUES (10, '汽水', 'http://localhost:8894/img/goods/qishui.png', '栓双', 8, 1);
INSERT INTO `goods` VALUES (11, '沙棘汁', 'http://localhost:8894/img/goods/shajizhi.png', '好喝', 3, 1);
INSERT INTO `goods` VALUES (12, '和其正', 'http://localhost:8894/img/goods/heqizheng.png', 'dsa asd', 5, 1);
INSERT INTO `goods` VALUES (13, '菠菜', 'http://localhost:8894/img/goods/bocai.png', '大', 2, 3);
INSERT INTO `goods` VALUES (14, '生菜', 'http://localhost:8894/img/goods/shengcai.png', 'asdajlskdja', 2, 3);
INSERT INTO `goods` VALUES (15, '番茄', 'http://localhost:8894/img/goods/fanqie.png', '好吃', 1, 3);
INSERT INTO `goods` VALUES (16, '胡萝卜', 'http://localhost:8894/img/goods/huluobo.png', 'asdkjlajkld', 2, 3);

-- ----------------------------
-- Table structure for userorder
-- ----------------------------
DROP TABLE IF EXISTS `userorder`;
CREATE TABLE `userorder`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `goodsname` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '商品名称',
  `number` int(11) NOT NULL COMMENT '购买数量',
  `price` int(11) NOT NULL COMMENT '总价',
  `time` datetime NOT NULL,
  `uid` int(11) NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 160 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of userorder
-- ----------------------------
INSERT INTO `userorder` VALUES (139, '脉动', 17, 68, '2019-10-16 11:11:45', 10023);
INSERT INTO `userorder` VALUES (140, '沙棘汁', 2, 6, '2019-10-16 11:11:45', 10023);
INSERT INTO `userorder` VALUES (152, '带鱼', 1, 50, '2021-07-12 23:15:20', 10029);
INSERT INTO `userorder` VALUES (153, '苹果', 1, 2, '2021-07-12 23:15:20', 10029);
INSERT INTO `userorder` VALUES (154, '草莓', 1, 4, '2021-07-12 23:15:20', 10029);
INSERT INTO `userorder` VALUES (155, '草莓', 7, 28, '2021-07-12 23:17:13', 10029);
INSERT INTO `userorder` VALUES (156, '苹果', 6, 12, '2021-07-12 23:17:13', 10029);
INSERT INTO `userorder` VALUES (157, '草莓', 1, 4, '2021-07-12 23:23:38', 10029);
INSERT INTO `userorder` VALUES (158, '苹果', 1, 2, '2021-07-13 00:50:32', 10029);
INSERT INTO `userorder` VALUES (159, '生菜', 5, 10, '2021-07-13 00:50:32', 10029);

SET FOREIGN_KEY_CHECKS = 1;
