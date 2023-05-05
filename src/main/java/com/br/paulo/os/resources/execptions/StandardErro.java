package com.br.paulo.os.resources.execptions;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class StandardErro implements Serializable {
    private static final long seriaLVersionUID = 1L;
    private Long timestamp;
    private  Integer status;
    private String error;

    public StandardErro(){
        super();
    }
    public StandardErro(Long timestamp, Integer status, String error) {
        this.timestamp = timestamp;
        this.status = status;
        this.error = error;
    }
}
