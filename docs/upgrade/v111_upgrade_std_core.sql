INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('0',NULL,'comment_type','评论类型','admin',now(),NULL,'CD-CHW000015','CD-CHW000015');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('1','comment_type','P','普通产品','admin',now(),NULL,'CD-CHW000015','CD-CHW000015');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('1','comment_type','PR','租赁产品','admin',now(),NULL,'CD-CHW000015','CD-CHW000015');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('1','comment_type','TR','游记','admin',now(),NULL,'CD-CHW000015','CD-CHW000015');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('1','comment_type','AN','活动留言','admin',now(),NULL,'CD-CHW000015','CD-CHW000015');

ALTER TABLE `tstd_comment` 
CHANGE COLUMN `entity_name` `entity_name` TEXT NULL DEFAULT NULL COMMENT '实体名称';

delete from tsys_dict where parent_key='travel_status' or dkey='travel_status';

INSERT INTO `tsys_config` (`type`,`ckey`,`cvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('rent','RP_CONFIRM_ORDER_DAYS','7','admin',now(),'超过天数，系统确认收货','CD-CHW000015','CD-CHW000015');

delete from tsys_dict where parent_key='act_status' or dkey='act_status';
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('0',NULL,'act_status','活动状态','admin',now(),NULL,'CD-CHW000015','CD-CHW000015');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('1','act_status','0','待发布','admin',now(),NULL,'CD-CHW000015','CD-CHW000015');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('1','act_status','1','已发布','admin',now(),NULL,'CD-CHW000015','CD-CHW000015');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('1','act_status','3','未成团','admin',now(),NULL,'CD-CHW000015','CD-CHW000015');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('1','act_status','4','已成团','admin',now(),NULL,'CD-CHW000015','CD-CHW000015');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('1','act_status','5','已完成','admin',now(),NULL,'CD-CHW000015','CD-CHW000015');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('1','act_status','9','已取消','admin',now(),NULL,'CD-CHW000015','CD-CHW000015');

update tsys_dict set dvalue ='免费活动成团奖励' where dkey='HD_MFFB';
update tsys_dict set dvalue ='收费活动成团奖励' where dkey='HD_SFFB';

update tstd_travels set status ='0' where status ='1';

update tstd_interact set kind='cl' where type ='P' or type='RP' or type='N';