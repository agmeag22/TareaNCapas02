package com.uca.capas.repositories;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import com.uca.capas.domain.Empleado;

public interface EmpleadoRepository extends JpaRepository<Empleado, Integer>{

	public List<Empleado> findAll(Sort sort);
	
	//El metodo recibe un objeto de tipo Pageable, sin embargo al ser llamado es un new PageRequest lo que se le envia
	public Page<Empleado> findAll(Pageable page);
}
