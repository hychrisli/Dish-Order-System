package cmpe.dos.controller;

import static cmpe.dos.constant.JsonConstant.KEY_ERROR;
import static cmpe.dos.constant.JsonConstant.KEY_LOCATION;
import static cmpe.dos.constant.JsonConstant.KEY_MESSAGE;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import cmpe.dos.response.JsonResponse;
import cmpe.dos.response.JsonResponseHandler;

public abstract class AbstractController extends JsonResponseHandler{ 

	@Value("${server.address}")
	private String serverAddress;
	
	@Value("${server.port}")
	private String serverPort;
    
	protected <T> ResponseEntity<JsonResponse> success(String key, T data){
		return genericResponse(new JsonResponse(key, data), HttpStatus.OK);
	}
	
	protected ResponseEntity<JsonResponse> notFound(){
		return genericResponse(new JsonResponse(KEY_ERROR, HttpStatus.NOT_FOUND.name()), HttpStatus.NOT_FOUND);
	}
	
	protected ResponseEntity<JsonResponse> created(String loc){
		String url = "http://" + serverAddress + ":" + serverPort + loc;
		HttpHeaders headers = new HttpHeaders();
		headers.add(KEY_LOCATION, url);
		JsonResponse jsonResponse = new JsonResponse(KEY_MESSAGE, HttpStatus.CREATED.name());
		jsonResponse.addPair(KEY_LOCATION, url);
		return responseWithCustHeaders(jsonResponse, headers, HttpStatus.CREATED);
	}
	
	protected ResponseEntity<JsonResponse> conflict(){
		return genericResponse(new JsonResponse(KEY_ERROR, HttpStatus.CONFLICT.name()), HttpStatus.CONFLICT);
	}
}
