INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('0',NULL,'product_order_status','订单商品状态','admin',now(),NULL,'CD-CHW000015','CD-CHW000015');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('1','product_order_status','0','可退货','admin',now(),NULL,'CD-CHW000015','CD-CHW000015');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('1','product_order_status','1','退货申请中','admin',now(),NULL,'CD-CHW000015','CD-CHW000015');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('1','product_order_status','2','待发货','admin',now(),NULL,'CD-CHW000015','CD-CHW000015');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('1','product_order_status','3','退货失败','admin',now(),NULL,'CD-CHW000015','CD-CHW000015');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('1','product_order_status','4','已发货', 'admin',now(),NULL,'CD-CHW000015','CD-CHW000015');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('1','product_order_status','5','已退款','admin',now(),NULL,'CD-CHW000015','CD-CHW000015');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('1','product_order_status','6','收货异常','admin',now(),NULL,'CD-CHW000015','CD-CHW000015');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('1','product_order_status','7','不可退货','admin',now(),NULL,'CD-CHW000015','CD-CHW000015');

INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('0',NULL,'run_team_list','跑团列表','admin',now(),NULL,'CD-CHW000015','CD-CHW000015');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('1','run_team_list','任贝跑团','任贝跑团','admin',now(),NULL,'CD-CHW000015','CD-CHW000015');

ALTER TABLE `tstd_travels` 
ADD COLUMN `run_team_list` VARCHAR(32) NULL COMMENT '所属跑团' AFTER `pic`;

INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('0',NULL,'return_reason','退货原因','admin',now(),NULL,'CD-CHW000015','CD-CHW000015');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('1','return_reason','1','商品信息描述不符','admin',now(),NULL,'CD-CHW000015','CD-CHW000015');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('1','return_reason','2','7天无理由退货','admin',now(),NULL,'CD-CHW000015','CD-CHW000015');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('1','return_reason','9','其他','admin',now(),NULL,'CD-CHW000015','CD-CHW000015');

INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('1','order_status','6','已支付待成团','admin',now(),'','CD-CHW000015','CD-CHW000015');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('1','order_status','7','未成团','admin',now(),'','CD-CHW000015','CD-CHW000015');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('1','order_status','8','已成团','admin',now(),'','CD-CHW000015','CD-CHW000015');

INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('0',NULL,'product_group_code','商品团购状态','admin',now(),NULL,'CD-CHW000015','CD-CHW000015');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('1','product_group_code','0','待开始','admin',now(),NULL,'CD-CHW000015','CD-CHW000015');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('1','product_group_code','1','成团中','admin',now(),NULL,'CD-CHW000015','CD-CHW000015');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('1','product_group_code','2','已成团','admin',now(),NULL,'CD-CHW000015','CD-CHW000015');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('1','product_group_code','3','未成团','admin',now(),NULL,'CD-CHW000015','CD-CHW000015');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('1','product_group_code','4','已取消','admin',now(),NULL,'CD-CHW000015','CD-CHW000015');

INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('1','product_location','3','限时特卖','admin',now(),'','CD-CHW000015','CD-CHW000015');

INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('1','act_order_status','6','申请退款中','admin',now(),NULL,'CD-CHW000015','CD-CHW000015');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('1','act_order_status','7','退款成功','admin',now(),NULL,'CD-CHW000015','CD-CHW000015');