package com.br.paulo.os.services;

import com.br.paulo.os.domain.Cliente;
import com.br.paulo.os.domain.Pessoa;
import com.br.paulo.os.dtos.ClienteDTO;
import com.br.paulo.os.exceptions.ObjectNotFoundException;
import com.br.paulo.os.repositories.ClienteRepository;
import com.br.paulo.os.repositories.PessoaRepository;
import com.br.paulo.os.resources.execptions.DataIntegratyViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {
	@Autowired
	private ClienteRepository repository;
	@Autowired
	private PessoaRepository pessoaRepository;
	public Cliente findById(Integer id) {
		Optional<Cliente> obj = repository.findById(id);
		return obj.orElseThrow(()-> new ObjectNotFoundException("Cliente " + id + " não encontrado" ));

	}
	public List<Cliente> findAll() {
		return repository.findAll();
	}

	public Cliente create(ClienteDTO objDTO){
		if(findBycpf(objDTO) != null){
			throw new DataIntegratyViolationException("CPF já cadastrado na base de dados");
		}
		return repository.save(new Cliente(null,objDTO.getNome(),objDTO.getCpf(),objDTO.getTelefone()));
	}

	public Cliente update(Integer id, @Valid ClienteDTO objDTO) {
		Cliente oldObj = findById(id);
		if (findBycpf(objDTO) != null && findBycpf(objDTO).getId() != id){
			throw new DataIntegratyViolationException("CPF já cadastrado na base de dados");
		}
		oldObj.setNome(objDTO.getNome());
		oldObj.setCpf(objDTO.getCpf());
		oldObj.setTelefone(objDTO.getTelefone());
		return repository.save(oldObj);
	}

	public void delete(Integer id) {
		Cliente obj =findById(id);
		if(obj.getListOs().size() > 0){
			throw  new DataIntegratyViolationException("Cliente com Ordens ativas, não pode ser deletado");
		}
		repository.deleteById(id);
	}
	private Pessoa findBycpf(ClienteDTO objDTO){

		Pessoa obj = pessoaRepository.findByCPF(objDTO.getCpf());
		if(obj != null){
			return obj;
		}
		return null;
	}

}
