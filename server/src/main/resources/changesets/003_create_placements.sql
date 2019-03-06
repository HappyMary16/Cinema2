CREATE TABLE `placement` (
  `hall_id` INT (11) NOT NULL,
  `row` INT (11) NOT NULL,
  `column` INT (11) NOT NULL,
  INDEX `hall_placement_idx` (`hall_id` ASC) VISIBLE,
  CONSTRAINT `hall_placement`
    FOREIGN KEY (`hall_id`)
    REFERENCES `halls` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE
    )
COLLATE='utf8mb4_0900_ai_ci'
ENGINE=InnoDB;