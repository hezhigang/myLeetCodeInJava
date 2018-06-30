-- 185. Department Top Three Salaries
-- mysql
-- 参考了https://stackoverflow.com/questions/12113699/get-top-n-records-for-each-group-of-grouped-results
select d.Name as Department,e.Name as Employee,b.Salary as Salary from 
(
select a.DepartmentId,a.Salary from 
(
select t.DepartmentId,t.Salary,(@num:=if(@deptId = t.DepartmentId, @num +1, if(@deptId := t.DepartmentId, 1, 1))) as row_number from 
(
select distinct DepartmentId,Salary from Employee
) t 
CROSS JOIN (select @num:=0, @deptId:=null) c  
order by t.DepartmentId,t.Salary desc
) a 
where a.row_number<=3
) b 
left outer join Employee e using(DepartmentId,Salary) 
inner join Department d on e.DepartmentId=d.Id 
order by b.DepartmentId,b.Salary desc;