package com.br.paulo.os.domain;

import lombok.EqualsAndHashCode;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Entity
@EqualsAndHashCode
public class Cliente extends Pessoa {
    private static final long serialVersionUID = 1L;

    @OneToMany(mappedBy = "cliente")
    private List<Os> listOs = new ArrayList<>();

    public Cliente() {
        super();

    }

    public Cliente(Integer id, String nome, String cpf, String telefone) {
        super(id, nome, cpf, telefone);

    }

    public List<Os> getListOs() {
        return listOs;
    }

    public void setListOs(List<Os> list) {
        this.listOs = list;
    }


}
