EXPLAIN  SELECT * FROM products p WHERE p.categories_id IN (SELECT c.id FROM categories c WHERE c.categories_name = 'Electronics' OR c.categories_name = 'Books')

EXPLAIN EXTENDED SELECT * FROM products p WHERE p.categories_id IN (SELECT c.id FROM categories c WHERE c.categories_name = 'Electronics')

EXPLAIN EXTENDED SELECT * FROM products p 
INNER JOIN categories c ON c.id = p.categories_id
WHERE c.categories_name = 'Electronics';

EXPLAIN SELECT * FROM products p 
INNER JOIN categories c ON c.id = p.categories_id
WHERE c.categories_name = 'Electronics' OR c.categories_name = 'Books';

EXPLAIN SELECT * FROM products p WHERE p.product_name = 'Product8480255593061684000000000000000000000000000000000000000000000000000';

CREATE INDEX idx_categories_id
ON products (categories_id);

CREATE INDEX idx_product_name
ON products (product_name);

ALTER TABLE products
DROP INDEX idx_product_name;

SELECT MONTH(created_at) AS month, SUM(total_price) AS total
FROM orders
WHERE YEAR(created_at) = YEAR(CURRENT_DATE())
GROUP BY MONTH(created_at);
