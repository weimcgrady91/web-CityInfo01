#create database db_cityInfo;

create table tb_type (
  type_sign int primary key auto_increment,
  type_name varchar(20),
  type_intro varchar(20)
);
create table tb_info (
  id int primary key auto_increment,
  info_type int ,
  info_title varchar(80),
  info_content varchar(100),
  info_linkman varchar(50),
  info_phone varchar(50),
  info_email varchar(50),
  info_date timestamp ,
  info_state varchar(1),
  info_payfor varchar(1),
  foreign key (info_type) references tb_type(type_sign)
);
create table tb_user (
  id int  primary key auto_increment,
  user_name varchar(20),
  user_password varchar(20)
);