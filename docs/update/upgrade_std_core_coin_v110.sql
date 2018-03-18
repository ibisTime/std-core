INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('0',NULL,'store_status','店铺状态','admin',now(),'','CD-TOKEN00018','CD-TOKEN00018');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('1','store_status','1','待上架','admin',now(),'','CD-TOKEN00018','CD-TOKEN00018');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('1','store_status','2','已上架','admin',now(),'','CD-TOKEN00018','CD-TOKEN00018');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('1','store_status','4','已下架','admin',now(),'','CD-TOKEN00018','CD-TOKEN00018');

INSERT INTO `tsys_config` (`type`,`ckey`,`cvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('qiniu','qiniu_access_key','EDwp_G4S-dbWdLUAVqdYciXvjTe2f8nC3X9mGAP3','admin',now(),'七牛云key1','CD-TOKEN00018','CD-TOKEN00018');
INSERT INTO `tsys_config` (`type`,`ckey`,`cvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('qiniu','qiniu_secret_key','ZxFAZFxZ_FDataELWdzsfiZzXu6Snu6RakO1sib7','admin',now(),'七牛云key1','CD-TOKEN00018','CD-TOKEN00018');
INSERT INTO `tsys_config` (`type`,`ckey`,`cvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('qiniu','qiniu_bucket','ogc-token','admin',now(),'存储空间','CD-TOKEN00018','CD-TOKEN00018');
INSERT INTO `tsys_config` (`type`,`ckey`,`cvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('qiniu','qiniu_domain','p5k7690z2.bkt.clouddn.com','admin',now(),'访问域名','CD-TOKEN00018','CD-TOKEN00018');

delete from tsys_dict where parent_key='banner_location' or dkey ='banner_location';
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('0','','banner_location','banner位置','admin',now(),NULL,'CD-TOKEN00018','CD-TOKEN00018');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('1','banner_location','app_home','APP商家首页','admin',now(),NULL,'CD-TOKEN00018','CD-TOKEN00018');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('1','banner_location','web_banner','WEB首页广告','admin',now(),NULL,'CD-TOKEN00018','CD-TOKEN00018');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('1','banner_location','web_download','WEB下载二维码','admin',now(),NULL,'CD-TOKEN00018','CD-TOKEN00018');

INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('1','jour_biz_type','trans','划转','admin',now(),'','CD-TOKEN00018','CD-TOKEN00018');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('1','jour_biz_type','tradefrozen','交易冻结','admin',now(),'','CD-TOKEN00018','CD-TOKEN00018');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('1','jour_biz_type','tradeunfrozen','交易解冻','admin',now(),'','CD-TOKEN00018','CD-TOKEN00018');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('1','jour_biz_type','autofill','自动补给','admin',now(),'','CD-TOKEN00018','CD-TOKEN00018');
