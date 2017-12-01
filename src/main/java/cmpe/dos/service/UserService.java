package cmpe.dos.service;

import java.util.List;

import cmpe.dos.dto.UserDto;
import cmpe.dos.entity.User;

public interface UserService {
    
    public UserDto retrieveUserDto(String username);
    
    public Boolean createUser(UserDto userDto);
    
    public Boolean deleteUser(String username);
    
    public List<User> getAllUsers();
}
