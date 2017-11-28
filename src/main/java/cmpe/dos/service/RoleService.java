package cmpe.dos.service;

import cmpe.dos.dto.RoleDto;

public interface RoleService {

    public RoleDto getRoleDto(String username);
    
    public String[] getRoles(String username);
}
