-- 177. Nth Highest Salary

-- run on mysql-5.6.19
DROP FUNCTION IF EXISTS getNthHighestSalary;
DELIMITER $$

CREATE FUNCTION getNthHighestSalary(N INT) RETURNS INT 
DETERMINISTIC
BEGIN
  DECLARE fromRow INT;
  SET fromRow = N-1;
  RETURN (select (select distinct Salary from Employee order by Salary desc limit 1 offset fromRow));
END;
$$
delimiter ;

-- answer

CREATE FUNCTION getNthHighestSalary(N INT) RETURNS INT
BEGIN
  DECLARE fromRow INT;
  SET fromRow = N-1;
  RETURN (select (select distinct Salary from Employee order by Salary desc limit 1 offset fromRow));
END