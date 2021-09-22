package com.developer.test.controller;

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
import org.springframework.web.bind.annotation.RestController;

import com.developer.test.beans.vo.RoleVO;
import com.developer.test.service.RoleService;

@RestController
public class RoleController {
	@Autowired
	public RoleService service;
	
	
	@GetMapping("/test/role")
	public ResponseEntity<List<RoleVO>> getAll() {
		return new ResponseEntity<List<RoleVO>>(service.getAll(),HttpStatus.OK);
	}
	
	@GetMapping("/test/role/{id}")
	public ResponseEntity<RoleVO> getById(@PathVariable Long id){
		return new ResponseEntity<RoleVO>(service.getById(id),HttpStatus.OK);
	}
	
	@GetMapping("/test/role/name/{nombre}")
	public ResponseEntity<List<RoleVO>> getByName(@PathVariable String nombre){
		return new ResponseEntity<List<RoleVO>>(service.getByNombre(nombre),HttpStatus.OK);
	}
	
	@PostMapping("/test/role")
	public ResponseEntity<String> add(@RequestBody RoleVO role){
		return new ResponseEntity<String>(service.add(role),HttpStatus.OK);
	}
	
	@PutMapping("/test/role/{id}")
	public ResponseEntity<String> edit(@RequestBody RoleVO role, @PathVariable long id){
		return new ResponseEntity<String>(service.edit(role, id),HttpStatus.OK);
	}
	
	@DeleteMapping("/test/role/{id}")
	public ResponseEntity<String> delete(@PathVariable long id){
		return new ResponseEntity<String>(service.delete(id),HttpStatus.OK);
	}
}
