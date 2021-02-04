CREATE TABLE IF NOT EXISTS `users` (
    `id` int unsigned NOT NULL AUTO_INCREMENT,
    `name` varchar(255),
    `email` varchar(255),
    `password` varchar(1000),
    PRIMARY KEY(`id`)
);