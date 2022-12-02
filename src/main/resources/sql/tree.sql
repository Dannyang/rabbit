-- ----------------------------
-- Table structure for product
-- ----------------------------
DROP TABLE IF EXISTS `product`;
CREATE TABLE `product`
(
    `id`          bigint(20) NOT NULL AUTO_INCREMENT,
    `uuid`        varchar(64)  NOT NULL,
    `name`        varchar(100) NOT NULL COMMENT '名称',
    `sort`        int(11) DEFAULT NULL COMMENT '排序',
    `parent_uuid` varchar(64)  NOT NULL DEFAULT '-1' COMMENT '父亲 无父级为-1',
    `level`       varchar(10)  NOT NULL COMMENT '产品层级',
    `create_time` datetime     NOT NULL,
    PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COMMENT='产品表';

-- ----------------------------
-- Records of product
-- ----------------------------
INSERT INTO `product`
VALUES ('1', '4dbf40d2-2af7-425c-a103-0349caaa26cf', '生产类', '1', '-1', '1', '2021-09-23 15:34:36');
INSERT INTO `product`
VALUES ('2', '3062deff-8ec7-44c4-bd4e-88fe3c7b835c', '22', '1', '4dbf40d2-2af7-425c-a103-0349caaa26cf', '2',
        '2021-09-23 15:37:20');
INSERT INTO `product`
VALUES ('3', '32afe426-9337-41c1-83e8-caf3248ba57e', '互联网信息', '2', '4dbf40d2-2af7-425c-a103-0349caaa26cf', '2',
        '2021-09-23 15:38:19');
INSERT INTO `product`
VALUES ('4', '34c5239f-db2d-4394-b367-a57f8ae6f8ff', '33', '1', '3062deff-8ec7-44c4-bd4e-88fe3c7b835c', '3',
        '2021-09-23 15:53:29');
INSERT INTO `product`
VALUES ('5', '19eedcd3-aa7f-4a2d-8182-d3f795e99b9d', '44', '1', '34c5239f-db2d-4394-b367-a57f8ae6f8ff', '4',
        '2021-09-23 15:53:56');

INSERT INTO `product` (`id`, `uuid`, `name`, `sort`, `parent_uuid`, `level`, `create_time`)
VALUES (6, 'uuid_1', '测试类_1', 1, '-1', '1', '2022-12-02 16:01:18');
INSERT INTO `product` (`id`, `uuid`, `name`, `sort`, `parent_uuid`, `level`, `create_time`)
VALUES (7, 'uuid_2', '测试类_2', 1, 'uuid_1', '2', '2022-12-02 16:01:58');
INSERT INTO `product` (`id`, `uuid`, `name`, `sort`, `parent_uuid`, `level`, `create_time`)
VALUES (8, 'uuid_3', '测试类_3', 2, 'uuid_1', '2', '2022-12-02 16:03:01');
