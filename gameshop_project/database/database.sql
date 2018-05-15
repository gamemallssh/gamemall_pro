/**
* Author:aqin
* Date: 2018-05-11
* Desc: 创建商品、图片库及类别数据库表
*/

drop table if exists mm_goodstype;

/*==============================================================*/
/* Table: mm_goodstype                                          */
/*==============================================================*/
create table mm_goodstype
(
   gt_id                varchar(32) not null,
   gt_pid               varchar(32),
   gt_name              varchar(20),
   gt_desc              varchar(50),
   primary key (gt_id)
);
ALTER TABLE mm_goodstype ADD CONSTRAINT FK_owngoodstype FOREIGN KEY (gt_pid)
	  REFERENCES mm_goodstype (gt_id) on delete restrict on update restrict;

drop table if exists mm_goods;

/*==============================================================*/
/* Table: mm_goods                                              */
/*==============================================================*/
create table mm_goods
(
   goods_id             varchar(32) not null,
   gt_id                varchar(32) not null,
   goods_name           varchar(100),
   goods_memo           varchar(50),
   goods_publisher      varchar(50),
   goods_status         varchar(1),
   goods_price          decimal(8,2),
   goods_discount       decimal(2,1),
   goods_publishtime    datetime,
   goods_creator        varchar(50),
   primary key (goods_id)
);

alter table mm_goods add constraint FK_owngoods foreign key (gt_id)
      references mm_goodstype (gt_id) on delete restrict on update restrict;

drop table if exists mm_images;

/*==============================================================*/
/* Table: mm_images                                             */
/*==============================================================*/
create table mm_images
(
   image_uri            varchar(50) not null,
   goods_id             varchar(32) not null,
   primary key (image_uri, goods_id)
);

alter table mm_images add constraint FK_ownimages foreign key (goods_id)
      references mm_goods (goods_id) on delete restrict on update restrict;
