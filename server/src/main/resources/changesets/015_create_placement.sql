create TABLE `placement` (
  `hall_id` INT (11) NOT NULL,
  `row_num` INT (11) NOT NULL,
  `column_num` INT (11) NOT NULL,
  INDEX `hall_placement_idx` (`hall_id` ASC) VISIBLE,
  CONSTRAINT `hall_placement`
    FOREIGN KEY (`hall_id`)
    REFERENCES `hall` (`id`)
    ON delete CASCADE
    ON update CASCADE
    )
COLLATE='utf8mb4_0900_ai_ci'
ENGINE=InnoDB;