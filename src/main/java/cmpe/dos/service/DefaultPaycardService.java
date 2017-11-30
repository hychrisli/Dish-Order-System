package cmpe.dos.service;

import cmpe.dos.dto.CreditInfoDto;

public interface DefaultPaycardService {

	public CreditInfoDto getDefaultPaycardInfo(String username);
}
