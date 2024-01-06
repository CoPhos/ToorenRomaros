set foreign_key_checks=0;
--movies
--start wars
INSERT INTO film (
    id,
    FILM_TYPE,
    TITTLE,
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
        'EN',
        '98726d24-d2c0-4b69-9534-86dc7b3175d5',
        'Lucasfilm',
        'PG',
        null,
        '2023-02-15',
        NULL,
        '0e3a8915-c68c-46dd-aee2-98dbde4b4b14',
        "775000000",
        "121",
        '1977-05-25',
        FALSE
    ),
    (
        '0e3a8915-c68c-46dd-aee2-98dbde4b4b14',
        1,
        'Star Wars: Episode V - The Empire Strikes Back',
        'The saga continues...',
        'EN',
        '98726d24-d2c0-4b69-9534-86dc7b3175d5',
        'Lucasfilm',
        'PG',
        null,
        '2023-03-15',
        'e5cc7851-39a7-4342-aabf-ef8f72c7d648',
        'cd086f77-3009-4f62-8c7a-914bde6fbbf4',
        "538400000",
        "124",
        '1980-05-21',
        FALSE
    ),
    (
        'cd086f77-3009-4f62-8c7a-914bde6fbbf4',
        1,
        'Star Wars: Episode VI - Return of the Jedi',
        'The saga nears its end...',
        'EN',
        '98726d24-d2c0-4b69-9534-86dc7b3175d5',
        'Lucasfilm',
        'PG',
        null,
        '2023-04-15',
        '0e3a8915-c68c-46dd-aee2-98dbde4b4b14',
        'e80d4a56-52a7-4f52-a2f2-5b88bc79b5e2',
        "475100000",
        "131",
        '1983-05-25',
        FALSE
    ),
    (
        'e80d4a56-52a7-4f52-a2f2-5b88bc79b5e2',
        1,
        'Star Wars: Episode I - The Phantom Menace',
        'A long time ago...',
        'EN',
        '98726d24-d2c0-4b69-9534-86dc7b3175d5',
        '20th Century Fox',
        'PG',
        null,
        '2023-05-15',
        'cd086f77-3009-4f62-8c7a-914bde6fbbf4',
        '9637c4e3-288b-4d8b-b25c-4475e7aa5cda',
        "1027000000",
        "136",
        '1999-05-19',
        FALSE
    ),
    (
        '9637c4e3-288b-4d8b-b25c-4475e7aa5cda',
        1,
        'Star Wars: Episode II - Attack of the Clones',
        'The saga continues...',
        'EN',
        '98726d24-d2c0-4b69-9534-86dc7b3175d5',
        '20th Century Fox',
        'PG',
        null,
        '2023-06-15',
        'e80d4a56-52a7-4f52-a2f2-5b88bc79b5e2',
        'a45a2bb9-7e52-4284-8cfe-5b2f5f2b8c1d',
        "649400000",
        "142",
        '2002-05-16',
        FALSE
    ),
    (
        'a45a2bb9-7e52-4284-8cfe-5b2f5f2b8c1d',
        1,
        'Star Wars: Episode III - Revenge of the Sith',
        'The dark side emerges...',
        'EN',
        '98726d24-d2c0-4b69-9534-86dc7b3175d5',
        '20th Century Fox',
        'PG-13',
        null,
        '2023-07-15',
        '9637c4e3-288b-4d8b-b25c-4475e7aa5cda',
        'd26e4ab3-9dce-420c-8254-7a8b1461d1bf',
        "848800000",
        "140",
        '2005-05-19',
        FALSE
    ),
    (
        'd26e4ab3-9dce-420c-8254-7a8b1461d1bf',
        1,
        'Star Wars: Episode VII - The Force Awakens',
        'A new journey begins...',
        'EN',
        '98726d24-d2c0-4b69-9534-86dc7b3175d5',
        'Walt Disney Studios',
        'PG-13',
        null,
        '2023-08-15',
        'a45a2bb9-7e52-4284-8cfe-5b2f5f2b8c1d',
        'bf24f51c-6b56-4a04-ae5e-86d6b3d2eb74',
        "2068000000",
        "138",
        '2015-12-18',
        FALSE
    ),
    (
        'bf24f51c-6b56-4a04-ae5e-86d6b3d2eb74',
        1,
        'Star Wars: Episode VIII - The Last Jedi',
        'The saga continues...',
        'EN',
        '98726d24-d2c0-4b69-9534-86dc7b3175d5',
        'Walt Disney Studios',
        'PG-13',
        null,
        '2023-09-15',
        'd26e4ab3-9dce-420c-8254-7a8b1461d1bf',
        'f456ce87-d4a1-4c5f-98a7-e8100cfe4bd0',
        "1333000000",
        "152",
        '2017-12-15',
        FALSE
    ),
    (
        'f456ce87-d4a1-4c5f-98a7-e8100cfe4bd0',
        1,
        'Star Wars: Episode IX - The Rise of Skywalker',
        'The saga concludes...',
        'EN',
        '98726d24-d2c0-4b69-9534-86dc7b3175d5',
        'Walt Disney Studios',
        'PG-13',
        null,
        '2023-10-15',
        'bf24f51c-6b56-4a04-ae5e-86d6b3d2eb74',
        NULL,
        "1074000000",
        "142",
        '2019-12-20',
        FALSE
    );

--Pirates of the Caribbean
INSERT INTO film (
    id,
    FILM_TYPE,
    TITTLE,
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
        'EN',
        '983bdb60-3fe9-470f-b811-74ab692fcb47',
        'Walt Disney Pictures',
        'PG-13',
        null,
        '2023-02-15',
        NULL,
        'af9a78e1-e999-4c47-9cf4-4601627f0648',
        "654300000",
        "143",
        '2003-07-09',
        FALSE
    ),
    (
        'af9a78e1-e999-4c47-9cf4-4601627f0648',
        1,
        "Pirates of the Caribbean: Dead Man's Chest",
        'Jack Sparrow owes a debt to Davy Jones...',
        'EN',
        '983bdb60-3fe9-470f-b811-74ab692fcb47',
        'Walt Disney Pictures',
        'PG-13',
        null,
        '2023-03-15',
        'f4b3d4e2-2f3d-4a13-8f2c-729b26e964c5',
        'bd6929a2-c6c5-452b-8e8c-9b9b2ad89321',
        "1068000000",
        "151",
        '2006-07-07',
        FALSE
    ),
    (
        'bd6929a2-c6c5-452b-8e8c-9b9b2ad89321',
        1,
        "Pirates of the Caribbean: At World's End",
        'The Brethren Court convenes to fight against Lord Cutler Beckett...',
        'EN',
        '983bdb60-3fe9-470f-b811-74ab692fcb47',
        'Walt Disney Pictures',
        'PG-13',
        null,
        '2023-04-15',
        'af9a78e1-e999-4c47-9cf4-4601627f0648',
        'e6d90526-08b3-47c1-a01d-2f9b48c94a9c',
        "963400000",
        "169",
        '2007-05-24',
        FALSE
    ),
    (
        'e6d90526-08b3-47c1-a01d-2f9b48c94a9c',
        1,
        'Pirates of the Caribbean: On Stranger Tides',
        'Jack Sparrow searches for the Fountain of Youth...',
        'EN',
        '983bdb60-3fe9-470f-b811-74ab692fcb47',
        'Walt Disney Pictures',
        'PG-13',
        null,
        '2023-05-15',
        'bd6929a2-c6c5-452b-8e8c-9b9b2ad89321',
        'f49218c1-2c5d-4f6b-8182-2b3e55c85711',
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
        'EN',
        '983bdb60-3fe9-470f-b811-74ab692fcb47',
        'Walt Disney Pictures',
        'PG-13',
        null,
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
    TITTLE,
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
        "Harry Potter and the Sorcerer's Stone",
        'An orphaned boy discovers he is a wizard and attends Hogwarts School of Witchcraft and Wizardry.',
        'EN',
        '74366cba-fe10-4253-930f-8c5098babbc4',
        'Warner Bros. Pictures',
        'PG',
        null,
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
        'EN',
        '74366cba-fe10-4253-930f-8c5098babbc4',
        'Warner Bros. Pictures',
        'PG',
        null,
        '2023-03-15',
        '2f901ff3-968b-4e90-9db0-5e16843d1e16',
        'a57d328f-bc58-4bb5-b0db-9c6342a5b0a0',
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
        'EN',
        '74366cba-fe10-4253-930f-8c5098babbc4',
        'Warner Bros. Pictures',
        'PG',
        null,
        '2023-04-15',
        'ec28a46e-9852-4cb8-9b23-96c6d98e00d5',
        'c1e229e7-1705-4c3d-b6bf-c3da3f019d05',
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
        'EN',
        '74366cba-fe10-4253-930f-8c5098babbc4',
        'Warner Bros. Pictures',
        'PG-13',
        null,
        '2023-05-15',
        'a57d328f-bc58-4bb5-b0db-9c6342a5b0a0',
        'd6ff152f-2cb3-4082-8b14-f36d23cc3f77',
        896400000,
        157,
        '2005-11-18',
        FALSE
    ),
    (
        'd6ff152f-2cb3-4082-8b14-f36d23cc3f77',
        1,
        'Harry Potter and the Order of the Phoenix',
        "Harry and his friends form Dumbledore's Army to resist the dark forces.",
        'EN',
        '74366cba-fe10-4253-930f-8c5098babbc4',
        'Warner Bros. Pictures',
        'PG-13',
        null,
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
        "Harry learns more about Voldemort's past and the Horcruxes.",
        'EN',
        '74366cba-fe10-4253-930f-8c5098babbc4',
        'Warner Bros. Pictures',
        'PG',
        null,
        '2023-07-15',
        'd6ff152f-2cb3-4082-8b14-f36d23cc3f77',
        'f63285d1-eae0-4a5c-b0b9-54bf0bf3c40c',
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
        'EN',
        '74366cba-fe10-4253-930f-8c5098babbc4',
        'Warner Bros. Pictures',
        'PG-13',
        null,
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
        'EN',
        '74366cba-fe10-4253-930f-8c5098babbc4',
        'Warner Bros. Pictures',
        'PG-13',
        null,
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
    TITTLE,
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
        '642f36f2-4edd-43d2-9df8-810344d5e733',
        1,
        'The Lord of the Rings: The Fellowship of the Ring',
        'A young hobbit, Frodo Baggins, must destroy the One Ring to save Middle-earth.',
        'EN',
        'cd7aba5e-fdfc-4cc0-90ef-b2b5e9634ac0',
        'New Line Cinema',
        'PG-13',
        null,
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
        'EN',
        'cd7aba5e-fdfc-4cc0-90ef-b2b5e9634ac0',
        'New Line Cinema',
        'PG-13',
        null,
        '2023-03-15',
        '642f36f2-4edd-43d2-9df8-810344d5e733', -- Preceded by The Fellowship of the Ring
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
        'EN',
        'cd7aba5e-fdfc-4cc0-90ef-b2b5e9634ac0',
        'New Line Cinema',
        'PG-13',
        null,
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
    TITTLE,
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
        'EN',
        '2ce4fe03-96b9-42b5-8395-372b9a935d76',
        '20th Century Fox',
        'PG-13',
        null,
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
        'EN',
        '2ce4fe03-96b9-42b5-8395-372b9a935d76',
        '20th Century Fox',
        'PG-13',
        null,
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
        'EN',
        '2ce4fe03-96b9-42b5-8395-372b9a935d76',
        '20th Century Fox',
        'PG-13',
        null,
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
        'EN',
        '2ce4fe03-96b9-42b5-8395-372b9a935d76',
        '20th Century Fox',
        'PG-13',
        null,
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
        'EN',
        '2ce4fe03-96b9-42b5-8395-372b9a935d76',
        '20th Century Fox',
        'PG-13',
        null,
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
        'EN',
        '2ce4fe03-96b9-42b5-8395-372b9a935d76',
        '20th Century Fox',
        'PG-13',
        null,
        '2023-07-15',
        'f84e28c4-5803-4d2c-9b9a-18779413405a', -- Preceded by X-Men: Apocalypse
        NULL, -- No sequel planned for X-Men: Dark Phoenix
        252500000,
        113,
        '2019-06-05',
        FALSE
    );

--Transformers
INSERT INTO film (
    id,
    FILM_TYPE,
    TITTLE,
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
        'EN',
        'dbd8fad2-f7c3-4186-b20f-de2d796ffd27',
        'Paramount Pictures',
        'PG-13',
        null,
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
        'EN',
        'dbd8fad2-f7c3-4186-b20f-de2d796ffd27',
        'Paramount Pictures',
        'PG-13',
        null,
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
        'EN',
        'dbd8fad2-f7c3-4186-b20f-de2d796ffd27',
        'Paramount Pictures',
        'PG-13',
        null,
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
        'EN',
        'dbd8fad2-f7c3-4186-b20f-de2d796ffd27',
        'Paramount Pictures',
        'PG-13',
        null,
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
        'EN',
        'dbd8fad2-f7c3-4186-b20f-de2d796ffd27',
        'Paramount Pictures',
        'PG-13',
        null,
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
        'EN',
        'dbd8fad2-f7c3-4186-b20f-de2d796ffd27',
        'Paramount Pictures',
        'PG-13',
        null,
        '2023-07-15',
        '9d5835f1-7ce7-482b-a5a5-05f39461d1bf', -- Preceded by Transformers: The Last Knight
        NULL, -- No sequel planned for Bumblebee
        468200000,
        114,
        '2018-12-21',
        FALSE
    );

