package com.br.paulo.os.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Tecnico extends Pessoa implements Serializable {
	private static final long seriaLVersionUID = 1L;
	@JsonIgnore
	@OneToMany(mappedBy = "tecnico")
	private List<Os> listOs = new ArrayList<>();

	public Tecnico() {
		super();
	}

	public Tecnico(Integer id, String nome, String cpf, String telefone) {
		super(id, nome, cpf, telefone);
	}

	public static long getSerialversionuid() {
		return seriaLVersionUID;
	}

	public List<Os> getListOs() {
		return listOs;
	}

	public void setListOs(List<Os> listOs) {
		this.listOs = listOs;
	}
}

