set foreign_key_checks=0;
INSERT INTO user (ID, USERNAME, BIRTHDAY, CREATED_DATE, ABOUT, FOLLOWING_COUNT, FOLLOWING_ME_COUNT)
VALUES
    ('b7a61937-6f59-4bbb-80a7-08d65d1ad656','john_doe', '1990-05-15', '2050-01-10', 'I love coding.', 300, 500),
    ('1e61da98-e8d9-4e82-b2a0-bc53b124aef1','jane_smith', '1985-08-20', '2050-11-22', 'Passionate about travel.', 200, 400),
    ('b5d35e6e-7404-4fc0-9bc5-a265e9fca71b','mike_jackson', '1995-03-05', '2052-03-15', 'Exploring the world.', 150, 300),
    ('2ae12264-977d-419d-aa19-ce9658041fe4','sara_wilson', '1980-12-10', '2050-09-28', 'Nature lover.', 400, 700),
    ('6f95b5af-4d6f-448c-8f3d-ca54521f4653','chris_martin', '1992-07-01', '2052-04-02', 'Music enthusiast.', 250, 350);


INSERT INTO user_follower (ID, USER_ID, FOLLOWER_ID, FOLLOW_SINCE)
VALUES
    ('2159ecc3-4778-4b42-add2-72228311c05b','b7a61937-6f59-4bbb-80a7-08d65d1ad656', '1e61da98-e8d9-4e82-b2a0-bc53b124aef1', '1990-05-15'),
    ('11051c40-668b-4106-b126-9efb104d8b48','b7a61937-6f59-4bbb-80a7-08d65d1ad656', 'b5d35e6e-7404-4fc0-9bc5-a265e9fca71b', '1980-12-10'),
    ('e93690b7-cc29-40f6-924b-cc6352215df7','b7a61937-6f59-4bbb-80a7-08d65d1ad656', '2ae12264-977d-419d-aa19-ce9658041fe4', '1980-12-10'),
    ('470f3178-27b7-4356-b927-b86d3bb6b34b','b7a61937-6f59-4bbb-80a7-08d65d1ad656', '6f95b5af-4d6f-448c-8f3d-ca54521f4653', '1985-08-20'),
    ('d56f2fbd-b119-482c-916e-d2ba68a892ac','1e61da98-e8d9-4e82-b2a0-bc53b124aef1', 'b7a61937-6f59-4bbb-80a7-08d65d1ad656', '1985-05-21');

