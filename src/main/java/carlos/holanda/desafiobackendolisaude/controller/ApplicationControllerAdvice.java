package carlos.holanda.desafiobackendolisaude.controller;

import carlos.holanda.desafiobackendolisaude.exception.RecordNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ApplicationControllerAdvice {

    @ExceptionHandler(RecordNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String RecordNotFoundHandler(RecordNotFoundException exception) {
        return exception.getMessage();
    }
}
