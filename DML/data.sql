USE dos;

INSERT INTO BRANCH (BRANCH_ID, STREET, CITY, STATE, ZIPCODE, NAME, PHONE) VALUES (1, '550 Newhall Dr', 'San Jose', 'CA', '95110', 'Order-N-Get', '800-232-232');
INSERT INTO BRANCH (BRANCH_ID, STREET, CITY, STATE, ZIPCODE, NAME, PHONE) VALUES (2, '2777 El Camino Real', 'Santa Clara', 'CA', '95051', 'Order-N-get', '408-924-1000');

INSERT INTO USER (USERNAME, PASSWORD, STREET, CITY, STATE, ZIPCODE, PHONE, SIGNUP_DATE) VALUES ('cust1', '$2a$10$3sBJyEypIxm6q55sohk9KOqSGTtwC5K8geItdGoOmcHSZtGukfRk2', '1 Washington Square', 'San Jose', 'CA', '95112','800-123-456', STR_TO_DATE('2017-11-01', '%Y-%m-%d'));
INSERT INTO USER (USERNAME, PASSWORD, STREET, CITY, STATE, ZIPCODE, PHONE, SIGNUP_DATE) VALUES ('admin1', '$2a$10$9tWe/MDXo.xoyFylWr9lBuJd2nQjZDspj19BCylKe..51v1qaLxUi', '290 S 7th St', 'San Jose', 'CA', '95112', '800-123-456', STR_TO_DATE('2017-11-06', '%Y-%m-%d'));
INSERT INTO USER (USERNAME, PASSWORD, STREET, CITY, STATE, ZIPCODE, PHONE, SIGNUP_DATE) VALUES ('worker1', '$2a$10$B.y3H9ZObYjhrbzEkaUenOW0xdguHqWv3x4tLG4in.IIC5AX7HUJS', '87 N San Pedro St', 'San Jose', 'CA', '95110', '800-111-222', STR_TO_DATE('2017-11-06', '%Y-%m-%d'));

INSERT INTO CUSTOMER (USERNAME) VALUES ('cust1');
INSERT INTO ADMINISTRATOR (USERNAME) VALUES ('admin1');
INSERT INTO WORKER (USERNAME, BRANCH_ID) VALUES ('worker1', 1);

INSERT INTO default_paycard VALUES ('cust1', '5v9JFotRGp5nMBr9eizgMm0OK5su6xcY', 'visa', 'John Gates', str_to_date('08/09/2019', '%m/%d/%Y'));

insert into catalog_dict values (1, 'starter', 'Wonderful appetizers and snacks');
insert into catalog_dict values (2, 'rice', 'All kinds or fried rice and dish with white rice.');
insert into catalog_dict values (3, 'dumpling', 'Asian style and European style dumplings');

insert into branch_catalog values (1, 1, 2);
insert into branch_catalog values (2, 1, 3);
insert into branch_catalog values (3, 2, 1);
insert into branch_catalog values (4, 2, 2);
insert into branch_catalog values (5, 2, 3);