INSERT INTO film (id, FILM_TYPE, TITTLE, SYNOPSIS, ORIGINAL_LANGUAGE, DISTRIBUTOR, SUITABLE_FOR, STREAMING_RELEASE_DATE, PREQUEL_ID, SEQUEL_ID, BOX_OFFICE, RUNTIME, THEATERS_RELEASE_DATE, AT_THEATERS)
VALUES
    ('123e4567-e89b-12d3-a456-556642440001', '2', 'Serie 1', 'Synopsis 1', 'ENG', 'Distributor 1', 'PG-13', '2023-09-27', NULL, '223e4567-e89b-12d3-a456-556642440002',NULL,NULL,NULL,NULL),
    ('223e4567-e89b-12d3-a456-556642440002', '2', 'Serie 2', 'Synopsis 2', 'FRE', 'Distributor 2', 'R', '2023-10-05', '123e4567-e89b-12d3-a456-556642440001', NULL,NULL,NULL,NULL,NULL),
    ('323e4567-e89b-12d3-a456-556642440003', '2', 'Serie 3', 'Synopsis 3', 'ESP', 'Distributor 3', 'G', '2023-11-15', NULL, NULL,NULL,NULL,NULL,NULL),
    ('423e4567-e89b-12d3-a456-556642440004', '2', 'Serie 4', 'Synopsis 4', 'GER', 'Distributor 4', 'PG', '2023-12-20', '323e4567-e89b-12d3-a456-556642440003', NULL,NULL,NULL,NULL,NULL),
    ('523e4567-e89b-12d3-a456-556642440005', '2', 'Serie 5', 'Synopsis 5', 'ITA', 'Distributor 5', 'PG-13', '2024-01-10', NULL, '623e4567-e89b-12d3-a456-556642440006',NULL,NULL,NULL,NULL),
    ('623e4567-e89b-12d3-a456-556642440006', '2', 'Serie 6', 'Synopsis 6', 'JPN', 'Distributor 6', 'R', '2024-02-18', NULL, '523e4567-e89b-12d3-a456-556642440005',NULL,NULL,NULL,NULL),
    ('723e4567-e89b-12d3-a456-556642440007', '2', 'Serie 7', 'Synopsis 7', 'CHN', 'Distributor 7', 'G', '2024-03-25', '623e4567-e89b-12d3-a456-556642440006', '823e4567-e89b-12d3-a456-556642440008',NULL,NULL,NULL,NULL),
    ('823e4567-e89b-12d3-a456-556642440008', '2', 'Serie 8', 'Synopsis 8', 'KOR', 'Distributor 8', 'PG', '2024-04-30', '723e4567-e89b-12d3-a456-556642440007', NULL,NULL,NULL,NULL,NULL),
    ('923e4567-e89b-12d3-a456-556642440009', '2', 'Serie 9', 'Synopsis 9', 'RUS', 'Distributor 9', 'PG-13', '2024-05-10', NULL, '055b9e94-3e71-4c33-ba92-3d5afc9e353f',NULL,NULL,NULL,NULL),
    ('055b9e94-3e71-4c33-ba92-3d5afc9e353f', '2', 'Serie 10', 'Synopsis 10', 'BRA', 'Distributor 10', 'R', '2024-06-05', '923e4567-e89b-12d3-a456-556642440009', NULL,NULL,NULL,NULL,NULL);

INSERT INTO film (id, FILM_TYPE,TITTLE, SYNOPSIS, ORIGINAL_LANGUAGE, DISTRIBUTOR, SUITABLE_FOR, STREAMING_RELEASE_DATE, PREQUEL_ID, SEQUEL_ID, BOX_OFFICE, RUNTIME, THEATERS_RELEASE_DATE, AT_THEATERS) VALUES
    ('1a7b4a82-4823-4d79-8c7c-5b7ea9cd9d01', '1', 'Movie 1', 'Synopsis 1', 'ENG', 'Distributor 1', 'PG-13', '2023-09-27', NULL,'7a7b4a82-4823-4d79-8c7c-5b7ea9cd9d07', '1000000', '120', '2023-10-05', TRUE),
    ('10431aac-d368-4df8-addb-be5c0b8812fb', '1', 'Movie 2', 'Synopsis 2', 'FRE', 'Distributor 2', 'R', '2023-10-05', '1a7b4a82-4823-4d79-8c7c-5b7ea9cd9d01', NULL, '750000', '90', '2023-11-15', FALSE),
    ('3a7b4a82-4823-4d79-8c7c-5b7ea9cd9d03', '1', 'Movie 3', 'Synopsis 3', 'ESP', 'Distributor 3', 'G', '2023-11-15', NULL, NULL, '500000', '105', '2023-12-20', TRUE),
    ('4a7b4a82-4823-4d79-8c7c-5b7ea9cd9d04', '1', 'Movie 4', 'Synopsis 4', 'GER', 'Distributor 4', 'PG', '2023-12-20', '3a7b4a82-4823-4d79-8c7c-5b7ea9cd9d03', NULL, '850000', '135', '2024-01-10', TRUE),
    ('5a7b4a82-4823-4d79-8c7c-5b7ea9cd9d05', '1', 'Movie 5', 'Synopsis 5', 'ITA', 'Distributor 5', 'PG-13', '2024-01-10', NULL, '6a7b4a82-4823-4d79-8c7c-5b7ea9cd9d06', '1200000', '180', '2024-02-18', FALSE),
    ('6a7b4a82-4823-4d79-8c7c-5b7ea9cd9d06', '1', 'Movie 6', 'Synopsis 6', 'JPN', 'Distributor 6', 'R', '2024-02-18', NULL, '1a7b4a82-4823-4d79-8c7c-5b7ea9cd9d01', '650000', '95', '2024-03-25', TRUE),
    ('7a7b4a82-4823-4d79-8c7c-5b7ea9cd9d07', '1', 'Movie 7', 'Synopsis 7', 'CHN', 'Distributor 7', 'PG-13', '2024-03-25', '6a7b4a82-4823-4d79-8c7c-5b7ea9cd9d06', NULL, '900000', '140', '2024-04-30', TRUE),
    ('8a7b4a82-4823-4d79-8c7c-5b7ea9cd9d08', '1', 'Movie 8', 'Synopsis 8', 'KOR', 'Distributor 8', 'PG', '2024-04-30', '7a7b4a82-4823-4d79-8c7c-5b7ea9cd9d07', NULL, '550000', '105', '2024-05-10', FALSE),
    ('9a7b4a82-4823-4d79-8c7c-5b7ea9cd9d09', '1', 'Movie 9', 'Synopsis 9', 'RUS', 'Distributor 9', 'PG-13', '2024-05-10', NULL, '863b6d8b-f19a-4bd2-99e2-67a473189e3c', '1100000', '115', '2024-06-05', TRUE),
    ('863b6d8b-f19a-4bd2-99e2-67a473189e3c', '1', 'Movie 10', 'Synopsis 10', 'BRA', 'Distributor 10', 'R', '2024-06-05', '9a7b4a82-4823-4d79-8c7c-5b7ea9cd9d09', NULL, '800000', '160', '2024-07-15', TRUE);

