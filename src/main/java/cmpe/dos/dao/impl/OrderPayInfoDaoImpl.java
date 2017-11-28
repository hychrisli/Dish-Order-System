package cmpe.dos.dao.impl;

import org.springframework.stereotype.Repository;

import cmpe.dos.dao.AbstractHibernateDao;
import cmpe.dos.entity.OrderPayInfo;

@Repository
public class OrderPayInfoDaoImpl extends AbstractHibernateDao<OrderPayInfo> {

	public OrderPayInfoDaoImpl(){
		super(OrderPayInfo.class);
	}
}