USE `lab7_db`;

DROP TRIGGER IF EXISTS employee_INSERT;
DROP TRIGGER IF EXISTS employee_UPDATE;
DROP TRIGGER IF EXISTS position_DELETE;
DROP TRIGGER IF EXISTS pharmacy_INSERT;
DROP TRIGGER IF EXISTS pharmacy_UPDATE;
DROP TRIGGER IF EXISTS pharmacy_DELETE;
DROP TRIGGER IF EXISTS street_DELETE;
DROP TRIGGER IF EXISTS pharmacylistdrugsjoin_INSERT;
DROP TRIGGER IF EXISTS pharmacylistdrugsjoin_UPDATE;
DROP TRIGGER IF EXISTS pharmacylistdrugsjoin_DELETE;
DROP TRIGGER IF EXISTS listdrugspharmacyjoin_DELETE;
DROP TRIGGER IF EXISTS listdrugszoneinfluencejoin_INSERT;
DROP TRIGGER IF EXISTS listdrugszoneinfluencejoin_UPDATE;
DROP TRIGGER IF EXISTS listdrugszoneinfluencejoin_DELETE;
DROP TRIGGER IF EXISTS zoneinfluencelistdrugsjoin_DELETE;

DELIMITER //
CREATE TRIGGER employee_INSERT 
	BEFORE INSERT 
	ON employee FOR EACH ROW 
BEGIN
	IF (new.position NOT IN(SELECT id_position FROM position)) 
		THEN SIGNAL SQLSTATE '45000'
        SET MESSAGE_TEXT = "FK constraint. There is no such id_position in the table position";
	END IF;
    IF(new.id_pharmacy NOT IN (SELECT id_pharmacy FROM pharmacy))
		THEN SIGNAL SQLSTATE '45000'
        SET MESSAGE_TEXT = "FK constraint. There is no such id_pharmacy in the table pharmacy";
    END IF;
END //
DELIMITER ;

DELIMITER //
CREATE TRIGGER employee_UPDATE 
	BEFORE UPDATE
	ON employee FOR EACH ROW 
BEGIN
	IF (new.position NOT IN(SELECT id_position FROM position)) 
		THEN SIGNAL SQLSTATE '45000'
        SET MESSAGE_TEXT = "FK constraint. There is no such id_position in the table position";
	END IF;
     IF(new.id_pharmacy NOT IN (SELECT id_pharmacy FROM pharmacy))
		THEN SIGNAL SQLSTATE '45000'
        SET MESSAGE_TEXT = "FK constraint. There is no such id_pharmacy in the table pharmacy";
    END IF;
END //
DELIMITER ;

DELIMITER //
CREATE TRIGGER position_DELETE 
	BEFORE DELETE
	ON position FOR EACH ROW 
BEGIN
	IF (old.id_position IN(SELECT position FROM employee)) 
		THEN SIGNAL SQLSTATE '45000'
        SET MESSAGE_TEXT = "You cannot delete a row, it is used in the employee table";
	END IF;
END //
DELIMITER ;

DELIMITER //
CREATE TRIGGER pharmacy_INSERT 
	BEFORE INSERT
	ON pharmacy FOR EACH ROW 
BEGIN
	IF (new.id_street NOT IN(SELECT id_street FROM street)) 
		THEN SIGNAL SQLSTATE '45000'
        SET MESSAGE_TEXT = "FK constraint. There is no such id_street in the table street";
	END IF;
END //
DELIMITER ;

DELIMITER //
CREATE TRIGGER pharmacy_UPDATE
	BEFORE UPDATE
	ON pharmacy FOR EACH ROW 
BEGIN
	IF (new.id_street NOT IN(SELECT id_street FROM street)) 
		THEN SIGNAL SQLSTATE '45000'
        SET MESSAGE_TEXT = "FK constraint. There is no such id_street in the table street";
	END IF;
END //
DELIMITER ;

DELIMITER //
CREATE TRIGGER pharmacy_DELETE 
	BEFORE DELETE
	ON pharmacy FOR EACH ROW 
BEGIN
	IF (old.id_pharmacy IN (SELECT id_pharmacy FROM employee)) 
		THEN SIGNAL SQLSTATE '45000'
        SET MESSAGE_TEXT = "You cannot delete a row, it is used in the employee table";
	END IF;
END //
DELIMITER ;

DELIMITER //
CREATE TRIGGER street_DELETE 
	BEFORE DELETE
	ON street FOR EACH ROW 
BEGIN
	IF (old.id_street IN (SELECT id_street FROM pharmacy)) 
		THEN SIGNAL SQLSTATE '45000'
        SET MESSAGE_TEXT = "You cannot delete a row, it is used in the pharmacy table";
	END IF;
END //
DELIMITER ;

DELIMITER //
CREATE TRIGGER pharmacylistdrugsjoin_INSERT
	BEFORE INSERT
	ON pharmacylistdrugsjoin FOR EACH ROW 
