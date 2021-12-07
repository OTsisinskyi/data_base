USE `lab7_db`;

DROP PROCEDURE IF EXISTS ProcedureParameterizedInsertEmployee;
DELIMITER //
CREATE PROCEDURE ProcedureParameterizedInsertEmployee(IN surname varchar(30), 
								   IN name varchar(30),
								   IN midle_name varchar(30), 
                                   IN identity_number char(10), 
                                   IN passport char(10), 
                                   IN experience decimal(10, 1), 
                                   IN birthday_date date, 
                                   IN position varchar(15), 
                                   IN id_pharmacy int)
BEGIN
	INSERT INTO employee(`surname`, `name`, `midle_name`, `idetity_number`, `passport`, `experince`, `birthday_date`, `position`, `id_pharmacy`) 
    VALUES (surname, name, midle_name, identity_number, passport, experience, birthday_date, position, id_pharmacy);
END//
DELIMITER ;
CALL ProcedureParameterizedInsertEmployee( 'Марчук', 'Микола', 'Степанович', '1234567890', '1224632154', '4.1', '2003-10-01', 'секретар', 1);


DROP PROCEDURE IF EXISTS InsertTenRowRandStreet;
DELIMITER //
CREATE PROCEDURE InsertTenRowRandStreet()
BEGIN
	DECLARE rand int;
    DECLARE count int;
    SET count = 0;
    while1: WHILE count != 1 DO
		SET rand = RAND()*10;
			while2: WHILE EXISTS((SELECT * FROM lab7_db.street WHERE id_street = CONCAT('Noname №', CAST(rand AS CHAR)))) DO
                SET rand = RAND()*10;
				END WHILE while2;
		SET count = count + 1;
		INSERT INTO street (id_street) VALUES (CONCAT('Noname №', CAST(rand AS CHAR)));
    END WHILE while1;
    SELECT * FROM street;
END//
DELIMITER ;

CALL InsertTenRowRandStreet();