package com.br.paulo.os.dtos;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.br.CPF;
@Getter
@Setter
public class TecnicoDTO {

    private Integer id;
    private String nome;
    @CPF
    private String cpf;
    private String telefone;

//    public TecnicoDTO(Integer id, String nome, String cpf, String telefone) {
//        this.id = id;
//        this.nome = nome;
//        this.cpf = cpf;
//        this.telefone = telefone;
//    }
}
