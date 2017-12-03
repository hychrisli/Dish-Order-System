package cmpe.dos.service;

import java.util.List;

import cmpe.dos.entity.CouponDict;

public interface CouponDictService {

	public CouponDict getCouponInfo(String couponId);
	
	public List<CouponDict> getCoupons();
}
