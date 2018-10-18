
INSERT INTO `tsys_config` (`type`,`ckey`,`cvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('invite_pop','invite_pop_rate','0.1','admin',now(),'默认分成比例','CD-TOKEN00018','CD-TOKEN00018');
INSERT INTO `tsys_config` (`type`,`ckey`,`cvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('invite_pop','invite_pop_days','90','admin',now(),'量化分成有效期（天）','CD-TOKEN00018','CD-TOKEN00018');

INSERT INTO `tsys_config` (`type`,`ckey`,`cvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('quantitative_finance','pop_protocol_ZH_CN','购买协议中文版','admin',now(),'购买协议（中文）','CD-TOKEN00018','CD-TOKEN00018');
INSERT INTO `tsys_config` (`type`,`ckey`,`cvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('quantitative_finance','pop_protocol_EN','购买协议英文版','admin',now(),'购买协议（英文）','CD-TOKEN00018','CD-TOKEN00018');
INSERT INTO `tsys_config` (`type`,`ckey`,`cvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('quantitative_finance','pop_protocol_KO','购买协议韩文版','admin',now(),'购买协议（韩文）','CD-TOKEN00018','CD-TOKEN00018');

DELETE FROM `tsys_dict` WHERE `parent_key` = 'jour_biz_type_user' AND `dkey` = 'lhlc_invest';
DELETE FROM `tsys_dict` WHERE `parent_key` = 'jour_biz_type_user' AND `dkey` = 'lhlc_repay';
DELETE FROM `tsys_dict` WHERE `parent_key` = 'jour_biz_type_plat_lhlc' AND `dkey` = 'lhlc_invest';
DELETE FROM `tsys_dict` WHERE `parent_key` = 'jour_biz_type_plat_lhlc' AND `dkey` = 'lhlc_repay';
DELETE FROM `tsys_dict` WHERE `parent_key` = 'jour_biz_type' AND `dkey` = 'lhlc_invest';
DELETE FROM `tsys_dict` WHERE `parent_key` = 'jour_biz_type' AND `dkey` = 'lhlc_repay';

INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('1','jour_biz_type_user','lhlc_invest_out','量化理财投资','admin',now(),'','CD-TOKEN00018','CD-TOKEN00018');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('1','jour_biz_type_user','lhlc_repay_in','量化理财本金回款','admin',now(),'','CD-TOKEN00018','CD-TOKEN00018');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('1','jour_biz_type_user','lhlc_income_in','量化理财收益','admin',now(),'','CD-TOKEN00018','CD-TOKEN00018');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('1','jour_biz_type_user','invite_income_pop_in','邀请好友量化分成','admin',now(),'','CD-TOKEN00018','CD-TOKEN00018');

INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('1','jour_biz_type_plat_lhlc','lhlc_invest_in','量化理财投资','admin',now(),'','CD-TOKEN00018','CD-TOKEN00018');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('1','jour_biz_type_plat_lhlc','lhlc_repay_out','量化理财本金回款','admin',now(),'','CD-TOKEN00018','CD-TOKEN00018');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('1','jour_biz_type_plat_lhlc','lhlc_income_out','量化理财收益','admin',now(),'','CD-TOKEN00018','CD-TOKEN00018');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('1','jour_biz_type_plat_lhlc','invite_pop_out','邀请好友量化分成','admin',now(),'','CD-TOKEN00018','CD-TOKEN00018');

INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('1','jour_biz_type','lhlc_invest_out','量化理财投资','admin',now(),'','CD-TOKEN00018','CD-TOKEN00018');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('1','jour_biz_type','lhlc_repay_in','量化理财本金回款','admin',now(),'','CD-TOKEN00018','CD-TOKEN00018');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('1','jour_biz_type','lhlc_income_in','量化理财收益','admin',now(),'','CD-TOKEN00018','CD-TOKEN00018');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('1','jour_biz_type','invite_income_pop_in','邀请好友量化分成','admin',now(),'','CD-TOKEN00018','CD-TOKEN00018');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('1','jour_biz_type','lhlc_invest_in','量化理财投资','admin',now(),'','CD-TOKEN00018','CD-TOKEN00018');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('1','jour_biz_type','lhlc_repay_out','量化理财本金回款','admin',now(),'','CD-TOKEN00018','CD-TOKEN00018');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('1','jour_biz_type','lhlc_income_out','量化理财收益','admin',now(),'','CD-TOKEN00018','CD-TOKEN00018');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('1','jour_biz_type','invite_pop_out','邀请好友量化分成','admin',now(),'','CD-TOKEN00018','CD-TOKEN00018');

INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('0',NULL,'product_type','理财产品类型','admin',now() ,'','CD-TOKEN00018','CD-TOKEN00018');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('1','product_type','0','普通产品','admin',now(),'','CD-TOKEN00018','CD-TOKEN00018');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('1','product_type','1','单次限购产品','admin',now(),'','CD-TOKEN00018','CD-TOKEN00018');

INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('0',NULL,'client_type','客户端类型','admin',now() ,'','CD-TOKEN00018','CD-TOKEN00018');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('1','client_type','WEB_H5','手机H5端','admin',now(),'','CD-TOKEN00018','CD-TOKEN00018');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('1','client_type','ios','苹果端','admin',now(),'','CD-TOKEN00018','CD-TOKEN00018');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('1','client_type','android','安卓端','admin',now(),'','CD-TOKEN00018','CD-TOKEN00018');

