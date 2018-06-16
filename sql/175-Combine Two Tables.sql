-- 175. Combine Two Tables
-- mysql query
select p.FirstName FirstName,p.LastName LastName,a.City City, a.State State 
from Person p 
left outer join Address a on p.PersonId=a.PersonId