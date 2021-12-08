package com.gabo32.dev4j.users.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.gabo32.dev4j.users.entities.Role;
import com.gabo32.dev4j.users.entities.User;
import com.gabo32.dev4j.users.repositories.RoleRepository;
import com.gabo32.dev4j.users.repositories.UserInRoleRepository;

@Service
public class RoleService {

	@Autowired	
	private RoleRepository repository;
	
	@Autowired
	private UserInRoleRepository inRoleRepository;
	
	public List<User> getUsersByRole(String rolName){
		return inRoleRepository.findUserByRoleName(rolName);
	}
	
	public List<Role> getRoles(){
		return repository.findAll();
	}
	
	public Role createRole(Role role) {
		return repository.save(role);
	}
	
	public Role updateRole(Integer roleId, Role role) {
		Optional<Role> result = repository.findById(roleId);
		if( result.isPresent()) {
			return repository.save(role);
		}else {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, String.format("Role id %d does't exist", roleId));
		}
	}

	public void deleteRole(Integer roleId) {
		Optional<Role> result = repository.findById(roleId);
		if(result.isPresent()) {
			repository.delete(result.get());
		}else {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, String.format("Role id %d does't exist", roleId));
		}
	}
	
}
