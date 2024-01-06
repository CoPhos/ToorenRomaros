set foreign_key_checks=0;
--common users
INSERT INTO user (
    ID,
    USERNAME,
    BIRTHDAY,
    CREATED_DATE,
    ABOUT,
    FOLLOWING_COUNT,
    FOLLOWING_ME_COUNT,
    EMAIL,
    PASSWORD,
    ROLE,
    USER_STATUS)
VALUES
        ('b7a61937-6f59-4bbb-80a7-08d65d1ad656',
        'john.doe',
        '1990-05-15',
        '2050-01-10',
        'I love coding.',
        0,
        0,
        'john.doe@email.com',
        '{bcrypt}$2a$10$neR0EcYY5./tLVp4litNyuBy/kfrTsqEv8hiyqEKX0TXIQQwC/5Rm',
        'USER',
        'ACTIVE'
    ),
        ('1e61da98-e8d9-4e82-b2a0-bc53b124aef1',
        'jane.smith',
        '1985-08-20',
        '2050-11-22',
        'Passionate about travel.',
        0,
        0,
        'jane.smith@email.com',
        '{bcrypt}$2a$10$neR0EcYY5./tLVp4litNyuBy/kfrTsqEv8hiyqEKX0TXIQQwC/5Rm',
        'USER',
        'ACTIVE'
    ),
        ('b5d35e6e-7404-4fc0-9bc5-a265e9fca71b',
        'mike.jackson',
        '1995-03-05',
        '2052-03-15',
        'Exploring the world.',
        0,
        0,
        'mike.jackson@email.com',
        '{bcrypt}$2a$10$neR0EcYY5./tLVp4litNyuBy/kfrTsqEv8hiyqEKX0TXIQQwC/5Rm',
        'USER',
        'ACTIVE'
    ),
    (
        '6e5f46c3-d172-4e14-aeef-7b8aebc9d786',
        'alice_jones',
        '1988-03-10',
        '2023-01-03',
        'Tech enthusiast and book lover.',
        0,
        0,
        'alice.jones@email.com',
        '{bcrypt}$2a$10$neR0EcYY5./tLVp4litNyuBy/kfrTsqEv8hiyqEKX0TXIQQwC/5Rm',
        'USER',
        'ACTIVE'
    ),
    (
        '8b56d48a-28b9-47ab-b8f1-129abac6e593',
        'robert_smith',
        '1975-12-05',
        '2023-01-04',
        'Outdoor adventurer and nature lover.',
        0,
        0,
        'robert.smith@email.com',
        '{bcrypt}$2a$10$neR0EcYY5./tLVp4litNyuBy/kfrTsqEv8hiyqEKX0TXIQQwC/5Rm',
        'USER',
        'ACTIVE'
    ),
    (
        '9d37e1a4-21c8-4e91-a11b-6d991460f7ef',
        'emily_davis',
        '1995-06-18',
        '2023-01-05',
        'Foodie and aspiring chef.',
        0,
        0,
        'emily.davis@email.com',
        '{bcrypt}$2a$10$neR0EcYY5./tLVp4litNyuBy/kfrTsqEv8hiyqEKX0TXIQQwC/5Rm',
        'USER',
        'ACTIVE'
    ),
    (
        'ac84d66d-6efb-4d61-87cb-baaf5a3f83f2',
        'samuel_green',
        '1980-09-27',
        '2023-01-06',
        'Fitness freak and health advocate.',
        0,
        0,
        'samuel.green@email.com',
        '{bcrypt}$2a$10$neR0EcYY5./tLVp4litNyuBy/kfrTsqEv8hiyqEKX0TXIQQwC/5Rm',
        'USER',
        'ACTIVE'
    ),
    (
        'c1e088d9-6e10-4c8e-9d62-63c9a125f092',
        'sophia_wilson',
        '1992-02-14',
        '2023-01-07',
        'Passionate about fashion and design.',
        0,
        0,
        'sophia.wilson@email.com',
        '{bcrypt}$2a$10$neR0EcYY5./tLVp4litNyuBy/kfrTsqEv8hiyqEKX0TXIQQwC/5Rm',
        'USER',
        'ACTIVE'
    ),
    (
        'e75c7e29-4d6c-4424-85d3-b9c813e5b917',
        'david_miller',
        '1983-11-08',
        '2023-01-08',
        'Music lover and guitar player.',
        0,
        0,
        'david.miller@email.com',
        '{bcrypt}$2a$10$neR0EcYY5./tLVp4litNyuBy/kfrTsqEv8hiyqEKX0TXIQQwC/5Rm',
        'USER',
        'ACTIVE'
    ),
    (
        'fb2f9c0c-01ce-4bb5-9377-40bca1fb8794',
        'olivia_walker',
        '1998-07-23',
        '2023-01-09',
        'Aspiring travel blogger and photographer.',
        0,
        0,
        'olivia.walker@email.com',
        '{bcrypt}$2a$10$neR0EcYY5./tLVp4litNyuBy/kfrTsqEv8hiyqEKX0TXIQQwC/5Rm',
        'USER',
        'ACTIVE'
    ),
    (
        'a5d1a2e2-0bf7-4c05-aa0a-36b13f0123b2',
        'william_harris',
        '1972-04-30',
        '2023-01-10',
        'Avid reader and history buff.',
        0,
        0,
        'william.harris@email.com',
        '{bcrypt}$2a$10$neR0EcYY5./tLVp4litNyuBy/kfrTsqEv8hiyqEKX0TXIQQwC/5Rm',
        'USER',
        'ACTIVE'
    ),
    (
        'd8a8bc2b-2873-4469-8f15-3f7b091b34ac',
        'lily_morris',
        '1989-10-12',
        '2023-01-11',
        'Animal lover and pet enthusiast.',
        0,
        0,
        'lily.morris@email.com',
        '{bcrypt}$2a$10$neR0EcYY5./tLVp4litNyuBy/kfrTsqEv8hiyqEKX0TXIQQwC/5Rm',
        'USER',
        'ACTIVE'
    ),
    (
        'fe938b42-9e0b-497b-858b-d2ac18f2a2bd',
        'jason_turner',
        '1978-01-25',
        '2023-01-12',
        'Sports fanatic and fitness trainer.',
        0,
        0,
        'jason.turner@email.com',
        '{bcrypt}$2a$10$neR0EcYY5./tLVp4litNyuBy/kfrTsqEv8hiyqEKX0TXIQQwC/5Rm',
        'USER',
        'ACTIVE'
    );

