CREATE TABLE IF NOT EXISTS `art_category` (
    `id` int unsigned NOT NULL AUTO_INCREMENT,
    `art_id` int unsigned,
    `category_id` int unsigned,
    PRIMARY KEY(`id`),
    FOREIGN KEY (`art_id`) REFERENCES `arts`(`id`),
    FOREIGN KEY (`category_id`) REFERENCES `categories`(`id`)
);