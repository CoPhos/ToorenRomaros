set foreign_key_checks=0;
--INSERT INTO video(id, file_path, name) VALUES
--    ('3a662730-eb02-4d41-be85-9b46ae6613c4','/path/to/video','video1');

--INSERT INTO image(id, created_at, file_path, size, image_type, owner_type, owner_id) VALUES
--    ('4894c62c-0f28-40d9-a886-f828953d7c44','2028-11-02 13:48:22','/home/cophos/spring-workspace/tooren_romaros/api/src/main/resources/media/tokyoDriftMainImag.jpg','desktop','filmMainImage','M','863b6d8b-f19a-4bd2-99e2-67a473189e3c'),
--    ('b3d3d65a-12b6-4ea7-8deb-d073ef1a0396','2028-11-02 13:48:22','/home/cophos/spring-workspace/tooren_romaros/api/src/main/resources/media/richTextImage1.jpg','desktop','richText','RT','35019f7b-db70-403f-a1cc-ac2f4bb8aae4'),
--    ('76e9e54c-1ef3-4380-b5eb-63acb7a85883','2028-11-02 13:48:22','/home/cophos/spring-workspace/tooren_romaros/api/src/main/resources/media/richTextImage2.jpg','desktop','richText','RT','35019f7b-db70-403f-a1cc-ac2f4bb8aae4'),
--    ('92c1c7a0-bd83-4646-acf0-afa0d4231d2f','2028-11-02 13:48:22','/home/cophos/spring-workspace/tooren_romaros/api/src/main/resources/media/richTextMain.jpg','desktop','richTextMainImage','RT','35019f7b-db70-403f-a1cc-ac2f4bb8aae4'),
--    ('0669bb03-c882-48cf-baec-2cc83c1eb221','2028-11-02 13:48:22','/home/cophos/spring-workspace/tooren_romaros/api/src/main/resources/media/thumbail.jpg','desktop','videoThumbail','V','3a662730-eb02-4d41-be85-9b46ae6613c4'),
--    ('69528eb9-1eab-4c18-822c-de216b77759a','2028-11-02 13:48:22','/home/cophos/spring-workspace/tooren_romaros/api/src/main/resources/media/tokyoDriftImage1.jpg','desktop','film','M','863b6d8b-f19a-4bd2-99e2-67a473189e3c'),
--    ('dc887fa6-113d-4590-8376-4b7dddc8216b','2028-11-02 13:48:22','/home/cophos/spring-workspace/tooren_romaros/api/src/main/resources/media/tokyoDriftImage2.jpg','desktop','film','M','863b6d8b-f19a-4bd2-99e2-67a473189e3c');


--INSERT INTO discuss (id, body, like_count, publication_datetime, reported, post_id, user_id) VALUES
--    ('3a7b4a82-4823-4d79-8c7c-5b7ea9cd9d03', 'Discussion topic.', 15, '2028-10-15 10:45:00', 0, NULL, '4a7b4a82-4823-4d79-8c7c-5b7ea9cd9d04'),
--    ('49cb02ba-9a1b-45ab-85d3-9a04f3a3e053', 'Discussing something important.', 8, '2028-10-15 12:00:00', 0, NULL, '3a7b4a82-4823-4d79-8c7c-5b7ea9cd9d03');

--INSERT INTO discuss (id, body, like_count, publication_datetime, reported, post_id, user_id)
--VALUES
--    ('4a7b4a82-4823-4d79-8c7c-5b7ea9cd9d04', 'I have some questions', '2', '2028-10-16 10:15:00', FALSE, '1a7b4a82-4823-4d79-8c7c-5b7ea9cd9d01', '3a7b4a82-4823-4d79-8c7c-5b7ea9cd9d03'),
--    ('5a7b4a82-4823-4d79-8c7c-5b7ea9cd9d05', 'Let's discuss this!', '4', '2028-10-16 11:30:00', FALSE, '2a7b4a82-4823-4d79-8c7c-5b7ea9cd9d02', '4a7b4a82-4823-4d79-8c7c-5b7ea9cd9d04');

---- Sample data for the "post" table
--INSERT INTO post (id, content, like_count, publication_datetime, synthesis, tittle, user_id)
--VALUES
--    ('1a7b4a82-4823-4d79-8c7c-5b7ea9cd9d01', 'This is an interesting post about the movie.', '12', '2028-10-17 13:15:00', 'A discussion about the movie', 'Movie Discussion', '4a7b4a82-4823-4d79-8c7c-5b7ea9cd9d04'),
--    ('2a7b4a82-4823-4d79-8c7c-5b7ea9cd9d02', 'Join the discussion!', '5', '2028-10-17 14:30:00', 'Let's talk about the film.', 'Film Talk', '5a7b4a82-4823-4d79-8c7c-5b7ea9cd9d05');
set foreign_key_checks=1;