BEGIN TRANSACTION;

INSERT INTO users (username,password_hash,role) VALUES ('user','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_USER');
INSERT INTO users (username,password_hash,role) VALUES ('admin','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_ADMIN');


INSERT INTO fish_inventory (name, type, length, weight, location, lure_used, date_caught, image_url)
    VALUES ('Rainbow Trout', 'Trout', 14.5, 1.2, 'Lake Clearwater', 'Spinnerbait', '2022-03-12', NULL);
INSERT INTO fish_inventory (name, type, length, weight, location, lure_used, date_caught, image_url)
    VALUES ('Bigmouth Bass', 'Bass', 18.2, 3.8, 'Lake Evergreen', 'Crankbait', '2022-04-05', NULL);
INSERT INTO fish_inventory (name, type, length, weight, location, lure_used, date_caught, image_url)
    VALUES ('Silver Salmon', 'Salmon', 24.7, 6.5, 'Kenai River', 'Fly', '2022-05-19', NULL);
INSERT INTO fish_inventory (name, type, length, weight, location, lure_used, date_caught, image_url)
    VALUES ('Striped Bass', 'Bass', 32.1, 12.3, 'Chesapeake Bay', 'Jig', '2022-06-02', NULL);
INSERT INTO fish_inventory (name, type, length, weight, location, lure_used, date_caught, image_url)
    VALUES ('Brown Trout', 'Trout', 16.4, 1.5, 'Yellowstone River', 'Worm', '2022-06-15', NULL);
INSERT INTO fish_inventory (name, type, length, weight, location, lure_used, date_caught, image_url)
    VALUES ('King Salmon', 'Salmon', 36.8, 18.7, 'Bristol Bay', 'Spoon', '2022-07-08', NULL);
INSERT INTO fish_inventory (name, type, length, weight, location, lure_used, date_caught, image_url)
    VALUES ('Largemouth Bass', 'Bass', 20.0, 5.2, 'Lake Okeechobee', 'Topwater', '2022-08-21', NULL);
INSERT INTO fish_inventory (name, type, length, weight, location, lure_used, date_caught, image_url)
    VALUES ('Brook Trout', 'Trout', 11.8, 0.9, 'Mountain Stream', 'Spinnerbait', '2022-09-04', NULL);
INSERT INTO fish_inventory (name, type, length, weight, location, lure_used, date_caught, image_url)
    VALUES ('Coho Salmon', 'Salmon', 27.3, 7.6, 'Pacific Ocean', 'Plug', '2022-10-17', NULL);
INSERT INTO fish_inventory (name, type, length, weight, location, lure_used, date_caught, image_url)
    VALUES ('Smallmouth Bass', 'Bass', 19.5, 4.3, 'Lake Michigan', 'Crankbait', '2022-11-30', NULL);
INSERT INTO fish_inventory (name, type, length, weight, location, lure_used, date_caught, image_url)
    VALUES ('Cutthroat Trout', 'Trout', 12.6, 1.1, 'Clear Creek', 'Fly', '2022-12-12', NULL);
INSERT INTO fish_inventory (name, type, length, weight, location, lure_used, date_caught, image_url)
    VALUES ('Sockeye Salmon', 'Salmon', 25.4, 8.2, 'Kasilof River', 'Spinner', '2023-01-25', NULL);
INSERT INTO fish_inventory (name, type, length, weight, location, lure_used, date_caught, image_url)
    VALUES ('White Bass', 'Bass', 15.8, 2.3, 'Lake Taxoma', 'Jig', '2023-02-07', NULL);
INSERT INTO fish_inventory (name, type, length, weight, location, lure_used, date_caught, image_url)
    VALUES ('Artic Char', 'Char', 19.7, 3.6, 'Lake Yukon', 'Spoon', '2023-03-22', NULL);
INSERT INTO fish_inventory (name, type, length, weight, location, lure_used, date_caught, image_url)
    VALUES ('Bluegill', 'Sunfish', 7.3, 0.4, 'Pond', 'Worm', '2023-04-05', NULL);
INSERT INTO fish_inventory (name, type, length, weight, location, lure_used, date_caught, image_url)
    VALUES ('Walleye', 'Perch', 22.9, 5.9, 'Lake Erie', 'Minnow', '2023-05-18', NULL);
