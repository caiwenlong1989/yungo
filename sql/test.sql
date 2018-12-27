
-- 抢购并发测试
TRUNCATE TABLE t_log_buy;
UPDATE t_product SET buy_count = 0, no_buy_count = count;

SELECT * FROM t_log_buy ORDER BY from_count DESC;
SELECT * FROM t_product;
