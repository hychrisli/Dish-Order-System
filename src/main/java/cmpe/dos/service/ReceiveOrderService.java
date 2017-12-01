package cmpe.dos.service;

import cmpe.dos.entity.Order;

import java.util.List;

public interface ReceiveOrderService {

    public List<Order> confirmReceiveOrder(Integer oderId);
    public List<Order> showNonReceivedOrder(String username);
}
