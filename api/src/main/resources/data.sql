INSERT INTO user_entity (username, birthday, created_date, about, following_count, followme_count)
VALUES
    ('john_doe', '1990-05-15', '2022-01-10', 'I love coding.', 300, 500),
    ('jane_smith', '1985-08-20', '2021-11-22', 'Passionate about travel.', 200, 400),
    ('mike_jackson', '1995-03-05', '2022-03-15', 'Exploring the world.', 150, 300),
    ('sara_wilson', '1980-12-10', '2020-09-28', 'Nature lover.', 400, 700),
    ('chris_martin', '1992-07-01', '2023-04-02', 'Music enthusiast.', 250, 350);

INSERT INTO user_follower_entity (id,user_id, follower_id)
VALUES
    ('b7a61937-6f59-4bbb-80a7-08d65d1ad640','john_doe', 'jane_smith'),
    ('1e61da98-e8d9-4e82-b2a0-bc53b124aef1','john_doe', 'mike_jackson'),
    ('b5d35e6e-7404-4fc0-9bc5-a265e9fca71b','john_doe', 'sara_wilson'),
    ('2ae12264-977d-419d-aa19-ce9658041fe4','john_doe', 'chris_martin');




