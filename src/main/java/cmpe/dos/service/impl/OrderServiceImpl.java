package cmpe.dos.service.impl;

import java.util.List;

import cmpe.dos.dao.OrderDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cmpe.dos.dao.HibernateDao;
import cmpe.dos.dto.DeliverInfoDto;
import cmpe.dos.entity.DefaultPaycard;
import cmpe.dos.entity.Order;
import cmpe.dos.entity.User;
import cmpe.dos.service.OrderService;

@Service
public class OrderServiceImpl implements OrderService {
	
	 @Autowired
	 HibernateDao<Order> odao;
	 
	 @Autowired
	 HibernateDao<User> udao;
	 
	 @Autowired
	 HibernateDao<DefaultPaycard> dpdao;

	 @Autowired
    OrderDao orderDao;
	 

	@Override
	public List<Order> retrieveUserOrder(String username) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean createOrder(Order order) {
		odao.create(order);
		return true;
	}

	@Override
	public DeliverInfoDto getDefaultDeliverInfo(String username) {
		User userInfo = udao.getById(username);
		DeliverInfoDto diDto = new DeliverInfoDto();
		diDto.setReceiverName(userInfo.getUsername());
		diDto.setStreet(userInfo.getStreet());
		diDto.setCity(userInfo.getCity());
		diDto.setState(userInfo.getState());
		diDto.setZipcode(userInfo.getZipcode());
		diDto.setPhone(userInfo.getPhone());
		return diDto;
	}

	@Override
	public List<Order> getOrderByUsername(String username) {
       return  orderDao.getOrdersByUser(username);
    }


	

}
