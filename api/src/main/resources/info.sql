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

--sagas movie
INSERT INTO saga (id, name) VALUES
    ('98726d24-d2c0-4b69-9534-86dc7b3175d5', 'Start Wars Saga'),
    ('983bdb60-3fe9-470f-b811-74ab692fcb47','Pirates of the Caribbean Saga'),
    ('74366cba-fe10-4253-930f-8c5098babbc4','Harry Potter Saga'),
    ('cd7aba5e-fdfc-4cc0-90ef-b2b5e9634ac0','The Lord of the Rings Saga'),
    ('2ce4fe03-96b9-42b5-8395-372b9a935d76','X-Men Saga'),
    ('dbd8fad2-f7c3-4186-b20f-de2d796ffd27','Transformers Saga'),
    ('b733a1a4-2c24-47b9-a1df-af988257fa2b','Fast & Furious Saga'),
    ('1194c17d-8090-42bb-b01c-49fb08c4dec8','Twilight Saga'),
    ('a251ee27-57e1-439b-b332-f7e9d1a98418','The Chronicles of Narnia Saga'),
    ('2c71b3b5-836f-4155-aac5-130cf05ba66e','Toy Story Saga'),
    ('0bfd4070-dd0a-4eb0-9cba-3edbd01512b6','Shrek Saga'),
    ('99d9059c-96fb-42d4-a3c9-27b4bda1e6a2','Mission Impossible Saga'),
    ('3f51926e-97d6-4877-970e-8cec5a42bf5c','The Mummy Saga'),
    ('6494e629-46d6-41eb-a769-3e2f96292493','Resident Evil Saga'),
    ('3f278ab5-2bb5-4f46-b7e7-905fb45eaa71','Ice Age Saga'),
    ('19b3f0d6-49d9-44e2-bf2b-1d67ca39b086','Spider-Man Saga'),
    ('0f6b8db8-fae3-4f5d-9157-5e40760e5e75','The Matrix Saga'),
    ('bd87db23-5562-4188-af79-2e884d9bc8ac','Iron Man Saga'),
    ('0606b0b8-b5ee-4a3f-8f9e-1f82dcd4bd57','Indiana Jones Saga'),
    ('7eb891ff-b43c-473f-8c2d-74c3f4b3a45f','The Terminator Saga'),
    ('3f31ac78-b224-4cae-8cb8-261390b3d9bb','Jurassic Park Saga'),
    ('e0a15465-5e81-485d-937c-d6a09f08cf24','Rambo Saga'),
    ('adc21998-a3d7-4ab1-b57c-0d548481195d','The Hangover Saga'),
    ('1b335998-2d7b-42e6-90c2-c22f9884fda7','Back to the Future Saga'),
    ('d2fc3f9a-83b9-44d8-a48a-04df5d625dff','Men in Black Saga'),
    ('060d8217-1eeb-4c0d-9242-4eab74f7007a','Die Hard Saga'),
    ('8bc176ce-dbc0-4685-81cb-71de31780281','Rush Hour Saga'),
    ('2720b6a8-6b5d-47fb-8630-a73cb9718443','Bring It On Saga'),
    ('7024167e-9da5-4773-bbb0-db7dae9814f7','Alien Saga'),
    ('c8d0fa86-e070-4ee3-985e-208b22554f5d','Star Trek Saga'),
    ('8703d819-b298-4cb2-8995-cf26099b5bc1','Planet of the Apes Saga'),
    ('bfba85e8-f6cc-4cb3-9200-66430dc8da6c','The Bourne Saga');

--movies
--start wars
INSERT INTO film (
    id,
    FILM_TYPE,
    TITLE,
    SYNOPSIS,
    ORIGINAL_LANGUAGE,
    SAGA_ID,
    DISTRIBUTOR,
    SUITABLE_FOR,
    COOMING_SOON,
    STREAMING_RELEASE_DATE,
    PREQUEL_ID,
    SEQUEL_ID,
    BOX_OFFICE,
    RUNTIME,
    THEATERS_RELEASE_DATE,
    AT_THEATERS
)
VALUES
(
        'e5cc7851-39a7-4342-aabf-ef8f72c7d648',
        1,
        'Star Wars: Episode IV - A New Hope',
        'In a galaxy far, far away...',
        'English',
        '98726d24-d2c0-4b69-9534-86dc7b3175d5',
        'Lucasfilm',
        'PG',
        false,
        '2023-02-15',
        NULL,
        '6e5f46c3-d172-4e14-aeef-7b8aebc9d786',
        775000000,
        121,
        '1977-05-25',
        FALSE
    ),
    (
        '0e3a8915-c68c-46dd-aee2-98dbde4b4b14',
        1,
        'Star Wars: Episode V - The Empire Strikes Back',
        'The saga continues...',
        'English',
        '98726d24-d2c0-4b69-9534-86dc7b3175d5',
        'Lucasfilm',
        'PG',
        false,
        '2023-03-15',
        'e5cc7851-39a7-4342-aabf-ef8f72c7d648',
        '8b56d48a-28b9-47ab-b8f1-129abac6e593',   I
        538400000,
        124,
        '1980-05-21',
        FALSE
    ),
    (
        'cd086f77-3009-4f62-8c7a-914bde6fbbf4',
        1,
        'Star Wars: Episode VI - Return of the Jedi',
        'The saga nears its end...',
        'English',
        '98726d24-d2c0-4b69-9534-86dc7b3175d5',
        'Lucasfilm',
        'PG',
        false,
        '2023-04-15',
        '0e3a8915-c68c-46dd-aee2-98dbde4b4b14',
        'a1cd5239-cb3b-4fe5-8f5b-4d350383aafc',
        475100000,
        131,
        '1983-05-25',
        FALSE
    ),
    (
        'e80d4a56-52a7-4f52-a2f2-5b88bc79b5e2',
        1,
        'Star Wars: Episode I - The Phantom Menace',
        'A long time ago...',
        'English',
        '98726d24-d2c0-4b69-9534-86dc7b3175d5',
        '20th Century Fox',
        'PG',
        false,
        '2023-05-15',
        'cd086f77-3009-4f62-8c7a-914bde6fbbf4',
        '6e5f46c3-d172-4e14-aeef-7b8aebc9d786',
        1027000000,
        136,
        '1999-05-19',
        FALSE
    ),
    (
        '9637c4e3-288b-4d8b-b25c-4475e7aa5cda',
        1,
        'Star Wars: Episode II - Attack of the Clones',
        'The saga continues...',
        'English',
        '98726d24-d2c0-4b69-9534-86dc7b3175d5',
        '20th Century Fox',
        'PG',
        false,
        '2023-06-15',
        'e80d4a56-52a7-4f52-a2f2-5b88bc79b5e2',
        '8b56d48a-28b9-47ab-b8f1-129abac6e593',
        649400000,
        142,
        '2002-05-16',
        FALSE
    ),
    (
        'a45a2bb9-7e52-4284-8cfe-5b2f5f2b8c1d',
        1,
        'Star Wars: Episode III - Revenge of the Sith',
        'The dark side emerges...',
        'English',
        '98726d24-d2c0-4b69-9534-86dc7b3175d5',
        '20th Century Fox',
        'PG-13',
        false,
        '2023-07-15',
        '9637c4e3-288b-4d8b-b25c-4475e7aa5cda',
        'a1cd5239-cb3b-4fe5-8f5b-4d350383aafc',
        848800000,
        140,
        '2005-05-19',
        FALSE
    ),
    (
        'd26e4ab3-9dce-420c-8254-7a8b1461d1bf',
        1,
        'Star Wars: Episode VII - The Force Awakens',
        'A new journey begins...',
        'English',
        '98726d24-d2c0-4b69-9534-86dc7b3175d5',
        'Walt Disney Studios',
        'PG-13',
        false,
        '2023-08-15',
        'a45a2bb9-7e52-4284-8cfe-5b2f5f2b8c1d',
        '7c21d6ae-93d3-48e1-8bf8-098cb9c5b19f',   III
        2068000000,
        138,
        '2015-12-18',
        FALSE
    ),
    (
        'bf24f51c-6b56-4a04-ae5e-86d6b3d2eb74',
        1,
        'Star Wars: Episode VIII - The Last Jedi',
        'The saga continues...',
        'English',
        '98726d24-d2c0-4b69-9534-86dc7b3175d5',
        'Walt Disney Studios',
        'PG-13',
        false,
        '2023-09-15',
        'd26e4ab3-9dce-420c-8254-7a8b1461d1bf',
        '8b56d48a-28b9-47ab-b8f1-129abac6e593',
        1333000000,
        152,
        '2017-12-15',
        FALSE
    ),
    (
        'f456ce87-d4a1-4c5f-98a7-e8100cfe4bd0',
        1,
        'Star Wars: Episode IX - The Rise of Skywalker',
        'The saga concludes...',
        'English',
        '98726d24-d2c0-4b69-9534-86dc7b3175d5',
        'Walt Disney Studios',
        'PG-13',
        false,
        '2023-10-15',
        'bf24f51c-6b56-4a04-ae5e-86d6b3d2eb74',
        NULL,
        1074000000,
        142,
        '2019-12-20',
        FALSE
    );

--Pirates of the Caribbean
INSERT INTO film (
    id,
    FILM_TYPE,
    TITLE,
    SYNOPSIS,
    ORIGINAL_LANGUAGE,
    SAGA_ID,
    DISTRIBUTOR,
    SUITABLE_FOR,
    COOMING_SOON,
    STREAMING_RELEASE_DATE,
    PREQUEL_ID,
    SEQUEL_ID,
    BOX_OFFICE,
    RUNTIME,
    THEATERS_RELEASE_DATE,
    AT_THEATERS
)
VALUES
    (
        'f4b3d4e2-2f3d-4a13-8f2c-729b26e964c5',
        1,
        'Pirates of the Caribbean: The Curse of the Black Pearl',
        'Captain Jack Sparrow seeks to recover his stolen ship...',
        'English',
        'c7795e3b-0211-4a2d-8f3c-9ec63abf1ee2',
        'Walt Disney Pictures',
        'PG-13',
        false,
        '2023-02-15',
        NULL,
        '8c362380-9ee9-4a07-ba1f-53a1312ac493',
        654300000,
        143,
        '2003-07-09',
        FALSE
    ),
    (
        'af9a78e1-e999-4c47-9cf4-4601627f0648',
        1,
        "Pirates of the Caribbean: Dead Man's Chest",
        'Jack Sparrow owes a debt to Davy Jones...',
        'English',
        'c7795e3b-0211-4a2d-8f3c-9ec63abf1ee2',
        'Walt Disney Pictures',
        'PG-13',
        false,
        '2023-03-15',
        'f4b3d4e2-2f3d-4a13-8f2c-729b26e964c5',
        '5a4f8e6d-96f8-4c9f-8705-80f1fe1c63cc',
        1068000000,
        151,
        '2006-07-07',
        FALSE
    ),
    (
        'bd6929a2-c6c5-452b-8e8c-9b9b2ad89321',
        1,
        "Pirates of the Caribbean: At World's End",
        'The Brethren Court convenes to fight against Lord Cutler Beckett...',
        'English',
        'c7795e3b-0211-4a2d-8f3c-9ec63abf1ee2',
        'Walt Disney Pictures',
        'PG-13',
        false,
        '2023-04-15',
        'af9a78e1-e999-4c47-9cf4-4601627f0648',
        'd8a8bc2b-2873-4469-8f15-3f7b091b34ac',
        963400000,
        169,
        '2007-05-24',
        FALSE
    ),
    (
        'e6d90526-08b3-47c1-a01d-2f9b48c94a9c',
        1,
        'Pirates of the Caribbean: On Stranger Tides',
        'Jack Sparrow searches for the Fountain of Youth...',
        'English',
        'c7795e3b-0211-4a2d-8f3c-9ec63abf1ee2',
        'Walt Disney Pictures',
        'PG-13',
        false,
        '2023-05-15',
        'bd6929a2-c6c5-452b-8e8c-9b9b2ad89321',
        'a1cd5239-cb3b-4fe5-8f5b-4d350383aafc',
        1046000000,
        136,
        '2011-05-20',
        FALSE
    ),
    (
        'f49218c1-2c5d-4f6b-8182-2b3e55c85711',
        1,
        'Pirates of the Caribbean: Dead Men Tell No Tales',
        'Captain Jack Sparrow seeks the Trident of Poseidon...',
        'English',
        'c7795e3b-0211-4a2d-8f3c-9ec63abf1ee2',
        'Walt Disney Pictures',
        'PG-13',
        false,
        '2023-06-15',
        'e6d90526-08b3-47c1-a01d-2f9b48c94a9c',
        NULL,
        794900000,
        129,
        '2017-05-26',
        FALSE
    );

--Harry Potter
INSERT INTO film (
    id,
    FILM_TYPE,
    TITLE,
    SYNOPSIS,
    ORIGINAL_LANGUAGE,
    SAGA_ID,
    DISTRIBUTOR,
    SUITABLE_FOR,
    COOMING_SOON,
    STREAMING_RELEASE_DATE,
    PREQUEL_ID,
    SEQUEL_ID,
    BOX_OFFICE,
    RUNTIME,
    THEATERS_RELEASE_DATE,
    AT_THEATERS
)
VALUES
    (
        '2f901ff3-968b-4e90-9db0-5e16843d1e16',
        1,
        "Harry Potter and the Sorcerer\'s Stone",
        'An orphaned boy discovers he is a wizard and attends Hogwarts School of Witchcraft and Wizardry.',
        'English',
        '7d56b82e-4c71-4b1b-8f78-b67210a43cd5',
        'Warner Bros. Pictures',
        'PG',
        false,
        '2023-02-15',
        NULL, -- No prequel for Sorcerer's Stone
        '4587bd15-7d50-42a3-b4c0-58c0c092070b',
        974800000,
        152,
        '2001-11-16',
        FALSE
    ),
    (
        'ec28a46e-9852-4cb8-9b23-96c6d98e00d5',
        1,
        'Harry Potter and the Chamber of Secrets',
        'Harry investigates a series of mysterious attacks at Hogwarts.',
        'English',
        '7d56b82e-4c71-4b1b-8f78-b67210a43cd5',
        'Warner Bros. Pictures',
        'PG',
        false,
        '2023-03-15',
        '2f901ff3-968b-4e90-9db0-5e16843d1e16',
        'a7f7d3f9-6864-4c33-b2e3-18929229e717',
        879500000,
        161,
        '2002-11-15',
        FALSE
    ),
    (
        'a57d328f-bc58-4bb5-b0db-9c6342a5b0a0',
        1,
        'Harry Potter and the Prisoner of Azkaban',
        'Harry learns more about his past and encounters Sirius Black.',
        'English',
        '7d56b82e-4c71-4b1b-8f78-b67210a43cd5',
        'Warner Bros. Pictures',
        'PG',
        false,
        '2023-04-15',
        'ec28a46e-9852-4cb8-9b23-96c6d98e00d5',
        'ddbc5c34-7f09-4a3d-bb39-7a8b1461d1bf',
        796700000,
        142,
        '2004-06-04',
        FALSE
    ),
    (
        'c1e229e7-1705-4c3d-b6bf-c3da3f019d05',
        1,
        'Harry Potter and the Goblet of Fire',
        'Harry competes in the Triwizard Tournament amidst rising tensions in the wizarding world.',
        'English',
        '7d56b82e-4c71-4b1b-8f78-b67210a43cd5',
        'Warner Bros. Pictures',
        'PG-13',
        false,
        '2023-05-15',
        'a57d328f-bc58-4bb5-b0db-9c6342a5b0a0',
        '85ba1e5a-55c1-4ea7-b5e0-9ec63abf1ee2',
        896400000,
        157,
        '2005-11-18',
        FALSE
    ),
    (
        'd6ff152f-2cb3-4082-8b14-f36d23cc3f77',
        1,
        'Harry Potter and the Order of the Phoenix',
        "Harry and his friends form Dumbledore\'s Army to resist the dark forces.",
        'English',
        '7d56b82e-4c71-4b1b-8f78-b67210a43cd5',
        'Warner Bros. Pictures',
        'PG-13',
        false,
        '2023-06-15',
        'c1e229e7-1705-4c3d-b6bf-c3da3f019d05',
        'f1e2e8f8-cbbe-4fb0-8588-098cb9c5b19f',
        942000000,
        138,
        '2007-07-11',
        FALSE
    ),
    (
        'f1e2e8f8-cbbe-4fb0-8588-098cb9c5b19f',
        1,
        'Harry Potter and the Half-Blood Prince',
        "Harry learns more about Voldemort\'s past and the Horcruxes.",
        'English',
        '7d56b82e-4c71-4b1b-8f78-b67210a43cd5',
        'Warner Bros. Pictures',
        'PG',
        false,
        '2023-07-15',
        'd6ff152f-2cb3-4082-8b14-f36d23cc3f77',
        'a57d328f-bc58-4bb5-b0db-9c6342a5b0a0',
        934500000,
        153,
        '2009-07-15',
        FALSE
    ),
    (
        'f63285d1-eae0-4a5c-b0b9-54bf0bf3c40c',
        1,
        'Harry Potter and the Deathly Hallows - Part 1',
        'Harry, Ron, and Hermione embark on a quest to destroy the Horcruxes.',
        'English',
        '7d56b82e-4c71-4b1b-8f78-b67210a43cd5',
        'Warner Bros. Pictures',
        'PG-13',
        false,
        '2023-08-15',
        'f1e2e8f8-cbbe-4fb0-8588-098cb9c5b19f',
        '8538f37c-0c25-45f2-9d14-40bca1fb8794',
        976900000,
        146,
        '2010-11-19',
        FALSE
    ),
    (
        '8538f37c-0c25-45f2-9d14-40bca1fb8794',
        1,
        'Harry Potter and the Deathly Hallows - Part 2',
        'The final battle between Harry and Voldemort takes place at Hogwarts.',
        'English',
        '7d56b82e-4c71-4b1b-8f78-b67210a43cd5',
        'Warner Bros. Pictures',
        'PG-13',
        false,
        '2023-09-15',
        'f63285d1-eae0-4a5c-b0b9-54bf0bf3c40c',
        NULL,
        1341000000,
        130,
        '2011-07-15',
        FALSE
    );
