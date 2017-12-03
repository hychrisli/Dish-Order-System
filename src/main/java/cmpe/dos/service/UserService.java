package cmpe.dos.service;

import java.util.List;

import cmpe.dos.dto.UserDto;
import cmpe.dos.dto.WorkerDto;
import cmpe.dos.entity.User;
import cmpe.dos.entity.Worker;

public interface UserService {
    
    public UserDto retrieveUserDto(String username);
    
    public Boolean createUser(UserDto userDto);
    
    public Boolean deleteUser(String username);
    
    public Worker createWorker(WorkerDto workerDto);
    
    public List<User> getAllUsers();
}
