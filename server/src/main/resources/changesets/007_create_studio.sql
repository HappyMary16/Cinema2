CREATE TABLE `studio` (
	`id` INT(11) NOT NULL AUTO_INCREMENT,
	`studio` VARCHAR(50) NOT NULL,
	PRIMARY KEY (`id`),
	UNIQUE INDEX `id` (`id`),
	UNIQUE INDEX `studio` (`studio`)
)
COLLATE='utf8mb4_0900_ai_ci'
ENGINE=InnoDB;