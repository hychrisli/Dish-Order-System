package cmpe.dos.dao.impl;

import org.springframework.stereotype.Repository;

import cmpe.dos.dao.AbstractHibernateDao;
import cmpe.dos.entity.Reward;

@Repository
public class RewardDaoImpl extends AbstractHibernateDao<Reward> {

	public RewardDaoImpl() {
		super(Reward.class);
		// TODO Auto-generated constructor stub
	}

}
