package cmpe.dos.service.impl;

import static cmpe.dos.exception.ErrorCode.ERR_ENCRYPTION;
import static cmpe.dos.exception.ErrorCode.ERR_KEYGEN_BY_SECRET;
import static cmpe.dos.exception.ErrorCode.ERR_FILE_NOT_FOUND;

import java.security.Key;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

import com.google.common.io.ByteStreams;

import cmpe.dos.exception.AppException;
import cmpe.dos.mapper.Cryptor;
import cmpe.dos.service.CryptoService;

@Service
public class CryptoServiceImpl implements CryptoService {

    @Value("${dos.encoded-key}")
    String encodedKeyFileName;

    @Override
    public byte[] encrypt(String value) throws AppException {
	Key key = getKeyBySecret();
	if (key != null) {
	    try {
		return Cryptor.encrypt("DES", key, value);
	    } catch (Exception e) {
		throw new AppException(ERR_ENCRYPTION, e);
	    }
	}
	return null;
    }

    @Override
    public String decrypt(byte[] data) {
	// TODO Auto-generated method stub
	return null;
    }
    
    @Override
    public Key getKeyBySecret() throws AppException{
	ClassPathResource resource = new ClassPathResource(encodedKeyFileName);
	if (resource.exists()) {
	    try {
		byte[] secret = ByteStreams.toByteArray(resource.getInputStream());
		return Cryptor.newKeyBySecretKeySpec(secret, "DES");
	    } catch (Exception e) {
		throw new AppException(ERR_KEYGEN_BY_SECRET, e);
	    }
	} else {
	    throw new AppException(ERR_FILE_NOT_FOUND, "Encoded key file not found");
	}
    }
}
