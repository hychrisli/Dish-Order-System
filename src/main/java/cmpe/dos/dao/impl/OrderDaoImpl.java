package cmpe.dos.dao.impl;

import cmpe.dos.dao.OrderDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import cmpe.dos.dao.AbstractHibernateDao;
import cmpe.dos.dao.RewardDao;
import cmpe.dos.entity.Order;

import java.util.List;

@Repository
public class OrderDaoImpl extends AbstractHibernateDao<Order> implements OrderDao {


	public OrderDaoImpl(){
		super(Order.class);
	}

	@Override
	public List<Order> getNonPickupOrderByUser(String username) {

		String sql = "from Order where username = ? and pickOrDeliveryTime is NULL";

		return doQueryList(sql,true, username);
	}

	@Override
	public List<Order> getOrdersByUser(String username) {
		String sql = "from Order where username = ?";
		return doQueryList(sql, true, username);
	}
}