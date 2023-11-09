BEGIN TRANSACTION;

INSERT INTO users (username,password_hash,role) VALUES ('user','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_USER');
INSERT INTO users (username,password_hash,role) VALUES ('admin','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_ADMIN');


INSERT INTO fish_inventory (name, type, length, weight, location, lure_used, date_caught, image_url)
    VALUES ('Rainbow Trout', 'Trout', 14.5, 1.2, 'Lake Clearwater', 'Spinnerbait', '2022-03-12', 'https://upload.wikimedia.org/wikipedia/commons/thumb/c/c1/Close_up_of_rainbow_trout_fish_underwater_oncorhynchus_mykiss.jpg/1024px-Close_up_of_rainbow_trout_fish_underwater_oncorhynchus_mykiss.jpg');
INSERT INTO fish_inventory (name, type, length, weight, location, lure_used, date_caught, image_url)
    VALUES ('Bigmouth Bass', 'Bass', 18.2, 3.8, 'Lake Evergreen', 'Crankbait', '2022-04-05', 'https://upload.wikimedia.org/wikipedia/commons/thumb/8/8b/1351_largemouth_bass_%28Micropterus_salmoides%29_300_dpi.jpg/1024px-1351_largemouth_bass_%28Micropterus_salmoides%29_300_dpi.jpg');
INSERT INTO fish_inventory (name, type, length, weight, location, lure_used, date_caught, image_url)
    VALUES ('Silver Salmon', 'Salmon', 24.7, 6.5, 'Kenai River', 'Fly', '2022-05-19', 'https://upload.wikimedia.org/wikipedia/commons/thumb/e/ed/Silver_Salmon_at_Smith_River_Falls_%2849021167137%29.jpg/1024px-Silver_Salmon_at_Smith_River_Falls_%2849021167137%29.jpg');
INSERT INTO fish_inventory (name, type, length, weight, location, lure_used, date_caught, image_url)
    VALUES ('Striped Bass', 'Bass', 32.1, 12.3, 'Chesapeake Bay', 'Jig', '2022-06-02', 'https://upload.wikimedia.org/wikipedia/commons/7/74/Morone_saxatilis_SI2.jpg');
INSERT INTO fish_inventory (name, type, length, weight, location, lure_used, date_caught, image_url)
    VALUES ('Brown Trout', 'Trout', 16.4, 1.5, 'Yellowstone River', 'Worm', '2022-06-15', 'https://upload.wikimedia.org/wikipedia/commons/thumb/8/88/Salmo_trutta_Ozeaneum_Stralsund_HBP_2010-07-02.jpg/1024px-Salmo_trutta_Ozeaneum_Stralsund_HBP_2010-07-02.jpg');
INSERT INTO fish_inventory (name, type, length, weight, location, lure_used, date_caught, image_url)
    VALUES ('King Salmon', 'Salmon', 36.8, 18.7, 'Bristol Bay', 'Spoon', '2022-07-08', 'https://upload.wikimedia.org/wikipedia/commons/d/dc/OncorhynchusTschawytscha2.jpg');
INSERT INTO fish_inventory (name, type, length, weight, location, lure_used, date_caught, image_url)
    VALUES ('Largemouth Bass', 'Bass', 20.0, 5.2, 'Lake Okeechobee', 'Topwater', '2022-08-21', 'https://upload.wikimedia.org/wikipedia/commons/thumb/8/8b/1351_largemouth_bass_%28Micropterus_salmoides%29_300_dpi.jpg/1024px-1351_largemouth_bass_%28Micropterus_salmoides%29_300_dpi.jpg');
INSERT INTO fish_inventory (name, type, length, weight, location, lure_used, date_caught, image_url)
    VALUES ('Brook Trout', 'Trout', 11.8, 0.9, 'Mountain Stream', 'Spinnerbait', '2022-09-04', 'https://upload.wikimedia.org/wikipedia/commons/e/ee/Brook_trout_in_water.jpg');
