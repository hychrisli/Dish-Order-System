package cmpe.dos.service.impl;

import static org.slf4j.LoggerFactory.getLogger;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import cmpe.dos.dao.OrderDao;
import cmpe.dos.dto.OrderHistoryDto;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cmpe.dos.config.security.AuthConfig;
import cmpe.dos.dao.HibernateDao;
import cmpe.dos.dto.DeliverInfoDto;
import cmpe.dos.dto.DishHistDetailDto;
import cmpe.dos.dto.OrderDetailDto;
import cmpe.dos.entity.DefaultPaycard;
import cmpe.dos.entity.Order;
import cmpe.dos.entity.User;
import cmpe.dos.service.OrderService;

@Service
public class OrderServiceImpl implements OrderService {

    private final static Logger LOGGER = getLogger(OrderServiceImpl.class);
    
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
    public List getOrderByUsername(String username) {
	return orderDao.getOrdersByUser(username);
    }

    @Override
    public List getInfoByID1(int orderId) {
	return orderDao.getjointinformation1(orderId);
    }

    @Override
    public List getInfoByID2(int orderId) {
	return orderDao.getjointinformation2(orderId);
    }

    @Override
    public OrderHistoryDto getHistoryOrderDto(Integer orderId) {
	List info1 = orderDao.getjointinformation1(orderId);
	List info2 = orderDao.getjointinformation2(orderId);
	OrderHistoryDto ODto = new OrderHistoryDto();
	Object[] list1 = (Object[]) (info1.get(0));

	ODto.setOrderId((Integer) list1[0]);
	ODto.setUsername((String) list1[1]);
	ODto.setBranchId((Short) list1[2]);
	ODto.setTotalPrice((Float) list1[3]);
	ODto.setIsDeliver((Boolean) list1[4]);
	ODto.setReceiverName((String) list1[5]);
	ODto.setPhone((String) list1[6]);
	ODto.setStreet((String) list1[7]);
	ODto.setCity((String) list1[8]);
	ODto.setState((String) list1[9]);
	ODto.setZipcode((String) list1[10]);
	ODto.setCardNum((String) list1[11]);
	ODto.setCardType((String) list1[12]);
	ODto.setCardholderName((String) list1[13]);
	ODto.setDate((Date) list1[14]);
	ODto.setDishHistDetail(new ArrayList<DishHistDetailDto>());
	
	LOGGER.info("row num: " + info2.size());
	
	for (int i = 0; i < info2.size(); i++) {
	    
	    Object[] col = (Object[]) info2.get(i);
	    DishHistDetailDto dishHistDetailDto = new DishHistDetailDto();
	    dishHistDetailDto.setDishId((Integer) col[0]);
	    dishHistDetailDto.setName((String) col[1]);
	    dishHistDetailDto.setOrderQuantity((Short) col[2]);
	    ODto.getDishHistDetail().add(dishHistDetailDto);
	}

	return ODto;

    }

    @Override
    public Order getOrderById(Integer orderId) {
	return orderDao.getById(orderId);
    }
}
