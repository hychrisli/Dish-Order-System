package cmpe.dos.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cmpe.dos.dao.HibernateDao;
import cmpe.dos.dto.CreditInfoDto;
import cmpe.dos.entity.DefaultPaycard;
import cmpe.dos.service.DefaultPaycardService;

@Service
public class DefaultPaycardServiceImpl implements DefaultPaycardService {

	@Autowired
	HibernateDao<DefaultPaycard> dao;
	
	@Override
	public CreditInfoDto getDefaultPaycardInfo(String username) {
		
		DefaultPaycard dp = dao.getById(username);
		CreditInfoDto ciDto = new CreditInfoDto();
		ciDto.setCardholderName(dp.getCardholderName());
		ciDto.setCardNum(dp.getCardNum());
		ciDto.setCardType(dp.getCardType());
		ciDto.setDate(dp.getDate());
		return ciDto;
	}

}
