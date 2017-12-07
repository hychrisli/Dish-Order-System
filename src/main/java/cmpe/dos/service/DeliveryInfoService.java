package cmpe.dos.service;

import cmpe.dos.entity.DeliveryInfo;

public interface DeliveryInfoService {

	public void create(DeliveryInfo deliveryInfo);
	
	public DeliveryInfo getDeliveryInfo(Integer orderId);
}
