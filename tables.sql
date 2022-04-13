-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `mydb` ;

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `mydb` DEFAULT CHARACTER SET utf8 ;
USE `mydb` ;

-- -----------------------------------------------------
-- Table `mydb`.`passengers`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`passengers` ;

CREATE TABLE IF NOT EXISTS `mydb`.`passengers` (
  `Idpass` INT NOT NULL,
  `Family` VARCHAR(20) NULL,
  `Name` VARCHAR(20) NULL,
  `Passport` VARCHAR(20) NULL,
  `Sex` VARCHAR(5) NULL,
  PRIMARY KEY (`Idpass`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`timetable`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`timetable` ;

CREATE TABLE IF NOT EXISTS `mydb`.`timetable` (
  `Id` INT NOT NULL,
  `Number` VARCHAR(45) NULL,
  `Start Station` VARCHAR(45) NULL,
  `End Station` VARCHAR(45) NULL,
  `Date` VARCHAR(45) NULL,
  `Time of Depart` VARCHAR(45) NULL,
  `Time of Arrival` VARCHAR(45) NULL,
  `Price` INT NULL,
  PRIMARY KEY (`Id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`trains`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`trains` ;

CREATE TABLE IF NOT EXISTS `mydb`.`trains` (
  `Number` INT NOT NULL,
  `Type` VARCHAR(45) NULL,
  `NumbCupeTick` INT NULL,
  `NumbPlatzTick` INT NULL,
  PRIMARY KEY (`Number`))
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

-- -----------------------------------------------------
-- Data for table `mydb`.`passengers`
-- -----------------------------------------------------
START TRANSACTION;
USE `mydb`;
INSERT INTO `mydb`.`passengers` (`Idpass`, `Family`, `Name`, `Passport`, `Sex`) VALUES (1, 'Petrov', 'Ivan', 'AB20212', 'M');
INSERT INTO `mydb`.`passengers` (`Idpass`, `Family`, `Name`, `Passport`, `Sex`) VALUES (2, 'Ivanenko', 'Petro', 'AC24567', 'M');
INSERT INTO `mydb`.`passengers` (`Idpass`, `Family`, `Name`, `Passport`, `Sex`) VALUES (3, 'Sidorenko', 'Diana', 'DE34213', 'F');

COMMIT;


-- -----------------------------------------------------
-- Data for table `mydb`.`timetable`
-- -----------------------------------------------------
START TRANSACTION;
USE `mydb`;
INSERT INTO `mydb`.`timetable` (`Id`, `Number`, `Start Station`, `End Station`, `Date`, `Time of Depart`, `Time of Arrival`, `Price`) VALUES (1, '175', 'Dnepr', 'Sumy', '2022-03-05', '23:00', '08:00', 320);
INSERT INTO `mydb`.`timetable` (`Id`, `Number`, `Start Station`, `End Station`, `Date`, `Time of Depart`, `Time of Arrival`, `Price`) VALUES (2, '152', 'Kiev', 'Kharkov', '2022-03-04', '22:00', '07:00', 350);
INSERT INTO `mydb`.`timetable` (`Id`, `Number`, `Start Station`, `End Station`, `Date`, `Time of Depart`, `Time of Arrival`, `Price`) VALUES (3, '100', 'Kiev', 'Odessa', '2022-03-03', '21:30', '06:00', 300);

COMMIT;


-- -----------------------------------------------------
-- Data for table `mydb`.`trains`
-- -----------------------------------------------------
START TRANSACTION;
USE `mydb`;
INSERT INTO `mydb`.`trains` (`Number`, `Type`, `NumbCupeTick`, `NumbPlatzTick`) VALUES (175, 'Fast', 100, 200);
INSERT INTO `mydb`.`trains` (`Number`, `Type`, `NumbCupeTick`, `NumbPlatzTick`) VALUES (152, 'Fast', 150, 250);
INSERT INTO `mydb`.`trains` (`Number`, `Type`, `NumbCupeTick`, `NumbPlatzTick`) VALUES (100, 'Express', 100, 220);

COMMIT;
