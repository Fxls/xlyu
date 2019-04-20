-- 注释
-- 声明NUMBER类型数据
--

create table student_xlyu(
  -- 声明数据表中的字段及类型   字段名 类型  ，字段名   类型   
  id number(4),
  name varchar2(20), --存储20个字节长度的可变字符串
  gender char(1),  --存储一个字节长度的固定字符串
  sal number(7,2)  --最后一个字段不要加逗号
);

create table student1_xlyu(
  id number(4),
  --varchar2节省空间
  name varchar2(20),
  --char查询效率高
  gender char(1),
  resience char(100)
);
create table student2_xlyu(
  id number(4),
  name varchar2(20),
  gender char(1),
  --存储日期类型 ，占用7个字节，默认显示格式   DD-MON-RR
  birth date
);

create table employee_xlyu(
  id number(4),
  name varchar2(20),
  gender char(1),
  birth date,
  salary number(6,2),
  job varchar2(30),
  deptno number(2)
);

desc employee_xlyu;
drop table employee_xlyu;
create table employee_xlyu(
  id number(4),
  name varchar2(20) NOT null,--name字段不能为null值（非空约束）
  gender char(1) default 'M',--向表中添加值，如果未添加，自动赋值为default类型，没有默认值时为null值
  birth date,
  salary number(6,2),
  job varchar2(30),
  deptno number(2)
);

rename employee_xlyu to myemp_xlyu;--修改表名字

--ALTER TABLE *** ADD(对表的修改---ADD增加列);
ALTER TABLE MYEMP_XLYU ADD(
  HIREDATE DATE default SYSDATE
);

--ALTER TABLE *** DROP(对表的修改---DROP删除列);
ALTER TABLE MYEMP_XLYU DROP(
  HIREDATE
);
DESC myemp_xlyu;

--ALTER TABLE *** MODIFY(对列修改);
ALTER TABLE MYEMP_XLYU MODIFY(
  JOB varchar2(40) DEFAULT 'AAA'
);
DESC myemp_xlyu;

INSERT INTO MYEMP_XLYU(ID,NAME,JOB,SALARY)VALUES(
  1001,'jack','boss',9999.99
);
INSERT INTO MYEMP_XLYU VALUES(
  1002,'xlyu','F','18-4月-19',10,'emp',11
);
