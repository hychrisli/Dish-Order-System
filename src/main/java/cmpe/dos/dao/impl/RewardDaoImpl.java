package cmpe.dos.dao.impl;

import java.util.Date;

import org.springframework.stereotype.Repository;

import cmpe.dos.dao.AbstractHibernateDao;
import cmpe.dos.dao.RewardDao;
import cmpe.dos.entity.Reward;

@Repository
public class RewardDaoImpl extends AbstractHibernateDao<Reward> implements RewardDao {

	public RewardDaoImpl() {
		super(Reward.class);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Reward getValidCoupon(String couponId) {
		Date today = new Date();
		String hql = "from Reward "
				+ "where couponId = ? and validStart <= ? and validEnd >= ? order by validEnd";
		return doQueryFirst(hql, couponId, today, today);
	}
}
