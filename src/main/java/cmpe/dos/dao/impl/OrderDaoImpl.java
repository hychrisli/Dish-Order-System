package cmpe.dos.dao.impl;

import org.springframework.stereotype.Repository;

import cmpe.dos.dao.AbstractHibernateDao;
import cmpe.dos.dao.RewardDao;
import cmpe.dos.entity.Order;

@Repository
public class OrderDaoImpl extends AbstractHibernateDao<Order>{

	public OrderDaoImpl(){
		super(Order.class);
	}

}