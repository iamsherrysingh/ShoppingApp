	DROP DATABASE IF EXISTS shopping_app_product_db;
	CREATE database shopping_app_product_db;
	USE shopping_app_product_db;
	DROP TABLE if exists product;
	SHOW TABLES;
	CREATE TABLE product (
							   id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
								product_name VARCHAR(50) NOT NULL,
								product_description VARCHAR(300) NOT NULL,
								product_image VARCHAR(150),
								price double NOT null
							 );
	SHOW TABLES;
	INSERT INTO product VALUES(1, 'Baseball Bat', 'Full size aluminum baseball bat', 'src\\main\\resources\\static\\ProductImages\\product_1.jpg', 79.99);
	INSERT INTO product VALUES(2, 'Network Switch', 'Gigabit Network Switch', 'src\\main\\resources\\static\\ProductImages\\product_2.jpg', 19.99);
	INSERT INTO product VALUES(3, 'CAT-5 Ethernet Cable', 'Gigabit Network Cable, 50 feet', 'src\\main\\resources\\static\\ProductImages\\product_3.jpg', 14.99);
	INSERT INTO product VALUES(4, 'Google Pixel 4XL', 'Snapdragon 855, 6GB RAM, 646GB', 'src\\main\\resources\\static\\ProductImages\\product_4.jpg', 1299.99);
	INSERT INTO product VALUES(5, 'Mug', '250 ml Coffee Mug', 'src\\main\\resources\\static\\ProductImages\\product_5.jpg', 3.99);
	SELECT * FROM product;