package br.com.resilia.smartclasses.resources.exceptions;

import br.com.resilia.smartclasses.domain.dto.ApiExceptionResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ApiExceptionHanlder {

    @ExceptionHandler(ApiException.class)
    public ResponseEntity<ApiExceptionResponse> getError(ApiException apiException) {
        var apiResponseError = new ApiExceptionResponse(apiException);
        return ResponseEntity.status(apiException.getStatus()).body(apiResponseError);
    }

}
