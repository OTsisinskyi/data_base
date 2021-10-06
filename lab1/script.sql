-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `mydb` DEFAULT CHARACTER SET utf8 ;
USE `mydb` ;

-- -----------------------------------------------------
-- Table `mydb`.`city`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`city` (
  `name` VARCHAR(40) NOT NULL,
  PRIMARY KEY (`name`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb3;


-- -----------------------------------------------------
-- Table `mydb`.`district`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`district` (
  `name` VARCHAR(40) NOT NULL,
  PRIMARY KEY (`name`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb3;


-- -----------------------------------------------------
-- Table `mydb`.`enterprise`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`enterprise` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
AUTO_INCREMENT = 6
DEFAULT CHARACTER SET = utf8mb3;


-- -----------------------------------------------------
-- Table `mydb`.`street_address`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`street_address` (
  `name` VARCHAR(40) NOT NULL,
  PRIMARY KEY (`name`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb3;


-- -----------------------------------------------------
-- Table `mydb`.`parking`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`parking` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `total_number` INT NOT NULL,
  `price_per_hour` INT NOT NULL,
  `street_address_name` VARCHAR(40) NOT NULL,
  `district_name` VARCHAR(40) NOT NULL,
  `city_name` VARCHAR(40) NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_parking_street_address1_idx` (`street_address_name` ASC) VISIBLE,
  INDEX `fk_parking_district1_idx` (`district_name` ASC) VISIBLE,
  INDEX `fk_parking_city1_idx` (`city_name` ASC) VISIBLE,
  CONSTRAINT `fk_parking_city1`
    FOREIGN KEY (`city_name`)
    REFERENCES `mydb`.`city` (`name`),
  CONSTRAINT `fk_parking_district1`
    FOREIGN KEY (`district_name`)
    REFERENCES `mydb`.`district` (`name`),
  CONSTRAINT `fk_parking_street_address1`
    FOREIGN KEY (`street_address_name`)
    REFERENCES `mydb`.`street_address` (`name`))
ENGINE = InnoDB
AUTO_INCREMENT = 5
DEFAULT CHARACTER SET = utf8mb3;


-- -----------------------------------------------------
-- Table `mydb`.`free_parking_spaces`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`free_parking_spaces` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `index` VARCHAR(5) NOT NULL,
  `parking_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_free_parking_spaces_parking1_idx` (`parking_id` ASC) VISIBLE,
  CONSTRAINT `fk_free_parking_spaces_parking1`
    FOREIGN KEY (`parking_id`)
    REFERENCES `mydb`.`parking` (`id`))
ENGINE = InnoDB
AUTO_INCREMENT = 11
DEFAULT CHARACTER SET = utf8mb3;


-- -----------------------------------------------------
-- Table `mydb`.`parking_reservation`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`parking_reservation` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `car_number` VARCHAR(8) NOT NULL,
  `time` TIME NOT NULL,
  `parking_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_parking_reservation_parking1_idx` (`parking_id` ASC) VISIBLE,
  CONSTRAINT `fk_parking_reservation_parking1`
    FOREIGN KEY (`parking_id`)
    REFERENCES `mydb`.`parking` (`id`))
ENGINE = InnoDB
AUTO_INCREMENT = 7
DEFAULT CHARACTER SET = utf8mb3;


-- -----------------------------------------------------
-- Table `mydb`.`regular_user`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`regular_user` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `number_car` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
AUTO_INCREMENT = 6
DEFAULT CHARACTER SET = utf8mb3;


-- -----------------------------------------------------
-- Table `mydb`.`user_card`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`user_card` (
  `number_car` INT NOT NULL AUTO_INCREMENT,
  `entry_time` TIME NOT NULL,
  `parking_id` INT NOT NULL,
  `regular_user_id` INT NULL DEFAULT NULL,
  `enterprise_id` INT NULL DEFAULT NULL,
  PRIMARY KEY (`number_car`),
  INDEX `fk_user_parking1_idx` (`parking_id` ASC) VISIBLE,
  INDEX `fk_user_card_regular_user1_idx` (`regular_user_id` ASC) VISIBLE,
  INDEX `fk_user_card_enterprise1_idx` (`enterprise_id` ASC) VISIBLE,
  CONSTRAINT `fk_user_card_enterprise1`
    FOREIGN KEY (`enterprise_id`)
    REFERENCES `mydb`.`enterprise` (`id`),
  CONSTRAINT `fk_user_card_regular_user1`
    FOREIGN KEY (`regular_user_id`)
    REFERENCES `mydb`.`regular_user` (`id`),
  CONSTRAINT `fk_user_parking1`
    FOREIGN KEY (`parking_id`)
    REFERENCES `mydb`.`parking` (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb3;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
