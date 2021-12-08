package com.gabo32.dev4j.users.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gabo32.dev4j.users.entities.Role;
import com.gabo32.dev4j.users.entities.User;
import com.gabo32.dev4j.users.services.RoleService;

@RestController
@RequestMapping("/roles")
public class RoleController {

	@Autowired
	private RoleService service;
	
	@GetMapping
	public ResponseEntity<List<Role>> getRoles(){
		return new ResponseEntity<>(service.getRoles(), HttpStatus.OK);
	}
	
	@GetMapping("/{rolName}/users")
	public ResponseEntity<List<User>> getUsersByRole(@PathVariable(name="rolName") String rolName){
		return new ResponseEntity<>(service.getUsersByRole(rolName), HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<Role> createRoles(@RequestBody Role role){
		return new ResponseEntity<>(service.createRole(role), HttpStatus.CREATED);
	}
	
	@PutMapping("/{roleId}")
	public ResponseEntity<Role> updateRoles(@PathVariable(name="roleId") Integer roleId, @RequestBody Role role ){
		return new ResponseEntity<>(service.updateRole(roleId, role), HttpStatus.OK);
	}
	
	@DeleteMapping("/{roleId}")
	public ResponseEntity<Void> deleteRole(@PathVariable(name="roleId") Integer roleId){
		service.deleteRole(roleId);
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}
}
