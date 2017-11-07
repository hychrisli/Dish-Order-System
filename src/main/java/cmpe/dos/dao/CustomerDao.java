package cmpe.dos.dao;

import cmpe.dos.entity.Customer;

public interface CustomerDao {
    
    public Customer findCustomer(String username);

}
