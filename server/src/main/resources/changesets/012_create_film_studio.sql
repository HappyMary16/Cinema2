CREATE TABLE `film_studio` (
	`film_id` INT(11) NOT NULL,
	`studio_id` INT(11) NOT NULL,
	UNIQUE INDEX `film_id_studio_id` (`film_id`, `studio_id`),
	CONSTRAINT `film_studio` FOREIGN KEY (`film_id`) REFERENCES `film` (`id`) ON update CASCADE ON delete CASCADE,
	CONSTRAINT `studio_film` FOREIGN KEY (`studio_id`) REFERENCES `studio` (`id`) ON update CASCADE ON delete CASCADE
)
COLLATE='utf8mb4_0900_ai_ci'
ENGINE=InnoDB
;