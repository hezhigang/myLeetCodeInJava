-- 595. Big Countries

-- mysql

-- 1st
select name,population,area from World where area>3000000 or population>25000000;

-- 2nd
select name,population,area from World where area>3000000 
union 
select name,population,area from World where population>25000000;
