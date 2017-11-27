DROP DATABASE IF EXISTS dos;
CREATE DATABASE dos;
USE dos;

/*==============================================================*/
/* Table: BRANCH                                                */
/*==============================================================*/
create table BRANCH
(
   BRANCH_ID            smallint not null,
   PHONE                char(12) not null,
   STREET               varchar(50) not null,
   CITY                 varchar(20) not null,
   STATE                varchar(20) not null,
   ZIPCODE              char(5) not null,
   NAME                 varchar(20) not null,
   primary key (BRANCH_ID)
);



/*==============================================================*/
/* Table: USER                                                  */
/*==============================================================*/
create table USER
(
   USERNAME             varchar(20) not null,
   PASSWORD             varchar(100) not null,
   PHONE                char(12),
   STREET               varchar(50),
   CITY                 varchar(20),
   STATE                varchar(20),
   ZIPCODE              char(5),
   SIGNUP_DATE          date not null,
   primary key (USERNAME)
);


create table CUSTOMER
(
    USERNAME    varchar(20),
    constraint customer_pk primary key (username),
    constraint customer_fk foreign key (username)
        references USER (USERNAME) on delete cascade
);


create table ADMINISTRATOR
(
    USERNAME    varchar(20),
    constraint ADMIN_PK primary key (USERNAME),
    constraint ADMIN_FK foreign key (username) 
        references USER (USERNAME) on delete cascade
);


CREATE TABLE WORKER
(
    USERNAME    varchar(20),
    BRANCH_ID   smallint    not null,
    constraint WORKER_PK primary key (USERNAME, BRANCH_ID),
    constraint WORKER_C_FK foreign key (USERNAME) 
        references USER (USERNAME) on delete cascade,
    constraint worker_b_fk foreign key (BRANCH_ID) 
        references BRANCH (BRANCH_ID)
);



/*==============================================================*/
/* Table: DEFAULT_PAYCARD                                       */
/*==============================================================*/
create table DEFAULT_PAYCARD
(
   USERNAME             varchar(20) not null,
   CARD_NUM             varchar(50) not null,
   CARD_TYPE            varchar(10) not null,
   CARDHOLDER_NAME      varchar(50) not null,
   EXPIRE_DATE          date not null,
   primary key (USERNAME)
);

alter table DEFAULT_PAYCARD add constraint FK_REFERENCE_6 foreign key (USERNAME)
      references USER (USERNAME) on delete restrict on update restrict;
      


/*==============================================================*/
/* Table: COUPON_DICT                                           */
/*==============================================================*/
create table COUPON_DICT
(
   COUPON_ID            int not null,
   VALUE                float(5,2) not null,
   primary key (COUPON_ID)
);



/*==============================================================*/
/* Table: REWARD                                                */
/*==============================================================*/
create table REWARD
(
   REWARD_ID            int not null,
   COUPON_ID            int not null,
   USERNAME             varchar(20) not null,
   VALID_START          date not null,
   VALID_END            date not null,
   USED_DATE            date,
   primary key (REWARD_ID)
);

alter table REWARD add constraint FK_REFERENCE_7 foreign key (USERNAME)
      references USER (USERNAME) on delete restrict on update restrict;

alter table REWARD add constraint FK_REFERENCE_8 foreign key (COUPON_ID)
      references COUPON_DICT (COUPON_ID) on delete restrict on update restrict;




/*==============================================================*/
/* Table: DELIVERY_SETTING                                      */
/*==============================================================*/
create table DELIVERY_SETTING
(
   BRANCH_ID            smallint not null,
   PROVIDABLE           boolean not null,
   FEE                  float(4,2),
   primary key (BRANCH_ID)
);

alter table DELIVERY_SETTING add constraint FK_REFERENCE_3 foreign key (BRANCH_ID)
      references BRANCH (BRANCH_ID) on delete restrict on update restrict;

      


/*==============================================================*/
/* Table: CATALOG_DICT                                          */
/*==============================================================*/
create table CATALOG_DICT
(
   CATALOG_ID           smallint not null,
   NAME                 varchar(20) not null,
   DESCRIPTION          varchar(200),
   primary key (CATALOG_ID)
);



/*==============================================================*/
/* Table: BRANCH_CATALOG                                        */
/*==============================================================*/
create table BRANCH_CATALOG
(
   ID                   int not null,
   BRANCH_ID            smallint not null,
   CATALOG_ID           smallint not null,
   primary key (ID)
);

alter table BRANCH_CATALOG add constraint FK_REFERENCE_1 foreign key (CATALOG_ID)
      references CATALOG_DICT (CATALOG_ID) on delete restrict on update restrict;

alter table BRANCH_CATALOG add constraint FK_REFERENCE_9 foreign key (BRANCH_ID)
      references BRANCH (BRANCH_ID) on delete restrict on update restrict;
      


