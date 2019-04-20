/**
  第一题
 */
select job,length (job)from emp_xlyu order by job ;
--1、job中的数据按照字母升序排列
select ename||'earns$'||sal||' monthly but wants $'||sal*3 as "dream salary" from emp_xlyu;
--2、name拼接earns$加salary拼接monthly but wants$拼接三倍薪水
select empno,ename from emp_xlyu where upper(job) = 'clerk';
--3、从emp_xlyu提取job为clerk的字段empno，ename
select substr('doctor who',1,6)from dual;
--4、截取子字符串，提取结果doctor
select trim('半'from'半月二更半')as "上联" from dual;
--5、从'半月二更半'前后截去'半'，得到‘月二更’
select trim(leading '半'from'半月二更半') as "上联" from dual;
--6、月二更半
select trim(trailing '半'from'半月二更半')as "上联" from dual;
--7、半月二更
select lpad('tardis',10,'*')from dual;
--8、左补位，在tardis前补四位*
select lpad('tardis',3,'*')from dual;
--9、tar
select * from emp_xlyu where length (ename)=5;
--10、列举emp_xlyu中当ename长度为5的所有字段数据

/**
  第三题
 */
select ename,sal,round(sal*1.08)from emp_xlyu; 
--1、1.08倍的工资，然后对整数部分四舍五入
select mod(11,4)from dual;
--2、3（11除以4的余数为3）
select trunc(123.123,-1)from dual;
--3、120（小数点前一位截取数字）
select floor(sysdate-hiredate)as "入职时间"，ename from emp_xlyu;
--4、系统日期减去入职日期，取floor数，也就是小数点前的整数

/**
  第五题
 */
desc t_accout_xlyu ;
update t_accout_xlyu set login_passwd = '256528',create_date='02-3月-14' where id = 1;
select id,login_name,login_passwd,to_char(create_date,'yyyy"-"mm"-"dd'),real_name,idcard_no,telephone from t_accout_xlyu where id = 1;

/**
  第六题
 */
select to_char(systimestamp ,'yyyy"年"mm"月"dd"日" HH24"时"MI"分"SS"秒"')from dual;
select upper('name hiredate-review')from dual;

/**
  第七题
*/
select * from emp_xlyu where extract(year from hiredate)='1987';
--1、获取入职时间是1987年的所有字段数据
select ename,last_day(hiredate)from emp_xlyu;
--2、返会所有人的姓名和入职时间的所在月的最后一天
select next_day(sysdate ,7)from dual;
--3、下周六的时间27-4月-19
select ename,add_months(hiredate,3)from emp_xlyu;
--4、返回入职时间后的第三个月的时间
select ename ,months_between(sysdate,hiredate)from emp_xlyu;
--5、返回员工入职至现在月数（含小数）
select greatest(to_date('20070101','yyyymmdd'),hiredate)from emp_xlyu;
--6、比较2007-01-01和员工入职日期返回最大值，返回的都是01-1月-07

/**
  第八题
*/
create table customer_xlyu(
  cust_id number(4),
  cname varchar2(25),
  birthday date,
  account number
);
insert into customer_xlyu(cust_id,cname,birthday)values(
001,'李白','01-3月-75'
);
insert into customer_xlyu(cust_id,cname)values(
002,'杜甫'
);
insert into customer_xlyu(cust_id,cname)values(
003,'苏轼'
);
insert into customer_xlyu(cust_id,cname)values(
004,'李煜'
);
select * from customer_xlyu;
select * from customer_xlyu where birthday is null;

/**
  第九题
*/
select empno,ename,sal,nvl2(comm,comm,0),sal+nvl2(comm,comm,0)from emp_xlyu;

/**
  第十题
*/
select empno,ename,nvl2(hiredate,to_char(hiredate,'yyyy-mm-dd'),'not available')from emp_xlyu;