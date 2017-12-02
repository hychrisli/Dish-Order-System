package cmpe.dos.service.impl;

import static cmpe.dos.exception.ErrorCode.ERR_UNSUPPORTED_ENCODE;

import java.io.UnsupportedEncodingException;

import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cmpe.dos.dao.HibernateDao;
import cmpe.dos.dto.CreditInfoDto;
import cmpe.dos.entity.DefaultPaycard;
import cmpe.dos.exception.AppException;
import cmpe.dos.service.CryptoService;
import cmpe.dos.service.DefaultPaycardService;

@Service
public class DefaultPaycardServiceImpl implements DefaultPaycardService {

	@Autowired
	HibernateDao<DefaultPaycard> dao;
	
	@Autowired
	CryptoService cryptoSvc;
	
	@Override
	public CreditInfoDto getDefaultPaycardInfo(String username) throws AppException {
		
		DefaultPaycard dp = dao.getById(username);
		CreditInfoDto ciDto = new CreditInfoDto();
		ciDto.setCardholderName(dp.getCardholderName());
		ciDto.setCardNum(cryptoSvc.decrypt(Base64.decodeBase64(dp.getCardNum())));
		ciDto.setCardType(dp.getCardType());
		ciDto.setDate(dp.getDate());
		return ciDto;
	}

	@Override
	public boolean saveDefaultPaycard(String username, CreditInfoDto creditInfoDto) throws AppException {
	    
	    DefaultPaycard defaultPayCard = new DefaultPaycard();
	    defaultPayCard.setCardholderName(creditInfoDto.getCardholderName());
	    defaultPayCard.setCardType(creditInfoDto.getCardType());
	    defaultPayCard.setDate(creditInfoDto.getDate());
	    defaultPayCard.setUsername(username);
	    defaultPayCard.setCardNum(Base64.encodeBase64String(cryptoSvc.encrypt(creditInfoDto.getCardNum())));
	    dao.save(defaultPayCard);
	    return true;
	}

}
