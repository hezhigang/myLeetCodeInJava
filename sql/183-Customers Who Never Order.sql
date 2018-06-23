-- 183. Customers Who Never Order

-- mysql

-- by subquery
select c.Name as Customers from Customers c where c.Id not in 
(select distinct o.CustomerId from Orders o);

-- by outer join
select c.Name as Customers from Customers c
left outer join Orders o on c.Id=o.CustomerId 
where o.Id is null;