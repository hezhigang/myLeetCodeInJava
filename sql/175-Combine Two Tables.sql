-- 175. Combine Two Tables
-- mysql query
select p.FirstName FirstName,p.LastName LastName,a.City City, a.State State 
from Person p 
left outer join Address a on p.PersonId=a.PersonId

/* Write your T-SQL query statement below */
SELECT P.firstName AS 'firstName', P.lastName AS 'lastName', A.city AS 'city', A.state AS 'state'
FROM Person AS P
         LEFT OUTER JOIN Address AS A ON A.personId = P.personId