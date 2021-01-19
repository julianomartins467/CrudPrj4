package com.juliano.crudprj4.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.juliano.crudprj4.dto.ClientDTO;
import com.juliano.crudprj4.entities.Client;
import com.juliano.crudprj4.repositories.ClientRepository;
import com.juliano.crudprj4.services.exceptions.DatabaseException;
import com.juliano.crudprj4.services.exceptions.ResourceNotFoundException;

@Service
public class ClientService {

	@Autowired
	private ClientRepository repository;
	
	public Page<ClientDTO> findAllPaged(Pageable pageable) {
		Page<Client> List = repository.findAll(pageable);
		return List.map(e -> new ClientDTO(e));		
	}
	
	public ClientDTO findById(Long id) {
		Optional<Client> obj = repository.findById(id);
		Client entity =  obj.orElseThrow(() -> new ResourceNotFoundException(id));
		return new ClientDTO(entity);
	}
	
	@Transactional
	public ClientDTO insert(ClientDTO dto) {
		Client entity = dto.toEntity();
		entity = repository.save(entity);
		return new ClientDTO(entity);
	}
	
	
	public void delete(Long id) {
		try {
			repository.deleteById(id);
		} catch (EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException(id);
		} catch (DataIntegrityViolationException e) {
			throw new DatabaseException(e.getMessage());
		}
		
	}
	
	
	@Transactional
	public ClientDTO update(Long id, ClientDTO dto) {
		try {
			Client entity = repository.getOne(id);
			updateData(entity, dto);
			entity =  repository.save(entity);
			return new ClientDTO(entity);
		} catch (Exception e) {
			throw new ResourceNotFoundException(id);
		}
		
	}

	private void updateData(Client entity, ClientDTO dto) {
		entity.setName(dto.getName());
		entity.setCpf(dto.getCpf());
		entity.setIncome(dto.getIncome());
		entity.setBirthDate(dto.getBirthDate());
		entity.setChildren(dto.getChildren());
	}
}