insert into dish_dict (DISH_ID, CATALOG_ID, `NAME`, DESCRIPTION) values (1, 1, 'Buffalo Wings', 'Served with Celery and Blue cheese or Ranch Dressing.');
insert into dish_dict (DISH_ID, CATALOG_ID, `NAME`, DESCRIPTION) values (2, 1, 'Shrimp Cocktail', 'Served with ketchup lemon and Worcestershire mixed sause');
insert into dish_dict (DISH_ID, CATALOG_ID, `NAME`, DESCRIPTION) values (3, 1, 'Mini Beef Tacos', 'Served with sour cream');
insert into dish_dict (DISH_ID, CATALOG_ID, `NAME`, DESCRIPTION) values (4, 1, 'Smoked Haddock', 'Served with mustard sauce');
insert into dish_dict (DISH_ID, CATALOG_ID, `NAME`, DESCRIPTION) values (5, 2, 'Vegetable Fried Rice', 'Bell peppers, baby peas, and other vegetables.');
insert into dish_dict (DISH_ID, CATALOG_ID, `NAME`, DESCRIPTION) values (6, 2, 'Kimchi Fried Rice', 'Kimchi, rice, egg and spinach');
insert into dish_dict (DISH_ID, CATALOG_ID, `NAME`, DESCRIPTION) values (7, 2, 'Shrimp Fried Rice', 'Shrimp, rice, scrambled eggs, pepper, celery and peas');
insert into dish_dict (DISH_ID, CATALOG_ID, `NAME`, DESCRIPTION) values (8, 2, 'Pineapple Fried Rice', 'Pineapple, bell peppers, rice and scallions');
insert into dish_dict (DISH_ID, CATALOG_ID, `NAME`, DESCRIPTION) values (9, 3, 'Seafood Dumpling', 'Striped bass, shrimp, mashroom and chives');
insert into dish_dict (DISH_ID, CATALOG_ID, `NAME`, DESCRIPTION) values (10, 3, 'Boiled Dumpling', 'Pork,chives and Chinese cabbages');
insert into dish_dict (DISH_ID, CATALOG_ID, `NAME`, DESCRIPTION) values (11, 3, 'German Dumpling', 'Russet potatoes, eggs and bread');
insert into dish_dict (DISH_ID, CATALOG_ID, `NAME`, DESCRIPTION) values (12, 3, 'Vietnamese Dumpling', 'Pork, shrimp, mashroom and green onions. It is made of rice flour');

insert into dish (ID, BRANCH_ID, DISH_ID, PRICE, INVENTORY_QUANTITY) values (1, 1, 5, 7.99, 300);
insert into dish (ID, BRANCH_ID, DISH_ID, PRICE, INVENTORY_QUANTITY) values (2, 1, 7, 9.59, 300);
insert into dish (ID, BRANCH_ID, DISH_ID, PRICE, INVENTORY_QUANTITY) values (3, 1, 8, 7.99, 200);
insert into dish (ID, BRANCH_ID, DISH_ID, PRICE, INVENTORY_QUANTITY) values (4, 1, 9, 9.99, 200);
insert into dish (ID, BRANCH_ID, DISH_ID, PRICE, INVENTORY_QUANTITY) values (5, 1, 10, 7.99, 5);
insert into dish (ID, BRANCH_ID, DISH_ID, PRICE, INVENTORY_QUANTITY) values (6, 1, 11, 8.99, 200);
insert into dish (ID, BRANCH_ID, DISH_ID, PRICE, INVENTORY_QUANTITY) values (7, 1, 12, 6.99, 200);
insert into dish (ID, BRANCH_ID, DISH_ID, PRICE, INVENTORY_QUANTITY) values (8, 2, 1, 5.99, 100);
insert into dish (ID, BRANCH_ID, DISH_ID, PRICE, INVENTORY_QUANTITY) values (9, 2, 2, 5.99, 100);
insert into dish (ID, BRANCH_ID, DISH_ID, PRICE, INVENTORY_QUANTITY) values (10, 2, 3, 4.99, 100);
insert into dish (ID, BRANCH_ID, DISH_ID, PRICE, INVENTORY_QUANTITY) values (11, 2, 5, 8.99, 100);
insert into dish (ID, BRANCH_ID, DISH_ID, PRICE, INVENTORY_QUANTITY) values (12, 2, 6, 6.99, 100);
insert into dish (ID, BRANCH_ID, DISH_ID, PRICE, INVENTORY_QUANTITY) values (13, 2, 7, 8.99, 100);
insert into dish (ID, BRANCH_ID, DISH_ID, PRICE, INVENTORY_QUANTITY) values (14, 2, 9, 10.99, 100);
insert into dish (ID, BRANCH_ID, DISH_ID, PRICE, INVENTORY_QUANTITY) values (15, 2, 10, 7.99, 100);
insert into dish (ID, BRANCH_ID, DISH_ID, PRICE, INVENTORY_QUANTITY) values (16, 2, 12, 7.99, 200);

insert into delivery_setting values (1, true, 7.00);
insert into delivery_setting values (2, false, 0.00);

insert into coupon_dict values ('commentReward', 3.00);
insert into coupon_dict values ('5yearReward', 5.00);

