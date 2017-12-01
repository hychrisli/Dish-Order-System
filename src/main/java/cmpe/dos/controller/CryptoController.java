package cmpe.dos.controller;

import static cmpe.dos.constant.UrlConstant.CRYPTO;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import cmpe.dos.exception.AppException;
import cmpe.dos.response.JsonResponse;
import cmpe.dos.service.CryptoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.SwaggerDefinition;
import io.swagger.annotations.Tag;

@RestController
@Api(tags = {"Cryto"})
@SwaggerDefinition(tags = { @Tag(name="Cryto Controller", description="Crypto Controller Endpoints")})
@Transactional(rollbackFor = Exception.class)
public class CryptoController extends AbstractController {

    @Autowired
    CryptoService cryptoSvc;
    
    @ApiOperation(value = "Encrypt")
    @GetMapping(CRYPTO + "/{val}")
    public ResponseEntity<JsonResponse> encrytDecrypt(@PathVariable String val) throws AppException{
	byte[] key = cryptoSvc.encrypt(val);
	String decryVal = cryptoSvc.decrypt(key);
	
	return success("val", new String[]{decryVal, Arrays.toString(key)});
    }
    
    
}
