package cmpe.dos.dao.impl;

import org.springframework.stereotype.Repository;

import cmpe.dos.dao.AbstractHibernateDao;
import cmpe.dos.entity.Administrator;

@Repository
public class AdminDaoImpl extends AbstractHibernateDao<Administrator> {

    public AdminDaoImpl() {
	super(Administrator.class);
    }
}
