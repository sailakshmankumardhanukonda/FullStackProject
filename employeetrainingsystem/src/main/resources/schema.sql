DROP TABLE IF EXISTS EMPLOYEETRAINING;
  
CREATE TABLE EMPLOYEETRAINING (
  empid INT NOT NULL,
  courseid INT NOT NULL,
  score FLOAT NOT NULL,
  hoursspent INT NOT NULL,
  dateofcompletion DATE NOT NULL,
  status VARCHAR(50) NOT NULL, 
  PRIMARY KEY(empid,courseid)
);