--Fast & Furious
INSERT INTO film (
    id,
    FILM_TYPE,
    TITTLE,
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
        'EN',
        'b733a1a4-2c24-47b9-a1df-af988257fa2b',
        'Universal Pictures',
        'PG-13',
        null,
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
        'EN',
        'b733a1a4-2c24-47b9-a1df-af988257fa2b',
        'Universal Pictures',
        'PG-13',
        null,
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
        'EN',
        'b733a1a4-2c24-47b9-a1df-af988257fa2b',
        'Universal Pictures',
        'PG-13',
        null,
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
        'EN',
        'b733a1a4-2c24-47b9-a1df-af988257fa2b',
        'Universal Pictures',
        'PG-13',
        null,
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
        'EN',
        'b733a1a4-2c24-47b9-a1df-af988257fa2b',
        'Universal Pictures',
        'PG-13',
        null,
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
        'EN',
        'b733a1a4-2c24-47b9-a1df-af988257fa2b',
        'Universal Pictures',
        'PG-13',
        null,
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
        'EN',
        'b733a1a4-2c24-47b9-a1df-af988257fa2b',
        'Universal Pictures',
        'PG-13',
        null,
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
        'EN',
        'b733a1a4-2c24-47b9-a1df-af988257fa2b',
        'Universal Pictures',
        'PG-13',
        null,
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
        'EN',
        'b733a1a4-2c24-47b9-a1df-af988257fa2b',
        'Universal Pictures',
        'PG-13',
        null,
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
    TITTLE,
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
        'EN',
        '1194c17d-8090-42bb-b01c-49fb08c4dec8',
        'Summit Entertainment',
        'PG-13',
        null,
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
        'EN',
        '1194c17d-8090-42bb-b01c-49fb08c4dec8',
        'Summit Entertainment',
        'PG-13',
        null,
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
        'EN',
        '1194c17d-8090-42bb-b01c-49fb08c4dec8',
        'Summit Entertainment',
        'PG-13',
        null,
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
        'EN',
        '1194c17d-8090-42bb-b01c-49fb08c4dec8',
        'Summit Entertainment',
        'PG-13',
        null,
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
        'The Cullens and their allies gather to protect Renesmee from a null allegation.',
        'EN',
        '1194c17d-8090-42bb-b01c-49fb08c4dec8',
        'Summit Entertainment',
        'PG-13',
        null,
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
    TITTLE,
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
        'EN',
        'a251ee27-57e1-439b-b332-f7e9d1a98418',
        'Walt Disney Pictures',
        'PG',
        null,
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
        'EN',
        'a251ee27-57e1-439b-b332-f7e9d1a98418',
        'Walt Disney Pictures',
        'PG',
        null,
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
        'EN',
        'a251ee27-57e1-439b-b332-f7e9d1a98418',
        '20th Century Fox',
        'PG',
        null,
        '2023-04-15',
        'a4e13e08-3d3d-4aa5-9b46-86dc7b3175d5', -- Preceded by Prince Caspian
        NULL, -- No sequel planned for The Voyage of the Dawn Treader
        415700000,
        113,
        '2010-12-10',
        FALSE
    );

--Toy Story
INSERT INTO film (
    id,
    FILM_TYPE,
    TITTLE,
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
        'EN',
        '2c71b3b5-836f-4155-aac5-130cf05ba66e',
        'Walt Disney Pictures',
        'G',
        null,
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
        'EN',
        '2c71b3b5-836f-4155-aac5-130cf05ba66e',
        'Walt Disney Pictures',
        'G',
        null,
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
        'EN',
        '2c71b3b5-836f-4155-aac5-130cf05ba66e',
        'Walt Disney Pictures',
        'G',
        null,
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
        'EN',
        '2c71b3b5-836f-4155-aac5-130cf05ba66e',
        'Walt Disney Pictures',
        'G',
        null,
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
    TITTLE,
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
        'EN',
        '0bfd4070-dd0a-4eb0-9cba-3edbd01512b6',
        'DreamWorks Pictures',
        'PG',
        null,
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
        'EN',
        '0bfd4070-dd0a-4eb0-9cba-3edbd01512b6',
        'DreamWorks Pictures',
        'PG',
        null,
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
        'EN',
        '0bfd4070-dd0a-4eb0-9cba-3edbd01512b6',
        'DreamWorks Pictures',
        'PG',
        null,
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
        'EN',
        '0bfd4070-dd0a-4eb0-9cba-3edbd01512b6',
        'DreamWorks Pictures',
        'PG',
        null,
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
    TITTLE,
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
        'EN',
        '99d9059c-96fb-42d4-a3c9-27b4bda1e6a2',
        'Paramount Pictures',
        'PG-13',
        null,
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
        'EN',
        '99d9059c-96fb-42d4-a3c9-27b4bda1e6a2',
        'Paramount Pictures',
        'PG-13',
        null,
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
        'EN',
        '99d9059c-96fb-42d4-a3c9-27b4bda1e6a2',
        'Paramount Pictures',
        'PG-13',
        null,
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
        'EN',
        '99d9059c-96fb-42d4-a3c9-27b4bda1e6a2',
        'Paramount Pictures',
        'PG-13',
        null,
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
        'EN',
        '99d9059c-96fb-42d4-a3c9-27b4bda1e6a2',
        'Paramount Pictures',
        'PG-13',
        null,
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
        'EN',
        '99d9059c-96fb-42d4-a3c9-27b4bda1e6a2',
        'Paramount Pictures',
        'PG-13',
        null,
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
    TITTLE,
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
        'EN',
        '3f51926e-97d6-4877-970e-8cec5a42bf5c',
        'Universal Pictures',
        'PG-13',
        null,
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
        'EN',
        '3f51926e-97d6-4877-970e-8cec5a42bf5c',
        'Universal Pictures',
        'PG-13',
        null,
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
        'EN',
        '3f51926e-97d6-4877-970e-8cec5a42bf5c',
        'Universal Pictures',
        'PG-13',
        null,
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
    TITTLE,
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
        'EN',
        '6494e629-46d6-41eb-a769-3e2f96292493',
        'Screen Gems',
        'R',
        null,
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
        'EN',
        '6494e629-46d6-41eb-a769-3e2f96292493',
        'Screen Gems',
        'R',
        null,
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
        'EN',
        '6494e629-46d6-41eb-a769-3e2f96292493',
        'Screen Gems',
        'R',
        null,
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
        'EN',
        '6494e629-46d6-41eb-a769-3e2f96292493',
        'Screen Gems',
        'R',
        null,
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
        'EN',
        '6494e629-46d6-41eb-a769-3e2f96292493',
        'Screen Gems',
        'R',
        null,
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
        'EN',
        '6494e629-46d6-41eb-a769-3e2f96292493',
        'Screen Gems',
        'R',
        null,
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
    TITTLE,
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
        'EN',
        '3f278ab5-2bb5-4f46-b7e7-905fb45eaa71',
        '20th Century Fox',
        'PG',
        null,
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
        'EN',
        '3f278ab5-2bb5-4f46-b7e7-905fb45eaa71',
        '20th Century Fox',
        'PG',
        null,
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
        'EN',
        '3f278ab5-2bb5-4f46-b7e7-905fb45eaa71',
        '20th Century Fox',
        'PG',
        null,
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
        'EN',
        '3f278ab5-2bb5-4f46-b7e7-905fb45eaa71',
        '20th Century Fox',
        'PG',
        null,
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
        'EN',
        '3f278ab5-2bb5-4f46-b7e7-905fb45eaa71',
        '20th Century Fox',
        'PG',
        null,
        '2023-06-15',
        'd0e7fdaa-1a71-47b1-a70a-57bb2ad89321', -- Preceded by Ice Age: Continental Drift
        NULL, -- No sequel planned for Ice Age: Collision Course
        408579038,
        94,
        '2016-07-22',
        FALSE
    );

--Spider-Man
INSERT INTO film (
    id,
    FILM_TYPE,
    TITTLE,
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
        'EN',
        '19b3f0d6-49d9-44e2-bf2b-1d67ca39b086',
        'Sony Pictures Releasing',
        'PG-13',
        null,
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
        'EN',
        '19b3f0d6-49d9-44e2-bf2b-1d67ca39b086',
        'Sony Pictures Releasing',
        'PG-13',
        null,
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
        'EN',
        '19b3f0d6-49d9-44e2-bf2b-1d67ca39b086',
        'Sony Pictures Releasing',
        'PG-13',
        null,
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
    TITTLE,
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
        'EN',
        '0f6b8db8-fae3-4f5d-9157-5e40760e5e75',
        'Warner Bros. Pictures',
        'R',
        null,
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
        'EN',
        '0f6b8db8-fae3-4f5d-9157-5e40760e5e75',
        'Warner Bros. Pictures',
        'R',
        null,
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
        'EN',
        '0f6b8db8-fae3-4f5d-9157-5e40760e5e75',
        'Warner Bros. Pictures',
        'R',
        null,
        '2023-04-15',
        '491e0975-b9bf-4ac3-9274-86dc7b3175d5', -- Preceded by The Matrix Reloaded
        NULL, -- No sequel planned for The Matrix Revolutions
        427343288,
        129,
        '2003-10-27',
        FALSE
    );

--Iron Man
INSERT INTO film (
    id,
    FILM_TYPE,
    TITTLE,
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
        'EN',
        'bd87db23-5562-4188-af79-2e884d9bc8ac',
        'Paramount Pictures',
        'PG-13',
        null,
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
        'EN',
        'bd87db23-5562-4188-af79-2e884d9bc8ac',
        'Paramount Pictures',
        'PG-13',
        null,
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
        'EN',
        'bd87db23-5562-4188-af79-2e884d9bc8ac',
        'Walt Disney Studios Motion Pictures',
        'PG-13',
        null,
        '2023-04-15',
        '1f1d7e23-6899-40aa-8ad4-86dc7b3175d5', -- Preceded by Iron Man 2
        '943b4b26-c495-40d6-a172-19b29d051c2e', -- Followed by Iron Man 3
        "1.518 billion",
        143,
        '2012-04-11',
        FALSE
    ),
    (
        '943b4b26-c495-40d6-a172-19b29d051c2e',
        1,
        'Iron Man 3',
        'Tony Stark faces a formidable enemy known as the Mandarin, leading to personal and professional challenges.',
        'EN',
        'bd87db23-5562-4188-af79-2e884d9bc8ac',
        'Walt Disney Studios Motion Pictures',
        'PG-13',
        null,
        '2023-05-15',
        '5072401a-cfae-4e3b-9538-77d3df47f9c3', -- Preceded by The Avengers
        NULL, -- No sequel planned for Iron Man 3
        "1.214 billion",
        "130",
        '2013-04-24',
        FALSE
    );

--Indiana Jones
INSERT INTO film (
    id,
    FILM_TYPE,
    TITTLE,
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
        'EN',
        '0606b0b8-b5ee-4a3f-8f9e-1f82dcd4bd57',
        'Paramount Pictures',
        'PG',
        null,
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
        'EN',
        '0606b0b8-b5ee-4a3f-8f9e-1f82dcd4bd57',
        'Paramount Pictures',
        'PG',
        null,
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
        'EN',
        '0606b0b8-b5ee-4a3f-8f9e-1f82dcd4bd57',
        'Paramount Pictures',
        'PG-13',
        null,
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
    TITTLE,
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
        'EN',
        '7eb891ff-b43c-473f-8c2d-74c3f4b3a45f',
        'Orion Pictures',
        'R',
        null,
        '2023-02-15',
        NULL, -- No prequel for The Terminator
        '2e1b83aa-3dbf-4a61-b5a2-86dc7b3175d5', -- Followed by Terminator 2: Judgment Day
        "78.4 million",
        107,
        '1984-10-26',
        FALSE
    ),
    (
        '2e1b83aa-3dbf-4a61-b5a2-86dc7b3175d5',
        1,
        'Terminator 2: Judgment Day',
        'A new Terminator is sent to protect John Connor from a more advanced and powerful Terminator.',
        'EN',
        '7eb891ff-b43c-473f-8c2d-74c3f4b3a45f',
        'TriStar Pictures',
        'R',
        null,
        '2023-03-15',
        'b943a1cf-5b18-43f7-862a-549b84d4b019', -- Preceded by The Terminator
        '3cf70b25-8a47-4f5b-ae91-77d3df47f9c3', -- Followed by Terminator 3: Rise of the Machines
        "519.8 million",
        137,
        '1991-07-01',
        FALSE
    ),
    (
        '3cf70b25-8a47-4f5b-ae91-77d3df47f9c3',
        1,
        'Terminator 3: Rise of the Machines',
        'John Connor must once again face a Terminator, this time a female model, and prevent Judgment Day.',
        'EN',
        '7eb891ff-b43c-473f-8c2d-74c3f4b3a45f',
        'Warner Bros. Pictures',
        'R',
        null,
        '2023-04-15',
        '2e1b83aa-3dbf-4a61-b5a2-86dc7b3175d5', -- Preceded by Terminator 2: Judgment Day
        'f59d6ff6-c469-4767-9cc7-19b29d051c2e', -- Followed by Terminator Salvation
        "433.4 million",
        109,
        '2003-06-30',
        FALSE
    ),
    (
        'f59d6ff6-c469-4767-9cc7-19b29d051c2e',
        1,
        'Terminator Salvation',
        'Set in a post-apocalyptic future, John Connor leads the resistance against Skynet and its machines.',
        'EN',
        '7eb891ff-b43c-473f-8c2d-74c3f4b3a45f',
        'Warner Bros. Pictures',
        'PG-13',
        null,
        '2023-05-15',
        '3cf70b25-8a47-4f5b-ae91-77d3df47f9c3', -- Preceded by Terminator 3: Rise of the Machines
        '6143835a-2292-42c7-8bfa-86dc7b3175d5', -- Followed by Terminator Genisys
        "371.4 million",
        115,
        '2009-05-14',
        FALSE
    ),
    (
        '6143835a-2292-42c7-8bfa-86dc7b3175d5',
        1,
        'Terminator Genisys',
        'The timeline is altered as Sarah Connor and a Guardian Terminator team up to prevent Judgment Day.',
        'EN',
        '7eb891ff-b43c-473f-8c2d-74c3f4b3a45f',
        'Paramount Pictures',
        'PG-13',
        null,
        '2023-06-15',
        'f59d6ff6-c469-4767-9cc7-19b29d051c2e', -- Preceded by Terminator Salvation
        'c0e1d24f-c6da-4912-8980-19b29d051c2e', -- Followed by Terminator: Dark Fate
        "440.6 million",
        126,
        '2015-06-28',
        FALSE
    ),
    (
        'c0e1d24f-c6da-4912-8980-19b29d051c2e',
        1,
        'Terminator: Dark Fate',
        'Sarah Connor returns to battle a new, highly advanced Terminator, accompanied by a human-machine hybrid.',
        'EN',
        '7eb891ff-b43c-473f-8c2d-74c3f4b3a45f',
        'Paramount Pictures',
        'R',
        null,
        '2023-07-15',
        '6143835a-2292-42c7-8bfa-86dc7b3175d5', -- Preceded by Terminator Genisys
        NULL, -- No sequel planned for Terminator: Dark Fate
        "261.1 million",
        128,
        '2019-10-23',
        FALSE
    );

