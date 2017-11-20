package cmp226.dos.service;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.internal.matchers.apachecommons.ReflectionEquals;
import org.mockito.runners.MockitoJUnitRunner;

import cmpe.dos.dao.HibernateDao;
import cmpe.dos.dto.UserDto;
import cmpe.dos.entity.User;
import cmpe.dos.mapper.UserMapper;
import cmpe.dos.service.UserService;
import cmpe.dos.service.impl.UserServiceImpl;

@RunWith(MockitoJUnitRunner.class)
public class UserServiceTest {

    @Mock
    private HibernateDao<User> dao;
    
    @InjectMocks
    private UserService userService = new UserServiceImpl();
    
    private String username1, username2;
    private User user1, user2;
    private UserDto userDto1, userDto2;
    
    
    @Before
    public void init(){
	username1 = "admin1";
	username2 = "cust1";
	
	user1 = new User();
	user1.setUsername(username1);
	
	user2 = new User();
	user2.setUsername(username2);
	
	userDto1 = UserMapper.toDto(user1);
	userDto2 = UserMapper.toDto(user2);
	
	Mockito.when(dao.getById(username1)).thenReturn(user1);
	Mockito.when(dao.getById(username2)).thenReturn(null);
    }
    
    
    @Test
    public void testFindUser() {
	Assert.assertThat(userService.retrieveUserDto(username1), new ReflectionEquals(userDto1));
	Assert.assertEquals(userService.retrieveUserDto(username2), null);
    }
    
    @Test 
    public void testCreateUser() {
	Assert.assertEquals(userService.createUser(userDto1), false);
	Assert.assertEquals(userService.createUser(userDto2), true);
    }
    
    @Test 
    public void testDeleteUser() {
	Assert.assertEquals(userService.deleteUser(username1), true);
	Assert.assertEquals(userService.deleteUser(username2), false);
    }

}