--The Lord of the Rings
INSERT INTO film (
    id,
    FILM_TYPE,
    TITLE,
    SYNOPSIS,
    ORIGINAL_LANGUAGE,
    SAGA_ID,
    DISTRIBUTOR,
    SUITABLE_FOR,
    COOMING_SOON,
    STREAMING_RELEASE_DATE,
    PREQUEL_ID,
    SEQUEL_ID,
    BOX_OFFICE,
    RUNTIME,
    THEATERS_RELEASE_DATE,
    AT_THEATERS
)
VALUES
    (
        '3c27c7da-4f2a-4308-8bb4-c0f80a26-e3a8-4ac4-82b7-75ce7a21b1aa',
        1,
        'The Lord of the Rings: The Fellowship of the Ring',
        'A young hobbit, Frodo Baggins, must destroy the One Ring to save Middle-earth.',
        'English',
        '5a4f8e6d-96f8-4c9f-8705-80f1fe1c63cc',
        'New Line Cinema',
        'PG-13',
        false,
        '2023-02-15',
        NULL, -- No prequel for The Fellowship of the Ring
        '2e2c6482-d9be-4e05-9b24-c6b2c30754d8', -- Followed by The Two Towers
        887500000,
        178,
        '2001-12-19',
        FALSE
    ),
    (
        '2e2c6482-d9be-4e05-9b24-c6b2c30754d8',
        1,
        'The Lord of the Rings: The Two Towers',
        'Frodo and Sam continue their journey while the rest of the fellowship faces new challenges.',
        'English',
        '5a4f8e6d-96f8-4c9f-8705-80f1fe1c63cc',
        'New Line Cinema',
        'PG-13',
        false,
        '2023-03-15',
        '3c27c7da-4f2a-4308-8bb4-c0f80a26-e3a8-4ac4-82b7-75ce7a21b1aa', -- Preceded by The Fellowship of the Ring
        '4a9386b3-89d2-4ae6-a72d-d2ac18f2a2bd', -- Followed by The Return of the King
        947200000,
        179,
        '2002-12-18',
        FALSE
    ),
    (
        '4a9386b3-89d2-4ae6-a72d-d2ac18f2a2bd',
        1,
        'The Lord of the Rings: The Return of the King',
        'The final battle for Middle-earth unfolds as Frodo and Sam reach Mount Doom.',
        'English',
        '5a4f8e6d-96f8-4c9f-8705-80f1fe1c63cc',
        'New Line Cinema',
        'PG-13',
        false,
        '2023-04-15',
        '2e2c6482-d9be-4e05-9b24-c6b2c30754d8', -- Preceded by The Two Towers
        NULL, -- No sequel planned for The Return of the King
        1148000000,
        201,
        '2003-12-17',
        FALSE
    );

--X-Men
INSERT INTO film (
    id,
    FILM_TYPE,
    TITLE,
    SYNOPSIS,
    ORIGINAL_LANGUAGE,
    SAGA_ID,
    DISTRIBUTOR,
    SUITABLE_FOR,
    COOMING_SOON,
    STREAMING_RELEASE_DATE,
    PREQUEL_ID,
    SEQUEL_ID,
    BOX_OFFICE,
    RUNTIME,
    THEATERS_RELEASE_DATE,
    AT_THEATERS
)
VALUES
    (
        'd8ea07ab-2c74-4c92-b265-64eb81e3e4fe',
        1,
        'X-Men',
        'A group of mutants with extraordinary abilities must come together to stop a common threat.',
        'English',
        'ddbc5c34-7f09-4a3d-bb39-7a8b1461d1bf',
        '20th Century Fox',
        'PG-13',
        false,
        '2023-02-15',
        NULL, -- No prequel for X-Men
        '1a025732-6e0c-41d2-9f77-862ad86c16b5', -- Followed by X2: X-Men United
        296300000,
        104,
        '2000-07-14',
        FALSE
    ),
    (
        '1a025732-6e0c-41d2-9f77-862ad86c16b5',
        1,
        'X2: X-Men United',
        'The X-Men team up with their enemies to face a greater threat.',
        'English',
        'ddbc5c34-7f09-4a3d-bb39-7a8b1461d1bf',
        '20th Century Fox',
        'PG-13',
        false,
        '2023-03-15',
        'd8ea07ab-2c74-4c92-b265-64eb81e3e4fe', -- Preceded by X-Men
        '34f48f58-2d22-4b71-96b4-548b84d4b019', -- Followed by X-Men: The Last Stand
        407700000,
        133,
        '2003-05-02',
        FALSE
    ),
    (
        '34f48f58-2d22-4b71-96b4-548b84d4b019',
        1,
        'X-Men: The Last Stand',
        'A cure for mutation threatens the existence of mutants, leading to a conflict.',
        'English',
        'ddbc5c34-7f09-4a3d-bb39-7a8b1461d1bf',
        '20th Century Fox',
        'PG-13',
        false,
        '2023-04-15',
        '1a025732-6e0c-41d2-9f77-862ad86c16b5', -- Preceded by X2: X-Men United
        '46a8f689-2a93-4a5a-9234-6a2e5e3e4f88', -- Followed by X-Men: Days of Future Past
        459400000,
        104,
        '2006-05-26',
        FALSE
    ),
    (
        '46a8f689-2a93-4a5a-9234-6a2e5e3e4f88',
        1,
        'X-Men: Days of Future Past',
        'The X-Men send Wolverine to the past to prevent a catastrophic future for mutants.',
        'English',
        'ddbc5c34-7f09-4a3d-bb39-7a8b1461d1bf',
        '20th Century Fox',
        'PG-13',
        false,
        '2023-05-15',
        '34f48f58-2d22-4b71-96b4-548b84d4b019', -- Preceded by X-Men: The Last Stand
        'f84e28c4-5803-4d2c-9b9a-18779413405a', -- Followed by X-Men: Apocalypse
        747900000,
        131,
        '2014-05-10',
        FALSE
    ),
    (
        'f84e28c4-5803-4d2c-9b9a-18779413405a',
        1,
        'X-Men: Apocalypse',
        'The X-Men must defeat an ancient mutant who is determined to destroy the world.',
        'English',
        'ddbc5c34-7f09-4a3d-bb39-7a8b1461d1bf',
        '20th Century Fox',
        'PG-13',
        false,
        '2023-06-15',
        '46a8f689-2a93-4a5a-9234-6a2e5e3e4f88', -- Preceded by X-Men: Days of Future Past
        'd7a32df4-79b7-470a-8f25-6a2e5e3e4f88', -- Followed by X-Men: Dark Phoenix
        543900000,
        144,
        '2016-05-09',
        FALSE
    ),
    (
        'd7a32df4-79b7-470a-8f25-6a2e5e3e4f88',
        1,
        'X-Men: Dark Phoenix',
        "Jean Grey's powers become uncontrollable, threatening the X-Men and the world.",
        'English',
        'ddbc5c34-7f09-4a3d-bb39-7a8b1461d1bf',
        '20th Century Fox',
        'PG-13',
        false,
        '2023-07-15',
        'f84e28c4-5803-4d2c-9b9a-18779413405a', -- Preceded by X-Men: Apocalypse
        NULL, -- No sequel planned for X-Men: Dark Phoenix
        252500000,
        113,
        '2019-06-05',
        FALSE
    )
    -- Add more mock data as needed
    ;

--Transformers
INSERT INTO film (
    id,
    FILM_TYPE,
    TITLE,
    SYNOPSIS,
    ORIGINAL_LANGUAGE,
    SAGA_ID,
    DISTRIBUTOR,
    SUITABLE_FOR,
    COOMING_SOON,
    STREAMING_RELEASE_DATE,
    PREQUEL_ID,
    SEQUEL_ID,
    BOX_OFFICE,
    RUNTIME,
    THEATERS_RELEASE_DATE,
    AT_THEATERS
)
VALUES
    (
        'ff17f7e8-363c-4a6b-b8d4-cb3a3f90b587',
        1,
        'Transformers',
        'Alien robots, the Autobots, and Decepticons, bring their war to Earth.',
        'English',
        'f92c8b19-d8d5-42b1-8125-7a8b1461d1bf',
        'Paramount Pictures',
        'PG-13',
        false,
        '2023-02-15',
        NULL, -- No prequel for Transformers
        'df62eb26-8f9b-4150-87f1-df8836a0b28f', -- Followed by Transformers: Revenge of the Fallen
        709700000,
        144,
        '2007-07-03',
        FALSE
    ),
    (
        'df62eb26-8f9b-4150-87f1-df8836a0b28f',
        1,
        'Transformers: Revenge of the Fallen',
        'The battle for Earth continues as ancient Decepticons rise.',
        'English',
        'f92c8b19-d8d5-42b1-8125-7a8b1461d1bf',
        'Paramount Pictures',
        'PG-13',
        false,
        '2023-03-15',
        'ff17f7e8-363c-4a6b-b8d4-cb3a3f90b587', -- Preceded by Transformers
        'a3b2454e-4970-4c43-927e-848b84d4b019', -- Followed by Transformers: Dark of the Moon
        836300000,
        150,
        '2009-06-24',
        FALSE
    ),
    (
        'a3b2454e-4970-4c43-927e-848b84d4b019',
        1,
        'Transformers: Dark of the Moon',
        'The Autobots learn about a Cybertronian spacecraft on the Moon.',
        'English',
        'f92c8b19-d8d5-42b1-8125-7a8b1461d1bf',
        'Paramount Pictures',
        'PG-13',
        false,
        '2023-04-15',
        'df62eb26-8f9b-4150-87f1-df8836a0b28f', -- Preceded by Transformers: Revenge of the Fallen
        '3c5d387a-b25f-446a-8794-1c5112542a95', -- Followed by Transformers: Age of Extinction
        1124000000,
        154,
        '2011-06-29',
        FALSE
    ),
    (
        '3c5d387a-b25f-446a-8794-1c5112542a95',
        1,
        'Transformers: Age of Extinction',
        'A mechanic and his family join the Autobots against a new threat.',
        'English',
        'f92c8b19-d8d5-42b1-8125-7a8b1461d1bf',
        'Paramount Pictures',
        'PG-13',
        false,
        '2023-05-15',
        'a3b2454e-4970-4c43-927e-848b84d4b019', -- Preceded by Transformers: Dark of the Moon
        '9d5835f1-7ce7-482b-a5a5-05f39461d1bf', -- Followed by Transformers: The Last Knight
        1089000000,
        165,
        '2014-06-27',
        FALSE
    ),
    (
        '9d5835f1-7ce7-482b-a5a5-05f39461d1bf',
        1,
        'Transformers: The Last Knight',
        'Optimus Prime discovers his home planet, Cybertron, is now a dead planet.',
        'English',
        'f92c8b19-d8d5-42b1-8125-7a8b1461d1bf',
        'Paramount Pictures',
        'PG-13',
        false,
        '2023-06-15',
        '3c5d387a-b25f-446a-8794-1c5112542a95', -- Preceded by Transformers: Age of Extinction
        '38c69c22-7805-4da5-9d04-57bb2ad89321', -- Followed by Bumblebee
        605400000,
        154,
        '2017-06-21',
        FALSE
    ),
    (
        '38c69c22-7805-4da5-9d04-57bb2ad89321',
        1,
        'Bumblebee',
        'A young girl discovers and befriends the Autobot Bumblebee in the 1980s.',
        'English',
        'f92c8b19-d8d5-42b1-8125-7a8b1461d1bf',
        'Paramount Pictures',
        'PG-13',
        false,
        '2023-07-15',
        '9d5835f1-7ce7-482b-a5a5-05f39461d1bf', -- Preceded by Transformers: The Last Knight
        NULL, -- No sequel planned for Bumblebee
        468200000,
        114,
        '2018-12-21',
        FALSE
    )
    -- Add more mock data as needed
    ;

--Fast & Furious
INSERT INTO film (
    id,
    FILM_TYPE,
    TITLE,
    SYNOPSIS,
    ORIGINAL_LANGUAGE,
    SAGA_ID,
    DISTRIBUTOR,
    SUITABLE_FOR,
    COOMING_SOON,
    STREAMING_RELEASE_DATE,
    PREQUEL_ID,
    SEQUEL_ID,
    BOX_OFFICE,
    RUNTIME,
    THEATERS_RELEASE_DATE,
    AT_THEATERS
)
VALUES
    (
        '8260b2a8-7a9b-4fe6-ae6b-549b84d4b019',
        1,
        'The Fast and the Furious',
        'An undercover cop infiltrates the world of illegal street racing to catch a criminal.',
        'English',
        'aec566c3-6a64-4f6f-96e0-7a8b1461d1bf',
        'Universal Pictures',
        'PG-13',
        false,
        '2023-02-15',
        NULL, -- No prequel for The Fast and the Furious
        'b5c88e68-3c5d-481b-b53b-6a2e5e3e4f88', -- Followed by 2 Fast 2 Furious
        207300000,
        106,
        '2001-06-22',
        FALSE
    ),
    (
        'b5c88e68-3c5d-481b-b53b-6a2e5e3e4f88',
        1,
        '2 Fast 2 Furious',
        "Former cop Brian O'Conner teams up with a friend to take down a drug lord.",
        'English',
        'aec566c3-6a64-4f6f-96e0-7a8b1461d1bf',
        'Universal Pictures',
        'PG-13',
        false,
        '2023-03-15',
        '8260b2a8-7a9b-4fe6-ae6b-549b84d4b019', -- Preceded by The Fast and the Furious
        '2f12ffcb-b8c5-496f-831c-77d3df47f9c3', -- Followed by The Fast and the Furious: Tokyo Drift
        236400000,
        107,
        '2003-06-06',
        FALSE
    ),
    (
        '2f12ffcb-b8c5-496f-831c-77d3df47f9c3',
        1,
        'The Fast and the Furious: Tokyo Drift',
        'A teenager becomes involved in the Tokyo drift racing scene and faces new challenges.',
        'English',
        'aec566c3-6a64-4f6f-96e0-7a8b1461d1bf',
        'Universal Pictures',
        'PG-13',
        false,
        '2023-04-15',
        'b5c88e68-3c5d-481b-b53b-6a2e5e3e4f88', -- Preceded by 2 Fast 2 Furious
        'c1c5c654-1f90-496e-bb88-78b2d8238fe1', -- Followed by Fast & Furious
        157000000,
        104,
        '2006-06-16',
        FALSE
    ),
    (
        'c1c5c654-1f90-496e-bb88-78b2d8238fe1',
        1,
        'Fast & Furious',
        "Dominic Toretto and Brian O'Conner reunite to take down a common enemy.",
        'English',
        'aec566c3-6a64-4f6f-96e0-7a8b1461d1bf',
        'Universal Pictures',
        'PG-13',
        false,
        '2023-05-15',
        '2f12ffcb-b8c5-496f-831c-77d3df47f9c3', -- Preceded by The Fast and the Furious: Tokyo Drift
        'c6e22957-5a2f-4b8c-8e98-8f11f5d71ed9', -- Followed by Fast Five
        363300000,
        107,
        '2009-04-03',
        FALSE
    ),
    (
        'c6e22957-5a2f-4b8c-8e98-8f11f5d71ed9',
        1,
        'Fast Five',
        'Dominic Toretto and his team plan a heist in Rio de Janeiro while being pursued by a federal agent.',
        'English',
        'aec566c3-6a64-4f6f-96e0-7a8b1461d1bf',
        'Universal Pictures',
        'PG-13',
        false,
        '2023-06-15',
        'c1c5c654-1f90-496e-bb88-78b2d8238fe1', -- Preceded by Fast & Furious
        'd5bf89ae-ba7f-49f1-a1c0-19b29d051c2e', -- Followed by Fast & Furious 6
        626100000,
        130,
        '2011-04-29',
        FALSE
    ),
    (
        'd5bf89ae-ba7f-49f1-a1c0-19b29d051c2e',
        1,
        'Fast & Furious 6',
        'Dominic Toretto and his team join forces with Hobbs to take down a skilled mercenary.',
        'English',
        'aec566c3-6a64-4f6f-96e0-7a8b1461d1bf',
        'Universal Pictures',
        'PG-13',
        false,
        '2023-07-15',
        'c6e22957-5a2f-4b8c-8e98-8f11f5d71ed9', -- Preceded by Fast Five
        '0df89bf3-8b0f-4d3a-8101-cb3a3f90b587', -- Followed by Furious 7
        788700000,
        130,
        '2013-05-07',
        FALSE
    ),
    (
        '0df89bf3-8b0f-4d3a-8101-cb3a3f90b587',
        1,
        'Furious 7',
        'Dominic Toretto and his team face a new enemy and deal with the loss of a family member.',
        'English',
        'aec566c3-6a64-4f6f-96e0-7a8b1461d1bf',
        'Universal Pictures',
        'PG-13',
        false,
        '2023-08-15',
        'd5bf89ae-ba7f-49f1-a1c0-19b29d051c2e', -- Preceded by Fast & Furious 6
        '3cc0efb7-cdb9-47c8-9c5f-862ad86c16b5', -- Followed by The Fate of the Furious
        1515000000,
        137,
        '2015-04-01',
        FALSE
    ),
    (
        '3cc0efb7-cdb9-47c8-9c5f-862ad86c16b5',
        1,
        'The Fate of the Furious',
        'Dominic Toretto turns against his team due to mysterious circumstances.',
        'English',
        'aec566c3-6a64-4f6f-96e0-7a8b1461d1bf',
        'Universal Pictures',
        'PG-13',
        false,
        '2023-09-15',
        '0df89bf3-8b0f-4d3a-8101-cb3a3f90b587', -- Preceded by Furious 7
        'd3bc7aa2-49fc-4e4f-b1f2-77d3df47f9c3', -- Followed by Fast & Furious Presents: Hobbs & Shaw
        1239000000,
        136,
        '2017-04-04',
        FALSE
    ),
    (
        'd3bc7aa2-49fc-4e4f-b1f2-77d3df47f9c3',
        1,
        'Fast & Furious Presents: Hobbs & Shaw',
        'Luke Hobbs and Deckard Shaw team up to stop a cyber-genetically enhanced villain.',
        'English',
        'aec566c3-6a64-4f6f-96e0-7a8b1461d1bf',
        'Universal Pictures',
        'PG-13',
        false,
        '2023-10-15',
        '3cc0efb7-cdb9-47c8-9c5f-862ad86c16b5', -- Preceded by The Fate of the Furious
        NULL, -- No sequel planned for Hobbs & Shaw
        759500000,
        137,
        '2019-08-02',
        FALSE
    );
