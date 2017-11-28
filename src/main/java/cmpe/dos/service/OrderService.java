package cmpe.dos.service;

import java.util.List;

import cmpe.dos.entity.Order;

public interface OrderService {
    
    public List<Order> retrieveUserOrder(String username);
    
    public Boolean createOrder(Order order);
    
}
