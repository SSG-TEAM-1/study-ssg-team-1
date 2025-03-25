WITH user_ch AS (
        SELECT COUNT(*) AS counta
        FROM USER_INFO
        WHERE JOINED LIKE "2021%"
)
SELECT
    YEAR(sales_date) AS YEAR
    , MONTH(sales_date) AS MONTH
    , COUNT(DISTINCT user_id) AS PURCHASED_USERS
    , ROUND((COUNT(DISTINCT user_id)) / counta, 1) AS PUCHASED_RATIO
FROM
    online_sale, user_ch
WHERE
    user_id IN (SELECT user_id
                FROM user_info
                WHERE joined LIKE "2021%")
GROUP BY
    YEAR, MONTH
ORDER BY
    YEAR ASC , MONTH ASC