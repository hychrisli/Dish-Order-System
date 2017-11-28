package cmpe.dos.service;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;

import cmpe.dos.dao.HibernateDao;
import cmpe.dos.entity.Order;
import cmpe.dos.service.impl.OrderServiceImpl;

public class OrderServiceTest {
    @Mock
    private HibernateDao<Order> dao;

    @InjectMocks
    private OrderService orderService = new OrderServiceImpl();

    private Order o1;

    @Before
    public void init() {
	Order o1 = new Order("cust1", (short) 1, new Date(), 15.89f, false);

    }

/*    @Test
    public void testRetrieveUserOrder() {
	fail("Not yet implemented");
    }*/

    @Test
    public void testCreateOrder() {
	Assert.assertEquals(orderService.createOrder(o1), true);
    }

}
