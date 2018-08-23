INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('0',NULL,'product_order_status','订单详情商品状态','admin',now(),NULL,'CD-CHW000015','CD-CHW000015');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('1','product_order_status','0','可退货','admin',now(),NULL,'CD-CHW000015','CD-CHW000015');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('1','product_order_status','1','退货申请中','admin',now(),NULL,'CD-CHW000015','CD-CHW000015');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('1','product_order_status','2','代发货','admin',now(),NULL,'CD-CHW000015','CD-CHW000015');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('1','product_order_status','3','退货失败','admin',now(),NULL,'CD-CHW000015','CD-CHW000015');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('1','product_order_status','4','已发货', 'admin',now(),NULL,'CD-CHW000015','CD-CHW000015');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('1','product_order_status','5','已退款','admin',now(),NULL,'CD-CHW000015','CD-CHW000015');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('1','product_order_status','6','收货异常','admin',now(),NULL,'CD-CHW000015','CD-CHW000015');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('1','product_order_status','7','不可退货','admin',now(),NULL,'CD-CHW000015','CD-CHW000015');

INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('0',NULL,'run_team_list','跑团列表','admin',now(),NULL,'CD-CHW000015','CD-CHW000015');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('1','run_team_list','1001','任贝跑团','admin',now(),NULL,'CD-CHW000015','CD-CHW000015');

ALTER TABLE `tstd_travels` 
ADD COLUMN `run_team_list` VARCHAR(32) NULL COMMENT '所属跑团' AFTER `pic`;

INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('0',NULL,'return_reason','退货原因','admin',now(),NULL,'CD-CHW000015','CD-CHW000015');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('1','return_reason','1','商品信息描述不符','admin',now(),NULL,'CD-CHW000015','CD-CHW000015');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('1','return_reason','2','卖家发错货','admin',now(),NULL,'CD-CHW000015','CD-CHW000015');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('1','return_reason','3','其他','admin',now(),NULL,'CD-CHW000015','CD-CHW000015');

INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('1','order_status','6','已支付待成团','admin',now(),'','CD-CHW000015','CD-CHW000015');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('1','order_status','7','已成团','admin',now(),'','CD-CHW000015','CD-CHW000015');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('1','order_status','8','未成团','admin',now(),'','CD-CHW000015','CD-CHW000015');

INSERT INTO `tsys_config` (`type`,`ckey`,`cvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('prod_back_rate','PROD_LD_BACK_RATE','0.5','admin',now(),'领队返点比例','CD-CHW000015','CD-CHW000015');
INSERT INTO `tsys_config` (`type`,`ckey`,`cvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('prod_back_rate','PROD_ONE_BACK_RATE','0.5','admin',now(),'一级返点比例','CD-CHW000015','CD-CHW000015');
INSERT INTO `tsys_config` (`type`,`ckey`,`cvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('prod_back_rate','PROD_TWO_BACK_RATE','0.3','admin',now(),'二级返点比例','CD-CHW000015','CD-CHW000015');
