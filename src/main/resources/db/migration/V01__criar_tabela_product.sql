CREATE TABLE TB_PRODUCT (
	PRODUCT_ID VARCHAR(250) NOT NULL,
	NAME VARCHAR(50) NOT NULL,
	DESCRIPTION VARCHAR(50) NOT NULL,
	PRICE DECIMAL(19,2) NOT NULL,
	constraint pk_productId primary key (PRODUCT_ID)
);