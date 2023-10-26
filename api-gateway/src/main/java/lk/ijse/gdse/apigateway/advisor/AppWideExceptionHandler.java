package lk.ijse.gdse.apigateway.advisor;

import lk.ijse.gdse.apigateway.util.ResponseUtil;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ExceptionHandler;

import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@CrossOrigin
public class AppWideExceptionHandler {
    @ExceptionHandler(Exception.class)
    public ResponseEntity exceptionHandler(Exception e) {
        e.printStackTrace();
        return new ResponseEntity(new ResponseUtil(500, e.getMessage(), null), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}