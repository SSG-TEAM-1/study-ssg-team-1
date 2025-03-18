CREATE TABLE online_sale(
    online_sale_id INT,
    user_id INT,
    product_id INT,
    sales_amount INT,
    sales_date DATE
)ENGINE=INNODB;

INSERT INTO online_sale
VALUES  (1, 1, 3, 2, '2022-02-25'),
        (2, 1, 4, 1, '2022-03-01'),
        (4, 2, 4, 1, '2022-03-12'),
        (3, 1, 3, 3, '2022-03-31'),
        (5, 3, 5, 1, '2022-04-03'),
        (6, 2, 4, 1, '2022-04-06'),
        (2, 1, 4, 2, '2022-05-11');
        
        
SELECT
    user_id
    , product_id
FROM
    online_sale
GROUP BY
    user_id, product_id
HAVING
    COUNT(*) > 1
ORDER BY
    user_id, product_id DESC;