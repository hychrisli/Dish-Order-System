package cmpe.dos.mapper;

import cmpe.dos.dto.UserDto;
import cmpe.dos.entity.User;

public class UserMapper {

    public static UserDto toDto(User user){
	if (user == null) return null;
	
	UserDto userDto = new UserDto();
	userDto.setUsername(user.getUsername());
	userDto.setPassword(user.getPassword());
	userDto.setPhone(user.getPhone());
	userDto.setAddress(user.getAddress());
	userDto.setSignupDate(user.getSignupDate());
	
	return userDto;
    }
    
    public static User toPojo(UserDto userDto){
	User user = new User();
	
	user.setUsername(userDto.getUsername());
	user.setPassword(userDto.getPassword());
	user.setPhone(userDto.getPhone());
	user.setAddress(userDto.getAddress());
	user.setSignupDate(userDto.getSignupDate());
	
	return user;
    }
    
}
