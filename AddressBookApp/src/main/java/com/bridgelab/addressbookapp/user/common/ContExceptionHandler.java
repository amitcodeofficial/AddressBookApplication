package com.bridgelab.addressbookapp.user.common;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import com.bridgelab.addressbookapp.user.common.CustomException.*;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;
import java.util.Date;

@ControllerAdvice
public class ContExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(WrongIdException.class)
    public ResponseEntity<CustomError> wrongIdExc(WrongIdException wrongIdException){
        return new ResponseEntity<CustomError>(new CustomError(wrongIdException.getMessage(),HttpStatus.NOT_FOUND,new Date().toString()), HttpStatus.BAD_REQUEST);
    }

}
