-- Valentina Studio --
-- MySQL dump --
-- ---------------------------------------------------------


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
-- ---------------------------------------------------------


-- Dump data of "artists" ----------------------------------
BEGIN;

INSERT INTO `artists`(`id`,`name`,`bio`) VALUES 
( '1', 'Andy Warhol', 'Beginning out as a commercial artist, he brought the ethos of promotion into fine art, even going so far as to say, “Making money is art.” Such attitudes blew away the existential declarations of Abstract Expressionism. Although he’s recognized for captions such as Campbell’s Soup, Marilyn Monroe, and Elvis Presley, his greatest invention was himself.' ),
( '2', 'Pablo Picasso', 'Pablo Picasso is implicitly synonymous with modern art, and it doesn’t hurt that he fits the generally held image of the fugitive genius whose goals are balanced by a taste for living big. He turned the field of art history with radical innovations that include college and Cubism, which destroyed the stranglehold of representational material matter on art, and set the rate for other 20th-century artists' ),
( '3', 'Vincent van Gogh', 'Van Gogh is known for being psychologically unstable, but his arts are among the most popular and most famous artists of all time. Van Gogh’s technique of painting with flurries of thick brushstrokes made up of vivid colours squeezed straight from the tube would inspire subsequent generations of artists.' ),
( '4', 'Leonardo da Vinci', 'The original Renaissance Man, Leonardo is known as a genius, not only for masterpieces such as the Mona Lisa, The Last Supper and The Lady with an Ermine but also for his designs of technologies (aircraft, tanks, automobile) that were five hundred years in the future.' ),
( '5', 'Michelangelo', 'Michelangelo was a triple threat: A painter (the Sistine Ceiling), a sculptor (the David and Pietà) and architect (St. Peter’s Basilica in Rome). Make that a quadruple warning since he also wrote poetry. Aside from the aforementioned Sistine Ceiling, St. Peter’s Basilica and Pietà, there was his tomb for Pope Julian II and the design for the Laurentian Library at San Lorenzo’s Church.' ),
( '6', 'Henri Matisse', 'No artist is as intimately attached to the delights of colour as Henri Matisse. His work was all about twisted curves rooted in the ideas of symbolic art and was constantly concentrated on the beguiling satisfaction of colour and tone.' ),
( '7', 'Jackson Pollock', 'Hindered by addiction, self-doubt, and awkwardness as a conventional painter, Pollock transformed his faults in a short but intense period between 1947 and 1950 when he performed the drip ideas that connected his fame. Avoiding the easel to lay his paintings flat on the floor, he used house paint right from the can, throwing and dropping thin skeins of pigment that left behind a solid record of his movements.' );
COMMIT;
-- ---------------------------------------------------------


-- Dump data of "arts" -------------------------------------
BEGIN;

INSERT INTO `arts`(`id`,`artist_id`,`name`,`status`,`buyer`) VALUES 
( '1', '1', 'Campbell\'s Soup Cans', NULL, NULL ),
( '2', '1', 'Marilyn Diptych', NULL, NULL ),
( '3', '1', 'Shot Marilyns', NULL, NULL ),
( '4', '2', 'Guernica', NULL, NULL ),
( '5', '2', 'Les Demoiselles d\'Avignon', NULL, NULL ),
( '6', '2', 'The Weeping Woman', NULL, NULL ),
( '7', '3', 'Van Gogh self-portrait', NULL, NULL ),
( '8', '3', 'Irises', NULL, NULL ),
( '9', '3', 'Road with Cypress and Star', NULL, NULL ),
( '10', '4', 'Mona Lisa', NULL, NULL ),
( '11', '4', 'The Last Supper', NULL, NULL ),
( '12', '6', 'Le bonheur de vivre', NULL, NULL ),
( '13', '6', 'Woman with a Hat', NULL, NULL ),
( '14', '7', 'Blue Poles', NULL, NULL );
COMMIT;
-- ---------------------------------------------------------


-- Dump data of "categories" -------------------------------
BEGIN;

INSERT INTO `categories`(`id`,`name`) VALUES 
( '1', 'American art' ),
( '2', 'Performance art' ),
( '3', 'Political art' ),
( '4', 'Nude art' ),
( '5', 'Modern art' ),
( '6', 'Portrait' ),
( '7', 'Christian art' ),
( '8', 'Abstract art' );
COMMIT;
-- ---------------------------------------------------------

-- Dump data of "art_category" -----------------------------
BEGIN;

INSERT INTO `art_category`(`id`,`art_id`,`category_id`) VALUES 
( '2', '1', '1' ),
( '3', '2', '1' ),
( '4', '3', '2' ),
( '5', '4', '3' ),
( '6', '5', '4' ),
( '7', '6', '3' ),
( '8', '7', '5' ),
( '9', '8', '5' ),
( '10', '9', '5' ),
( '11', '10', '6' ),
( '12', '11', '7' ),
( '13', '12', '5' ),
( '14', '13', '5' ),
( '15', '14', '8' );
COMMIT;
-- ---------------------------------------------------------


/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
-- ---------------------------------------------------------


