package cmpe.dos.dao;

import cmpe.dos.entity.Order;
import cmpe.dos.entity.Reward;

import java.util.List;

public interface RewardDao extends HibernateDao<Reward>{

	public Reward getValidCoupon(String couponId);
}
