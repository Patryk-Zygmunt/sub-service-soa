package agh.givealift.subs.controller;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.TransactionSystemException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.naming.AuthenticationException;
import javax.validation.ConstraintViolationException;

@ControllerAdvice
public class ExceptionController {
    
        @ExceptionHandler(AuthenticationException.class)
    public ResponseEntity<String> authExc() {
        return new ResponseEntity<>("Błędny login lub hasło", HttpStatus.UNAUTHORIZED);
    }
    

    
       @ExceptionHandler(org.hibernate.exception.ConstraintViolationException.class)
    public ResponseEntity<String> databaseValidateExc(org.hibernate.exception.ConstraintViolationException e) {
        return new ResponseEntity<>("Niepoprawne atrybuty żądania" + e.getMessage(), HttpStatus.BAD_REQUEST);
    }
    
      @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<String> validateExc(ConstraintViolationException cve) {
            StringBuilder sb =  new StringBuilder();
            cve.getConstraintViolations()
                    .stream().forEach(e->sb.append(e.getMessageTemplate() + System.lineSeparator()));
        return new ResponseEntity<>(sb.toString(), HttpStatus.BAD_REQUEST);
    }
        
     @ExceptionHandler(TransactionSystemException.class)
    public ResponseEntity<String> unpackValidateExc(TransactionSystemException e) {
        if(e.getMostSpecificCause() instanceof ConstraintViolationException)
                return validateExc((ConstraintViolationException)e.getMostSpecificCause());
        return new ResponseEntity<>(e.getMessage() , HttpStatus.INTERNAL_SERVER_ERROR);
    }

    
    
    
    
    
}
