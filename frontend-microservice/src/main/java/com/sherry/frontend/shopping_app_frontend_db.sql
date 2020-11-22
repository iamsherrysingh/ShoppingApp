DROP DATABASE IF EXISTS shopping_app_frontend_db;
CREATE database shopping_app_frontend_db;
USE shopping_app_frontend_db;
DROP TABLE if exists user;
SHOW TABLES;
CREATE TABLE user (user_name VARCHAR(20) NOT NULL PRIMARY KEY,password VARCHAR(50) NOT NULL,active BOOL NOT NULL, role VARCHAR(30) NOT null	);
SHOW TABLES;
INSERT INTO user VALUES('admin', 'admin', 1, 'ADMIN');
INSERT INTO user VALUES('user', 'user', 1, 'USER');
INSERT INTO user VALUES('sherry', 'sherry', 1, 'USER,ADMIN');
SELECT * FROM user;