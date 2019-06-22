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

	@PersistenceContext(unitName="capas")
	private EntityManager entityManager;
	@Override
	public boolean findEqual(String username, String password) throws DataAccessException {
		// TODO Auto-generated method stub
		boolean result=false;
		try {
			StringBuffer sb = new StringBuffer();
			sb.append("select * from table_user where username='"+username+"';");
			Query query = entityManager.createNativeQuery(sb.toString(),User.class);
			User user=(User) query.getSingleResult();
			if(user.getUsername().equals(username)) {
				if(user.getPassword().equals(password)) {
					result=true;
				}
			}
		}catch(Exception e){
		}
		return result;
}
}
