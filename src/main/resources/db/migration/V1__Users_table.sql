CREATE TABLE IF NOT EXISTS users(
    userID TINYINT PRIMARY KEY AUTO_INCREMENT,
    fullName VARCHAR(255),
    email VARCHAR(255),
    password_hash VARCHAR(255),
    qualification VARCHAR(255),
	userStatus VARCHAR(15),
	campusID int
);
