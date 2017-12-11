CREATE PROCEDURE `auto_scan` ()
BEGIN

CREATE EVENT myevent
	ON SCHEDULE EVERY 5 second
    DO
		CALL autoConfirmReceive();

END
