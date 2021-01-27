CREATE TABLE IF NOT EXISTS `arts` (
    `id` int unsigned NOT NULL AUTO_INCREMENT,
    `artist_id` int unsigned,
    `name` varchar(500),
    `status` varchar(20),
    `buyer` JSON,
    PRIMARY KEY(`id`),
    FOREIGN KEY (`artist_id`) REFERENCES `artists`(`id`)
);