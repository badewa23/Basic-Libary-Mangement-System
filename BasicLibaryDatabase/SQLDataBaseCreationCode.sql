-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema libary management system
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema libary management system
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `libary management system` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci ;
USE `libary management system` ;

-- -----------------------------------------------------
-- Table `libary management system`.`book`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `libary management system`.`book` (
  `BookID` INT NOT NULL AUTO_INCREMENT,
  `Title` VARCHAR(500) NOT NULL,
  `Author` VARCHAR(500) NULL DEFAULT NULL,
  `Publisher` VARCHAR(500) NULL DEFAULT NULL,
  `PublicationDate` VARCHAR(50) NULL DEFAULT NULL,
  `DateCreated` VARCHAR(50) NOT NULL,
  `DeweyDecNum` INT NULL DEFAULT NULL,
  PRIMARY KEY (`BookID`),
  UNIQUE INDEX `Title` (`Title` ASC) VISIBLE)
ENGINE = InnoDB
AUTO_INCREMENT = 8
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `libary management system`.`genres`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `libary management system`.`genres` (
  `GenreID` INT NOT NULL AUTO_INCREMENT,
  `Name` VARCHAR(50) NOT NULL,
  PRIMARY KEY (`GenreID`),
  UNIQUE INDEX `Name` (`Name` ASC) VISIBLE)
ENGINE = InnoDB
AUTO_INCREMENT = 8
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `libary management system`.`genres_has_book`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `libary management system`.`genres_has_book` (
  `genres_has_bookID` INT NOT NULL AUTO_INCREMENT,
  `GenreID` INT NOT NULL,
  `BookID` INT NOT NULL,
  PRIMARY KEY (`genres_has_bookID`),
  INDEX `GenreID_idx` (`GenreID` ASC) VISIBLE,
  INDEX `BookID_idx` (`BookID` ASC) VISIBLE,
  CONSTRAINT `BookID`
    FOREIGN KEY (`BookID`)
    REFERENCES `libary management system`.`book` (`BookID`),
  CONSTRAINT `GenreID`
    FOREIGN KEY (`GenreID`)
    REFERENCES `libary management system`.`genres` (`GenreID`))
ENGINE = InnoDB
AUTO_INCREMENT = 13
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `libary management system`.`users`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `libary management system`.`users` (
  `UserID` INT NOT NULL AUTO_INCREMENT,
  `Username` VARCHAR(20) NOT NULL,
  `Password` VARCHAR(20) NOT NULL,
  `Role` VARCHAR(20) NOT NULL,
  PRIMARY KEY (`UserID`),
  UNIQUE INDEX `Username` (`Username` ASC) VISIBLE)
ENGINE = InnoDB
AUTO_INCREMENT = 14
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
