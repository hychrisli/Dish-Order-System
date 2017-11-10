package cmpe.dos.dao.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import cmpe.dos.dao.CustomerDao;
import cmpe.dos.entity.Customer;
import cmpe.dos.entity.User;

@Repository
public class CustomerDaoImpl implements CustomerDao {

    @PersistenceContext
    private EntityManager entityManager;
    
    @Override
    public Customer findCustomer(String username) {
	return entityManager.find(Customer.class, username);
    }

}
