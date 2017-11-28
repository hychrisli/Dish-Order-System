package cmpe.dos.dao.impl;

import org.springframework.stereotype.Repository;

import cmpe.dos.dao.AbstractHibernateDao;
import cmpe.dos.entity.DeliveryInfo;

@Repository
public class DeliveryInfoDaoImpl extends AbstractHibernateDao<DeliveryInfo> {

	public DeliveryInfoDaoImpl(){
		super(DeliveryInfo.class);
	}
}
