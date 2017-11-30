package cmpe.dos.dao.impl;

import org.springframework.stereotype.Repository;

import cmpe.dos.dao.AbstractHibernateDao;
import cmpe.dos.entity.OrderDishDetail;

@Repository
public class OrderDishDetailDaoImpl extends AbstractHibernateDao<OrderDishDetail> {

	public OrderDishDetailDaoImpl(){
		super(OrderDishDetail.class);
	}
}