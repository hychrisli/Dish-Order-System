package cmpe.dos.dao.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import cmpe.dos.dao.UserDao;
import cmpe.dos.entity.User;

@Repository
public class UserDaoImpl implements UserDao {

    @PersistenceContext
    private EntityManager entityManager;
    
    @Override
    public User findUser(String username) {
	return entityManager.find(User.class, username);
    }
    
}
