
INSERT INTO `tsys_config` (`type`,`ckey`,`cvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('collection_rule_btc','collection_limit_btc','100','admin',now(),'当UTXO总额大于等于该值时，进行归集','CD-COIN000017','CD-COIN000017');
INSERT INTO `tsys_config` (`type`,`ckey`,`cvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('withdraw_rule_btc','withdraw_fee_btc','0','admin',now(),'BTC取现手续费','CD-COIN000017','CD-COIN000017');
INSERT INTO `tsys_config` (`type`,`ckey`,`cvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('coin_price_x','btc_coin_price_x','0','admin',now(),'btc价格计算x','CD-COIN000017','CD-COIN000017');

INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('1','channel_type','BTC','比特币','admin',now(),'','CD-COIN000017','CD-COIN000017');
