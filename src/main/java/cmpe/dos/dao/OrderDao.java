package cmpe.dos.dao;

import cmpe.dos.entity.Order;

import java.util.List;

public interface OrderDao extends HibernateDao<Order> {


    public List<Order> getNonPickupOrderByUser(String username);
    public List<Order> getOrdersByUser(String username);
}
