CREATE TABLE IF NOT EXISTS `artists` (
    `id` int unsigned NOT NULL AUTO_INCREMENT,
    `name` varchar(255),
    `bio` varchar(1000),
    PRIMARY KEY(`id`)
);