--Jurassic Park
INSERT INTO film (
    id,
    FILM_TYPE,
    TITTLE,
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
        'EN',
        '3f31ac78-b224-4cae-8cb8-261390b3d9bb',
        'Universal Pictures',
        'PG-13',
        null,
        '2023-02-15',
        NULL, -- No prequel for Jurassic Park
        '9a00426e-62c0-4872-a1c7-86dc7b3175d5', -- Followed by The Lost World: Jurassic Park
        "1.029 billion",
        127,
        '1993-06-11',
        FALSE
    ),
    (
        '9a00426e-62c0-4872-a1c7-86dc7b3175d5',
        1,
        'The Lost World: Jurassic Park',
        'A group returns to Isla Sorna to study dinosaurs, but encounters unexpected dangers, including a T-Rex in San Diego.',
        'EN',
        '3f31ac78-b224-4cae-8cb8-261390b3d9bb',
        'Universal Pictures',
        'PG-13',
        null,
        '2023-03-15',
        '9535a650-c1c2-4f12-8302-549b84d4b019', -- Preceded by Jurassic Park
        '780df39b-7f88-4ce6-a7e6-77d3df47f9c3', -- Followed by Jurassic Park III
        "618.6 million",
        129,
        '1997-05-23',
        FALSE
    ),
    (
        '780df39b-7f88-4ce6-a7e6-77d3df47f9c3',
        1,
        'Jurassic Park III',
        'A rescue mission turns into a fight for survival when a group becomes stranded on Isla Sorna with dangerous dinosaurs.',
        'EN',
        '3f31ac78-b224-4cae-8cb8-261390b3d9bb',
        'Universal Pictures',
        'PG-13',
        null,
        '2023-04-15',
        '9a00426e-62c0-4872-a1c7-86dc7b3175d5', -- Preceded by The Lost World: Jurassic Park
        '34b84936-c72c-45c8-a04e-19b29d051c2e', -- Followed by Jurassic World
        "368.8 million",
        92,
        '2001-07-18',
        FALSE
    ),
    (
        '34b84936-c72c-45c8-a04e-19b29d051c2e',
        1,
        'Jurassic World',
        'A new theme park with genetically modified dinosaurs faces a crisis when a highly intelligent hybrid escapes.',
        'EN',
        '3f31ac78-b224-4cae-8cb8-261390b3d9bb',
        'Universal Pictures',
        'PG-13',
        null,
        '2023-05-15',
        '780df39b-7f88-4ce6-a7e6-77d3df47f9c3', -- Preceded by Jurassic Park III
        '9c2d977a-116a-44e6-a3c1-86dc7b3175d5', -- Followed by Jurassic World: Fallen Kingdom
        "1.672 billion",
        124,
        '2015-06-09',
        FALSE
    ),
    (
        '9c2d977a-116a-44e6-a3c1-86dc7b3175d5',
        1,
        'Jurassic World: Fallen Kingdom',
        'Owen and Claire return to Isla Nublar to save the remaining dinosaurs from an impending volcanic eruption.',
        'EN',
        '3f31ac78-b224-4cae-8cb8-261390b3d9bb',
        'Universal Pictures',
        'PG-13',
        null,
        '2023-06-15',
        '34b84936-c72c-45c8-a04e-19b29d051c2e', -- Preceded by Jurassic World
        '04d5a6a7-d465-42b4-81da-19b29d051c2e', -- Followed by Jurassic World: Dominion
        "1.308 billion",
        128,
        '2018-06-06',
        FALSE
    ),
    (
        '04d5a6a7-d465-42b4-81da-19b29d051c2e',
        1,
        'Jurassic World: Dominion',
        'Dinosaurs now coexist with humans, but a new threat emerges that could change the balance of power.',
        'EN',
        '3f31ac78-b224-4cae-8cb8-261390b3d9bb',
        'Universal Pictures',
        'PG-13',
        null,
        '2023-07-15',
        '9c2d977a-116a-44e6-a3c1-86dc7b3175d5', -- Preceded by Jurassic World: Fallen Kingdom
        NULL,
        "1.434 billion",
        132,
        '2020-08-10',
        FALSE
    );

--Rambo
INSERT INTO film (
    id,
    FILM_TYPE,
    TITTLE,
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
        'EN',
        'e0a15465-5e81-485d-937c-d6a09f08cf24',
        'Orion Pictures',
        'R',
        null,
        '2023-02-15',
        NULL, -- No prequel for First Blood
        'e1e9637c-badd-46ab-a630-86dc7b3175d5', -- Followed by Rambo: First Blood Part II
        "125.2 million",
        96,
        '1982-10-22',
        FALSE
    ),
    (
        'e1e9637c-badd-46ab-a630-86dc7b3175d5',
        1,
        'Rambo: First Blood Part II',
        'John Rambo is sent on a mission to rescue American POWs in Vietnam, uncovering betrayal and political intrigue.',
        'EN',
        'e0a15465-5e81-485d-937c-d6a09f08cf24',
        'TriStar Pictures',
        'R',
        null,
        '2023-03-15',
        '2b226f0f-3c93-46b9-9e62-549b84d4b019', -- Preceded by First Blood
        '7c635499-3f46-4e1d-ba1d-77d3df47f9c3', -- Followed by Rambo III
        "300.4 million",
        96,
        '1985-05-22',
        FALSE
    ),
    (
        '7c635499-3f46-4e1d-ba1d-77d3df47f9c3',
        1,
        'Rambo III',
        'Rambo travels to Afghanistan to rescue his former commander who is captured by Soviet forces during the war.',
        'EN',
        'e0a15465-5e81-485d-937c-d6a09f08cf24',
        'TriStar Pictures',
        'R',
        null,
        '2023-04-15',
        'e1e9637c-badd-46ab-a630-86dc7b3175d5', -- Preceded by Rambo: First Blood Part II
        'f35b8a06-1a57-4a22-9f71-19b29d051c2e', -- Followed by Rambo
        "189.0 million",
        102,
        '1988-05-25',
        FALSE
    ),
    (
        'f35b8a06-1a57-4a22-9f71-19b29d051c2e',
        1,
        'Rambo',
        'John Rambo is persuaded to undertake a mission to rescue aid workers in Burma, confronting a ruthless military regime.',
        'EN',
        'e0a15465-5e81-485d-937c-d6a09f08cf24',
        'Lionsgate',
        'R',
        null,
        '2023-05-15',
        '7c635499-3f46-4e1d-ba1d-77d3df47f9c3', -- Preceded by Rambo III
        'c9f276ed-0a8a-4d1a-89d5-86dc7b3175d5', -- Followed by Rambo: Last Blood
        "113.2 million",
        89,
        '2008-01-25',
        FALSE
    ),
    (
        'c9f276ed-0a8a-4d1a-89d5-86dc7b3175d5',
        1,
        'Rambo: Last Blood',
        "Rambo seeks vengeance when a friend's daughter is kidnapped by a Mexican cartel, leading to a deadly confrontation.",
        'EN',
        'e0a15465-5e81-485d-937c-d6a09f08cf24',
        'Lionsgate',
        'R',
        null,
        '2023-06-15',
        'f35b8a06-1a57-4a22-9f71-19b29d051c2e', -- Preceded by Rambo
        NULL, -- No sequel planned for Rambo: Last Blood
        "91.5 million",
        89,
        '2019-09-20',
        FALSE
    );

--The Hangover
INSERT INTO film (
    id,
    FILM_TYPE,
    TITTLE,
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
        'EN',
        'adc21998-a3d7-4ab1-b57c-0d548481195d',
        'Warner Bros. Pictures',
        'R',
        null,
        '2023-02-15',
        NULL, -- No prequel for The Hangover
        '0f9c90da-d591-42ab-af2d-86dc7b3175d5', -- Followed by The Hangover Part II
        "467.5 million",
        100,
        '2009-06-05',
        FALSE
    ),
    (
        '0f9c90da-d591-42ab-af2d-86dc7b3175d5',
        1,
        'The Hangover Part II',
        "The Wolfpack travels to Thailand for Stu's wedding, but another wild night leads to a search for a missing friend.",
        'EN',
        'adc21998-a3d7-4ab1-b57c-0d548481195d',
        'Warner Bros. Pictures',
        'R',
        null,
        '2023-03-15',
        '5e6a4861-493a-4a14-b950-549b84d4b019', -- Preceded by The Hangover
        'd1b70fc3-0b12-4c8d-9d6a-77d3df47f9c3', -- Followed by The Hangover Part III
        "586.8 million",
        102,
        '2011-05-26',
        FALSE
    ),
    (
        'd1b70fc3-0b12-4c8d-9d6a-77d3df47f9c3',
        1,
        'The Hangover Part III',
        'The Wolfpack attempts an intervention to help Alan, but things take a dangerous turn when they cross paths with a criminal.',
        'EN',
        'bb82103a-708e-4a86-953c-7a8b1461d1bf',
        'Warner Bros. Pictures',
        'R',
        null,
        '2023-04-15',
        'adc21998-a3d7-4ab1-b57c-0d548481195d', -- Preceded by The Hangover Part II
        NULL, -- No sequel planned for The Hangover Part III
        "362 million",
        100,
        '2013-05-23',
        FALSE
    );

--Back to the Future
INSERT INTO film (
    id,
    FILM_TYPE,
    TITTLE,
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
        'EN',
        '1b335998-2d7b-42e6-90c2-c22f9884fda7',
        'Universal Pictures',
        'PG',
        null,
        '2023-02-15',
        NULL, -- No prequel for Back to the Future
        '83a46bc4-7d3b-40cb-ae71-86dc7b3175d5', -- Followed by Back to the Future Part II
        "389.1 million",
        116,
        '1985-07-03',
        FALSE
    ),
    (
        '83a46bc4-7d3b-40cb-ae71-86dc7b3175d5',
        1,
        'Back to the Future Part II',
        'Marty and Doc travel to the future to prevent a family disaster, but their actions have unintended consequences.',
        'EN',
        '1b335998-2d7b-42e6-90c2-c22f9884fda7',
        'Universal Pictures',
        'PG',
        null,
        '2023-03-15',
        '823f77c2-6b1c-4cc3-92b2-549b84d4b019', -- Preceded by Back to the Future
        'c68608f8-ef27-4c5a-bf2e-77d3df47f9c3', -- Followed by Back to the Future Part III
        "332 million",
        108,
        '1989-11-22',
        FALSE
    ),
    (
        'c68608f8-ef27-4c5a-bf2e-77d3df47f9c3',
        1,
        'Back to the Future Part III',
        'Marty travels to the Wild West to rescue Doc, but they face challenges and must find a way back to their time.',
        'EN',
        '1b335998-2d7b-42e6-90c2-c22f9884fda7',
        'Universal Pictures',
        'PG',
        null,
        '2023-04-15',
        '83a46bc4-7d3b-40cb-ae71-86dc7b3175d5', -- Preceded by Back to the Future Part II
        NULL, -- No sequel planned for Back to the Future Part III
        "244.5 million",
        118,
        '1990-05-25',
        FALSE
    );

--Men in Black
INSERT INTO film (
    id,
    FILM_TYPE,
    TITTLE,
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
        'EN',
        'd2fc3f9a-83b9-44d8-a48a-04df5d625dff',
        'Columbia Pictures',
        'PG-13',
        null,
        '2023-02-15',
        NULL, -- No prequel for Men in Black
        '0ec5c120-3801-46e7-a3f5-86dc7b3175d5', -- Followed by Men in Black II
        "589.4 million",
        98,
        '1997-07-02',
        FALSE
    ),
    (
        '0ec5c120-3801-46e7-a3f5-86dc7b3175d5',
        1,
        'Men in Black II',
        'Agent J must reunite with Agent K to stop an evil alien threat that could destroy Earth.',
        'EN',
        'd2fc3f9a-83b9-44d8-a48a-04df5d625dff',
        'Columbia Pictures',
        'PG-13',
        null,
        '2023-03-15',
        'c0cc183c-30e5-4714-bec0-549b84d4b019', -- Preceded by Men in Black
        '1379b3cc-e0bf-4f4a-8e90-77d3df47f9c3', -- Followed by Men in Black 3
        "441.8 million",
        88,
        '2002-07-03',
        FALSE
    ),
    (
        '1379b3cc-e0bf-4f4a-8e90-77d3df47f9c3',
        1,
        'Men in Black 3',
        'Agent J travels back in time to the 1960s to prevent an alien from assassinating a young Agent K.',
        'EN',
        'd2fc3f9a-83b9-44d8-a48a-04df5d625dff',
        'Columbia Pictures',
        'PG-13',
        null,
        '2023-04-15',
        '0ec5c120-3801-46e7-a3f5-86dc7b3175d5', -- Preceded by Men in Black II
        'f02a5d7f-9a43-43cc-8a89-19b29d051c2e', -- Followed by Men in Black: International
        "624 million",
        106,
        '2012-05-25',
        FALSE
    ),
    (
        'f02a5d7f-9a43-43cc-8a89-19b29d051c2e',
        1,
        'Men in Black: International',
        'Agent H and rookie M must prevent an alien threat and uncover a mole within the Men in Black organization.',
        'EN',
        'd2fc3f9a-83b9-44d8-a48a-04df5d625dff',
        'Columbia Pictures',
        'PG-13',
        null,
        '2023-05-15',
        '1379b3cc-e0bf-4f4a-8e90-77d3df47f9c3', -- Preceded by Men in Black 3
        NULL, -- No sequel planned for Men in Black: International
        "253.9 million",
        115,
        '2019-06-14',
        FALSE
    );
