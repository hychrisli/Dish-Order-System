package cmpe.dos.dao.impl;

import org.springframework.stereotype.Repository;

import cmpe.dos.dao.AbstractHibernateDao;
import cmpe.dos.entity.DefaultPaycard;

@Repository
public class DefaultPaycardDaoImpl extends AbstractHibernateDao<DefaultPaycard> {

	public DefaultPaycardDaoImpl(){
		super(DefaultPaycard.class);
	}
}
