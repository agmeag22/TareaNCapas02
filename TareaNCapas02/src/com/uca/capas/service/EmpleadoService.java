package com.uca.capas.service;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import com.uca.capas.domain.Empleado;

public interface EmpleadoService {

	public List<Empleado> findAll();
	
	public List<Empleado> findAll(Sort sort);
	
	public List<Empleado> findAll(Pageable page);

	public Empleado findOne(Integer user);
	
	public Empleado save(Empleado c);
	
	public long countAll();
	
	public void delete(Empleado c);

}
