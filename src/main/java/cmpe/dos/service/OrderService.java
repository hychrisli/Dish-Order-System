package cmpe.dos.service;

import java.util.List;

import cmpe.dos.dto.DeliverInfoDto;
import cmpe.dos.dto.OrderHistoryDto;
import cmpe.dos.entity.Order;

public interface OrderService {
    
    public List<Order> retrieveUserOrder(String username);
    
    public Boolean createOrder(Order order);
    
    public DeliverInfoDto getDefaultDeliverInfo(String username);


    public List getOrderByUsername(String username);

    public List getInfoByID1(int orderId);

    public List getInfoByID2(int orderId);

    public OrderHistoryDto getHistoryOrderDto(List info1, List info2);
    

}
