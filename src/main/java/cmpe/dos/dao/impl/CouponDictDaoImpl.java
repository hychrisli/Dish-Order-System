package cmpe.dos.dao.impl;

import org.springframework.stereotype.Repository;

import cmpe.dos.dao.AbstractHibernateDao;
import cmpe.dos.entity.CouponDict;

@Repository
public class CouponDictDaoImpl extends AbstractHibernateDao<CouponDict> {

	public CouponDictDaoImpl() {
		super(CouponDict.class);
	}

}
