/**
  concat(char1,char2)字符串拼接，通常使||更方便快捷
 */
select concat(concat(ename,':'),sal) from emp_xlyu ;
select ename||':'||sal from emp_xlyu;
-- 返回字符串长度
select ename ,length(ename) from emp_xlyu;
-- upper 转换成大写 lower 转换成小写 initcap单词首字母大写
select upper ('good man ') , lower ('BADWOMAN'),initcap('why use r')
from dual;
/**
  trim（c2 from c1）从c1的前后截去c2
  ltrim（c1，c2）c1的左边截去c2
  rtrim（c1，c2）从c1的右边截去c2
  */
select trim (' 'from'  bangolufsen  ')as "T1",
       ltrim ('intel','i')as "T2",
       rtrim ('intel','i')as "T3" from dual;
/**
  lpad（char1，n，char2）左补位函数
  rpad（char1，n，char2）右补位函数
  用于在c1的左端或者右端用char2补足到n位
 */
select ename,lpad(sal,6,'%')as "salary" from emp_xlyu ;  
select ename,rpad(sal,6,'%')as "salary" from emp_xlyu ;
/**
  substr（char，m，n）获取子字符串，m=0从首字符开始，m取负数，从尾部开始
  如果没有设置n，或者n的长度超过了char的长度，则取到字符串末尾位置
 */
select substr('we do not talk anymore',0) from dual;
select substr('we do not talk anymore',0,9) from dual;
/**
 instr（char1，char2，n，m）
 从n的位置开始搜索，没有指定n，从第一个字符开始搜索
 m用于指定子串的第m出现的次数，如果不指定取消1
 如果在char1中没有找到子串char2，返回0
  */
select instr ('my heart will go on and on','on')as "words" from dual;
/**
  round（n，m）m大于0四舍五入到小数点后第m位，m小于0四舍五入到小数点前第m位，m取0值四舍五入到整数位
  trunc（n，m）n，m的定义和round相同，但是功能不同
 */
select round (45.678,-1)as "t1",round(45.678,0) as "t2",round(45.678,1)as "t3" from dual;
select trunc (45.678,-1)as "t1",trunc(45.678,0) as "t2",trunc(45.678,1)as "t3" from dual ;
-- 返回m除以n后的余数，n为0返回n
select ename ||'-'||sal,mod(sal,1000)from emp_xlyu;
/**
  ceil（n）天花板
  floor（n）地板
  if n=4.5，ceil（4.5）-》5；floor（4.5）-》4
 */
select ceil(45.3) from dual ;
select floor (45.3 )from dual ;
-- 入职天数
select ename||'-'||hiredate ,round (sysdate - hiredate )as "worktime"from emp_xlyu;
drop table test_xlyu; 
create table test_xlyu(
  c1 date,
  c2 timestamp
);
select sysdate from dual;

drop table student_xlyu;

-- sysdate返回当前的系统时间，精确到秒，默认显示格式DD-MON-RR
create table student_xlyu(
  id number (4),
  name char (20),
  registerDate date default sysdate
);
-- 内部函数，返回当前系统日期和时间，精确到毫秒
select systimestamp from dual;

--内部函数，返回系统时间，精确到毫秒
select to_char(systimestamp,'ss.ff')from dual;

--to_date将字符串按照定制格式转化内日期
--char眼珠那换的字符串
--fmt格式
--nlsparams指定日期语言
select ename||':'||hiredate from emp_xlyu where hiredate > to_date ('1979-01-01','yyyy-mm-dd');

--to_char将其他类型的数据转换成字符类型
select ename, to_char(hiredate,'yyyy"年"mm"月"dd"日"')from emp_xlyu;

--last_day 输出当前输入时间的月份的最后一天
select last_day(sysdate) from dual ;
select last_day('20-2月-09')from dual;

--add_months对输入日期的月份进行增加
select ename,add_months(hiredate,10*12)as "入职十周年" from emp_xlyu;

--计算连个日期之间相隔的月份months_between
select ename ,round(months_between(sysdate,hiredate))as "hiredate" from emp_xlyu;

--表示下周几（1-7表示日-六）next_day
select next_day(sysdate,4)as "next_wedn"from dual;

--least,greatest,比较日期，返回最大或最小，格式必须保持一致，可以有多个参数
select least(sysdate,'10-10月-08')from dual;
select greatest(sysdate,'10-10月-08')from dual;

--extract 提取时间分量（年、月、日）
select extract(year from sysdate)current_year from dual;
select extract(hour from timestamp '2008-10-10 10:10:10')from dual;

--null
select * from emp_xlyu where comm is null;
select * from emp_xlyu where comm is not null ;

--nvl2非空约束
select ename,sal,comm,nvl2(comm,sal+comm,sal)as "salary" from emp_xlyu;

