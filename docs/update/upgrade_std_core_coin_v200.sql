

INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('1','coin','SC','云储币','admin',now(),'','CD-COIN000017','CD-COIN000017');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('1','channel_type','SC','云储币','admin',now(),'','CD-COIN000017','CD-COIN000017');

UPDATE `tsys_config` SET `type`='collection_rule_eth',`ckey`='collection_limit_eth' WHERE `type`='collection_rule' AND `ckey`='collection_limit';
UPDATE `tsys_config` SET `type`='withdraw_rule_eth',`ckey`='withdraw_fee_eth' WHERE `type`='withdraw_rule' AND `ckey`='withdraw_fee';
INSERT INTO `tsys_config` (`type`,`ckey`,`cvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('collection_rul_sc','collection_limit_sc','10000','admin',now(),'当SC钱包达到该数量时进行自动归集','CD-COIN000017','CD-COIN000017');
INSERT INTO `tsys_config` (`type`,`ckey`,`cvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('withdraw_rule_sc','withdraw_fee_sc','100','admin',now(),'SC取现手续费','CD-COIN000017','CD-COIN000017');

INSERT INTO `tsys_config` (`type`,`ckey`,`cvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('coin_price_x','sc_coin_price_x','0','admin',now(),'sc价格计算x','CD-COIN000017','CD-COIN000017');