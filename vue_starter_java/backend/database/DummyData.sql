SELECT * FROM users;
SELECT * FROM address;
SELECT * FROM event;
SELECT * FROM food;
SELECT * FROM orders;
SELECT * FROM event_attendees;


INSERT INTO users (username, password, salt, email, role) 
VALUES ('Shecka', 'cookout123', 'qwerty', 'Shecka826@gmail.com', 'User');

INSERT INTO address (street_address, city, state, zip)
VALUES ('123 Very Fake Street', 'Pittsburgh', 'PA', '15212');

INSERT INTO event (event_name, event_date, event_time, description, deadline, address_id)
VALUES ('Christmas Cookout', '12-20-2019', '3pm', 'A fun get together for Christmas!', '12-10-2019', '1');

INSERT INTO food (food_name, vegetarian, vegan, gluten_free, nut_free, description, event_id)
VALUES ('Hamburger', 'false', 'false', 'false', 'true', 'Hamburger with all the fixings', '1');
INSERT INTO food (food_name, vegetarian, vegan, gluten_free, nut_free, description, event_id)
VALUES ('Hotdog', 'false', 'false', 'false', 'true', 'Hotdog with all the fixings', '1');
INSERT INTO food (food_name, vegetarian, vegan, gluten_free, nut_free, description, event_id)
VALUES ('Paneer Tikka Masala', 'true', 'false', 'true', 'true', 'Indian cheese in a spicy sauce', '1');

INSERT INTO orders (event_id, user_id, food_id, status, quantity)
VALUES ('1', '1', '2', 'waiting', '2');
INSERT INTO orders (event_id, user_id, food_id, status, quantity)
VALUES ('1', '1', '3', 'done', '1');

INSERT INTO event_attendees (event_id, user_id, is_host, is_attending, first_name, last_name, adult_guests, child_guests)
VALUES ('1', '1', 'true', 'true', 'First', 'Last', '1', '0');




