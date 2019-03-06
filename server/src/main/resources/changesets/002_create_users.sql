CREATE TABLE `user` (
	`id` INT(11) NOT NULL AUTO_INCREMENT,
	`first_name` VARCHAR(50) NOT NULL,
	`last_name` VARCHAR(50) NOT NULL,
	`login` VARCHAR(50) NOT NULL,
	`password` VARCHAR(50) NOT NULL,
	`phone` VARCHAR(50) NOT NULL,
	`email` VARCHAR(50),
	`role_id` INT(11) NOT NULL,
	PRIMARY KEY (`id`),
	UNIQUE INDEX `id` (`id`),
	UNIQUE INDEX `login` (`login`),
	UNIQUE INDEX `phone` (`phone`)
)
COLLATE='utf8mb4_0900_ai_ci'
ENGINE=InnoDB;