--Die Hard
INSERT INTO film (
    id,
    FILM_TYPE,
    TITTLE,
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
        'EN',
        '060d8217-1eeb-4c0d-9242-4eab74f7007a',
        '20th Century Fox',
        'R',
        null,
        '2023-02-15',
        NULL, -- No prequel for Die Hard
        '86e9933b-7089-4a09-8c3d-86dc7b3175d5', -- Followed by Die Hard 2
        "141.5 million",
        132,
        '1988-07-15',
        FALSE
    ),
    (
        '86e9933b-7089-4a09-8c3d-86dc7b3175d5',
        1,
        'Die Hard 2',
        "John McClane must stop terrorists who take an airport hostage while his wife's plane circles overhead.",
        'EN',
        '060d8217-1eeb-4c0d-9242-4eab74f7007a',
        '20th Century Fox',
        'R',
        null,
        '2023-03-15',
        'b2e09126-7f86-493d-9d0b-549b84d4b019', -- Preceded by Die Hard
        '55c7914b-86bf-43a5-9a67-77d3df47f9c3', -- Followed by Die Hard with a Vengeance
        "240 million",
        124,
        '1990-07-04',
        FALSE
    ),
    (
        '55c7914b-86bf-43a5-9a67-77d3df47f9c3',
        1,
        'Die Hard with a Vengeance',
        'John McClane teams up with a Harlem store owner to stop a terrorist with a personal vendetta against McClane.',
        'EN',
        '060d8217-1eeb-4c0d-9242-4eab74f7007a',
        '20th Century Fox',
        'R',
        null,
        '2023-04-15',
        '86e9933b-7089-4a09-8c3d-86dc7b3175d5', -- Preceded by Die Hard 2
        '7e0ab380-8268-4a1b-a09b-19b29d051c2e', -- Followed by Live Free or Die Hard
        "366.1 million",
        128,
        '1995-05-19',
        FALSE
    ),
    (
        '7e0ab380-8268-4a1b-a09b-19b29d051c2e',
        1,
        'Live Free or Die Hard',
        'John McClane faces a cyber-terrorist threat that could cripple the United States and brings him into a new era of action.',
        'EN',
        '060d8217-1eeb-4c0d-9242-4eab74f7007a',
        '20th Century Fox',
        'PG-13',
        null,
        '2023-05-15',
        '55c7914b-86bf-43a5-9a67-77d3df47f9c3', -- Preceded by Die Hard with a Vengeance
        '0da847d9-3c29-452e-b0d7-86dc7b3175d5', -- Followed by A Good Day to Die Hard
        "383.5 million",
        128,
        '2007-06-27',
        FALSE
    ),
    (
        '0da847d9-3c29-452e-b0d7-86dc7b3175d5',
        1,
        'A Good Day to Die Hard',
        'John McClane travels to Russia to help his estranged son, who is caught up in a nuclear weapons heist.',
        'EN',
        '060d8217-1eeb-4c0d-9242-4eab74f7007a',
        '20th Century Fox',
        'R',
        null,
        '2023-06-15',
        '7e0ab380-8268-4a1b-a09b-19b29d051c2e', -- Preceded by Live Free or Die Hard
        NULL, -- No sequel planned for A Good Day to Die Hard
        "304.7 million",
        98,
        '2013-02-14',
        FALSE
    );

--Rush Hour
INSERT INTO film (
    id,
    FILM_TYPE,
    TITTLE,
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
        'EN',
        '8bc176ce-dbc0-4685-81cb-71de31780281',
        'New Line Cinema',
        'PG-13',
        null,
        '2023-02-15',
        NULL, -- No prequel for Rush Hour
        '5d22c4d1-af04-4ff5-81bf-86dc7b3175d5', -- Followed by Rush Hour 2
        "244.4 million",
        98,
        '1998-09-18',
        FALSE
    ),
    (
        '5d22c4d1-af04-4ff5-81bf-86dc7b3175d5',
        1,
        'Rush Hour 2',
        'Lee and Carter travel to Hong Kong to stop a counterfeit money scam and unravel a conspiracy involving the Triads.',
        'EN',
        '8bc176ce-dbc0-4685-81cb-71de31780281',
        'New Line Cinema',
        'PG-13',
        null,
        '2023-03-15',
        '76e7f7d5-6db4-4a32-b0c3-549b84d4b019', -- Preceded by Rush Hour
        '72f35b15-ff76-4971-9f87-77d3df47f9c3', -- Followed by Rush Hour 3
        "347.3 million",
        90,
        '2001-08-03',
        FALSE
    ),
    (
        '72f35b15-ff76-4971-9f87-77d3df47f9c3',
        1,
        'Rush Hour 3',
        'Lee and Carter investigate an assassination attempt on the Chinese ambassador, leading them to a dangerous criminal organization.',
        'EN',
        '8bc176ce-dbc0-4685-81cb-71de31780281',
        'New Line Cinema',
        'PG-13',
        null,
        '2023-04-15',
        '5d22c4d1-af04-4ff5-81bf-86dc7b3175d5', -- Preceded by Rush Hour 2
        NULL, -- No sequel planned for Rush Hour 3
        "258.2 million",
        91,
        '2007-08-10',
        FALSE
    );

--Bring It On
INSERT INTO film (
    id,
    FILM_TYPE,
    TITTLE,
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
        'EN',
        '2720b6a8-6b5d-47fb-8630-a73cb9718443',
        'Universal Pictures',
        'PG-13',
        null,
        '2023-02-15',
        NULL, -- No prequel for Bring It On
        'c96b4164-666b-4fc4-9e1f-86dc7b3175d5', -- Followed by Bring It On Again
        "90.5 million",
        98,
        '2000-08-25',
        FALSE
    ),
    (
        'c96b4164-666b-4fc4-9e1f-86dc7b3175d5',
        1,
        'Bring It On Again',
        'New captain Whittier and her friends form a cheerleading squad to compete in college, facing new challenges and rivalries.',
        'EN',
        '2720b6a8-6b5d-47fb-8630-a73cb9718443',
        'Universal Pictures',
        'PG-13',
        null,
        '2023-03-15',
        'a3e2b597-7d4a-414e-af7f-549b84d4b019', -- Preceded by Bring It On
        'd8a7f0c5-b0d1-4d67-9d53-77d3df47f9c3', -- Followed by Bring It On: All or Nothing
        "63.5 million",
        90,
        '2004-01-13',
        FALSE
    ),
    (
        'd8a7f0c5-b0d1-4d67-9d53-77d3df47f9c3',
        1,
        'Bring It On: All or Nothing',
        "A transfer student joins a cheerleading squad to take down her former school's captain in a national competition.",
        'EN',
        '2720b6a8-6b5d-47fb-8630-a73cb9718443',
        'Universal Studios Home Entertainment',
        'PG-13',
        null,
        '2023-04-15',
        'c96b4164-666b-4fc4-9e1f-86dc7b3175d5', -- Preceded by Bring It On Again
        NULL, -- No sequel planned for Bring It On: All or Nothing
        "17.2 million",
        99,
        '2006-08-08',
        FALSE
    );

--Alien
INSERT INTO film (
    id,
    FILM_TYPE,
    TITTLE,
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
        'EN',
        '7024167e-9da5-4773-bbb0-db7dae9814f7',
        '20th Century Fox',
        'R',
        null,
        '2023-02-15',
        NULL, -- No prequel for Alien
        'b439e110-2a07-4c4b-8c86-86dc7b3175d5', -- Followed by Aliens
        "104.9 million",
        117,
        '1979-05-25',
        FALSE
    ),
    (
        'b439e110-2a07-4c4b-8c86-86dc7b3175d5',
        1,
        'Aliens',
        'Ellen Ripley returns to the planet where her crew encountered the alien, this time with a squad of space marines.',
        'EN',
        '7024167e-9da5-4773-bbb0-db7dae9814f7',
        '20th Century Fox',
        'R',
        null,
        '2023-03-15',
        'e17a30eb-baa1-4b42-9661-549b84d4b019', -- Preceded by Alien
        '7cda4f3e-9cf7-4072-8f1a-77d3df47f9c3', -- Followed by Alien³
        "131.1 million",
        137,
        '1986-07-18',
        FALSE
    ),
    (
        '7cda4f3e-9cf7-4072-8f1a-77d3df47f9c3',
        1,
        'Alien³',
        'Ripley crash-lands on a prison planet and discovers that the alien has stowed away on her ship.',
        'EN',
        '7024167e-9da5-4773-bbb0-db7dae9814f7',
        '20th Century Fox',
        'R',
        null,
        '2023-04-15',
        'b439e110-2a07-4c4b-8c86-86dc7b3175d5', -- Preceded by Aliens
        'ec1e1e48-bf0f-4c8a-84ec-19b29d051c2e', -- Followed by Alien: Resurrection
        "159.8 million",
        114,
        '1992-05-22',
        FALSE
    ),
    (
        'ec1e1e48-bf0f-4c8a-84ec-19b29d051c2e',
        1,
        'Alien: Resurrection',
        'Ripley is cloned 200 years after her death, and the alien resurfaces on a military-run space station.',
        'EN',
        '7024167e-9da5-4773-bbb0-db7dae9814f7',
        '20th Century Fox',
        'R',
        null,
        '2023-05-15',
        '7cda4f3e-9cf7-4072-8f1a-77d3df47f9c3', -- Preceded by Alien³
        NULL, -- No sequel planned for Alien: Resurrection
        "161.4 million",
        109,
        '1997-11-26',
        FALSE
    );

--Star Trek
INSERT INTO film (
    id,
    FILM_TYPE,
    TITTLE,
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
        'EN',
        'c8d0fa86-e070-4ee3-985e-208b22554f5d',
        'Paramount Pictures',
        'PG',
        null,
        '2023-02-15',
        NULL, -- No prequel for Star Trek: The Motion Picture
        'b26e4e15-2f86-4d15-abe4-86dc7b3175d5', -- Followed by Star Trek II: The Wrath of Khan
        "139 million",
        132,
        '1979-12-07',
        FALSE
    ),
    (
        'b26e4e15-2f86-4d15-abe4-86dc7b3175d5',
        1,
        'Star Trek II: The Wrath of Khan',
        'Admiral Kirk and the crew of the Enterprise face off against an old adversary seeking revenge.',
        'EN',
        'c8d0fa86-e070-4ee3-985e-208b22554f5d',
        'Paramount Pictures',
        'PG',
        null,
        '2023-03-15',
        '3a2c343a-68db-42aa-9bd4-549b84d4b019', -- Preceded by Star Trek: The Motion Picture
        'b9ef9e52-15ae-46cd-bd24-77d3df47f9c3', -- Followed by Star Trek III: The Search for Spock
        "97 million",
        113,
        '1982-06-04',
        FALSE
    ),
    (
        'b9ef9e52-15ae-46cd-bd24-77d3df47f9c3',
        1,
        'Star Trek III: The Search for Spock',
        'The crew of the Enterprise risks everything to bring Spock back to life and save their ship.',
        'EN',
        'c8d0fa86-e070-4ee3-985e-208b22554f5d',
        'Paramount Pictures',
        'PG',
        null,
        '2023-04-15',
        'b26e4e15-2f86-4d15-abe4-86dc7b3175d5', -- Preceded by Star Trek II: The Wrath of Khan
        'd6bb8b6d-36a4-4b24-a0eb-19b29d051c2e', -- Followed by Star Trek IV: The Voyage Home
        "87 million",
        105,
        '1984-06-01',
        FALSE
    ),
    (
        'd6bb8b6d-36a4-4b24-a0eb-19b29d051c2e',
        1,
        'Star Trek IV: The Voyage Home',
        'The Enterprise crew travels back to 20th-century Earth to save the planet from an alien probe.',
        'EN',
        'c8d0fa86-e070-4ee3-985e-208b22554f5d',
        'Paramount Pictures',
        'PG',
        null,
        '2023-05-15',
        'b9ef9e52-15ae-46cd-bd24-77d3df47f9c3', -- Preceded by Star Trek III: The Search for Spock
        NULL, -- No sequel planned for Star Trek IV: The Voyage Home
        "133 million",
        119,
        '1986-11-26',
        FALSE
    );

