package cmpe.dos.mapper;

import cmpe.dos.dto.CreditInfoDto;
import cmpe.dos.entity.OrderPayInfo;

public class CreditInfoMapper {

    public static CreditInfoDto toDto(OrderPayInfo info) {
	
	CreditInfoDto creditInfoDto = new CreditInfoDto();
	
	creditInfoDto.setCardholderName(info.getCardholderName());
	creditInfoDto.setCardNum(info.getCardNum());
	creditInfoDto.setCardType(info.getCardType());
	creditInfoDto.setDate(info.getDate());
	
	return creditInfoDto;
    }
    
    
    
}
