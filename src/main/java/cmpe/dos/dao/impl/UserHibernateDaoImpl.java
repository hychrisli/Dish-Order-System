package cmpe.dos.dao.impl;

import org.springframework.stereotype.Repository;

import cmpe.dos.entity.User;

@Repository
public class UserHibernateDaoImpl extends HibernateDaoImpl<User> {
    
    public UserHibernateDaoImpl() {
	super(User.class);
    }
}
