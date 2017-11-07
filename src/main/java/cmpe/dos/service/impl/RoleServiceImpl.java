package cmpe.dos.service.impl;

import static cmpe.dos.config.security.UserRole.ROLE_USER;
import static cmpe.dos.config.security.UserRole.ROLE_ADMIN;
import static cmpe.dos.config.security.UserRole.ROLE_CUSTOMER;
import static cmpe.dos.config.security.UserRole.ROLE_WORKER;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cmpe.dos.dao.AdminDao;
import cmpe.dos.dao.CustomerDao;
import cmpe.dos.dao.WorkerDao;
import cmpe.dos.dto.RoleDto;
import cmpe.dos.mapper.RoleMapper;
import cmpe.dos.service.RoleService;

@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    AdminDao adminDao;
    
    @Autowired
    CustomerDao customerDao;
    
    @Autowired
    WorkerDao workerDao;


    @Override
    public RoleDto getRoleDto(String username) {
	return RoleMapper.toDto(
		adminDao.findAdmin(username), 
		customerDao.findCustomer(username), null);
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
