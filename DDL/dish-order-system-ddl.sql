

DROP DATABASE IF EXISTS dos;
CREATE DATABASE dos;
USE dos;

CREATE TABLE Branch
(
    branch_id   SMALLINT,
    phone       CHAR(12)        NOT NULL,
    address     VARCHAR(100)    NOT NULL,
    name        VARCHAR(20)     NOT NULL,
    CONSTRAINT branch_pk PRIMARY KEY (branch_id)
);

CREATE TABLE `User`
(
    username    VARCHAR(20),
    `password`  VARCHAR(50) NOT NULL,
    phone       CHAR(12),
    address     VARCHAR(100),
    signup_date DATE        NOT NULL,
    CONSTRAINT user_pk PRIMARY KEY (username)
);

CREATE TABLE Customer
(
    username    VARCHAR(20),
    CONSTRAINT customer_pk PRIMARY KEY (username),
    CONSTRAINT customer_fk FOREIGN KEY (username)
        REFERENCES `User`(username)
);

CREATE TABLE Administrator
(
    username    VARCHAR(20),
    CONSTRAINT admin_pk PRIMARY KEY (username),
    CONSTRAINT admin_fk FOREIGN KEY (username) 
        REFERENCES `User`(username)
);
l
CREATE TABLE Worker
(
    username    VARCHAR(20),
    branch_id   SMALLINT    NOT NULL,
    CONSTRAINT worker_pk PRIMARY KEY (username, branch_id),
    CONSTRAINT worker_c_fk FOREIGN KEY (username) 
        REFERENCES `User`(username),
    CONSTRAINT worker_b_fk FOREIGN KEY (branch_id) 
        REFERENCES Branch(branch_id)
);

CREATE TABLE `Order`
(
    order_id    INT,
    username    VARCHAR(20) NOT NULL,
    branch_id   SMALLINT,
    CONSTRAINT order_pk PRIMARY KEY (order_id),
    CONSTRAINT order_c_fk FOREIGN KEY (username) 
        REFERENCES Customer(username),
    CONSTRAINT order_b_fk FOREIGN KEY (branch_id) 
        REFERENCES Branch(branch_id)
);


CREATE TABLE Paycard
(
    paycard_id      INT,
    crypt_card_num  VARCHAR(50) NOT NULL,
    card_type       CHAR(10)    NOT NULL,
    cardholder_name VARCHAR(50) NOT NULL,
    expire_date     DATE        NOT NULL,
    CONSTRAINT paycard_pk PRIMARY KEY (paycard_id)
);

-- Paycard used by customer relationship
CREATE TABLE Cust_Paycard
(
    paycard_id  INT,
    username    VARCHAR(20) NOT NULL,
    CONSTRAINT cust_paycard_pk PRIMARY KEY (paycard_id, username),
    CONSTRAINT cust_paycard_p_fk FOREIGN KEY (paycard_id) 
        REFERENCES Paycard(paycard_id),
    CONSTRAINT cust_paycard_c_fk FOREIGN KEY (username) 
        REFERENCES Customer(username)
);

CREATE TABLE Coupon_Dict
(
    coupon_id   INT,
    value       DECIMAL(5,2)    NOT NULL,
    CONSTRAINT coupon_dict_pk PRIMARY KEY(coupon_id)
);

-- coupong rewarded to user
CREATE TABLE Reward
(
    coupon_id   INT,
    username    VARCHAR(20),
    valid_start DATE    NOT NULL,
    valid_end   DATE    NOT NULL,	
    used_date   DATE,
    CONSTRAINT reward_pk PRIMARY KEY (coupon_id, username),
    CONSTRAINT reward_cd_fk FOREIGN KEY (coupon_id) 
        REFERENCES Coupon_Dict(coupon_id),
    CONSTRAINT reward_c_fk FOREIGN KEY (username) 
        REFERENCES Customer(username)
);

CREATE TABLE Delivery_Setting
(
    branch_id   SMALLINT,
    fee         DECIMAL(4,2)    NOT NULL,
    CONSTRAINT delivery_setting_pk PRIMARY KEY(branch_id),
    CONSTRAINT delivery_setting_fk FOREIGN KEY (branch_id) 
        REFERENCES Branch(branch_id)
);