/*==============================================================*/
/* Table: DISH_DICT                                             */
/*==============================================================*/
create table DISH_DICT
(
   DISH_ID              int not null,
   CATALOG_ID           smallint not null,
   NAME                 varchar(20) not null,
   DESCRIPTION          varchar(200),
   PICTURE_DIR          varchar(200),
   primary key (DISH_ID)
);

alter table DISH_DICT add constraint FK_REFERENCE_2 foreign key (CATALOG_ID)
      references CATALOG_DICT (CATALOG_ID) on delete restrict on update restrict;
      


/*==============================================================*/
/* Table: DISH                                                  */
/*==============================================================*/
create table DISH
(
   ID                   int not null,
   BRANCH_ID            smallint not null,
   DISH_ID              int not null,
   PRICE                float(5,2) not null,
   INVENTORY_QUANTITY   smallint not null,
   primary key (ID)
);

alter table DISH add constraint FK_REFERENCE_12 foreign key (BRANCH_ID)
      references BRANCH (BRANCH_ID) on delete restrict on update restrict;

alter table DISH add constraint FK_REFERENCE_13 foreign key (DISH_ID)
      references DISH_DICT (DISH_ID) on delete restrict on update restrict;
      


/*==============================================================*/
/* Table: "ORDER"                                               */
/*==============================================================*/
create table `ORDER`
(
   ORDER_ID             int not null,
   USERNAME             varchar(20) not null,
   BRANCH_ID            smallint not null,
   ORDER_TIME           date not null,
   TOTAL_PRICE          float(8,2) not null,
   IS_DELIVER           boolean not null,
   PICKUP_DELIVER_TIME  date,
   primary key (ORDER_ID)
);

alter table `ORDER` add constraint FK_REFERENCE_4 foreign key (BRANCH_ID)
      references BRANCH (BRANCH_ID) on delete restrict on update restrict;

alter table `ORDER` add constraint FK_REFERENCE_5 foreign key (USERNAME)
      references USER (USERNAME) on delete restrict on update restrict;
      


/*==============================================================*/
/* Table: ORDER_PAY_INFO                                        */
/*==============================================================*/
create table ORDER_PAY_INFO
(
   ORDER_ID             int not null,
   CARD_NUM             varchar(50) not null,
   CARD_TYPE            varchar(10) not null,
   CARDHOLDER_NAME      varchar(50) not null,
   EXPIRE_DATE          date not null,
   primary key (ORDER_ID)
);

alter table ORDER_PAY_INFO add constraint FK_REFERENCE_11 foreign key (ORDER_ID)
      references `ORDER` (ORDER_ID) on delete restrict on update restrict;
      


/*==============================================================*/
/* Table: DELIVERY_INFO                                         */
/*==============================================================*/
create table DELIVERY_INFO
(
   ORDER_ID             int not null,
   RECEIVER_NAME        varchar(20) not null,
   PHONE                char(12) not null,
   STREET               varchar(50) not null,
   CITY                 varchar(20) not null,
   STATE                varchar(20) not null,
   ZIPCODE              char(5) not null,
   primary key (ORDER_ID)
);

alter table DELIVERY_INFO add constraint FK_REFERENCE_10 foreign key (ORDER_ID)
      references `ORDER` (ORDER_ID) on delete restrict on update restrict;
      


/*==============================================================*/
/* Table: ORDER_DISH_DETAIL                                     */
/*==============================================================*/
create table ORDER_DISH_DETAIL
(
   ID                   int not null,
   ORDER_ID             int not null,
   DISH_ID              int not null,
   ORDER_QUANTITY       smallint not null,
   primary key (ID)
);

alter table ORDER_DISH_DETAIL add constraint FK_REFERENCE_14 foreign key (ORDER_ID)
      references `ORDER` (ORDER_ID) on delete restrict on update restrict;

alter table ORDER_DISH_DETAIL add constraint FK_REFERENCE_15 foreign key (DISH_ID)
      references DISH_DICT (DISH_ID) on delete restrict on update restrict;
      


/*==============================================================*/
/* Table: RATING                                                */
/*==============================================================*/
create table RATING
(
   ID                   int not null,
   USERNAME             varchar(20) not null,
   ORDER_ID             int not null,
   DISH_ID              int not null,
   SCORE                tinyint not null,
   TIMESTAMP            datetime not null,
   COMMENTS             varchar(200),
   primary key (ID)
);

alter table RATING add constraint FK_REFERENCE_16 foreign key (USERNAME)
      references USER (USERNAME) on delete restrict on update restrict;

alter table RATING add constraint FK_REFERENCE_17 foreign key (ORDER_ID)
      references `ORDER` (ORDER_ID) on delete restrict on update restrict;

alter table RATING add constraint FK_REFERENCE_18 foreign key (DISH_ID)
      references DISH_DICT (DISH_ID) on delete restrict on update restrict;
         
grant all on dos.* to 'dosuser'@'localhost';
