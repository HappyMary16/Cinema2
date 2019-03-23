CREATE TABLE `genre` (
	`id` INT(11) NOT NULL AUTO_INCREMENT,
	`genre` VARCHAR(50) NOT NULL,
	PRIMARY KEY (`id`),
	UNIQUE INDEX `id` (`id`),
	UNIQUE INDEX `genre` (`genre`)
)
COLLATE='utf8mb4_0900_ai_ci'
ENGINE=InnoDB;

INSERT INTO genre(genre) VALUES('genre');