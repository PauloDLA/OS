package com.br.paulo.os.services;

import com.br.paulo.os.domain.Pessoa;
import com.br.paulo.os.domain.Tecnico;
import com.br.paulo.os.dtos.TecnicoDTO;
import com.br.paulo.os.exceptions.ObjectNotFoundException;
import com.br.paulo.os.repositories.PessoaRepository;
import com.br.paulo.os.resources.execptions.DataIntegratyViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.br.paulo.os.repositories.TecnicoRepository;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Service
public class TecnicoService {
	@Autowired
	private TecnicoRepository repository;
	@Autowired
	private PessoaRepository pessoaRepository;
	public Tecnico findById(Integer id) {
		Optional<Tecnico> obj = repository.findById(id);
		return obj.orElseThrow(()-> new ObjectNotFoundException("Tecnico " + id + " não encontrado" ));

	}
	public List<Tecnico> findAll() {
		return repository.findAll();
	}

	public Tecnico create(TecnicoDTO objDTO){
		if(findBycpf(objDTO) != null){
			throw new DataIntegratyViolationException("CPF já cadastrado na base de dados");
		}
		return repository.save(new Tecnico(null,objDTO.getNome(),objDTO.getCpf(),objDTO.getTelefone()));
	}

	public Tecnico update(Integer id, @Valid TecnicoDTO objDTO) {
		Tecnico oldObj = findById(id);
		if (findBycpf(objDTO) != null && findBycpf(objDTO).getId() != id){
			throw new DataIntegratyViolationException("CPF já cadastrado na base de dados");
		}
		oldObj.setNome(objDTO.getNome());
		oldObj.setCpf(objDTO.getCpf());
		oldObj.setTelefone(objDTO.getTelefone());
		return repository.save(oldObj);
	}

	public void delete(Integer id) {
		Tecnico obj =findById(id);
		if(obj.getListOs().size() > 0){
			throw  new DataIntegratyViolationException("Tecnico com Ordens ativas, não pode ser deletado");
		}
		repository.deleteById(id);
	}
	private Pessoa findBycpf(TecnicoDTO objDTO){

		Pessoa obj = pessoaRepository.findByCPF(objDTO.getCpf());
		if(obj != null){
			return obj;
		}
		return null;
	}

}
