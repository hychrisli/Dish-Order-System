package cmpe.dos.service.impl;

import cmpe.dos.entity.CouponDict;
import cmpe.dos.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cmpe.dos.dao.HibernateDao;
import cmpe.dos.dao.RewardDao;
import cmpe.dos.dto.CouponDto;
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
	return rewardDao.getValidCoupon(couponId);
    }

    @Override
    public void DeleteUsedCoupon(Reward reward) {
	rewardDao.deleteById(reward.getRewardId());
    }

    @Override
    public Boolean addNewCoupon(CouponDto couponDto) {

	CouponDict coupon = couponDictDao.getById(couponDto.getCouponName());

	if (coupon == null) {
	    CouponDict couponDict = new CouponDict();
	    couponDict.setCouponId(couponDto.getCouponName());
	    couponDict.setValue(couponDto.getCouponValue());
	    couponDictDao.create(couponDict);
	}

	// Expiration date of the coupon
	Date today = Calendar.getInstance().getTime();
	Calendar cal = Calendar.getInstance();
	cal.setTime(new Date());
	cal.add(Calendar.DATE, couponDto.getDuration());
	Date endDate = cal.getTime();

	Calendar calYears = Calendar.getInstance();
	calYears.setTime(new Date());
	calYears.add(Calendar.YEAR, -couponDto.getMemberYears());

	Date ago = calYears.getTime();
	List users = userDao.doQueryList(
		"select b.username from User as a, Order as b where a.username = b.username "
			+ "and a.signupDate <= ? group by b.username having count(*) > ?",
		true, ago, Long.valueOf(couponDto.getOrderTimes().longValue()));

	for (int i = 0; i < users.size(); i++) {
	    Reward reward = new Reward();
	    reward.setCouponId(couponDto.getCouponName());
	    reward.setUsername((String) (users.get(i)));
	    reward.setValidStart(today);
	    reward.setValidEnd(endDate);
	    rewardDao.create(reward);
	}

	return true;
    }

    @Override
    public List<Reward> getRewardsByUser(String username) {
	return rewardDao.doQueryList("from Reward where username = ?", true, username);
    }

    @Override
    public Boolean sendCommentReward(String username) {
	Reward newReward = new Reward();

	newReward.setCouponId("commentReward");
	Date now = new Date(new Date().getTime());
	newReward.setValidStart(now);
	Date dueDate = new Date(new Date().getTime());
	addDays(dueDate, 20);
	newReward.setValidEnd(dueDate);
	newReward.setUsername(username);

	rewardDao.create(newReward);
	return true;
    }

    private static Date addDays(Date d, int days) {
	d.setTime(d.getTime() + days * 1000 * 60 * 60 * 24);
	return d;
    }
}
