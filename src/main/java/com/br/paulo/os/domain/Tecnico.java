package com.br.paulo.os.domain;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;
@Entity
public class Tecnico extends Pessoa {
	private static final long seriaLVersionUID = 1L;
	
	@OneToMany(mappedBy = "tecnico")
	private List<Os> list = new ArrayList<>();


	public Tecnico() {
		super();

	}

	public Tecnico(Integer id, String nome, String cpf, String telefone) {
		super(id, nome, cpf, telefone);

	}

	public List<Os> getList() {
		return list;
	}

	public void setList(List<Os> list) {
		this.list = list;
	}

	public static long getSerialversionuid() {
		return seriaLVersionUID;
	}

}
