-- 176. Second Highest Salary
select IF(count(distinct Salary)>1,min(t.Salary),null) SecondHighestSalary from 
(select Salary from Employee order by Salary desc limit 2) t;