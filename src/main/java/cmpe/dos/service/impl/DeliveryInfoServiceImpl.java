package cmpe.dos.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cmpe.dos.dao.HibernateDao;
import cmpe.dos.entity.DeliveryInfo;
import cmpe.dos.service.DeliveryInfoService;

@Service
public class DeliveryInfoServiceImpl implements DeliveryInfoService {

	@Autowired
	 HibernateDao<DeliveryInfo> dao;
	
	@Override
	public void creat(DeliveryInfo deliveryInfo) {
		dao.create(deliveryInfo);		
	}

}