INSERT INTO fish_inventory (name, type, length, weight, location, lure_used, date_caught, image_url)
    VALUES ('Coho Salmon', 'Salmon', 27.3, 7.6, 'Pacific Ocean', 'Plug', '2022-10-17', 'https://upload.wikimedia.org/wikipedia/commons/thumb/e/ed/Silver_Salmon_at_Smith_River_Falls_%2849021167137%29.jpg/1024px-Silver_Salmon_at_Smith_River_Falls_%2849021167137%29.jpg');
INSERT INTO fish_inventory (name, type, length, weight, location, lure_used, date_caught, image_url)
    VALUES ('Smallmouth Bass', 'Bass', 19.5, 4.3, 'Lake Michigan', 'Crankbait', '2022-11-30', 'https://upload.wikimedia.org/wikipedia/commons/thumb/6/62/Micropterus_dolomieu.jpg/1024px-Micropterus_dolomieu.jpg');
INSERT INTO fish_inventory (name, type, length, weight, location, lure_used, date_caught, image_url)
    VALUES ('Cutthroat Trout', 'Trout', 12.6, 1.1, 'Clear Creek', 'Fly', '2022-12-12', 'https://upload.wikimedia.org/wikipedia/commons/thumb/b/be/Westslope_Cutthroat_Trout_Middle_Fork_Flathead_%2827912294517%29_%28cropped%29.jpg/1024px-Westslope_Cutthroat_Trout_Middle_Fork_Flathead_%2827912294517%29_%28cropped%29.jpg');
INSERT INTO fish_inventory (name, type, length, weight, location, lure_used, date_caught, image_url)
    VALUES ('Sockeye Salmon', 'Salmon', 25.4, 8.2, 'Kasilof River', 'Spinner', '2023-01-25', 'https://upload.wikimedia.org/wikipedia/commons/thumb/7/76/Sockeye_salmon_swimming_right.jpg/1024px-Sockeye_salmon_swimming_right.jpg');
INSERT INTO fish_inventory (name, type, length, weight, location, lure_used, date_caught, image_url)
    VALUES ('White Bass', 'Bass', 15.8, 2.3, 'Lake Texoma', 'Jig', '2023-02-07', 'https://upload.wikimedia.org/wikipedia/commons/thumb/8/8b/White_Bass%2C_Caught_and_Released.JPG/1024px-White_Bass%2C_Caught_and_Released.JPG');
INSERT INTO fish_inventory (name, type, length, weight, location, lure_used, date_caught, image_url)
    VALUES ('Arctic Char', 'Char', 19.7, 3.6, 'Lake Yukon', 'Spoon', '2023-03-22', 'https://upload.wikimedia.org/wikipedia/commons/e/ea/Salvelinusalpinus.jpg');
INSERT INTO fish_inventory (name, type, length, weight, location, lure_used, date_caught, image_url)
    VALUES ('Bluegill', 'Sunfish', 7.3, 0.4, 'Pond', 'Worm', '2023-04-05', 'https://upload.wikimedia.org/wikipedia/commons/thumb/b/bf/Lepomis_macrochirus_UMFS_2014_2.JPG/1024px-Lepomis_macrochirus_UMFS_2014_2.JPG');
INSERT INTO fish_inventory (name, type, length, weight, location, lure_used, date_caught, image_url)
    VALUES ('Walleye', 'Perch', 22.9, 5.9, 'Lake Erie', 'Minnow', '2023-05-18', 'https://upload.wikimedia.org/wikipedia/commons/thumb/9/96/Sander_vitreus.jpg/1024px-Sander_vitreus.jpg');
INSERT INTO fish_inventory (name, type, length, weight, location, lure_used, date_caught, image_url)
    VALUES ('Northern Pike', 'Pike', 41.2, 15.2, 'Lake Superior', 'Jerkbait', '2023-06-01', 'https://upload.wikimedia.org/wikipedia/commons/thumb/9/93/Esox_lucius_ZOO_1.jpg/1024px-Esox_lucius_ZOO_1.jpg');
INSERT INTO fish_inventory (name, type, length, weight, location, lure_used, date_caught, image_url)
    VALUES ('Yellow Perch', 'Perch', 10.4, 0.8, 'Lake Ontario', 'Grub', '2023-07-14', 'https://upload.wikimedia.org/wikipedia/commons/7/7f/YellowPerch.jpg');