--Twilight
INSERT INTO film (
    id,
    FILM_TYPE,
    TITLE,
    SYNOPSIS,
    ORIGINAL_LANGUAGE,
    SAGA_ID,
    DISTRIBUTOR,
    SUITABLE_FOR,
    COOMING_SOON,
    STREAMING_RELEASE_DATE,
    PREQUEL_ID,
    SEQUEL_ID,
    BOX_OFFICE,
    RUNTIME,
    THEATERS_RELEASE_DATE,
    AT_THEATERS
)
VALUES
    (
        'ca7f3a44-67ef-4920-bf5c-6a2e5e3e4f88',
        1,
        'Twilight',
        'A teenage girl falls in love with a vampire, sparking a series of events with supernatural consequences.',
        'English',
        'd6c6dd85-6e0c-44b1-b1e1-549b84d4b019',
        'Summit Entertainment',
        'PG-13',
        false,
        '2023-02-15',
        NULL, -- No prequel for Twilight
        'ebf92416-0587-420d-a7ce-86dc7b3175d5', -- Followed by The Twilight Saga: New Moon
        393600000,
        122,
        '2008-11-21',
        FALSE
    ),
    (
        'ebf92416-0587-420d-a7ce-86dc7b3175d5',
        1,
        'The Twilight Saga: New Moon',
        'Bella Swan is devastated by the abrupt departure of her vampire love, Edward Cullen.',
        'English',
        'd6c6dd85-6e0c-44b1-b1e1-549b84d4b019',
        'Summit Entertainment',
        'PG-13',
        false,
        '2023-03-15',
        'ca7f3a44-67ef-4920-bf5c-6a2e5e3e4f88', -- Preceded by Twilight
        '207b149f-cc3e-4d08-8260-77d3df47f9c3', -- Followed by The Twilight Saga: Eclipse
        709700000,
        130,
        '2009-11-20',
        FALSE
    ),
    (
        '207b149f-cc3e-4d08-8260-77d3df47f9c3',
        1,
        'The Twilight Saga: Eclipse',
        'Bella is forced to choose between her love for Edward and her friendship with Jacob.',
        'English',
        'd6c6dd85-6e0c-44b1-b1e1-549b84d4b019',
        'Summit Entertainment',
        'PG-13',
        false,
        '2023-04-15',
        'ebf92416-0587-420d-a7ce-86dc7b3175d5', -- Preceded by The Twilight Saga: New Moon
        'a3e736b0-45f7-401a-a37f-57bb2ad89321', -- Followed by The Twilight Saga: Breaking Dawn - Part 1
        698500000,
        124,
        '2010-06-30',
        FALSE
    ),
    (
        'a3e736b0-45f7-401a-a37f-57bb2ad89321',
        1,
        'The Twilight Saga: Breaking Dawn - Part 1',
        'Bella and Edward get married, leading to unexpected consequences for the couple.',
        'English',
        'd6c6dd85-6e0c-44b1-b1e1-549b84d4b019',
        'Summit Entertainment',
        'PG-13',
        false,
        '2023-05-15',
        '207b149f-cc3e-4d08-8260-77d3df47f9c3', -- Preceded by The Twilight Saga: Eclipse
        'd9d92a19-23b1-46c1-81f1-19b29d051c2e', -- Followed by The Twilight Saga: Breaking Dawn - Part 2
        712200000,
        117,
        '2011-11-18',
        FALSE
    ),
    (
        'd9d92a19-23b1-46c1-81f1-19b29d051c2e',
        1,
        'The Twilight Saga: Breaking Dawn - Part 2',
        'The Cullens and their allies gather to protect Renesmee from a false allegation.',
        'English',
        'd6c6dd85-6e0c-44b1-b1e1-549b84d4b019',
        'Summit Entertainment',
        'PG-13',
        false,
        '2023-06-15',
        'a3e736b0-45f7-401a-a37f-57bb2ad89321', -- Preceded by The Twilight Saga: Breaking Dawn - Part 1
        NULL, -- No sequel planned for Breaking Dawn - Part 2
        829700000,
        115,
        '2012-11-16',
        FALSE
    );

--The Chronicles of Narnia
INSERT INTO film (
    id,
    FILM_TYPE,
    TITLE,
    SYNOPSIS,
    ORIGINAL_LANGUAGE,
    SAGA_ID,
    DISTRIBUTOR,
    SUITABLE_FOR,
    COOMING_SOON,
    STREAMING_RELEASE_DATE,
    PREQUEL_ID,
    SEQUEL_ID,
    BOX_OFFICE,
    RUNTIME,
    THEATERS_RELEASE_DATE,
    AT_THEATERS
)
VALUES
    (
        '833c2904-369d-4c46-ae80-549b84d4b019',
        1,
        'The Chronicles of Narnia: The Lion, the Witch and the Wardrobe',
        'Four siblings discover a magical wardrobe that leads to the land of Narnia, ruled by the White Witch.',
        'English',
        'ef7aa23e-47a9-4a1e-9a97-7a8b1461d1bf',
        'Walt Disney Pictures',
        'PG',
        false,
        '2023-02-15',
        NULL, -- No prequel for The Lion, the Witch and the Wardrobe
        'a4e13e08-3d3d-4aa5-9b46-86dc7b3175d5', -- Followed by The Chronicles of Narnia: Prince Caspian
        745000000,
        143,
        '2005-12-09',
        FALSE
    ),
    (
        'a4e13e08-3d3d-4aa5-9b46-86dc7b3175d5',
        1,
        'The Chronicles of Narnia: Prince Caspian',
        'The Pevensie siblings return to Narnia to help Prince Caspian reclaim his throne from his evil uncle.',
        'English',
        'ef7aa23e-47a9-4a1e-9a97-7a8b1461d1bf',
        'Walt Disney Pictures',
        'PG',
        false,
        '2023-03-15',
        '833c2904-369d-4c46-ae80-549b84d4b019', -- Preceded by The Lion, the Witch and the Wardrobe
        'bd050c17-3a03-47a5-9b24-77d3df47f9c3', -- Followed by The Chronicles of Narnia: The Voyage of the Dawn Treader
        419700000,
        150,
        '2008-05-16',
        FALSE
    ),
    (
        'bd050c17-3a03-47a5-9b24-77d3df47f9c3',
        1,
        'The Chronicles of Narnia: The Voyage of the Dawn Treader',
        'The Pevensie siblings join Prince Caspian on a voyage to the edge of the world to save Narnia.',
        'English',
        'ef7aa23e-47a9-4a1e-9a97-7a8b1461d1bf',
        '20th Century Fox',
        'PG',
        false,
        '2023-04-15',
        'a4e13e08-3d3d-4aa5-9b46-86dc7b3175d5', -- Preceded by Prince Caspian
        NULL, -- No sequel planned for The Voyage of the Dawn Treader
        415700000,
        113,
        '2010-12-10',
        FALSE
    ) ;

--Toy Story
INSERT INTO film (
    id,
    FILM_TYPE,
    TITLE,
    SYNOPSIS,
    ORIGINAL_LANGUAGE,
    SAGA_ID,
    DISTRIBUTOR,
    SUITABLE_FOR,
    COOMING_SOON,
    STREAMING_RELEASE_DATE,
    PREQUEL_ID,
    SEQUEL_ID,
    BOX_OFFICE,
    RUNTIME,
    THEATERS_RELEASE_DATE,
    AT_THEATERS
)
VALUES
    (
        '5e02c3c0-368e-48d2-897c-549b84d4b019',
        1,
        'Toy Story',
        'A cowboy doll named Woody feels threatened when a new spaceman toy, Buzz Lightyear, arrives.',
        'English',
        '15b34076-946c-4c27-a284-7a8b1461d1bf',
        'Walt Disney Pictures',
        'G',
        false,
        '2023-02-15',
        NULL, -- No prequel for Toy Story
        'eeb5074a-9ecb-4bf9-b57b-86dc7b3175d5', -- Followed by Toy Story 2
        373600000,
        81,
        '1995-11-22',
        FALSE
    ),
    (
        'eeb5074a-9ecb-4bf9-b57b-86dc7b3175d5',
        1,
        'Toy Story 2',
        'Woody is stolen by a toy collector, and Buzz Lightyear and the other toys set out on a mission to rescue him.',
        'English',
        '15b34076-946c-4c27-a284-7a8b1461d1bf',
        'Walt Disney Pictures',
        'G',
        false,
        '2023-03-15',
        '5e02c3c0-368e-48d2-897c-549b84d4b019', -- Preceded by Toy Story
        '1e1e7ce8-2330-4d4e-9a4b-77d3df47f9c3', -- Followed by Toy Story 3
        497400000,
        92,
        '1999-11-24',
        FALSE
    ),
    (
        '1e1e7ce8-2330-4d4e-9a4b-77d3df47f9c3',
        1,
        'Toy Story 3',
        "Andy's toys mistakenly end up at a daycare center when he prepares to leave for college.",
        'English',
        '15b34076-946c-4c27-a284-7a8b1461d1bf',
        'Walt Disney Pictures',
        'G',
        false,
        '2023-04-15',
        'eeb5074a-9ecb-4bf9-b57b-86dc7b3175d5', -- Preceded by Toy Story 2
        'ac938090-3bd0-4b19-8d6c-57bb2ad89321', -- Followed by Toy Story 4
        1076000000,
        103,
        '2010-06-12',
        FALSE
    ),
    (
        'ac938090-3bd0-4b19-8d6c-57bb2ad89321',
        1,
        'Toy Story 4',
        "Woody and Buzz embark on a quest to find Woody's romantic interest, Bo Peep.",
        'English',
        '15b34076-946c-4c27-a284-7a8b1461d1bf',
        'Walt Disney Pictures',
        'G',
        false,
        '2023-05-15',
        '1e1e7ce8-2330-4d4e-9a4b-77d3df47f9c3', -- Preceded by Toy Story 3
        NULL, -- No sequel planned for Toy Story 4
        1073000000,
        100,
        '2019-06-11',
        FALSE
    );

--Shrek
INSERT INTO film (
    id,
    FILM_TYPE,
    TITLE,
    SYNOPSIS,
    ORIGINAL_LANGUAGE,
    SAGA_ID,
    DISTRIBUTOR,
    SUITABLE_FOR,
    COOMING_SOON,
    STREAMING_RELEASE_DATE,
    PREQUEL_ID,
    SEQUEL_ID,
    BOX_OFFICE,
    RUNTIME,
    THEATERS_RELEASE_DATE,
    AT_THEATERS
)
VALUES
    (
        '3f4089d4-7f7a-4ba0-8812-549b84d4b019',
        1,
        'Shrek',
        'An ogre named Shrek sets out on a journey to rescue Princess Fiona and ends up discovering the value of friendship.',
        'English',
        'ae2d148f-12a3-41f0-a6c8-7a8b1461d1bf',
        'DreamWorks Pictures',
        'PG',
        false,
        '2023-02-15',
        NULL, -- No prequel for Shrek
        'e2e8bb26-3d4a-4285-91d0-86dc7b3175d5', -- Followed by Shrek 2
        484400000,
        90,
        '2001-04-22',
        FALSE
    ),
    (
        'e2e8bb26-3d4a-4285-91d0-86dc7b3175d5',
        1,
        'Shrek 2',
        "Shrek and Fiona visit Fiona's parents to seek their blessing, leading to comedic and unexpected situations.",
        'English',
        'ae2d148f-12a3-41f0-a6c8-7a8b1461d1bf',
        'DreamWorks Pictures',
        'PG',
        false,
        '2023-03-15',
        '3f4089d4-7f7a-4ba0-8812-549b84d4b019', -- Preceded by Shrek
        'ec7f4a8f-4971-4e4b-b040-77d3df47f9c3', -- Followed by Shrek the Third
        919200000,
        93,
        '2004-04-28',
        FALSE
    ),
    (
        'ec7f4a8f-4971-4e4b-b040-77d3df47f9c3',
        1,
        'Shrek the Third',
        'Shrek is reluctantly next in line to be king, but he sets out on a quest to find the FALSE heir instead.',
        'English',
        'ae2d148f-12a3-41f0-a6c8-7a8b1461d1bf',
        'DreamWorks Pictures',
        'PG',
        false,
        '2023-04-15',
        'e2e8bb26-3d4a-4285-91d0-86dc7b3175d5', -- Preceded by Shrek 2
        'd0a8c33d-3d44-4ff7-a0d7-57bb2ad89321', -- Followed by Shrek Forever After
        798900000,
        93,
        '2007-05-17',
        FALSE
    ),
    (
        'd0a8c33d-3d44-4ff7-a0d7-57bb2ad89321',
        1,
        'Shrek Forever After',
        'Shrek makes a deal with Rumpelstiltskin that turns his world upside down and erases him from existence.',
        'English',
        'ae2d148f-12a3-41f0-a6c8-7a8b1461d1bf',
        'DreamWorks Pictures',
        'PG',
        false,
        '2023-05-15',
        'ec7f4a8f-4971-4e4b-b040-77d3df47f9c3', -- Preceded by Shrek the Third
        NULL, -- No sequel planned for Shrek Forever After
        752600000,
        93,
        '2010-04-21',
        FALSE
    );

--Mission Impossible
INSERT INTO film (
    id,
    FILM_TYPE,
    TITLE,
    SYNOPSIS,
    ORIGINAL_LANGUAGE,
    SAGA_ID,
    DISTRIBUTOR,
    SUITABLE_FOR,
    COOMING_SOON,
    STREAMING_RELEASE_DATE,
    PREQUEL_ID,
    SEQUEL_ID,
    BOX_OFFICE,
    RUNTIME,
    THEATERS_RELEASE_DATE,
    AT_THEATERS
)
VALUES
    (
        'd2f17dbf-ff6a-4cfc-92ec-549b84d4b019',
        1,
        'Mission: Impossible',
        'Ethan Hunt is framed for the murder of his team and must clear his name while uncovering a conspiracy.',
        'English',
        '82aa3bc7-d0b0-4d0d-b2ae-7a8b1461d1bf',
        'Paramount Pictures',
        'PG-13',
        false,
        '2023-02-15',
        NULL, -- No prequel for Mission: Impossible
        'b22ee6aa-6f36-4be6-a31a-86dc7b3175d5', -- Followed by Mission: Impossible 2
        457700000,
        110,
        '1996-05-22',
        FALSE
    ),
    (
        'b22ee6aa-6f36-4be6-a31a-86dc7b3175d5',
        1,
        'Mission: Impossible 2',
        'Ethan Hunt is tasked with stopping a rogue agent who has stolen a deadly virus.',
        'English',
        '82aa3bc7-d0b0-4d0d-b2ae-7a8b1461d1bf',
        'Paramount Pictures',
        'PG-13',
        false,
        '2023-03-15',
        'd2f17dbf-ff6a-4cfc-92ec-549b84d4b019', -- Preceded by Mission: Impossible
        '7b6b98e3-9f2f-4ef2-8d1c-77d3df47f9c3', -- Followed by Mission: Impossible III
        546400000,
        123,
        '2000-05-24',
        FALSE
    ),
    (
        '7b6b98e3-9f2f-4ef2-8d1c-77d3df47f9c3',
        1,
        'Mission: Impossible III',
        'Ethan Hunt comes out of retirement to rescue an agent and faces a dangerous arms dealer.',
        'English',
        '82aa3bc7-d0b0-4d0d-b2ae-7a8b1461d1bf',
        'Paramount Pictures',
        'PG-13',
        false,
        '2023-04-15',
        'b22ee6aa-6f36-4be6-a31a-86dc7b3175d5', -- Preceded by Mission: Impossible 2
        'befd8643-97e9-4f6d-9a5e-57bb2ad89321', -- Followed by Mission: Impossible – Ghost Protocol
        397900000,
        126,
        '2006-05-05',
        FALSE
    ),
    (
        'befd8643-97e9-4f6d-9a5e-57bb2ad89321',
        1,
        'Mission: Impossible – Ghost Protocol',
        'The IMF team must stop a nuclear extremist who plans to start a global nuclear war.',
        'English',
        '82aa3bc7-d0b0-4d0d-b2ae-7a8b1461d1bf',
        'Paramount Pictures',
        'PG-13',
        false,
        '2023-05-15',
        '7b6b98e3-9f2f-4ef2-8d1c-77d3df47f9c3', -- Preceded by Mission: Impossible III
        'f3b609a5-53e8-4a42-aecc-19b29d051c2e', -- Followed by Mission: Impossible – Rogue Nation
        694700000,
        132,
        '2011-12-16',
        FALSE
    ),
    (
        'f3b609a5-53e8-4a42-aecc-19b29d051c2e',
        1,
        'Mission: Impossible – Rogue Nation',
        'Ethan Hunt and his team must take down a rogue organization known as the Syndicate.',
        'English',
        '82aa3bc7-d0b0-4d0d-b2ae-7a8b1461d1bf',
        'Paramount Pictures',
        'PG-13',
        false,
        '2023-06-15',
        'befd8643-97e9-4f6d-9a5e-57bb2ad89321', -- Preceded by Ghost Protocol
        'e5ac0580-0d64-4f2c-88c5-8f11f5d71ed9', -- Followed by Mission: Impossible – Fallout
        682700000,
        147,
        '2015-07-31',
        FALSE
    ),
    (
        'e5ac0580-0d64-4f2c-88c5-8f11f5d71ed9',
        1,
        'Mission: Impossible – Fallout',
        'Ethan Hunt and his team must prevent a global catastrophe after a mission goes wrong.',
        'English',
        '82aa3bc7-d0b0-4d0d-b2ae-7a8b1461d1bf',
        'Paramount Pictures',
        'PG-13',
        false,
        '2023-07-15',
        'f3b609a5-53e8-4a42-aecc-19b29d051c2e', -- Preceded by Rogue Nation
        NULL, -- No sequel planned for Fallout
        791100000,
        147,
        '2018-07-27',
        FALSE
    );

--The Mummy
INSERT INTO film (
    id,
    FILM_TYPE,
    TITLE,
    SYNOPSIS,
    ORIGINAL_LANGUAGE,
    SAGA_ID,
    DISTRIBUTOR,
    SUITABLE_FOR,
    COOMING_SOON,
    STREAMING_RELEASE_DATE,
    PREQUEL_ID,
    SEQUEL_ID,
    BOX_OFFICE,
    RUNTIME,
    THEATERS_RELEASE_DATE,
    AT_THEATERS
)
VALUES
    (
        'f97cc5ef-81e2-48dd-94e7-549b84d4b019',
        1,
        'The Mummy',
        'An ancient mummy is accidentally resurrected, unleashing a curse that threatens the world.',
        'English',
        '6db662c3-556a-4e96-8cb3-7a8b1461d1bf',
        'Universal Pictures',
        'PG-13',
        false,
        '2023-02-15',
        NULL, -- No prequel for The Mummy
        'ee5f49eb-52f1-4fc1-940c-86dc7b3175d5', -- Followed by The Mummy Returns
        155400000,
        125,
        '1999-04-16',
        FALSE
    ),
    (
        'ee5f49eb-52f1-4fc1-940c-86dc7b3175d5',
        1,
        'The Mummy Returns',
        "Rick and Evy O'Connell face the resurrected Imhotep, who seeks to conquer the world.",
        'English',
        '6db662c3-556a-4e96-8cb3-7a8b1461d1bf',
        'Universal Pictures',
        'PG-13',
        false,
        '2023-03-15',
        'f97cc5ef-81e2-48dd-94e7-549b84d4b019', -- Preceded by The Mummy
        'c384dab1-63f2-4f77-b45a-77d3df47f9c3', -- Followed by The Mummy: Tomb of the Dragon Emperor
        435000000,
        130,
        '2001-05-04',
        FALSE
    ),
    (
        'c384dab1-63f2-4f77-b45a-77d3df47f9c3',
        1,
        'The Mummy: Tomb of the Dragon Emperor',
        "The O'Connells travel to China to stop the resurrected Emperor Han from achieving immortality.",
        'English',
        '6db662c3-556a-4e96-8cb3-7a8b1461d1bf',
        'Universal Pictures',
        'PG-13',
        false,
        '2023-04-15',
        'ee5f49eb-52f1-4fc1-940c-86dc7b3175d5', -- Preceded by The Mummy Returns
        NULL, -- No sequel planned for Tomb of the Dragon Emperor
        401000000,
        112,
        '2008-07-24',
        FALSE
    );
