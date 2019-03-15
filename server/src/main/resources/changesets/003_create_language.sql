CREATE TABLE `language` (
	`id` INT(11) NOT NULL AUTO_INCREMENT,
	`language` VARCHAR(50) NOT NULL,
	PRIMARY KEY (`id`),
	UNIQUE INDEX `id` (`id`),
	UNIQUE INDEX `language` (`language`)
)
COLLATE='utf8mb4_0900_ai_ci'
ENGINE=InnoDB;