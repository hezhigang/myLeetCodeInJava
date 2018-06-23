-- 182. Duplicate Emails

-- mysql
select t.Email as Email from 
(select Email,count(Email) from Person group by Email having count(Email)>1) t;