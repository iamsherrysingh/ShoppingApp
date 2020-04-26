CREATE database shopping_app_accounts_db;
USE shopping_app_accounts_db;
DROP TABLE if exists user;
SHOW TABLES;
CREATE TABLE user (
						user_name VARCHAR(20) NOT NULL PRIMARY KEY,
							password VARCHAR(50) NOT NULL
						 );
SHOW TABLES;
INSERT INTO user VALUES('Sherry', 'password');
INSERT INTO user VALUES('Abhijot', 'password');
INSERT INTO user VALUES('Gurkarman', 'password');
INSERT INTO user VALUES('Ravinder', 'password');
INSERT INTO user VALUES('Aman', 'password');
INSERT INTO user VALUES('Harbans', 'password');
INSERT INTO user VALUES('Jaspreet', 'password');
INSERT INTO user VALUES('Kesar', 'password');
SELECT * FROM user;