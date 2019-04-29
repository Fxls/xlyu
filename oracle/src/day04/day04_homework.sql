--1.1sales部门有哪些职位
select job from emp_xlyu where deptno =(select deptno from dept_xlyu where dname = 'sales');
--1.2哪些人不是别人的经理
select ename,job from emp_xlyu a where not exists(select 3 from emp_xlyu where mgr = a.empno);
--1.3谁的薪水比ford高，不考虑重名
select ename from emp_xlyu where sal>(select sal from emp_xlyu where ename = 'ford');
--1.4谁和ford同部门，列出名字（除去ford）
select ename from emp_xlyu where deptno =(select deptno from emp_xlyu where ename='ford')
and ename != 'ford';
--1.5哪个部门的人数比部门20的人多（求和比较）
select deptno ,count(1)from emp_xlyu group by deptno having count(1)>(select count(*)from emp_xlyu
where deptno =20);
--1.6 列出名字和职位，查询员工所在的部门平均薪水大于2000的员工信息
select ename ,job 
from emp_xlyu
where deptno in (select deptno from emp_xlyu
group by deptno
having avg(nvl(sal,0))>2000);
/*
2
where语句中为什么不能写rownum>...
答：
*/
--3
select *from (select a.*,rownum rn from 
(select * from news order by occurtime desc )a where rownum<=10)
where rn>=6;
--4
--ABD
--5
--给不同的job设置等级
--6.5

--6.6







