DROP TRIGGER IF EXISTS CalculateTotalLikesCommentInsert;//
DROP TRIGGER IF EXISTS CalculateTotalLikesCommentDelete;//
DROP TRIGGER IF EXISTS CalculateTotalLikesPostInsert;//
DROP TRIGGER IF EXISTS CalculateTotalLikesPostDelete;//
//
CREATE TRIGGER CalculateTotalLikesCommentInsert
AFTER INSERT
ON thumbs_up FOR EACH ROW
BEGIN
    DECLARE owner_id VARCHAR(36);
    DECLARE like_count INT;

    SELECT NEW.owner_id INTO owner_id;
    SELECT count(tu.id) INTO like_count FROM thumbs_up tu WHERE tu.owner_id = owner_id;

    UPDATE comment SET like_count = like_count WHERE id = owner_id;
END//
//
CREATE TRIGGER CalculateTotalLikesCommentDelete
AFTER DELETE
ON thumbs_up FOR EACH ROW
BEGIN
    DECLARE deleted_id VARCHAR(36);

    SET deleted_id = OLD.owner_id;

    UPDATE comment SET like_count = like_count - 1 WHERE id = deleted_id;
END//
//


//
CREATE TRIGGER CalculateTotalLikesPostInsert
AFTER INSERT
ON thumbs_up FOR EACH ROW
BEGIN
    DECLARE owner_id VARCHAR(36);
    DECLARE like_count INT;

    SELECT NEW.owner_id INTO owner_id;
    SELECT count(tu.id) INTO like_count FROM thumbs_up tu WHERE tu.owner_id = owner_id;

    UPDATE post SET like_count = like_count WHERE id = owner_id;
END//

//
CREATE TRIGGER CalculateTotalLikesPostDelete
AFTER DELETE
ON thumbs_up FOR EACH ROW
BEGIN
    DECLARE deleted_id VARCHAR(36);

    SET deleted_id = OLD.owner_id;

    UPDATE post SET like_count = like_count - 1 WHERE id = deleted_id;
END//
//