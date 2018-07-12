-- 626. Exchange Seats

-- mysql

select * from 
(
select t1.id,t2.student from 
(select * from seat where id%2=1) t1 join 
(select * from seat where id%2=0) t2 on t1.id=t2.id-1 

union 

select IFNULL(t2.id,t1.id) as id,t1.student from 
(select * from seat where id%2=1) t1 left outer join 
(select * from seat where id%2=0) t2 on t1.id=t2.id-1
) t order by id;