CREATE TABLE IF NOT EXISTS `product` (
    `productId` int AUTO_INCREMENT  PRIMARY KEY,
     `productName` varchar(100) NOT NULL,
    `price` DOUBLE NOT NULL,
    `quantity` BIGINT NOT NULL,
    );