INSERT INTO fish_inventory (name, type, length, weight, location, lure_used, date_caught, image_url)
    VALUES ('Muskie', 'Pike', 53.6, 26.8, 'Lake St. Clair', 'Topwater', '2023-08-27', 'https://upload.wikimedia.org/wikipedia/commons/thumb/d/d2/Esox_masquinongyeditcrop.jpg/1024px-Esox_masquinongyeditcrop.jpg');
INSERT INTO fish_inventory (name, type, length, weight, location, lure_used, date_caught, image_url)
    VALUES ('Channel Catfish', 'Catfish', 28.7, 9.5, 'Mississippi River', 'Stinkbait', '2023-09-10', 'https://upload.wikimedia.org/wikipedia/commons/thumb/e/e0/Ictalurus_punctatus1.jpg/1024px-Ictalurus_punctatus1.jpg');
INSERT INTO fish_inventory (name, type, length, weight, location, lure_used, date_caught, image_url)
    VALUES ('Yellowtail Amberjack', 'Amberjack', 47.2, 32.5, 'Pacific Ocean', 'Jig', '2022-01-25', 'https://upload.wikimedia.org/wikipedia/commons/thumb/1/19/Yellowtail_amberjack.jpg/1024px-Yellowtail_amberjack.jpg');
INSERT INTO fish_inventory (name, type, length, weight, location, lure_used, date_caught, image_url)
    VALUES ('Red Snapper', 'Snapper', 28.9, 8.7, 'Gulf of Mexico', 'Cut Bait', '2022-02-14', 'https://upload.wikimedia.org/wikipedia/commons/thumb/b/b7/Red_Snapper.jpg/1024px-Red_Snapper.jpg');
INSERT INTO fish_inventory (name, type, length, weight, location, lure_used, date_caught, image_url)
    VALUES ('Mahi-Mahi', 'Mahi-Mahi', 41.5, 26.8, 'Caribbean Sea', 'Trolling Lure', '2022-03-03', 'https://upload.wikimedia.org/wikipedia/commons/thumb/9/94/Coryphaenahippurus.JPG/1024px-Coryphaenahippurus.JPG');
INSERT INTO fish_inventory (name, type, length, weight, location, lure_used, date_caught, image_url)
    VALUES ('King Mackerel', 'Mackerel', 31.8, 10.3, 'Gulf of Mexico', 'Trolling Lure', '2022-04-21', 'https://upload.wikimedia.org/wikipedia/commons/thumb/a/a9/King_Mackerel.JPG/1024px-King_Mackerel.JPG');
INSERT INTO fish_inventory (name, type, length, weight, location, lure_used, date_caught, image_url)
    VALUES ('Swordfish', 'Swordfish', 97.4, 155.2, 'Atlantic Ocean', 'Squid', '2022-05-10', 'https://upload.wikimedia.org/wikipedia/commons/1/19/Swordfish_natural_environment.jpg');
INSERT INTO fish_inventory (name, type, length, weight, location, lure_used, date_caught, image_url)
    VALUES ('Sailfish', 'Sailfish', 108.7, 205.6, 'Pacific Ocean', 'Ballyhoo', '2022-06-29', 'https://upload.wikimedia.org/wikipedia/commons/d/d5/Two_men_holding_a_freshly_caught_sailfish.jpg');
INSERT INTO fish_inventory (name, type, length, weight, location, lure_used, date_caught, image_url)
    VALUES ('Bluegill', 'Sunfish', 6.4, 0.3, 'Pond', 'Worm', '2022-07-18', 'https://upload.wikimedia.org/wikipedia/commons/thumb/b/bf/Lepomis_macrochirus_UMFS_2014_2.JPG/1024px-Lepomis_macrochirus_UMFS_2014_2.JPG');
INSERT INTO fish_inventory (name, type, length, weight, location, lure_used, date_caught, image_url)
    VALUES ('Arctic Char', 'Char', 17.8, 3.2, 'Lake Yukon', 'Spoon', '2022-08-06', 'https://upload.wikimedia.org/wikipedia/commons/e/ea/Salvelinusalpinus.jpg');
