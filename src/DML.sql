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
VALUES ("Carla", "Avendano", "c.avendano@hotmail.com",56986196636);

INSERT INTO test.person(person_name, person_lastname, person_email, person_phone) 
VALUES ("Jhordany", "Polanco", "j.horda.ny@hotmail.com",18097892117);

/*Updating table: UPDATE tableName SET column = value WHERE condition [Parenthesis is optional]*/
UPDATE person SET person_phone = 18297892117 WHERE (person_id = 2);

