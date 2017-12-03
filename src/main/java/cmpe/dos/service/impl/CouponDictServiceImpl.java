package cmpe.dos.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cmpe.dos.dao.HibernateDao;
import cmpe.dos.entity.CouponDict;
import cmpe.dos.service.CouponDictService;

@Service
public class CouponDictServiceImpl implements CouponDictService {
	
	@Autowired
	HibernateDao<CouponDict> dao;

	@Override
	public CouponDict getCouponInfo(String couponId) {
		return dao.getById(couponId);
	}

	@Override
	public List<CouponDict> getCoupons() {
	    return dao.findAll();
	}

}
