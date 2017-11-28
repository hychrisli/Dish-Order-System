package cmpe.dos.dao.impl;

import org.springframework.stereotype.Repository;

import cmpe.dos.dao.AbstractHibernateDao;
import cmpe.dos.entity.Customer;

@Repository
public class CustomerDaoImpl extends AbstractHibernateDao<Customer> {

    public CustomerDaoImpl() {
	super(Customer.class);
    }
}