insert into reward (reward_id, coupon_id, username, valid_start, valid_end) 
values (1, 'commentReward', 'cust1', str_to_date('11/09/2017', '%m/%d/%Y'), str_to_date('12/19/2017', '%m/%d/%Y'));
insert into reward (reward_id, coupon_id, username, valid_start, valid_end) 
values (2, 'commentReward', 'cust1', str_to_date('11/20/2017', '%m/%d/%Y'), str_to_date('12/20/2017', '%m/%d/%Y'));
insert into reward (reward_id, coupon_id, username, valid_start, valid_end) 
values (3, 'commentReward', 'cust1', str_to_date('11/25/2017', '%m/%d/%Y'), str_to_date('12/24/2017', '%m/%d/%Y'));
insert into reward (reward_id, coupon_id, username, valid_start, valid_end) 
values (4, 'commentReward', 'cust1', str_to_date('11/30/2017', '%m/%d/%Y'), str_to_date('11/30/2017', '%m/%d/%Y'));

insert into ORDERS values (1, 'cust1', 2, '2017/11/09', 2.0, true, '2017/11/09');
insert into ORDERS values (2, 'cust1', 2, '2017/11/09', 2.0, true, '2017/11/09');
insert into ORDERS values (3, 'cust1', 2, '2017/11/09', 2.0, true, '2017/11/09');
insert into ORDERS values (4, 'cust1', 2, '2017/11/09', 2.0, true, '2017/11/09');
insert into ORDERS values (5, 'cust1', 2, '2017/11/09', 2.0, true, '2017/11/09');
insert into ORDERS values (6, 'cust1', 2, '2017/11/09', 2.0, true, '2017/11/09');
insert into ORDERS values (7, 'cust1', 2, '2017/11/09', 2.0, true, '2017/11/09');
insert into ORDERS values (8, 'cust1', 2, '2017/11/09', 2.0, true, '2017/11/09');

insert into orders (order_id, username, branch_id, order_time, total_price, is_deliver, pickup_deliver_time)
value(1001, 'cust1',1,'2017-11-28 02:21:14.15',20,true, '2017-11-29 02:21:14.15');
insert into orders (order_id, username, branch_id, order_time, total_price, is_deliver, pickup_deliver_time)
value(2001, 'cust1',2,'2017-11-28 12:21:14.15',30,false, null);

insert into RATING (ID, USERNAME, ORDER_ID, DISH_ID, SCORE, TIMESTAMP, COMMENTS)
values (1, 'cust1', 1, 1, 4,  '2000-12-12 18:01:30', 'good!');
insert into RATING (ID, USERNAME, ORDER_ID, DISH_ID, SCORE, TIMESTAMP, COMMENTS)
values (2, 'cust1', 2, 1, 5,  '2000-12-12 18:01:30', 'good!');
insert into RATING (ID, USERNAME, ORDER_ID, DISH_ID, SCORE, TIMESTAMP, COMMENTS)
values (3, 'cust1', 3, 3, 1,  '2000-12-12 18:01:30', 'good!');
insert into RATING (ID, USERNAME, ORDER_ID, DISH_ID, SCORE, TIMESTAMP, COMMENTS)
values (4, 'cust1', 4, 3, 3,  '2000-12-12 18:01:30', 'good!');
insert into RATING (ID, USERNAME, ORDER_ID, DISH_ID, SCORE, TIMESTAMP, COMMENTS)
values (5, 'cust1', 5, 3, 2,  '2000-12-12 18:01:30', 'good!');
insert into RATING (ID, USERNAME, ORDER_ID, DISH_ID, SCORE, TIMESTAMP, COMMENTS)
values (6, 'cust1', 6, 3, 5,  '2000-12-12 18:01:30', 'good!');
insert into RATING (ID, USERNAME, ORDER_ID, DISH_ID, SCORE, TIMESTAMP, COMMENTS)
values (7, 'cust1', 7, 3, 5,  '2000-12-12 18:01:30', 'good!');

insert into rating(id, username, order_id, dish_id, score,timestamp, comments,branch_id) 
values (8, 'cust1', 1001, 1, 5, '2017-11-29 02:21:14.15','Yummy yummy! ',1);
insert into rating(id, username, order_id, dish_id, score,timestamp, comments,branch_id) 

