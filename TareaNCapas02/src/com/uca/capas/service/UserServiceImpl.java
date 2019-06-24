package com.uca.capas.service;

import java.util.List;

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
}
