package com.br.paulo.os.resources.execptions;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
@Getter
public class ValidationError extends StandardErro{
    private static final long seriaLVersionUID = 1L;

    private List<FieldMessade> erros = new ArrayList<FieldMessade>();
    public ValidationError(Long timestamp, Integer status, String error) {
        super(timestamp, status, error);

    }
    public ValidationError(List<FieldMessade> erros) {
        super();
        this.erros = erros;
    }
    public  void addError(String fieldName, String message){
        this.erros.add(new FieldMessade(fieldName, message));
    }
}
