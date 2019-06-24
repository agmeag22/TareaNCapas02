package com.uca.capas.service;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.uca.capas.domain.Empleado;
import com.uca.capas.domain.Sucursal;
import com.uca.capas.domain.User;
import com.uca.capas.repositories.UserRepository;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	UserRepository userRepository;
	
	
	public boolean findOneUser(String username, String password) throws DataAccessException {
			boolean result=false;
			if(userRepository.findOneUser(username, password)==1) result=true;
			return result;
	}
	
	
	public List<User> findBySucursal(int code) throws DataAccessException {
			return userRepository.findBySucursal(code);
	}


	public User findOne(Integer sucursal) {
		// TODO Auto-generated method stub
		return userRepository.findById(sucursal).get();
	}

	
	public void deleteUser(User user) {
		userRepository.delete(user);
		
	}


	@Override
	public void delete(User user) {
		userRepository.delete(user);
		
	}


	@Override
	public void save(User user) {
		userRepository.save(user);
		
	}


	
	
}
