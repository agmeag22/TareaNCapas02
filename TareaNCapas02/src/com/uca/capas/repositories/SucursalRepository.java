package com.uca.capas.repositories;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import com.uca.capas.domain.Sucursal;

public interface SucursalRepository extends JpaRepository<Sucursal, Integer>{

	public List<Sucursal> findAll(Sort sort);
	
	//El metodo recibe un objeto de tipo Pageable, sin embargo al ser llamado es un new PageRequest lo que se le envia
	public Page<Sucursal> findAll(Pageable page);
}
