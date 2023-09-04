package com.titv.spring.session07_5.exception;

import com.titv.spring.session07_5.entity.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    /*______________ Chuyển hết lỗi từ các Controller
    khác vào Global Exception trước  _________________*/

    @ExceptionHandler // this method catch StudentException
    public ResponseEntity<ErrorResponse> catchError(StudentException ex){
        ErrorResponse er = new ErrorResponse(HttpStatus.NOT_FOUND.value(), ex.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(er);
    }

    @ExceptionHandler   // This method catch all Exception ==> Not really recommended!
    public ResponseEntity<ErrorResponse> catchError1(Exception ex){
        ErrorResponse er = new ErrorResponse(HttpStatus.BAD_REQUEST.value(), ex.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(er);
    }
}
