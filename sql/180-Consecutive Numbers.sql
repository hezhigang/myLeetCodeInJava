-- 180. Consecutive Numbers
-- mysql
-- https://dba.stackexchange.com/questions/189013/mysql-query-for-3-consecutive-integers-between-records
select distinct t.Num as ConsecutiveNums from Logs t
where exists (select 1 from Logs x where x.Id-1=t.Id and x.Num=t.Num) and 
exists(select 1 from Logs x where x.Id+1=t.Id and x.Num=t.Num);