CREATE TABLE `acitivity_push_tag`
(
    `id`                  bigint(20) NOT NULL AUTO_INCREMENT,
    `behavior_feature`    varchar(500) NOT NULL COMMENT '行为特征',
    `consumption_feature` varchar(500) NOT NULL COMMENT '消费特征',
    `interest_feature`    varchar(500) NOT NULL COMMENT '兴趣偏好',
    `mental_feature`      varchar(500) NOT NULL COMMENT '心理特征',
    `basic_info`          varchar(500) NOT NULL COMMENT '基本信息',
    `registration_info`   varchar(500) NOT NULL COMMENT '注册信息',
    `authority_info`      varchar(500) NOT NULL COMMENT '权限信息',
    `user_customization`  varchar(500) NOT NULL COMMENT '用户定制信息',
    PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;