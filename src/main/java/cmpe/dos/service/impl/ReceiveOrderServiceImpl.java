package cmpe.dos.service.impl;

import cmpe.dos.dao.HibernateDao;
import cmpe.dos.dao.OrderDao;
import cmpe.dos.entity.Order;
import cmpe.dos.service.ReceiveOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class ReceiveOrderServiceImpl implements ReceiveOrderService {

    @Autowired
    HibernateDao<Order> odao;
    Date d;

    @Override
    public List<Order> confirmReceiveOrder(Integer orderId) {

        Date timestamp = new Date();
        List<Order> updatedOrder = new ArrayList<>();
        for(Order o: odao.doQueryList("from ORDERS where orderId = ? ",true, orderId)){
            o.setPickOrDeliveryTime(timestamp);
            odao.update(o);
            updatedOrder.add(o);

        }

        return updatedOrder;
    }

    @Override
    public List<Order> showNonReceivedOrder(String username) {
        String sql = "from ORDERS where username = ? and pickOrDeliveryTime is null";
        return odao.doQueryList(sql,true, username);
    }
}
