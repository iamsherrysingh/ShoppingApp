DROP DATABASE IF EXISTS shopping_app_accounts_db;
CREATE database shopping_app_accounts_db;
USE shopping_app_accounts_db;
DROP TABLE if exists customer;
SHOW TABLES;
CREATE TABLE customer (
						customer_name VARCHAR(20) NOT NULL PRIMARY KEY,
							password VARCHAR(50) NOT NULL
						 );
SHOW TABLES;
INSERT INTO customer VALUES('Sherry', 'password');
INSERT INTO customer VALUES('Abhijot', 'password');
INSERT INTO customer VALUES('Gurkarman', 'password');
INSERT INTO customer VALUES('Ravinder', 'password');
INSERT INTO customer VALUES('Aman', 'password');
INSERT INTO customer VALUES('Harbans', 'password');
INSERT INTO customer VALUES('Jaspreet', 'password');
INSERT INTO customer VALUES('Kesar', 'password');
SELECT * FROM customer;