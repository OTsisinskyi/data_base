CREATE SCHEMA IF NOT EXISTS `lab7_db` DEFAULT CHARACTER SET utf8 ;
USE `lab7_db` ;

DROP TABLE IF EXISTS `lab7_db`.`employee`;
DROP TABLE IF EXISTS `lab7_db`.`position`;
DROP TABLE IF EXISTS `lab7_db`.`pharmacy`;
DROP TABLE IF EXISTS `lab7_db`.`street`;
DROP TABLE IF EXISTS `lab7_db`.`listdrugs`;
DROP TABLE IF EXISTS `lab7_db`.`zoneinfluence`;
DROP TABLE IF EXISTS `lab7_db`.`listdrugszoneinfluencejoin`;
DROP TABLE IF EXISTS `lab7_db`.`pharmacylistdrugsjoin`;

CREATE TABLE IF NOT EXISTS Employee (
  `id_employee` INT NOT NULL AUTO_INCREMENT,
  `surname` VARCHAR(45) NOT NULL,
  `name` VARCHAR(45) NOT NULL,
  `midle_name` VARCHAR(45) NOT NULL,
  `idetity_number` CHAR(10) NOT NULL UNIQUE,
  `passport` CHAR(10) NOT NULL UNIQUE,
  `experince` DECIMAL(10,1) NOT NULL,
  `birthday_date` DATE NOT NULL,
  `position` VARCHAR(20) NOT NULL,
  `id_pharmacy` INT NOT NULL,
  PRIMARY KEY (`id_employee`))
ENGINE = InnoDB;

CREATE TABLE IF NOT EXISTS Position (
  `id_position` VARCHAR(30) NOT NULL,
  PRIMARY KEY (`id_position`))
ENGINE = InnoDB;


CREATE TABLE IF NOT EXISTS Pharmacy (
  `id_pharmacy` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `house_number` VARCHAR(45) NOT NULL,
  `web_page_address` VARCHAR(45) NOT NULL,
  `time_open` TIME NOT NULL,
  `time_close` TIME NOT NULL,
  `saturday` TINYINT NOT NULL,
  `sunday` TINYINT NOT NULL,
  `id_street` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id_pharmacy`))
ENGINE = InnoDB;


CREATE TABLE IF NOT EXISTS Street (
  `id_street` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id_street`))
ENGINE = InnoDB;


CREATE TABLE IF NOT EXISTS ListDrugs (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `ministry_code` VARCHAR(20) NOT NULL,
  `prescription_only` TINYINT NOT NULL,
  `narcotic` TINYINT NOT NULL,
  `psychotropic_drug` TINYINT NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


CREATE TABLE IF NOT EXISTS ZoneInfluence (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


CREATE TABLE IF NOT EXISTS ListDrugsZoneInfluencejoin (
  `id` INT NOT NULL AUTO_INCREMENT,
  `id_list_drugs` INT NOT NULL,
  `id_zone_influence` INT NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


CREATE TABLE IF NOT EXISTS PharmacyListDrugsJoin (
  `id` INT NOT NULL AUTO_INCREMENT,
  `id_pharmacy` INT NOT NULL,
  `id_list_drugs` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;

INSERT INTO employee (surname, name, midle_name, idetity_number, passport, experince, birthday_date, position, id_pharmacy) 
VALUES ('Хмельницький', 'Богдан', 'Михайлович', '1764987210', '3761987362', '3.4', '2000-04-13', 'касир', '1'),
	   ('Дорошенко', 'Петро', 'Степанович', '7539874610', '9734159871', '1.2', '2001-10-03', 'стажор', '1'),
	   ('Вишня', 'Остап', 'Іванович', '0761982782', '1073298716', '1.7', '2002-11-06', 'складмен', '1'),
       ('Сагайдачний', 'Петро', 'Остимович', '7539187362', '1028461827', '1.9', '2000-11-10', 'касир', '2'),
	   ('Наливайко', 'Назар', 'Миколайович', '3987619841', '2872610982', '0.5', '1995-01-22', 'стажор', '2'),
	   ('Шевченко', 'Тарас', 'Григорович', '2984001223', '8291873371', '0.0', '2003-05-05', 'складмен', '2');
       
INSERT INTO position (id_position) 
VALUES ('касир'),
	   ('стажор'),
	   ('складмен'),
       ('секретар');

      
INSERT INTO pharmacy (name, house_number, web_page_address, time_open, time_close, saturday, sunday, id_street) 
VALUES ('Подорожник', '13', 'https://podorozhnyk.com/', '00:00', '24:00', '1', '1', 'вул.Наукова'),
       ('Подорожник', '57', 'https://podorozhnyk.com/', '00:00', '24:00', '1', '1', 'вул.Княгині Ольги'),
       ('3i', '104', 'https://www.3i.com/', '07:00', '23:00', '1', '0', 'вул.Героїв Упа');
       
INSERT INTO street (id_street) 
VALUES ('вул.Наукова'),
	   ('вул.Княгині Ольги'),
	   ('вул.Героїв Упа');
       
INSERT INTO listdrugs (name, ministry_code, prescription_only, narcotic, psychotropic_drug)
VALUES ('Карвалол', '827346', '0', '0', '0'),
	   ('Парацетамол', '924628', '0', '0', '0'),
	   ('Морфін', '234473', '1', '1', '1');
       
INSERT INTO zoneinfluence (name)
VALUES ('серце'),
	   ('голова'),
	   ('нервова система');
       
       
INSERT INTO listdrugszoneinfluencejoin (id_list_drugs, id_zone_influence) 
VALUES ('1', '1'),
	   ('2', '2'),
	   ('3', '3');
       
INSERT INTO pharmacylistdrugsjoin (id_pharmacy, id_list_drugs) 
VALUES ('1', '1'),
	   ('1', '2'),
	   ('2', '2'),
       ('2', '3'),
	   ('1', '3');
