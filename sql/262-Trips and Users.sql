-- 262. Trips and Users

-- mysql

-- 1st
select b.Request_at as Day,round(IFNull(a.cancel_num,0)/b.total_num,2) as `Cancellation Rate` from 
(
select t.Request_at,count(*) as cancel_num from Trips t 
where t.Client_Id in (select Users_Id from Users where Role='client' and Banned='No') and 
t.Driver_Id in (select Users_Id from Users where Role='driver' and Banned='No') and 
t.Status in ('cancelled_by_driver','cancelled_by_client') and t.Request_at between DATE '2013-10-01' and DATE '2013-10-03' 
group by t.Request_at
) a right outer join 
(
select t.Request_at,count(*) as total_num from Trips t 
where t.Client_Id in (select Users_Id from Users where Role='client' and Banned='No') and 
t.Driver_Id in (select Users_Id from Users where Role='driver' and Banned='No') and t.Request_at between DATE '2013-10-01' and DATE '2013-10-03'  
group by t.Request_at
) b on b.Request_at=a.Request_at;

-- 2nd
select a.Request_at as Day,round(IFNull(b.cancel_num,0)/a.total_num,2) as `Cancellation Rate` from 
(
select t.Request_at,count(*) as total_num from Trips t 
where t.Client_Id in (select Users_Id from Users where Role='client' and Banned='No') and 
t.Driver_Id in (select Users_Id from Users where Role='driver' and Banned='No') and t.Request_at between DATE '2013-10-01' and DATE '2013-10-03'  
group by t.Request_at
) a left outer join 
(
select t.Request_at,count(*) as cancel_num from Trips t 
where t.Client_Id in (select Users_Id from Users where Role='client' and Banned='No') and 
t.Driver_Id in (select Users_Id from Users where Role='driver' and Banned='No') and 
t.Status in ('cancelled_by_driver','cancelled_by_client') and t.Request_at between DATE '2013-10-01' and DATE '2013-10-03' 
group by t.Request_at
) b on b.Request_at=a.Request_at;