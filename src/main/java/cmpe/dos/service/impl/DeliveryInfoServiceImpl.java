package cmpe.dos.service.impl;

import cmpe.dos.dao.HibernateDao;
import cmpe.dos.entity.DeliveryInfo;
import cmpe.dos.service.DeliveryInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DeliveryInfoServiceImpl implements DeliveryInfoService {

	@Autowired
	 HibernateDao<DeliveryInfo> dao;
	
	@Override
	public void creat(DeliveryInfo deliveryInfo) {
		dao.create(deliveryInfo);		
	}

}
