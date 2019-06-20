package com.uca.capas.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.uca.capas.domain.User;
import com.uca.capas.repositories.UserRepository;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	UserRepository userRepository;

	public List<User> findAll() {
		// TODO Auto-generated method stub
		return userRepository.findAll();
	}

	public User findOne(Integer user) {
		// TODO Auto-generated method stub
		return userRepository.findById(user).get();
	}

	@Transactional
	public User save(User c) {
		// TODO Auto-generated method stub
		return userRepository.save(c);
	}

	public long countAll() {
		// TODO Auto-generated method stub
		return userRepository.count();
	}

	public List<User> findAll(Sort sort) {
		// TODO Auto-generated method stub
		return userRepository.findAll(sort);
	}
	
	@Transactional
	public void delete(User c) {
		userRepository.delete(c);
	}

	public List<User> findAll(Pageable page) {
		// TODO Auto-generated method stub
		return userRepository.findAll(page).getContent();
	}
	
	

}
