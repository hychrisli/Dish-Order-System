package cmpe.dos.dao.impl;

import cmpe.dos.entity.Order;

import java.util.List;
import cmpe.dos.dao.HibernateDao;
import org.springframework.beans.factory.annotation.Autowired;
import java.security.Principal;
import cmpe.dos.dao.OrderDao;

import org.springframework.stereotype.Repository;

import cmpe.dos.dao.AbstractHibernateDao;
import cmpe.dos.entity.Order;
import cmpe.dos.entity.DishDict;

import java.util.logging.Logger;


@Repository
public class OrderDaoImpl extends AbstractHibernateDao<Order> implements OrderDao {

    protected static Logger LOGGER = Logger.getLogger(OrderDaoImpl.class.getName());
	public OrderDaoImpl(){
		super(Order.class);
	}

	@Override
	public List<Order> getNonPickupOrderByUser(String username) {

		String sql = "from Order where username = ? and pickOrDeliveryTime is null";

		return doQueryList(sql,true, username);
	}

	@Override

	public List getOrdersByUser(String username) {
		String hql = " from Order where username = ? ";
        List order = doQueryListUntype(hql, true, username);


		///return doQueryListUntype(hql, true, username);
        return doQueryListUntype(hql, true, username);
	}

	@Override
	public List getjointinformation1(int order_id) {
		String hql = "select o.orderId, o.username, o.branchId, o.totalPrice, o.isDeliver, " +
				" di.receiverName, di.phone, di.street, di.city, di.state, di.zipcode, " +
				" opi.cardNum, opi.cardType, opi.cardholderName, opi.date " +
				" from Order as o, DeliveryInfo as di, OrderPayInfo as opi" +
				" where o.orderId = di.orderId and opi.orderId = ?";
		///List list1 =  doQueryListUntype(hql, true,order_id);
		//String hql2 = "select odd.dishId, dd.name, odd.orderQuantity  from OrderDishDetail as odd, DishDict as dd where odd.dishId = dd.dishID and odd.orderId = ?";
        ///list1.add(doQueryListUntype(hql2,true,order_id));
		return doQueryListUntype(hql, true,order_id);

	}

	@Override
    public List getjointinformation2(int order_id) {
        String hql2 = "select odd.dishId, dd.name, odd.orderQuantity  from OrderDishDetail as odd, DishDict as dd where odd.dishId = dd.dishID and odd.orderId = ?";
        return doQueryListUntype(hql2,true,order_id);
    }


//	select o.orderId, o.username, o.branchId, o.totalPrice, o.isDeliver,
//	di.receiverName, di.phone, di.street, di.city, di.state, di.zipcode,
//	opi.cardNum, opi.cardType, opi.cardholderName, opi.expireDate
//	from Orders as o, DeliveryInfo as di, OrderPayInfo as opi
//	where o.orderId = di.orderId and opi.orderId = o.orderId;

//	select odd.dishd, dd.NAME, odd.ORDER_QUANTITY
//	from order_dish_detail as odd, dish_dict as dd
//	where odd.dish_id = dd.dish_id and odd.order_id = 1;
}
