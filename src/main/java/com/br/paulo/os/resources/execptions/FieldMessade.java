package com.br.paulo.os.resources.execptions;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class FieldMessade implements Serializable {
    private static final long seriaLVersionUID = 1L;
    private String fildName;
    private String message;

    public FieldMessade() {
        super();

    }
    public FieldMessade(String fildName, String message) {
        super();
        this.fildName = fildName;
        this.message = message;
    }
}
