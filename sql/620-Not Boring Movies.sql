-- 620. Not Boring Movies

-- mysql

-- 1st
select * from cinema where id%2=1 and description not like '%boring%' order by rating desc;

-- 2nd
select * from cinema where MOD(id,2)=1 and description not like '%boring%' order by rating desc;