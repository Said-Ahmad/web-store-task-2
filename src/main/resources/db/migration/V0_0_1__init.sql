CREATE SCHEMA IF NOT EXISTS test;

CREATE SEQUENCE IF NOT EXISTS test.product_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;

CREATE TABLE test.products
(
    id          INTEGER DEFAULT nextval('test.product_id_seq'::regclass) PRIMARY KEY NOT NULL,
    name        VARCHAR                                                              NOT NULL,
    price       INTEGER                                                              NOT NULL,
    article     VARCHAR NULL,
    description VARCHAR NULL
);

CREATE SEQUENCE IF NOT EXISTS test.racks_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;

CREATE TABLE test.racks
(
    id INTEGER DEFAULT nextval('test.racks_id_seq'::regclass) PRIMARY KEY NOT NULL,
    name        VARCHAR NOT NULL,
    description VARCHAR NULL
);

CREATE SEQUENCE IF NOT EXISTS test.product_and_racks_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;

CREATE TABLE test.product_and_racks
(
    id INTEGER DEFAULT nextval('test.product_and_racks_id_seq'::regclass) PRIMARY KEY NOT NULL,
    product_id INTEGER NOT NULL,
    racks_id   INTEGER NOT NULL,
    is_primary BOOLEAN NOT NULL,
    FOREIGN KEY (product_id) REFERENCES test.products (id),
    FOREIGN KEY (racks_id) REFERENCES test.racks (id)
);


CREATE SEQUENCE IF NOT EXISTS test.orders_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;

CREATE TABLE test.orders
(
    id INTEGER DEFAULT nextval(' test.orders_id_seq'::regclass) PRIMARY KEY NOT NULL,
    number_of_orders INTEGER NOT NULL
);


CREATE SEQUENCE IF NOT EXISTS test.order_and_products_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;

CREATE TABLE test.order_and_products
(
    id INTEGER DEFAULT nextval('test.order_and_products_id_seq'::regclass) PRIMARY KEY NOT NULL,
    order_id   INTEGER NOT NULL,
    product_id INTEGER NOT NULL,
    FOREIGN KEY (order_id) REFERENCES test.orders (id),
    FOREIGN KEY (product_id) REFERENCES test.products (id)
);
INSERT INTO test.products(name, price, description)
VALUES ('Laptop', 1000, 'A powerful laptop for work and play');

INSERT INTO test.products(name, price, description)
VALUES ('TV', 1000, '24" Full HD monitor');

INSERT INTO test.products(name, price, description)
VALUES ('Smartphone', 1000, 'Smartphone with 6.5" screen and 4 cameras');

INSERT INTO test.products(name, price, description)
VALUES ('System unit', 1000, '---');

INSERT INTO test.products(name, price, description)
VALUES ('Watch', 1000, '---');

INSERT INTO test.products(name, price, description)
VALUES ('Microphone', 1000, '---');

INSERT INTO test.racks(name, description)
VALUES ('A', 'Rack for laptops and monitors');
INSERT INTO test.racks(name, description)
VALUES ('B', 'Mobile phone rack');
INSERT INTO test.racks(name, description)
VALUES ('J', 'Rack for other equipment');
INSERT INTO test.racks(name, description)
VALUES ('Z', 'Additional phone rack');
INSERT INTO test.racks(name, description)
VALUES ('V', 'Additional phone rack');

INSERT INTO test.product_and_racks(product_id, racks_id, is_primary)
VALUES (1, 1, true);

INSERT INTO test.product_and_racks(product_id, racks_id, is_primary)
VALUES (2, 1, true);

INSERT INTO test.product_and_racks(product_id, racks_id, is_primary)
VALUES (3, 2, true);

INSERT INTO test.product_and_racks(product_id, racks_id, is_primary)
VALUES (3, 4, false);

INSERT INTO test.product_and_racks(product_id, racks_id, is_primary)
VALUES (3, 5, false);

INSERT INTO test.product_and_racks(product_id, racks_id, is_primary)
VALUES (3, 2, true);

INSERT INTO test.product_and_racks(product_id, racks_id, is_primary)
VALUES (4, 3, true);

INSERT INTO test.product_and_racks(product_id, racks_id, is_primary)
VALUES (5, 3, true);

INSERT INTO test.product_and_racks(product_id, racks_id, is_primary)
VALUES (5, 1, false);

INSERT INTO test.product_and_racks(product_id, racks_id, is_primary)
VALUES (6, 3, true);


INSERT INTO test.orders (number_of_orders)
VALUES (10);
INSERT INTO test.orders (number_of_orders)
VALUES (11);
INSERT INTO test.orders (number_of_orders)
VALUES (14);
INSERT INTO test.orders (number_of_orders)
VALUES (15);

INSERT INTO test.order_and_products(order_id, product_id)
VALUES (1, 1);
INSERT INTO test.order_and_products(order_id, product_id)
VALUES (1, 1);
INSERT INTO test.order_and_products(order_id, product_id)
VALUES (2, 2);
INSERT INTO test.order_and_products(order_id, product_id)
VALUES (2, 2);
INSERT INTO test.order_and_products(order_id, product_id)
VALUES (2, 2);
INSERT INTO test.order_and_products(order_id, product_id)
VALUES (3, 1);
INSERT INTO test.order_and_products(order_id, product_id)
VALUES (3, 1);
INSERT INTO test.order_and_products(order_id, product_id)
VALUES (3, 1);
INSERT INTO test.order_and_products(order_id, product_id)
VALUES (1, 3);
INSERT INTO test.order_and_products(order_id, product_id)
VALUES (1, 6);
INSERT INTO test.order_and_products(order_id, product_id)
VALUES (3, 4);
INSERT INTO test.order_and_products(order_id, product_id)
VALUES (3, 4);
INSERT INTO test.order_and_products(order_id, product_id)
VALUES (3, 4);
INSERT INTO test.order_and_products(order_id, product_id)
VALUES (3, 4);
INSERT INTO test.order_and_products(order_id, product_id)
VALUES (4, 5);
