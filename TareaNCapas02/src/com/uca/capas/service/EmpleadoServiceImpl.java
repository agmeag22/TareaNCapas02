package com.uca.capas.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.uca.capas.domain.Empleado;
import com.uca.capas.repositories.EmpleadoRepository;

@Service
public class EmpleadoServiceImpl implements EmpleadoService {
	
	@Autowired
	EmpleadoRepository empleadoRepository;

	public List<Empleado> findAll() {
		// TODO Auto-generated method stub
		return empleadoRepository.findAll();
	}

	public Empleado findOne(Integer user) {
		// TODO Auto-generated method stub
		return empleadoRepository.findById(user).get();
	}

	@Transactional
	public Empleado save(Empleado c) {
		// TODO Auto-generated method stub
		return empleadoRepository.save(c);
	}

	public long countAll() {
		// TODO Auto-generated method stub
		return empleadoRepository.count();
	}

	public List<Empleado> findAll(Sort sort) {
		// TODO Auto-generated method stub
		return empleadoRepository.findAll(sort);
	}
	
	@Transactional
	public void delete(Empleado c) {
		empleadoRepository.delete(c);
	}

	public List<Empleado> findAll(Pageable page) {
		// TODO Auto-generated method stub
		return empleadoRepository.findAll(page).getContent();
	}
	
	

}
