DROP TABLE IF EXISTS `tstd_activity`;
CREATE TABLE `tstd_activity` (
  `code` varchar(32) NOT NULL COMMENT '编号',
  `title` varchar(32) DEFAULT NULL COMMENT '标题',
  `pic` text COMMENT '缩略图',
  `adv_pic` text COMMENT '广告图',
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
  `company_code` varchar(32) DEFAULT NULL COMMENT '公司编号',
  `system_code` varchar(32) DEFAULT NULL COMMENT '系统编号',
  PRIMARY KEY (`code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `tstd_activity_order`;
CREATE TABLE `tstd_activity_order` (
  `code` varchar(32) NOT NULL COMMENT '编号',
  `activity_code` varchar(32) DEFAULT NULL COMMENT '活动编号',
  `activity_title` varchar(255) DEFAULT NULL COMMENT '活动名称',
  `quantity` int(11) DEFAULT NULL COMMENT '报名人数',
  `price` bigint(11) DEFAULT NULL COMMENT '单价',
  `amount` bigint(11) DEFAULT NULL COMMENT '订单总额',
  `status` varchar(4) DEFAULT NULL COMMENT '状态',
  `pay_type` varchar(32) DEFAULT NULL COMMENT '支付方式',
  `pay_group` varchar(32) DEFAULT NULL COMMENT '支付组号',
  `pay_code` varchar(32) DEFAULT NULL COMMENT '支付编号',
  `pay_amount` bigint(11) DEFAULT NULL COMMENT '支付金额',
  `penalty` bigint(11) DEFAULT NULL COMMENT '违约金额',
  `pay_datetime` datetime DEFAULT NULL COMMENT '支付时间',
  `apply_user` varchar(32) DEFAULT NULL COMMENT '申请人',
  `mobile` varchar(32) DEFAULT NULL COMMENT '联系方式',
  `apply_datetime` datetime DEFAULT NULL COMMENT '下单时间',
  `updater` varchar(32) DEFAULT NULL COMMENT '更新人',
  `update_datetime` datetime DEFAULT NULL COMMENT '更新时间',
  `remark` text COMMENT '备注',
  `company_code` varchar(32) DEFAULT NULL COMMENT '公司编号',
  `system_code` varchar(32) DEFAULT NULL COMMENT '系统编号',
  PRIMARY KEY (`code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `tstd_comment` (
  `code` varchar(32) NOT NULL COMMENT '编号',
  `type` varchar(32) DEFAULT NULL COMMENT '类型',
  `score` int(11) DEFAULT NULL COMMENT '评星分数',
  `content` text COMMENT '评论内容',
  `status` varchar(4) DEFAULT NULL COMMENT '状态',
  `commenter` varchar(32) DEFAULT NULL COMMENT '评论人',
  `commenter_name` varchar(32) DEFAULT NULL COMMENT '评论人名称',
  `comment_datetime` datetime DEFAULT NULL COMMENT '评论时间',
  `approver` varchar(32) DEFAULT NULL COMMENT '审核人',
  `approve_datetime` datetime DEFAULT NULL COMMENT '审核时间',
  `remark` text COMMENT '备注',
  `parent_code` varchar(32) DEFAULT NULL COMMENT '父类编号',
  `order_code` varchar(32) DEFAULT NULL COMMENT '订单编号',
  `entity_code` varchar(32) DEFAULT NULL COMMENT '实体编号',
  `entity_name` varchar(32) DEFAULT NULL COMMENT '实体名称',
  `company_code` varchar(32) DEFAULT NULL COMMENT '公司编号',
  `system_code` varchar(32) DEFAULT NULL COMMENT '系统编号',
  PRIMARY KEY (`code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

DROP TABLE IF EXISTS `tstd_coupon`;
CREATE TABLE `tstd_coupon` (
  `code` varchar(32) NOT NULL COMMENT '编号',
  `to_user` varchar(32) NOT NULL COMMENT '归属人',
  `par_value` int(11) NOT NULL COMMENT '面值',
  `start_datetime` datetime NOT NULL COMMENT '开始时间',
  `end_datetime` datetime NOT NULL COMMENT '结束时间',
  `use_range` varchar(32) NOT NULL COMMENT '使用范围',
  `status` varchar(4) DEFAULT NULL COMMENT '状态',
  `releaser` varchar(32) NOT NULL COMMENT '发放人',
  `release_datetime` datetime NOT NULL COMMENT '发放时间',
  `updater` varchar(32) DEFAULT NULL COMMENT '更新人',
  `update_datetime` datetime DEFAULT NULL COMMENT '更新时间',
  `remark` text COMMENT '备注',
  `company_code` varchar(32) DEFAULT NULL COMMENT '公司编号',
  `system_code` varchar(32) DEFAULT NULL COMMENT '系统编号',
  PRIMARY KEY (`code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `tstd_currency_activity`;
CREATE TABLE `tstd_currency_activity` (
  `code` varchar(32) NOT NULL COMMENT '编号',
  `type` varchar(32) NOT NULL COMMENT '类型',
  `description` text NOT NULL COMMENT '图文描述',
  `start_datetime` datetime NOT NULL COMMENT '开始时间',
  `end_datetime` datetime NOT NULL COMMENT '结束时间',
  `currency` varchar(32) NOT NULL COMMENT '币种',
  `number` int(11) NOT NULL COMMENT '赠送数量',
  `location` varchar(32) DEFAULT NULL COMMENT 'ui位置',
  `order_no` int(11) DEFAULT NULL COMMENT 'ui顺序',
  `status` varchar(4) DEFAULT NULL COMMENT '状态',
  `updater` varchar(32) DEFAULT NULL COMMENT '更新人',
  `update_datetime` datetime DEFAULT NULL COMMENT '更新时间',
  `remark` text COMMENT '备注',
  `company_code` varchar(32) DEFAULT NULL COMMENT '公司编号',
  `system_code` varchar(32) DEFAULT NULL COMMENT '系统编号',
  PRIMARY KEY (`code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `tstd_interact`;
CREATE TABLE `tstd_interact` (
  `code` varchar(32) NOT NULL COMMENT '编号',
  `category` varchar(32) DEFAULT NULL COMMENT '实体类型（商品/资讯）',
  `type` varchar(4) DEFAULT NULL COMMENT '类型(1 点赞 2 收藏 3 浏览)',
  `entity_code` varchar(32) DEFAULT NULL COMMENT '实体编号',
  `interacter` varchar(32) DEFAULT NULL COMMENT '交互人',
  `interact_datetime` datetime DEFAULT NULL COMMENT '交互时间',
  `refereer` varchar(32) DEFAULT NULL COMMENT '推荐人',
  `company_code` varchar(32) DEFAULT NULL COMMENT '公司编号',
  `system_code` varchar(32) DEFAULT NULL COMMENT '系统编号',
  PRIMARY KEY (`code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

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
  `company_code` varchar(32) DEFAULT NULL COMMENT '公司编号',
  `system_code` varchar(32) DEFAULT NULL COMMENT '系统编号',
  PRIMARY KEY (`code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `tstd_news`;
CREATE TABLE `tstd_news` (
  `code` varchar(32) NOT NULL COMMENT '编号',
  `type` varchar(4) DEFAULT NULL COMMENT '类别',
  `title` varchar(255) DEFAULT NULL COMMENT '标题',
  `keywords` varchar(255) DEFAULT NULL,
  `adv_pic` varchar(255) DEFAULT NULL COMMENT '广告图',
  `pic` varchar(255) DEFAULT NULL COMMENT '图片url',
  `content` text COMMENT '内容',
  `scan_num` int(11) DEFAULT NULL COMMENT '浏览数',
  `comment_num` int(11) DEFAULT NULL COMMENT '评论数',
  `location` varchar(4) DEFAULT NULL COMMENT 'UI位置',
  `order_no` int(11) DEFAULT NULL COMMENT '序号',
  `status` varchar(4) DEFAULT NULL COMMENT '状态(0 未发布 1已发布 2 已下架)',
  `updater` varchar(32) DEFAULT NULL COMMENT '更新人',
  `update_datetime` datetime DEFAULT NULL COMMENT '更新时间',
  `remark` varchar(255) DEFAULT NULL COMMENT '备注',
  `company_code` varchar(32) DEFAULT NULL COMMENT '公司编号',
  `system_code` varchar(32) DEFAULT NULL COMMENT '系统编号',
  PRIMARY KEY (`code`) COMMENT '新闻资讯'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `tstd_publicity`;
CREATE TABLE `tstd_publicity` (
  `code` varchar(32) NOT NULL COMMENT '编号',
  `type` varchar(32) NOT NULL COMMENT '类型',
  `adv_pic` text COMMENT '图片',
  `description` text NOT NULL COMMENT '图文描述',
  `start_datetime` datetime NOT NULL COMMENT '开始时间',
  `end_datetime` datetime NOT NULL COMMENT '结束时间',
  `value1` decimal(18,4) NOT NULL COMMENT 'value1',
  `value2` decimal(18,4) NOT NULL COMMENT 'value2',
  `value3` decimal(18,4) NOT NULL COMMENT 'value3',
  `location` varchar(32) DEFAULT NULL COMMENT 'ui位置',
  `order_no` int(11) DEFAULT NULL COMMENT 'ui顺序',
  `status` varchar(4) DEFAULT NULL COMMENT '状态',
  `updater` varchar(32) DEFAULT NULL COMMENT '更新人',
  `update_datetime` datetime DEFAULT NULL COMMENT '更新时间',
  `remark` text COMMENT '备注',
  `company_code` varchar(32) DEFAULT NULL COMMENT '公司编号',
  `system_code` varchar(32) DEFAULT NULL COMMENT '系统编号',
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
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

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
  `company_code` varchar(32) DEFAULT NULL COMMENT '公司编号',
  `system_code` varchar(32) DEFAULT NULL COMMENT '系统编号',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=0 DEFAULT CHARSET=utf8;


DROP TABLE IF EXISTS `tstd_caigopool`;
CREATE TABLE `tstd_caigopool` (
  `code` varchar(32) NOT NULL COMMENT '编号',
  `activity_code` varchar(32) DEFAULT NULL COMMENT '活动编号',

  `amount` bigint(20) DEFAULT NULL COMMENT '余额',
  `used_amount` bigint(20) DEFAULT NULL COMMENT '被使用的金额',
  `add_user` varchar(32) DEFAULT NULL COMMENT '最后入金人',
  `add_datetime` datetime DEFAULT NULL COMMENT '最后入金时间',
  `remark` varchar(255) DEFAULT NULL COMMENT '备注',
  
  `company_code` varchar(32) DEFAULT NULL COMMENT '公司编号',
  `system_code` varchar(32) DEFAULT NULL COMMENT '系统编号',
  PRIMARY KEY (`code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


DROP TABLE IF EXISTS `tstd_caigopool_back`;
CREATE TABLE `tstd_caigopool_back` (
  `id` bigint(32) NOT NULL AUTO_INCREMENT COMMENT '序号',
  `pool_code` varchar(32) DEFAULT NULL COMMENT '对应池编号',
  `activity_code` varchar(32) DEFAULT NULL COMMENT '活动编号',
  
  `to_amount` bigint(20) DEFAULT NULL COMMENT '我方系统的金额',
  `to_currency` varchar(32) DEFAULT NULL COMMENT '我方系统的币种',
  `to_user` varchar(32) DEFAULT NULL COMMENT '我方系统的用户（手机号）',

  `create_datetime` datetime DEFAULT NULL COMMENT '创建时间',
  `remark` varchar(255) DEFAULT NULL COMMENT '备注',
  `company_code` varchar(32) DEFAULT NULL COMMENT '公司编号',
  `system_code` varchar(32) DEFAULT NULL COMMENT '系统编号',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;