--critics
INSERT INTO user (
    ID,
    USERNAME,
    BIRTHDAY,
    CREATED_DATE,
    ABOUT,
    FOLLOWING_COUNT,
    FOLLOWING_ME_COUNT,
    EMAIL,
    PASSWORD,
    ROLE,
    USER_STATUS
)
VALUES
    ('2ae12264-977d-419d-aa19-ce9658041fe4',
        'sara.wilson',
        '1980-12-10',
        '2050-09-28',
        'Nature lover.',
        0,
        0,
        'sara.wilson@email.com',
        '{bcrypt}$2a$10$neR0EcYY5./tLVp4litNyuBy/kfrTsqEv8hiyqEKX0TXIQQwC/5Rm',
        'CRITIC',
        'ACTIVE'
    ),
        ('6f95b5af-4d6f-448c-8f3d-ca54521f4653',
        'chris.martin',
        '1992-07-01',
        '2052-04-02',
        'Music enthusiast.',
        0,
        0,
        'chris_martin@email.com',
        '{bcrypt}$2a$10$neR0EcYY5./tLVp4litNyuBy/kfrTsqEv8hiyqEKX0TXIQQwC/5Rm',
        'CRITIC',
        'ACTIVE'
    ),
    (
        '4fbcdb2e-0c16-4bf1-9ce6-1c7e187b243c',
        'katherine_critic',
        '1986-07-08',
        '2023-01-13',
        'Film critic and cinema enthusiast.',
        80,
        60,
        'katherine.critic@email.com',
        'hashed_password',
        'CRITIC',
        'ACTIVE'
    ),
    (
        '7c21d6ae-93d3-48e1-8bf8-098cb9c5b19f',
        'michael_reviewer',
        '1993-12-15',
        '2023-01-14',
        'Book reviewer and literature lover.',
        70,
        50,
        'michael.reviewer@email.com',
        'hashed_password',
        'CRITIC',
        'ACTIVE'
    ),
    (
        'a1cd5239-cb3b-4fe5-8f5b-4d350383aafc',
        'grace_opinionator',
        '1984-04-22',
        '2023-01-15',
        'Opinion columnist with a flair for writing.',
        90,
        70,
        'grace.opinionator@email.com',
        'hashed_password',
        'CRITIC',
        'ACTIVE'
    ),
    (
        'c0f80a26-e3a8-4ac4-82b7-75ce7a21b1aa',
        'peter_critique',
        '1976-09-01',
        '2023-01-16',
        'Art and culture critic with a keen eye.',
        100,
        80,
        'peter.critique@email.com',
        'hashed_password',
        'CRITIC',
        'ACTIVE'
    ),
    (
        'e6e49dbb-19bf-4e98-bd6c-d032e32d03c5',
        'natalie_critique',
        '1990-02-28',
        '2023-01-17',
        'Music critic and concert aficionado.',
        110,
        90,
        'natalie.critique@email.com',
        'hashed_password',
        'CRITIC',
        'ACTIVE'
    );
    INSERT INTO user (ID, USERNAME, BIRTHDAY, CREATED_DATE, ABOUT, FOLLOWING_COUNT, FOLLOWING_ME_COUNT, EMAIL, PASSWORD, ROLE, USER_STATUS)
    VALUES
    ('e2e8120d-3527-4d4a-8f3c-4ae620977ee1', 'Critic123', '1990-05-15', '2023-01-10', 'Film enthusiast and critic', 50, 30, 'critic123@example.com', 'hashedpassword123', 'CRITIC', 'ACTIVE'),
    ('14b65b63-0fc3-4a8a-bd5b-6ea3266c6ab9', 'MovieExpert', '1985-09-22', '2023-02-05', 'Passionate about cinema analysis', 80, 40, 'movie.expert@example.com', 'securepass456', 'CRITIC', 'ACTIVE'),
    ('a3f1c214-fa72-4329-9c16-7085f22b6d6a', 'FilmBuff', '1988-12-08', '2023-03-20', 'Dedicated to exploring diverse genres', 60, 25, 'filmbuff@email.com', 'myp@ssword789', 'CRITIC', 'ACTIVE'),
    ('7d8e1e7d-6d8d-4aa9-a184-2150d07651c2', 'Cinephile_87', '1987-04-03', '2023-04-15', 'Analyzing the art of storytelling in films', 45, 20, 'cinephile87@gmail.com', 'secret123', 'CRITIC', 'ACTIVE'),
    ('f23f64e9-dfa1-4ae9-94b0-21e8f3c9d9bf', 'FilmExplorer', '1992-06-18', '2023-05-02', 'Discovering hidden cinematic gems', 55, 35, 'explorer.films@yahoo.com', 'explorepass', 'CRITIC', 'ACTIVE');

    INSERT INTO user (ID, USERNAME, BIRTHDAY, CREATED_DATE, ABOUT, FOLLOWING_COUNT, FOLLOWING_ME_COUNT, EMAIL, PASSWORD, ROLE, USER_STATUS)
    VALUES
    ('3b8f6e8f-b050-4c12-87d2-9f2c0a1b6e1a', 'CriticalEye', '1989-08-12', '2023-06-10', 'Analyzing films with a critical perspective', 70, 15, 'eye4film@gmail.com', 'filmcriticpass', 'CRITIC', 'ACTIVE'),
    ('6aabb9df-1e9c-4e0d-8487-f3d83606e98d', 'TheMovieGuru', '1995-02-28', '2023-07-05', 'Guiding viewers to hidden cinematic treasures', 65, 28, 'movie.guru@example.com', 'gurupassword123', 'CRITIC', 'ACTIVE'),
    ('ba907991-64f3-4bc0-8d0a-82566d7fc1e1', 'CineLover123', '1986-11-09', '2023-08-20', 'Passionate about the art of storytelling in movies', 75, 22, 'cine_lover123@mail.com', 'cineloverpass', 'CRITIC', 'ACTIVE'),
    ('a9719a04-65d6-4fe5-8bf2-1d1e0d45e2bb', 'FilmSavvy', '1993-07-25', '2023-09-15', 'Sharing insights on the world of cinema', 48, 18, 'filmsavvy@gmail.com', 'savvypass456', 'CRITIC', 'ACTIVE'),
    ('bd9f84a0-25e8-4df3-bff8-950a2290ba94', 'CinephileInsider', '1991-04-14', '2023-10-02', 'Exploring the depth of storytelling in cinema', 58, 33, 'insider.cinephile@email.com', 'cineinsiderpass', 'CRITIC', 'ACTIVE');

