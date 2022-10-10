package com.example.ClientCRUD.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.ClientCRUD.dto.UserDTO;
import com.example.ClientCRUD.entities.User;
import com.example.ClientCRUD.repositories.UserRepository;
import com.example.ClientCRUD.services.exceptions.ResourceNotFoundException;


@Service
public class UserService {

	@Autowired
	private UserRepository repository;
	
	@Transactional(readOnly = true)
	public List<UserDTO> findAll(){
		List<User> list = repository.findAll();
		return list.stream().map(user -> new UserDTO(user)).toList();
	}
	
	@Transactional(readOnly = true)
	public UserDTO findById(Long id) {
		Optional<User> obj = repository.findById(id);
		User entity = obj.orElseThrow(() -> new ResourceNotFoundException("User not found!"));
		return new UserDTO(entity);
	}
	
	@Transactional
	public UserDTO insertUser(UserDTO userDto) {
		User entity = new User();
		entity.setId(userDto.getId());
		entity.setName(userDto.getName());
		entity.setCpf(userDto.getCpf());
		entity.setIncome(userDto.getIncome());
		entity.setChildren(userDto.getChildren());
		entity = repository.save(entity);
		return new UserDTO(entity);
	}
}
