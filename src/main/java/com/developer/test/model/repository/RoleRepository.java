package com.developer.test.model.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.developer.test.model.entity.Role;
@Repository
public interface RoleRepository extends CrudRepository<Role,Long> {
	List<Role> findByNombre(String nombre);
}
