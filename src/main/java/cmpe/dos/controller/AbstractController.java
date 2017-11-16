package cmpe.dos.controller;

import static cmpe.dos.constant.JsonConstant.KEY_ERROR;
import static cmpe.dos.constant.JsonConstant.KEY_LOCATION;
import static cmpe.dos.constant.JsonConstant.KEY_MESSAGE;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import cmpe.dos.response.JsonResponse;
import cmpe.dos.response.JsonResponseHandler;

@Transactional
public abstract class AbstractController extends JsonResponseHandler {

    protected <T> ResponseEntity<JsonResponse> success(String key, T data) {
	return genericResponse(new JsonResponse(key, data), HttpStatus.OK);
    }

    protected ResponseEntity<JsonResponse> notFound() {
	return genericResponse(new JsonResponse(KEY_ERROR, HttpStatus.NOT_FOUND.name()), HttpStatus.NOT_FOUND);
    }

    protected <T> ResponseEntity<JsonResponse> created(String key, T data) {

	return genericResponse(new JsonResponse(key, data), HttpStatus.CREATED);
    }

    protected ResponseEntity<JsonResponse> conflict() {
	return genericResponse(new JsonResponse(KEY_ERROR, HttpStatus.CONFLICT.name()), HttpStatus.CONFLICT);
    }
}
