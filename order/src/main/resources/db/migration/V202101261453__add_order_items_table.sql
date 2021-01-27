CREATE TABLE IF NOT EXISTS `order_items` (
    `id` int unsigned NOT NULL AUTO_INCREMENT,
    `order_id` int unsigned,
    `art_id` int unsigned,
    `art_name` varchar(500),
    PRIMARY KEY(`id`),
    FOREIGN KEY (`order_id`) REFERENCES `orders`(`id`)
);