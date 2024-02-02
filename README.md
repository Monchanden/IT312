#Query for MySQL

CREATE DATABASE db_mart;

CREATE TABLE tbl_user(
	id INT PRIMARY KEY,
	username VARCHAR(255) NOT NULL,
	password VARCHAR(255) NOT NULL,
	role INT NOT NULL,
	is_active INT NOT NULL
);

CREATE TABLE tbl_product(
	id INT PRIMARY KEY,
	product_name VARCHAR(255) NOT NULL,
	quantity BIGINT NOT NULL,
	unit_price VARCHAR(255) NOT NULL,
	stock_date VARCHAR(255) NOT NULL,
	inputter VARCHAR(255) NOT NULL,
	barcode VARCHAR(255) NOT NULL
);

CREATE TABLE tbl_payment(
	id INT PRIMARY KEY,
	product_name VARCHAR(255) NOT NULL,
	quantity INT NOT NULL,
	unit_price VARCHAR(255) NOT NULL,
	date VARCHAR(255) NOT NULL,
	cashier VARCHAR(255) NOT NULL,
	customer_name VARCHAR(255) NOT NULL,
	payment_id VARCHAR(255) NOT NULL
);
