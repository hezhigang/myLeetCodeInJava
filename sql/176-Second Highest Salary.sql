-- 176. Second Highest Salary
select IF(count(distinct Salary)>1,min(t.Salary),null) SecondHighestSalary from 
(select Salary from Employee order by Salary desc limit 2) t;

-- fine answer
select
(
select distinct Salary from Employee order by Salary desc limit 1,1
) AS SecondHighestSalary;

/* Write your T-SQL query statement below */
SELECT
    CASE
        WHEN COUNT(V.salary) > 1 THEN MIN(V.salary)
        ELSE NULL
        END AS 'SecondHighestSalary' FROM
    (
        SELECT TOP 2 SA.salary FROM
            (
                SELECT DISTINCT EM.salary
                FROM Employee AS EM
            ) AS SA
        ORDER BY SA.salary DESC
    ) AS V