DELIMITER $$
CREATE PROCEDURE `autoConfirmReceive` (id int)
BEGIN

	SET @this_order_time = (select order_time from ORDERS where order_id = id);

	IF  ( DATE_SUB(NOW(), INTERVAL 20 DAY) > @this_order_time) THEN
    
		update orders 
		set pickup_deliver_time =  now()
        where order_id =  id;

	END IF;

END       $$

DELIMITER ;

