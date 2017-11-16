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
import cmpe.dos.dao.UserDao;
import cmpe.dos.dto.UserDto;
import cmpe.dos.entity.User;
import cmpe.dos.service.UserService;
import cmpe.dos.service.impl.UserServiceImpl;

@RunWith(MockitoJUnitRunner.class)
public class UserServiceTest {

    @Mock
    private HibernateDao<User> userDao;
    
    @InjectMocks
    private UserService userService = new UserServiceImpl();
    
    private String username1;
    private String username2;
    private User user1;
    private UserDto userDto1;
    
    
    @Before
    public void init(){
	username1 = "admin1";
	username2 = "cust1";
	
	user1 = new User();
	user1.setUsername(username1);
	
	userDto1 = new UserDto();
	userDto1.setUsername(username1);
	
	Mockito.when(userDao.getById(username1)).thenReturn(user1);
	Mockito.when(userDao.getById(username2)).thenReturn(null);
    }
    
    
    @Test
    public void testFindUser() {
	Assert.assertThat(userService.retrieveUserDto(username1), new ReflectionEquals(userDto1));
	Assert.assertEquals(userService.retrieveUserDto(username2), null);
    }
    
}
