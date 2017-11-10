package cmpe.dos.mapper;

import cmpe.dos.dto.RoleDto;
import cmpe.dos.entity.Administrator;
import cmpe.dos.entity.Customer;
import cmpe.dos.entity.Worker;

public class RoleMapper {

    public static RoleDto toDto(Administrator admin, Customer customer, Worker worker) {
	
	RoleDto roleDto = new RoleDto();
	
	roleDto.setAdmin(admin == null ? false: true);
	roleDto.setCustomer(customer == null ? false : true);
	roleDto.setWorker(worker == null ? false : true);
	
	return roleDto;
    }
    
}
