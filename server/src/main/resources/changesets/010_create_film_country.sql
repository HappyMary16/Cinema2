CREATE TABLE `film_country` (
	`film_id` INT(11) NOT NULL,
	`country_id` INT(11) NOT NULL,
	UNIQUE INDEX `film_id_country_id` (`film_id`, `country_id`),
	CONSTRAINT `film_country` FOREIGN KEY (`film_id`) REFERENCES `film` (`id`) ON update CASCADE ON delete CASCADE,
	CONSTRAINT `country_film` FOREIGN KEY (`country_id`) REFERENCES `country` (`id`) ON update CASCADE ON delete CASCADE
)
COLLATE='utf8mb4_0900_ai_ci'
ENGINE=InnoDB
;