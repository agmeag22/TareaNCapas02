package com.uca.capas.repositories;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import com.uca.capas.domain.User;

public interface UserRepository extends JpaRepository<User, Integer>{
	
}
