DROP TABLE IF EXISTS EMPLOYEE;
  
CREATE TABLE EMPLOYEE (
  empid INT PRIMARY KEY,
  firstname VARCHAR(50) NOT NULL,
  middlename VARCHAR(50) NOT NULL,
  lastname VARCHAR(50) NOT NULL,
  dob DATE NOT NULL,
  city VARCHAR(50) NOT NULL
);

DROP TABLE IF EXISTS EMPLOYEECOURSE;


CREATE TABLE EMPLOYEECOURSE(
  courseid INT PRIMARY KEY,
  coursename VARCHAR(50) NOT NULL
);