INSERT INTO staff(id, biography, birthday, birth_place, first_name, last_name)
VALUES
    ('8c137b7c-f69e-4b4e-8308-e8b787720b6e', 'Sample biography 1', '1990-05-15', 'Sample Place 1', 'John', 'Doe'),
    ('3a05a600-416c-4b10-b050-e408f10e1c93', 'Sample biography 2', '1985-08-22', 'Sample Place 2', 'Jane', 'Smith'),
    ('3a0b5202-c980-41cd-b20e-deadf8ba3229', 'Sample biography 3', '1995-03-10', 'Sample Place 3', 'David', 'Johnson'),
    ('05331795-d1de-4000-a9e9-73e91dac98b4', 'Sample biography 4', '1980-12-03', 'Sample Place 4', 'Alice', 'Brown'),
    ('b1ea82fa-3b0e-4e7c-8719-c27aaaac8f54', 'Sample biography 5', '1998-07-28', 'Sample Place 5', 'Michael', 'Wilson');

INSERT INTO social (id, name) VALUES
    ('5a32b1b3-9e91-4354-9bb9-ce2f7f84beb6', 'Twitter'),
    ('f6e264e3-d1fd-49eb-b0b1-d032b648749f', 'Facebook'),
    ('c85cdab6-d449-49eb-96e8-206854e86925', 'Instagram'),
    ('56445d2a-c493-4e0a-9bdc-571b9960d54f', 'TikTok'),
    ('16c3633d-0481-4be6-815d-0ee2d641339f', 'Youtube'),
    ('49631bb2-bcd4-4de7-8c42-bdc8eda69170', 'Snapchat');

INSERT INTO social_staff(id, url, social_id, entity_id) VALUES
    ('4636c464-7955-4f0c-8d9c-b2b69e86c99e','https://www.twitch.tv/Youtube','16c3633d-0481-4be6-815d-0ee2d641339f','8c137b7c-f69e-4b4e-8308-e8b787720b6e'),
    ('34c40978-97cb-4943-a317-be672db1574d','https://www.twitch.tv/twitter','5a32b1b3-9e91-4354-9bb9-ce2f7f84beb6','8c137b7c-f69e-4b4e-8308-e8b787720b6e'),
    ('32a25f4d-076f-4ec0-a248-134f067130fa','https://www.twitch.tv/nstagram','c85cdab6-d449-49eb-96e8-206854e86925','05331795-d1de-4000-a9e9-73e91dac98b4');

