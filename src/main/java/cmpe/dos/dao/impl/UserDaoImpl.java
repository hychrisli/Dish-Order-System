package cmpe.dos.dao.impl;

import org.springframework.stereotype.Repository;

import cmpe.dos.dao.AbstractHibernateDao;
import cmpe.dos.entity.User;

@Repository
public class UserDaoImpl extends AbstractHibernateDao<User> {
    
    public UserDaoImpl() {
	super(User.class);
    }
}
