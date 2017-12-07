package cmpe.dos.service.impl;

import cmpe.dos.dao.HibernateDao;
import cmpe.dos.entity.Order;
import cmpe.dos.service.ReceiveOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class ReceiveOrderServiceImpl implements ReceiveOrderService {

    @Autowired
    HibernateDao<Order> odao;
    Date d;

    @Override
    public Order confirmReceiveOrder(Integer orderId, String username) {

        Date now = new Date();
        Timestamp ts = new Timestamp(now.getTime());

        Order updatedOrder = odao.doQueryUnique("from Order where orderId = ? and username = ? ",orderId, username);
        if(updatedOrder != null) {
            updatedOrder.setPickOrDeliveryTime(ts);
            odao.update(updatedOrder);
        }
        return updatedOrder;
    }

    @Override
    public List<Order> showNonReceivedOrder(String username) {
        String sql = "from Order where username = ? and pickOrDeliveryTime is null";
        return odao.doQueryList(sql,true, username);
    }

    @Override
    public List<Order> showallUnreceivedOrders() {
        return odao.doQueryList("from Order where pickOrDeliveryTime is null",false);
    }

    @Override
    public Boolean confirmReceiveAnOrder(Integer orderId) {
        Date now = new Date();
        Timestamp ts = new Timestamp(now.getTime());

        Order confirmedOrder = odao.doQueryUnique("from Order where orderId = ? ",  orderId);
        if(confirmedOrder != null) {
            confirmedOrder.setPickOrDeliveryTime(ts);
            odao.update(confirmedOrder);
            return true;
        }

        return false;
    }
}
