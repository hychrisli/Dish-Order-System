package cmpe.dos.service.impl;

import cmpe.dos.entity.CouponDict;
import cmpe.dos.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cmpe.dos.dao.HibernateDao;
import cmpe.dos.dao.RewardDao;
import cmpe.dos.entity.Reward;
import cmpe.dos.service.RewardService;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Service
public class RewardServiceImpl implements RewardService {

	@Autowired
	RewardDao rewardDao;
	@Autowired
	HibernateDao<CouponDict> couponDictDao;

	@Autowired
	HibernateDao<User> userDao;

	@Override
	public Reward getValidCoupon(String couponId) {
		// TODO Auto-generated method stub
		return rewardDao.getValidCoupon(couponId);
	}

	@Override
	public void DeleteUsedCoupon(Reward reward) {
		rewardDao.deleteById(reward.getRewardId());
	}

	@Override
	public Boolean addNewCoupon(Integer years, Integer times, Float values, Integer duration) {
		CouponDict couponDict = new CouponDict();
		couponDict.setCouponId("loyaltyReward");
		couponDict.setValue(values);
		couponDictDao.create(couponDict);
		Date today = Calendar.getInstance().getTime();
		Calendar cal = Calendar.getInstance();
		cal.setTime(new Date());
		cal.add(Calendar.DATE, duration);
		Date endDate = cal.getTime();
		Calendar calYears = Calendar.getInstance();
		calYears.setTime(new Date());
		calYears.add(Calendar.YEAR, -years);
		Date ago = calYears.getTime();
		List users = userDao.doQueryList("select b.username from User as a, Order as b where a.username = b.username " +
				"and a.signupDate <= ? group by b.username having count(*) > ?", true, ago, Long.valueOf(times.longValue()));

		for(int i = 0; i < users.size(); i++) {
			Reward reward = new Reward();
			reward.setCouponId("loyaltyReward");
			reward.setUsername((String)(users.get(i)));
			reward.setValidStart(today);
			reward.setValidEnd(endDate);
			rewardDao.create(reward);
		}
		return true;
	}
}
