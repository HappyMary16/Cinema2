CREATE TABLE `country` (
	`id` INT(11) NOT NULL AUTO_INCREMENT,
	`country` VARCHAR(50) NOT NULL,
	PRIMARY KEY (`id`),
	UNIQUE INDEX `id` (`id`),
	UNIQUE INDEX `country` (`country`)
)
COLLATE='utf8mb4_0900_ai_ci'
ENGINE=InnoDB;

INSERT INTO country(country) VALUES('country');