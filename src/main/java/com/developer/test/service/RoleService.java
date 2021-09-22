package com.developer.test.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.developer.test.beans.vo.RoleVO;
import com.developer.test.model.entity.Role;
import com.developer.test.model.repository.RoleRepository;

@Service
public class RoleService {
	
	@Autowired
	public RoleRepository repository;
	
	public List<RoleVO> getAll(){
		List<Role> listRoles = (List<Role>) repository.findAll();
		if(listRoles != null) {
			return convertVO(listRoles);
		}
		else {
			return null;
		}
	}
	
	public RoleVO getById(Long id) {
		Role getRoleId = repository.findById(id).get();
		RoleVO result = new RoleVO(getRoleId.getId(),getRoleId.getNombre());
		return result;
	}
	
	public List<RoleVO> getByNombre(String nombre) {
		List<Role> listRoles = (List<Role>)repository.findByNombre(nombre);
		if(listRoles != null) {
			return convertVO(listRoles);
		}
		else {
			return null;
		}
	}
	
	public String add(RoleVO role) {
		Role addRole = new Role();
		addRole.setNombre(role.getNombre());
		System.out.println(addRole.getNombre());
		repository.save(addRole);
		return "Rol agregado";
	}
	
	public String edit(RoleVO role, long id) {
		Role editRole = repository.findById(id).get();
		editRole.setNombre(role.getNombre());
		repository.save(editRole);
		return "Rol editado";
	}
	
	public String delete(long id) {
		repository.deleteById(id);
		return "Rol eliminado";
	}
	
	public List<RoleVO> convertVO(List<Role> listRoles){
		List<RoleVO> result = new ArrayList<RoleVO>();
		RoleVO roleResult;
		for(Role role : listRoles) {
			roleResult = new RoleVO(role.getId(),role.getNombre());
			result.add(roleResult);
		}
		return result;
	}
}
