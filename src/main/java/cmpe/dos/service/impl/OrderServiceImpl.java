package cmpe.dos.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cmpe.dos.dao.HibernateDao;
import cmpe.dos.entity.Order;
import cmpe.dos.service.OrderService;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    HibernateDao<Order> dao;

    @Override
    public List<Order> retrieveUserOrder(String username) {
	// TODO Auto-generated method stub
	return null;
    }

    @Override
    public Boolean createOrder(Order order) {
	// dao.create(order);
	return true;
    }

}
