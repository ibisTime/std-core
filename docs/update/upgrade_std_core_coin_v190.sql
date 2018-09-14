
INSERT INTO `tsys_config` (`type`,`ckey`,`cvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('jf','register_add','10','admin',now(),'新用户注册赠送积分数量','CD-TOKEN00018','CD-TOKEN00018');
INSERT INTO `tsys_config` (`type`,`ckey`,`cvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('jf','invite_add','10','admin',now(),'邀请新用户并成功登录APP赠送积分数量','CD-TOKEN00018','CD-TOKEN00018');
INSERT INTO `tsys_config` (`type`,`ckey`,`cvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('jf','lottery_cost','10','admin',now(),'抽奖消耗积分数量','CD-TOKEN00018','CD-TOKEN00018');


INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('1','jour_biz_type_user','jf_lottery_in','积分抽奖','admin',now(),'','CD-TOKEN00018','CD-TOKEN00018');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('1','jour_biz_type_plat','jf_lottery_out','积分抽奖支出','admin',now(),'','CD-TOKEN00018','CD-TOKEN00018');