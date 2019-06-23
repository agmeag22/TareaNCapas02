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
	
	@PersistenceContext(unitName="capas")
	private EntityManager entityManager;
	
	public boolean findOneUser(String username, String password) throws DataAccessException {
			StringBuffer sb = new StringBuffer();
			boolean result=false;
			sb.append("select count(*) from public.table_user where username='"+username+"' and pass='"+password+"';");
			Query query = entityManager.createNativeQuery(sb.toString());
			int resultset= ((Number) query.getSingleResult()).intValue();
			if(resultset==1) result=true;
			return result;
	}
	
	
	public List<User> findBySucursal(int code) throws DataAccessException {
			StringBuffer sb = new StringBuffer();
			sb.append("select * from public.table_user where id_store='"+code+"';");
			Query query = entityManager.createNativeQuery(sb.toString());
			List <User> resultset=query.getResultList();
			return resultset;
	}
}
