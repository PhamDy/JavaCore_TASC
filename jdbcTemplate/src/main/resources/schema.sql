CREATE TABLE IF NOT EXISTS `address` (
    `id` int AUTO_INCREMENT PRIMARY KEY,
    `city` varchar(100),
    `phone` VARCHAR(50)
);

CREATE TABLE IF NOT EXISTS `users` (
  `id` int AUTO_INCREMENT PRIMARY KEY,
  `address_id` int,
  `name` varchar(100),
    `age` int,
    FOREIGN KEY (`address_id`) REFERENCES address(id)
);