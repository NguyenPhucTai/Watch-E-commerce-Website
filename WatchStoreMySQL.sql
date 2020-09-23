use assignmentspring;

create database watchstore;
use watchstore;

INSERT INTO roles (name) VALUES  ("ADMIN");
INSERT INTO roles (name) VALUES  ("USER");

INSERT INTO account_role (account_id, role_id) VALUES  ("1","1");
INSERT INTO account_role (account_id, role_id) VALUES  ("2","1");
INSERT INTO account_role (account_id, role_id) VALUES  ("3","2");
INSERT INTO account_role (account_id, role_id) VALUES  ("4","2");

DELETE FROM account_role where account_id = 14;
DELETE FROM account_role where account_id = 3;
DELETE FROM account_role where account_id = 13;

DELETE FROM accounts WHERE id = 3;
DELETE FROM accounts WHERE id = 12;
DELETE FROM accounts WHERE id = 13;
DELETE FROM accounts WHERE id = 10;


/*Insert to BRAND*/
insert into brand (brand_name) values ("HUBLOT");

/*Insert to CATEGORY*/
insert into category (cate_name) values ("3-HANDS");
insert into category (cate_name) values ("CHRONOGRAPH");
insert into category (cate_name) values ("MOONPHASE");
insert into category (cate_name) values ("ORLINSKI");
insert into category (cate_name) values ("PARTNERSHIPS");


