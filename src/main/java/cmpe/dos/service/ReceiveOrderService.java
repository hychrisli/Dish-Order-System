package cmpe.dos.service;

import cmpe.dos.entity.Order;

import java.util.List;

public interface ReceiveOrderService {

    public Order confirmReceiveOrder(Integer oderId, String username);
    public List<Order> showNonReceivedOrder(String username);
    public List<Order> showallUnreceivedOrders();
    public Boolean confirmReceiveAnOrder(Integer orderId);
}
