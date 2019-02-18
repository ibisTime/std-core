DELETE FROM `tsys_dict` WHERE `dkey` = "dapp_label" or `parent_key` = "dapp_label";
DELETE FROM `tsys_dict` WHERE `dkey` = "dapp_trategy_label" or `parent_key` = "dapp_trategy_label";

INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('0','','open_dapp_tag_type','应用标签类型','admin',now(),NULL,'CD-TOKEN00018','CD-TOKEN00018');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('1','open_dapp_tag_type','0','应用','admin',now(),NULL,'CD-TOKEN00018','CD-TOKEN00018');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('1','open_dapp_tag_type','1','攻略','admin',now(),NULL,'CD-TOKEN00018','CD-TOKEN00018');