--Planet of the Apes
INSERT INTO film (
    id,
    FILM_TYPE,
    TITTLE,
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
        'EN',
        '8703d819-b298-4cb2-8995-cf26099b5bc1',
        '20th Century Fox',
        'G',
        null,
        '2023-02-15',
        NULL, -- No prequel for Planet of the Apes
        '8c535883-8f99-4c8a-8e9b-86dc7b3175d5', -- Followed by Beneath the Planet of the Apes
        "32.6 million",
        112,
        '1968-04-03',
        FALSE
    ),
    (
        '8c535883-8f99-4c8a-8e9b-86dc7b3175d5',
        1,
        'Beneath the Planet of the Apes',
        'Astronauts discover a subterranean human race while trying to rescue a fellow astronaut on the ape-ruled planet.',
        'EN',
        '8703d819-b298-4cb2-8995-cf26099b5bc1',
        '20th Century Fox',
        'G',
        null,
        '2023-03-15',
        'f7a9a1b3-ec1d-4df3-a0fe-549b84d4b019', -- Preceded by Planet of the Apes
        '6c5cf208-7c74-4212-ba2b-77d3df47f9c3', -- Followed by Escape from the Planet of the Apes
        "19 million",
        95,
        '1970-05-26',
        FALSE
    ),
    (
        '6c5cf208-7c74-4212-ba2b-77d3df47f9c3',
        1,
        'Escape from the Planet of the Apes',
        'Two intelligent talking apes travel back in time to Earth, where they become celebrities and face unforeseen challenges.',
        'EN',
        '8703d819-b298-4cb2-8995-cf26099b5bc1',
        '20th Century Fox',
        'G',
        null,
        '2023-04-15',
        '8c535883-8f99-4c8a-8e9b-86dc7b3175d5', -- Preceded by Beneath the Planet of the Apes
        '86a06649-2a4a-4e2e-93fc-19b29d051c2e', -- Followed by Conquest of the Planet of the Apes
        "12.4 million",
        98,
        '1971-05-21',
        FALSE
    ),
    (
        '86a06649-2a4a-4e2e-93fc-19b29d051c2e',
        1,
        'Conquest of the Planet of the Apes',
        'Apes, led by Caesar, rebel against humans after being oppressed and enslaved for years.',
        'EN',
        '8703d819-b298-4cb2-8995-cf26099b5bc1',
        '20th Century Fox',
        'PG',
        null,
        '2023-05-15',
        '6c5cf208-7c74-4212-ba2b-77d3df47f9c3', -- Preceded by Escape from the Planet of the Apes
        'bba13d54-9bd7-4f6b-b963-86dc7b3175d5', -- Followed by Battle for the Planet of the Apes
        "9.7 million",
        88,
        '1972-06-30',
        FALSE
    ),
    (
        'bba13d54-9bd7-4f6b-b963-86dc7b3175d5',
        1,
        'Battle for the Planet of the Apes',
        'Caesar leads a fragile peace between apes and remaining humans, but conflict looms on the horizon.',
        'EN',
        '8703d819-b298-4cb2-8995-cf26099b5bc1',
        '20th Century Fox',
        'G',
        null,
        '2023-06-15',
        '86a06649-2a4a-4e2e-93fc-19b29d051c2e', -- Preceded by Conquest of the Planet of the Apes
        NULL, -- No sequel planned for Battle for the Planet of the Apes
        "8.8 million",
        93,
        '1973-06-15',
        FALSE
    );

--The Bourne
INSERT INTO film (
    id,
    FILM_TYPE,
    TITTLE,
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
        'EN',
        'bfba85e8-f6cc-4cb3-9200-66430dc8da6c',
        'Universal Pictures',
        'PG-13',
        null,
        '2023-02-15',
        NULL, -- No prequel for The Bourne Identity
        '26f59b9c-1020-4da7-b8e8-86dc7b3175d5', -- Followed by The Bourne Supremacy
        "214 million",
        119,
        '2002-06-14',
        FALSE
    ),
    (
        '26f59b9c-1020-4da7-b8e8-86dc7b3175d5',
        1,
        'The Bourne Supremacy',
        'Jason Bourne is framed for a CIA operation gone wrong, and he must clear his name while being hunted by both the agency and assassins.',
        'EN',
        'bfba85e8-f6cc-4cb3-9200-66430dc8da6c',
        'Universal Pictures',
        'PG-13',
        null,
        '2023-03-15',
        '5de7cbb2-2c65-4212-920e-86dc7b3175d5', -- Preceded by The Bourne Identity
        '748376f5-17ec-4a76-8d32-77d3df47f9c3', -- Followed by The Bourne Ultimatum
        "290.7 million",
        108,
        '2004-07-23',
        FALSE
    ),
    (
        '748376f5-17ec-4a76-8d32-77d3df47f9c3',
        1,
        'The Bourne Ultimatum',
        'Jason Bourne continues to uncover his past and faces those responsible for turning him into a trained assassin.',
        'EN',
        'bfba85e8-f6cc-4cb3-9200-66430dc8da6c',
        'Universal Pictures',
        'PG-13',
        null,
        '2023-04-15',
        '26f59b9c-1020-4da7-b8e8-86dc7b3175d5', -- Preceded by The Bourne Supremacy
        '67c7868c-7b6c-4c67-ae71-19b29d051c2e', -- Followed by The Bourne Legacy
        "442.8 million",
        115,
        '2007-08-03',
        FALSE
    ),
    (
        '67c7868c-7b6c-4c67-ae71-19b29d051c2e',
        1,
        'The Bourne Legacy',
        'A new operative, Aaron Cross, must deal with the consequences of Operation Outcome as he becomes a target.',
        'EN',
        'bfba85e8-f6cc-4cb3-9200-66430dc8da6c',
        'Universal Pictures',
        'PG-13',
        null,
        '2023-05-15',
        '748376f5-17ec-4a76-8d32-77d3df47f9c3', -- Preceded by The Bourne Ultimatum
        '7e4e3d92-7bc9-4655-b0b2-19b29d051c2e', -- Followed by Jason Bourne
        "276.1 million",
        135,
        '2012-07-30',
        FALSE
    ),
    (
        '7e4e3d92-7bc9-4655-b0b2-19b29d051c2e',
        1,
        'Jason Bourne',
        'Jason Bourne returns to the world he left behind as he uncovers more hidden truths about his past.',
        'EN',
        'bfba85e8-f6cc-4cb3-9200-66430dc8da6c',
        'Universal Pictures',
        'PG-13',
        null,
        '2023-06-15',
        '67c7868c-7b6c-4c67-ae71-19b29d051c2e', -- Preceded by The Bourne Legacy
        NULL, -- No sequel planned for Jason Bourne
        "415.5 million",
        123,
        '2016-07-29',
        FALSE
    );

--tv series
--breaking bad
INSERT INTO film (
    id, 
    FILM_TYPE, 
    TITTLE, 
    SYNOPSIS, 
    ORIGINAL_LANGUAGE, 
    DISTRIBUTOR, 
    SUITABLE_FOR, 
    COOMING_SOON, 
    STREAMING_RELEASE_DATE, 
    PREQUEL_ID, 
    SEQUEL_ID, 
    SAGA_ID,
    SEASON_NUMBER
)
VALUES
    (
        'b6c3d9c0-bc6c-4a0f-bc2c-5e1bea20b95d', 
        2, 
        'Breaking Bad Season 1', 
        'High school chemistry teacher turned methamphetamine producer faces numerous challenges in the criminal underworld.', 
        'EN', 
        'AMC', 
        'PG-18', 
        null, 
        '2022-01-01', 
        null, 
        'eda4ed07-06db-4da4-bfa6-3b8f8b601d9a', 
        null, 
        1
    ),
    (
        'eda4ed07-06db-4da4-bfa6-3b8f8b601d9a', 
        2, 
        'Breaking Bad Season 2', 
        'Walter White continues his descent into the dangerous world of drug trade, facing new adversaries and moral dilemmas.', 
        'EN', 
        'AMC', 
        'PG-18', 
        null, 
        '2022-02-01',
        'b6c3d9c0-bc6c-4a0f-bc2c-5e1bea20b95d', 
        '6d7b6091-c37d-4d23-a3d1-5e12115ecb25', 
        null, 
        2
    ),
    (
        '6d7b6091-c37d-4d23-a3d1-5e12115ecb25', 
        2, 
        'Breaking Bad Season 3', 
        "Walter White's empire grows, and tensions rise as he faces formidable enemies and internal conflicts.", 
        'EN', 
        'AMC', 
        'PG-18', 
        null, 
        '2022-03-01',
        'eda4ed07-06db-4da4-bfa6-3b8f8b601d9a', 
        'c26da0d8-9d8c-48df-8f5a-c19be5c4ff7d', 
        null, 
        3
    ),
    (
        'c26da0d8-9d8c-48df-8f5a-c19be5c4ff7d', 
        2, 
        'Breaking Bad Season 4', 
        'The battle for control intensifies as Walter White faces off against a powerful adversary in a high-stakes game.', 
        'EN', 
        'AMC', 
        'PG-18', 
        null, 
        '2022-04-01', 
        'c26da0d8-9d8c-48df-8f5a-c19be5c4ff7d',
        'f0a82e48-29e9-4fb0-9244-fc2a4c9d22e6', 
        null, 
        4
    ),
    (
        'f0a82e48-29e9-4fb0-9244-fc2a4c9d22e6', 
        2, 
        'Breaking Bad Season 5', 
        "Walter White's transformation is complete as he confronts the consequences of his actions and battles old foes.", 
        'EN', 
        'AMC', 
        'PG-18', 
        null,  
        '2022-05-01', 
        'c26da0d8-9d8c-48df-8f5a-c19be5c4ff7d', 
        null, 
        null, 
        5
    );

--chernobyl
INSERT INTO film (
    id, 
    FILM_TYPE, 
    TITTLE, 
    SYNOPSIS, 
    ORIGINAL_LANGUAGE, 
    DISTRIBUTOR, 
    SUITABLE_FOR, 
    COOMING_SOON, 
    STREAMING_RELEASE_DATE, 
    PREQUEL_ID, 
    SEQUEL_ID, 
    SAGA_ID,
    SEASON_NUMBER
)
VALUES
    ('c3a21162-6d67-44d0-af0a-1d493e7f4b61', 2, 'Chernobyl', 'Dramatization of the 1986 Chernobyl nuclear disaster and its aftermath, focusing on the heroes who risked their lives to save others.', 'EN', 'HBO', 'PG-18', null, '2022-06-01', null, null, null, 1);

--better call saul
INSERT INTO film (
    id, 
    FILM_TYPE, 
    TITTLE,
    SYNOPSIS, 
    ORIGINAL_LANGUAGE, 
    DISTRIBUTOR, 
    SUITABLE_FOR, 
    COOMING_SOON, 
    STREAMING_RELEASE_DATE, 
    PREQUEL_ID, 
    SEQUEL_ID, 
    SAGA_ID,
    SEASON_NUMBER
)
VALUES
    ('f04d758d-32ae-42a8-9e5c-44d96a7fb89c', 
    2, 
    'Better Call Saul Season 1', 
    'Prequel to Breaking Bad, Better Call Saul follows the transformation of Jimmy McGill, a small-time lawyer hustling to champion his underdog clients, build his practice, and come to terms with his brother’s shaky morality.', 
    'EN', 
    'AMC', 
    'PG-18', 
    null, 
    '2022-07-01', 
    null, 
    '1c52e5f3-6c01-4f7f-89f2-e1c1936f51cc', 
    null, 
    1
    ),
    ('1c52e5f3-6c01-4f7f-89f2-e1c1936f51cc', 
    2, 
    'Better Call Saul Season 2', 
    'Jimmy McGill navigates the complex legal world and faces personal challenges as he inches closer to becoming the infamous lawyer Saul Goodman.', 
    'EN', 
    'AMC', 
    'PG-18', 
    null, 
    '2022-08-01', 
    'f04d758d-32ae-42a8-9e5c-44d96a7fb89c',
    'a7b41f4e-13b1-4c21-a5db-2093d317e1f9', 
    null, 
    2
    ),
    ('a7b41f4e-13b1-4c21-a5db-2093d317e1f9', 
    2, 
    'Better Call Saul Season 3', 
    'As Jimmy McGill becomes Saul Goodman, the legal and personal stakes get higher, and connections to Breaking Bad become more evident.', 
    'EN', 
    'AMC', 
    'PG-18', 
    null, 
    '2022-09-01', 
    '1c52e5f3-6c01-4f7f-89f2-e1c1936f51cc', 
    '268186cc-b927-4c50-9d56-9f78a7d72f24',
    null, 
    3
    ),
    ('268186cc-b927-4c50-9d56-9f78a7d72f24', 
    2, 
    'Better Call Saul Season 4', 
    'Jimmy McGill faces more moral dilemmas as Saul Goodman while the world around him changes, setting the stage for Breaking Bad.', 
    'EN', 
    'AMC', 
    'PG-18', 
    null, 
    '2022-10-01', 
    'a7b41f4e-13b1-4c21-a5db-2093d317e1f9', 
    'b4e5a85e-96ab-46af-b2a7-809ae7e89f7e',
    null, 
    4
    ),
    ('b4e5a85e-96ab-46af-b2a7-809ae7e89f7e', 
    2, 
    'Better Call Saul Season 5', 
    "Jimmy McGill's transformation into Saul Goodman accelerates, and the series approaches the events of Breaking Bad.", 
    'EN', 
    'AMC', 
    'PG-18', 
    null, 
    '2022-11-01', 
    '268186cc-b927-4c50-9d56-9f78a7d72f24', 
    null,
    null, 
    5
    );

    --Narcos
INSERT INTO film (
    id, 
    FILM_TYPE, 
    TITTLE,
    SYNOPSIS, 
    ORIGINAL_LANGUAGE, 
    DISTRIBUTOR, 
    SUITABLE_FOR, 
    COOMING_SOON, 
    STREAMING_RELEASE_DATE, 
    PREQUEL_ID, 
    SEQUEL_ID, 
    SAGA_ID,
    SEASON_NUMBER
)
VALUES
    ('d575487f-c9a2-4d42-b4b9-5c22a7167484',
    2,
    'Narcos Season 1',
    'Based on true events, Narcos follows the rise and fall of notorious drug lord Pablo Escobar and the DEA agents trying to bring him to justice.',
    'EN',
    'Netflix',
    'PG-18',
    null,
    '2023-01-01',
    null,
    '7430c5db-62d1-4387-b699-50b93a68eaab',
    null,
    1
    ),
    ('7430c5db-62d1-4387-b699-50b93a68eaab',
    2,
    'Narcos Season 2',
    'The hunt for Pablo Escobar intensifies as the DEA faces new challenges, and the drug trade continues to evolve in Colombia.',
    'EN',
    'Netflix',
    'PG-18',
    null,
    '2023-02-01',
    'd575487f-c9a2-4d42-b4b9-5c22a7167484',
    '6d4e91ab-549f-4db1-a8b2-8cfa351f646b',
    null,
    2
    ),
    ('6d4e91ab-549f-4db1-a8b2-8cfa351f646b',
    2,
    'Narcos Season 3',
    'As the Cali Cartel rises to power, DEA agents work to dismantle the organization and bring its leaders to justice.',
    'EN',
    'Netflix',
    'PG-18',
    null,
    '2023-03-01',
    '7430c5db-62d1-4387-b699-50b93a68eaab',
    'f319f4ae-36bb-4fc2-9d23-6c7227222c10',
    null,
    3
    ),
    ('f319f4ae-36bb-4fc2-9d23-6c7227222c10',
    2,
    'Narcos Season 4',
    "The focus shifts to the Mexican drug trade, exploring the rise of the Guadalajara Cartel and the DEA's efforts to combat it.",
    'EN',
    'Netflix',
    'PG-18',
    null,
    '2023-04-01',
    '6d4e91ab-549f-4db1-a8b2-8cfa351f646b',
    'd39d1af7-5f17-45d3-9e21-8d10a10469a9',
    null,
    4
    ),
    ('d39d1af7-5f17-45d3-9e21-8d10a10469a9',
    2,
    'Narcos Season 5',
    'The war on drugs continues as new players enter the scene, and law enforcement faces unprecedented challenges in the pursuit of justice.',
    'EN',
    'Netflix',
    'PG-18',
    null,
    '2023-05-01',
    'f319f4ae-36bb-4fc2-9d23-6c7227222c10',
    null,
    null,
    5
    );

    --black mirror
