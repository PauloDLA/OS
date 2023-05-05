package com.br.paulo.os.services;

import com.br.paulo.os.domain.Tecnico;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.br.paulo.os.repositories.TecnicoRepository;

import java.util.Optional;

@Service
public class TecnicoService {

	@Autowired
	private TecnicoRepository repository;

	public Tecnico findById(Integer id) {
		Optional<Tecnico> obj = repository.findById(id);

		return obj.orElse(null);

	}
}
