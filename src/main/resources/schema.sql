CREATE TABLE CUSTOMERS
(
    id INT NOT NULL,
    name VARCHAR(50),
    surname VARCHAR(50),
    age INT,
    phone_number VARCHAR(20),
    PRIMARY KEY (id)
);

CREATE TABLE ORDERS
(
    id INT NOT NULL,
    date DATE,
    customer_id INT,
    product_name VARCHAR(50),
    amount INT,
    PRIMARY KEY (id),
    FOREIGN KEY (customer_id) REFERENCES CUSTOMERS(id)
);

INSERT INTO CUSTOMERS(name, surname, age, phone_number)
VALUES ('Petya','Temnov', 18, 89636946644);

INSERT INTO ORDERS(date, product_name, amount)
VALUES ('2024-02-14','sneakers', 18);