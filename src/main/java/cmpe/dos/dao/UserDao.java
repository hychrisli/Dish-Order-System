package cmpe.dos.dao;

import cmpe.dos.entity.User;

public interface UserDao {
    
    public User findUser(String username);
    
}
