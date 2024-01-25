DROP TRIGGER IF EXISTS CalculateAverageSuperRatingSuperInsert;//
DROP TRIGGER IF EXISTS CalculateAverageSuperRatingSuperUpdate;//
DROP TRIGGER IF EXISTS CalculateAverageUserRatingUserInsert;//
DROP TRIGGER IF EXISTS CalculateAverageUserRatingUserUpdate;//
//
CREATE TRIGGER CalculateAverageSuperRatingSuperInsert
AFTER INSERT
ON post FOR EACH ROW
BEGIN
    DECLARE film_id VARCHAR(36);
    DECLARE average_rating TINYINT;

    SELECT NEW.film_id INTO film_id;
    SELECT AVG(r.rating) INTO average_rating FROM post r WHERE r.film_id = film_id AND r.is_review = true;

    UPDATE film SET average_super_rating = average_rating WHERE id = film_id;
END//
//
CREATE TRIGGER CalculateAverageSuperRatingSuperUpdate
AFTER UPDATE
ON post FOR EACH ROW
BEGIN
    DECLARE film_id VARCHAR(36);
    DECLARE average_rating TINYINT;

    SELECT NEW.film_id INTO film_id;
    SELECT AVG(r.rating) INTO average_rating FROM post r WHERE r.film_id = film_id AND r.is_review = true;

    UPDATE film SET average_super_rating = average_rating WHERE id = film_id;
END//
//
CREATE TRIGGER CalculateAverageUserRatingUserInsert
AFTER INSERT
ON comment FOR EACH ROW
BEGIN
    DECLARE film_id VARCHAR(36);
    DECLARE average_rating TINYINT;

    SELECT NEW.film_id INTO film_id;
    SELECT AVG(c.rating) INTO average_rating FROM comment c WHERE c.film_id = film_id AND c.reported = false;

    UPDATE film SET average_user_rating = average_rating WHERE id = film_id;
END//
//
CREATE TRIGGER CalculateAverageUserRatingUserUpdate
AFTER UPDATE
ON comment FOR EACH ROW
BEGIN
    DECLARE film_id VARCHAR(36);
    DECLARE average_rating TINYINT;

    SELECT NEW.film_id INTO film_id;
    SELECT AVG(c.rating) INTO average_rating FROM comment c WHERE c.film_id = film_id AND c.reported = false;

    UPDATE film SET average_user_rating = average_rating WHERE id = film_id;
END//

