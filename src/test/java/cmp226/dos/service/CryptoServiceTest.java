package cmp226.dos.service;

import java.security.Key;
import java.util.Arrays;
import java.util.logging.Logger;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.PropertySource;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import cmp226.dos.TestContextConfiguration;
import cmpe.dos.exception.AppException;
import cmpe.dos.service.CryptoService;
import cmpe.dos.service.impl.CryptoServiceImpl;

@RunWith(JUnit4.class)
@ContextConfiguration(classes = {CryptoService.class, CryptoServiceImpl.class})
public class CryptoServiceTest {

    protected static Logger LOGGER = Logger.getLogger(CryptoServiceTest.class.getName());
    
    @Value("${spring.datasource.password}")
    String password;
    
    CryptoService cryptoSvc = new CryptoServiceImpl();
    
    @Test
    public void test1() throws AppException{
	Key key = cryptoSvc.getKeyBySecret();
	byte[] keyByte = key.getEncoded();
	LOGGER.info(password);
	LOGGER.info(Arrays.toString(keyByte));
    }
    
}