--Resident Evil
INSERT INTO film (
    id,
    FILM_TYPE,
    TITLE,
    SYNOPSIS,
    ORIGINAL_LANGUAGE,
    SAGA_ID,
    DISTRIBUTOR,
    SUITABLE_FOR,
    COOMING_SOON,
    STREAMING_RELEASE_DATE,
    PREQUEL_ID,
    SEQUEL_ID,
    BOX_OFFICE,
    RUNTIME,
    THEATERS_RELEASE_DATE,
    AT_THEATERS
)
VALUES
    (
        'cd50e45e-b6db-470d-8e9e-549b84d4b019',
        1,
        'Resident Evil',
        'Alice wakes up with no memory in a mansion controlled by a powerful AI and must uncover the truth about the Umbrella Corporation.',
        'English',
        'fdb1c9f0-3b67-4972-97e7-7a8b1461d1bf',
        'Screen Gems',
        'R',
        false,
        '2023-02-15',
        NULL, -- No prequel for Resident Evil
        '67ee768e-8a36-4e68-a2cf-86dc7b3175d5', -- Followed by Resident Evil: Apocalypse
        102900000,
        100,
        '2002-03-15',
        FALSE
    ),
    (
        '67ee768e-8a36-4e68-a2cf-86dc7b3175d5',
        1,
        'Resident Evil: Apocalypse',
        'Alice joins forces with other survivors to escape Raccoon City, now infested with zombies and mutated creatures.',
        'English',
        'fdb1c9f0-3b67-4972-97e7-7a8b1461d1bf',
        'Screen Gems',
        'R',
        false,
        '2023-03-15',
        'cd50e45e-b6db-470d-8e9e-549b84d4b019', -- Preceded by Resident Evil
        '693c3792-7e36-4ea4-a18e-77d3df47f9c3', -- Followed by Resident Evil: Extinction
        129400000,
        94,
        '2004-09-10',
        FALSE
    ),
    (
        '693c3792-7e36-4ea4-a18e-77d3df47f9c3',
        1,
        'Resident Evil: Extinction',
        'Alice continues her fight against the Umbrella Corporation in a world overrun by the T-virus.',
        'English',
        'fdb1c9f0-3b67-4972-97e7-7a8b1461d1bf',
        'Screen Gems',
        'R',
        false,
        '2023-04-15',
        '67ee768e-8a36-4e68-a2cf-86dc7b3175d5', -- Preceded by Resident Evil: Apocalypse
        '51587792-c53e-44f8-8bf7-57bb2ad89321', -- Followed by Resident Evil: Afterlife
        147717833,
        95,
        '2007-09-21',
        FALSE
    ),
    (
        '51587792-c53e-44f8-8bf7-57bb2ad89321',
        1,
        'Resident Evil: Afterlife',
        'Alice searches for survivors in Los Angeles and discovers a safe haven, Arcadia, controlled by the mysterious Wesker.',
        'English',
        'fdb1c9f0-3b67-4972-97e7-7a8b1461d1bf',
        'Screen Gems',
        'R',
        false,
        '2023-05-15',
        '693c3792-7e36-4ea4-a18e-77d3df47f9c3', -- Preceded by Resident Evil: Extinction
        'a9f446b5-676d-4d2b-b065-19b29d051c2e', -- Followed by Resident Evil: Retribution
        300228084,
        96,
        '2010-09-10',
        FALSE
    ),
    (
        'a9f446b5-676d-4d2b-b065-19b29d051c2e',
        1,
        'Resident Evil: Retribution',
        "Alice battles against the Umbrella Corporation's forces while uncovering shocking truths about her past.",
        'English',
        'fdb1c9f0-3b67-4972-97e7-7a8b1461d1bf',
        'Screen Gems',
        'R',
        false,
        '2023-06-15',
        '51587792-c53e-44f8-8bf7-57bb2ad89321', -- Preceded by Resident Evil: Afterlife
        'fd9f7f5c-314b-47b3-bb7b-8f11f5d71ed9', -- Followed by Resident Evil: The Final Chapter
        240159255,
        95,
        '2012-09-14',
        FALSE
    ),
    (
        'fd9f7f5c-314b-47b3-bb7b-8f11f5d71ed9',
        1,
        'Resident Evil: The Final Chapter',
        'Alice returns to Raccoon City for a final showdown with the Umbrella Corporation and the undead hordes.',
        'English',
        'fdb1c9f0-3b67-4972-97e7-7a8b1461d1bf',
        'Screen Gems',
        'R',
        false,
        '2023-07-15',
        'a9f446b5-676d-4d2b-b065-19b29d051c2e', -- Preceded by Resident Evil: Retribution
        NULL, -- No sequel planned for The Final Chapter
        312242626,
        107,
        '2016-12-23',
        FALSE
    );

--Ice Age
INSERT INTO film (
    id,
    FILM_TYPE,
    TITLE,
    SYNOPSIS,
    ORIGINAL_LANGUAGE,
    SAGA_ID,
    DISTRIBUTOR,
    SUITABLE_FOR,
    COOMING_SOON,
    STREAMING_RELEASE_DATE,
    PREQUEL_ID,
    SEQUEL_ID,
    BOX_OFFICE,
    RUNTIME,
    THEATERS_RELEASE_DATE,
    AT_THEATERS
)
VALUES
    (
        'f613d654-d9cb-4b5b-bb46-549b84d4b019',
        1,
        'Ice Age',
        'A group of animals embarks on a journey to return a human baby to its parents during the ice age.',
        'English',
        '9850f96a-84e5-4d2e-a5bf-7a8b1461d1bf',
        '20th Century Fox',
        'PG',
        false,
        '2023-02-15',
        NULL, -- No prequel for Ice Age
        '890e4a6e-cf1f-4397-8f54-86dc7b3175d5', -- Followed by Ice Age: The Meltdown
        383300000,
        81,
        '2002-03-15',
        FALSE
    ),
    (
        '890e4a6e-cf1f-4397-8f54-86dc7b3175d5',
        1,
        'Ice Age: The Meltdown',
        'Manny, Sid, and Diego discover a huge ice dam is about to break, leading to a perilous journey to find safety.',
        'English',
        '9850f96a-84e5-4d2e-a5bf-7a8b1461d1bf',
        '20th Century Fox',
        'PG',
        false,
        '2023-03-15',
        'f613d654-d9cb-4b5b-bb46-549b84d4b019', -- Preceded by Ice Age
        '34579e3a-4de0-4c44-9079-77d3df47f9c3', -- Followed by Ice Age: Dawn of the Dinosaurs
        660940780,
        91,
        '2006-03-31',
        FALSE
    ),
    (
        '34579e3a-4de0-4c44-9079-77d3df47f9c3',
        1,
        'Ice Age: Dawn of the Dinosaurs',
        'The gang encounters dinosaurs in an underground world while trying to rescue Sid from a dinosaur egg.',
        'English',
        '9850f96a-84e5-4d2e-a5bf-7a8b1461d1bf',
        '20th Century Fox',
        'PG',
        false,
        '2023-04-15',
        '890e4a6e-cf1f-4397-8f54-86dc7b3175d5', -- Preceded by Ice Age: The Meltdown
        'd0e7fdaa-1a71-47b1-a70a-57bb2ad89321', -- Followed by Ice Age: Continental Drift
        886686817,
        94,
        '2009-06-30',
        FALSE
    ),
    (
        'd0e7fdaa-1a71-47b1-a70a-57bb2ad89321',
        1,
        'Ice Age: Continental Drift',
        'The continent begins to drift apart, separating Manny, Sid, and Diego from their families, prompting an epic adventure.',
        'English',
        '9850f96a-84e5-4d2e-a5bf-7a8b1461d1bf',
        '20th Century Fox',
        'PG',
        false,
        '2023-05-15',
        '34579e3a-4de0-4c44-9079-77d3df47f9c3', -- Preceded by Ice Age: Dawn of the Dinosaurs
        'f8727d9d-afda-4f8c-87b2-19b29d051c2e', -- Followed by Ice Age: Collision Course
        877244782,
        88,
        '2012-07-13',
        FALSE
    ),
    (
        'f8727d9d-afda-4f8c-87b2-19b29d051c2e',
        1,
        'Ice Age: Collision Course',
        'Manny and his friends must prevent a cosmic disaster that could end the Ice Age world.',
        'English',
        '9850f96a-84e5-4d2e-a5bf-7a8b1461d1bf',
        '20th Century Fox',
        'PG',
        false,
        '2023-06-15',
        'd0e7fdaa-1a71-47b1-a70a-57bb2ad89321', -- Preceded by Ice Age: Continental Drift
        NULL, -- No sequel planned for Ice Age: Collision Course
        408579038,
        94,
        '2016-07-22',
        FALSE
    )
    -- Add more mock data as needed
    ;

--Spider-Man
INSERT INTO film (
    id,
    FILM_TYPE,
    TITLE,
    SYNOPSIS,
    ORIGINAL_LANGUAGE,
    SAGA_ID,
    DISTRIBUTOR,
    SUITABLE_FOR,
    COOMING_SOON,
    STREAMING_RELEASE_DATE,
    PREQUEL_ID,
    SEQUEL_ID,
    BOX_OFFICE,
    RUNTIME,
    THEATERS_RELEASE_DATE,
    AT_THEATERS
)
VALUES
    (
        '4ec7fecc-f015-4a11-8871-549b84d4b019',
        1,
        'Spider-Man',
        'Peter Parker gains spider-like abilities and uses them to fight crime while facing the Green Goblin.',
        'English',
        '6378b2a1-bf9e-4f5e-874f-7a8b1461d1bf',
        'Sony Pictures Releasing',
        'PG-13',
        false,
        '2023-02-15',
        NULL, -- No prequel for Spider-Man
        'c2f143ab-e992-4cfa-8ad0-86dc7b3175d5', -- Followed by Spider-Man 2
        821708551,
        121,
        '2002-05-03',
        FALSE
    ),
    (
        'c2f143ab-e992-4cfa-8ad0-86dc7b3175d5',
        1,
        'Spider-Man 2',
        'Peter Parker struggles with the responsibilities of being Spider-Man while facing the powerful Doctor Octopus.',
        'English',
        '6378b2a1-bf9e-4f5e-874f-7a8b1461d1bf',
        'Sony Pictures Releasing',
        'PG-13',
        false,
        '2023-03-15',
        '4ec7fecc-f015-4a11-8871-549b84d4b019', -- Preceded by Spider-Man
        'e343cb24-0d8f-4d92-826f-77d3df47f9c3', -- Followed by Spider-Man 3
        783766341,
        127,
        '2004-06-30',
        FALSE
    ),
    (
        'e343cb24-0d8f-4d92-826f-77d3df47f9c3',
        1,
        'Spider-Man 3',
        'Peter Parker faces new challenges when the symbiote attaches to him, leading to the emergence of Venom.',
        'English',
        '6378b2a1-bf9e-4f5e-874f-7a8b1461d1bf',
        'Sony Pictures Releasing',
        'PG-13',
        false,
        '2023-04-15',
        'c2f143ab-e992-4cfa-8ad0-86dc7b3175d5', -- Preceded by Spider-Man 2
        NULL, -- No sequel planned for Spider-Man 3
        894983373,
        139,
        '2007-05-01',
        FALSE
    )
    -- Add more mock data as needed
    ;

--The Matrix
INSERT INTO film (
    id,
    FILM_TYPE,
    TITLE,
    SYNOPSIS,
    ORIGINAL_LANGUAGE,
    SAGA_ID,
    DISTRIBUTOR,
    SUITABLE_FOR,
    COOMING_SOON,
    STREAMING_RELEASE_DATE,
    PREQUEL_ID,
    SEQUEL_ID,
    BOX_OFFICE,
    RUNTIME,
    THEATERS_RELEASE_DATE,
    AT_THEATERS
)
VALUES
    (
        '997f1b76-3484-4d87-8b21-549b84d4b019',
        1,
        'The Matrix',
        'Neo discovers the truth about the Matrix and joins the rebellion against the machines.',
        'English',
        'a6a6b61e-1040-43a7-8658-7a8b1461d1bf',
        'Warner Bros. Pictures',
        'R',
        false,
        '2023-02-15',
        NULL, -- No prequel for The Matrix
        '491e0975-b9bf-4ac3-9274-86dc7b3175d5', -- Followed by The Matrix Reloaded
        463517383,
        136,
        '1999-03-31',
        FALSE
    ),
    (
        '491e0975-b9bf-4ac3-9274-86dc7b3175d5',
        1,
        'The Matrix Reloaded',
        'Neo, Trinity, and Morpheus face new challenges as they continue their fight against the machines.',
        'English',
        'a6a6b61e-1040-43a7-8658-7a8b1461d1bf',
        'Warner Bros. Pictures',
        'R',
        false,
        '2023-03-15',
        '997f1b76-3484-4d87-8b21-549b84d4b019', -- Preceded by The Matrix
        '3f60de1c-4f5e-4b63-835c-77d3df47f9c3', -- Followed by The Matrix Revolutions
        738576929,
        138,
        '2003-05-07',
        FALSE
    ),
    (
        '3f60de1c-4f5e-4b63-835c-77d3df47f9c3',
        1,
        'The Matrix Revolutions',
        'The final battle between humanity and the machines unfolds as Neo confronts the source of the Matrix.',
        'English',
        'a6a6b61e-1040-43a7-8658-7a8b1461d1bf',
        'Warner Bros. Pictures',
        'R',
        false,
        '2023-04-15',
        '491e0975-b9bf-4ac3-9274-86dc7b3175d5', -- Preceded by The Matrix Reloaded
        NULL, -- No sequel planned for The Matrix Revolutions
        427343288,
        129,
        '2003-10-27',
        FALSE
    )
    -- Add more mock data as needed
    ;

--Iron Man
INSERT INTO film (
    id,
    FILM_TYPE,
    TITLE,
    SYNOPSIS,
    ORIGINAL_LANGUAGE,
    SAGA_ID,
    DISTRIBUTOR,
    SUITABLE_FOR,
    COOMING_SOON,
    STREAMING_RELEASE_DATE,
    PREQUEL_ID,
    SEQUEL_ID,
    BOX_OFFICE,
    RUNTIME,
    THEATERS_RELEASE_DATE,
    AT_THEATERS
)
VALUES
    (
        '7fc79eb3-f84c-4650-a4c3-549b84d4b019',
        1,
        'Iron Man',
        'Tony Stark, a wealthy industrialist, builds a powered suit of armor and becomes the superhero Iron Man.',
        'English',
        'b19ac7cc-7a1f-4ba0-8d45-7a8b1461d1bf',
        'Paramount Pictures',
        'PG-13',
        false,
        '2023-02-15',
        NULL, -- No prequel for Iron Man
        '1f1d7e23-6899-40aa-8ad4-86dc7b3175d5', -- Followed by Iron Man 2
        585174222,
        126,
        '2008-04-30',
        FALSE
    ),
    (
        '1f1d7e23-6899-40aa-8ad4-86dc7b3175d5',
        1,
        'Iron Man 2',
        'Tony Stark faces new threats while dealing with his declining health and the emergence of a rival.',
        'English',
        'b19ac7cc-7a1f-4ba0-8d45-7a8b1461d1bf',
        'Paramount Pictures',
        'PG-13',
        false,
        '2023-03-15',
        '7fc79eb3-f84c-4650-a4c3-549b84d4b019', -- Preceded by Iron Man
        '5072401a-cfae-4e3b-9538-77d3df47f9c3', -- Followed by The Avengers
        623933331,
        124,
        '2010-04-26',
        FALSE
    ),
    (
        '5072401a-cfae-4e3b-9538-77d3df47f9c3',
        1,
        'The Avengers',
        'Iron Man, Captain America, Thor, and other heroes join forces to stop Loki and his alien army.',
        'English',
        'b19ac7cc-7a1f-4ba0-8d45-7a8b1461d1bf',
        'Walt Disney Studios Motion Pictures',
        'PG-13',
        false,
        '2023-04-15',
        '1f1d7e23-6899-40aa-8ad4-86dc7b3175d5', -- Preceded by Iron Man 2
        '943b4b26-c495-40d6-a172-19b29d051c2e', -- Followed by Iron Man 3
        1.518 billion,
        143,
        '2012-04-11',
        FALSE
    ),
    (
        '943b4b26-c495-40d6-a172-19b29d051c2e',
        1,
        'Iron Man 3',
        'Tony Stark faces a formidable enemy known as the Mandarin, leading to personal and professional challenges.',
        'English',
        'b19ac7cc-7a1f-4ba0-8d45-7a8b1461d1bf',
        'Walt Disney Studios Motion Pictures',
        'PG-13',
        false,
        '2023-05-15',
        '5072401a-cfae-4e3b-9538-77d3df47f9c3', -- Preceded by The Avengers
        NULL, -- No sequel planned for Iron Man 3
        1.214 billion,
        130,
        '2013-04-24',
        FALSE
    )
    -- Add more mock data as needed
    ;

--Indiana Jones
INSERT INTO film (
    id,
    FILM_TYPE,
    TITLE,
    SYNOPSIS,
    ORIGINAL_LANGUAGE,
    SAGA_ID,
    DISTRIBUTOR,
    SUITABLE_FOR,
    COOMING_SOON,
    STREAMING_RELEASE_DATE,
    PREQUEL_ID,
    SEQUEL_ID,
    BOX_OFFICE,
    RUNTIME,
    THEATERS_RELEASE_DATE,
    AT_THEATERS
)
VALUES
    (
        '0ec5e7c4-3d17-4d2b-9c44-549b84d4b019',
        1,
        'Raiders of the Lost Ark',
        'Archaeologist Indiana Jones races against the Nazis to find the Ark of the Covenant.',
        'English',
        'e17a3e32-512b-46f1-936d-7a8b1461d1bf',
        'Paramount Pictures',
        'PG',
        false,
        '2023-02-15',
        NULL, -- No prequel for Raiders of the Lost Ark
        '2ac3d9d4-52f6-4f3b-bdf3-86dc7b3175d5', -- Followed by Indiana Jones and the Temple of Doom
        389925971,
        115,
        '1981-06-12',
        FALSE
    ),
    (
        '2ac3d9d4-52f6-4f3b-bdf3-86dc7b3175d5',
        1,
        'Indiana Jones and the Temple of Doom',
        'Indiana Jones, along with Short Round and Willie Scott, embarks on a quest to retrieve a mystical stone.',
        'English',
        'e17a3e32-512b-46f1-936d-7a8b1461d1bf',
        'Paramount Pictures',
        'PG',
        false,
        '2023-03-15',
        '0ec5e7c4-3d17-4d2b-9c44-549b84d4b019', -- Preceded by Raiders of the Lost Ark
        '5f64d75a-e0ea-4598-9cf0-77d3df47f9c3', -- Followed by Indiana Jones and the Last Crusade
        474171806,
        118,
        '1984-05-23',
        FALSE
    ),
    (
        '5f64d75a-e0ea-4598-9cf0-77d3df47f9c3',
        1,
        'Indiana Jones and the Last Crusade',
        'Indiana Jones teams up with his father to find the Holy Grail and stop the Nazis once and for all.',
        'English',
        'e17a3e32-512b-46f1-936d-7a8b1461d1bf',
        'Paramount Pictures',
        'PG-13',
        false,
        '2023-04-15',
        '2ac3d9d4-52f6-4f3b-bdf3-86dc7b3175d5', -- Preceded by Indiana Jones and the Temple of Doom
        NULL, -- No sequel planned for Indiana Jones and the Last Crusade
        474171806,
        127,
        '1989-05-24',
        FALSE
    );
