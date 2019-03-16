create TABLE `seance` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `film_id` INT (11) NOT NULL,
  `hall_id` INT (11) NOT NULL,
  `price` INT (11) NOT NULL,
  `date_and_time` DATETIME,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `id` (`id`),

  CONSTRAINT `seance_film`
    FOREIGN KEY (`film_id`)
    REFERENCES `film` (`id`)
    ON delete CASCADE
    ON update CASCADE,

  CONSTRAINT `seance_hall`
    FOREIGN KEY (`hall_id`)
    REFERENCES `hall` (`id`)
    ON delete CASCADE
    ON update CASCADE
    )
COLLATE='utf8mb4_0900_ai_ci'
ENGINE=InnoDB;