-- 627. Swap Salary

-- mysql

-- 1st
update salary set sex=IF(sex='m','f','m');

-- 2nd
update salary set sex=case sex when 'm' then 'f' when 'f' then 'm' end;