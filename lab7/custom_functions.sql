USE `lab7_db` ;

DROP FUNCTION IF EXISTS FuncExperienceMoreAVG;
DELIMITER //
CREATE FUNCTION FuncExperienceMoreAVG() RETURNS FLOAT
	READS SQL DATA
BEGIN 
	RETURN (SELECT AVG(experince) FROM employee);
END //
DELIMITER ;
SELECT * FROM employee WHERE experince > FuncExperienceMoreAVG();


DROP FUNCTION IF EXISTS FuncGetStreetIDPharmacy;
DELIMiTER //
CREATE FUNCTION FuncGetStreetIDPharmacy(id int)
RETURNS VARCHAR(45)
READS SQL DATA
BEGIN
	RETURN (SELECT id_street FROM pharmacy WHERE id_pharmacy = id);
END //
DELIMITER ;
SELECT FuncGetStreetIDPharmacy(3) as pharmacy_street ;