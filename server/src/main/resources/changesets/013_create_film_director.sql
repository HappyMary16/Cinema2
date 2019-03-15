CREATE TABLE `film_director` (
	`film_id` INT(11) NOT NULL,
	`director_id` INT(11) NOT NULL,
	UNIQUE INDEX `film_id_director_id` (`film_id`, `director_id`),
	CONSTRAINT `film_director` FOREIGN KEY (`film_id`) REFERENCES `film` (`id`) ON update CASCADE ON delete CASCADE,
	CONSTRAINT `director_film` FOREIGN KEY (`director_id`) REFERENCES `person` (`id`) ON update CASCADE ON delete CASCADE
)
COLLATE='utf8mb4_0900_ai_ci'
ENGINE=InnoDB
;