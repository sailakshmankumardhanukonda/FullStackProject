DROP TABLE IF EXISTS EMPLOYEETRAINING;
  
CREATE TABLE EMPLOYEETRAINING (
  empid INT NOT NULL,
  courseid INT NOT NULL,
  score FLOAT,
  hoursspent INT NOT NULL,
  dateofcompletion DATE,
  status VARCHAR(50) NOT NULL, 
  PRIMARY KEY(empid,courseid)
);