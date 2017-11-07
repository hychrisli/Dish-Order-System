package cmpe.dos.dao;

import cmpe.dos.entity.Administrator;

public interface AdminDao {
    
    public Administrator findAdmin (String username);
}
