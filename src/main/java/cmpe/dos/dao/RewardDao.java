package cmpe.dos.dao;

import cmpe.dos.entity.Order;
import cmpe.dos.entity.Reward;

public interface RewardDao extends HibernateDao<Reward>{

	public Reward getValidCoupon(String couponId);
}
