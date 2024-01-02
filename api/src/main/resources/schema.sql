CREATE TABLE IF NOT EXISTS `tooren_romaros`.`comment` (
    `id` varchar(36) NOT NULL,
    `user` VARCHAR(36) NULL,
    `body` TEXT NOT NULL,
    `datetime` DATETIME NULL,
    `like_count` INT NULL,
    PRIMARY KEY (`id`));

--create table IF NOT EXISTS discuss (id VARCHAR(36) not null, body VARCHAR(255) not null, like_count VARCHAR(10) DEFAULT 0, publication_datetime DATETIME, reported BOOLEAN DEFAULT false, post_id VARCHAR(36), user_id VARCHAR(36), primary key (id));
--create table IF NOT EXISTS episode (id VARCHAR(36) not null, streaming_release_date DATE, run_time varchar(255), tittle VARCHAR(255), serie_id VARCHAR(36), primary key (id));
--create table IF NOT EXISTS film (film_type integer not null, id VARCHAR(36) not null, average_super_rating FLOAT, average_user_rating FLOAT, cooming_soon DATE, distributor VARCHAR(50), original_language VARCHAR(3), streaming_release_date DATE, suitable_for VARCHAR(5), synopsis VARCHAR(255), tittle VARCHAR(255), at_theaters Boolean, box_office VARCHAR(15), runtime VARCHAR(5), theaters_release_date DATE, season_number VARCHAR(4), prequel_id VARCHAR(36), saga_id VARCHAR(36), sequel_id VARCHAR(36), primary key (id));
--create table IF NOT EXISTS film_staff (id VARCHAR(36) not null, appear_as VARCHAR(50), role VARCHAR(50) not null, film_id VARCHAR(36), staff_id VARCHAR(36), primary key (id));
--create table IF NOT EXISTS genre (id VARCHAR(36) not null, genre varchar(255) not null, primary key (id));
--create table IF NOT EXISTS genre_film (id VARCHAR(36) not null, film_id VARCHAR(36), genre_id VARCHAR(36), primary key (id));
--create table IF NOT EXISTS image (id VARCHAR(36) not null, created_at DATETIME, file_path VARCHAR(255), size VARCHAR(8), image_type VARCHAR(24), owner_type varchar(255), owner_id varchar(255), primary key (id));
--create table IF NOT EXISTS parent_child_discuss (id VARCHAR(36) not null, child_discuss_id VARCHAR(36), parent_discuss_id VARCHAR(36), primary key (id));
--create table IF NOT EXISTS post (id VARCHAR(36) not null, content MEDIUMTEXT, headline VARCHAR(255), like_count VARCHAR(10) DEFAULT 0, publication_datetime DATETIME, status VARCHAR(24), synthesis VARCHAR(255), tittle VARCHAR(255), user_id VARCHAR(36), primary key (id));
--create table IF NOT EXISTS rating (id VARCHAR(36) not null, rating FLOAT not null, super_rating BOOLEAN not null, film_id VARCHAR(36), user_id VARCHAR(36), primary key (id));
--create table IF NOT EXISTS saga (id VARCHAR(36) not null, name VARCHAR(255), primary key (id));
--create table IF NOT EXISTS social (id VARCHAR(36) not null, name VARCHAR(50) not null, primary key (id));
--create table IF NOT EXISTS social_staff (id VARCHAR(36) not null, url VARCHAR(255) not null, social_id VARCHAR(36), entity_id VARCHAR(36), primary key (id));
--create table IF NOT EXISTS social_user (id VARCHAR(36) not null, url VARCHAR(255) not null, social_id VARCHAR(36), entity_id VARCHAR(36), primary key (id));
--create table IF NOT EXISTS staff (id VARCHAR(36) not null, biography TEXT not null, birthday DATE not null, birth_place VARCHAR(50) not null, first_name VARCHAR(50) not null, last_name VARCHAR(50) not null, primary key (id));
--create table IF NOT EXISTS stream (id VARCHAR(36) not null, name VARCHAR(50) not null, price VARCHAR(8) not null, primary key (id));
--create table IF NOT EXISTS stream_film (id VARCHAR(36) not null, buy Boolean not null, rent Boolean not null, url VARCHAR(255) not null, film_id VARCHAR(36), stream_id VARCHAR(36), primary key (id));
--create table IF NOT EXISTS user (id VARCHAR(36) not null, about VARCHAR(255), birthday DATE, created_date DATE, email varchar(255), following_count integer, following_me_count integer, password varchar(255), role varchar(255), user_status varchar(255), username VARCHAR(32) not null, primary key (id));
--create table IF NOT EXISTS user_follower (id VARCHAR(36) not null, follow_since DATE, follower_id VARCHAR(36) not null, user_id VARCHAR(36) not null, primary key (id));
--create table IF NOT EXISTS user_token (id VARCHAR(36) not null, refresh_token varchar(255) not null, user_id VARCHAR(36), primary key (id));
--create table IF NOT EXISTS video (id VARCHAR(36) not null, file_path VARCHAR(255), name VARCHAR(64), primary key (id));