/*
-- Query: SELECT type,parent_key,dkey,dvalue,updater,update_datetime,remark,company_code,system_code FROM std_core.tsys_dict
-- Date: 2017-08-31 20:03
*/
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('0',NULL,'news_status','资讯状态','admin',now(),NULL,'CD-CHW000015','CD-CHW000015');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('1','news_status','0','未发布','admin',now(),NULL,'CD-CHW000015','CD-CHW000015');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('1','news_status','1','已发布','admin',now(),NULL,'CD-CHW000015','CD-CHW000015');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('1','news_status','2','已下架','admin',now(),NULL,'CD-CHW000015','CD-CHW000015');

INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('0',NULL,'reaction','','admin',now(),NULL,'CD-CHW000015','CD-CHW000015');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('1','reaction','0','正常','admin',now(),NULL,'CD-CHW000015','CD-CHW000015');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('1','reaction','1','审核','admin',now(),NULL,'CD-CHW000015','CD-CHW000015');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('1','reaction','2','拒绝','admin',now(),NULL,'CD-CHW000015','CD-CHW000015');