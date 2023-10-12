set foreign_key_checks=0;
INSERT INTO user (ID,USERNAME, BIRTHDAY, CREATED_DATE, ABOUT, FOLLOWING_COUNT, FOLLOWING_ME_COUNT)
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
    ('123e4567-e89b-12d3-a456-556642440001', '2', 'Movie 1', 'Synopsis 1', 'ENG', 'Distributor 1', 'PG-13', '2023-09-27', NULL, '223e4567-e89b-12d3-a456-556642440002',NULL,NULL,NULL,NULL),
    ('223e4567-e89b-12d3-a456-556642440002', '2', 'Movie 2', 'Synopsis 2', 'FRE', 'Distributor 2', 'R', '2023-10-05', '123e4567-e89b-12d3-a456-556642440001', NULL,NULL,NULL,NULL,NULL),
    ('323e4567-e89b-12d3-a456-556642440003', '2', 'Movie 3', 'Synopsis 3', 'ESP', 'Distributor 3', 'G', '2023-11-15', NULL, NULL,NULL,NULL,NULL,NULL),
    ('423e4567-e89b-12d3-a456-556642440004', '2', 'Movie 4', 'Synopsis 4', 'GER', 'Distributor 4', 'PG', '2023-12-20', '323e4567-e89b-12d3-a456-556642440003', NULL,NULL,NULL,NULL,NULL),
    ('523e4567-e89b-12d3-a456-556642440005', '2','Movie 5', 'Synopsis 5', 'ITA', 'Distributor 5', 'PG-13', '2024-01-10', NULL, '623e4567-e89b-12d3-a456-556642440006',NULL,NULL,NULL,NULL),
    ('623e4567-e89b-12d3-a456-556642440006', '2', 'Movie 6', 'Synopsis 6', 'JPN', 'Distributor 6', 'R', '2024-02-18', NULL, '523e4567-e89b-12d3-a456-556642440005',NULL,NULL,NULL,NULL),
    ('723e4567-e89b-12d3-a456-556642440007', '2', 'Movie 7', 'Synopsis 7', 'CHN', 'Distributor 7', 'G', '2024-03-25', '623e4567-e89b-12d3-a456-556642440006', '823e4567-e89b-12d3-a456-556642440008',NULL,NULL,NULL,NULL),
    ('823e4567-e89b-12d3-a456-556642440008', '2', 'Movie 8', 'Synopsis 8', 'KOR', 'Distributor 8', 'PG', '2024-04-30', '723e4567-e89b-12d3-a456-556642440007', NULL,NULL,NULL,NULL,NULL),
    ('923e4567-e89b-12d3-a456-556642440009', '2','Movie 9', 'Synopsis 9', 'RUS', 'Distributor 9', 'PG-13', '2024-05-10', NULL, '055b9e94-3e71-4c33-ba92-3d5afc9e353f',NULL,NULL,NULL,NULL),
    ('055b9e94-3e71-4c33-ba92-3d5afc9e353f', '2','Movie 10', 'Synopsis 10', 'BRA', 'Distributor 10', 'R', '2024-06-05', '923e4567-e89b-12d3-a456-556642440009', NULL,NULL,NULL,NULL,NULL);

INSERT INTO film (id, FILM_TYPE,TITTLE, SYNOPSIS, ORIGINAL_LANGUAGE, DISTRIBUTOR, SUITABLE_FOR, STREAMING_RELEASE_DATE, PREQUEL_ID, SEQUEL_ID, BOX_OFFICE, RUNTIME, THEATERS_RELEASE_DATE, AT_THEATERS) VALUES
    ('1a7b4a82-4823-4d79-8c7c-5b7ea9cd9d01', '1','Movie 1', 'Synopsis 1', 'ENG', 'Distributor 1', 'PG-13', '2023-09-27', NULL, '2a7b4a82-4823-4d79-8c7c-5b7ea9cd9d02', '1000000', '120', '2023-10-05', TRUE),
    ('2a7b4a82-4823-4d79-8c7c-5b7ea9cd9d02', '1','Movie 2', 'Synopsis 2', 'FRE', 'Distributor 2', 'R', '2023-10-05', '1a7b4a82-4823-4d79-8c7c-5b7ea9cd9d01', NULL, '750000', '90', '2023-11-15', FALSE),
    ('3a7b4a82-4823-4d79-8c7c-5b7ea9cd9d03', '1','Movie 3', 'Synopsis 3', 'ESP', 'Distributor 3', 'G', '2023-11-15', NULL, NULL, '500000', '105', '2023-12-20', TRUE),
    ('4a7b4a82-4823-4d79-8c7c-5b7ea9cd9d04', '1','Movie 4', 'Synopsis 4', 'GER', 'Distributor 4', 'PG', '2023-12-20', '3a7b4a82-4823-4d79-8c7c-5b7ea9cd9d03', NULL, '850000', '135', '2024-01-10', TRUE),
    ('5a7b4a82-4823-4d79-8c7c-5b7ea9cd9d05', '1','Movie 5', 'Synopsis 5', 'ITA', 'Distributor 5', 'PG-13', '2024-01-10', NULL, '6a7b4a82-4823-4d79-8c7c-5b7ea9cd9d06', '1200000', '180', '2024-02-18', FALSE),
    ('6a7b4a82-4823-4d79-8c7c-5b7ea9cd9d06', '1','Movie 6', 'Synopsis 6', 'JPN', 'Distributor 6', 'R', '2024-02-18', NULL, '5a7b4a82-4823-4d79-8c7c-5b7ea9cd9d05', '650000', '95', '2024-03-25', TRUE),
    ('7a7b4a82-4823-4d79-8c7c-5b7ea9cd9d07', '1','Movie 7', 'Synopsis 7', 'CHN', 'Distributor 7', 'G', '2024-03-25', '6a7b4a82-4823-4d79-8c7c-5b7ea9cd9d06', '8a7b4a82-4823-4d79-8c7c-5b7ea9cd9d08', '900000', '140', '2024-04-30', TRUE),
    ('8a7b4a82-4823-4d79-8c7c-5b7ea9cd9d08', '1','Movie 8', 'Synopsis 8', 'KOR', 'Distributor 8', 'PG', '2024-04-30', '7a7b4a82-4823-4d79-8c7c-5b7ea9cd9d07', NULL, '550000', '105', '2024-05-10', FALSE),
    ('9a7b4a82-4823-4d79-8c7c-5b7ea9cd9d09', '1','Movie 9', 'Synopsis 9', 'RUS', 'Distributor 9', 'PG-13', '2024-05-10', NULL, '863b6d8b-f19a-4bd2-99e2-67a473189e3c', '1100000', '115', '2024-06-05', TRUE),
    ('863b6d8b-f19a-4bd2-99e2-67a473189e3c', '1','Movie 10', 'Synopsis 10', 'BRA', 'Distributor 10', 'R', '2024-06-05', '9a7b4a82-4823-4d79-8c7c-5b7ea9cd9d09', NULL, '800000', '160', '2024-07-15', TRUE);

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

set foreign_key_checks=1;