--The Terminator
INSERT INTO film (
    id,
    FILM_TYPE,
    TITLE,
    SYNOPSIS,
    ORIGINAL_LANGUAGE,
    SAGA_ID,
    DISTRIBUTOR,
    SUITABLE_FOR,
    COOMING_SOON,
    STREAMING_RELEASE_DATE,
    PREQUEL_ID,
    SEQUEL_ID,
    BOX_OFFICE,
    RUNTIME,
    THEATERS_RELEASE_DATE,
    AT_THEATERS
)
VALUES
    (
        'b943a1cf-5b18-43f7-862a-549b84d4b019',
        1,
        'The Terminator',
        'A cyborg assassin is sent back in time to kill Sarah Connor, the mother of the future leader of the resistance.',
        'English',
        '1d16f3d4-42c1-4df0-bc3e-7a8b1461d1bf',
        'Orion Pictures',
        'R',
        false,
        '2023-02-15',
        NULL, -- No prequel for The Terminator
        '2e1b83aa-3dbf-4a61-b5a2-86dc7b3175d5', -- Followed by Terminator 2: Judgment Day
        78.4 million,
        107,
        '1984-10-26',
        FALSE
    ),
    (
        '2e1b83aa-3dbf-4a61-b5a2-86dc7b3175d5',
        1,
        'Terminator 2: Judgment Day',
        'A new Terminator is sent to protect John Connor from a more advanced and powerful Terminator.',
        'English',
        '1d16f3d4-42c1-4df0-bc3e-7a8b1461d1bf',
        'TriStar Pictures',
        'R',
        false,
        '2023-03-15',
        'b943a1cf-5b18-43f7-862a-549b84d4b019', -- Preceded by The Terminator
        '3cf70b25-8a47-4f5b-ae91-77d3df47f9c3', -- Followed by Terminator 3: Rise of the Machines
        519.8 million,
        137,
        '1991-07-01',
        FALSE
    ),
    (
        '3cf70b25-8a47-4f5b-ae91-77d3df47f9c3',
        1,
        'Terminator 3: Rise of the Machines',
        'John Connor must once again face a Terminator, this time a female model, and prevent Judgment Day.',
        'English',
        '1d16f3d4-42c1-4df0-bc3e-7a8b1461d1bf',
        'Warner Bros. Pictures',
        'R',
        false,
        '2023-04-15',
        '2e1b83aa-3dbf-4a61-b5a2-86dc7b3175d5', -- Preceded by Terminator 2: Judgment Day
        'f59d6ff6-c469-4767-9cc7-19b29d051c2e', -- Followed by Terminator Salvation
        433.4 million,
        109,
        '2003-06-30',
        FALSE
    ),
    (
        'f59d6ff6-c469-4767-9cc7-19b29d051c2e',
        1,
        'Terminator Salvation',
        'Set in a post-apocalyptic future, John Connor leads the resistance against Skynet and its machines.',
        'English',
        '1d16f3d4-42c1-4df0-bc3e-7a8b1461d1bf',
        'Warner Bros. Pictures',
        'PG-13',
        false,
        '2023-05-15',
        '3cf70b25-8a47-4f5b-ae91-77d3df47f9c3', -- Preceded by Terminator 3: Rise of the Machines
        '6143835a-2292-42c7-8bfa-86dc7b3175d5', -- Followed by Terminator Genisys
        371.4 million,
        115,
        '2009-05-14',
        FALSE
    ),
    (
        '6143835a-2292-42c7-8bfa-86dc7b3175d5',
        1,
        'Terminator Genisys',
        'The timeline is altered as Sarah Connor and a Guardian Terminator team up to prevent Judgment Day.',
        'English',
        '1d16f3d4-42c1-4df0-bc3e-7a8b1461d1bf',
        'Paramount Pictures',
        'PG-13',
        false,
        '2023-06-15',
        'f59d6ff6-c469-4767-9cc7-19b29d051c2e', -- Preceded by Terminator Salvation
        'c0e1d24f-c6da-4912-8980-19b29d051c2e', -- Followed by Terminator: Dark Fate
        440.6 million,
        126,
        '2015-06-28',
        FALSE
    ),
    (
        'c0e1d24f-c6da-4912-8980-19b29d051c2e',
        1,
        'Terminator: Dark Fate',
        'Sarah Connor returns to battle a new, highly advanced Terminator, accompanied by a human-machine hybrid.',
        'English',
        '1d16f3d4-42c1-4df0-bc3e-7a8b1461d1bf',
        'Paramount Pictures',
        'R',
        false,
        '2023-07-15',
        '6143835a-2292-42c7-8bfa-86dc7b3175d5', -- Preceded by Terminator Genisys
        NULL, -- No sequel planned for Terminator: Dark Fate
        261.1 million,
        128,
        '2019-10-23',
        FALSE
    )
    -- Add more mock data as needed
    ;

--Jurassic Park
INSERT INTO film (
    id,
    FILM_TYPE,
    TITLE,
    SYNOPSIS,
    ORIGINAL_LANGUAGE,
    SAGA_ID,
    DISTRIBUTOR,
    SUITABLE_FOR,
    COOMING_SOON,
    STREAMING_RELEASE_DATE,
    PREQUEL_ID,
    SEQUEL_ID,
    BOX_OFFICE,
    RUNTIME,
    THEATERS_RELEASE_DATE,
    AT_THEATERS
)
VALUES
    (
        '9535a650-c1c2-4f12-8302-549b84d4b019',
        1,
        'Jurassic Park',
        'A theme park with genetically engineered dinosaurs experiences a catastrophic failure, endangering visitors.',
        'English',
        'fcae48b9-0e94-4a52-8190-7a8b1461d1bf',
        'Universal Pictures',
        'PG-13',
        false,
        '2023-02-15',
        NULL, -- No prequel for Jurassic Park
        '9a00426e-62c0-4872-a1c7-86dc7b3175d5', -- Followed by The Lost World: Jurassic Park
        1.029 billion,
        127,
        '1993-06-11',
        FALSE
    ),
    (
        '9a00426e-62c0-4872-a1c7-86dc7b3175d5',
        1,
        'The Lost World: Jurassic Park',
        'A group returns to Isla Sorna to study dinosaurs, but encounters unexpected dangers, including a T-Rex in San Diego.',
        'English',
        'fcae48b9-0e94-4a52-8190-7a8b1461d1bf',
        'Universal Pictures',
        'PG-13',
        false,
        '2023-03-15',
        '9535a650-c1c2-4f12-8302-549b84d4b019', -- Preceded by Jurassic Park
        '780df39b-7f88-4ce6-a7e6-77d3df47f9c3', -- Followed by Jurassic Park III
        618.6 million,
        129,
        '1997-05-23',
        FALSE
    ),
    (
        '780df39b-7f88-4ce6-a7e6-77d3df47f9c3',
        1,
        'Jurassic Park III',
        'A rescue mission turns into a fight for survival when a group becomes stranded on Isla Sorna with dangerous dinosaurs.',
        'English',
        'fcae48b9-0e94-4a52-8190-7a8b1461d1bf',
        'Universal Pictures',
        'PG-13',
        false,
        '2023-04-15',
        '9a00426e-62c0-4872-a1c7-86dc7b3175d5', -- Preceded by The Lost World: Jurassic Park
        '34b84936-c72c-45c8-a04e-19b29d051c2e', -- Followed by Jurassic World
        368.8 million,
        92,
        '2001-07-18',
        FALSE
    ),
    (
        '34b84936-c72c-45c8-a04e-19b29d051c2e',
        1,
        'Jurassic World',
        'A new theme park with genetically modified dinosaurs faces a crisis when a highly intelligent hybrid escapes.',
        'English',
        'fcae48b9-0e94-4a52-8190-7a8b1461d1bf',
        'Universal Pictures',
        'PG-13',
        false,
        '2023-05-15',
        '780df39b-7f88-4ce6-a7e6-77d3df47f9c3', -- Preceded by Jurassic Park III
        '9c2d977a-116a-44e6-a3c1-86dc7b3175d5', -- Followed by Jurassic World: Fallen Kingdom
        1.672 billion,
        124,
        '2015-06-09',
        FALSE
    ),
    (
        '9c2d977a-116a-44e6-a3c1-86dc7b3175d5',
        1,
        'Jurassic World: Fallen Kingdom',
        'Owen and Claire return to Isla Nublar to save the remaining dinosaurs from an impending volcanic eruption.',
        'English',
        'fcae48b9-0e94-4a52-8190-7a8b1461d1bf',
        'Universal Pictures',
        'PG-13',
        false,
        '2023-06-15',
        '34b84936-c72c-45c8-a04e-19b29d051c2e', -- Preceded by Jurassic World
        '04d5a6a7-d465-42b4-81da-19b29d051c2e', -- Followed by Jurassic World: Dominion
        1.308 billion,
        128,
        '2018-06-06',
        FALSE
    ),
    (
        '04d5a6a7-d465-42b4-81da-19b29d051c2e',
        1,
        'Jurassic World: Dominion',
        'Dinosaurs now coexist with humans, but a new threat emerges that could change the balance of power.',
        'English',
        'fcae48b9-0e94-4a52-8190-7a8b1461d1bf',
        'Universal Pictures',
        'PG-13',
        false,
        '2023-07-15',
        '9c2d977a-116a-44e6-a3c1-86dc7b3175d5', -- Preceded by Jurassic World: Fallen Kingdom
        NULL,
        1.434 billion,
        132,
        '2020-08-10',
        FALSE
    );

--Rambo
INSERT INTO film (
    id,
    FILM_TYPE,
    TITLE,
    SYNOPSIS,
    ORIGINAL_LANGUAGE,
    SAGA_ID,
    DISTRIBUTOR,
    SUITABLE_FOR,
    COOMING_SOON,
    STREAMING_RELEASE_DATE,
    PREQUEL_ID,
    SEQUEL_ID,
    BOX_OFFICE,
    RUNTIME,
    THEATERS_RELEASE_DATE,
    AT_THEATERS
)
VALUES
    (
        '2b226f0f-3c93-46b9-9e62-549b84d4b019',
        1,
        'First Blood',
        "Vietnam War veteran John Rambo faces mistreatment from a small town's police force, leading to a one-man war.",
        'English',
        '785855c1-0873-4eae-aa7c-7a8b1461d1bf',
        'Orion Pictures',
        'R',
        false,
        '2023-02-15',
        NULL, -- No prequel for First Blood
        'e1e9637c-badd-46ab-a630-86dc7b3175d5', -- Followed by Rambo: First Blood Part II
        125.2 million,
        96,
        '1982-10-22',
        FALSE
    ),
    (
        'e1e9637c-badd-46ab-a630-86dc7b3175d5',
        1,
        'Rambo: First Blood Part II',
        'John Rambo is sent on a mission to rescue American POWs in Vietnam, uncovering betrayal and political intrigue.',
        'English',
        '785855c1-0873-4eae-aa7c-7a8b1461d1bf',
        'TriStar Pictures',
        'R',
        false,
        '2023-03-15',
        '2b226f0f-3c93-46b9-9e62-549b84d4b019', -- Preceded by First Blood
        '7c635499-3f46-4e1d-ba1d-77d3df47f9c3', -- Followed by Rambo III
        300.4 million,
        96,
        '1985-05-22',
        FALSE
    ),
    (
        '7c635499-3f46-4e1d-ba1d-77d3df47f9c3',
        1,
        'Rambo III',
        'Rambo travels to Afghanistan to rescue his former commander who is captured by Soviet forces during the war.',
        'English',
        '785855c1-0873-4eae-aa7c-7a8b1461d1bf',
        'TriStar Pictures',
        'R',
        false,
        '2023-04-15',
        'e1e9637c-badd-46ab-a630-86dc7b3175d5', -- Preceded by Rambo: First Blood Part II
        'f35b8a06-1a57-4a22-9f71-19b29d051c2e', -- Followed by Rambo
        189.0 million,
        102,
        '1988-05-25',
        FALSE
    ),
    (
        'f35b8a06-1a57-4a22-9f71-19b29d051c2e',
        1,
        'Rambo',
        'John Rambo is persuaded to undertake a mission to rescue aid workers in Burma, confronting a ruthless military regime.',
        'English',
        '785855c1-0873-4eae-aa7c-7a8b1461d1bf',
        'Lionsgate',
        'R',
        false,
        '2023-05-15',
        '7c635499-3f46-4e1d-ba1d-77d3df47f9c3', -- Preceded by Rambo III
        'c9f276ed-0a8a-4d1a-89d5-86dc7b3175d5', -- Followed by Rambo: Last Blood
        113.2 million,
        89,
        '2008-01-25',
        FALSE
    ),
    (
        'c9f276ed-0a8a-4d1a-89d5-86dc7b3175d5',
        1,
        'Rambo: Last Blood',
        "Rambo seeks vengeance when a friend's daughter is kidnapped by a Mexican cartel, leading to a deadly confrontation.",
        'English',
        '785855c1-0873-4eae-aa7c-7a8b1461d1bf',
        'Lionsgate',
        'R',
        false,
        '2023-06-15',
        'f35b8a06-1a57-4a22-9f71-19b29d051c2e', -- Preceded by Rambo
        NULL, -- No sequel planned for Rambo: Last Blood
        91.5 million,
        89,
        '2019-09-20',
        FALSE
    )

--The Hangover
INSERT INTO film (
    id,
    FILM_TYPE,
    TITLE,
    SYNOPSIS,
    ORIGINAL_LANGUAGE,
    SAGA_ID,
    DISTRIBUTOR,
    SUITABLE_FOR,
    COOMING_SOON,
    STREAMING_RELEASE_DATE,
    PREQUEL_ID,
    SEQUEL_ID,
    BOX_OFFICE,
    RUNTIME,
    THEATERS_RELEASE_DATE,
    AT_THEATERS
)
VALUES
    (
        '5e6a4861-493a-4a14-b950-549b84d4b019',
        1,
        'The Hangover',
        'A bachelor party in Las Vegas goes awry, and the groomsmen must retrace their steps to find the missing groom.',
        'English',
        'bb82103a-708e-4a86-953c-7a8b1461d1bf',
        'Warner Bros. Pictures',
        'R',
        false,
        '2023-02-15',
        NULL, -- No prequel for The Hangover
        '0f9c90da-d591-42ab-af2d-86dc7b3175d5', -- Followed by The Hangover Part II
        467.5 million,
        100,
        '2009-06-05',
        FALSE
    ),
    (
        '0f9c90da-d591-42ab-af2d-86dc7b3175d5',
        1,
        'The Hangover Part II',
        "The Wolfpack travels to Thailand for Stu\'s wedding, but another wild night leads to a search for a missing friend.",
        'English',
        'bb82103a-708e-4a86-953c-7a8b1461d1bf',
        'Warner Bros. Pictures',
        'R',
        false,
        '2023-03-15',
        '5e6a4861-493a-4a14-b950-549b84d4b019', -- Preceded by The Hangover
        'd1b70fc3-0b12-4c8d-9d6a-77d3df47f9c3', -- Followed by The Hangover Part III
        586.8 million,
        102,
        '2011-05-26',
        FALSE
    ),
    (
        'd1b70fc3-0b12-4c8d-9d6a-77d3df47f9c3',
        1,
        'The Hangover Part III',
        'The Wolfpack attempts an intervention to help Alan, but things take a dangerous turn when they cross paths with a criminal.',
        'English',
        'bb82103a-708e-4a86-953c-7a8b1461d1bf',
        'Warner Bros. Pictures',
        'R',
        false,
        '2023-04-15',
        '0f9c90da-d591-42ab-af2d-86dc7b3175d5', -- Preceded by The Hangover Part II
        NULL, -- No sequel planned for The Hangover Part III
        362 million,
        100,
        '2013-05-23',
        FALSE
    )
    -- Add more mock data as needed
    ;

--Back to the Future
INSERT INTO film (
    id,
    FILM_TYPE,
    TITLE,
    SYNOPSIS,
    ORIGINAL_LANGUAGE,
    SAGA_ID,
    DISTRIBUTOR,
    SUITABLE_FOR,
    COOMING_SOON,
    STREAMING_RELEASE_DATE,
    PREQUEL_ID,
    SEQUEL_ID,
    BOX_OFFICE,
    RUNTIME,
    THEATERS_RELEASE_DATE,
    AT_THEATERS
)
VALUES
    (
        '823f77c2-6b1c-4cc3-92b2-549b84d4b019',
        1,
        'Back to the Future',
        'Marty McFly is accidentally sent 30 years into the past by a time-traveling DeLorean, endangering his own existence.',
        'English',
        '1477ab9f-079c-4e4c-b973-7a8b1461d1bf',
        'Universal Pictures',
        'PG',
        false,
        '2023-02-15',
        NULL, -- No prequel for Back to the Future
        '83a46bc4-7d3b-40cb-ae71-86dc7b3175d5', -- Followed by Back to the Future Part II
        389.1 million,
        116,
        '1985-07-03',
        FALSE
    ),
    (
        '83a46bc4-7d3b-40cb-ae71-86dc7b3175d5',
        1,
        'Back to the Future Part II',
        'Marty and Doc travel to the future to prevent a family disaster, but their actions have unintended consequences.',
        'English',
        '1477ab9f-079c-4e4c-b973-7a8b1461d1bf',
        'Universal Pictures',
        'PG',
        false,
        '2023-03-15',
        '823f77c2-6b1c-4cc3-92b2-549b84d4b019', -- Preceded by Back to the Future
        'c68608f8-ef27-4c5a-bf2e-77d3df47f9c3', -- Followed by Back to the Future Part III
        332 million,
        108,
        '1989-11-22',
        FALSE
    ),
    (
        'c68608f8-ef27-4c5a-bf2e-77d3df47f9c3',
        1,
        'Back to the Future Part III',
        'Marty travels to the Wild West to rescue Doc, but they face challenges and must find a way back to their time.',
        'English',
        '1477ab9f-079c-4e4c-b973-7a8b1461d1bf',
        'Universal Pictures',
        'PG',
        false,
        '2023-04-15',
        '83a46bc4-7d3b-40cb-ae71-86dc7b3175d5', -- Preceded by Back to the Future Part II
        NULL, -- No sequel planned for Back to the Future Part III
        244.5 million,
        118,
        '1990-05-25',
        FALSE
    );

--Men in Black
INSERT INTO film (
    id,
    FILM_TYPE,
    TITLE,
    SYNOPSIS,
    ORIGINAL_LANGUAGE,
    SAGA_ID,
    DISTRIBUTOR,
    SUITABLE_FOR,
    COOMING_SOON,
    STREAMING_RELEASE_DATE,
    PREQUEL_ID,
    SEQUEL_ID,
    BOX_OFFICE,
    RUNTIME,
    THEATERS_RELEASE_DATE,
    AT_THEATERS
)
VALUES
    (
        'c0cc183c-30e5-4714-bec0-549b84d4b019',
        1,
        'Men in Black',
        'A top-secret government agency monitors and polices extraterrestrial activity on Earth.',
        'English',
        '2c51dbae-3b4a-4a86-8a29-7a8b1461d1bf',
        'Columbia Pictures',
        'PG-13',
        false,
        '2023-02-15',
        NULL, -- No prequel for Men in Black
        '0ec5c120-3801-46e7-a3f5-86dc7b3175d5', -- Followed by Men in Black II
        589.4 million,
        98,
        '1997-07-02',
        FALSE
    ),
    (
        '0ec5c120-3801-46e7-a3f5-86dc7b3175d5',
        1,
        'Men in Black II',
        'Agent J must reunite with Agent K to stop an evil alien threat that could destroy Earth.',
        'English',
        '2c51dbae-3b4a-4a86-8a29-7a8b1461d1bf',
        'Columbia Pictures',
        'PG-13',
        false,
        '2023-03-15',
        'c0cc183c-30e5-4714-bec0-549b84d4b019', -- Preceded by Men in Black
        '1379b3cc-e0bf-4f4a-8e90-77d3df47f9c3', -- Followed by Men in Black 3
        441.8 million,
        88,
        '2002-07-03',
        FALSE
    ),
    (
        '1379b3cc-e0bf-4f4a-8e90-77d3df47f9c3',
        1,
        'Men in Black 3',
        'Agent J travels back in time to the 1960s to prevent an alien from assassinating a young Agent K.',
        'English',
        '2c51dbae-3b4a-4a86-8a29-7a8b1461d1bf',
        'Columbia Pictures',
        'PG-13',
        false,
        '2023-04-15',
        '0ec5c120-3801-46e7-a3f5-86dc7b3175d5', -- Preceded by Men in Black II
        'f02a5d7f-9a43-43cc-8a89-19b29d051c2e', -- Followed by Men in Black: International
        624 million,
        106,
        '2012-05-25',
        FALSE
    ),
    (
        'f02a5d7f-9a43-43cc-8a89-19b29d051c2e',
        1,
        'Men in Black: International',
        'Agent H and rookie M must prevent an alien threat and uncover a mole within the Men in Black organization.',
        'English',
        '2c51dbae-3b4a-4a86-8a29-7a8b1461d1bf',
        'Columbia Pictures',
        'PG-13',
        false,
        '2023-05-15',
        '1379b3cc-e0bf-4f4a-8e90-77d3df47f9c3', -- Preceded by Men in Black 3
        NULL, -- No sequel planned for Men in Black: International
        253.9 million,
        115,
        '2019-06-14',
        FALSE
    );
