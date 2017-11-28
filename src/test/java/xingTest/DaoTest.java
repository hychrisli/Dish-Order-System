package xingTest;

import java.util.Date;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.stereotype.Service;

import cmpe.dos.dao.HibernateDao;
import cmpe.dos.entity.Order;
import cmpe.dos.entity.User;
import cmpe.dos.service.OrderService;
import cmpe.dos.service.impl.OrderServiceImpl;

@Service
public class DaoTest {

	@Mock
    private HibernateDao<User> dao;
    
    @InjectMocks
    private static OrderService orderService = new OrderServiceImpl();
	
/*	public static void main(String[] args) {
//		ApplicationContext ctx = new AnnotationConfigApplicationContext(DaoTest.class);
		Order o1 = new Order("cust1", (short)1, new Date(), 15.89f, false );
		orderService.createOrder(o1);
		
	}
*/
}
