delimiter //
CREATE PROCEDURE SPValidateAccess (
    IN phone INT(11),
    IN password VARCHAR(16)
)
BEGIN
 SELECT client_id, client_last_name, client_name, client_phone FROM client
 WHERE client_phone = phone AND client_password = password;
END//
delimiter ;