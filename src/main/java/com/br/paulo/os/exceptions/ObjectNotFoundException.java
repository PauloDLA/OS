package com.br.paulo.os.exceptions;

import java.io.Serializable;

public class ObjectNotFoundException extends  RuntimeException implements Serializable {
    private static final long seriaLVersionUID = 1L;

    public ObjectNotFoundException(String message) {
        super(message);
    }

    public ObjectNotFoundException(Throwable cause) {
        super(cause);
    }
}
