-- 181. Employees Earning More Than Their Managers

-- mysql
select t.Name as Employee 
from Employee t 
where t.Salary>(select e.Salary from Employee e where e.Id=t.ManagerId);