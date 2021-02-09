create database insurance;
use insurance;

create table t_customer (
    id bigint auto_increment,
    create_time datetime not null ,
    modified_time datetime not null ,
    deleted boolean default 0 not null ,
    access_key bigint unique not null comment '业务id',
    customer_name varchar(64) not null comment '客户名称',
    login_name varchar(16) unique not null comment '登陆名',
    password varchar(64) not null comment '密码',
    phone varchar(11) not null comment '电话号码',
    certification boolean default 0 not null comment '是否认证通过 0未通过 1已通过',
    certification_time datetime comment '认证时间',
    primary key(id)
) comment '客户表';

create table t_customer_certification_info (
   id bigint auto_increment,
   create_time datetime not null ,
   modified_time datetime not null ,
   deleted boolean default 0 not null ,
   access_key bigint unique not null comment '业务id',
   customer_id bigint unique not null comment '客户id',
   name varchar(10) not null comment '姓名',
   birthday datetime not null comment '生日',
   identity_number varchar(18) not null comment '身份证号',
   identity_positive varchar(255) not null comment '身份证正面',
   identity_reverse varchar(255) not null comment '身份证反面',
   take_identity_image varchar(255) not null comment '手持身份证图',
   primary key(id)
)comment '客户认证信息表';

