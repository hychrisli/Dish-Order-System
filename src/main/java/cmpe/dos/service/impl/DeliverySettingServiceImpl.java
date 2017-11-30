package cmpe.dos.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cmpe.dos.dao.HibernateDao;
import cmpe.dos.entity.DeliverySetting;
import cmpe.dos.service.DeliverySettingService;

@Service
public class DeliverySettingServiceImpl implements DeliverySettingService {

	@Autowired
    HibernateDao<DeliverySetting> dao;
	
	@Override
	public DeliverySetting retrieveDeliverSetting(Short branchId) {
		return dao.getById(branchId);
	}

}
