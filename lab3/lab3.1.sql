SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

CREATE SCHEMA IF NOT EXISTS `mydb` DEFAULT CHARACTER SET utf8 ;
USE `mydb` ;

DROP TABLE IF EXISTS `mydb`.`parking`;
DROP TABLE IF EXISTS `mydb`.`chain`;
DROP TABLE IF EXISTS `mydb`.`city`;
DROP TABLE IF EXISTS `mydb`.`district`;
DROP TABLE IF EXISTS `mydb`.`street_address`;
DROP TABLE IF EXISTS `mydb`.`enterprise`;
DROP TABLE IF EXISTS `mydb`.`parking_reservation`;
DROP TABLE IF EXISTS `mydb`.`user_card`;
DROP TABLE IF EXISTS `mydb`.`parking_story`;


CREATE TABLE IF NOT EXISTS `mydb`.`street_address` (
  `name` VARCHAR(40) NOT NULL,
  PRIMARY KEY (`name`))
ENGINE = InnoDB;

CREATE TABLE IF NOT EXISTS `mydb`.`district` (
  `name` VARCHAR(40) NOT NULL,
  PRIMARY KEY (`name`))
ENGINE = InnoDB;


CREATE TABLE IF NOT EXISTS `mydb`.`city` (
  `name` VARCHAR(40) NOT NULL,
  PRIMARY KEY (`name`))
ENGINE = InnoDB;

CREATE TABLE IF NOT EXISTS `mydb`.`chain` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


