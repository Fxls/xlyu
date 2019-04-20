create table ACCOUNT_XLYU(
  id number(9) NOT null,
  recommbnder_id number(9),
  login_name varchar2(30)not null,
  login_passwd varchar2(8) not null,
  status char(1),
  create_date date default sysdate,
  pause_date date ,
  close_date date,
  real_name varchar2(20) not null,
  idcard_no char(18) not null,
  birthdate date ,
  gender char(1) ,
  occupation varchar2(50),
  telephone varchar2(15) not null,
  email varchar2(50),
  mailaddress varchar2(50),
  zipcode char(6),
  qq varchar2(15),
  last_login_time date,
  last_login_ip varchar2(15)
);

desc account_xlyu;

rename account_xlyu to t_accout_xlyu;
alter table t_accout_xlyu add(
  bak varchar2(50)
);
desc t_accout_xlyu;
alter table t_accout_xlyu modify(
  bak varchar2(40) default 'login'
);
desc t_accout_xlyu;

alter table t_accout_xlyu drop(
  bak
);

insert into t_accout_xlyu(id,login_name,login_passwd,create_date,real_name,idcard_no,telephone) values(
  1,'shili','256528','28-1ÔÂ-08'£¬'shiyuanli','410381194302256523','13669351234'
);

update t_accout_xlyu set login_passwd = '801206'
where id  =  1;
select *  from  t_accout_xlyu;

