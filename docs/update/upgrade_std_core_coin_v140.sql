
DROP TABLE IF EXISTS `tstd_country`;
CREATE TABLE `tstd_country` (
  `inter_code` varchar(32) NOT NULL COMMENT '国际代码',
  `inter_name` varchar(32) DEFAULT NULL COMMENT '国际名称',
  `chinese_name` varchar(32) DEFAULT NULL COMMENT '中文名称',
  `inter_simple_code` varchar(32) DEFAULT NULL COMMENT '国际简码',
  `continent` varchar(32) DEFAULT NULL COMMENT '所属洲际',
  `order_no` int(11) DEFAULT '0' COMMENT '展示顺序',
  `status` varchar(32) DEFAULT '0' COMMENT '状态 0=不启用 1=启用',
  PRIMARY KEY (`inter_code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

UPDATE `dev_tha_std_core`.`tsys_dict` SET `dvalue`='基于ETH的token币' WHERE `parent_key`='coin_type' AND `dkey`='1';
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('1','coin_type','2','基于WAN的token币','admin',now(),'','CD-TOKEN00018','CD-TOKEN00018');

INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('0',NULL,'red_packet_status','红包状态','admin',now(),'','CD-TOKEN00018','CD-TOKEN00018');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('1','red_packet_status','0','已发布','admin',now(),'','CD-TOKEN00018','CD-TOKEN00018');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('1','red_packet_status','1','未抢完','admin',now(),'','CD-TOKEN00018','CD-TOKEN00018');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('1','red_packet_status','2','已抢完','admin',now(),'','CD-TOKEN00018','CD-TOKEN00018');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('1','red_packet_status','3','部分退回','admin',now(),'','CD-TOKEN00018','CD-TOKEN00018');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('1','red_packet_status','4','全部退回','admin',now(),'','CD-TOKEN00018','CD-TOKEN00018');

INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('0',NULL,'red_packet_type','红包类型','admin',now(),'','CD-TOKEN00018','CD-TOKEN00018');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('1','red_packet_type','0','定额红包','admin',now(),'','CD-TOKEN00018','CD-TOKEN00018');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('1','red_packet_type','1','拼手气红包','admin',now(),'','CD-TOKEN00018','CD-TOKEN00018');

INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('1','jour_biz_type_user','sendredpacket_in','抢红包','admin',now(),'','CD-TOKEN00018','CD-TOKEN00018');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('1','jour_biz_type_user','sendredpacket_out','发红包','admin',now(),'','CD-TOKEN00018','CD-TOKEN00018');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('1','jour_biz_type_user','redpacket_back','红包退回','admin',now(),'','CD-TOKEN00018','CD-TOKEN00018');