--Die Hard
INSERT INTO film (
    id,
    FILM_TYPE,
    TITLE,
    SYNOPSIS,
    ORIGINAL_LANGUAGE,
    SAGA_ID,
    DISTRIBUTOR,
    SUITABLE_FOR,
    COOMING_SOON,
    STREAMING_RELEASE_DATE,
    PREQUEL_ID,
    SEQUEL_ID,
    BOX_OFFICE,
    RUNTIME,
    THEATERS_RELEASE_DATE,
    AT_THEATERS
)
VALUES
    (
        'b2e09126-7f86-493d-9d0b-549b84d4b019',
        1,
        'Die Hard',
        'NYPD officer John McClane takes on a group of terrorists who have seized a Los Angeles skyscraper during a Christmas party.',
        'English',
        'c14b6f06-83e3-492f-8c0b-7a8b1461d1bf',
        '20th Century Fox',
        'R',
        false,
        '2023-02-15',
        NULL, -- No prequel for Die Hard
        '86e9933b-7089-4a09-8c3d-86dc7b3175d5', -- Followed by Die Hard 2
        141.5 million,
        132,
        '1988-07-15',
        FALSE
    ),
    (
        '86e9933b-7089-4a09-8c3d-86dc7b3175d5',
        1,
        'Die Hard 2',
        "John McClane must stop terrorists who take an airport hostage while his wife's plane circles overhead.",
        'English',
        'c14b6f06-83e3-492f-8c0b-7a8b1461d1bf',
        '20th Century Fox',
        'R',
        false,
        '2023-03-15',
        'b2e09126-7f86-493d-9d0b-549b84d4b019', -- Preceded by Die Hard
        '55c7914b-86bf-43a5-9a67-77d3df47f9c3', -- Followed by Die Hard with a Vengeance
        240 million,
        124,
        '1990-07-04',
        FALSE
    ),
    (
        '55c7914b-86bf-43a5-9a67-77d3df47f9c3',
        1,
        'Die Hard with a Vengeance',
        'John McClane teams up with a Harlem store owner to stop a terrorist with a personal vendetta against McClane.',
        'English',
        'c14b6f06-83e3-492f-8c0b-7a8b1461d1bf',
        '20th Century Fox',
        'R',
        false,
        '2023-04-15',
        '86e9933b-7089-4a09-8c3d-86dc7b3175d5', -- Preceded by Die Hard 2
        '7e0ab380-8268-4a1b-a09b-19b29d051c2e', -- Followed by Live Free or Die Hard
        366.1 million,
        128,
        '1995-05-19',
        FALSE
    ),
    (
        '7e0ab380-8268-4a1b-a09b-19b29d051c2e',
        1,
        'Live Free or Die Hard',
        'John McClane faces a cyber-terrorist threat that could cripple the United States and brings him into a new era of action.',
        'English',
        'c14b6f06-83e3-492f-8c0b-7a8b1461d1bf',
        '20th Century Fox',
        'PG-13',
        false,
        '2023-05-15',
        '55c7914b-86bf-43a5-9a67-77d3df47f9c3', -- Preceded by Die Hard with a Vengeance
        '0da847d9-3c29-452e-b0d7-86dc7b3175d5', -- Followed by A Good Day to Die Hard
        383.5 million,
        128,
        '2007-06-27',
        FALSE
    ),
    (
        '0da847d9-3c29-452e-b0d7-86dc7b3175d5',
        1,
        'A Good Day to Die Hard',
        'John McClane travels to Russia to help his estranged son, who is caught up in a nuclear weapons heist.',
        'English',
        'c14b6f06-83e3-492f-8c0b-7a8b1461d1bf',
        '20th Century Fox',
        'R',
        false,
        '2023-06-15',
        '7e0ab380-8268-4a1b-a09b-19b29d051c2e', -- Preceded by Live Free or Die Hard
        NULL, -- No sequel planned for A Good Day to Die Hard
        304.7 million,
        98,
        '2013-02-14',
        FALSE
    );

--Rush Hour
INSERT INTO film (
    id,
    FILM_TYPE,
    TITLE,
    SYNOPSIS,
    ORIGINAL_LANGUAGE,
    SAGA_ID,
    DISTRIBUTOR,
    SUITABLE_FOR,
    COOMING_SOON,
    STREAMING_RELEASE_DATE,
    PREQUEL_ID,
    SEQUEL_ID,
    BOX_OFFICE,
    RUNTIME,
    THEATERS_RELEASE_DATE,
    AT_THEATERS
)
VALUES
    (
        '76e7f7d5-6db4-4a32-b0c3-549b84d4b019',
        1,
        'Rush Hour',
        "Detective Inspector Lee and Detective James Carter team up to rescue a kidnapped Chinese consul's daughter in Los Angeles.",
        'English',
        'c5d3d05f-43f2-4c5a-9a63-7a8b1461d1bf',
        'New Line Cinema',
        'PG-13',
        false,
        '2023-02-15',
        NULL, -- No prequel for Rush Hour
        '5d22c4d1-af04-4ff5-81bf-86dc7b3175d5', -- Followed by Rush Hour 2
        244.4 million,
        98,
        '1998-09-18',
        FALSE
    ),
    (
        '5d22c4d1-af04-4ff5-81bf-86dc7b3175d5',
        1,
        'Rush Hour 2',
        'Lee and Carter travel to Hong Kong to stop a counterfeit money scam and unravel a conspiracy involving the Triads.',
        'English',
        'c5d3d05f-43f2-4c5a-9a63-7a8b1461d1bf',
        'New Line Cinema',
        'PG-13',
        false,
        '2023-03-15',
        '76e7f7d5-6db4-4a32-b0c3-549b84d4b019', -- Preceded by Rush Hour
        '72f35b15-ff76-4971-9f87-77d3df47f9c3', -- Followed by Rush Hour 3
        347.3 million,
        90,
        '2001-08-03',
        FALSE
    ),
    (
        '72f35b15-ff76-4971-9f87-77d3df47f9c3',
        1,
        'Rush Hour 3',
        'Lee and Carter investigate an assassination attempt on the Chinese ambassador, leading them to a dangerous criminal organization.',
        'English',
        'c5d3d05f-43f2-4c5a-9a63-7a8b1461d1bf',
        'New Line Cinema',
        'PG-13',
        false,
        '2023-04-15',
        '5d22c4d1-af04-4ff5-81bf-86dc7b3175d5', -- Preceded by Rush Hour 2
        NULL, -- No sequel planned for Rush Hour 3
        258.2 million,
        91,
        '2007-08-10',
        FALSE
    );

--Bring It On
INSERT INTO film (
    id,
    FILM_TYPE,
    TITLE,
    SYNOPSIS,
    ORIGINAL_LANGUAGE,
    SAGA_ID,
    DISTRIBUTOR,
    SUITABLE_FOR,
    COOMING_SOON,
    STREAMING_RELEASE_DATE,
    PREQUEL_ID,
    SEQUEL_ID,
    BOX_OFFICE,
    RUNTIME,
    THEATERS_RELEASE_DATE,
    AT_THEATERS
)
VALUES
    (
        'a3e2b597-7d4a-414e-af7f-549b84d4b019',
        1,
        'Bring It On',
        "A high school cheerleading captain discovers her team's routines were stolen from an inner-city squad and seeks redemption.",
        'English',
        'ebc6b8f3-79e4-4e88-bc35-7a8b1461d1bf',
        'Universal Pictures',
        'PG-13',
        false,
        '2023-02-15',
        NULL, -- No prequel for Bring It On
        'c96b4164-666b-4fc4-9e1f-86dc7b3175d5', -- Followed by Bring It On Again
        90.5 million,
        98,
        '2000-08-25',
        FALSE
    ),
    (
        'c96b4164-666b-4fc4-9e1f-86dc7b3175d5',
        1,
        'Bring It On Again',
        'New captain Whittier and her friends form a cheerleading squad to compete in college, facing new challenges and rivalries.',
        'English',
        'ebc6b8f3-79e4-4e88-bc35-7a8b1461d1bf',
        'Universal Pictures',
        'PG-13',
        false,
        '2023-03-15',
        'a3e2b597-7d4a-414e-af7f-549b84d4b019', -- Preceded by Bring It On
        'd8a7f0c5-b0d1-4d67-9d53-77d3df47f9c3', -- Followed by Bring It On: All or Nothing
        63.5 million,
        90,
        '2004-01-13',
        FALSE
    ),
    (
        'd8a7f0c5-b0d1-4d67-9d53-77d3df47f9c3',
        1,
        'Bring It On: All or Nothing',
        "A transfer student joins a cheerleading squad to take down her former school's captain in a national competition.",
        'English',
        'ebc6b8f3-79e4-4e88-bc35-7a8b1461d1bf',
        'Universal Studios Home Entertainment',
        'PG-13',
        false,
        '2023-04-15',
        'c96b4164-666b-4fc4-9e1f-86dc7b3175d5', -- Preceded by Bring It On Again
        NULL, -- No sequel planned for Bring It On: All or Nothing
        17.2 million,
        99,
        '2006-08-08',
        FALSE
    );

--Alien
INSERT INTO film (
    id,
    FILM_TYPE,
    TITLE,
    SYNOPSIS,
    ORIGINAL_LANGUAGE,
    SAGA_ID,
    DISTRIBUTOR,
    SUITABLE_FOR,
    COOMING_SOON,
    STREAMING_RELEASE_DATE,
    PREQUEL_ID,
    SEQUEL_ID,
    BOX_OFFICE,
    RUNTIME,
    THEATERS_RELEASE_DATE,
    AT_THEATERS
)
VALUES
    (
        'e17a30eb-baa1-4b42-9661-549b84d4b019',
        1,
        'Alien',
        'The crew of a commercial spaceship encounters a deadly extraterrestrial life form that stalks and kills them.',
        'English',
        '72b23d84-8c42-4fe6-98fb-7a8b1461d1bf',
        '20th Century Fox',
        'R',
        false,
        '2023-02-15',
        NULL, -- No prequel for Alien
        'b439e110-2a07-4c4b-8c86-86dc7b3175d5', -- Followed by Aliens
        104.9 million,
        117,
        '1979-05-25',
        FALSE
    ),
    (
        'b439e110-2a07-4c4b-8c86-86dc7b3175d5',
        1,
        'Aliens',
        'Ellen Ripley returns to the planet where her crew encountered the alien, this time with a squad of space marines.',
        'English',
        '72b23d84-8c42-4fe6-98fb-7a8b1461d1bf',
        '20th Century Fox',
        'R',
        false,
        '2023-03-15',
        'e17a30eb-baa1-4b42-9661-549b84d4b019', -- Preceded by Alien
        '7cda4f3e-9cf7-4072-8f1a-77d3df47f9c3', -- Followed by Alien³
        131.1 million,
        137,
        '1986-07-18',
        FALSE
    ),
    (
        '7cda4f3e-9cf7-4072-8f1a-77d3df47f9c3',
        1,
        'Alien³',
        'Ripley crash-lands on a prison planet and discovers that the alien has stowed away on her ship.',
        'English',
        '72b23d84-8c42-4fe6-98fb-7a8b1461d1bf',
        '20th Century Fox',
        'R',
        false,
        '2023-04-15',
        'b439e110-2a07-4c4b-8c86-86dc7b3175d5', -- Preceded by Aliens
        'ec1e1e48-bf0f-4c8a-84ec-19b29d051c2e', -- Followed by Alien: Resurrection
        159.8 million,
        114,
        '1992-05-22',
        FALSE
    ),
    (
        'ec1e1e48-bf0f-4c8a-84ec-19b29d051c2e',
        1,
        'Alien: Resurrection',
        'Ripley is cloned 200 years after her death, and the alien resurfaces on a military-run space station.',
        'English',
        '72b23d84-8c42-4fe6-98fb-7a8b1461d1bf',
        '20th Century Fox',
        'R',
        false,
        '2023-05-15',
        '7cda4f3e-9cf7-4072-8f1a-77d3df47f9c3', -- Preceded by Alien³
        NULL, -- No sequel planned for Alien: Resurrection
        161.4 million,
        109,
        '1997-11-26',
        FALSE
    );

--Star Trek
INSERT INTO film (
    id,
    FILM_TYPE,
    TITLE,
    SYNOPSIS,
    ORIGINAL_LANGUAGE,
    SAGA_ID,
    DISTRIBUTOR,
    SUITABLE_FOR,
    COOMING_SOON,
    STREAMING_RELEASE_DATE,
    PREQUEL_ID,
    SEQUEL_ID,
    BOX_OFFICE,
    RUNTIME,
    THEATERS_RELEASE_DATE,
    AT_THEATERS
)
VALUES
    (
        '3a2c343a-68db-42aa-9bd4-549b84d4b019',
        1,
        'Star Trek: The Motion Picture',
        'The crew of the Starship Enterprise investigates a powerful alien entity that threatens Earth.',
        'English',
        'f3a05731-c2cc-49f8-aa46-7a8b1461d1bf',
        'Paramount Pictures',
        'PG',
        false,
        '2023-02-15',
        NULL, -- No prequel for Star Trek: The Motion Picture
        'b26e4e15-2f86-4d15-abe4-86dc7b3175d5', -- Followed by Star Trek II: The Wrath of Khan
        139 million,
        132,
        '1979-12-07',
        FALSE
    ),
    (
        'b26e4e15-2f86-4d15-abe4-86dc7b3175d5',
        1,
        'Star Trek II: The Wrath of Khan',
        'Admiral Kirk and the crew of the Enterprise face off against an old adversary seeking revenge.',
        'English',
        'f3a05731-c2cc-49f8-aa46-7a8b1461d1bf',
        'Paramount Pictures',
        'PG',
        false,
        '2023-03-15',
        '3a2c343a-68db-42aa-9bd4-549b84d4b019', -- Preceded by Star Trek: The Motion Picture
        'b9ef9e52-15ae-46cd-bd24-77d3df47f9c3', -- Followed by Star Trek III: The Search for Spock
        97 million,
        113,
        '1982-06-04',
        FALSE
    ),
    (
        'b9ef9e52-15ae-46cd-bd24-77d3df47f9c3',
        1,
        'Star Trek III: The Search for Spock',
        'The crew of the Enterprise risks everything to bring Spock back to life and save their ship.',
        'English',
        'f3a05731-c2cc-49f8-aa46-7a8b1461d1bf',
        'Paramount Pictures',
        'PG',
        false,
        '2023-04-15',
        'b26e4e15-2f86-4d15-abe4-86dc7b3175d5', -- Preceded by Star Trek II: The Wrath of Khan
        'd6bb8b6d-36a4-4b24-a0eb-19b29d051c2e', -- Followed by Star Trek IV: The Voyage Home
        87 million,
        105,
        '1984-06-01',
        FALSE
    ),
    (
        'd6bb8b6d-36a4-4b24-a0eb-19b29d051c2e',
        1,
        'Star Trek IV: The Voyage Home',
        'The Enterprise crew travels back to 20th-century Earth to save the planet from an alien probe.',
        'English',
        'f3a05731-c2cc-49f8-aa46-7a8b1461d1bf',
        'Paramount Pictures',
        'PG',
        false,
        '2023-05-15',
        'b9ef9e52-15ae-46cd-bd24-77d3df47f9c3', -- Preceded by Star Trek III: The Search for Spock
        NULL, -- No sequel planned for Star Trek IV: The Voyage Home
        133 million,
        119,
        '1986-11-26',
        FALSE
    ) ;

--Planet of the Apes
INSERT INTO film (
    id,
    FILM_TYPE,
    TITLE,
    SYNOPSIS,
    ORIGINAL_LANGUAGE,
    SAGA_ID,
    DISTRIBUTOR,
    SUITABLE_FOR,
    COOMING_SOON,
    STREAMING_RELEASE_DATE,
    PREQUEL_ID,
    SEQUEL_ID,
    BOX_OFFICE,
    RUNTIME,
    THEATERS_RELEASE_DATE,
    AT_THEATERS
)
VALUES
    (
        'f7a9a1b3-ec1d-4df3-a0fe-549b84d4b019',
        1,
        'Planet of the Apes',
        'An astronaut crew crash-lands on a strange planet where evolved apes are the dominant species and humans are primitive.',
        'English',
        'a2e74f5f-2b7d-4bc0-8fc5-7a8b1461d1bf',
        '20th Century Fox',
        'G',
        false,
        '2023-02-15',
        NULL, -- No prequel for Planet of the Apes
        '8c535883-8f99-4c8a-8e9b-86dc7b3175d5', -- Followed by Beneath the Planet of the Apes
        32.6 million,
        112,
        '1968-04-03',
        FALSE
    ),
    (
        '8c535883-8f99-4c8a-8e9b-86dc7b3175d5',
        1,
        'Beneath the Planet of the Apes',
        'Astronauts discover a subterranean human race while trying to rescue a fellow astronaut on the ape-ruled planet.',
        'English',
        'a2e74f5f-2b7d-4bc0-8fc5-7a8b1461d1bf',
        '20th Century Fox',
        'G',
        false,
        '2023-03-15',
        'f7a9a1b3-ec1d-4df3-a0fe-549b84d4b019', -- Preceded by Planet of the Apes
        '6c5cf208-7c74-4212-ba2b-77d3df47f9c3', -- Followed by Escape from the Planet of the Apes
        19 million,
        95,
        '1970-05-26',
        FALSE
    ),
    (
        '6c5cf208-7c74-4212-ba2b-77d3df47f9c3',
        1,
        'Escape from the Planet of the Apes',
        'Two intelligent talking apes travel back in time to Earth, where they become celebrities and face unforeseen challenges.',
        'English',
        'a2e74f5f-2b7d-4bc0-8fc5-7a8b1461d1bf',
        '20th Century Fox',
        'G',
        false,
        '2023-04-15',
        '8c535883-8f99-4c8a-8e9b-86dc7b3175d5', -- Preceded by Beneath the Planet of the Apes
        '86a06649-2a4a-4e2e-93fc-19b29d051c2e', -- Followed by Conquest of the Planet of the Apes
        12.4 million,
        98,
        '1971-05-21',
        FALSE
    ),
    (
        '86a06649-2a4a-4e2e-93fc-19b29d051c2e',
        1,
        'Conquest of the Planet of the Apes',
        'Apes, led by Caesar, rebel against humans after being oppressed and enslaved for years.',
        'English',
        'a2e74f5f-2b7d-4bc0-8fc5-7a8b1461d1bf',
        '20th Century Fox',
        'PG',
        false,
        '2023-05-15',
        '6c5cf208-7c74-4212-ba2b-77d3df47f9c3', -- Preceded by Escape from the Planet of the Apes
        'bba13d54-9bd7-4f6b-b963-86dc7b3175d5', -- Followed by Battle for the Planet of the Apes
        9.7 million,
        88,
        '1972-06-30',
        FALSE
    ),
    (
        'bba13d54-9bd7-4f6b-b963-86dc7b3175d5',
        1,
        'Battle for the Planet of the Apes',
        'Caesar leads a fragile peace between apes and remaining humans, but conflict looms on the horizon.',
        'English',
        'a2e74f5f-2b7d-4bc0-8fc5-7a8b1461d1bf',
        '20th Century Fox',
        'G',
        false,
        '2023-06-15',
        '86a06649-2a4a-4e2e-93fc-19b29d051c2e', -- Preceded by Conquest of the Planet of the Apes
        NULL, -- No sequel planned for Battle for the Planet of the Apes
        8.8 million,
        93,
        '1973-06-15',
        FALSE
    );

