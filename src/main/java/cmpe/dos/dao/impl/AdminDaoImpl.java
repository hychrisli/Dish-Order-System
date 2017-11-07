package cmpe.dos.dao.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import cmpe.dos.dao.AdminDao;
import cmpe.dos.entity.Administrator;
import cmpe.dos.entity.User;

@Repository
public class AdminDaoImpl implements AdminDao {

    @PersistenceContext
    private EntityManager entityManager;
    
    @Override
    public Administrator findAdmin(String username) {
	return entityManager.find(Administrator.class, username);
    }

}
