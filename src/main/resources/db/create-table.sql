use employee_db;

	CREATE TABLE `employee`(
		`employee_id` INT  NOT NULL  AUTO_INCREMENT,
		`firstname`  VARCHAR(45)  NOT NULL,
		`lastname` VARCHAR(45)  NOT NULL,
		`date_of_birth` DATE DEFAULT NULL,
		`email` VARCHAR(45) NOT NULL,
		`phonenumber` VARCHAR(45) NOT NULL,
		
	PRIMARY KEY(`employee_id`)
	
	)Engine=InnoDB;
