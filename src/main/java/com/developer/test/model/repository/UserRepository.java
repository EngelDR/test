package com.developer.test.model.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.developer.test.model.entity.User;

@Transactional(readOnly = true)
@Repository
public interface UserRepository extends CrudRepository<User,Long> {
	List<User> findByNombre(String nombre);
}