INSERT INTO fish_inventory (name, type, length, weight, location, lure_used, date_caught, image_url)
    VALUES ('White Bass', 'Bass', 14.6, 2.1, 'Lake Texoma', 'Jig', '2022-09-23', 'https://upload.wikimedia.org/wikipedia/commons/thumb/8/8b/White_Bass%2C_Caught_and_Released.JPG/1024px-White_Bass%2C_Caught_and_Released.JPG');
INSERT INTO fish_inventory (name, type, length, weight, location, lure_used, date_caught, image_url)
    VALUES ('Cuttthroat Trout', 'Trout', 13.2, 1, 'Clear Creek', 'Fly', '2022-10-11', 'https://upload.wikimedia.org/wikipedia/commons/thumb/b/be/Westslope_Cutthroat_Trout_Middle_Fork_Flathead_%2827912294517%29_%28cropped%29.jpg/1024px-Westslope_Cutthroat_Trout_Middle_Fork_Flathead_%2827912294517%29_%28cropped%29.jpg');
INSERT INTO fish_inventory (name, type, length, weight, location, lure_used, date_caught, image_url)
    VALUES ('Blue Marlin', 'Marlin', 118.3, 319.7, 'Gulf of Mexico', 'Trolling Lure', '2022-11-30', 'https://upload.wikimedia.org/wikipedia/commons/thumb/b/b9/Atlantic_blue_marlin.jpg/1024px-Atlantic_blue_marlin.jpg');
INSERT INTO fish_inventory (name, type, length, weight, location, lure_used, date_caught, image_url)
    VALUES ('Catfish', 'Catfish', 30.9, 10.2, 'Mississippi River', 'Stinkbait', '2022-12-19', 'https://upload.wikimedia.org/wikipedia/commons/d/d8/Channelcat.jpg');
INSERT INTO fish_inventory (name, type, length, weight, location, lure_used, date_caught, image_url)
    VALUES ('Muskellunge', 'Pike', 45.3, 22.1, 'Lake St. Clair', 'Topwater', '2023-03-03', 'https://upload.wikimedia.org/wikipedia/commons/thumb/d/d2/Esox_masquinongyeditcrop.jpg/1024px-Esox_masquinongyeditcrop.jpg');
INSERT INTO fish_inventory (name, type, length, weight, location, lure_used, date_caught, image_url)
    VALUES ('Yellow Perch', 'Perch', 9.6, 0.6, 'Lake Ontario', 'Grub', '2023-04-20', 'https://upload.wikimedia.org/wikipedia/commons/7/7f/YellowPerch.jpg');
INSERT INTO fish_inventory (name, type, length, weight, location, lure_used, date_caught, image_url)
    VALUES ('Northern Pike', 'Pike', 38.6, 13.8, 'Lake Superior', 'Jerkbait', '2023-05-08', 'https://upload.wikimedia.org/wikipedia/commons/thumb/9/93/Esox_lucius_ZOO_1.jpg/1024px-Esox_lucius_ZOO_1.jpg');
INSERT INTO fish_inventory (name, type, length, weight, location, lure_used, date_caught, image_url)
    VALUES ('Walleye', 'Perch', 21.1, 6.2, 'Lake Michigan', 'Minnow', '2023-06-26', 'https://upload.wikimedia.org/wikipedia/commons/thumb/9/96/Sander_vitreus.jpg/1024px-Sander_vitreus.jpg');
INSERT INTO fish_inventory (name, type, length, weight, location, lure_used, date_caught, image_url)
    VALUES ('Brook Trout', 'Trout', 10.7, 0.7, 'Mountain Stream', 'Spinnerbait', '2023-07-14', 'https://upload.wikimedia.org/wikipedia/commons/e/ee/Brook_trout_in_water.jpg');
INSERT INTO fish_inventory (name, type, length, weight, location, lure_used, date_caught, image_url)
    VALUES ('Smallmouth Bass', 'Bass', 19.2, 4.7, 'Lake Erie', 'Crankbait', '2023-08-25', 'https://upload.wikimedia.org/wikipedia/commons/thumb/6/62/Micropterus_dolomieu.jpg/1024px-Micropterus_dolomieu.jpg');
