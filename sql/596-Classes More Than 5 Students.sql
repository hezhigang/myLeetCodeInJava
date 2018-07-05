-- 596. Classes More Than 5 Students

-- mysql

select t.`class` as `class` from 
(
select `class`,count(distinct student) as n from courses group by `class` having n>=5
) t;