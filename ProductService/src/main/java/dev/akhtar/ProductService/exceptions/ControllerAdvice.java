package dev.akhtar.ProductService.exceptions;

import dev.akhtar.ProductService.dtos.ErrorResponseDTo;
import org.hibernate.service.spi.ServiceException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.Instant;

;

@org.springframework.web.bind.annotation.ControllerAdvice
public class ControllerAdvice {

    @ExceptionHandler(NoSuchCategoryExistsException.class)
    public ResponseEntity<ErrorResponseDTo> handleCategoryNotExistsException(NoSuchCategoryExistsException noSuchCategoryExistsException){
            ErrorResponseDTo errorResponseDTo = new ErrorResponseDTo();
            errorResponseDTo.setMessage(noSuchCategoryExistsException.getMessage());
            errorResponseDTo.setTimestamp(Instant.now());

        return new ResponseEntity<>(errorResponseDTo, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(ServiceException.class)
    public ResponseEntity<ErrorResponseDTo> handleServiceException(ServiceException serviceException){
        ErrorResponseDTo errorResponseDTo = new ErrorResponseDTo();
        errorResponseDTo.setMessage((serviceException.getMessage()));
        errorResponseDTo.setTimestamp(Instant.now());

        return ResponseEntity.badRequest().body(errorResponseDTo);
    }





}
