BEGIN TRANSACTION;

DROP TABLE IF EXISTS users;
DROP TABLE IF EXISTS fish_inventory;
DROP TABLE IF EXISTS fish_tracking_history;

CREATE TABLE users (
	user_id SERIAL,
	username varchar(50) NOT NULL UNIQUE,
	password_hash varchar(200) NOT NULL,
	role varchar(50) NOT NULL,
	CONSTRAINT PK_user PRIMARY KEY (user_id)
);

CREATE TABLE fish_inventory (
    fish_id SERIAL,
    name VARCHAR(255) NOT NULL,
    type VARCHAR (50) NOT NULL,
    length NUMERIC(5, 2) NOT NULL,
    weight NUMERIC(5, 2) NOT NULL,
    location VARCHAR(255) NOT NULL,
    lure_used VARCHAR(100),
    date_caught DATE NOT NULL,
    image_url VARCHAR(255),
    CONSTRAINT PK_fish_id PRIMARY KEY (fish_id)
);

CREATE TABLE fish_tracking_history (
    tracking_history_id SERIAL,
    fish_id INT,
    recorded_date DATE NOT NULL,
    recorded_length NUMERIC (5, 2),
    recorded_weight NUMERIC (5, 2),
    CONSTRAINT PK_tracking_history_id PRIMARY KEY (tracking_history_id),
    CONSTRAINT FK_fish_id FOREIGN KEY (fish_id) REFERENCES fish_inventory (fish_id)
);

COMMIT TRANSACTION;
