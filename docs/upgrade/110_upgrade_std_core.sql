INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('1','order_status','94','用户删除','admin',now(),'','CD-CHW000015','CD-CHW000015');

INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('1','rorder_status','94','用户删除','admin',now(),'','CD-CHW000015','CD-CHW000015');

INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('1','product_status','9','已回收','admin',now(),'','CD-CHW000015','CD-CHW000015');

INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('1','rent_prod_status','9','已回收','admin',now(),'','CD-CHW000015','CD-CHW000015');

-- ----------------------------
--  Table structure for `tstd_travels`
-- ----------------------------
DROP TABLE IF EXISTS `tstd_travels`;
CREATE TABLE `tstd_travels` (
  `code` varchar(32) NOT NULL COMMENT '编号',
  `title` varchar(255) DEFAULT NULL COMMENT '标题',
  `description` text COMMENT '文字描述',
  `pic` text COMMENT '图片描述',
  `location` varchar(4) DEFAULT NULL COMMENT 'UI位置',
  
  `order_no` int(11) DEFAULT NULL COMMENT 'UI序号',
  `collection_times` int(11) DEFAULT NULL COMMENT '收藏次数',
  `like_times` int(11) DEFAULT NULL COMMENT '点赞次数',
  `ds_times` int(11) DEFAULT NULL COMMENT '打赏次数',
  `status` varchar(4) DEFAULT NULL COMMENT '状态',
  
  `publisher` varchar(32) DEFAULT NULL COMMENT '发布人',
  `publish_datetime` datetime DEFAULT NULL COMMENT '发布时间',
  `updater` varchar(32) DEFAULT NULL COMMENT '平台修改人',
  `update_datetime` datetime DEFAULT NULL COMMENT '平台修改时间',
  `remark` varchar(255) DEFAULT NULL COMMENT '备注',
  `company_code` varchar(32) DEFAULT NULL COMMENT '公司编号',
  `system_code` varchar(32) DEFAULT NULL COMMENT '系统编号',
  PRIMARY KEY (`code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

ALTER TABLE `tstd_interact` 
ADD COLUMN `kind` VARCHAR(4) NULL COMMENT '种类(1 点赞 2 打赏)' AFTER `type`,
ADD COLUMN `remark` VARCHAR(32) NULL COMMENT '备注' AFTER `interact_datetime`;

