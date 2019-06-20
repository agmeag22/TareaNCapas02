package com.uca.capas.service;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import com.uca.capas.domain.User;

public interface UserService {

	public List<User> findAll();
	
	public List<User> findAll(Sort sort);
	
	public List<User> findAll(Pageable page);

	public User findOne(Integer user);
	
	public User save(User c);
	
	public long countAll();
	
	public void delete(User c);

}
