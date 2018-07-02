-- 196. Delete Duplicate Emails
-- mysql

-- 1st
delete p from Person as p, Person as t where p.Id>t.Id and p.Email=t.Email;

-- 2nd
delete p from Person as p inner join Person as t where p.Id>t.Id and p.Email=t.Email;