INSERT INTO user (ID, BIRTHDAY, CREATED_DATE, ABOUT, FOLLOWING_COUNT, FOLLOWING_ME_COUNT)
VALUES
    ('john_doe', '1990-05-15', '2022-01-10', 'I love coding.', 300, 500),
    ('jane_smith', '1985-08-20', '2021-11-22', 'Passionate about travel.', 200, 400),
    ('mike_jackson', '1995-03-05', '2022-03-15', 'Exploring the world.', 150, 300),
    ('sara_wilson', '1980-12-10', '2020-09-28', 'Nature lover.', 400, 700),
    ('chris_martin', '1992-07-01', '2023-04-02', 'Music enthusiast.', 250, 350);


INSERT INTO user_follower (user_id, follower_id)
VALUES
    ('john_doe', 'jane_smith'),
    ('john_doe', 'mike_jackson'),
    ('john_doe', 'sara_wilson'),
    ('john_doe', 'chris_martin');