--user_followers
INSERT INTO user_follower (ID, USER_ID, FOLLOWER_ID, FOLLOW_SINCE)
VALUES
    (
        '1a9b8c0e-7f8d-4bd6-a1a0-9ec63abf1ee2',
        '4fbcdb2e-0c16-4bf1-9ce6-1c7e187b243c',
        '4c925fdc-27b0-4d47-b7b7-25c6e2a86474',
        '2023-01-18'
    ),
    (
        '3b0d5cfa-2cc3-4e5d-a786-581234c38c3e',
        '7c21d6ae-93d3-48e1-8bf8-098cb9c5b19f',
        'f12a4a35-4d1d-4c39-8a3c-6c146a7baf3d',
        '2023-01-19'
    ),
    (
        '5a4f8e6d-96f8-4c9f-8705-80f1fe1c63cc',
        'a1cd5239-cb3b-4fe5-8f5b-4d350383aafc',
        '8b56d48a-28b9-47ab-b8f1-129abac6e593',
        '2023-01-20'
    ),
    (
        '7b2a1c34-0d37-4f4f-9dd2-d6c647c1e1a2',
        'c0f80a26-e3a8-4ac4-82b7-75ce7a21b1aa',
        '9d37e1a4-21c8-4e91-a11b-6d991460f7ef',
        '2023-01-21'
    ),
    (
        '9c8d7e6b-3a2b-42e9-b124-99779a28bc4c',
        'e6e49dbb-19bf-4e98-bd6c-d032e32d03c5',
        'ac84d66d-6efb-4d61-87cb-baaf5a3f83f2',
        '2023-01-22'
    ),
    (
        '4d55a0fd-7439-4a10-8d91-42e31db06a35',
        '4fbcdb2e-0c16-4bf1-9ce6-1c7e187b243c',
        '6e5f46c3-d172-4e14-aeef-7b8aebc9d786',
        '2023-01-23'
    ),
    (
        '6e293d10-126b-44c1-a75d-8e00ac8778ae',
        '7c21d6ae-93d3-48e1-8bf8-098cb9c5b19f',
        '8b56d48a-28b9-47ab-b8f1-129abac6e593',
        '2023-01-24'
    ),
    (
        '8c362380-9ee9-4a07-ba1f-53a1312ac493',
        'a1cd5239-cb3b-4fe5-8f5b-4d350383aafc',
        'e75c7e29-4d6c-4424-85d3-b9c813e5b917',
        '2023-01-25'
    ),
    (
        'a3a12274-74f3-4e4b-81f8-3d3cde3da796',
        'c0f80a26-e3a8-4ac4-82b7-75ce7a21b1aa',
        'd8a8bc2b-2873-4469-8f15-3f7b091b34ac',
        '2023-01-26'
    ),
    (
        'c5739aef-e315-4f7e-8824-6cf5b7ee6f6f',
        'e6e49dbb-19bf-4e98-bd6c-d032e32d03c5',
        'fe938b42-9e0b-497b-858b-d2ac18f2a2bd',
        '2023-01-27'
    ),
    (
        'e4a9e3f9-5e88-4304-8925-3d4324f4eaf3',
        '4fbcdb2e-0c16-4bf1-9ce6-1c7e187b243c',
        'a5d1a2e2-0bf7-4c05-aa0a-36b13f0123b2',
        '2023-01-28'
    ),
    (
        'fd1bc987-321e-4ab1-aa9d-7f6d98c4c864',
        '7c21d6ae-93d3-48e1-8bf8-098cb9c5b19f',
        'd8a8bc2b-2873-4469-8f15-3f7b091b34ac',
        '2023-01-29'
    ),
    (
        'b5d4ac3e-c1c2-4c0b-80f4-361eddb58f56',
        'a1cd5239-cb3b-4fe5-8f5b-4d350383aafc',
        'fe938b42-9e0b-497b-858b-d2ac18f2a2bd',
        '2023-01-30'
    ),
    (
        'd0c6e208-4e63-4175-b5d2-c71a9aa51d18',
        'c0f80a26-e3a8-4ac4-82b7-75ce7a21b1aa',
        'a5d1a2e2-0bf7-4c05-aa0a-36b13f0123b2',
        '2023-01-31'
    ),
    (
        'fe8cb3d0-0cf3-4bf2-92b2-51a2063713f1',
        'e6e49dbb-19bf-4e98-bd6c-d032e32d03c5',
        'fb2f9c0c-01ce-4bb5-9377-40bca1fb8794',
        '2023-02-01'
    );
set foreign_key_checks=1;