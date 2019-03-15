create TABLE `hall` (
	`id` INT(11) NOT NULL AUTO_INCREMENT,
	`hall_name` VARCHAR(50) NOT NULL,
	`width` INT(11) NOT NULL,
	`height` INT(11) NOT NULL,
	PRIMARY KEY (`id`),
	UNIQUE INDEX `id` (`id`),
	UNIQUE INDEX `hall_name` (`hall_name`)
)
COLLATE='utf8mb4_0900_ai_ci'
ENGINE=InnoDB;