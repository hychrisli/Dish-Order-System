package cmpe.dos.dao.impl;

import cmpe.dos.entity.Order;

import java.util.List;
import cmpe.dos.dao.HibernateDao;
import cmpe.dos.dao.OrderDao;
import org.springframework.beans.factory.annotation.Autowired;
import java.security.Principal;
import cmpe.dos.dao.OrderDao;

import org.springframework.stereotype.Repository;

import cmpe.dos.dao.AbstractHibernateDao;
import cmpe.dos.entity.Order;

import java.util.logging.Logger;


@Repository
public class OrderDaoImpl extends AbstractHibernateDao<Order> implements OrderDao {

    protected static Logger LOGGER = Logger.getLogger(OrderDaoImpl.class.getName());
	public OrderDaoImpl(){
		super(Order.class);
	}

	@Override
	public List<Order> getNonPickupOrderByUser(String username) {

		String sql = "from ORDERS where username = ? and pickOrDeliveryTime is null";

		return doQueryList(sql,true, username);
	}

	@Override
	public List<Order> getOrdersByUser(String username) {
		///String hql = " from Order where username = ? ";
        String hql = " from ORDERS where username = ?";
        List<Order> order = doQueryList(hql, true, username);
		return doQueryList(hql, true, username);
	}
}
