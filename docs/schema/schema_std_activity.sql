DROP TABLE IF EXISTS `tstd_activity`;
CREATE TABLE `tstd_activity` (
  `code` varchar(32) NOT NULL COMMENT '编号',
  `title` varchar(32) DEFAULT NULL COMMENT '标题',
  `pic` text COMMENT '缩略图',
  `adv_pic` text COMMENT '广告图',
  `slogan` varchar(255) DEFAULT NULL COMMENT '广告语',
  `amount` bigint(11) DEFAULT NULL COMMENT '费用',
  `description` text COMMENT '图文描述',
  `hold_place` varchar(255) DEFAULT NULL COMMENT '举办地',
  `contact` varchar(32) DEFAULT NULL COMMENT '联系方式',
  `location` varchar(32) DEFAULT NULL COMMENT 'ui位置',
  `order_no` int(11) DEFAULT NULL COMMENT 'ui顺序',
  `start_datetime` datetime DEFAULT NULL COMMENT '开始时间',
  `end_datetime` datetime DEFAULT NULL COMMENT '结束时间',
  `total_num` int(11) DEFAULT NULL COMMENT '总人数',
  `remain_num` int(11) DEFAULT NULL COMMENT '剩余人数',
  `status` varchar(4) DEFAULT NULL COMMENT '状态',
  `updater` varchar(32) DEFAULT NULL COMMENT '更新人',
  `update_datetime` datetime DEFAULT NULL COMMENT '更新时间',
  `remark` text COMMENT '备注',
  PRIMARY KEY (`code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `tstd_activity_order`;
CREATE TABLE `tstd_activity_order` (
  `code` varchar(32) NOT NULL COMMENT '编号',
  `activity_code` varchar(32) DEFAULT NULL COMMENT '活动编号',
  `activity_title` varchar(255) DEFAULT NULL COMMENT '活动名称',
  `quantity` int(11) DEFAULT NULL COMMENT '数量',
  `price` bigint(11) DEFAULT NULL COMMENT '单价',
  `amount` bigint(11) DEFAULT NULL COMMENT '总金额',
  `status` varchar(4) DEFAULT NULL COMMENT '状态',
  `pay_type` varchar(32) DEFAULT NULL COMMENT '支付方式',
  `pay_group` varchar(32) DEFAULT NULL COMMENT '支付组号',
  `pay_code` varchar(32) DEFAULT NULL COMMENT '支付编号',
  `pay_amount` bigint(11) DEFAULT NULL COMMENT '支付金额',
  `penalty` bigint(11) DEFAULT NULL COMMENT '违约金额',
  `pay_datetime` datetime DEFAULT NULL COMMENT '支付时间',
  `apply_user` varchar(32) DEFAULT NULL COMMENT '申请人',
  `mobile` varchar(32) DEFAULT NULL COMMENT '手机号',
  `apply_datetime` datetime DEFAULT NULL COMMENT '申请时间',
  `apply_note` varchar(255) DEFAULT NULL COMMENT '申请备注',
  `updater` varchar(32) DEFAULT NULL COMMENT '更新人',
  `update_datetime` datetime DEFAULT NULL COMMENT '更新时间',
  `remark` text COMMENT '备注',
  PRIMARY KEY (`code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;


DROP TABLE IF EXISTS `tstd_comment`;
CREATE TABLE `tstd_comment` (
  `code` varchar(32) NOT NULL COMMENT '编号',
  `score` int(11) DEFAULT NULL COMMENT '星评分数',
  `content` text COMMENT '评论内容',
  `status` varchar(4) DEFAULT NULL COMMENT '状态',
  `commer` varchar(32) DEFAULT NULL COMMENT '评论人',
  `comment_datetime` datetime DEFAULT NULL COMMENT '评论时间',
  `approver` varchar(32) DEFAULT NULL COMMENT '审核人',
  `approve_datetime` datetime DEFAULT NULL COMMENT '审核时间',
  `remark` text COMMENT '备注',
  `parent_code` varchar(32) DEFAULT NULL COMMENT '父类编号',
  `product_code` varchar(32) DEFAULT NULL COMMENT '产品编号',
  PRIMARY KEY (`code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

DROP TABLE IF EXISTS `tstd_keyword`;
CREATE TABLE `tstd_keyword` (
  `code` varchar(32) NOT NULL COMMENT '编号',
  `word` varchar(255) DEFAULT NULL COMMENT '词语',
  `weight` int(11) DEFAULT NULL COMMENT '权重(0-1 0.5以上黑，0.5以下白)',
  `level` varchar(4) DEFAULT NULL COMMENT '作用等级',
  `reaction` varchar(4) DEFAULT NULL COMMENT '反应(1 直接拦截/2 替换**)',
  `updater` varchar(32) DEFAULT NULL COMMENT '更新人',
  `update_datetime` datetime DEFAULT NULL COMMENT '更新时间',
  `remark` varchar(255) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

DROP TABLE IF EXISTS `tstd_praise_item`;
CREATE TABLE `tstd_praise_item` (
  `code` varchar(32) NOT NULL COMMENT '编号',
  `name` varchar(32) DEFAULT NULL COMMENT '项目名称',
  `score` int(11) DEFAULT NULL COMMENT '得分',
  `comment_code` varchar(32) DEFAULT NULL COMMENT '评论编号',
  PRIMARY KEY (`code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `tsys_config`;
CREATE TABLE `tsys_config` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `type` varchar(32) DEFAULT NULL COMMENT '类型',
  `ckey` varchar(32) DEFAULT NULL COMMENT 'key值',
  `cvalue` varchar(255) DEFAULT NULL COMMENT '值',
  `updater` varchar(32) DEFAULT NULL COMMENT '更新人',
  `update_datetime` datetime DEFAULT NULL COMMENT '更新时间',
  `remark` varchar(255) DEFAULT NULL COMMENT '备注',
  `company_code` varchar(32) DEFAULT NULL COMMENT '公司编号',
  `system_code` varchar(32) DEFAULT NULL COMMENT '系统编号',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=0 DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `tsys_dict`;
CREATE TABLE `tsys_dict` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '编号（自增长）',
  `type` char(1) DEFAULT NULL COMMENT '类型（第一层/第二层）',
  `parent_key` varchar(32) DEFAULT NULL COMMENT '父key',
  `dkey` varchar(32) DEFAULT NULL COMMENT 'key',
  `dvalue` varchar(255) DEFAULT NULL COMMENT '值',
  `updater` varchar(32) DEFAULT NULL COMMENT '更新人',
  `update_datetime` datetime DEFAULT NULL COMMENT '更新时间',
  `remark` varchar(255) DEFAULT NULL COMMENT '备注',
  `system_code` varchar(32) DEFAULT NULL COMMENT '系统编号',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
