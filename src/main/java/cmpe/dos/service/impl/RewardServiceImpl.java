package cmpe.dos.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cmpe.dos.dao.HibernateDao;
import cmpe.dos.dao.RewardDao;
import cmpe.dos.entity.Reward;
import cmpe.dos.service.RewardService;

@Service
public class RewardServiceImpl implements RewardService {

	 @Autowired
	 RewardDao dao;
	 
	@Override
	public Reward getValidCoupon(String couponId) {
		// TODO Auto-generated method stub
		return dao.getValidCoupon(couponId);
	}

	@Override
	public void DeleteUsedCoupon(Reward reward) {
		dao.deleteById(reward.getRewardId());
	}

}
