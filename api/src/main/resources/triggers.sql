DROP TRIGGER IF EXISTS CalculateAverageUserRatingUserInsert;//
DROP TRIGGER IF EXISTS CalculateAverageUserRatingSuperInsert;//
DROP TRIGGER IF EXISTS CalculateAverageUserRatingUserUpdate;//
DROP TRIGGER IF EXISTS CalculateAverageUserRatingSuperUpdate;
//
CREATE TRIGGER CalculateAverageUserRatingUserInsert
AFTER INSERT
ON rating FOR EACH ROW
BEGIN
    DECLARE film_id VARCHAR(36);
    DECLARE average_rating FLOAT;

    SELECT NEW.film_id INTO film_id;
    SELECT AVG(r.rating) INTO average_rating FROM rating r WHERE r.film_id = film_id AND r.super_rating = false;

    UPDATE film SET average_user_rating = average_rating WHERE id = film_id;
END//

//
CREATE TRIGGER CalculateAverageUserRatingSuperInsert
AFTER INSERT
ON rating FOR EACH ROW
BEGIN
    DECLARE film_id VARCHAR(36);
    DECLARE average_rating FLOAT;

    SELECT NEW.film_id INTO film_id;
    SELECT AVG(r.rating) INTO average_rating FROM rating r WHERE r.film_id = film_id AND r.super_rating = true;

    UPDATE film SET average_user_rating = average_rating WHERE id = film_id;
END//

//
CREATE TRIGGER CalculateAverageUserRatingUserUpdate
AFTER UPDATE
ON rating FOR EACH ROW
BEGIN
    DECLARE film_id VARCHAR(36);
    DECLARE average_rating FLOAT;

    SELECT NEW.film_id INTO film_id;
    SELECT AVG(r.rating) INTO average_rating FROM rating r WHERE r.film_id = film_id AND r.super_rating = false;

    UPDATE film SET average_user_rating = average_rating WHERE id = film_id;
END//
//
CREATE TRIGGER CalculateAverageUserRatingSuperUpdate
AFTER UPDATE
ON rating FOR EACH ROW
BEGIN
    DECLARE film_id VARCHAR(36);
    DECLARE average_rating FLOAT;

    SELECT NEW.film_id INTO film_id;
    SELECT AVG(r.rating) INTO average_rating FROM rating r WHERE r.film_id = film_id AND r.super_rating = true;

    UPDATE film SET average_user_rating = average_rating WHERE id = film_id;
END//