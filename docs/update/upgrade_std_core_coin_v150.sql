ALTER TABLE `tstd_country` 
ADD COLUMN `pic` VARCHAR(255) NULL COMMENT '国旗图片' AFTER `continent`;

UPDATE `tstd_country` SET `status`='1', `order_no`='4' WHERE `inter_code`='0082';

UPDATE `dev_tha_std_core`.`tstd_country` SET `pic`='Indonesia.png' WHERE `inter_code`='0062';
UPDATE `dev_tha_std_core`.`tstd_country` SET `pic`='Malaysia.png' WHERE `inter_code`='0060';
UPDATE `dev_tha_std_core`.`tstd_country` SET `pic`='China.png' WHERE `inter_code`='0086';
UPDATE `dev_tha_std_core`.`tstd_country` SET `pic`='SouthKorea.png' WHERE `inter_code`='0082';

INSERT INTO `tsys_config` (`type`,`ckey`,`cvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('followUs','Facebook','@THAWallet','admin',now(),'Facebook账号','CD-TOKEN00018','CD-TOKEN00018');
INSERT INTO `tsys_config` (`type`,`ckey`,`cvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('followUs','Twitter','@THAWallet','admin',now(),'Twitter账号','CD-TOKEN00018','CD-TOKEN00018');
INSERT INTO `tsys_config` (`type`,`ckey`,`cvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('followUs','Telegram','https://t.me/THAWallet_cn','admin',now(),'Telegram账号','CD-TOKEN00018','CD-TOKEN00018');
INSERT INTO `tsys_config` (`type`,`ckey`,`cvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('followUs','WeChat','THA-Wallet','admin',now(),'微信账号','CD-TOKEN00018','CD-TOKEN00018');


