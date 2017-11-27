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
	userDto.setStreet(user.getStreet());
	userDto.setCity(user.getCity());
	userDto.setState(user.getState());
	userDto.setZipcode(user.getZipcode());
	userDto.setSignupDate(user.getSignupDate());
	
	return userDto;
    }
    
    public static User toPojo(UserDto userDto){
	User user = new User();
	
	user.setUsername(userDto.getUsername());
	user.setPassword(userDto.getPassword());
	user.setPhone(userDto.getPhone());
	user.setStreet(userDto.getStreet());
	user.setCity(userDto.getCity());
	user.setState(userDto.getState());
	user.setZipcode(userDto.getZipcode());
	user.setSignupDate(userDto.getSignupDate());
	
	return user;
    }
    
}
