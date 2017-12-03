package cmpe.dos.dao;

import cmpe.dos.entity.Order;

import java.util.List;

public interface OrderDao extends HibernateDao<Order> {


    public List<Order> getNonPickupOrderByUser(String username);

    public List getOrdersByUser(String username);
    public List getjointinformation1(int order_id);
    public List getjointinformation2(int order_id);
}
