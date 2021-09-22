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

import com.developer.test.beans.vo.UserVO;
import com.developer.test.service.UserService;

@RestController
public class UserController {
	
	@Autowired
	private UserService service;
	
	@GetMapping("/test/user")
	public ResponseEntity<List<UserVO>> getAll(){
		return new ResponseEntity<List<UserVO>>(service.getAll(),HttpStatus.OK);
	}
	
	@GetMapping("/test/user/{id}")
	public ResponseEntity<UserVO> getById(@PathVariable Long id){
		return new ResponseEntity<UserVO> (service.getById(id),HttpStatus.OK);
	}
	
	@GetMapping("/test/user/name/{name}")
	public ResponseEntity<List<UserVO>> getByName(@PathVariable String name){
		return new ResponseEntity<List<UserVO>> (service.getByName(name),HttpStatus.OK);
	}
	
	@PostMapping("/test/user")
	public ResponseEntity<String> add(@RequestBody UserVO user){
		return new ResponseEntity<String>(service.add(user),HttpStatus.OK);
	}
	
	@PutMapping("/test/user/{id}")
	public ResponseEntity<String> edit(@PathVariable Long id, @RequestBody UserVO user){
		return new ResponseEntity<String>(service.edit(user, id),HttpStatus.OK);
	}
	
	@DeleteMapping("/test/user/{id}")
	public ResponseEntity<String> delete(@PathVariable Long id){
		return new ResponseEntity<String>(service.delete(id),HttpStatus.OK);
	}
}
