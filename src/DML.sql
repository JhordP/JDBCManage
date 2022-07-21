CREATE SCHEMA test; /*Or CREATE DATABASE*/

USE test; /*DATABASE USING AT THIS MOMENT*/

/*TO CREATE THE TABLE*/
CREATE TABLE person(
person_id INT NOT NULL auto_increment, /*ColumnName DataTypes*/
person_name VARCHAR(10),
person_lastname VARCHAR(10),
person_email VARCHAR(25),
person_phone LONG,
PRIMARY KEY(person_id)); /*Primary Key is declared after the columns pointing the PK Column as argument.*/

/*NOTE: When you use the table reference name you can use just the name or database.tableName*/
DROP TABLE person; /*To delete the table.*/

SELECT * FROM test.person; /*Select columns from table, you can use WHERE condition*/

/*Inserting values into table: INSERT INTO tableName(columns...) VALUES (values...)*/
INSERT INTO test.person(person_name, person_lastname, person_email, person_phone) 
VALUES ("Name", "Lastname", "Email",9999999999);

INSERT INTO test.person(person_name, person_lastname, person_email, person_phone) 
VALUES ("Name", "Lastname", "Email",9999999999);

/*Updating table: UPDATE tableName SET column = value WHERE condition [Parenthesis is optional]*/
UPDATE person SET person_phone = 18091112222 WHERE (person_id = 2);

/* User Administration / Login */

CREATE TABLE login (
id INT NOT NULL auto_increment,
username VARCHAR(15),
passw VARCHAR(50),
PRIMARY KEY(id)
);

SELECT * FROM login;

