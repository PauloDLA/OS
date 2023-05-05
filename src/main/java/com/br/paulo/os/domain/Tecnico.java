package com.br.paulo.os.domain;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Tecnico extends Pessoa {
	private static final long seriaLVersionUID = 1L;
	
	@OneToMany(mappedBy = "tecnico")
	private List<Os> list_os = new ArrayList<>();


	public Tecnico() {
		super();

	}

	public Tecnico(Integer id, String nome, String cpf, String telefone) {
		super(id, nome, cpf, telefone);

	}

	public static long getSerialversionuid() {
		return seriaLVersionUID;
	}

    public List<Os> getList_os() {
        return list_os;
    }

    public void setList_os(List<Os> list_os) {
        this.list_os = list_os;
    }
}
