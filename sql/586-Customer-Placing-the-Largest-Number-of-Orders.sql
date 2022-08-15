/* Write your T-SQL query statement below */
SELECT TOP 1 V.customer_number AS 'customer_number' FROM
    (
        SELECT O.customer_number AS 'customer_number', COUNT(O.order_number) AS 'num'
        FROM Orders AS O
        GROUP BY O.customer_number
    ) AS V
ORDER BY V.num DESC