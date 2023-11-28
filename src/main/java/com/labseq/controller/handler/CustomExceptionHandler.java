package com.labseq.controller.handler;

import com.labseq.exception.NegativeIndexException;
import com.labseq.domain.model.handler.ApiException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
class CustomExceptionHandler extends ResponseEntityExceptionHandler {
    private static final HttpStatus BAD_REQUEST = HttpStatus.BAD_REQUEST;
    @ExceptionHandler(NegativeIndexException.class)
    public ResponseEntity<ApiException> handleNegativeIndexException(
            NegativeIndexException ex) {
        return ResponseEntity.status(BAD_REQUEST)
                .body(createResponse(ex.getMessage(), BAD_REQUEST.value()));
}

    private ApiException createResponse(String message, int status) {
        return ApiException.newBuilder().message(message).status(status).build();
    }

}