INSERT INTO fish_inventory (name, type, length, weight, location, lure_used, date_caught, image_url)
    VALUES ('Chinook Salmon', 'Salmon', 32.5, 10.4, 'Columbia River', 'Spoon', '2023-09-15', 'https://upload.wikimedia.org/wikipedia/commons/d/dc/OncorhynchusTschawytscha2.jpg');
INSERT INTO fish_inventory (name, type, length, weight, location, lure_used, date_caught, image_url)
    VALUES ('Golden Trout', 'Trout', 12.8, 0.9, 'High Mountain Lake', 'Fly', '2023-10-02', 'https://upload.wikimedia.org/wikipedia/commons/f/fb/California_Golden_Trout.jpg');


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
INSERT INTO fish_tracking_history (fish_id, recorded_date, recorded_length, recorded_weight)
    VALUES (21, '2022-01-25', 47.2, 32.5);
INSERT INTO fish_tracking_history (fish_id, recorded_date, recorded_length, recorded_weight)
    VALUES (22, '2022-02-14', 28.9, 8.7);
INSERT INTO fish_tracking_history (fish_id, recorded_date, recorded_length, recorded_weight)
    VALUES (23, '2022-03-03', 41.5, 26.8);
INSERT INTO fish_tracking_history (fish_id, recorded_date, recorded_length, recorded_weight)
    VALUES (24, '2022-04-21', 31.8, 10.3);
INSERT INTO fish_tracking_history (fish_id, recorded_date, recorded_length, recorded_weight)
    VALUES (25, '2022-05-10', 97.4, 155.2);
INSERT INTO fish_tracking_history (fish_id, recorded_date, recorded_length, recorded_weight)
    VALUES (26, '2022-06-29', 108.7, 205.6);
INSERT INTO fish_tracking_history (fish_id, recorded_date, recorded_length, recorded_weight)
    VALUES (27, '2022-07-18', 6.4, 0.3);
INSERT INTO fish_tracking_history (fish_id, recorded_date, recorded_length, recorded_weight)
    VALUES (28, '2022-08-06', 17.8, 3.2);
INSERT INTO fish_tracking_history (fish_id, recorded_date, recorded_length, recorded_weight)
    VALUES (29, '2022-09-23', 14.6, 2.1);
INSERT INTO fish_tracking_history (fish_id, recorded_date, recorded_length, recorded_weight)
    VALUES (30, '2022-10-11', 13.2, 1);
INSERT INTO fish_tracking_history (fish_id, recorded_date, recorded_length, recorded_weight)
    VALUES (31, '2022-11-30', 118.3, 319.7);
INSERT INTO fish_tracking_history (fish_id, recorded_date, recorded_length, recorded_weight)
    VALUES (32, '2022-12-19', 30.9, 10.2);
INSERT INTO fish_tracking_history (fish_id, recorded_date, recorded_length, recorded_weight)
    VALUES (33, '2023-03-03', 45.3, 22.1);
INSERT INTO fish_tracking_history (fish_id, recorded_date, recorded_length, recorded_weight)
    VALUES (34, '2023-04-20', 9.6, 0.6);
INSERT INTO fish_tracking_history (fish_id, recorded_date, recorded_length, recorded_weight)
    VALUES (35, '2023-05-08', 38.6, 13.8);
INSERT INTO fish_tracking_history (fish_id, recorded_date, recorded_length, recorded_weight)
    VALUES (36, '2023-06-26', 21.1, 6.2);
INSERT INTO fish_tracking_history (fish_id, recorded_date, recorded_length, recorded_weight)
    VALUES (37, '2023-07-14', 10.7, 0.7);
INSERT INTO fish_tracking_history (fish_id, recorded_date, recorded_length, recorded_weight)
    VALUES (38, '2023-08-25', 19.2, 4.7);
INSERT INTO fish_tracking_history (fish_id, recorded_date, recorded_length, recorded_weight)
    VALUES (39, '2023-09-15', 32.5, 10.4);
INSERT INTO fish_tracking_history (fish_id, recorded_date, recorded_length, recorded_weight)
    VALUES (40, '2023-10-02', 12.8, 0.9);


COMMIT TRANSACTION;