INSERT INTO film (
    id, 
    FILM_TYPE, 
    TITTLE, 
    SYNOPSIS, 
    ORIGINAL_LANGUAGE, 
    DISTRIBUTOR, 
    SUITABLE_FOR, 
    COOMING_SOON, 
    STREAMING_RELEASE_DATE, 
    PREQUEL_ID, 
    SEQUEL_ID, 
    SAGA_ID,
    SEASON_NUMBER
) VALUES 
    (
        'f7b5e49b-051c-4bda-b2e0-bfb7c4ed11ea',
        2,
        'Black Mirror Season 1',
        'A series of standalone dramas exploring the dark and often dystopian aspects of modern society and technology.', 
        'EN', 
        'Netflix', 
        'PG-18', 
        NULL, 
        '2023-06-01', 
        NULL, 
        '8c88d60f-565d-4e85-a68c-efb5b8c92023', 
        NULL, 
        1
    ),
    ('8c88d60f-565d-4e85-a68c-efb5b8c92023',
     2,
      'Black Mirror Season 2',
       'Continuation of standalone dramas, each episode presenting a different story and perspective on the impact of technology on society.', 
       'EN', 'Netflix', 'PG-18', NULL, '2023-07-01', 'f7b5e49b-051c-4bda-b2e0-bfb7c4ed11ea', 'a2492d67-231a-4ac3-8a02-bf387cc6a7e5', NULL, 2),
    ('a2492d67-231a-4ac3-8a02-bf387cc6a7e5',
     2,
      'Black Mirror Season 3',
       'Further exploration of the dark and thought-provoking themes related to technology and its effects on humanity.', 
       'EN', 'Netflix', 'PG-18', NULL, '2023-08-01', '8c88d60f-565d-4e85-a68c-efb5b8c92023', '77c40f8b-4b72-4ea9-b0a3-2a9a5dd104bf', NULL, 3),
    ('77c40f8b-4b72-4ea9-b0a3-2a9a5dd104bf',
     2,
      'Black Mirror Season 4',
       'New standalone stories that delve into the potential consequences and ethical dilemmas arising from advancements in technology.', 
       'EN', 'Netflix', 'PG-18', NULL, '2023-09-01', 'a2492d67-231a-4ac3-8a02-bf387cc6a7e5', NULL, NULL, 4);

--peaky blinders
INSERT INTO film (
    id, 
    FILM_TYPE, 
    TITTLE, 
    SYNOPSIS, 
    ORIGINAL_LANGUAGE, 
    DISTRIBUTOR, 
    SUITABLE_FOR, 
    COOMING_SOON, 
    STREAMING_RELEASE_DATE, 
    PREQUEL_ID, 
    SEQUEL_ID, 
    SAGA_ID,
    SEASON_NUMBER
) VALUES 
    ('cfe41c49-4c5e-4a56-b5cc-99a82b3b3c60', 2, 'Peaky Blinders Season 1', 
    'Set in post-World War I Birmingham, the Shelby crime family, known as the Peaky Blinders, rises to power amidst social and political turmoil.', 'EN', 'BBC', 'PG-18', NULL, '2024-01-01', 
    NULL, '6b4824f1-c55c-45d2-a5b9-040e2ab05ce6', NULL, 1),
    ('6b4824f1-c55c-45d2-a5b9-040e2ab05ce6', 2, 'Peaky Blinders Season 2', 
    'The Shelby family faces new challenges as they expand their empire and clash with powerful enemies in the world of organized crime.', 'EN', 'BBC', 'PG-18', NULL, '2024-02-01', 
    'cfe41c49-4c5e-4a56-b5cc-99a82b3b3c60', '44b653f4-6269-4cb2-a145-df41ec7bb44f', NULL, 2),
    ('44b653f4-6269-4cb2-a145-df41ec7bb44f', 2, 'Peaky Blinders Season 3', 'As the Shelby family solidifies its control, they face internal and external threats, leading to betrayals and power struggles.', 'EN', 'BBC', 'PG-18', NULL, '2024-03-01', 
    '6b4824f1-c55c-45d2-a5b9-040e2ab05ce6', '5569c74b-05b0-4c9e-b48a-9d6eac14f354', NULL, 3),
    ('5569c74b-05b0-4c9e-b48a-9d6eac14f354', 2, 'Peaky Blinders Season 4', 'The Shelby empire faces its most dangerous adversaries yet, testing the loyalty and cunning of its members.', 'EN', 'BBC', 'PG-18', NULL, '2024-04-01', 
    '44b653f4-6269-4cb2-a145-df41ec7bb44f', NULL, NULL, 4);

--dr house
INSERT INTO film (
    id, 
    FILM_TYPE, 
    TITTLE, 
    SYNOPSIS, 
    ORIGINAL_LANGUAGE, 
    DISTRIBUTOR, 
    SUITABLE_FOR, 
    COOMING_SOON, 
    STREAMING_RELEASE_DATE, 
    PREQUEL_ID, 
    SEQUEL_ID, 
    SAGA_ID,
    SEASON_NUMBER
) VALUES 
    ('c22f5d36-c2eb-47ef-92c5-8a8e25e0b4eb', 2, 'Dr. House Season 1', 'Dr. Gregory House, a brilliant but unconventional medical genius, leads his team in solving mysterious and complex medical cases at Princeton-Plainsboro Teaching Hospital.', 'EN', 'Fox', 'PG-18', NULL, '2024-05-01', 
    NULL, 'c79f2a54-650a-4e2f-bb77-6c34320ccf5f', NULL, 1),

    ('c79f2a54-650a-4e2f-bb77-6c34320ccf5f', 2, 'Dr. House Season 2', 'Dr. House continues to navigate the challenges of diagnosing rare illnesses while dealing with his own personal struggles and the dynamics of his medical team.', 'EN', 'Fox', 'PG-18', NULL, '2024-06-01', 
    'c22f5d36-c2eb-47ef-92c5-8a8e25e0b4eb', '828a7daa-7c15-4bb2-b7b7-20715a9f59b9', NULL, 2),

    ('828a7daa-7c15-4bb2-b7b7-20715a9f59b9', 2, 'Dr. House Season 3', 'The medical mysteries intensify as Dr. House confronts new ethical dilemmas and faces the consequences of his unconventional methods.', 'EN', 'Fox', 'PG-18', NULL, '2024-07-01', 
    'c79f2a54-650a-4e2f-bb77-6c34320ccf5f', '9a5f81e2-19f9-4bf7-8f8b-5a676fe243fb', NULL, 3),

    ('9a5f81e2-19f9-4bf7-8f8b-5a676fe243fb', 2, 'Dr. House Season 4', "Dr. House's brilliance is put to the test as he tackles complex cases, all while dealing with changes within the hospital and his own team.", 'EN', 'Fox', 'PG-18', NULL, '2024-08-01', 
    '828a7daa-7c15-4bb2-b7b7-20715a9f59b9', NULL, NULL, 4);

--the boys
INSERT INTO film (
    id, 
    FILM_TYPE, 
    TITTLE,
    SYNOPSIS, 
    ORIGINAL_LANGUAGE, 
    DISTRIBUTOR, 
    SUITABLE_FOR, 
    COOMING_SOON, 
    STREAMING_RELEASE_DATE, 
    PREQUEL_ID, 
    SEQUEL_ID, 
    SAGA_ID,
    SEASON_NUMBER
) VALUES 
    ('684319f5-e7b0-4393-9ce3-f6c9dd5ef8f5', 2, 'The Boys Season 1', 'In a world where superheroes abuse their powers, a group of vigilantes, known as The Boys, set out to expose and take down corrupt and arrogant superheroes.', 'EN', 'Amazon Prime Video', 'PG-18', NULL, '2024-09-01', 
    NULL, 'fb80c748-54f0-45cd-a51f-09baf2daaa5d', NULL, 1),

    ('fb80c748-54f0-45cd-a51f-09baf2daaa5d', 2, 'The Boys Season 2', 'The conflict between The Boys and the powerful superhero corporation intensifies as new characters are introduced, and secrets are revealed.', 'EN', 'Amazon Prime Video', 'PG-18', NULL, '2024-10-01', 
    '684319f5-e7b0-4393-9ce3-f6c9dd5ef8f5', '6f9b4c6c-964d-4e4a-878f-af0d0d951a12', NULL, 2),

    ('6f9b4c6c-964d-4e4a-878f-af0d0d951a12', 2, 'The Boys Season 3', 'The Boys face even greater challenges as they uncover a deeper conspiracy involving the origins of superpowers and the true nature of the superhero industry.', 'EN', 'Amazon Prime Video', 'PG-18', NULL, '2024-11-01', 
    'fb80c748-54f0-45cd-a51f-09baf2daaa5d', NULL, NULL, 3);

--twd
INSERT INTO film (
    id, 
    FILM_TYPE, 
    TITTLE,
    SYNOPSIS, 
    ORIGINAL_LANGUAGE, 
    DISTRIBUTOR, 
    SUITABLE_FOR, 
    COOMING_SOON, 
    STREAMING_RELEASE_DATE, 
    PREQUEL_ID, 
    SEQUEL_ID, 
    SAGA_ID,
    SEASON_NUMBER
) VALUES 
    ('04a1dab2-3eb4-4ed7-9378-6848b0a6e0cf', 2, 'The Walking Dead Season 1', 'Sheriff Rick Grimes wakes up from a coma to find a world overrun by zombies. He leads a group of survivors in a quest for safety and survival.', 'EN', 'AMC', 'PG-18', NULL, '2024-12-01', 
    NULL, 'cfd09a72-3b72-4a57-9164-694078c9c196', NULL, 1),

    ('cfd09a72-3b72-4a57-9164-694078c9c196', 2, 'The Walking Dead Season 2', 'The group faces new challenges as they encounter other survivor communities, discovering that the living can be just as dangerous as the undead.', 'EN', 'AMC', 'PG-18', NULL, '2025-01-01', 
    '04a1dab2-3eb4-4ed7-9378-6848b0a6e0cf', 'c78fe5f4-5da5-4be7-98b8-7fe06e3f3273', NULL, 2),

    ('c78fe5f4-5da5-4be7-98b8-7fe06e3f3273', 2, 'The Walking Dead Season 3', 'Conflict with other survivor groups and the threat of a hostile new world order pose challenges to the group as they strive for a semblance of civilization.', 'EN', 'AMC', 'PG-18', NULL, '2025-02-01', 
    'cfd09a72-3b72-4a57-9164-694078c9c196', '881b150f-9ad5-44c5-aa9a-414f17424c89', NULL, 3),

    ('881b150f-9ad5-44c5-aa9a-414f17424c89', 2, 'The Walking Dead Season 4', 'The survivors face not only the undead but also internal conflicts as they try to rebuild society and find a sense of normalcy in a post-apocalyptic world.', 'EN', 'AMC', 'PG-18', NULL, '2025-03-01', 
    'c78fe5f4-5da5-4be7-98b8-7fe06e3f3273', NULL, NULL, 4),

    ('f371b194-38cd-4961-936b-9c913a00e849', 2, 'The Walking Dead Season 5', 'The group faces new threats, including hostile survivor communities and the mysterious Wolves, as they continue their journey for safety and a new home.', 'EN', 'AMC', 'PG-18', NULL, '2025-04-01', 
    '881b150f-9ad5-44c5-aa9a-414f17424c89', 'b431dbbf-cd42-4a53-909b-e6a72f28178b', NULL, 5),

    ('b431dbbf-cd42-4a53-909b-e6a72f28178b', 2, 'The Walking Dead Season 6', 'The survivors try to build a new society in the Alexandria Safe-Zone, but conflicts arise both from within and external threats, leading to a power struggle.', 'EN', 'AMC', 'PG-18', NULL, '2025-05-01', 
    'f371b194-38cd-4961-936b-9c913a00e849', 'e07f64a2-7471-4b19-b042-3d7cb4d2a5d2', NULL, 6),

    ('e07f64a2-7471-4b19-b042-3d7cb4d2a5d2', 2, 'The Walking Dead Season 7', 'Facing the tyrannical rule of Negan and his group, the survivors must find ways to resist and fight back, all while dealing with personal losses and sacrifices.', 'EN', 'AMC', 'PG-18', NULL, '2025-06-01', 
    'b431dbbf-cd42-4a53-909b-e6a72f28178b', NULL, NULL, 7),

    ('99e7b926-d3ec-46b3-8909-26eb5db31df1', 2, 'The Walking Dead Season 8', 'The war against Negan and the Saviors reaches its climax, leading to major confrontations and the retribution of past actions.', 'EN', 'AMC', 'PG-18', NULL, '2025-07-01', 
    'e07f64a2-7471-4b19-b042-3d7cb4d2a5d2', 'ef51b1cf-5970-4a26-8de7-6f176469c2de', NULL, 8),

    ('ef51b1cf-5970-4a26-8de7-6f176469c2de', 2, 'The Walking Dead Season 9', 'After the war, the survivors face new challenges, including the mysterious Whisperers and the struggle to rebuild civilization in a world overrun by the undead.', 'EN', 'AMC', 'PG-18', NULL, '2025-08-01', 
    '99e7b926-d3ec-46b3-8909-26eb5db31df1', 'aad6d831-ee4d-42d1-82c5-f86f6339619c', NULL, 9),

    ('aad6d831-ee4d-42d1-82c5-f86f6339619c', 2, 'The Walking Dead Season 10', 'The survivors confront the Whisperer threat, and as tensions rise, they must decide how far they are willing to go to protect their way of life and the future.', 'EN', 'AMC', 'PG-18', NULL, '2025-09-01', 
    'ef51b1cf-5970-4a26-8de7-6f176469c2de', NULL, NULL, 10);

