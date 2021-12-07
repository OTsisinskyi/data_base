USE `lab7_db`;

DROP PROCEDURE IF EXISTS ProcCursorNamePharmacy;
DELIMITER //
CREATE PROCEDURE ProcCursorNamePharmacy()
BEGIN
	DECLARE done int DEFAULT FALSE;
    DECLARE pharmacy_name VARCHAR(45);
    
    DECLARE pharmacy_name_cursor CURSOR
    FOR SELECT pharmacy.name FROM pharmacy;
    
    DECLARE CONTINUE HANDLER FOR NOT FOUND SET done = true;
    SET @create_table = 'CREATE TABLE IF NOT EXISTS pharmacy_name(id INT AUTO_INCREMENT, name VARCHAR(45), PRIMARY KEY(id));';
		PREPARE create_query FROM @create_table;
		EXECUTE create_query;
    OPEN pharmacy_name_cursor;
    
    loop1: LOOP 
		FETCH pharmacy_name_cursor INTO pharmacy_name;
		IF done = TRUE THEN LEAVE loop1;
			END IF;
		SET @request = CONCAT('INSERT INTO pharmacy_name(name)VALUES(" ', pharmacy_name, ' ");');
			PREPARE create_query from @request;
			EXECUTE create_query;
    END LOOP loop1;
    DEALLOCATE PREPARE create_query;
	CLOSE pharmacy_name_cursor;
END //
DELIMITER ;

CALL ProcCursorNamePharmacy;