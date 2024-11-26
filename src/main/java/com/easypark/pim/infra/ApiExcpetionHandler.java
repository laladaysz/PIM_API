package com.easypark.pim.infra;

import com.easypark.pim.exceptions.ExceptionClass;
import com.easypark.pim.exceptions.GenericsNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.ZoneId;
import java.time.ZonedDateTime;

@ControllerAdvice
public class ApiExcpetionHandler {
    @ExceptionHandler(value={GenericsNotFoundException.class})
    public ResponseEntity<Object> handleGenericsNotFoundException(GenericsNotFoundException e){
        HttpStatus badRequest = HttpStatus.BAD_REQUEST;
        ExceptionClass exceptionClass = new ExceptionClass(
                e.getMessage(),
                badRequest,
                ZonedDateTime.now(ZoneId.of("Z"))
        );
        return new ResponseEntity<>(exceptionClass, badRequest);
    }
}
