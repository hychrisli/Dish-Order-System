package cmpe.dos.exception;

import static cmpe.dos.exception.ErrorCode.ERR_BAD_REQUEST;
import static cmpe.dos.exception.ErrorCode.ERR_INTERNAL_SERVER_ERROR;
import static cmpe.dos.exception.ErrorCode.ERR_ACCESS_DENIED;
import static cmpe.dos.exception.ErrorCode.ERR_INTEGRITY_VIOLATION;
import static org.slf4j.LoggerFactory.getLogger;

import org.slf4j.Logger;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import cmpe.dos.response.JsonResponse;
import cmpe.dos.response.JsonResponseHandler;

@RestControllerAdvice
public class ControllerExceptionHandler extends JsonResponseHandler {

    private final static Logger LOGGER = getLogger(ControllerExceptionHandler.class);

    @ExceptionHandler(AccessDeniedException.class)
    public ResponseEntity<JsonResponse> handlAccessException(AccessDeniedException e) {
	return failure(ERR_ACCESS_DENIED, e.getMessage());
    }
 
    @ExceptionHandler(AppException.class)
    public ResponseEntity<JsonResponse> handleAppException(AppException appException) {
	LOGGER.error(appException.getErrorCode().name(), appException);
	return failure(appException.getErrorCode(), appException.getMessage());
    }
    
    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<JsonResponse> handleBadRequestException(HttpMessageNotReadableException e) {
	LOGGER.error(ERR_BAD_REQUEST.name(), e);
	return badRequest(e.getMessage());
    }

    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<JsonResponse> handleIntegrityViolationException(DataIntegrityViolationException e) {
	LOGGER.error(ERR_INTEGRITY_VIOLATION.name(), e);
	return failure(ERR_INTEGRITY_VIOLATION, "CANNOT Be Deleted. Data Integrity Violation");
    }

    
    @ExceptionHandler(Exception.class)
    public ResponseEntity<JsonResponse> handleException(Exception e) {
	LOGGER.error(ERR_INTERNAL_SERVER_ERROR.name(), e);
	return failure(ERR_INTERNAL_SERVER_ERROR, e.getMessage());
    }

}
