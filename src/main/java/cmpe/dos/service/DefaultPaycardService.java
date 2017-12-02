package cmpe.dos.service;

import cmpe.dos.dto.CreditInfoDto;
import cmpe.dos.exception.AppException;

public interface DefaultPaycardService {

	public CreditInfoDto getDefaultPaycardInfo(String username) throws AppException ;
	
	public boolean saveDefaultPaycard(String username, CreditInfoDto creditInfoDto) throws AppException ;
}
