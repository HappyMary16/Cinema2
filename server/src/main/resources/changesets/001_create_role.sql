CREATE TABLE `role` (
	`id` INT(11) NOT NULL AUTO_INCREMENT,
	`role` VARCHAR(50) NOT NULL,
	PRIMARY KEY (`id`),
	UNIQUE INDEX `id` (`id`),
	UNIQUE INDEX `role` (`role`)
)
COLLATE='utf8mb4_0900_ai_ci'
ENGINE=InnoDB;

INSERT INTO role(role) VALUES('admin');
INSERT INTO role(role) VALUES('user');
INSERT INTO role(role) VALUES('director');
INSERT INTO role(role) VALUES('actor');