--The Bourne
INSERT INTO film (
    id,
    FILM_TYPE,
    TITLE,
    SYNOPSIS,
    ORIGINAL_LANGUAGE,
    SAGA_ID,
    DISTRIBUTOR,
    SUITABLE_FOR,
    COOMING_SOON,
    STREAMING_RELEASE_DATE,
    PREQUEL_ID,
    SEQUEL_ID,
    BOX_OFFICE,
    RUNTIME,
    THEATERS_RELEASE_DATE,
    AT_THEATERS
)
VALUES
    (
        '5de7cbb2-2c65-4212-920e-549b84d4b019',
        1,
        'The Bourne Identity',
        'A man is found floating in the Mediterranean Sea with amnesia and must uncover his identity while being pursued by assassins.',
        'English',
        'c3ec2a69-35d4-4de7-a6b4-7a8b1461d1bf',
        'Universal Pictures',
        'PG-13',
        false,
        '2023-02-15',
        NULL, -- No prequel for The Bourne Identity
        '26f59b9c-1020-4da7-b8e8-86dc7b3175d5', -- Followed by The Bourne Supremacy
        214 million,
        119,
        '2002-06-14',
        FALSE
    ),
    (
        '26f59b9c-1020-4da7-b8e8-86dc7b3175d5',
        1,
        'The Bourne Supremacy',
        'Jason Bourne is framed for a CIA operation gone wrong, and he must clear his name while being hunted by both the agency and assassins.',
        'English',
        'c3ec2a69-35d4-4de7-a6b4-7a8b1461d1bf',
        'Universal Pictures',
        'PG-13',
        false,
        '2023-03-15',
        '5de7cbb2-2c65-4212-920e-86dc7b3175d5', -- Preceded by The Bourne Identity
        '748376f5-17ec-4a76-8d32-77d3df47f9c3', -- Followed by The Bourne Ultimatum
        290.7 million,
        108,
        '2004-07-23',
        FALSE
    ),
    (
        '748376f5-17ec-4a76-8d32-77d3df47f9c3',
        1,
        'The Bourne Ultimatum',
        'Jason Bourne continues to uncover his past and faces those responsible for turning him into a trained assassin.',
        'English',
        'c3ec2a69-35d4-4de7-a6b4-7a8b1461d1bf',
        'Universal Pictures',
        'PG-13',
        false,
        '2023-04-15',
        '26f59b9c-1020-4da7-b8e8-86dc7b3175d5', -- Preceded by The Bourne Supremacy
        '67c7868c-7b6c-4c67-ae71-19b29d051c2e', -- Followed by The Bourne Legacy
        442.8 million,
        115,
        '2007-08-03',
        FALSE
    ),
    (
        '67c7868c-7b6c-4c67-ae71-19b29d051c2e',
        1,
        'The Bourne Legacy',
        'A new operative, Aaron Cross, must deal with the consequences of Operation Outcome as he becomes a target.',
        'English',
        'c3ec2a69-35d4-4de7-a6b4-7a8b1461d1bf',
        'Universal Pictures',
        'PG-13',
        false,
        '2023-05-15',
        '748376f5-17ec-4a76-8d32-77d3df47f9c3', -- Preceded by The Bourne Ultimatum
        '7e4e3d92-7bc9-4655-b0b2-19b29d051c2e', -- Followed by Jason Bourne
        276.1 million,
        135,
        '2012-07-30',
        FALSE
    ),
    (
        '7e4e3d92-7bc9-4655-b0b2-19b29d051c2e',
        1,
        'Jason Bourne',
        'Jason Bourne returns to the world he left behind as he uncovers more hidden truths about his past.',
        'English',
        'c3ec2a69-35d4-4de7-a6b4-7a8b1461d1bf',
        'Universal Pictures',
        'PG-13',
        false,
        '2023-06-15',
        '67c7868c-7b6c-4c67-ae71-19b29d051c2e', -- Preceded by The Bourne Legacy
        NULL, -- No sequel planned for Jason Bourne
        415.5 million,
        123,
        '2016-07-29',
        FALSE
    );
