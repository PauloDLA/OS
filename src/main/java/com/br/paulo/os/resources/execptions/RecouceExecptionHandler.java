package com.br.paulo.os.resources.execptions;

import com.br.paulo.os.exceptions.ObjectNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class RecouceExecptionHandler {

    @ExceptionHandler(ObjectNotFoundException.class)
    public ResponseEntity<StandardErro> objectNotFoundException(ObjectNotFoundException e){
        StandardErro erro =  new StandardErro(System.currentTimeMillis(),
                HttpStatus.NOT_FOUND.value(),e.getMessage());

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(erro);
    }
    @ExceptionHandler(DataIntegratyViolationException.class)
    public ResponseEntity<StandardErro> objectNotFoundException(DataIntegratyViolationException e){
        StandardErro erro =  new StandardErro(System.currentTimeMillis(),
                HttpStatus.BAD_REQUEST.value(), e.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(erro);
    }
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<StandardErro> objectNotFoundException(MethodArgumentNotValidException e){
       ValidationError error = new ValidationError(System.currentTimeMillis(),
               HttpStatus.BAD_REQUEST.value(),"Erro na validação dos campos!");
        for (FieldError x : e.getBindingResult().getFieldErrors()) {
            error.addError(x.getField(), x.getDefaultMessage());
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);

    }


}
