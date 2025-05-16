INSERT INTO users (id, name, preferences_id)
VALUES (1, 'Allison Hill', NULL);
INSERT INTO users (id, name, preferences_id)
VALUES (2, 'Noah Rhodes', NULL);
INSERT INTO users (id, name, preferences_id)
VALUES (3, 'Angie Henderson', NULL);

INSERT INTO transit_routes (id, route_name)
VALUES (1, 'Route 1');

INSERT INTO transit_routes_users (route_id, user_id)
VALUES (1, 1);
INSERT INTO transit_routes_users (route_id, user_id)
VALUES (1, 2);
INSERT INTO transit_routes_users (route_id, user_id)
VALUES (1, 3);

INSERT INTO artists (id, name, genre, popularity)
VALUES (201, 'Artist One', 'Pop', 80);
INSERT INTO artists (id, name, genre, popularity)
VALUES (202, 'Artist Two', 'Hip-Hop', 75);

INSERT INTO albums (id, title, release_date)
VALUES (301, 'Test Album', '2022-01-01');
INSERT INTO tracks (id, title, duration, album_id)

VALUES (101, 'Track A', 220, 301);
INSERT INTO tracks (id, title, duration, album_id)
VALUES (102, 'Track B', 187, 301);
INSERT INTO tracks (id, title, duration, album_id)
VALUES (103, 'Track C', 181, 301);
INSERT INTO tracks_artists (track_id, artist_id)
VALUES (101, 201);
INSERT INTO tracks_artists (track_id, artist_id)
VALUES (102, 202);
INSERT INTO tracks_artists (track_id, artist_id)
VALUES (103, 201);
INSERT INTO music_activity (user_id, track_id, timestamp)
VALUES (3, 102, '2025-05-14 06:02:39');
INSERT INTO music_activity (user_id, track_id, timestamp)
VALUES (1, 101, '2025-05-14 10:41:49');
INSERT INTO music_activity (user_id, track_id, timestamp)
VALUES (1, 103, '2025-05-14 19:47:42');
INSERT INTO music_activity (user_id, track_id, timestamp)
VALUES (1, 103, '2025-05-14 20:48:58');
INSERT INTO music_activity (user_id, track_id, timestamp)
VALUES (3, 103, '2025-05-15 16:40:23');
INSERT INTO music_activity (user_id, track_id, timestamp)
VALUES (1, 103, '2025-05-15 23:42:43');
INSERT INTO music_activity (user_id, track_id, timestamp)
VALUES (2, 101, '2025-05-14 05:48:24');
INSERT INTO music_activity (user_id, track_id, timestamp)
VALUES (1, 101, '2025-05-15 20:44:35');
INSERT INTO music_activity (user_id, track_id, timestamp)
VALUES (1, 101, '2025-05-14 18:21:12');
INSERT INTO music_activity (user_id, track_id, timestamp)
VALUES (3, 103, '2025-05-16 03:11:51');