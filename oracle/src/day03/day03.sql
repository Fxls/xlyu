--from子句
select * from dept_xlyu;--查询所有列
-- as 使用别名，‘’不区分大小写，“”区分大小写
select empno as id ,ename "Name" ,sal * 12 "Annual Salary" from emp_xlyu;
--where子句,限制查询结果
select * from emp_xlyu where deptno = 10 ;
select ename,sal,job from emp_xlyu where job = 'salesman';
--select 子句，如果只查询表的部分列，需要在select后指定列名
select ename ,sal from emp_xlyu;
--查询条件，> < >= <= != = <>
select ename ,sal from emp_xlyu where sal <2000;
select ename,sal,job from emp_xlyu where deptno != 10;
--查询1982-1-1以后入职的员工
select * from emp_xlyu where hiredate > to_date('1982-1-1','yyyy-mm-dd');
--and，or关键字
--and，同时满足
select ename ,sal ,job from emp_xlyu where sal>1000 and job='clerk';
--or，满足其中一个条件
select ename ,sal ,job from emp_xlyu where sal>1000 or job='clerk';
-- like 查询 ，like条件（模糊查询）
--%表示0到多个字符
--_标识单个字符
--查询ename第二个字母为a的员工
select ename ,job from emp_xlyu where ename like '_A%';
--查询ename中含有a的员工
select ename,job from emp_xlyu where ename like '%a%';
--in, not in
-- 比较操作符，in用来取出符合列表范围中的数据
-- not in取出不符合此列表中的数据记录
--()表示集合，里面为集合元素
--查询职位是manager或clerk的员工
select ename ,job from emp_xlyu where job in ('manager','clerk');
--查询不是部门10或20的员工
select ename ,job,deptno from emp_xlyu where deptno not in (10,20);
--between...and.. 
select ename ,sal from emp_xlyu where sal between 1500 and 3000;
--is null ,is not null
--查询奖金数据为null的员工
select ename ,sal ,comm from emp_xlyu where comm is null ;
--查询奖金数据不为null的员工
select ename ,sal ,comm from emp_xlyu where comm is not null;
/*
>any   大于最小
<any   小于最大
>all   大于最大
<all   小于最小
*/
select * from emp_xlyu where sal >any(3500,4500,5000);
--基本数学运算
select * from emp_xlyu where (sal*12)>50000;
--distinct过滤重复
select deptno from emp_xlyu;
select distinct deptno from emp_xlyu; 
--order by 排序（对数据按一定规则进行排序操作）
select ename  ,deptno from emp_xlyu order by deptno;
--ASC升序、DESC降序(什么都不写默认是ASC升序)
select * from emp_xlyu where deptno =10 order by sal desc;
--多个列排序
select * from emp_xlyu order by deptno ASC ,sal desc;
--聚合函数
--min (字段)：统计准备数据中字段的最小值
--max （字段）：统计准备数据中字段的最大值
--avg （字段）：统计字段所有数据的平均值（数值类型）
--sum （字段）：统计字段所有数据的总和（数值类型）
--count （字段）:统计字段中所有数据非null值的个数
select max(sal) as max ,min(sal) as min from emp_xlyu;
--查询员工的平均薪水
select round(avg(sal)) from emp_xlyu;
--查询所有员工的薪水总和
select sum（sal） from emp_xlyu;
--求员工奖金平均值（非空约束）
select avg(nvl(comm,0)) from emp_xlyu;
--查询公司总共有多少员工
select count (comm) from emp_xlyu;
--聚合函数对空值处理（聚合函数忽略null值）
select avg(comm) avg_comm from emp_xlyu;
select avg(nvl(comm,0)) avg_comm from emp_xlyu;
--group by 字段：按照指定字段进行分组，总共分为多少组，就有多少条记录进行返回，每一组记录都只有一条返回记录
--select关键字后面，返回字段必须是group by 后面的字段或者是聚合函数（只有一条数据返回）
select deptno from emp_xlyu group by deptno;
-- 各个部门的最高薪水
select deptno ,max(sal) from emp_xlyu group by deptno;
-- 各个部门的平均薪水
select deptno,avg(sal) from emp_xlyu group by deptno;
--having：对group by分组之后的结果进行条件筛选
select deptno ,max(sal) from emp_xlyu group by deptno having max(sal)>=4000;
/*
笛卡尔积：两个表记录分别作拼接
select 字段 from 表1，表2；--表1，2做笛卡尔积
关联查询时，指定的字段通常要使用 表名.字段名，指定查询的字段是哪一个表中的
表名起别名，直接在表名后面使用表的别名
给表起别名的时候，不能使用as
*/
select E.Ename name,D.Deptno As no from emp_xlyu E,dept D;
select * from emp_xlyu e ,dept_xlyu d;
--等值连接
select e.ename , d.dname from emp_xlyu e,dept_xlyu d where e.deptno = d.deptno;
--内连接
select * from emp_xlyu e join dept_xlyu d on (e.deptno=d.deptno);
/*
外连接
主表 left [outer] job 从表
从表 right [outer] job 主表
*/
--左边主表，右边从表
select e.ename ,d.dname from emp_xlyu e left join dept_xlyu d on (e.deptno = d.deptno); 
--左边从表，右边主表
select e.ename ,d.dname from emp_xlyu e right join dept_xlyu d on (e.deptno = d.deptno);
--全外连接，没有主从表之分
select e.ename ,d.dname from emp_xlyu e full join dept_xlyu d on (e.deptno = d. deptno);
--自连接，数据的来源是一个表
select worker.empno w_empno,worker.ename w_ename,manager.empno m_empno,manager.ename m_ename from emp_xlyu worker join emp_xlyu manager on worker.mgr = manager.empno;





