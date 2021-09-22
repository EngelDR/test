package com.developer.test.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.developer.test.beans.vo.RoleVO;
import com.developer.test.beans.vo.UserVO;
import com.developer.test.model.entity.Role;
import com.developer.test.model.entity.User;
import com.developer.test.model.repository.RoleRepository;
import com.developer.test.model.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	public UserRepository repository;
	
	@Autowired
	public RoleRepository repositoryRole;
	
	public List<UserVO> getAll(){
		List<User> users = (List<User>) repository.findAll();
		if(users != null) {
			return convertVO(users);
		}
		else {
			return null;
		}
	}
	public List<UserVO> getByName(String name){
		List<User> users = (List<User>) repository.findByNombre(name);
		if(users != null) {
			return convertVO(users);
		}
		else {
			return null;
		}
	}
	public UserVO getById(Long id) {
	    UserVO result = null;
		try {
		    User user = repository.findById(id).get();
    		Role roleAux = user.getRole();
    		RoleVO role = new RoleVO(roleAux.getId(),roleAux.getNombre());
    		result = new UserVO(user.getId(),user.getNombre(),user.getA_Paterno(),user.getA_Materno(),role);
    		return result;
		} catch (Exception e) {
		    return result;
        } 
	}
	public String add(UserVO user) {
		RoleVO roleAux = user.getRole();
		Role role = repositoryRole.findById(roleAux.getId()).get();
		User userAdd = new User();
		userAdd.setNombre(user.getNombre());
		userAdd.setA_Materno(user.getA_Materno());
		userAdd.setA_Paterno(user.getA_Paterno());
		userAdd.setRole(role);
		repository.save(userAdd);
		return "Usuario agregado";
	}
	public String edit(UserVO user,Long id) {
		User userEdit = repository.findById(id).get();
		RoleVO roleAux = user.getRole();
		Role role = repositoryRole.findById(roleAux.getId()).get();
		userEdit.setNombre(user.getNombre());
		userEdit.setA_Materno(user.getA_Materno());
		userEdit.setA_Paterno(user.getA_Paterno());
		userEdit.setRole(role);
		repository.save(userEdit);
		return "Usuario editado";
	}
	public String delete(Long id) {
		repository.deleteById(id);
		return "Usuario eliminado";
	}
	public List<UserVO> convertVO(List<User> users){
		List<UserVO> result = new ArrayList<UserVO>();
		UserVO aux;
		RoleVO auxRole;
		Role entityRole;
		for(User user:users) {
			entityRole = user.getRole();
			auxRole = new RoleVO(entityRole.getId(),entityRole.getNombre());
			aux = new UserVO(user.getId(),user.getNombre(),user.getA_Paterno(),user.getA_Materno(),auxRole);
			result.add(aux);
		}
		return result;
	}
}
