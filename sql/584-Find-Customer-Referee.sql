/* Write your T-SQL query statement below */
SELECT CU.name FROM Customer AS CU
WHERE CU.referee_id is null OR CU.referee_id <> 2