CREATE TABLE `film` (
	`id` INT(11) NOT NULL AUTO_INCREMENT,
	`title` VARCHAR(50) NOT NULL,
	`description` VARCHAR(250) NOT NULL,
	`year` INT(11) NOT NULL,
	`min_age` INT(11) NOT NULL,
	`duration` TIME NOT NULL,
	`film_language_id` INT(11) NOT NULL,
	`first_seance` DATE NOT NULL,
	`last_seance` DATE NOT NULL,
	`small_poster` VARCHAR(100) NOT NULL,
	`big_poster` VARCHAR(100) NOT NULL,
	`trailer_link` VARCHAR(100) NOT NULL,
	PRIMARY KEY (`id`),
	UNIQUE INDEX `id` (`id`)
)
COLLATE='utf8mb4_0900_ai_ci'
ENGINE=InnoDB;