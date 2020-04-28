DROP DATABASE IF EXISTS shopping_app_frontend_db;
CREATE database shopping_app_frontend_db;
USE shopping_app_frontend_db;shopping_app_frontend_db
DROP TABLE if exists admin;
SHOW TABLES;
CREATE TABLE admin (
						admin_name VARCHAR(20) NOT NULL PRIMARY KEY,
							password VARCHAR(50) NOT NULL
						 );
SHOW TABLES;
INSERT INTO admin VALUES('admin', 'admin');
INSERT INTO admin VALUES('root', 'root');
SELECT * FROM admin;