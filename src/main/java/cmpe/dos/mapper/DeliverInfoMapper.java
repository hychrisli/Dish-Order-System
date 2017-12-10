package cmpe.dos.mapper;

import cmpe.dos.dto.DeliverInfoDto;
import cmpe.dos.dto.OrderHistoryDto;
import cmpe.dos.entity.DeliveryInfo;
import cmpe.dos.utility.Param;

public class DeliverInfoMapper {

    public static DeliverInfoDto toDto(DeliveryInfo di){
	
	DeliverInfoDto diDto = new DeliverInfoDto();
	
	diDto.setCity(di.getCity());
	diDto.setPhone(di.getPhone());
	diDto.setReceiverName(di.getReceiverName());
	diDto.setState(di.getState());
	diDto.setStreet(di.getStreet());
	diDto.setZipcode(di.getZipcode());
	
	return diDto;
	
    }
    
    public static DeliveryInfo toPojo(Integer orderId, OrderHistoryDto dto){
	
	DeliveryInfo di = new DeliveryInfo();
	
	di.setOrderId(orderId);
	di.setReceiverName(dto.getReceiverName());
        di.setStreet(dto.getStreet());
        di.setCity(dto.getCity());
        di.setState(dto.getState());
        di.setZipcode(dto.getZipcode());
        di.setPhone(dto.getPhone());
        
        return di;
    }
    
    public static DeliveryInfo toPojo(Integer orderId, Param param) {
	DeliveryInfo di = new DeliveryInfo();
	
	di.setOrderId(orderId);
	di.setReceiverName(param.diDto.getReceiverName());
        di.setStreet(param.diDto.getStreet());
        di.setCity(param.diDto.getCity());
        di.setState(param.diDto.getState());
        di.setZipcode(param.diDto.getZipcode());
        di.setPhone(param.diDto.getPhone());
	
	return di;
    }
    
}
