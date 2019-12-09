BEGIN TRANSACTION;

DROP TABLE IF EXISTS users;
DROP TABLE IF EXISTS event;
DROP TABLE IF EXISTS event_attendees;
DROP TABLE IF EXISTS address;
DROP TABLE IF EXISTS RSVP;
DROP TABLE IF EXISTS menu;
DROP TABLE IF EXISTS food;
DROP TABLE IF EXISTS orders;

DROP SEQUENCE IF EXISTS seq_user_id;
DROP SEQUENCE IF EXISTS seq_event_id;
DROP SEQUENCE IF EXISTS seq_address_id;
DROP SEQUENCE IF EXISTS seq_menu_id;
DROP SEQUENCE IF EXISTS seq_orders_id;

CREATE SEQUENCE seq_user_id
START 1
INCREMENT 1;

CREATE TABLE users (
  user_id INTEGER DEFAULT NEXTVAL('seq_user_id') PRIMARY KEY,
  username varchar(255) UNIQUE,     -- Username
  password varchar(32) NOT NULL,      -- Password
  salt varchar(256) NOT NULL,          -- Password Salt
  email varchar(255) NOT NULL UNIQUE,
  date_registered timestamp DEFAULT Now()
);

CREATE SEQUENCE seq_event_id
START 1
INCREMENT 1;

CREATE TABLE event (
  event_id INTEGER DEFAULT NEXTVAL('seq_event_id') PRIMARY KEY,
  event_name varchar(255) NOT NULL,
  event_date date NOT NULL,
  event_time varchar(10) NOT NULL,
  description varchar(255),
  deadline date NOT NULL,
  menu_id int NOT NULL,
  address_id int NOT NULL
  );
  
CREATE TABLE event_attendees (
 event_id int NOT NULL,
 user_id int NOT NULL,
 role varchar(20) NOT NULL,
 is_attending boolean DEFAULT false,
 PRIMARY KEY (event_id, user_id),
 FOREIGN KEY (event_id) REFERENCES event (event_id),
 FOREIGN KEY (user_id) REFERENCES users (user_id)
 );
 
CREATE SEQUENCE seq_address_id
START 1
INCREMENT 1;

CREATE TABLE address (
 address_id INTEGER DEFAULT NEXTVAL('seq_address_id') PRIMARY KEY,
 street_address varchar(100) NOT NULL,
 city varchar(50) NOT NULL,
 state varchar(30) NOT NULL,
 zip int NOT NULL
);
 
CREATE TABLE RSVP (
 event_id int NOT NULL,
 user_id int NOT NULL,
 first_name varchar(25) NOT NULL,
 last_name varchar(50) NOT NULL,
 adult_guests int,
 child_guests int,
 PRIMARY KEY (event_id, user_id),
 FOREIGN KEY (event_id) REFERENCES event (event_id),
 FOREIGN KEY (user_id) REFERENCES users (user_id)
);

CREATE SEQUENCE seq_menu_id
START 1
INCREMENT 1;

CREATE TABLE menu (
 menu_id INTEGER DEFAULT NEXTVAL('seq_menu_id') PRIMARY KEY,
 event_id int NOT NULL,
 FOREIGN KEY (event_id) REFERENCES event (event_id)
);

CREATE TABLE food (
 food_id serial NOT NULL UNIQUE,
 food_name varchar(50) NOT NULL,
 vegetarian boolean DEFAULT false,
 vegan boolean DEFAULT false,
 gluten_free boolean DEFAULT false,
 nut_free boolean DEFAULT false,
 description varchar(255),
 menu_id int NOT NULL,
 FOREIGN KEY (menu_id) REFERENCES menu (menu_id)
);

CREATE SEQUENCE seq_orders_id
START 1
INCREMENT 1;

CREATE TABLE orders (
 order_id INTEGER DEFAULT NEXTVAL('seq_orders_id') PRIMARY KEY,
 event_id int NOT NULL,
 user_id int NOT NULL,
 food_id int NOT NULL,
 status varchar(20) NOT NULL,
 quantity int NOT NULL,
 FOREIGN KEY (event_id) REFERENCES event (event_id),
 FOREIGN KEY (user_id) REFERENCES users (user_id),
 FOREIGN KEY (food_id) REFERENCES food (food_id)
); 

ALTER TABLE event
ADD CONSTRAINT fk_address_id
FOREIGN KEY (address_id) 
REFERENCES address (address_id);

ALTER TABLE event
ADD CONSTRAINT fk_menu_id
FOREIGN KEY (menu_id)
REFERENCES menu (menu_id);

COMMIT;
