package com.uca.capas.repositories;

import java.util.List;


import org.springframework.dao.DataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.uca.capas.domain.Sucursal;
import com.uca.capas.domain.User;

public interface UserRepository extends JpaRepository<User, Integer>{
	
	
	@Query(nativeQuery=true, value="select count(*) from public.table_user where username= :username and pass= :password")
	public int findOneUser(@Param("username")String username,@Param("password") String password) throws DataAccessException ;


	@Query(nativeQuery=true, value="select * from table_user where id_store=:code")
	public List<User> findBySucursal(@Param("code") int code) throws DataAccessException ;
	
	
}
