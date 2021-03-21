create database insurance;
use insurance;

create table t_user (
    id bigint auto_increment,
    create_time datetime not null ,
    modified_time datetime not null ,
    deleted boolean default 0 not null ,
    access_key bigint unique not null comment '业务id',
    user_name varchar(64) not null comment '用户名',
    login_name varchar(16) unique not null comment '登陆名',
    phone varchar(11) not null comment '电话号码',
    password varchar(64) not null comment '密码',
    input_time datetime not null comment '录入时间',
    rule int not null comment '角色',
    identity_number varchar(18) comment '身份证号',
    address varchar(18) comment '地址',
    age int comment '年龄',
    primary key(id)
) comment '用户表';


create table t_insurance (
    id bigint auto_increment,
    create_time datetime not null ,
    modified_time datetime not null ,
    deleted boolean default 0 not null ,
    access_key bigint unique not null comment '业务id',
    insurance_name varchar(64) not null comment '保险名',
    insurance_type int not null comment '保险类别',
    money decimal(18,2) not null comment '金额',
    input_time datetime not null comment '录入时间',
    input_user_id bigint not null comment '录入人',
    status int not null default 0 comment '使用状态 0:未启用 1：已启用',
    file_path varchar(255) comment '文件地址',
    primary key(id)
) comment '保险表';

create table t_policy (
     id bigint auto_increment,
     create_time datetime not null ,
     modified_time datetime not null ,
     deleted boolean default 0 not null ,
     access_key bigint unique not null comment '业务id',
     policy_name varchar(64) not null comment '保单名',
     input_time datetime not null comment '录入时间',
     insure_user_id bigint not null comment '投保人',
     benefit_user_id bigint not null comment '受益人',
     insurance_id bigint not null comment '保险id',
     duration integer not null comment '时长/月',
     file_path varchar(255) comment '文件地址',
     primary key(id)
) comment '保单表';
