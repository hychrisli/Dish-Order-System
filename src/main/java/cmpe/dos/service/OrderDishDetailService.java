package cmpe.dos.service;

import java.util.List;

import cmpe.dos.entity.OrderDishDetail;

public interface OrderDishDetailService {

	public void create(OrderDishDetail orderDishDetail);
	
	public List<OrderDishDetail> getDishDetail(Integer orderId);
}
