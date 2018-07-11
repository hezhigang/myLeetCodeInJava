-- 601. Human Traffic of Stadium

-- mysql
-- consecutive 按题意指的是id序号的连续性

select x.* from 
(
select a.* from 
(select s.* from stadium s where s.people>=100) a,
(
select s.* from stadium s where s.people>=100 
and exists(select 1 from stadium t2 where t2.people>=100 and t2.id=s.id-1) 
and exists(select 1 from stadium t3 where t3.people>=100 and t3.id=s.id+1)
) b 
where a.id=b.id-1  

union 

select s.* from stadium s where s.people>=100 
and exists(select 1 from stadium t2 where t2.people>=100 and t2.id=s.id-1) 
and exists(select 1 from stadium t3 where t3.people>=100 and t3.id=s.id+1)

union 

select c.* from 
(
select s.* from stadium s where s.people>=100 
and exists(select 1 from stadium t2 where t2.people>=100 and t2.id=s.id-1) 
and exists(select 1 from stadium t3 where t3.people>=100 and t3.id=s.id+1)
) b,
(select s.* from stadium s where s.people>=100) c
where c.id=b.id+1
) x order by x.id;

-- 这个不能通过leetcode运行
-- 显示没查出 [28,"2017-05-28",150],[29,"2017-05-29",150],[30,"2017-06-01",150]
-- 所以只能根据id的连续性判断，日期有可能不连续
select x.* from 
(
select a.* from 
(select s.* from stadium s where s.people>=100) a,
(
select s.* from stadium s where s.people>=100 
and exists(select 1 from stadium t2 where t2.people>=100 and t2.`date`=DATE_SUB(s.`date`,INTERVAL 1 DAY)) 
and exists(select 1 from stadium t3 where t3.people>=100 and t3.`date`=DATE_ADD(s.`date`,INTERVAL 1 DAY))
) b 
where a.`date`=DATE_SUB(b.`date`,INTERVAL 1 DAY) 

union 

select s.* from stadium s where s.people>=100 
and exists(select 1 from stadium t2 where t2.people>=100 and t2.`date`=DATE_SUB(s.`date`,INTERVAL 1 DAY)) 
and exists(select 1 from stadium t3 where t3.people>=100 and t3.`date`=DATE_ADD(s.`date`,INTERVAL 1 DAY))

union 

select c.* from 
(
select s.* from stadium s where s.people>=100 
and exists(select 1 from stadium t2 where t2.people>=100 and t2.`date`=DATE_SUB(s.`date`,INTERVAL 1 DAY)) 
and exists(select 1 from stadium t3 where t3.people>=100 and t3.`date`=DATE_ADD(s.`date`,INTERVAL 1 DAY))
) b,
(select s.* from stadium s where s.people>=100) c
where c.`date`=DATE_ADD(b.`date`,INTERVAL 1 DAY)
) x order by x.id;