INSERT INTO social_user(id, url, social_id, entity_id) VALUES
    ('48061921-4c04-424a-a239-3e37164285d5','https://www.twitch.tv/tiktok','56445d2a-c493-4e0a-9bdc-571b9960d54f','b7a61937-6f59-4bbb-80a7-08d65d1ad656'),
    ('96806207-8ed7-4767-baaf-efe50eaead7a','https://www.twitch.tv/snapchat','49631bb2-bcd4-4de7-8c42-bdc8eda69170','b7a61937-6f59-4bbb-80a7-08d65d1ad656'),
    ('a4122962-5306-436d-833d-7c57f77bb348','https://www.twitch.tv/facebook','f6e264e3-d1fd-49eb-b0b1-d032b648749f','b7a61937-6f59-4bbb-80a7-08d65d1ad656');

INSERT INTO film_staff(id, appear_as, role, film_id, staff_id) VALUES
    ('432d5b2e-dfb4-481c-8c02-3249f7537940','extra 1','extra','1a7b4a82-4823-4d79-8c7c-5b7ea9cd9d01','8c137b7c-f69e-4b4e-8308-e8b787720b6e'),
    ('8d55aeba-aef8-4426-be61-fc6de9030193','','director','1a7b4a82-4823-4d79-8c7c-5b7ea9cd9d01','3a05a600-416c-4b10-b050-e408f10e1c93'),
    ('72a81c30-9766-4234-968c-efc194526b13','main character','actor','1a7b4a82-4823-4d79-8c7c-5b7ea9cd9d01','3a0b5202-c980-41cd-b20e-deadf8ba3229');

INSERT INTO rating(id, rating, super_rating, film_id, user_id) VALUES
    ('79302784-2f46-4aad-abba-43ad49bd3d1a','98',TRUE,'1a7b4a82-4823-4d79-8c7c-5b7ea9cd9d01','b7a61937-6f59-4bbb-80a7-08d65d1ad656'),
    ('413b6ea7-2ae3-41e8-b26f-010bef1809ee','90',TRUE,'423e4567-e89b-12d3-a456-556642440004','b7a61937-6f59-4bbb-80a7-08d65d1ad656'),
    ('19a67d4e-cfc5-4e37-b395-978745859128','60',TRUE,'9a7b4a82-4823-4d79-8c7c-5b7ea9cd9d09','b7a61937-6f59-4bbb-80a7-08d65d1ad656'),
    ('092217a2-7559-4933-b8c1-35b9ba1de95d','100',FALSE,'1a7b4a82-4823-4d79-8c7c-5b7ea9cd9d01','1e61da98-e8d9-4e82-b2a0-bc53b124aef1'),
    ('052533f4-d50d-4dc8-901b-7426698b0859','72',FALSE,'1a7b4a82-4823-4d79-8c7c-5b7ea9cd9d01','2ae12264-977d-419d-aa19-ce9658041fe4'),
    ('661548dc-1cfe-48e9-a19e-8df315e10189','35',FALSE,'9a7b4a82-4823-4d79-8c7c-5b7ea9cd9d09','2ae12264-977d-419d-aa19-ce9658041fe4');

INSERT INTO stream(id, name, price) VALUES
    ('7b0c02cc-efaa-4d9b-8619-8babb56e7b40','Netflix','99'),
    ('888360fc-ea1f-42cd-b51e-16ad39bc47bb','Hulu','50'),
    ('a7c2b80f-8bfa-43ee-89d9-d781f281d14b','Amazon Prime Vide','100'),
    ('58090783-9f69-46b2-b931-f91b11973121','Disney+','120');

