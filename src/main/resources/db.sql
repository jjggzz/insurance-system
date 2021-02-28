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

