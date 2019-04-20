drop table emp_xlyu;
create table emp_xlyu(
  empno number (4,0),
  ename varchar2(10),
  job varchar2(9),
  mgr number(4,0),
  hiredate date,
  sal number (7,2),
  comm number(7,2),
  deptno number(2,0)
);
desc emp_xlyu;
create table dept_xlyu(
  deptno number (2,0),
  dname varchar2(14),
  loc varchar2(13)
);
insert into emp_xlyu(empno,ename,job,mgr,hiredate,sal,deptno)values(
  7369,'smith','clerk',7902,'17-12月-80',800.00,20
);
insert into emp_xlyu(empno,ename,job,mgr,hiredate,sal,comm,deptno)values(
  7499,'allen','salesmen',7968,'20-2月-81',1600.00,300.00,30
);
insert into emp_xlyu(empno,ename,job,mgr,hiredate,sal,comm,deptno)values(
  7521,'ward','salesmen',7698,'22-2月-81',1250.00,500.00,30
);
insert into emp_xlyu(empno,ename,job,mgr,hiredate,sal,deptno)values(
  7566,'jones','manager',7839,'02-4月-81',2975.00,20
);
insert into emp_xlyu(empno,ename,job,mgr,hiredate,sal,comm,deptno)values(
  7654,'martin','salesmen',7698,'28-9月-81',1250.00,1400.00,30
);
insert into emp_xlyu(empno,ename,job,mgr,hiredate,sal,comm,deptno)values(
  7698,'blake','manger',7839,'01-5月-81',2850.00,0.00,30
);
insert into emp_xlyu(empno,ename,job,mgr,hiredate,sal,deptno)values(
  7782,'clark','manger',7839,'06-9月-81',2450.00,10
);
insert into emp_xlyu(empno,ename,job,mgr,hiredate,sal,deptno)values(
  7788,'scott','analyst',7566,'19-4月-87',3000.00,20
);
insert into emp_xlyu(empno,ename,job,hiredate,sal,deptno)values(
  7839,'king','president','17-11月-81',5000.00,30
);
insert into emp_xlyu(empno,ename,job,mgr,hiredate,sal,comm,deptno)values(
  7844,'turner','salesman',7698,'08-9月-81',1500.00,0.00,30
);
insert into emp_xlyu(empno,ename,job,mgr,hiredate,sal,deptno)values(
  7876,'adams','clerk',7788,'23-5月-87',1100.00,20
);
insert into emp_xlyu(empno,ename,job,mgr,hiredate,sal,deptno)values(
  7900,'james','clerk',7698,'03-12月-81',950.00,30
);
insert into emp_xlyu(empno,ename,job,mgr,hiredate,sal,deptno)values(
  7902,'ford','analyst',7566,'03-12月-81',3000.00,20
);
insert into emp_xlyu(empno,ename,job,mgr,hiredate,sal,deptno)values(
  7934,'miller','clerk',7782,'23-1月-82',1300.00,10
);
update emp_xlyu set comm = null  where ename = 'blake';
SELECT * FROM emp_xlyu;
insert into dept_xlyu(deptno,dname,loc)values(
  10,'accounting','new york'
);
insert into dept_xlyu(deptno,dname,loc)values(
  20,'research','dallas'
);
insert into dept_xlyu(deptno,dname,loc)values(
  30,'sales','chicago'
);
insert into dept_xlyu(deptno,dname,loc)values(
  40,'operations','boston'
);
select * from dept_xlyu;


