package cmpe.dos.service;

import cmpe.dos.entity.OrderPayInfo;

public interface OrderPayInfoService {

	public void create(OrderPayInfo orderPayInfo);
	
	public OrderPayInfo getOrderPayInfo(Integer orderId);
}
