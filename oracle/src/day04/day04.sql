--子查询,括号内是子查询的结果
--1.0
select e.ename,e.job from emp_xlyu e where e.job = 
(select job from emp_xlyu where ename ='scott');--查找和scott相同职位的员工
--2.0
select deptno ,ename ,sal from emp_xlyu  where sal > 
(select avg(sal)from emp_xlyu);
--3.0
select empno,ename,job,sal,deptno from emp_xlyu
where deptno in (select deptno from emp_xlyu where job ='salesman')
and job <> 'salesman';
--4.0exists后边的子查询至少返回一行数据，则整个条件返回true
select deptno ,dname from dept_xlyu d where exists (select * from emp_xlyu e where d.deptno=e.deptno);
--5.0最低薪水高于部门30的最低薪水的部门信息
select deptno ,min(sal)min_sal from emp_xlyu group by deptno 
having min(sal)>(select min(sal)from emp_xlyu where deptno = 30);
--6.0子查询在from部分，这时子查询当做表来使用
select e.deptno ,e.ename,e.sal from emp_xlyu e,(select deptno ,avg(sal)avg_sal from emp_xlyu group by deptno)x
where e.deptno = x.deptno and e.sal>x.avg_sal order by e.deptno;
--7.0子查询在select部分
select e.ename ,e.sal,(select d.deptno from dept_xlyu d where d.deptno = e.deptno)deptno from emp_xlyu e;
--分页查询
--rownum：例，用于返回标志符行数据顺序的数字
--只能从1计数，不能从结果集中直接截取
select * from (select rownum rn,e.*from emp_xlyu e)where rn between 8 and 10;
select * from (select rownum rn ,t.*from (select empno,ename,sal from emp_xlyu  order by sal desc) t)
where rn between 8 and 10;
Select Rownum , Ename, Empno, Sal From Emp_xlyu Where Rownum >= 1 And Rownum <= 5;
--decode函数
--1.0
select ename ,job , sal ,decode (job ,'manager',sal*1.2,'analyst',sal*1.1,'salesman',sal*1.07,sal)bonus from emp_xlyu;
--2.0等价于decode
select ename ,job,sal , case job when 'manager' then sal *12 when 'analyst' then sal * 1.1 when 'salesman' then sal*1.05 else sal end bonus from emp_xlyu ;
--3.0
select decode(job,'analyst','vip','manager','vip','operation')job,count(1)job_cnt from emp_xlyu group by decode(job ,'analyst','vip','manager','vip','operation');
--4.0
select deptno ,dname,loc from dept_xlyu order by decode(dname ,'operations','accounting',2,'sales',3);
--排序函数
--row_number
--按照部门编码分组显示，每组内安之源编码排序，并赋予组内编码
select deptno,ename,empno, row_number() over (partition by deptno order by empno)as emp_id from emp_xlyu;
--rank()over (partition by col1 order by col2)
--根据col1分组，在分组内部根据col2给予等级标识，等级标识即排名，相同的数据返回相同排名
--跳跃排序，如果有相同数据，排名相同，有重复值
select deptno,ename,sal,comm ,rank()over(partition by deptno order by sal desc ,comm)"rank_id"from emp_xlyu;
--dense_rank()over (partition by col1 order by col2)
--表示根据col1分组，在分组内根据col2给与等级标识即排名，相同的数据返回相同排名
--连续排序，如果有并列第二，下一个排序将会是三，这一点和rank不同，rank是跳跃排序
select deptno ,ename,sal,comm,dense_rank()over(partition by deptno order by sal desc,comm asc)from emp_xlyu;
/*
集合操作
union 联合
union all 联合全部
intersect 交集
minus 差集
注意：多个结果集，字段个数必须相同，对应字段的数据类型必须一致
*/

--union 合集去重
select empno,ename,job,sal from emp_xlyu where job = 'manager'
union select empno ,ename,job,sal from emp_xlyu where sal >2500
--union all（保留重复部分，不排序）
select * from emp_xlyu where job = 'maager' 
union all
select * from emp_xlyu where sal>2500;
--intersect 去两个结果集中重复的数据
--minus 去两个结果集中重复的数据（前存在，后不存在）
select * from emp_xlyu where job = 'manager'
intersect 
select * from emp_xlyu where sal>2500;
select * from emp_xlyu where job = 'manager'
minus 
select * from emp_xlyu where sal<2500;

--高级分组函数
--rollup




















