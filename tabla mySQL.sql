CREATE SCHEMA lab6_02;
USE lab6_02;

CREATE SCHEMA lab6_04;
USE lab6_04;

CREATE TABLE IF NOT EXISTS product (
  id BIGINT NOT NULL AUTO_INCREMENT,
  amount DECIMAL(19,2),
  currency VARCHAR(255),
  product_name VARCHAR(255),
  PRIMARY KEY (id));
  
INSERT INTO product(amount, currency, product_name) 
VALUES (20.20, 'USD', 'paraguas'),
(34.00, 'USD', 'cascos'),
(7.00, 'USD', 'escoba');