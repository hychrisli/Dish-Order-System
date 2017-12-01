package cmpe.dos.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;

import cmpe.dos.dao.HibernateDao;
import cmpe.dos.dto.UserDto;
import cmpe.dos.entity.User;
import cmpe.dos.mapper.UserMapper;
import cmpe.dos.service.UserService;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    HibernateDao<User> dao;
    
    @Override
    public UserDto retrieveUserDto(String username) {
	return UserMapper.toDto(dao.getById(username));
    }

    @Override
    public Boolean createUser(UserDto userDto) {
	
	if ( dao.getById(userDto.getUsername()) != null)
	    return false;
	userDto.setPassword(BCrypt.hashpw(userDto.getPassword(), BCrypt.gensalt(10)));
	dao.create(UserMapper.toPojo(userDto));
	return true;
    }

    @Override
    public Boolean deleteUser(String username){
	if (dao.getById(username) == null)
	    return false;
	dao.deleteById(username);
	return true;
    }

    @Override
    public List<User> getAllUsers() {
	List<User> users = dao.doQueryList("from USER", false);
	return users;
    }
    
    
    
}