INSERT INTO stream_film(id, buy, rent, url, film_id, stream_id) VALUES
    ('5b344dbe-082c-47bf-8dd4-4bb6415e22f8', TRUE, FALSE, 'http://netflix.com/movie5','5a7b4a82-4823-4d79-8c7c-5b7ea9cd9d05','7b0c02cc-efaa-4d9b-8619-8babb56e7b40'),
    ('143bf786-f1be-40ff-9b55-77f747abc920', TRUE, FALSE, 'http://netflix.com/movie6','7a7b4a82-4823-4d79-8c7c-5b7ea9cd9d07','7b0c02cc-efaa-4d9b-8619-8babb56e7b40'),
    ('9463d673-4cf6-487f-80f8-ed882afbb3fc', FALSE, TRUE, 'http://hulu.com/movie1','1a7b4a82-4823-4d79-8c7c-5b7ea9cd9d01','888360fc-ea1f-42cd-b51e-16ad39bc47bb'),
    ('4bc0eb01-fa0f-4768-b9d2-9777ba8415b5', FALSE, FALSE, 'http://netflix.com/movie1','1a7b4a82-4823-4d79-8c7c-5b7ea9cd9d01','7b0c02cc-efaa-4d9b-8619-8babb56e7b40'),
    ('c73658b2-f09c-46b3-b81d-da4b4ca2c570', TRUE, TRUE, 'http://primeVideo.com/movie1','1a7b4a82-4823-4d79-8c7c-5b7ea9cd9d01','a7c2b80f-8bfa-43ee-89d9-d781f281d14b');

INSERT INTO genre(id, genre) VALUES
    ('4ba05e0c-43d7-45b1-943f-d3a8b863dec1', 'Action'),
    ('dbe4b00f-7817-44aa-9942-bf05da8fb84f', 'Adventure'),
    ('655ce3a7-2c2a-4bd0-8b0a-002119422b82', 'Animation'),
    ('acbcd5e3-3ee0-490b-8bb3-aa324d342ed5', 'Anime'),
    ('9b243158-2f21-428f-aab1-2c3e83fd086d', 'Comedy'),
    ('991a8129-4c2d-4afa-8bb9-104fd745b8c6', 'Crime'),
    ('036ace82-a0e5-44ff-9a66-5b68b1027062', 'Documentary'),
    ('8538728a-c957-4435-91d0-8ccaf6223ca6', 'Drama'),
    ('fc7b3614-270d-49e1-af3e-b5e08779f4a0', 'Entretainment'),
    ('98e8983f-63fc-4c5e-b1fb-138d635c7f8b', 'Fantasy'),
    ('1a37e291-cae8-4cc6-8532-548ae92f2ad3', 'Horror'),
    ('60dce741-c75a-4f02-a36a-a1ba1d2d370c', 'History'),
    ('48faa47e-2765-4a30-b1d8-bc847c78fd56', 'News'),
    ('66a64410-6c10-4fb5-9d5c-58f70ff367a9', 'Sci-fi'),
    ('0753869f-56a3-4cfc-a541-3ba07a443166', 'Romance'),
    ('a3dfd418-26d1-4ff2-ac86-614c90e99ba7', 'Sports'),
    ('bf6d309b-6340-4179-b04e-9231ca9020e9', 'Stand up'),
    ('6b5604cc-f9a8-4183-90c1-d10b46e2f9a4', 'War');

