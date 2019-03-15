CREATE TABLE `film_genre` (
	`film_id` INT(11) NOT NULL,
	`genre_id` INT(11) NOT NULL,
	UNIQUE INDEX `film_id_genre_id` (`film_id`, `genre_id`),
	CONSTRAINT `film_genre` FOREIGN KEY (`film_id`) REFERENCES `film` (`id`) ON update CASCADE ON delete CASCADE,
	CONSTRAINT `genre_film` FOREIGN KEY (`genre_id`) REFERENCES `genre` (`id`) ON update CASCADE ON delete CASCADE
)
COLLATE='utf8mb4_0900_ai_ci'
ENGINE=InnoDB
;