--the office
INSERT INTO film (
    id, 
    FILM_TYPE, 
    TITTLE, 
    SYNOPSIS, 
    ORIGINAL_LANGUAGE, 
    DISTRIBUTOR, 
    SUITABLE_FOR, 
    COOMING_SOON, 
    STREAMING_RELEASE_DATE, 
    PREQUEL_ID, 
    SEQUEL_ID, 
    SAGA_ID,
    SEASON_NUMBER
) VALUES 
    ('a15d5a1a-3306-4e13-8e8d-9460ac68f2e6', 2, 'The Office Season 1', 'A mockumentary-style sitcom that follows the daily lives of office employees working at Dunder Mifflin Paper Company, featuring the quirky and eccentric regional manager Michael Scott.', 'EN', 'NBC', 'PG-13', NULL, '2025-10-01', 
    NULL, '4996a258-2d3e-4d3d-a3ea-8c4bd69c73e3', NULL, 1),

    ('4996a258-2d3e-4d3d-a3ea-8c4bd69c73e3', 2, 'The Office Season 2', 'The employees of Dunder Mifflin navigate office politics, love interests, and bizarre team-building exercises while Michael continues to manage the branch in his unique style.', 'EN', 'NBC', 'PG-13', NULL, '2025-11-01', 
    'a15d5a1a-3306-4e13-8e8d-9460ac68f2e6', 'c18b6fe7-3f13-4d1c-8299-7556f09742d9', NULL, 2),

    ('c18b6fe7-3f13-4d1c-8299-7556f09742d9', 2, 'The Office Season 3', 'The Scranton branch faces challenges with new management, office romances, and unexpected departures, creating comedic and heartfelt moments for the employees.', 'EN', 'NBC', 'PG-13', NULL, '2025-12-01', 
    '4996a258-2d3e-4d3d-a3ea-8c4bd69c73e3', 'ab1e3dd0-3c6a-4d06-b5da-4a993d6222b8', NULL, 3),

    ('ab1e3dd0-3c6a-4d06-b5da-4a993d6222b8', 2, 'The Office Season 4', "The employees embark on new adventures, including Jim and Pam's relationship developments, Michael's departure, and the introduction of new characters.", 'EN', 'NBC', 'PG-13', NULL, '2026-01-01', 
    'c18b6fe7-3f13-4d1c-8299-7556f09742d9', 'af1de44d-465c-49c0-86db-1dab04f34c31', NULL, 4),

    ('af1de44d-465c-49c0-86db-1dab04f34c31', 2, 'The Office Season 5', 'The Scranton branch undergoes changes in leadership, and characters face personal and professional growth, all while maintaining the unique and humorous workplace environment.', 'EN', 'NBC', 'PG-13', NULL, '2026-02-01', 
    'ab1e3dd0-3c6a-4d06-b5da-4a993d6222b8', NULL, NULL, 5),

    ('5f5d260d-fffd-4bc7-9f68-3d9d1b450146', 2, 'The Office Season 6', 'The employees navigate corporate buyouts, new romances, and the challenges of working in an increasingly digital world, resulting in more hilarious and heartwarming moments.', 'EN', 'NBC', 'PG-13', NULL, '2026-03-01', 
    'af1de44d-465c-49c0-86db-1dab04f34c31', '5a78c864-90da-4aa6-bd89-0195101f9331', NULL, 6),

    ('5a78c864-90da-4aa6-bd89-0195101f9331', 2, 'The Office Season 7', 'As the characters face the uncertainties of the job market and changes within the company, they continue to find humor and camaraderie in the everyday challenges of office life.', 'EN', 'NBC', 'PG-13', NULL, '2026-04-01', 
    '5f5d260d-fffd-4bc7-9f68-3d9d1b450146', '6b7f1c19-b91e-415f-8d74-f733958b5e8f', NULL, 7),

    ('6b7f1c19-b91e-415f-8d74-f733958b5e8f', 2, 'The Office Season 8', 'With new faces and a shift in dynamics, the employees adapt to changes in the workplace while maintaining the comedic essence that has defined the series.', 'EN', 'NBC', 'PG-13', NULL, '2026-05-01', 
    '5a78c864-90da-4aa6-bd89-0195101f9331', '6c917b1c-c96b-4c5d-8439-2b0789386234', NULL, 8),

    ('6c917b1c-c96b-4c5d-8439-2b0789386234', 2, 'The Office Season 9', "In the final season, the characters reflect on their time at Dunder Mifflin, facing challenges and embracing new opportunities as the series comes to a heartfelt conclusion.", 'EN', 'NBC', 'PG-13', NULL, '2026-06-01', 
    '6b7f1c19-b91e-415f-8d74-f733958b5e8f', NULL, NULL, 9);

--got
INSERT INTO film (
    id,
    FILM_TYPE,
    TITTLE,
    SYNOPSIS,
    ORIGINAL_LANGUAGE,
    DISTRIBUTOR,
    SUITABLE_FOR,
    COOMING_SOON,
    STREAMING_RELEASE_DATE,
    PREQUEL_ID,
    SEQUEL_ID,
    SAGA_ID,
    SEASON_NUMBER
) VALUES
    ('f05a3c5c-099b-4c1a-8f01-0413f2cc9c6c', 2, 'Game of Thrones Season 1', 'Noble families vie for control of the Seven Kingdoms of Westeros as an ancient threat awakens beyond the Wall. Intrigue, betrayal, and epic battles shape the fate of the realm.', 'EN', 'HBO', 'PG-18', NULL, '2027-01-01',
    NULL, 'f5cc1ec3-c0c5-4f29-99bf-6b012ff876bf', NULL, 1),

    ('f5cc1ec3-c0c5-4f29-99bf-6b012ff876bf', 2, 'Game of Thrones Season 2', 'War rages across Westeros as the Seven Kingdoms face external and internal threats. Loyalties are tested, alliances crumble, and new players enter the deadly game of thrones.', 'EN', 'HBO', 'PG-18', NULL, '2027-02-01',
    'f05a3c5c-099b-4c1a-8f01-0413f2cc9c6c', 'f3f5b32a-2c1b-4b11-94aa-7a3a156cc4b0', NULL, 2),

    ('f3f5b32a-2c1b-4b11-94aa-7a3a156cc4b0', 2, 'Game of Thrones Season 3', 'The War of the Five Kings escalates, and ancient powers return to the forefront. Betrayals, weddings, and shocking deaths shape the power dynamics of Westeros.', 'EN', 'HBO', 'PG-18', NULL, '2027-03-01',
    'f5cc1ec3-c0c5-4f29-99bf-6b012ff876bf', 'a82f9cd3-54b8-45d2-b3e3-4df1ecad0c0c', NULL, 3),

    ('a82f9cd3-54b8-45d2-b3e3-4df1ecad0c0c', 2, 'Game of Thrones Season 4', 'The power struggle continues with new alliances and betrayals. As threats converge on Westeros, the destiny of key characters is shaped in unexpected ways.', 'EN', 'HBO', 'PG-18', NULL, '2027-04-01',
    'f3f5b32a-2c1b-4b11-94aa-7a3a156cc4b0', 'ed32cb68-6763-4d8a-8f49-b6e7cc633f4b', NULL, 4),

    ('ed32cb68-6763-4d8a-8f49-b6e7cc633f4b', 2, 'Game of Thrones Season 5', 'As political tensions escalate and magic resurfaces, characters face their most challenging decisions yet. Battles for power and survival reach a climax across the continents.', 'EN', 'HBO', 'PG-18', NULL, '2027-05-01',
    'a82f9cd3-54b8-45d2-b3e3-4df1ecad0c0c', 'aff9f4a0-e086-4f44-8ba2-90768f90daa9', NULL, 5),

    ('aff9f4a0-e086-4f44-8ba2-90768f90daa9', 2, 'Game of Thrones Season 6', 'The battle for the Iron Throne intensifies, and the threat from the North grows. Secrets are revealed, alliances are forged, and destinies are fulfilled in a season of shocking revelations.', 'EN', 'HBO', 'PG-18', NULL, '2027-06-01',
    'ed32cb68-6763-4d8a-8f49-b6e7cc633f4b', '9935dca3-45b1-4ef6-9d9f-b9501ee3b4ad', NULL, 6),

    ('9935dca3-45b1-4ef6-9d9f-b9501ee3b4ad', 2, 'Game of Thrones Season 7', 'The great war between the living and the dead begins, while political intrigue and power struggles continue. Alliances are tested, and the fate of Westeros hangs in the balance.', 'EN', 'HBO', 'PG-18', NULL, '2027-07-01',
    'aff9f4a0-e086-4f44-8ba2-90768f90daa9', 'a218a9e8-5a10-4e89-9b85-3cfedc5a453a', NULL, 7),

    ('a218a9e8-5a10-4e89-9b85-3cfedc5a453a', 2, 'Game of Thrones Season 8', 'The final season sees the ultimate showdown for the Iron Throne as characters face the consequences of their actions. The fate of Westeros is decided in an epic conclusion.', 'EN', 'HBO', 'PG-18', NULL, '2027-08-01',
    '9935dca3-45b1-4ef6-9d9f-b9501ee3b4ad', NULL, NULL, 8);

--vikings
INSERT INTO film (
    id, 
    FILM_TYPE, 
    TITTLE, 
    SYNOPSIS, 
    ORIGINAL_LANGUAGE, 
    DISTRIBUTOR, 
    SUITABLE_FOR, 
    COOMING_SOON, 
    STREAMING_RELEASE_DATE, 
    PREQUEL_ID, 
    SEQUEL_ID, 
    SAGA_ID,
    SEASON_NUMBER
) VALUES 
    ('95c9366a-9200-45e3-890f-6e1c28d6f25d', 2, 'Vikings Season 1', 'The legendary Viking chieftain Ragnar Lothbrok rises to prominence through conquests and exploration. His journey is marked by ambition, betrayal, and the pursuit of new lands.', 'EN', 'History Channel', 'PG-18', NULL, '2027-09-01', 
    NULL, 'ab89d342-2e8e-4a6f-93f5-3ef8c12f6ef6', NULL, 1),

    ('ab89d342-2e8e-4a6f-93f5-3ef8c12f6ef6', 2, 'Vikings Season 2', 'Ragnar continues his quest for power and exploration, facing challenges from within his own family and external forces. As the Vikings expand their influence, conflicts intensify.', 'EN', 'History Channel', 'PG-18', NULL, '2027-10-01', 
    '95c9366a-9200-45e3-890f-6e1c28d6f25d', '0ff94b49-31eb-4d66-b376-6e06c469c54d', NULL, 2),

    ('0ff94b49-31eb-4d66-b376-6e06c469c54d', 2, 'Vikings Season 3', 'Ragnar faces new adversaries and personal challenges as he seeks to secure his legacy. The Vikings explore distant lands, encountering both allies and enemies on their journeys.', 'EN', 'History Channel', 'PG-18', NULL, '2027-11-01', 
    'ab89d342-2e8e-4a6f-93f5-3ef8c12f6ef6', '85863f6d-df96-48fb-b7c4-1be67c05a68c', NULL, 3),

    ('85863f6d-df96-48fb-b7c4-1be67c05a68c', 2, 'Vikings Season 4', "The Viking leaders face internal conflicts and external threats, leading to significant battles and political maneuvering. As Ragnar's legacy unfolds, new leaders emerge.", 'EN', 'History Channel', 'PG-18', NULL, '2027-12-01', 
    '0ff94b49-31eb-4d66-b376-6e06c469c54d', 'a625eeb7-5a79-4d89-8a8b-d2a411d3ef32', NULL, 4),

    ('a625eeb7-5a79-4d89-8a8b-d2a411d3ef32', 2, 'Vikings Season 5', "With Ragnar's death, his sons lead the Vikings in new directions. Battles for power, revenge, and exploration shape the destiny of the Norsemen in a time of great upheaval.", 'EN', 'History Channel', 'PG-18', NULL, '2028-01-01', 
    '85863f6d-df96-48fb-b7c4-1be67c05a68c', 'bd7d9ab2-4193-4142-a31d-37dbd5f35b9d', NULL, 5),

    ('bd7d9ab2-4193-4142-a31d-37dbd5f35b9d', 2, 'Vikings Season 6', 'In the final season, the saga of the Vikings concludes with the adventures of Bjorn Ironside and the exploration of new lands. The series culminates in the legacy of the legendary Viking heroes.', 'EN', 'History Channel', 'PG-18', NULL, '2028-02-01', 
    'a625eeb7-5a79-4d89-8a8b-d2a411d3ef32', NULL, NULL, 6);