BEGIN
	IF (new.id_pharmacy NOT IN (SELECT id_pharmacy FROM pharmacy)) 
		THEN SIGNAL SQLSTATE '45000'
        SET MESSAGE_TEXT = "FK constraint. There is no such id_pharmacy in the table pharmacy";
	END IF;
    IF (new.id_list_drugs NOT IN (SELECT id FROM listdrugs)) 
		THEN SIGNAL SQLSTATE '45000'
        SET MESSAGE_TEXT = "FK constraint. There is no such id in the table listdrugs";
	END IF;
END //
DELIMITER ;

DELIMITER //
CREATE TRIGGER pharmacylistdrugsjoin_UPDATE
	BEFORE UPDATE
	ON pharmacylistdrugsjoin FOR EACH ROW 
BEGIN
	IF (new.id_pharmacy NOT IN (SELECT id_pharmacy FROM pharmacy)) 
		THEN SIGNAL SQLSTATE '45000'
        SET MESSAGE_TEXT = "FK constraint. There is no such id_pharmacy in the table pharmacy";
	END IF;
    IF (new.id_list_drugs NOT IN (SELECT id FROM listdrugs)) 
		THEN SIGNAL SQLSTATE '45000'
        SET MESSAGE_TEXT = "FK constraint. There is no such id in the table listdrugs";
	END IF;
END //
DELIMITER ;

DELIMITER //
CREATE TRIGGER pharmacylistdrugsjoin_DELETE
	BEFORE DELETE
	ON pharmacy FOR EACH ROW 
BEGIN
	IF (old.id_pharmacy IN (SELECT id_pharmacy FROM pharmacylistdrugsjoin)) 
		THEN SIGNAL SQLSTATE '45000'
        SET MESSAGE_TEXT = "You cannot delete a row, it is used in the pharmacylistdrugsjoin table";
	END IF;
END //
DELIMITER ;

DELIMITER //
CREATE TRIGGER listdrugspharmacyjoin_DELETE
	BEFORE DELETE
	ON listdrugs FOR EACH ROW 
BEGIN
	IF (old.id IN (SELECT id_list_drugs FROM pharmacylistdrugsjoin)) 
		THEN SIGNAL SQLSTATE '45000'
        SET MESSAGE_TEXT = "You cannot delete a row, it is used in the pharmacylistdrugsjoin table";
	END IF;
END //
DELIMITER ;

DELIMITER //
CREATE TRIGGER listdrugszoneinfluencejoin_INSERT
	BEFORE INSERT
	ON listdrugszoneinfluencejoin FOR EACH ROW 
BEGIN
	IF (new.id_list_drugs NOT IN (SELECT id FROM listdrugs)) 
		THEN SIGNAL SQLSTATE '45000'
        SET MESSAGE_TEXT = "FK constraint. There is no such id_list_drugs in the table listdrugs";
	END IF;
    IF (new.id_zone_influence NOT IN (SELECT id FROM zoneinfluence)) 
		THEN SIGNAL SQLSTATE '45000'
        SET MESSAGE_TEXT = "FK constraint. There is no such id in the table zoneinfluence";
	END IF;
END //
DELIMITER ;

DELIMITER //
CREATE TRIGGER listdrugszoneinfluencejoin_UPDATE
	BEFORE UPDATE
	ON listdrugszoneinfluencejoin FOR EACH ROW 
BEGIN
	IF (new.id_list_drugs NOT IN (SELECT id FROM listdrugs)) 
		THEN SIGNAL SQLSTATE '45000'
        SET MESSAGE_TEXT = "FK constraint. There is no such id_list_drugs in the table listdrugs";
	END IF;
    IF (new.id_zone_influence NOT IN (SELECT id FROM zoneinfluence)) 
		THEN SIGNAL SQLSTATE '45000'
        SET MESSAGE_TEXT = "FK constraint. There is no such id in the table zoneinfluence";
	END IF;
END //
DELIMITER ;

DELIMITER //
CREATE TRIGGER listdrugszoneinfluencejoin_DELETE
	BEFORE DELETE
	ON listdrugs FOR EACH ROW 
BEGIN
	IF (old.id IN (SELECT id_list_drugs FROM listdrugszoneinfluencejoin)) 
		THEN SIGNAL SQLSTATE '45000'
        SET MESSAGE_TEXT = "You cannot delete a row, it is used in the listdrugszoneinfluencejoin table";
	END IF;
END //
DELIMITER ;

DELIMITER //
CREATE TRIGGER zoneinfluencelistdrugsjoin_DELETE
	BEFORE DELETE
	ON zoneinfluence FOR EACH ROW 
BEGIN
	IF (old.id IN (SELECT id_zone_influence FROM listdrugszoneinfluencejoin)) 
		THEN SIGNAL SQLSTATE '45000'
        SET MESSAGE_TEXT = "You cannot delete a row, it is used in the listdrugszoneinfluencejoin table";
	END IF;
END //
DELIMITER ;





















