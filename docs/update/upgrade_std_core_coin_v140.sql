
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('0',NULL,'red_packet_status','红包状态','admin',now(),'','CD-TOKEN00018','CD-TOKEN00018');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('1','red_packet_status','0','已发布','admin',now(),'','CD-TOKEN00018','CD-TOKEN00018');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('1','red_packet_status','1','未抢完','admin',now(),'','CD-TOKEN00018','CD-TOKEN00018');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('1','red_packet_status','2','已抢完','admin',now(),'','CD-TOKEN00018','CD-TOKEN00018');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('1','red_packet_status','3','部分退回','admin',now(),'','CD-TOKEN00018','CD-TOKEN00018');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('1','red_packet_status','4','全部退回','admin',now(),'','CD-TOKEN00018','CD-TOKEN00018');

INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('0',NULL,'red_packet_type','红包类型','admin',now(),'','CD-TOKEN00018','CD-TOKEN00018');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('1','red_packet_type','0','定额红包','admin',now(),'','CD-TOKEN00018','CD-TOKEN00018');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('1','red_packet_type','1','拼手气红包','admin',now(),'','CD-TOKEN00018','CD-TOKEN00018');

INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('1','jour_biz_type_user','sendredpacket_in','抢红包','admin',now(),'','CD-TOKEN00018','CD-TOKEN00018');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('1','jour_biz_type_user','sendredpacket_out','发红包','admin',now(),'','CD-TOKEN00018','CD-TOKEN00018');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('1','jour_biz_type_user','redpacket_back','红包退回','admin',now(),'','CD-TOKEN00018','CD-TOKEN00018');