CREATE TABLE Delivery_Info
(
    order_id    INT,
    branch_id   SMALLINT,
    username    VARCHAR(20) NOT NULL,	
    street      VARCHAR(50) NOT NULL,
    city        VARCHAR(20) NOT NULL,
    state       CHAR(20)    NOT NULL,
    zipcode     CHAR(5)     NOT NULL,
    CONSTRAINT delivery_info_pk PRIMARY KEY (order_id),
    CONSTRAINT delivery_info_fk FOREIGN KEY (order_id) 
        REFERENCES `Order`(order_id),
    CONSTRAINT delivery_info_ds_fk FOREIGN KEY (branch_id) 
        REFERENCES Delivery_Setting(branch_id),
    CONSTRAINT delivery_info_c_fk FOREIGN KEY (username) 
        REFERENCES Customer(username)
);

CREATE TABLE Catalog_Dict
(
    catalog_id  SMALLINT,
    name        VARCHAR(20) NOT NULL,
    description VARCHAR(200),
    CONSTRAINT catalog_dict_pk PRIMARY KEY (catalog_id)
);

-- Branch has catalogs
CREATE TABLE Branch_Catalog
(
    branch_id   SMALLINT,
    catalog_id  SMALLINT,
    CONSTRAINT branch_catalog_pk PRIMARY KEY (branch_id, catalog_id),
    CONSTRAINT branch_catalog_b_fk FOREIGN KEY (branch_id) 
        REFERENCES Branch(branch_id),
    CONSTRAINT branch_catalog_c_fk FOREIGN KEY (catalog_id) 
        REFERENCES Catalog_Dict(catalog_id)
);

CREATE TABLE Dish_Dict
(
    dish_id     INT,
    catalog_id  SMALLINT    NOT NULL,
    name        VARCHAR(20) NOT NULL,
    description VARCHAR(200),
    picture     BLOB,
    CONSTRAINT dish_dict_pk PRIMARY KEY (dish_id),
    CONSTRAINT dish_dict_fk FOREIGN KEY (catalog_id) 
        REFERENCES Catalog_Dict(catalog_id)
);

CREATE TABLE Dish
(
    branch_id           SMALLINT,
    dish_id             INT,
    inventory_quantity  SMALLINT        NOT NULL DEFAULT 0,
    price               DECIMAL(5,2)    NOT NULL,
    CONSTRAINT dish_pk PRIMARY KEY (branch_id, dish_id),
    CONSTRAINT dish_b_fk FOREIGN KEY (branch_id) 
        REFERENCES Branch(branch_id),
    CONSTRAINT dish_d_fk FOREIGN KEY (dish_id) 
        REFERENCES Dish_Dict(dish_id)
);

CREATE TABLE Dish_Detail
(
    order_id        INT,
    branch_id       SMALLINT,
    dish_id         INT,
    order_quantity  SMALLINT    NOT NULL    DEFAULT 1,
    CONSTRAINT dish_detail_pk PRIMARY KEY (order_id, branch_id, dish_id),
    CONSTRAINT dish_detail_o_fk FOREIGN KEY (order_id) 
        REFERENCES `Order`(order_id),
    CONSTRAINT dish_detail_d_fk FOREIGN KEY (branch_id, dish_id) 
        REFERENCES Dish(branch_id, dish_id)
);

CREATE TABLE Rating
(
    username    VARCHAR(20),
    order_id    INT,
    branch_id   SMALLINT,
    dish_id     INT,
    score       TINYINT NOT NULL,
    `timestamp` TIMESTAMP,
    comments    VARCHAR(200),
    CONSTRAINT rating_u_fk FOREIGN KEY (username) REFERENCES Customer(username),
    CONSTRAINT rating_d_fk FOREIGN KEY (order_id, branch_id, dish_id) 
    	REFERENCES Dish_Detail (order_id, branch_id, dish_id) 
);

