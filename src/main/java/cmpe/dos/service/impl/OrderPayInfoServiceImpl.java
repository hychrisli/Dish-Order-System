package cmpe.dos.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cmpe.dos.dao.HibernateDao;
import cmpe.dos.entity.OrderPayInfo;
import cmpe.dos.service.OrderPayInfoService;

@Service
public class OrderPayInfoServiceImpl implements OrderPayInfoService {

	@Autowired
	HibernateDao<OrderPayInfo> dao;
	
	@Override
	public void create(OrderPayInfo orderPayInfo) {
		dao.create(orderPayInfo);

	}

	@Override
	public OrderPayInfo getOrderPayInfo(Integer orderId) {
	    return dao.getById(orderId);
	}

}
