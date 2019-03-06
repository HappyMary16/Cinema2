CREATE TABLE `hall` (
	`id` INT(11) NOT NULL AUTO_INCREMENT,
	`name` VARCHAR(50) NOT NULL,
	`width` INT(11) NOT NULL,
	`height` INT(11) NOT NULL,
	PRIMARY KEY (`id`),
	UNIQUE INDEX `id` (`id`),
	UNIQUE INDEX `name` (`name`)
)
COLLATE='utf8mb4_0900_ai_ci'
ENGINE=InnoDB;