/*Insert to PRODUCT*/
insert into product (product_name, price, link_img, brand_id) values
("TITANIUM", 	  			  						   		   6900,  "https://www.hublot.com/sites/default/files/styles/watch_item_desktop_1x_scale_no_crop_600_6000_/public/2020-06/Classic-Fusion-Titanium-on-Rubber-45-mm.png?itok=ESByyOfI", 1),
("TITANIUM OPALIN", 	  			  						   7300,  "https://www.hublot.com/sites/default/files/styles/watch_item_desktop_1x_scale_no_crop_600_6000_/public/classic-fusion-titanium-opalin-45-mm-511.NX.2611.LR-soldier-shot.png?itok=wmue-wpJ", 1),
("TITANIUM BLUE", 		  			  						   7300,  "https://www.hublot.com/sites/default/files/styles/watch_item_desktop_1x_scale_no_crop_600_6000_/public/classic-fusion-titanium-blue-45-mm-511.NX.7170.LR-soldier-shot.png?itok=RIyhqaOG", 1),
("RACING GREY TITANIUM",  			  						   7300,  "https://www.hublot.com/sites/default/files/styles/watch_item_desktop_1x_scale_no_crop_600_6000_/public/classic-fusion-racing-grey-titanium-45-mm-511.NX.7071.LR-soldier-shot.png?itok=TSzz2LmJ", 1),
("TITANIUM KING GOLD",    			  						   11000, "https://www.hublot.com/sites/default/files/styles/watch_item_desktop_1x_scale_no_crop_600_6000_/public/classic-fusion-titanium-king-gold-45-mm-511.NO.1181.LR-soldier-shot.png?itok=oDyrtNsz", 1),
("KING GOLD", 			  			  						   22300, "https://www.hublot.com/sites/default/files/styles/watch_item_desktop_1x_scale_no_crop_600_6000_/public/classic-fusion-king-gold-45-mm-511.OX.1181.LR-soldier-shot.png?itok=Tq33fYL_", 1),
("KING GOLD OPALIN",      			  						   22300, "https://www.hublot.com/sites/default/files/styles/watch_item_desktop_1x_scale_no_crop_600_6000_/public/2020-06/Classic-Fusion-King-Gold-Opalin-45-mm-soldier-shot.png?itok=KmIkCLuj", 1),
("KING GOLD GREEN", 	  			  						   22300, "https://www.hublot.com/sites/default/files/styles/watch_item_desktop_1x_scale_no_crop_600_6000_/public/classic-fusion-king-gold-green-45-mm-511.OX.8980.LR-soldier-shot.png?itok=inT1ZOfF", 1),
("KING GOLD BLUE", 		  			  						   22300, "https://www.hublot.com/sites/default/files/styles/watch_item_desktop_1x_scale_no_crop_600_6000_/public/classic-fusion-king-gold-blue-45-mm-511.OX.7180.LR-soldier-shot.png?itok=eKleFH-s", 1),
("RACING GREY KING GOLD", 			  						   22300, "https://www.hublot.com/sites/default/files/styles/watch_item_desktop_1x_scale_no_crop_600_6000_/public/classic-fusion-racing-grey-king-gold-45-mm-511.OX.7081.LR-soldier-shot.png?itok=CCy2fMCu", 1),
("CERAMIC KING GOLD",     			  						   12500, "https://www.hublot.com/sites/default/files/styles/watch_item_desktop_1x_scale_no_crop_600_6000_/public/classic-fusion-ceramic-king-gold-45-mm-511.CO.1181.RX-soldier-shot.png?itok=T9lBS_4z", 1),
("CHRONOGRAPH TITANIUM",  			  						   9900,  "https://www.hublot.com/sites/default/files/styles/watch_item_desktop_1x_scale_no_crop_600_6000_/public/2020-06/Classic-Fusion-Chronograph-Titanium-on-Rubber-45-mm_0.png?itok=YWnrW_w_", 1),
("CHRONOGRAPH TITANIUM OPALIN", 	  						   10300, "https://www.hublot.com/sites/default/files/styles/watch_item_desktop_1x_scale_no_crop_600_6000_/public/classic-fusion-chronograph-titanium-opalin-45-mm-521.NX.2611.LR-soldier-shot.png?itok=S98ZZI_y", 1),
("CHRONOGRAPH TITANIUM BLUE",   	  						   10300, "https://www.hublot.com/sites/default/files/styles/watch_item_desktop_1x_scale_no_crop_600_6000_/public/classic-fusion-chronograph-titanium-blue-45-mm-521.NX.7170.LR-soldier-shot.png?itok=3kGtESPW", 1),
("AEROFUSION TITANIUM", 			  						   14300, "https://www.hublot.com/sites/default/files/styles/watch_item_desktop_1x_scale_no_crop_600_6000_/public/classic-fusion-aerofusion-titanium-45-mm-525.NX.0170.LR-soldier-shot.png?itok=sUYcgdaP", 1),
("AEROFUSION KING GOLD", 			  						   33300, "https://www.hublot.com/sites/default/files/styles/watch_item_desktop_1x_scale_no_crop_600_6000_/public/classic-fusion-aerofusion-king-gold-45-mm-525.OX.0180.LR-soldier-shot.png?itok=8Z-ZJaVG", 1),
("AEROFUSION BLACK MAGIC",      	  						   14900, "https://www.hublot.com/sites/default/files/styles/watch_item_desktop_1x_scale_no_crop_600_6000_/public/classic-fusion-aerofusion-black-magic-45-mm-525.CM.0170.RX-soldier-shot.png?itok=1A7iy4Gv", 1),
("AEROFUSION UEFA CHAMPIONS LEAGUE",  						   16400, "https://www.hublot.com/sites/default/files/styles/watch_item_desktop_1x_scale_no_crop_600_6000_/public/2020-05/classic-fusion-aerofusion-titanium-45-mm-525.NX_.0170_2.png?itok=eoIUGnXS", 1),
("AEROFUSION TITANIUM DIAMONDS",      						   20300, "https://www.hublot.com/sites/default/files/styles/watch_item_desktop_1x_scale_no_crop_600_6000_/public/classic-fusion-aerofusion-titanium-diamonds-45-mm-525.NX.0170.LR.1104-soldier-shot.png?itok=32QoRDz6", 1),
("AEROFUSION TITANIUM PAVE", 		  						   28800, "https://www.hublot.com/sites/default/files/styles/watch_item_desktop_1x_scale_no_crop_600_6000_/public/classic-fusion-aerofusion-titanium-pave-525.NX.0170.LR.1704-soldier-shot.png?itok=pPuuANza", 1),
("AEROFUSION KING GOLD DIAMONDS", 	  						   41300, "https://www.hublot.com/sites/default/files/styles/watch_item_desktop_1x_scale_no_crop_600_6000_/public/classic-fusion-aerofusion-king-gold-diamonds-525.OX.0180.LR.1104-soldier-shot.png?itok=Uul32EK8", 1),
("AEROFUSION KING GOLD PAVE", 		  						   47800, "https://www.hublot.com/sites/default/files/styles/watch_item_desktop_1x_scale_no_crop_600_6000_/public/classic-fusion-aerofusion-king-gold-pave-45-mm-525.OX.0180.LR.1704-soldier-shot.png?itok=PzIrcKFK", 1),
("AEROFUSION TITANIUM BRACELET",      						   15400, "https://www.hublot.com/sites/default/files/styles/watch_item_desktop_1x_scale_no_crop_600_6000_/public/classic-fusion-aerofusion-titanium-bracelet-45-mm-528.NX.0170.NX-soldier-shot.png?itok=S-TQ4B_q", 1),
("AEROFUSION KING GOLD BRACELET",     						   45900, "https://www.hublot.com/sites/default/files/styles/watch_item_desktop_1x_scale_no_crop_600_6000_/public/classic-fusion-aerofusion-king-gold-bracelet-45-mm-528.OX.0180.OX-soldier-shot.png?itok=VjhEviGG", 1),
("AEROFUSION BLACK MAGIC BRACELET",   				 		   17900, "https://www.hublot.com/sites/default/files/styles/watch_item_desktop_1x_scale_no_crop_600_6000_/public/classic-fusion-aerofusion-black-magic-bracelet-45-mm-528.CM.0170.CM-soldier-shot.png?itok=jxZePGE8", 1),
("AEROFUSION MOONPHASE TITANIUM",     						   15300, "https://www.hublot.com/sites/default/files/styles/watch_item_desktop_1x_scale_no_crop_600_6000_/public/classic-fusion-aerofusion-moonphase-titanium-45-mm-517.NX.0170.LR-soldier-shot.png?itok=AOhWcDZn", 1),
("AEROFUSION MOONPHASE KING GOLD",    						   30300, "https://www.hublot.com/sites/default/files/styles/watch_item_desktop_1x_scale_no_crop_600_6000_/public/classic-fusion-aerofusion-moonphase-king-gold-45-mm-517.OX.0180.LR-soldier-shot.png?itok=qkuxj6oX", 1),
("AEROFUSION MOONPHASE BLACK MAGIC",  						   16900, "https://www.hublot.com/sites/default/files/styles/watch_item_desktop_1x_scale_no_crop_600_6000_/public/classic-fusion-aerofusion-moonphase-black-magic-45-mm-517.CX.0170.LR-soldier-shot.png?itok=Cwrro6Xl", 1),
("AEROFUSION MOONPHASE TITANIUM DIAMONDS",  				   21300, "https://www.hublot.com/sites/default/files/styles/watch_item_desktop_1x_scale_no_crop_600_6000_/public/classic-fusion-aerofusion-moonphase-titanium-diamonds-45-mm-517.NX.0170.LR.1104-soldier-shot.png?itok=bOCNBOtg", 1),
("AEROFUSION MOONPHASE TITANIUM PAVE",      				   29800, "https://www.hublot.com/sites/default/files/styles/watch_item_desktop_1x_scale_no_crop_600_6000_/public/classic-fusion-aerofusion-moonphase-titanium-pave-45-mm-517.NX.0170.LR.1704-soldier-shot.png?itok=b2OECcxC", 1),
("AEROFUSION MOONPHASE KING GOLD DIAMONDS", 				   38300, "https://www.hublot.com/sites/default/files/styles/watch_item_desktop_1x_scale_no_crop_600_6000_/public/classic-fusion-aerofusion-moonphase-king-gold-diamonds-45-mm-517.OX.0180.LR.1104-soldier-shot.png?itok=geKfDbT0", 1),
("AEROFUSION MOONPHASE KING GOLD PAVE",     				   44800, "https://www.hublot.com/sites/default/files/styles/watch_item_desktop_1x_scale_no_crop_600_6000_/public/classic-fusion-aerofusion-moonphase-king-gold-pave-45-mm-517.OX.0180.LR.1704-soldier-shot.png?itok=FQjYN-Pn", 1),
("AEROFUSION CHRONOGRAPH ORLINSKI RED CERAMIC", 			   22900, "https://www.hublot.com/sites/default/files/styles/watch_item_desktop_1x_scale_no_crop_600_6000_/public/classic-fusion-aerofusion-chronograph-orlinski-red-ceramic-45-mm-525.CF.0130.RX.ORL19-soldier-shot.png?itok=jafkLvBz", 1),
("AEROFUSION CHRONOGRAPH ORLINSKI TITANIUM ALTERNATIVE PAVE",  29900, "https://www.hublot.com/sites/default/files/styles/watch_item_desktop_1x_scale_no_crop_600_6000_/public/classic-fusion-aerofusion-chronograph-orlinski-titanium-alternative-pave-45-mm-525.NX.0170.RX.1804.ORL18-soldier-shot.png?itok=0NzhcRVH", 1),
("AEROFUSION CHRONOGRAPH ORLINSKI KING GOLD ALTERNATIVE PAVE", 48900, "https://www.hublot.com/sites/default/files/styles/watch_item_desktop_1x_scale_no_crop_600_6000_/public/classic-fusion-aerofusion-chronograph-orlinski-king-gold-alternative-pave-45-mm-525.OX.0180.RX.1804.ORL19-soldier-shot.png?itok=ASpqlq3G", 1),
("TOURBILLON POWER RESERVE 5 DAYS ORLINSKI BLACK MAGIC",       85000, "https://www.hublot.com/sites/default/files/styles/watch_item_desktop_1x_scale_no_crop_600_6000_/public/classic-fusion-tourbillon-power-reserve-5-days-orlinski-black-magic-45-mm-505.CI.1170.RX.ORL19-soldier-shot.png?itok=JcGrbGFO", 1),
("TOURBILLON POWER RESERVE 5 DAYS ORLINSKI KING GOLD",         95000, "https://www.hublot.com/sites/default/files/styles/watch_item_desktop_1x_scale_no_crop_600_6000_/public/classic-fusion-tourbillon-power-reserve-5-days-orlinski-king-gold-45-mm-505.OX.1180.RX.ORL19-soldier-shot.png?itok=l2Mxvn4U", 1),
("ORLINSKI TITANIUM",     									   10900, "https://www.hublot.com/sites/default/files/styles/watch_item_desktop_1x_scale_no_crop_600_6000_/public/classic-fusion-orlinski-titanium-40-mm-550.NS.1800.RX.ORL19-soldier-shot.png?itok=Gx6KBte0", 1),
("ORLINSKI KING GOLD",     									   21400, "https://www.hublot.com/sites/default/files/styles/watch_item_desktop_1x_scale_no_crop_600_6000_/public/classic-fusion-orlinski-king-gold-40-mm-550.OS.1800.RX.ORL19-soldier-shot.png?itok=DAOMDALu", 1),
("ORLINSKI TITANIUM ALTERNATIVE PAVE",     					   17900, "https://www.hublot.com/sites/default/files/styles/watch_item_desktop_1x_scale_no_crop_600_6000_/public/classic-fusion-orlinski-titanium-alternative-pave-40-mm-550.NS.1800.RX.1804.ORL19-soldier-shot.png?itok=ZH4PRYEa", 1),
("ORLINSKI KING GOLD ALTERNATIVE PAVE",     				   27900, "https://www.hublot.com/sites/default/files/styles/watch_item_desktop_1x_scale_no_crop_600_6000_/public/classic-fusion-orlinski-king-gold-alternative-pave-40-mm-550.OS.1800.RX.1804.ORL19-soldier-shot.png?itok=-sppjEtU", 1),
("ORLINSKI TITANIUM PAVE",     								   20900, "https://www.hublot.com/sites/default/files/styles/watch_item_desktop_1x_scale_no_crop_600_6000_/public/classic-fusion-orlinski-titanium-pave-40-mm-550.NS.1800.RX.1604.ORL19-soldier-shot.png?itok=G8_0-CO8", 1),
("ORLINSKI KING GOLD PAVE",    								   30900, "https://www.hublot.com/sites/default/files/styles/watch_item_desktop_1x_scale_no_crop_600_6000_/public/classic-fusion-orlinski-king-gold-pave-40-mm-550.OS.1800.RX.1604.ORL19-soldier-shot.png?itok=Q9o965gv", 1),
("FERRARI GT TITANIUM",    									   20900, "https://www.hublot.com/sites/default/files/styles/watch_item_desktop_1x_scale_no_crop_600_6000_/public/classic-fusion-ferrari-gt-titanium-45-mm-526.NX.0124.VR-soldier-shot.png?itok=Z2zZWoIJ", 1),
("FERRARI GT KING GOLD",    								   36900, "https://www.hublot.com/sites/default/files/styles/watch_item_desktop_1x_scale_no_crop_600_6000_/public/classic-fusion-ferrari-gt-king-gold-45-mm-526.OX.0124.VR-soldier-shot.png?itok=tonli5qC", 1),
("FERRARI GT 3D CARBON",    								   25900, "https://www.hublot.com/sites/default/files/styles/watch_item_desktop_1x_scale_no_crop_600_6000_/public/classic-fusion-ferrari-gt-3d-carbon-45-mm-526.QB.0124.VR-soldier-shot.png?itok=lPsqDxnB", 1),
("CHRONOGRAPH BERLUTI COLD BROWN",    						   17900, "https://www.hublot.com/sites/default/files/styles/watch_item_desktop_1x_scale_no_crop_600_6000_/public/classic-fusion-chronograph-berluti-cold-brown-45-mm-521.NX.05IB.VR.BER19-soldier-shot.png?itok=bU1Alskp", 1),
("CHRONOGRAPH BERLUTI COLD GOLD",    						   19900, "https://www.hublot.com/sites/default/files/styles/watch_item_desktop_1x_scale_no_crop_600_6000_/public/classic-fusion-chronograph-berluti-cold-gold-45mm-521.BZ.05IG.VR.BER19-soldier-shot.png?itok=aaRlb7_M", 1),
("CRUZ DIEZ TITANIUM",   									   10300, "https://www.hublot.com/sites/default/files/styles/watch_item_desktop_1x_scale_no_crop_600_6000_/public/classic-fusion-cruz-diez-titanium-45-mm-511.NX.8900.VR.CZD19-soldier-shot.png?itok=jTl_ZOeK", 1),
("CRUZ DIEZ KING GOLD",    									   25300, "https://www.hublot.com/sites/default/files/styles/watch_item_desktop_1x_scale_no_crop_600_6000_/public/classic-fusion-cruz-diez-king-gold-45-mm-511.OX.8900.VR.CZD19-soldier-shot.png?itok=ijLtYnDo", 1),
("CRUZ DIEZ CERAMIC",    									   12300, "https://www.hublot.com/sites/default/files/styles/watch_item_desktop_1x_scale_no_crop_600_6000_/public/classic-fusion-cruz-diez-ceramic-45-mm-511.CX.8900.VR.CZD19-soldier-shot.png?itok=aV8Op2X-", 1);


/*Insert to PRODUCT_MCATEGORY*/
insert into product_mcategory(category_id, product_id) values
(1, 1),
(1, 2),
(1, 3),
(1, 4),
(1, 5),
(1, 6),
(1, 7),
(1, 8),
(1, 9),
(1, 10),
(1, 11),
(2, 12),
(2, 13),
(2, 14),
(2, 15),
(2, 16),
(2, 17),
(2, 18),
(2, 19),
(2, 20),
(2, 21),
(2, 22),
(2, 23),
(2, 24),
(2, 25),
(3, 26),
(3, 27),
(3, 28),
(3, 29),
(3, 30),
(3, 31),
(3, 32),
(4, 33),
(4, 34),
(4, 35),
(4, 36),
(4, 37),
(4, 38),
(4, 39),
(4, 40),
(4, 41),
(4, 42),
(4, 43),
(5, 44),
(5, 45),
(5, 46),
(5, 47),
(5, 48),
(5, 49),
(5, 50),
(5, 51);

select *
from accounts a, account_role r
where a.id = r.account_id
	and role_id  = "2";