--INSERT INTO film (id, FILM_TYPE, TITTLE, SYNOPSIS, ORIGINAL_LANGUAGE, DISTRIBUTOR, SUITABLE_FOR, STREAMING_RELEASE_DATE, PREQUEL_ID, SEQUEL_ID, BOX_OFFICE, RUNTIME, THEATERS_RELEASE_DATE, AT_THEATERS)
--VALUES
--    ('123e4567-e89b-12d3-a456-556642440001', '2', 'Serie 1', 'Synopsis 1', 'ENG', 'Distributor 1', 'PG-13', '2028-09-27', NULL, '223e4567-e89b-12d3-a456-556642440002',NULL,NULL,NULL,NULL),
--    ('223e4567-e89b-12d3-a456-556642440002', '2', 'Serie 2', 'Synopsis 2', 'FRE', 'Distributor 2', 'R', '2028-10-05', '123e4567-e89b-12d3-a456-556642440001', NULL,NULL,NULL,NULL,NULL),
--    ('323e4567-e89b-12d3-a456-556642440003', '2', 'Serie 3', 'Synopsis 3', 'ESP', 'Distributor 3', 'G', '2028-11-15', NULL, NULL,NULL,NULL,NULL,NULL),
--    ('423e4567-e89b-12d3-a456-556642440004', '2', 'Serie 4', 'Synopsis 4', 'GER', 'Distributor 4', 'PG', '2028-12-20', '323e4567-e89b-12d3-a456-556642440003', NULL,NULL,NULL,NULL,NULL),
--    ('523e4567-e89b-12d3-a456-556642440005', '2', 'Serie 5', 'Synopsis 5', 'ITA', 'Distributor 5', 'PG-13', '2024-01-10', NULL, '623e4567-e89b-12d3-a456-556642440006',NULL,NULL,NULL,NULL),
--    ('623e4567-e89b-12d3-a456-556642440006', '2', 'Serie 6', 'Synopsis 6', 'JPN', 'Distributor 6', 'R', '2024-02-18', NULL, '523e4567-e89b-12d3-a456-556642440005',NULL,NULL,NULL,NULL),
--    ('723e4567-e89b-12d3-a456-556642440007', '2', 'Serie 7', 'Synopsis 7', 'CHN', 'Distributor 7', 'G', '2024-03-25', '623e4567-e89b-12d3-a456-556642440006', '823e4567-e89b-12d3-a456-556642440008',NULL,NULL,NULL,NULL),
--    ('823e4567-e89b-12d3-a456-556642440008', '2', 'Serie 8', 'Synopsis 8', 'KOR', 'Distributor 8', 'PG', '2024-04-30', '723e4567-e89b-12d3-a456-556642440007', NULL,NULL,NULL,NULL,NULL),
--    ('923e4567-e89b-12d3-a456-556642440009', '2', 'Serie 9', 'Synopsis 9', 'RUS', 'Distributor 9', 'PG-13', '2024-05-10', NULL, '055b9e94-3e71-4c33-ba92-3d5afc9e353f',NULL,NULL,NULL,NULL),
--    ('055b9e94-3e71-4c33-ba92-3d5afc9e353f', '2', 'Serie 10', 'Synopsis 10', 'BRA', 'Distributor 10', 'R', '2024-06-05', '923e4567-e89b-12d3-a456-556642440009', NULL,NULL,NULL,NULL,NULL);
--
--INSERT INTO film (id, FILM_TYPE,TITTLE, SYNOPSIS, ORIGINAL_LANGUAGE, DISTRIBUTOR, SUITABLE_FOR, STREAMING_RELEASE_DATE, PREQUEL_ID, SEQUEL_ID, BOX_OFFICE, RUNTIME, THEATERS_RELEASE_DATE, AT_THEATERS, SAGA_ID) VALUES
--    ('1a7b4a82-4823-4d79-8c7c-5b7ea9cd9d01', '1', 'Movie 1', 'Synopsis 1', 'ENG', 'Distributor 1', 'PG-13', '2028-09-27', NULL,'7a7b4a82-4823-4d79-8c7c-5b7ea9cd9d07', '1000000', '120', '2028-10-05', TRUE, '1a7b4a82-4823-4d79-8c7c-5b7ea9cd9d01'),
--    ('10431aac-d368-4df8-addb-be5c0b8812fb', '1', 'Movie 2', 'Synopsis 2', 'FRE', 'Distributor 2', 'R', '2028-10-05', '1a7b4a82-4823-4d79-8c7c-5b7ea9cd9d01', NULL, '750000', '90', '2028-11-15', FALSE, '1a7b4a82-4823-4d79-8c7c-5b7ea9cd9d01'),
--    ('3a7b4a82-4823-4d79-8c7c-5b7ea9cd9d03', '1', 'Movie 3', 'Synopsis 3', 'ESP', 'Distributor 3', 'G', '2028-11-15', NULL, NULL, '500000', '105', '2028-12-20', TRUE, null),
--    ('4a7b4a82-4823-4d79-8c7c-5b7ea9cd9d04', '1', 'Movie 4', 'Synopsis 4', 'GER', 'Distributor 4', 'PG', '2028-12-20', '3a7b4a82-4823-4d79-8c7c-5b7ea9cd9d03', NULL, '850000', '135', '2024-01-10', TRUE, '1a7b4a82-4823-4d79-8c7c-5b7ea9cd9d01'),
--    ('5a7b4a82-4823-4d79-8c7c-5b7ea9cd9d05', '1', 'Movie 5', 'Synopsis 5', 'ITA', 'Distributor 5', 'PG-13', '2024-01-10', NULL, '6a7b4a82-4823-4d79-8c7c-5b7ea9cd9d06', '1200000', '180', '2024-02-18', FALSE, null),
--    ('6a7b4a82-4823-4d79-8c7c-5b7ea9cd9d06', '1', 'Movie 6', 'Synopsis 6', 'JPN', 'Distributor 6', 'R', '2024-02-18', NULL, '1a7b4a82-4823-4d79-8c7c-5b7ea9cd9d01', '650000', '95', '2024-03-25', TRUE, null),
--    ('7a7b4a82-4823-4d79-8c7c-5b7ea9cd9d07', '1', 'Movie 7', 'Synopsis 7', 'CHN', 'Distributor 7', 'PG-13', '2024-03-25', '6a7b4a82-4823-4d79-8c7c-5b7ea9cd9d06', NULL, '900000', '140', '2024-04-30', TRUE, null),
--    ('8a7b4a82-4823-4d79-8c7c-5b7ea9cd9d08', '1', 'Movie 8', 'Synopsis 8', 'KOR', 'Distributor 8', 'PG', '2024-04-30', '7a7b4a82-4823-4d79-8c7c-5b7ea9cd9d07', NULL, '550000', '105', '2024-05-10', FALSE, null),
--    ('9a7b4a82-4823-4d79-8c7c-5b7ea9cd9d09', '1', 'Movie 9', 'Synopsis 9', 'RUS', 'Distributor 9', 'PG-13', '2024-05-10', NULL, '863b6d8b-f19a-4bd2-99e2-67a473189e3c', '1100000', '115', '2024-06-05', TRUE, null),
--    ('863b6d8b-f19a-4bd2-99e2-67a473189e3c', '1', 'Movie 10', 'Synopsis 10', 'BRA', 'Distributor 10', 'R', '2024-06-05', '9a7b4a82-4823-4d79-8c7c-5b7ea9cd9d09', NULL, '800000', '160', '2024-07-15', TRUE, null);
--
--INSERT INTO staff(id, biography, birthday, birth_place, first_name, last_name)
--VALUES
--    ('8c137b7c-f69e-4b4e-8308-e8b787720b6e', 'Sample biography 1', '1990-05-15', 'Sample Place 1', 'John', 'Doe'),
--    ('3a05a600-416c-4b10-b050-e408f10e1c93', 'Sample biography 2', '1985-08-22', 'Sample Place 2', 'Jane', 'Smith'),
--    ('3a0b5202-c980-41cd-b20e-deadf8ba3229', 'Sample biography 3', '1995-03-10', 'Sample Place 3', 'David', 'Johnson'),
--    ('05331795-d1de-4000-a9e9-73e91dac98b4', 'Sample biography 4', '1980-12-03', 'Sample Place 4', 'Alice', 'Brown'),
--    ('b1ea82fa-3b0e-4e7c-8719-c27aaaac8f54', 'Sample biography 5', '1998-07-28', 'Sample Place 5', 'Michael', 'Wilson');
--
--INSERT INTO social (id, name) VALUES
--    ('5a32b1b3-9e91-4354-9bb9-ce2f7f84beb6', 'Twitter'),
--    ('f6e264e3-d1fd-49eb-b0b1-d032b648749f', 'Facebook'),
--    ('c85cdab6-d449-49eb-96e8-206854e86925', 'Instagram'),
--    ('56445d2a-c493-4e0a-9bdc-571b9960d54f', 'TikTok'),
--    ('16c3633d-0481-4be6-815d-0ee2d641339f', 'Youtube'),
--    ('49631bb2-bcd4-4de7-8c42-bdc8eda69170', 'Snapchat');
--
--INSERT INTO social_staff(id, url, social_id, entity_id) VALUES
--    ('4636c464-7955-4f0c-8d9c-b2b69e86c99e','https://www.twitch.tv/Youtube','16c3633d-0481-4be6-815d-0ee2d641339f','8c137b7c-f69e-4b4e-8308-e8b787720b6e'),
--    ('34c40978-97cb-4943-a317-be672db1574d','https://www.twitch.tv/twitter','5a32b1b3-9e91-4354-9bb9-ce2f7f84beb6','8c137b7c-f69e-4b4e-8308-e8b787720b6e'),
--    ('32a25f4d-076f-4ec0-a248-134f067130fa','https://www.twitch.tv/nstagram','c85cdab6-d449-49eb-96e8-206854e86925','05331795-d1de-4000-a9e9-73e91dac98b4');
--
--INSERT INTO social_user(id, url, social_id, entity_id) VALUES
--    ('48061921-4c04-424a-a239-3e37164285d5','https://www.twitch.tv/tiktok','56445d2a-c493-4e0a-9bdc-571b9960d54f','b7a61937-6f59-4bbb-80a7-08d65d1ad656'),
--    ('96806207-8ed7-4767-baaf-efe50eaead7a','https://www.twitch.tv/snapchat','49631bb2-bcd4-4de7-8c42-bdc8eda69170','b7a61937-6f59-4bbb-80a7-08d65d1ad656'),
--    ('a4122962-5306-436d-833d-7c57f77bb348','https://www.twitch.tv/facebook','f6e264e3-d1fd-49eb-b0b1-d032b648749f','b7a61937-6f59-4bbb-80a7-08d65d1ad656');
--
--INSERT INTO film_staff(id, appear_as, role, film_id, staff_id) VALUES
--    ('432d5b2e-dfb4-481c-8c02-3249f7537940','extra 1','extra','1a7b4a82-4823-4d79-8c7c-5b7ea9cd9d01','8c137b7c-f69e-4b4e-8308-e8b787720b6e'),
--    ('8d55aeba-aef8-4426-be61-fc6de9030193','','director','1a7b4a82-4823-4d79-8c7c-5b7ea9cd9d01','3a05a600-416c-4b10-b050-e408f10e1c93'),
--    ('72a81c30-9766-4234-968c-efc194526b13','main character','actor','1a7b4a82-4823-4d79-8c7c-5b7ea9cd9d01','3a0b5202-c980-41cd-b20e-deadf8ba3229');
--
--INSERT INTO rating(id, rating, super_rating, film_id, user_id) VALUES
--    ('79302784-2f46-4aad-abba-43ad49bd3d1a','98',TRUE,'1a7b4a82-4823-4d79-8c7c-5b7ea9cd9d01','b7a61937-6f59-4bbb-80a7-08d65d1ad656'),
--    ('413b6ea7-2ae3-41e8-b26f-010bef1809ee','90',TRUE,'423e4567-e89b-12d3-a456-556642440004','b7a61937-6f59-4bbb-80a7-08d65d1ad656'),
--    ('19a67d4e-cfc5-4e37-b395-978745859128','60',TRUE,'9a7b4a82-4823-4d79-8c7c-5b7ea9cd9d09','b7a61937-6f59-4bbb-80a7-08d65d1ad656'),
--    ('092217a2-7559-4933-b8c1-35b9ba1de95d','100',FALSE,'1a7b4a82-4823-4d79-8c7c-5b7ea9cd9d01','1e61da98-e8d9-4e82-b2a0-bc53b124aef1'),
--    ('052533f4-d50d-4dc8-901b-7426698b0859','72',FALSE,'1a7b4a82-4823-4d79-8c7c-5b7ea9cd9d01','2ae12264-977d-419d-aa19-ce9658041fe4'),
--    ('661548dc-1cfe-48e9-a19e-8df315e10189','35',FALSE,'9a7b4a82-4823-4d79-8c7c-5b7ea9cd9d09','2ae12264-977d-419d-aa19-ce9658041fe4');
--
--INSERT INTO stream(id, name, price) VALUES
--    ('7b0c02cc-efaa-4d9b-8619-8babb56e7b40','Netflix','99'),
--    ('888360fc-ea1f-42cd-b51e-16ad39bc47bb','Hulu','50'),
--    ('a7c2b80f-8bfa-43ee-89d9-d781f281d14b','Amazon Prime Vide','100'),
--    ('58090783-9f69-46b2-b931-f91b11973121','Disney+','120');
--
--INSERT INTO stream_film(id, buy, rent, url, film_id, stream_id) VALUES
--    ('5b344dbe-082c-47bf-8dd4-4bb6415e22f8', TRUE, FALSE, 'http://netflix.com/movie5','10431aac-d368-4df8-addb-be5c0b8812fb','7b0c02cc-efaa-4d9b-8619-8babb56e7b40'),
--    ('143bf786-f1be-40ff-9b55-77f747abc920', TRUE, FALSE, 'http://netflix.com/movie6','7a7b4a82-4823-4d79-8c7c-5b7ea9cd9d07','7b0c02cc-efaa-4d9b-8619-8babb56e7b40'),
--    ('9463d673-4cf6-487f-80f8-ed882afbb3fc', FALSE, TRUE, 'http://hulu.com/movie1','1a7b4a82-4823-4d79-8c7c-5b7ea9cd9d01','888360fc-ea1f-42cd-b51e-16ad39bc47bb'),
--    ('4bc0eb01-fa0f-4768-b9d2-9777ba8415b5', FALSE, FALSE, 'http://netflix.com/movie1','1a7b4a82-4823-4d79-8c7c-5b7ea9cd9d01','7b0c02cc-efaa-4d9b-8619-8babb56e7b40'),
--    ('c73658b2-f09c-46b3-b81d-da4b4ca2c570', TRUE, TRUE, 'http://primeVideo.com/movie1','1a7b4a82-4823-4d79-8c7c-5b7ea9cd9d01','a7c2b80f-8bfa-43ee-89d9-d781f281d14b');
--
--INSERT INTO genre(id, genre) VALUES
--    ('4ba05e0c-43d7-45b1-943f-d3a8b863dec1', 'Action'),
--    ('dbe4b00f-7817-44aa-9942-bf05da8fb84f', 'Adventure'),
--    ('655ce3a7-2c2a-4bd0-8b0a-002119422b82', 'Animation'),
--    ('acbcd5e3-3ee0-490b-8bb3-aa324d342ed5', 'Anime'),
--    ('9b243158-2f21-428f-aab1-2c3e83fd086d', 'Comedy'),
--    ('991a8129-4c2d-4afa-8bb9-104fd745b8c6', 'Crime'),
--    ('036ace82-a0e5-44ff-9a66-5b68b1027062', 'Documentary'),
--    ('8538728a-c957-4435-91d0-8ccaf6223ca6', 'Drama'),
--    ('fc7b3614-270d-49e1-af3e-b5e08779f4a0', 'Entretainment'),
--    ('98e8983f-63fc-4c5e-b1fb-138d635c7f8b', 'Fantasy'),
--    ('1a37e291-cae8-4cc6-8532-548ae92f2ad3', 'Horror'),
--    ('60dce741-c75a-4f02-a36a-a1ba1d2d370c', 'History'),
--    ('48faa47e-2765-4a30-b1d8-bc847c78fd56', 'News'),
--    ('66a64410-6c10-4fb5-9d5c-58f70ff367a9', 'Sci-fi'),
--    ('0753869f-56a3-4cfc-a541-3ba07a443166', 'Romance'),
--    ('a3dfd418-26d1-4ff2-ac86-614c90e99ba7', 'Sports'),
--    ('bf6d309b-6340-4179-b04e-9231ca9020e9', 'Stand up'),
--    ('6b5604cc-f9a8-4183-90c1-d10b46e2f9a4', 'War');
--
--INSERT INTO genre_film(id, film_id, genre_id) VALUES
--    ('f7be3075-d09e-4588-a67c-113dddfa4785', '1a7b4a82-4823-4d79-8c7c-5b7ea9cd9d01', '4ba05e0c-43d7-45b1-943f-d3a8b863dec1'),
--    ('6edc4050-2d82-44c8-b4b0-d0369a9022ca', '1a7b4a82-4823-4d79-8c7c-5b7ea9cd9d01', 'dbe4b00f-7817-44aa-9942-bf05da8fb84f'),
--    ('0ca978c0-e819-4ddd-8a3f-66c2792a3f87', '1a7b4a82-4823-4d79-8c7c-5b7ea9cd9d01', '991a8129-4c2d-4afa-8bb9-104fd745b8c6'),
--    ('4634f045-9451-489a-b2e0-db03b78d378a', '1a7b4a82-4823-4d79-8c7c-5b7ea9cd9d01', '66a64410-6c10-4fb5-9d5c-58f70ff367a9'),
--    ('1347e498-052d-462f-ad75-8cc74d4ed7a3', '10431aac-d368-4df8-addb-be5c0b8812fb', 'fc7b3614-270d-49e1-af3e-b5e08779f4a0'),
--    ('e1e97375-4a61-4b5c-b82f-acb2cef1c3fb', '10431aac-d368-4df8-addb-be5c0b8812fb', 'bf6d309b-6340-4179-b04e-9231ca9020e9'),
--    ('f8f5ee6e-8294-4a74-9319-9386c1dcb11a', '10431aac-d368-4df8-addb-be5c0b8812fb', '9b243158-2f21-428f-aab1-2c3e83fd086d'),
--    ('fc1d98c2-cb0f-46c2-9cb8-708f30c0f430', '3a7b4a82-4823-4d79-8c7c-5b7ea9cd9d03', '0753869f-56a3-4cfc-a541-3ba07a443166'),
--    ('3deada4e-2d85-4d4b-a2e8-211cf2d6cbdb', '3a7b4a82-4823-4d79-8c7c-5b7ea9cd9d03', '60dce741-c75a-4f02-a36a-a1ba1d2d370c'),
--    ('a30b66ac-2446-4604-a374-3aabccfc0f00', '3a7b4a82-4823-4d79-8c7c-5b7ea9cd9d03', '036ace82-a0e5-44ff-9a66-5b68b1027062'),
--    ('ddfc6e50-79a8-4537-87b9-b7fea45a9c7e', '123e4567-e89b-12d3-a456-556642440001', 'acbcd5e3-3ee0-490b-8bb3-aa324d342ed5'),
--    ('3227b5c5-8d06-4980-b575-436e11148f17', '123e4567-e89b-12d3-a456-556642440001', '655ce3a7-2c2a-4bd0-8b0a-002119422b82'),
--    ('ab5adde6-b0bb-41fe-a97b-49f1a1d0e862', '123e4567-e89b-12d3-a456-556642440001', '98e8983f-63fc-4c5e-b1fb-138d635c7f8b'),
--    ('94cc00b5-2071-4f49-9041-a51be180fdbb', '7a7b4a82-4823-4d79-8c7c-5b7ea9cd9d07', 'dbe4b00f-7817-44aa-9942-bf05da8fb84f');
--
--INSERT INTO video(id, file_path, name) VALUES
--    ('3a662730-eb02-4d41-be85-9b46ae6613c4','/path/to/video','video1');
--
--INSERT INTO image(id, created_at, file_path, size, image_type, owner_type, owner_id) VALUES
--    ('4894c62c-0f28-40d9-a886-f828953d7c44','2028-11-02 13:48:22','/home/cophos/spring-workspace/tooren_romaros/api/src/main/resources/media/tokyoDriftMainImag.jpg','desktop','filmMainImage','M','863b6d8b-f19a-4bd2-99e2-67a473189e3c'),
--    ('b3d3d65a-12b6-4ea7-8deb-d073ef1a0396','2028-11-02 13:48:22','/home/cophos/spring-workspace/tooren_romaros/api/src/main/resources/media/richTextImage1.jpg','desktop','richText','RT','35019f7b-db70-403f-a1cc-ac2f4bb8aae4'),
--    ('76e9e54c-1ef3-4380-b5eb-63acb7a85883','2028-11-02 13:48:22','/home/cophos/spring-workspace/tooren_romaros/api/src/main/resources/media/richTextImage2.jpg','desktop','richText','RT','35019f7b-db70-403f-a1cc-ac2f4bb8aae4'),
--    ('92c1c7a0-bd83-4646-acf0-afa0d4231d2f','2028-11-02 13:48:22','/home/cophos/spring-workspace/tooren_romaros/api/src/main/resources/media/richTextMain.jpg','desktop','richTextMainImage','RT','35019f7b-db70-403f-a1cc-ac2f4bb8aae4'),
--    ('0669bb03-c882-48cf-baec-2cc83c1eb221','2028-11-02 13:48:22','/home/cophos/spring-workspace/tooren_romaros/api/src/main/resources/media/thumbail.jpg','desktop','videoThumbail','V','3a662730-eb02-4d41-be85-9b46ae6613c4'),
--    ('69528eb9-1eab-4c18-822c-de216b77759a','2028-11-02 13:48:22','/home/cophos/spring-workspace/tooren_romaros/api/src/main/resources/media/tokyoDriftImage1.jpg','desktop','film','M','863b6d8b-f19a-4bd2-99e2-67a473189e3c'),
--    ('dc887fa6-113d-4590-8376-4b7dddc8216b','2028-11-02 13:48:22','/home/cophos/spring-workspace/tooren_romaros/api/src/main/resources/media/tokyoDriftImage2.jpg','desktop','film','M','863b6d8b-f19a-4bd2-99e2-67a473189e3c');
--
--INSERT INTO comment(id, body, like_count, publication_datetime, reported, film_id, user_id) VALUES
--    ('f4b6c133-03f5-494a-ac43-7bb8fecd9fa4','Body 1','0','2028-11-07T23:44:42.452775','0','10431aac-d368-4df8-addb-be5c0b8812fb','6f95b5af-4d6f-448c-8f3d-ca54521f4653'),
--    ('cd310ab9-a08f-40b3-8fc4-7c74ca4589af','Body 2','8','2028-11-07T23:44:42.452775','0','10431aac-d368-4df8-addb-be5c0b8812fb','b7a61937-6f59-4bbb-80a7-08d65d1ad656'),
--    ('52d9d29f-842c-4cbd-a2eb-44ffc7604b81','Body 3','2','2028-11-07T23:44:42.452775','0','1a7b4a82-4823-4d79-8c7c-5b7ea9cd9d01','b7a61937-6f59-4bbb-80a7-08d65d1ad656'),
--    ('11a5978c-85c9-4508-86e3-b3290873023e','Body 4','4','2028-11-07T23:44:42.452775','0','423e4567-e89b-12d3-a456-556642440004','b7a61937-6f59-4bbb-80a7-08d65d1ad656'),
--    ('6ded2312-edeb-4740-ac87-5425f40e12ab','Body 5','5','2028-11-07T23:44:42.452775','0','423e4567-e89b-12d3-a456-556642440004','b5d35e6e-7404-4fc0-9bc5-a265e9fca71b'),
--    ('9d588869-25eb-466b-b5fd-e5e480523ab8','Body 6','3','2028-11-07T23:44:42.452775','1','10431aac-d368-4df8-addb-be5c0b8812fb','2ae12264-977d-419d-aa19-ce9658041fe4');
--
--INSERT INTO episode (id, streaming_release_date, run_time, tittle, serie_id) VALUES
--    ('738ad70d-155a-493e-bd32-78664f87b0bc', '2028-10-15', '45 minutes', 'Episode 10', '223e4567-e89b-12d3-a456-556642440002'),
--    ('c4ddff8d-db85-4ed0-a5d9-dbade606aa85', '2028-10-22', '50 minutes', 'Episode 20', '223e4567-e89b-12d3-a456-556642440002');
--
--INSERT INTO episode (id, streaming_release_date, run_time, tittle, serie_id) VALUES
--    ('5a7b4a82-4823-4d79-8c7c-5b7ea9cd9d05', '2028-10-15', '45 minutes', 'Episode 1', '6a7b4a82-4823-4d79-8c7c-5b7ea9cd9d06'),
--    ('6a7b4a82-4823-4d79-8c7c-5b7ea9cd9d06', '2028-10-22', '50 minutes', 'Episode 2', '5a7b4a82-4823-4d79-8c7c-5b7ea9cd9d05');
--
--INSERT INTO episode (id, streaming_release_date, run_time, tittle, serie_id)
--VALUES
--    ('1a7b4a82-4823-4d79-8c7c-5b7ea9cd9d01', '2028-11-05', '45 minutes', 'Episode 1', '2a7b4a82-4823-4d79-8c7c-5b7ea9cd9d02'),
--    ('2a7b4a82-4823-4d79-8c7c-5b7ea9cd9d02', '2028-11-12', '50 minutes', 'Episode 2', '2a7b4a82-4823-4d79-8c7c-5b7ea9cd9d02');
--
--INSERT INTO saga (id, name) VALUES
--    ('1a7b4a82-4823-4d79-8c7c-5b7ea9cd9d01', 'Action Saga 1');
--
---- Sample data for the "comment" table
--INSERT INTO comment (id, body, like_count, publication_datetime, reported, film_id, user_id)
--VALUES
--    ('1a7b4a82-4823-4d79-8c7c-5b7ea9cd9d01', 'Great movie!', '10', '2028-10-15 14:30:00', FALSE, '2a7b4a82-4823-4d79-8c7c-5b7ea9cd9d02', '3a7b4a82-4823-4d79-8c7c-5b7ea9cd9d03'),
--    ('2a7b4a82-4823-4d79-8c7c-5b7ea9cd9d02', 'Enjoyed it!', '5', '2028-10-15 15:45:00', FALSE, '2a7b4a82-4823-4d79-8c7c-5b7ea9cd9d02', '4a7b4a82-4823-4d79-8c7c-5b7ea9cd9d04'),
--    ('3a7b4a82-4823-4d79-8c7c-5b7ea9cd9d03', 'Good storyline', '8', '2028-10-15 16:20:00', FALSE, '5a7b4a82-4823-4d79-8c7c-5b7ea9cd9d05', '6a7b4a82-4823-4d79-8c7c-5b7ea9cd9d06');
--
--INSERT INTO comment (id, body, like_count, publication_datetime, reported, film_id, user_id) VALUES
--    ('ee5bcc65-0ca1-4e3b-a7b4-7caf24e39827', 'This is a comment.', 10, '2028-10-15 08:30:00', 0, NULL, '2a7b4a82-4823-4d79-8c7c-5b7ea9cd9d02'),
--    ('98cafaec-4a02-4fdd-8d42-601751e8cd32', 'Another comment here.', 5, '2028-10-15 09:15:00', 1, '3a7b4a82-4823-4d79-8c7c-5b7ea9cd9d03', '1a7b4a82-4823-4d79-8c7c-5b7ea9cd9d01');
--
--INSERT INTO discuss (id, body, like_count, publication_datetime, reported, post_id, user_id) VALUES
--    ('3a7b4a82-4823-4d79-8c7c-5b7ea9cd9d03', 'Discussion topic.', 15, '2028-10-15 10:45:00', 0, NULL, '4a7b4a82-4823-4d79-8c7c-5b7ea9cd9d04'),
--    ('49cb02ba-9a1b-45ab-85d3-9a04f3a3e053', 'Discussing something important.', 8, '2028-10-15 12:00:00', 0, NULL, '3a7b4a82-4823-4d79-8c7c-5b7ea9cd9d03');
--
--INSERT INTO discuss (id, body, like_count, publication_datetime, reported, post_id, user_id)
--VALUES
--    ('4a7b4a82-4823-4d79-8c7c-5b7ea9cd9d04', 'I have some questions', '2', '2028-10-16 10:15:00', FALSE, '1a7b4a82-4823-4d79-8c7c-5b7ea9cd9d01', '3a7b4a82-4823-4d79-8c7c-5b7ea9cd9d03'),
--    ('5a7b4a82-4823-4d79-8c7c-5b7ea9cd9d05', 'Let\'s discuss this!', '4', '2028-10-16 11:30:00', FALSE, '2a7b4a82-4823-4d79-8c7c-5b7ea9cd9d02', '4a7b4a82-4823-4d79-8c7c-5b7ea9cd9d04');
--
---- Sample data for the "film" table
--INSERT INTO film (film_type, id, average_super_rating, average_user_rating, cooming_soon, distributor, original_language, streaming_release_date, suitable_for, synopsis, tittle, at_theaters, box_office, runtime, theaters_release_date, season_number, saga_id)
--VALUES
--    (1, 'c6ca9b13-71e5-4c13-b612-692a890b36d1', 8.5, 7.9, '2028-11-15', 'Universal Pictures', 'ENG', '2028-11-20', 'PG-13', 'A thrilling action movie', 'Action Movie 1', TRUE, '10000000', '120', '2028-11-25', NULL, '2a7b4a82-4823-4d79-8c7c-5b7ea9cd9d02'),
--    (2, '2a7b4a82-4823-4d79-8c7c-5b7ea9cd9d02', 7.8, 7.2, '2028-12-05', 'Warner Bros.', 'FRE', '2028-12-10', 'R', 'A suspenseful thriller', 'Thriller Movie 1', TRUE, '8000000', '110', '2028-12-15', NULL, '3a7b4a82-4823-4d79-8c7c-5b7ea9cd9d03');
--
---- Sample data for the "film_staff" table
--INSERT INTO film_staff (id, appear_as, role, film_id, staff_id)
--VALUES
--    ('1a7b4a82-4823-4d79-8c7c-5b7ea9cd9d01', 'John Doe', 'Director', '1a7b4a82-4823-4d79-8c7c-5b7ea9cd9d01', '4a7b4a82-4823-4d79-8c7c-5b7ea9cd9d04'),
--    ('2a7b4a82-4823-4d79-8c7c-5b7ea9cd9d02', 'Jane Smith', 'Producer', '1a7b4a82-4823-4d79-8c7c-5b7ea9cd9d01', '5a7b4a82-4823-4d79-8c7c-5b7ea9cd9d05');
--
---- Sample data for the "genre" table
--INSERT INTO genre (id, genre)
--VALUES
--    ('1a7b4a82-4823-4d79-8c7c-5b7ea9cd9d01', 'Action'),
--    ('2a7b4a82-4823-4d79-8c7c-5b7ea9cd9d02', 'Thriller');
--
---- Sample data for the "genre_film" table
--INSERT INTO genre_film (id, film_id, genre_id)
--VALUES
--    ('1a7b4a82-4823-4d79-8c7c-5b7ea9cd9d01', '1a7b4a82-4823-4d79-8c7c-5b7ea9cd9d01', '1a7b4a82-4823-4d79-8c7c-5b7ea9cd9d01'),
--    ('2a7b4a82-4823-4d79-8c7c-5b7ea9cd9d02', '2a7b4a82-4823-4d79-8c7c-5b7ea9cd9d02', '2a7b4a82-4823-4d79-8c7c-5b7ea9cd9d02');
--
---- Sample data for the "post" table
--INSERT INTO post (id, content, like_count, publication_datetime, synthesis, tittle, user_id)
--VALUES
--    ('1a7b4a82-4823-4d79-8c7c-5b7ea9cd9d01', 'This is an interesting post about the movie.', '12', '2028-10-17 13:15:00', 'A discussion about the movie', 'Movie Discussion', '4a7b4a82-4823-4d79-8c7c-5b7ea9cd9d04'),
--    ('2a7b4a82-4823-4d79-8c7c-5b7ea9cd9d02', 'Join the discussion!', '5', '2028-10-17 14:30:00', 'Let\'s talk about the film.', 'Film Talk', '5a7b4a82-4823-4d79-8c7c-5b7ea9cd9d05');
--
---- Sample data for the "rating" table
--INSERT INTO rating (id, rating, super_rating, film_id, user_id)
--VALUES
--    ('1a7b4a82-4823-4d79-8c7c-5b7ea9cd9d01', 8.0, TRUE, '1a7b4a82-4823-4d79-8c7c-5b7ea9cd9d01', '4a7b4a82-4823-4d79-8c7c-5b7ea9cd9d04'),
--    ('2a7b4a82-4823-4d79-8c7c-5b7ea9cd9d02', 7.5, FALSE, '2a7b4a82-4823-4d79-8c7c-5b7ea9cd9d02', '5a7b4a82-4823-4d79-8c7c-5b7ea9cd9d05');
set foreign_key_checks=1;

