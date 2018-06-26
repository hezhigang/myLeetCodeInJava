-- 184. Department Highest Salary

-- mysql
select d.Name as Department,e.Name as Employee,t.Salary from Department d 
left outer join (select DepartmentId,Max(Salary) as Salary from Employee group by DepartmentId) t on d.Id=t.DepartmentId 
inner join Employee e on e.DepartmentId=t.DepartmentId and e.Salary=t.Salary 
order by t.Salary desc;