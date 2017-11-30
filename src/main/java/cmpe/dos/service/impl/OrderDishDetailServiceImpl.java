package cmpe.dos.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cmpe.dos.dao.HibernateDao;
import cmpe.dos.entity.OrderDishDetail;
import cmpe.dos.service.OrderDishDetailService;

@Service
public class OrderDishDetailServiceImpl implements OrderDishDetailService {

	@Autowired
	 HibernateDao<OrderDishDetail> dao;
	
	@Override
	public void create(OrderDishDetail orderDishDetail) {
		dao.create(orderDishDetail);		
	}

}
