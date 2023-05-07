package com.br.paulo.os.resources.execptions;

import java.io.Serializable;

public class DataIntegratyViolationException extends  RuntimeException implements Serializable {
    private static final long seriaLVersionUID = 1L;

    public DataIntegratyViolationException(String message , Throwable cause) {
        super(message, cause);
    }

    public DataIntegratyViolationException(String message){
        super(message);
    }
}