CREATE TABLE IF NOT EXISTS `mydb`.`parking` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `total_number` INT NOT NULL,
  `price_per_hour` INT NOT NULL,
  `street_address_name` VARCHAR(40) NOT NULL,
  `district_name` VARCHAR(40) NOT NULL,
  `city_name` VARCHAR(40) NOT NULL,
  `chain_id` INT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_parking_street_address1_idx` (`street_address_name` ASC) VISIBLE,
  INDEX `fk_parking_district1_idx` (`district_name` ASC) VISIBLE,
  INDEX `fk_parking_city1_idx` (`city_name` ASC) VISIBLE,
  INDEX `fk_parking_chain1_idx` (`chain_id` ASC) VISIBLE,
  CONSTRAINT `fk_parking_street_address1`
    FOREIGN KEY (`street_address_name`)
    REFERENCES `mydb`.`street_address` (`name`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_parking_district1`
    FOREIGN KEY (`district_name`)
    REFERENCES `mydb`.`district` (`name`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_parking_city1`
    FOREIGN KEY (`city_name`)
    REFERENCES `mydb`.`city` (`name`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_parking_chain1`
    FOREIGN KEY (`chain_id`)
    REFERENCES `mydb`.`chain` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


CREATE TABLE IF NOT EXISTS `mydb`.`enterprise` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;

CREATE TABLE IF NOT EXISTS `mydb`.`user_card` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `surname` VARCHAR(45) NOT NULL,
  `phone_number` INT NOT NULL,
  `enterprise_id` INT NULL,
  `regular_user` TINYINT NOT NULL,
  INDEX `fk_user_card_enterprise1_idx` (`enterprise_id` ASC) VISIBLE,
  PRIMARY KEY (`id`),
  CONSTRAINT `fk_user_card_enterprise1`
    FOREIGN KEY (`enterprise_id`)
    REFERENCES `mydb`.`enterprise` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

CREATE TABLE IF NOT EXISTS `mydb`.`parking_reservation` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `car_number` VARCHAR(8) NOT NULL,
  `time` TIME NOT NULL,
  `parking_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_parking_reservation_parking1_idx` (`parking_id` ASC) VISIBLE,
  CONSTRAINT `fk_parking_reservation_parking1`
    FOREIGN KEY (`parking_id`)
    REFERENCES `mydb`.`parking` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

CREATE TABLE IF NOT EXISTS `mydb`.`parking_story` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `parking_id` INT NOT NULL,
  `user_card_id` INT NOT NULL,
  `number_car` VARCHAR(8) NOT NULL,
  `action` VARCHAR(7) NOT NULL,
  `timestamp` DATETIME NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_parking_story_parking1_idx` (`parking_id` ASC) VISIBLE,
  INDEX `fk_parking_story_user_card1_idx` (`user_card_id` ASC) VISIBLE,
  CONSTRAINT `fk_parking_story_parking1`
    FOREIGN KEY (`parking_id`)
    REFERENCES `mydb`.`parking` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_parking_story_user_card1`
    FOREIGN KEY (`user_card_id`)
    REFERENCES `mydb`.`user_card` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

ALTER TABLE user_card ADD INDEX name_sadname(name, surname);
ALTER TABLE parking_story ADD INDEX car_action_timestamp(number_car, action, timestamp);
ALTER TABLE parking_story ADD INDEX parking_story_point(parking_id);

INSERT INTO `mydb`.`city` (`name`) VALUES ('Львів');
INSERT INTO `mydb`.`city` (`name`) VALUES ('Рівне');
INSERT INTO `mydb`.`city` (`name`) VALUES ('Тернопіль');
INSERT INTO `mydb`.`city` (`name`) VALUES ('Ужгород');
INSERT INTO `mydb`.`city` (`name`) VALUES ('Вінниця');
INSERT INTO `mydb`.`city` (`name`) VALUES ('Миколаїв ');
INSERT INTO `mydb`.`city` (`name`) VALUES ('Чернівці');
INSERT INTO `mydb`.`city` (`name`) VALUES ('Черкаси');
INSERT INTO `mydb`.`city` (`name`) VALUES ('Київ');
INSERT INTO `mydb`.`city` (`name`) VALUES ('Житомир');
INSERT INTO `mydb`.`city` (`name`) VALUES ('Харків');
INSERT INTO `mydb`.`city` (`name`) VALUES ('Луцьк');
INSERT INTO `mydb`.`city` (`name`) VALUES ('Одеса');

INSERT INTO `mydb`.`district` (`name`) VALUES ('Вінницький район');
INSERT INTO `mydb`.`district` (`name`) VALUES ('Жмеринський район');
INSERT INTO `mydb`.`district` (`name`) VALUES ('Тульчинський район');
INSERT INTO `mydb`.`district` (`name`) VALUES ('Ковельський район');
INSERT INTO `mydb`.`district` (`name`) VALUES ('Камянський район');
INSERT INTO `mydb`.`district` (`name`) VALUES ('Бердичівкький район');
INSERT INTO `mydb`.`district` (`name`) VALUES ('Ужгородський район');
INSERT INTO `mydb`.`district` (`name`) VALUES ('Мукачивський район');
INSERT INTO `mydb`.`district` (`name`) VALUES ('Калуський район');
INSERT INTO `mydb`.`district` (`name`) VALUES ('Кропивницький район');
INSERT INTO `mydb`.`district` (`name`) VALUES ('Стрийський район');
INSERT INTO `mydb`.`district` (`name`) VALUES ('Самбірський район');
INSERT INTO `mydb`.`district` (`name`) VALUES ('Старосамбірський район');
INSERT INTO `mydb`.`district` (`name`) VALUES ('Львівський район');
INSERT INTO `mydb`.`district` (`name`) VALUES ('Дрогобицький район');
INSERT INTO `mydb`.`district` (`name`) VALUES ('Новгород-Сіверський район');

INSERT INTO `mydb`.`street_address` (`name`) VALUES ('вул. Степана Бандери');
INSERT INTO `mydb`.`street_address` (`name`) VALUES ('вул. Богдана Хмельницького');
INSERT INTO `mydb`.`street_address` (`name`) VALUES ('вул. Нестора Літописця');
INSERT INTO `mydb`.`street_address` (`name`) VALUES ('вул. Академіка Корольва');
INSERT INTO `mydb`.`street_address` (`name`) VALUES ('вул. Берогова');
INSERT INTO `mydb`.`street_address` (`name`) VALUES ('вул. Богуна');
INSERT INTO `mydb`.`street_address` (`name`) VALUES ('вул. Василя Симоненка');
INSERT INTO `mydb`.`street_address` (`name`) VALUES ('вул. Стрийська');
INSERT INTO `mydb`.`street_address` (`name`) VALUES ('вул. Наукова');
INSERT INTO `mydb`.`street_address` (`name`) VALUES ('вул. Шевченка');
INSERT INTO `mydb`.`street_address` (`name`) VALUES ('вул. Чупринки');
INSERT INTO `mydb`.`street_address` (`name`) VALUES ('вул. Сахарова');
INSERT INTO `mydb`.`street_address` (`name`) VALUES ('вул. героїв УПА');
INSERT INTO `mydb`.`street_address` (`name`) VALUES ('вул. Жуковського');
INSERT INTO `mydb`.`street_address` (`name`) VALUES ('вул. Івана Котляревського');
INSERT INTO `mydb`.`street_address` (`name`) VALUES ('вул. Короленка');
INSERT INTO `mydb`.`street_address` (`name`) VALUES ('вул. Козацька');
INSERT INTO `mydb`.`street_address` (`name`) VALUES ('вул. Макарова');
INSERT INTO `mydb`.`street_address` (`name`) VALUES ('вул. Поліська');
INSERT INTO `mydb`.`street_address` (`name`) VALUES ('вул. Попова');

INSERT INTO `mydb`.`chain` (`name`) VALUES ('ТвійПаркінг');
INSERT INTO `mydb`.`chain` (`name`) VALUES ('ДімАвто');
INSERT INTO `mydb`.`chain` (`name`) VALUES ('MережаПаркінгівЛьвів');
INSERT INTO `mydb`.`chain` (`name`) VALUES ('Форум');
INSERT INTO `mydb`.`chain` (`name`) VALUES ('King Cross Leopolis');

INSERT INTO `mydb`.`parking` (`total_number`, `price_per_hour`, `street_address_name`, `district_name`, `city_name`, `chain_id`) VALUES ('150', '20', 'вул. Короленка', 'Калуський район', 'Київ', '2');
INSERT INTO `mydb`.`parking` (`total_number`, `price_per_hour`, `street_address_name`, `district_name`, `city_name`, `chain_id`) VALUES ('100', '30', 'вул. Макарова', 'Камянський район', 'Луцьк', '1');
INSERT INTO `mydb`.`parking` (`total_number`, `price_per_hour`, `street_address_name`, `district_name`, `city_name`, `chain_id`) VALUES ('50', '20', 'вул. Козацька', 'Ковельський район', 'Рівне', '1');
INSERT INTO `mydb`.`parking` (`total_number`, `price_per_hour`, `street_address_name`, `district_name`, `city_name`, `chain_id`) VALUES ('200', '30', 'вул. Наукова', 'Кропивницький район', 'Тернопіль', '3');
INSERT INTO `mydb`.`parking` (`total_number`, `price_per_hour`, `street_address_name`, `district_name`, `city_name`, `chain_id`) VALUES ('40', '30', 'вул. Нестора Літописця', 'Львівський район', 'Львів', '2');
INSERT INTO `mydb`.`parking` (`total_number`, `price_per_hour`, `street_address_name`, `district_name`, `city_name`, `chain_id`) VALUES ('35', '20', 'вул. Поліська', 'Львівський район', 'Львів', '3');
INSERT INTO `mydb`.`parking` (`total_number`, `price_per_hour`, `street_address_name`, `district_name`, `city_name`, `chain_id`) VALUES ('150', '30', 'вул. Попова', 'Мукачивський район', 'Ужгород', '3');
INSERT INTO `mydb`.`parking` (`total_number`, `price_per_hour`, `street_address_name`, `district_name`, `city_name`, `chain_id`) VALUES ('140', '20', 'вул. Сахарова', 'Львівський район', 'Львів', '2');
INSERT INTO `mydb`.`parking` (`total_number`, `price_per_hour`, `street_address_name`, `district_name`, `city_name`, `chain_id`) VALUES ('50', '25', 'вул. Степана Бандери', 'Старосамбірський район', 'Львів', '1');
INSERT INTO `mydb`.`parking` (`total_number`, `price_per_hour`, `street_address_name`, `district_name`, `city_name`, `chain_id`) VALUES ('70', '35', 'вул. Стрийська', 'Стрийський район', 'Одеса', '1');
INSERT INTO `mydb`.`parking` (`total_number`, `price_per_hour`, `street_address_name`, `district_name`, `city_name`, `chain_id`) VALUES ('60', '30', 'вул. Чупринки', 'Тульчинський район', 'Черкаси', '4');
INSERT INTO `mydb`.`parking` (`total_number`, `price_per_hour`, `street_address_name`, `district_name`, `city_name`, `chain_id`) VALUES ('30', '25', 'вул. Шевченка', 'Ужгородський район', 'Чернівці', '5');

INSERT INTO `mydb`.`parking_reservation` (`car_number`, `time`, `parking_id`) VALUES ('ВС8203FD', '13:30', '2');
INSERT INTO `mydb`.`parking_reservation` (`car_number`, `time`, `parking_id`) VALUES ('IO4342FS', '09:20', '3');
INSERT INTO `mydb`.`parking_reservation` (`car_number`, `time`, `parking_id`) VALUES ('RS3234DF', '18:40', '1');
INSERT INTO `mydb`.`parking_reservation` (`car_number`, `time`, `parking_id`) VALUES ('AA2323RT', '17:15', '3');
INSERT INTO `mydb`.`parking_reservation` (`car_number`, `time`, `parking_id`) VALUES ('IA3402ER', '23:00', '3');
INSERT INTO `mydb`.`parking_reservation` (`car_number`, `time`, `parking_id`) VALUES ('AC2344SD', '12:30', '5');
INSERT INTO `mydb`.`parking_reservation` (`car_number`, `time`, `parking_id`) VALUES ('AA3453RE', '11:10', '6');
INSERT INTO `mydb`.`parking_reservation` (`car_number`, `time`, `parking_id`) VALUES ('AA3266DR', '19:40', '8');
INSERT INTO `mydb`.`parking_reservation` (`car_number`, `time`, `parking_id`) VALUES ('BC9202HG', '02:10', '3');
INSERT INTO `mydb`.`parking_reservation` (`car_number`, `time`, `parking_id`) VALUES ('AA2342DG', '12:30', '1');
INSERT INTO `mydb`.`parking_reservation` (`car_number`, `time`, `parking_id`) VALUES ('DF3344DF', '12:00', '4');
INSERT INTO `mydb`.`parking_reservation` (`car_number`, `time`, `parking_id`) VALUES ('GF8430JF', '11:00', '6');
INSERT INTO `mydb`.`parking_reservation` (`car_number`, `time`, `parking_id`) VALUES ('FG3256HG', '13:00', '10');

INSERT INTO `mydb`.`enterprise` (`name`) VALUES ('EPAM');
INSERT INTO `mydb`.`enterprise` (`name`) VALUES ('SoftServe');
INSERT INTO `mydb`.`enterprise` (`name`) VALUES ('GlobalLogic');
INSERT INTO `mydb`.`enterprise` (`name`) VALUES ('Luxoft');
INSERT INTO `mydb`.`enterprise` (`name`) VALUES ('Ciklum');
INSERT INTO `mydb`.`enterprise` (`name`) VALUES ('DataArt');
INSERT INTO `mydb`.`enterprise` (`name`) VALUES ('Sigma Software');
INSERT INTO `mydb`.`enterprise` (`name`) VALUES ('ELEKS');

INSERT INTO `mydb`.`user_card` (`name`, `surname`, `phone_number`, `enterprise_id`, `regular_user`) VALUES ('Степан', 'Хомут', '380322335', '1', '0');
INSERT INTO `mydb`.`user_card` (`name`, `surname`, `phone_number`, `enterprise_id`, `regular_user`) VALUES ('Петро', 'Антоняк', '380423212', '4', '1');
INSERT INTO `mydb`.`user_card` (`name`, `surname`, `phone_number`, `enterprise_id`, `regular_user`) VALUES ('Світлана', 'Пилипчук', '380345435', '3', '1');
INSERT INTO `mydb`.`user_card` (`name`, `surname`, `phone_number`, `enterprise_id`, `regular_user`) VALUES ('Ольга', 'Сташко', '380535235', '4', '1');
INSERT INTO `mydb`.`user_card` (`name`, `surname`, `phone_number`, `enterprise_id`, `regular_user`) VALUES ('Антон', 'Наливайко', '380325234', '8', '0');
INSERT INTO `mydb`.`user_card` (`name`, `surname`, `phone_number`, `enterprise_id`, `regular_user`) VALUES ('Роман', 'Коваль', '380856652', '4', '1');
INSERT INTO `mydb`.`user_card` (`name`, `surname`, `phone_number`, `enterprise_id`, `regular_user`) VALUES ('Галя', 'Валькевич', '380235752', '5', '1');
INSERT INTO `mydb`.`user_card` (`name`, `surname`, `phone_number`, `enterprise_id`, `regular_user`) VALUES ('Орися', 'Винарчик', '380365856', '1', '0');
INSERT INTO `mydb`.`user_card` (`name`, `surname`, `phone_number`, `enterprise_id`, `regular_user`) VALUES ('Люба', 'Гірняк', '380237733', '2', '1');
INSERT INTO `mydb`.`user_card` (`name`, `surname`, `phone_number`, `enterprise_id`, `regular_user`) VALUES ('Роман', 'Цісінський', '380545782', '4', '0');
INSERT INTO `mydb`.`user_card` (`name`, `surname`, `phone_number`, `enterprise_id`, `regular_user`) VALUES ('Іван', 'Нагірний', '380654856', '5', '0');
INSERT INTO `mydb`.`user_card` (`name`, `surname`, `phone_number`, `enterprise_id`, `regular_user`) VALUES ('Степан', 'Скіряк', '380645654', '6', '0');
INSERT INTO `mydb`.`user_card` (`name`, `surname`, `phone_number`, `enterprise_id`, `regular_user`) VALUES ('Остап', 'Мусянович', '380125345', '3', '1');
INSERT INTO `mydb`.`user_card` (`name`, `surname`, `phone_number`, `enterprise_id`, `regular_user`) VALUES ('Сиверин', 'Хмельницький', '380235345', '5', '1');
INSERT INTO `mydb`.`user_card` (`name`, `surname`, `phone_number`, `enterprise_id`, `regular_user`) VALUES ('Роман', 'Верес', '380996754', '8', '0');
INSERT INTO `mydb`.`user_card` (`name`, `surname`, `phone_number`, `enterprise_id`, `regular_user`) VALUES ('Сергій', 'Марчук', '380345344', '1', '1');

INSERT INTO `mydb`.`parking_story` (`parking_id`, `user_card_id`, `number_car`, `action`, `timestamp`) VALUES ('2', '1', 'BC4930HG', 'arrived', '2021-10-12 09:10:10');
INSERT INTO `mydb`.`parking_story` (`parking_id`, `user_card_id`, `number_car`, `action`, `timestamp`) VALUES ('1', '2', 'DH7322TY', 'arrived', '2021-10-12 10:20:35');
INSERT INTO `mydb`.`parking_story` (`parking_id`, `user_card_id`, `number_car`, `action`, `timestamp`) VALUES ('4', '12', 'HF3488FD', 'arrived', '2021-10-12 12:05:18');
INSERT INTO `mydb`.`parking_story` (`parking_id`, `user_card_id`, `number_car`, `action`, `timestamp`) VALUES ('6', '3', 'FE3843DO', 'arrived', '2021-10-12 12:08:00');
INSERT INTO `mydb`.`parking_story` (`parking_id`, `user_card_id`, `number_car`, `action`, `timestamp`) VALUES ('1', '4', 'FJ9292DS', 'arrived', '2021-10-12 13:08:13');
INSERT INTO `mydb`.`parking_story` (`parking_id`, `user_card_id`, `number_car`, `action`, `timestamp`) VALUES ('3', '2', 'DH7322TY', 'leaved', '2021-10-12 12:30:40');
INSERT INTO `mydb`.`parking_story` (`parking_id`, `user_card_id`, `number_car`, `action`, `timestamp`) VALUES ('6', '1', 'BC4930HG', 'leaved', '2021-10-12 12:30:00');
INSERT INTO `mydb`.`parking_story` (`parking_id`, `user_card_id`, `number_car`, `action`, `timestamp`) VALUES ('12', '3', 'FE3843DO', 'leaved', '2021-10-12 13:21:00');
INSERT INTO `mydb`.`parking_story` (`parking_id`, `user_card_id`, `number_car`, `action`, `timestamp`) VALUES ('1', '7', 'HD2711SD', 'arrived', '2021-10-12 15:30:05');
INSERT INTO `mydb`.`parking_story` (`parking_id`, `user_card_id`, `number_car`, `action`, `timestamp`) VALUES ('9', '2', 'DH7322TY', 'arrived', '2021-10-12 15:30:00');
INSERT INTO `mydb`.`parking_story` (`parking_id`, `user_card_id`, `number_car`, `action`, `timestamp`) VALUES ('7', '7', 'HD2711SD', 'leaved', '2021-10-12 14:10:00');
INSERT INTO `mydb`.`parking_story` (`parking_id`, `user_card_id`, `number_car`, `action`, `timestamp`) VALUES ('4', '12', 'HF3488FD', 'leaved', '2021-10-12 15:37:43');
INSERT INTO `mydb`.`parking_story` (`parking_id`, `user_card_id`, `number_car`, `action`, `timestamp`) VALUES ('5', '15', 'HD1231SA', 'arrived', '2021-10-12 16:50:00');


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;