INSERT INTO genre_film(id, film_id, genre_id) VALUES
    ('f7be3075-d09e-4588-a67c-113dddfa4785', '1a7b4a82-4823-4d79-8c7c-5b7ea9cd9d01', '4ba05e0c-43d7-45b1-943f-d3a8b863dec1'),
    ('6edc4050-2d82-44c8-b4b0-d0369a9022ca', '1a7b4a82-4823-4d79-8c7c-5b7ea9cd9d01', 'dbe4b00f-7817-44aa-9942-bf05da8fb84f'),
    ('0ca978c0-e819-4ddd-8a3f-66c2792a3f87', '1a7b4a82-4823-4d79-8c7c-5b7ea9cd9d01', '991a8129-4c2d-4afa-8bb9-104fd745b8c6'),
    ('4634f045-9451-489a-b2e0-db03b78d378a', '1a7b4a82-4823-4d79-8c7c-5b7ea9cd9d01', '66a64410-6c10-4fb5-9d5c-58f70ff367a9'),
    ('1347e498-052d-462f-ad75-8cc74d4ed7a3', '10431aac-d368-4df8-addb-be5c0b8812fb', 'fc7b3614-270d-49e1-af3e-b5e08779f4a0'),
    ('e1e97375-4a61-4b5c-b82f-acb2cef1c3fb', '10431aac-d368-4df8-addb-be5c0b8812fb', 'bf6d309b-6340-4179-b04e-9231ca9020e9'),
    ('f8f5ee6e-8294-4a74-9319-9386c1dcb11a', '10431aac-d368-4df8-addb-be5c0b8812fb', '9b243158-2f21-428f-aab1-2c3e83fd086d'),
    ('fc1d98c2-cb0f-46c2-9cb8-708f30c0f430', '3a7b4a82-4823-4d79-8c7c-5b7ea9cd9d03', '0753869f-56a3-4cfc-a541-3ba07a443166'),
    ('3deada4e-2d85-4d4b-a2e8-211cf2d6cbdb', '3a7b4a82-4823-4d79-8c7c-5b7ea9cd9d03', '60dce741-c75a-4f02-a36a-a1ba1d2d370c'),
    ('a30b66ac-2446-4604-a374-3aabccfc0f00', '3a7b4a82-4823-4d79-8c7c-5b7ea9cd9d03', '036ace82-a0e5-44ff-9a66-5b68b1027062'),
    ('ddfc6e50-79a8-4537-87b9-b7fea45a9c7e', '123e4567-e89b-12d3-a456-556642440001', 'acbcd5e3-3ee0-490b-8bb3-aa324d342ed5'),
    ('3227b5c5-8d06-4980-b575-436e11148f17', '123e4567-e89b-12d3-a456-556642440001', '655ce3a7-2c2a-4bd0-8b0a-002119422b82'),
    ('ab5adde6-b0bb-41fe-a97b-49f1a1d0e862', '123e4567-e89b-12d3-a456-556642440001', '98e8983f-63fc-4c5e-b1fb-138d635c7f8b'),
    ('94cc00b5-2071-4f49-9041-a51be180fdbb', '7a7b4a82-4823-4d79-8c7c-5b7ea9cd9d07', 'dbe4b00f-7817-44aa-9942-bf05da8fb84f');
set foreign_key_checks=1;

--select distinct film.id, film.tittle
--from film
--inner join stream_film
--on stream_film.film_id=film.id
--inner join genre_film
--on genre_film.film_id=film.id
--where stream_film.stream_id="7b0c02cc-efaa-4d9b-8619-8babb56e7b40"
--and genre_film.genre_id in ("4ba05e0c-43d7-45b1-943f-d3a8b863dec1", "dbe4b00f-7817-44aa-9942-bf05da8fb84f")
--and film.suitable_for = "PG-13"
--and film.film_type = '1'
--and film.at_theaters = TRUE
--and film.cooming_soon is not null
--and film.streaming_release_date is not null;


--select distinct film.*
--    from stream_film
--        inner join (select distinct genre_film.film_id
--                        from genre_film
--                            where genre_film.genre_id in
--                             ("4ba05e0c-43d7-45b1-943f-d3a8b863dec1",
--                             "dbe4b00f-7817-44aa-9942-bf05da8fb84f"))
--                             as t1 on t1.film_id= stream_film.film_id
--        inner join film
--            on film.id = t1.film_id
--        where stream_film.stream_id = "7b0c02cc-efaa-4d9b-8619-8babb56e7b40"
--        and film.suitable_for = "PG-13";

