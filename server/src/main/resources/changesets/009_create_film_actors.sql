CREATE TABLE `film_actor` (
	`film_id` INT(11) NOT NULL,
	`actor_id` INT(11) NOT NULL,
	UNIQUE INDEX `film_id_actor_id` (`film_id`, `actor_id`),
	CONSTRAINT `film_actor` FOREIGN KEY (`film_id`) REFERENCES `film` (`id`) ON update CASCADE ON delete CASCADE,
	CONSTRAINT `actor_film` FOREIGN KEY (`actor_id`) REFERENCES `person` (`id`) ON update CASCADE ON delete CASCADE
)
COLLATE='utf8mb4_0900_ai_ci'
ENGINE=InnoDB
;