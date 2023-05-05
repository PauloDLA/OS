package com.br.paulo.os.services;

import com.br.paulo.os.domain.Tecnico;
import com.br.paulo.os.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.br.paulo.os.repositories.TecnicoRepository;

import java.util.List;
import java.util.Optional;

@Service
public class TecnicoService {

	@Autowired
	private TecnicoRepository repository;

	public Tecnico findById(Integer id) {
		Optional<Tecnico> obj = repository.findById(id);
		return obj.orElseThrow(()-> new ObjectNotFoundException("Tecnico " + id + " não encontrado" ));

	}
	public List<Tecnico> findAll() {
		return repository.findAll();
	}
}
