package cmpe.dos.utility;

import java.util.List;

import cmpe.dos.dto.CreditInfoDto;
import cmpe.dos.dto.DeliverInfoDto;
import cmpe.dos.dto.OrderDetailDto;

public class Param {

	public Short branchId;
	
	public Boolean isDelivery;
	
	public Boolean isDefaultAddress;
	
	public Boolean isDefaultPaycard;
	
	public List<OrderDetailDto> orderDetailList;
	
	public DeliverInfoDto diDto;
	
	public CreditInfoDto ciDto;
	
	public Boolean usingCoupon;
	
	public String couponId;

	@Override
	public String toString() {
		return "Param [branchId=" + branchId + ", isDelivery=" + isDelivery + ", isDefaultAddress=" + isDefaultAddress
				+ ", isDefaultPaycard=" + isDefaultPaycard + ", orderDetailList=" + orderDetailList + ", diDto=" + diDto
				+ ", ciDto=" + ciDto + ", usingCoupon=" + usingCoupon + ", couponId=" + couponId + "]";
	}
	
}
