package cmpe.dos.service;

import cmpe.dos.dto.UserDto;

public interface UserService {
    
    public UserDto retrieveUserDto(String username);
}
