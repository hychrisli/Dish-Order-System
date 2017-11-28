package cmpe.dos.service.impl;

import static cmpe.dos.config.security.UserRole.ROLE_USER;
import static cmpe.dos.config.security.UserRole.ROLE_ADMIN;
import static cmpe.dos.config.security.UserRole.ROLE_CUSTOMER;
import static cmpe.dos.config.security.UserRole.ROLE_WORKER;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cmpe.dos.dao.HibernateDao;
import cmpe.dos.dto.RoleDto;
import cmpe.dos.entity.Administrator;
import cmpe.dos.entity.Customer;
import cmpe.dos.entity.Worker;
import cmpe.dos.mapper.RoleMapper;
import cmpe.dos.service.RoleService;

@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    HibernateDao<Administrator> adminDao;
    
    @Autowired
    HibernateDao<Customer> customerDao;
    
    @Autowired
    HibernateDao<Worker> workerDao;


    @Override
    public RoleDto getRoleDto(String username) {
	return RoleMapper.toDto(
		adminDao.getById(username), 
		customerDao.getById(username), 
		workerDao.getById(username));
    }

    @Override
    public String[] getRoles(String username) {
	RoleDto roleDto = getRoleDto(username);
	List<String> roleList = new ArrayList<String>();
	
	roleList.add(ROLE_USER);
	if (roleDto.isAdmin()) roleList.add(ROLE_ADMIN);
	if (roleDto.isCustomer()) roleList.add(ROLE_CUSTOMER);
	if (roleDto.isWorker()) roleList.add(ROLE_WORKER);
	String[] roles = new String[roleList.size()];
	return roleList.toArray(roles);
    }

}
