CREATE TABLE SALESPEOPLE
(
    SALESPERSON_ID BIGINT PRIMARY KEY AUTO_INCREMENT,
    FIRST_NAME     VARCHAR(64),
    LAST_NAME      VARCHAR(64),
    EMAIL          VARCHAR(128) UNIQUE,
    PHONE          VARCHAR(32),
    ADDRESS        VARCHAR(256),
    CITY           VARCHAR(64),
    STATE          CHAR(2),
    ZIPCODE        VARCHAR(12)
);

CREATE TABLE PRODUCTS
(
    PRODUCT_ID VARCHAR(32) PRIMARY KEY,
    NAME       VARCHAR(128),
    SIZE       INT,
    VARIETY    VARCHAR(32),
    PRICE      NUMERIC(4, 2),
    STATUS     VARCHAR(16)
);

CREATE TABLE CUSTOMERS
(
    CUSTOMER_ID BIGINT PRIMARY KEY AUTO_INCREMENT,
    FIRST_NAME  VARCHAR(64),
    LAST_NAME   VARCHAR(64),
    EMAIL       VARCHAR(128) UNIQUE,
    PHONE       VARCHAR(32),
    ADDRESS     VARCHAR(256),
    CITY        VARCHAR(64),
    STATE       CHAR(2),
    ZIPCODE     VARCHAR(12)
);

CREATE TABLE ORDERS
(
    ORDER_ID       VARCHAR(16) PRIMARY KEY,
    CUSTOMER_ID    BIGINT,
    SALESPERSON_ID BIGINT
);

CREATE TABLE ORDER_LINES
(
    ORDER_LINE_ID BIGINT PRIMARY KEY AUTO_INCREMENT,
    ORDER_ID      VARCHAR(16),
    PRODUCT_ID    VARCHAR(32),
    QUANTITY      INT
);

ALTER TABLE ORDERS
    ADD FOREIGN KEY (CUSTOMER_ID) REFERENCES CUSTOMERS (CUSTOMER_ID);
ALTER TABLE ORDERS
    ADD FOREIGN KEY (SALESPERSON_ID) REFERENCES SALESPEOPLE (SALESPERSON_ID);
ALTER TABLE ORDER_LINES
    ADD FOREIGN KEY (ORDER_ID) REFERENCES ORDERS (ORDER_ID);
ALTER TABLE ORDER_LINES
    ADD FOREIGN KEY (PRODUCT_ID) REFERENCES PRODUCTS (PRODUCT_ID);