INSERT INTO fish_inventory (name, type, length, weight, location, lure_used, date_caught, image_url)
    VALUES ('Northern Pike', 'Pike', 41.2, 15.2, 'Lake Superior', 'Jerkbait', '2023-06-01', NULL);
INSERT INTO fish_inventory (name, type, length, weight, location, lure_used, date_caught, image_url)
    VALUES ('Yellow Perch', 'Perch', 10.4, 0.8, 'Lake Ontario', 'Grub', '2023-07-14', NULL);
INSERT INTO fish_inventory (name, type, length, weight, location, lure_used, date_caught, image_url)
    VALUES ('Muskie', 'Pike', 53.6, 26.8, 'Lake St. Clair', 'Topwater', '2023-08-27', NULL);
INSERT INTO fish_inventory (name, type, length, weight, location, lure_used, date_caught, image_url)
    VALUES ('Channel Catfish', 'Catfish', 28.7, 9.5, 'Mississippi River', 'Stinkbait', '2023-09-10', NULL);


INSERT INTO fish_tracking_history (fish_id, recorded_date, recorded_length, recorded_weight)
    VALUES (1, '2022-03-12', 14.5, 1.2);
INSERT INTO fish_tracking_history (fish_id, recorded_date, recorded_length, recorded_weight)
    VALUES (2, '2022-04-05', 18.2, 3.8);
INSERT INTO fish_tracking_history (fish_id, recorded_date, recorded_length, recorded_weight)
    VALUES (3, '2022-05-19', 24.7, 6.5);
INSERT INTO fish_tracking_history (fish_id, recorded_date, recorded_length, recorded_weight)
    VALUES (4, '2022-06-02', 32.1, 12.3);
INSERT INTO fish_tracking_history (fish_id, recorded_date, recorded_length, recorded_weight)
    VALUES (5, '2022-06-15', 16.4, 1.5);
INSERT INTO fish_tracking_history (fish_id, recorded_date, recorded_length, recorded_weight)
    VALUES (6, '2022-07-08', 36.8, 18.7);
INSERT INTO fish_tracking_history (fish_id, recorded_date, recorded_length, recorded_weight)
    VALUES (7, '2022-08-21', 20.0, 5.2);
INSERT INTO fish_tracking_history (fish_id, recorded_date, recorded_length, recorded_weight)
    VALUES (8, '2022-09-04', 11.8, 0.9);
INSERT INTO fish_tracking_history (fish_id, recorded_date, recorded_length, recorded_weight)
    VALUES (9, '2022-10-17', 27.3, 7.6);
INSERT INTO fish_tracking_history (fish_id, recorded_date, recorded_length, recorded_weight)
    VALUES (10, '2022-11-30', 19.5, 4.3);
INSERT INTO fish_tracking_history (fish_id, recorded_date, recorded_length, recorded_weight)
    VALUES (11, '2022-12-12', 12.6, 1.1);
INSERT INTO fish_tracking_history (fish_id, recorded_date, recorded_length, recorded_weight)
    VALUES (12, '2023-01-25', 25.4, 8.2);
INSERT INTO fish_tracking_history (fish_id, recorded_date, recorded_length, recorded_weight)
    VALUES (13, '2023-02-07', 15.8, 2.3);
INSERT INTO fish_tracking_history (fish_id, recorded_date, recorded_length, recorded_weight)
    VALUES (14, '2023-03-22', 19.7, 3.6);
INSERT INTO fish_tracking_history (fish_id, recorded_date, recorded_length, recorded_weight)
    VALUES (15, '2023-04-05', 7.3, 0.4);
INSERT INTO fish_tracking_history (fish_id, recorded_date, recorded_length, recorded_weight)
    VALUES (16, '2023-05-18', 22.9, 5.9);
INSERT INTO fish_tracking_history (fish_id, recorded_date, recorded_length, recorded_weight)
    VALUES (17, '2023-06-01', 41.2, 15.2);
INSERT INTO fish_tracking_history (fish_id, recorded_date, recorded_length, recorded_weight)
    VALUES (18, '2023-07-14', 10.4, 0.8);
INSERT INTO fish_tracking_history (fish_id, recorded_date, recorded_length, recorded_weight)
    VALUES (19, '2023-08-27', 53.6, 26.8);
INSERT INTO fish_tracking_history (fish_id, recorded_date, recorded_length, recorded_weight)
    VALUES (20, '2023-09-10', 28.7, 9.5);


COMMIT TRANSACTION;
