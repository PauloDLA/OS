package com.br.paulo.os.dtos;

import com.br.paulo.os.domain.Tecnico;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.br.CPF;

import java.io.Serializable;

@Getter
@Setter
public class TecnicoDTO implements Serializable {
    private static final long seriaLVersionUID = 1L;
    private Integer id;
    private String nome;
    @CPF
    private String cpf;
    private String telefone;

    public TecnicoDTO(){
        super();
    }
    public TecnicoDTO(Tecnico obj) {
        this.id = obj.getId();
        this.nome = obj.getNome();
        this.cpf = obj.getCpf();
        this.telefone = obj.getTelefone();
    }
}
