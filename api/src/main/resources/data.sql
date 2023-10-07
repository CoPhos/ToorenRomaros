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
    ('49631bb2-bcd4-4de7-8c42-bdc8eda69170', 'Snapchat');
