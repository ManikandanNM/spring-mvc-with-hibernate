DROP DATABASE IF EXISTS yogidb;
CREATE DATABASE yogidb;

USE yogidb;

DROP TABLE IF EXISTS STUDENT_DETAILS;

CREATE TABLE yogidb.STUDENT_DETAILS(
   studentId INT NOT NULL AUTO_INCREMENT,
   studentName VARCHAR(100) NOT NULL,
   studentAge INT,
   panNo VARCHAR(40),
   address VARCHAR(400),
   PRIMARY KEY ( studentId )
)DEFAULT CHARSET=utf8;


DROP TABLE IF EXISTS students;

CREATE TABLE yogidb.students(
   studentId INT NOT NULL AUTO_INCREMENT,
   studentName VARCHAR(100) NOT NULL,
   studentAge INT,
   panNo VARCHAR(40),
   address VARCHAR(400),
   PRIMARY KEY ( studentId )
)DEFAULT CHARSET=utf8;


INSERT INTO students ( studentName, studentAge, panNo, address) VALUES ( "ram1", 24, "abchd1", "address1ofram1");
INSERT INTO students ( studentName, studentAge, panNo, address) VALUES ( "ram2", 25, "abchd2", "address1ofram2");
INSERT INTO students ( studentName, studentAge, panNo, address) VALUES ( "ram3", 26, "abchd3", "address1ofram3");
INSERT INTO students ( studentName, studentAge, panNo, address) VALUES ( "ram4", 27, "abchd4", "address1ofram4");