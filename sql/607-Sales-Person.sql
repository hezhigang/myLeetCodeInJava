/* Write your T-SQL query statement below */
SELECT SP.name AS 'name' FROM SalesPerson AS SP
WHERE SP.sales_id NOT IN
      (
          SELECT O.sales_id FROM Company AS C
                                     JOIN Orders AS O ON O.com_id = C.com_id
          WHERE C.name = 'RED'
      )

/* Write your T-SQL query statement below */
SELECT SP.name AS 'name' FROM SalesPerson AS SP
                                  LEFT OUTER JOIN
                              (
                                  SELECT O.sales_id, O.order_id FROM Company AS C
                                                                         JOIN Orders AS O ON O.com_id = C.com_id
                                  WHERE C.name = 'RED'
                              ) AS V
                              ON SP.sales_id = V.sales_id
WHERE V.order_id IS NULL