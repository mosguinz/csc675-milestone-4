/**
*   Milestone4.sql
*
*   SQL File that creates and populates the Employee and Department tables.
*
*/


-- Employee table
SELECT * FROM Employee;
DROP TABLE works_in;
DROP TABLE Employee;
DROP TABLE paycheck;

CREATE TABLE IF NOT EXISTS Employee (
employee_id int auto_increment,
lname varchar(255),
fname varchar(255),
email varchar(255),
street_address varchar(255),
city varchar(255),
state varchar(255),
country varchar(255),
department_id int,
PRIMARY KEY (employee_id)
);

INSERT INTO Employee VALUES (null, "Smith", "John", "john@sfsu.edu", "123 Market Street", "SF", "CA", "USA", 101);
INSERT INTO Employee VALUES (null, "Doe", "John", "jdoe@sfsu.edu", "456 Mission Street", "SF", "CA", "USA", 101);
INSERT INTO Employee VALUES (null, "Doe", "Jane", "jane@sfsu.edu", "456 Mission Street", "Austin", "TX", "USA", 101);
INSERT INTO Employee VALUES (null, "Smith", "Jane", "jsmith", "456 Mission Street", "Austin", "TX", "USA", 104);

SELECT * FROM Employee;
SELECT * FROM Employee WHERE lName = '';

-- Department Table
SELECT * FROM Department;
DROP TABLE Department;
DROP TABLE WORKS_IN;
CREATE TABLE IF NOT EXISTS Department (
department_id int auto_increment,
dept_name varchar(45) DEFAULT NULL,
dept_street_address varchar(255),
dept_city varchar(255),
dept_state varchar(255),
dept_country varchar(255),
manager_id int DEFAULT NULL,
PRIMARY KEY (department_id)
);
 
insert into department values (101, "Engineering", "1 Center Street", "SJ", "CA", "USA", 2);
insert into department values (null, "Marketing", "56 Mission Street", "SF", "CA", "USA", 110);
insert into department values (null, "Sales", "12 Market Street", "SF", "CA", "USA", 987);
insert into department values (null, "Executive", "456 Mission Street", "Austin", "TX", "USA", 101);
 
-- Test table for SQL Injection tests
CREATE TABLE IMPORTANTTABLE (COL1 INT);
INSERT INTO IMPORTANTTABLE values (1);

SELECT * FROM Employee WHERE employee_id = 0; drop table importantTable;
select * from importanttable;


