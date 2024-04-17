CREATE table products (
	id BIGINT AUTO_INCREMENT PRIMARY KEY,
	product_name VARCHAR(250) UNIQUE NOT NULL,
	price DOUBLE NOT NULL
 )

INSERT INTO products(product_name, price)
VALUES 
    (CONCAT('Product', FLOOR(RAND()*10000000)), RAND()*1000),
    (CONCAT('Product', FLOOR(RAND()*10000000)), RAND()*1000),
    (CONCAT('Product', FLOOR(RAND()*10000000)), RAND()*1000),
    (CONCAT('Product', FLOOR(RAND()*10000000)), RAND()*1000),
    (CONCAT('Product', FLOOR(RAND()*10000000)), RAND()*1000),
    (CONCAT('Product', FLOOR(RAND()*10000000)), RAND()*1000),
    (CONCAT('Product', FLOOR(RAND()*10000000)), RAND()*1000),
    (CONCAT('Product', FLOOR(RAND()*10000000)), RAND()*1000),
    (CONCAT('Product', FLOOR(RAND()*10000000)), RAND()*1000),
    (CONCAT('Product', FLOOR(RAND()*10000000)), RAND()*1000),
    (CONCAT('Product', FLOOR(RAND()*10000000)), RAND()*1000),
    (CONCAT('Product', FLOOR(RAND()*10000000)), RAND()*1000),
    (CONCAT('Product', FLOOR(RAND()*10000000)), RAND()*1000),
    (CONCAT('Product', FLOOR(RAND()*10000000)), RAND()*1000)
    
INSERT INTO products(product_name, price)
  (SELECT products.product_name, products.price FROM products)
  
  INSERT INTO products (product_name, price)
SELECT CONCAT('Product', id), RAND()*1000
FROM (
    SELECT ROW_NUMBER() OVER () AS id, product_name
    FROM products
) AS t

CREATE TABLE employees (
	id BIGINT AUTO_INCREMENT PRIMARY KEY,
  	FirstName VARCHAR(255),
  	LastName VARCHAR(255)
);

WITH a AS (
	SELECT *
	FROM user_role ur
	WHERE ur.user_id NOT IN (SELECT ur.user_id FROM user_role ur WHERE ur.role_id IN (1))
)

SELECT user_id FROM a


WITH a AS (
			SELECT *
			FROM user_role ur
			WHERE ur.role_id NOT IN(1)),
		b AS (
			SELECT * FROM a WHERE user_id NOT IN (SELECT user_id FROM a WHERE role_id = 2))
	
	SELECT u.*, b.role_id
	FROM b, users u
	WHERE b.user_id = u.user_id

-- Lấy thông tin về đơn hàng (Orders) cùng với tổng giá trị đơn hàng và tỷ lệ
-- giữa tổng giá trị và phí giao hàng
SELECT o.order_id, o.delivery_id, o.created_at,
		(SELECT SUM(price*quantity) FROM order_details od WHERE od.order_id = o.order_id) AS TotalPrice
FROM orders o 

WITH OrderToals AS (
		SELECT order_id, SUM(quantity*price) AS TotalPrice
		FROM order_details od
		GROUP BY od.order_id 
)
SELECT order_id, delivery_id, created_at, ot.TotalPrice,
	ot.TotalPrice/o.price AS Ratio
FROM orders o
JOIN OrderToals ot ON o.order_id = ot.order_id

CREATE TABLE categories (
    id INT PRIMARY KEY AUTO_INCREMENT,
    categories_name VARCHAR(100) UNIQUE
);


CREATE TABLE products (
    id INT PRIMARY KEY AUTO_INCREMENT,
    product_name VARCHAR(100) UNIQUE,
    price DOUBLE,
   categories_id INT ,
	FOREIGN KEY (`categories_id`) REFERENCES categories(id)
);

INSERT INTO categories (categories_name) VALUES
('Electronics'),
('Clothing'),
('Books')

INSERT INTO products (product_name, price, categories_id) 
VALUES 
    (CONCAT('Product', FLOOR(RAND()*10000000)), RAND()*1000, 1);

    




-- Tạo 1 triệu bản ghi mẫu
DELIMITER $$
CREATE PROCEDURE generate_data()
BEGIN
    DECLARE i INT DEFAULT 1;
    WHILE i <= 1000000 DO
        INSERT INTO products (product_name, price)
        VALUES (CONCAT('Product ', i), RAND() * 10000000);
        SET i = i + 1;
    END WHILE;
END $$
DELIMITER ;
CALL generate_data();

EXPLAIN SELECT * FROM products p WHERE p.product_name = 'Product 99999'

EXPLAIN EXTENDED SELECT * FROM products p WHERE p.price > (SELECT AVG(price) FROM products p)