--loki
INSERT INTO film (
    id, 
    FILM_TYPE, 
    TITTLE, 
    SYNOPSIS, 
    ORIGINAL_LANGUAGE, 
    DISTRIBUTOR, 
    SUITABLE_FOR, 
    COOMING_SOON, 
    STREAMING_RELEASE_DATE, 
    PREQUEL_ID, 
    SEQUEL_ID, 
    SAGA_ID,
    SEASON_NUMBER
) VALUES 
    ('f43a8625-1f48-4c5f-8979-228e7fe97421', 2, 'Loki Season 1', 'After escaping with the Tesseract during the events of Avengers: Endgame, Loki becomes embroiled in the bureaucratic workings of the Time Variance Authority (TVA). As he navigates time and space, he faces unexpected challenges and threats.', 'EN', 'Disney+', 'PG-13', NULL, '2028-03-01', NULL, '437e8916-4f33-4d20-b4cd-08ed314e5bf5', NULL, 1),
    ('437e8916-4f33-4d20-b4cd-08ed314e5bf5', 2, 'Loki Season 2', 'The God of Mischief continues his adventures across the multiverse, encountering alternate versions of himself and uncovering the mysteries of the TVA. As the fabric of reality unravels, Loki faces his greatest challenges.', 'EN', 'Disney+', 'PG-13', NULL, '2028-04-01', 'f43a8625-1f48-4c5f-8979-228e7fe97421', NULL, NULL, 2);

--Reacher
INSERT INTO film (
    id, 
    FILM_TYPE, 
    TITTLE, 
    SYNOPSIS, 
    ORIGINAL_LANGUAGE, 
    DISTRIBUTOR, 
    SUITABLE_FOR, 
    COOMING_SOON, 
    STREAMING_RELEASE_DATE, 
    PREQUEL_ID, 
    SEQUEL_ID, 
    SAGA_ID,
    SEASON_NUMBER
) VALUES 
    ('227a1b57-963c-4dd4-8d6d-0f82317fbafc', 2, 'Reacher Season 1', "Former Military Police Major Jack Reacher travels the United States, solving crimes and dispensing justice. His formidable skills and sense of justice make him a formidable force against wrongdoers.", 'EN', 'Amazon Prime Video', 'PG-18', NULL, '2028-05-01', NULL, 'b2b2f4cb-79cb-48b9-b39d-ba8f238cf04d', NULL, 1),
    ('b2b2f4cb-79cb-48b9-b39d-ba8f238cf04d', 2, 'Reacher Season 2', "Jack Reacher continues his journey, uncovering conspiracies and facing dangerous adversaries. As he delves into the criminal underworld, Reacher's quest for justice takes unexpected turns.", 'EN', 'Amazon Prime Video', 'PG-18', NULL, '2028-06-01', '227a1b57-963c-4dd4-8d6d-0f82317fbafc', NULL, NULL, 2);

--lucifer
INSERT INTO film (
    id, 
    FILM_TYPE, 
    TITTLE, 
    SYNOPSIS, 
    ORIGINAL_LANGUAGE, 
    DISTRIBUTOR, 
    SUITABLE_FOR, 
    COOMING_SOON, 
    STREAMING_RELEASE_DATE, 
    PREQUEL_ID, 
    SEQUEL_ID, 
    SAGA_ID,
    SEASON_NUMBER
) VALUES 
    ('2352e9c5-0cd3-4b3f-8831-4f8da62cc88c', 2, 'Lucifer Season 1', 'Lucifer Morningstar, bored with his life as the Devil in Hell, decides to retire to Los Angeles. There, he becomes a consultant for the LAPD and uses his supernatural abilities to solve crimes.', 'EN', 'Netflix', 'PG-18', NULL, '2028-07-01',
     NULL, 'cfd09994-d32e-4903-87a2-86e373906e7c', NULL, 1),

    ('cfd09994-d32e-4903-87a2-86e373906e7c', 2, 'Lucifer Season 2', 'Lucifer faces new challenges as celestial and demonic forces threaten the balance. Meanwhile, his relationships with humans, including LAPD detective Chloe Decker, become more complicated.', 'EN', 'Netflix', 'PG-18', NULL, '2028-08-01',
     '2352e9c5-0cd3-4b3f-8831-4f8da62cc88c', 'c964a0ea-98e3-4bbd-8ff2-5e4a2d4380f3', NULL, 2),

    ('c964a0ea-98e3-4bbd-8ff2-5e4a2d4380f3', 2, 'Lucifer Season 3', "Lucifer grapples with his identity and purpose, facing challenges from both Heaven and Hell. As secrets are revealed, alliances are tested, and Lucifer's journey takes unexpected turns.", 'EN', 'Netflix', 'PG-18', NULL, '2028-09-01',
     'cfd09994-d32e-4903-87a2-86e373906e7c', 'e1c1fcb8-3da3-4e49-9c17-160f2a7f7ebd', NULL, 3),

    ('e1c1fcb8-3da3-4e49-9c17-160f2a7f7ebd', 2, 'Lucifer Season 4', "Lucifer continues to navigate the complexities of his dual nature while facing new adversaries. Relationships are tested, and revelations about celestial realms shape the course of his destiny.", 'EN', 'Netflix', 'PG-18', NULL, '2028-10-01',
     'c964a0ea-98e3-4bbd-8ff2-5e4a2d4380f3', '7d3f2e09-7915-4e87-af8d-c7b5377d8797', NULL, 4),

    ('7d3f2e09-7915-4e87-af8d-c7b5377d8797', 2, 'Lucifer Season 5', "In the penultimate season, Lucifer confronts challenges from his past and present, including the return of old adversaries. The battle between Heaven and Hell reaches its climax.", 'EN', 'Netflix', 'PG-18', NULL, '2028-11-01',
     'e1c1fcb8-3da3-4e49-9c17-160f2a7f7ebd', 'c110b6df-e9b5-43b1-b4bb-c03d6d01f167', NULL, 5),

    ('c110b6df-e9b5-43b1-b4bb-c03d6d01f167', 2, 'Lucifer Season 6', "In the final season, Lucifer faces his ultimate challenge as he grapples with love, redemption, and destiny. The series concludes with a resolution to Lucifer Morningstar's journey.", 'EN', 'Netflix', 'PG-18', NULL, '2028-12-01', 
    '7d3f2e09-7915-4e87-af8d-c7b5377d8797', NULL, NULL, 6);

--the mandalorian
INSERT INTO film (
    id, 
    FILM_TYPE, 
    TITTLE,
    SYNOPSIS, 
    ORIGINAL_LANGUAGE, 
    DISTRIBUTOR, 
    SUITABLE_FOR, 
    COOMING_SOON, 
    STREAMING_RELEASE_DATE, 
    PREQUEL_ID, 
    SEQUEL_ID, 
    SAGA_ID,
    SEASON_NUMBER
) VALUES 
    ('c597d4ea-6635-4a29-81a7-4ecb0a8b7e8c', 2, 'The Mandalorian Season 1', 'Set in the Star Wars universe, the series follows the adventures of a lone bounty hunter known as the Mandalorian. As he navigates the galaxy, he encounters new allies and adversaries.', 'EN', 'Disney+', 'PG-13', NULL, '2029-01-01', 
    NULL, 'c7d79cc5-89f4-44ae-8d2d-787c0d9370d4', NULL, 1),

    ('c7d79cc5-89f4-44ae-8d2d-787c0d9370d4', 2, 'The Mandalorian Season 2', 'The Mandalorian continues his quest, facing new challenges and uncovering mysteries of the Force. As he encounters iconic characters, the fate of the galaxy hangs in the balance.', 'EN', 'Disney+', 'PG-13', NULL, '2029-02-01', 
    'c597d4ea-6635-4a29-81a7-4ecb0a8b7e8c', '6a5c9630-d8fe-46cd-8d5a-b2086b0a6cd9', NULL, 2),

    ('6a5c9630-d8fe-46cd-8d5a-b2086b0a6cd9', 2, 'The Mandalorian Season 3', 'The Mandalorian embarks on a new mission, facing challenges from both the criminal underworld and the remnants of the Empire. The series explores the deeper lore of the Star Wars galaxy.', 'EN', 'Disney+', 'PG-13', NULL, '2029-03-01', 
    'c7d79cc5-89f4-44ae-8d2d-787c0d9370d4', NULL, NULL, 3);

--gotham
INSERT INTO film (
    id, 
    FILM_TYPE, 
    TITTLE,
    SYNOPSIS, 
    ORIGINAL_LANGUAGE, 
    DISTRIBUTOR, 
    SUITABLE_FOR, 
    COOMING_SOON, 
    STREAMING_RELEASE_DATE, 
    PREQUEL_ID, 
    SEQUEL_ID, 
    SAGA_ID,
    SEASON_NUMBER
) VALUES 
    ('128f28e1-7f01-470c-982c-bfd1a7382ef9', 2, 'Gotham Season 1', 'Set in the early years of Gotham City, the series follows Detective James Gordon as he navigates corruption and crime. The origins of iconic Batman characters are explored in this dark and gritty prequel.', 'EN', 'FOX', 'PG-18', NULL, '2029-04-01', 
    NULL, '7b1221b8-80e5-442a-b567-6d3baf0592a5', NULL, 1),

    ('7b1221b8-80e5-442a-b567-6d3baf0592a5', 2, 'Gotham Season 2', "As crime escalates in Gotham, Gordon faces new threats, and the rise of iconic villains begins. The city plunges into chaos, setting the stage for the emergence of Batman and his rogues' gallery.", 'EN', 'FOX', 'PG-18', NULL, '2029-05-01', 
    '128f28e1-7f01-470c-982c-bfd1a7382ef9', 'd414a28e-c8b2-48e7-8924-e9488a0be68c', NULL, 2),

    ('d414a28e-c8b2-48e7-8924-e9488a0be68c', 2, 'Gotham Season 3', "The villains gain power, and the dark forces in Gotham grow stronger. Gordon and his allies face personal and professional challenges as the city teeters on the brink of chaos.", 'EN', 'FOX', 'PG-18', NULL, '2029-06-01', 
    '7b1221b8-80e5-442a-b567-6d3baf0592a5', '04b43156-5b8e-4167-a2c3-7a786f0111d3', NULL, 3),

    ('04b43156-5b8e-4167-a2c3-7a786f0111d3', 2, 'Gotham Season 4', "Gotham descends into madness as the villains' power reaches its peak. New heroes and threats emerge, shaping the destiny of the city and laying the groundwork for the Dark Knight.", 'EN', 'FOX', 'PG-18', NULL, '2029-07-01', 
    'd414a28e-c8b2-48e7-8924-e9488a0be68c', '56f1a542-bcf9-44c8-8d56-f1e18c4bcaeb', NULL, 4),

    ('56f1a542-bcf9-44c8-8d56-f1e18c4bcaeb', 2, 'Gotham Season 5', "In the final season, Gotham faces its darkest hour as the city is isolated and overrun by criminals. As chaos reigns, the series concludes with the transformation of Bruce Wayne into Batman.", 'EN', 'FOX', 'PG-18', NULL, '2029-08-01', 
    '04b43156-5b8e-4167-a2c3-7a786f0111d3', NULL, NULL, 5);

--the last kingdom
INSERT INTO film (
    id, 
    FILM_TYPE, 
    TITTLE,
    SYNOPSIS, 
    ORIGINAL_LANGUAGE, 
    DISTRIBUTOR, 
    SUITABLE_FOR, 
    COOMING_SOON, 
    STREAMING_RELEASE_DATE, 
    PREQUEL_ID, 
    SEQUEL_ID, 
    SAGA_ID,
    SEASON_NUMBER
) VALUES 
    ('a62d0e8b-e40b-4a63-8a2d-3f0e2a7490c8', 2, 'The Last Kingdom Season 1', 'Set in the late 9th century, the series follows Uhtred of Bebbanburg, a Saxon raised by Vikings, as he navigates the complex political landscape of England. Battles, alliances, and betrayals shape the destiny of the kingdoms.', 'EN', 'Netflix', 'PG-18', NULL, '2029-09-01', 
    NULL, '4ea1a1a9-6d69-4ed4-8f80-52c4a4ee4c14', NULL, 1),

    ('4ea1a1a9-6d69-4ed4-8f80-52c4a4ee4c14', 2, 'The Last Kingdom Season 2', "Uhtred continues his quest to reclaim his birthright, facing challenges from both Saxon and Viking forces. As England is divided, Uhtred's loyalty and strength are tested.", 'EN', 'Netflix', 'PG-18', NULL, '2029-10-01',
    "a62d0e8b-e40b-4a63-8a2d-3f0e2a7490c8", NULL, NULL, 2),

    ('c97f8e7c-1b25-42e9-9670-4ab1a9837e63', 2, 'The Last Kingdom Season 3', "Uhtred faces new adversaries and challenges as he strives to protect his people and reclaim his homeland. The battle for England intensifies, and loyalties are tested in the crucible of war.", 'EN', 'Netflix', 'PG-18', NULL, '2029-11-01', 
    '4ea1a1a9-6d69-4ed4-8f80-52c4a4ee4c14', '8b63d5ea-7c37-43bb-8da4-6a8458db08d5', NULL, 3),

    ('8b63d5ea-7c37-43bb-8da4-6a8458db08d5', 2, 'The Last Kingdom Season 4', "As England faces external threats, Uhtred must navigate shifting alliances and political intrigue. The series explores themes of identity, honor, and the impact of historical events on individuals.", 'EN', 'Netflix', 'PG-18', NULL, '2029-12-01', 
    'c97f8e7c-1b25-42e9-9670-4ab1a9837e63', '2be3dbed-3fb7-4f70-a4a3-03b3d4316d97', NULL, 4),

    ('2be3dbed-3fb7-4f70-a4a3-03b3d4316d97', 2, 'The Last Kingdom Season 5', "In the final season, Uhtred faces his greatest challenges as he strives to achieve lasting peace in England. The destinies of kingdoms are decided in a climactic conclusion to The Last Kingdom.", 'EN', 'Netflix', 'PG-18', NULL, '2030-01-01', 
    '8b63d5ea-7c37-43bb-8da4-6a8458db08d5', NULL, NULL, 5);
set foreign_key_checks=1;