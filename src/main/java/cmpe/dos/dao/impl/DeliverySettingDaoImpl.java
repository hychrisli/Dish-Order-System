package cmpe.dos.dao.impl;

import org.springframework.stereotype.Repository;

import cmpe.dos.dao.AbstractHibernateDao;
import cmpe.dos.entity.DeliverySetting;

@Repository
public class DeliverySettingDaoImpl extends AbstractHibernateDao<DeliverySetting> {

	public DeliverySettingDaoImpl(){
		super(DeliverySetting.class);
	}
}
